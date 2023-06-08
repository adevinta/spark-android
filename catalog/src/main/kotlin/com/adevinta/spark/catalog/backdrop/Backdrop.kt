/*
 * Copyright (c) 2023 Adevinta
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.adevinta.spark.catalog.backdrop

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.collapse
import androidx.compose.ui.semantics.expand
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import androidx.compose.ui.zIndex
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.backdrop.BackdropValue.Concealed
import com.adevinta.spark.catalog.backdrop.BackdropValue.Revealed
import com.adevinta.spark.components.bottomsheet.PreUpPostDownNestedScrollConnection
import com.adevinta.spark.components.bottomsheet.SwipeableDefaults
import com.adevinta.spark.components.bottomsheet.SwipeableState
import com.adevinta.spark.components.bottomsheet.swipeable
import com.adevinta.spark.components.snackbars.SnackbarHost
import com.adevinta.spark.components.snackbars.SnackbarHostState
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.tokens.contentColorFor
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

// TODO-scott.rayapoulle.ext (23-15-2023): Remove once M3 has this implementation available
/**
 * Possible values of [BackdropScaffoldState].
 */
public enum class BackdropValue {
    /**
     * Indicates the back layer is concealed and the front layer is active.
     */
    Concealed,

    /**
     * Indicates the back layer is revealed and the front layer is inactive.
     */
    Revealed
}

/**
 * State of the [BackdropScaffold] composable.
 *
 * @param initialValue The initial value of the state.
 * @param animationSpec The default animation that will be used to animate to a new state.
 * @param confirmStateChange Optional callback invoked to confirm or veto a pending state change.
 * @param snackbarHostState The [SnackbarHostState] used to show snackbars inside the scaffold.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Stable
public class BackdropScaffoldState(
    initialValue: BackdropValue,
    animationSpec: AnimationSpec<Float> = SwipeableDefaults.AnimationSpec,
    confirmStateChange: (BackdropValue) -> Boolean = { true },
    public val snackbarHostState: SnackbarHostState = SnackbarHostState(),
) : SwipeableState<BackdropValue>(
    initialValue = initialValue,
    animationSpec = animationSpec,
    confirmStateChange = confirmStateChange,
) {
    /**
     * Whether the back layer is revealed.
     */
    public val isRevealed: Boolean
        get() = currentValue == Revealed

    /**
     * Whether the back layer is concealed.
     */
    public val isConcealed: Boolean
        get() = currentValue == Concealed

    /**
     * Reveal the back layer with animation and suspend until it if fully revealed or animation
     * has been cancelled.  This method will throw [CancellationException] if the animation is
     * interrupted
     *
     * @return the reason the reveal animation ended
     */
    public suspend fun reveal(): Unit = animateTo(targetValue = Revealed)

    /**
     * Conceal the back layer with animation and suspend until it if fully concealed or animation
     * has been cancelled. This method will throw [CancellationException] if the animation is
     * interrupted
     *
     * @return the reason the conceal animation ended
     */
    @Suppress("")
    public suspend fun conceal(): Unit = animateTo(targetValue = Concealed)

    internal val nestedScrollConnection = this.PreUpPostDownNestedScrollConnection

    public companion object {
        /**
         * The default [Saver] implementation for [BackdropScaffoldState].
         */
        public fun Saver(
            animationSpec: AnimationSpec<Float>,
            confirmStateChange: (BackdropValue) -> Boolean,
            snackbarHostState: SnackbarHostState,
        ): Saver<BackdropScaffoldState, *> = Saver(
            save = { it.currentValue },
            restore = {
                BackdropScaffoldState(
                    initialValue = it,
                    animationSpec = animationSpec,
                    confirmStateChange = confirmStateChange,
                    snackbarHostState = snackbarHostState,
                )
            },
        )
    }
}

/**
 * Create and [remember] a [BackdropScaffoldState].
 *
 * @param initialValue The initial value of the state.
 * @param animationSpec The default animation that will be used to animate to a new state.
 * @param confirmStateChange Optional callback invoked to confirm or veto a pending state change.
 * @param snackbarHostState The [SnackbarHostState] used to show snackbars inside the scaffold.
 */
@Composable
public fun rememberBackdropScaffoldState(
    initialValue: BackdropValue,
    animationSpec: AnimationSpec<Float> = SwipeableDefaults.AnimationSpec,
    confirmStateChange: (BackdropValue) -> Boolean = { true },
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
): BackdropScaffoldState {
    return rememberSaveable(
        animationSpec,
        confirmStateChange,
        snackbarHostState,
        saver = BackdropScaffoldState.Saver(
            animationSpec = animationSpec,
            confirmStateChange = confirmStateChange,
            snackbarHostState = snackbarHostState,
        ),
    ) {
        BackdropScaffoldState(
            initialValue = initialValue,
            animationSpec = animationSpec,
            confirmStateChange = confirmStateChange,
            snackbarHostState = snackbarHostState,
        )
    }
}

/**
 * <a href="https://material.io/components/backdrop" class="external" target="_blank">Material Design backdrop</a>.
 *
 * A backdrop appears behind all other surfaces in an app, displaying contextual and actionable
 * content.
 *
 * ![Backdrop image](https://developer.android.com/images/reference/androidx/compose/material/backdrop.png)
 *
 * This component provides an API to put together several material components to construct your
 * screen. For a similar component which implements the basic material design layout strategy
 * with app bars, floating action buttons and navigation drawers, use the standard [Scaffold].
 * For similar component that uses a bottom sheet as the centerpiece of the screen, use
 * [BottomSheetScaffold].
 *
 * Either the back layer or front layer can be active at a time. When the front layer is active,
 * it sits at an offset below the top of the screen. This is the [peekHeight] and defaults to
 * 56dp which is the default app bar height. When the front layer is inactive, it sticks to the
 * height of the back layer's content if [stickyFrontLayer] is set to `true` and the height of
 * the front layer exceeds the [headerHeight], and otherwise it minimizes to the [headerHeight].
 * To switch between the back layer and front layer, you can either swipe on the front layer if
 * [gesturesEnabled] is set to `true` or use any of the methods in [BackdropScaffoldState].
 *
 * The scaffold also contains an app bar, which by default is placed above the back layer's
 * content. If [persistentAppBar] is set to `false`, then the backdrop will not show the app bar
 * when the back layer is revealed; instead it will switch between the app bar and the provided
 * content with an animation. For best results, the [peekHeight] should match the app bar height.
 * To show a snackbar, use the method `showSnackbar` of [BackdropScaffoldState.snackbarHostState].
 *
 * A simple example of a backdrop scaffold looks like this:
 *
 * @sample androidx.compose.material.samples.BackdropScaffoldSample
 *
 * @param appBar App bar for the back layer. Make sure that the [peekHeight] is equal to the
 * height of the app bar, so that the app bar is fully visible. Consider using [TopAppBar] but
 * set the elevation to 0dp and background color to transparent as a surface is already provided.
 * @param backLayerContent The content of the back layer.
 * @param frontLayerContent The content of the front layer.
 * @param modifier Optional [Modifier] for the root of the scaffold.
 * @param scaffoldState The state of the scaffold.
 * @param gesturesEnabled Whether or not the backdrop can be interacted with by gestures.
 * @param peekHeight The height of the visible part of the back layer when it is concealed.
 * @param headerHeight The minimum height of the front layer when it is inactive.
 * @param persistentAppBar Whether the app bar should be shown when the back layer is revealed.
 * By default, it will always be shown above the back layer's content. If this is set to `false`,
 * the back layer will automatically switch between the app bar and its content with an animation.
 * @param stickyFrontLayer Whether the front layer should stick to the height of the back layer.
 * @param backLayerBackgroundColor The background color of the back layer.
 * @param backLayerContentColor The preferred content color provided by the back layer to its
 * children. Defaults to the matching content color for [backLayerBackgroundColor], or if that
 * is not a color from the theme, this will keep the same content color set above the back layer.
 * @param frontLayerShape The shape of the front layer.
 * @param frontLayerElevation The elevation of the front layer.
 * @param frontLayerBackgroundColor The background color of the front layer.
 * @param frontLayerContentColor The preferred content color provided by the back front to its
 * children. Defaults to the matching content color for [frontLayerBackgroundColor], or if that
 * is not a color from the theme, this will keep the same content color set above the front layer.
 * @param frontLayerScrimColor The color of the scrim applied to the front layer when the back
 * layer is revealed. If the color passed is [Color.Unspecified], then a scrim will not be
 * applied and interaction with the front layer will not be blocked when the back layer is revealed.
 * @param snackbarHost The component hosting the snackbars shown inside the scaffold.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun BackdropScaffold(
    appBar: @Composable () -> Unit,
    backLayerContent: @Composable () -> Unit,
    frontLayerContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    scaffoldState: BackdropScaffoldState = rememberBackdropScaffoldState(Concealed),
    gesturesEnabled: Boolean = true,
    peekHeight: Dp = BackdropScaffoldDefaults.PeekHeight,
    headerHeight: Dp = BackdropScaffoldDefaults.HeaderHeight,
    persistentAppBar: Boolean = true,
    stickyFrontLayer: Boolean = true,
    backLayerBackgroundColor: Color = SparkTheme.colors.primary,
    backLayerContentColor: Color = contentColorFor(backLayerBackgroundColor),
    frontLayerShape: Shape = BackdropScaffoldDefaults.frontLayerShape,
    frontLayerElevation: Dp = BackdropScaffoldDefaults.FrontLayerElevation,
    frontLayerBackgroundColor: Color = SparkTheme.colors.surface,
    frontLayerContentColor: Color = contentColorFor(frontLayerBackgroundColor),
    frontLayerScrimColor: Color = BackdropScaffoldDefaults.frontLayerScrimColor,
    snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
) {
    val peekHeightPx = with(LocalDensity.current) { peekHeight.toPx() }
    val headerHeightPx = with(LocalDensity.current) { headerHeight.toPx() }

    val backLayer = @Composable {
        if (persistentAppBar) {
            Column {
                appBar()
                backLayerContent()
            }
        } else {
            BackLayerTransition(scaffoldState.targetValue, appBar, backLayerContent)
        }
    }
    val calculateBackLayerConstraints: (Constraints) -> Constraints = {
        it.copy(minWidth = 0, minHeight = 0).offset(vertical = -headerHeightPx.roundToInt())
    }

    // Back layer
    Surface(
        color = backLayerBackgroundColor,
        contentColor = backLayerContentColor,
    ) {
        val scope = rememberCoroutineScope()
        BackdropStack(
            modifier.fillMaxSize(),
            backLayer,
            calculateBackLayerConstraints,
        ) { constraints, backLayerHeight ->
            val fullHeight = constraints.maxHeight.toFloat()
            var revealedHeight = fullHeight - headerHeightPx
            if (stickyFrontLayer) {
                revealedHeight = min(revealedHeight, backLayerHeight)
            }
            val nestedScroll = if (gesturesEnabled) {
                Modifier.nestedScroll(scaffoldState.nestedScrollConnection)
            } else {
                Modifier
            }

            val swipeable = Modifier
                .then(nestedScroll)
                .swipeable(
                    state = scaffoldState,
                    anchors = mapOf(
                        peekHeightPx to Concealed,
                        revealedHeight to Revealed,
                    ),
                    orientation = Orientation.Vertical,
                    enabled = gesturesEnabled,
                )
                .semantics {
                    if (scaffoldState.isConcealed) {
                        collapse {
                            if (scaffoldState.confirmStateChange(Revealed)) {
                                scope.launch { scaffoldState.reveal() }
                            }; true
                        }
                    } else {
                        expand {
                            if (scaffoldState.confirmStateChange(Concealed)) {
                                scope.launch { scaffoldState.conceal() }
                            }; true
                        }
                    }
                }

            // Front layer
            Surface(
                Modifier
                    .offset { IntOffset(0, scaffoldState.offset.value.roundToInt()) }
                    .then(swipeable),
                shape = frontLayerShape,
                tonalElevation = frontLayerElevation,
                color = frontLayerBackgroundColor,
                contentColor = frontLayerContentColor,
            ) {
                Box(Modifier.padding(bottom = peekHeight)) {
                    frontLayerContent()
                    Scrim(
                        color = frontLayerScrimColor,
                        onDismiss = {
                            if (gesturesEnabled && scaffoldState.confirmStateChange(Concealed)) {
                                scope.launch { scaffoldState.conceal() }
                            }
                        },
                        visible = scaffoldState.targetValue == Revealed,
                    )
                }
            }

            // Snackbar host
            Box(
                Modifier
                    .padding(
                        bottom = if (scaffoldState.isRevealed &&
                            revealedHeight == fullHeight - headerHeightPx
                        ) headerHeight else 0.dp,
                    ),
                contentAlignment = Alignment.BottomCenter,
            ) {
                snackbarHost(scaffoldState.snackbarHostState)
            }
        }
    }
}

@Composable
private fun Scrim(
    color: Color,
    onDismiss: () -> Unit,
    visible: Boolean,
) {
    if (color.isSpecified) {
        val alpha by animateFloatAsState(
            targetValue = if (visible) 1f else 0f,
            animationSpec = TweenSpec(),
            label = "Scrim alpha",
        )
        val dismissModifier = if (visible) {
            Modifier.pointerInput(Unit) { detectTapGestures { onDismiss() } }
        } else {
            Modifier
        }
        Canvas(
            Modifier
                .fillMaxSize()
                .then(dismissModifier),
        ) {
            drawRect(color = color, alpha = alpha)
        }
    }
}

/**
 * A shared axis transition, used in the back layer. Both the [appBar] and the [content] shift
 * vertically, while they crossfade. It is very important that both are composed and measured,
 * even if invisible, and that this component is as large as both of them.
 */
@Composable
private fun BackLayerTransition(
    target: BackdropValue,
    appBar: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    // The progress of the animation between Revealed (0) and Concealed (2).
    // The midpoint (1) is the point where the appBar and backContent are switched.
    val animationProgress by animateFloatAsState(
        targetValue = if (target == Revealed) 0f else 2f, animationSpec = TweenSpec(),
        label = "Back Layer Transition",
    )
    val animationSlideOffset = with(LocalDensity.current) { AnimationSlideOffset.toPx() }

    val appBarFloat = (animationProgress - 1).coerceIn(0f, 1f)
    val contentFloat = (1 - animationProgress).coerceIn(0f, 1f)

    Box {
        Box(
            Modifier
                .zIndex(appBarFloat)
                .graphicsLayer(
                    alpha = appBarFloat,
                    translationY = (1 - appBarFloat) * animationSlideOffset,
                ),
        ) {
            appBar()
        }
        Box(
            Modifier
                .zIndex(contentFloat)
                .graphicsLayer(
                    alpha = contentFloat,
                    translationY = (1 - contentFloat) * -animationSlideOffset,
                ),
        ) {
            content()
        }
    }
}

@Composable
@UiComposable
private fun BackdropStack(
    modifier: Modifier,
    backLayer: @Composable @UiComposable () -> Unit,
    calculateBackLayerConstraints: (Constraints) -> Constraints,
    frontLayer: @Composable @UiComposable (Constraints, Float) -> Unit,
) {
    SubcomposeLayout(modifier) { constraints ->
        val backLayerPlaceable =
            subcompose(BackdropLayers.Back, backLayer).first()
                .measure(calculateBackLayerConstraints(constraints))

        val backLayerHeight = backLayerPlaceable.height.toFloat()

        val placeables =
            subcompose(BackdropLayers.Front) {
                frontLayer(constraints, backLayerHeight)
            }.map { it.measure(constraints) }

        var maxWidth = max(constraints.minWidth, backLayerPlaceable.width)
        var maxHeight = max(constraints.minHeight, backLayerPlaceable.height)
        placeables.forEach {
            maxWidth = max(maxWidth, it.width)
            maxHeight = max(maxHeight, it.height)
        }

        layout(maxWidth, maxHeight) {
            backLayerPlaceable.placeRelative(0, 0)
            placeables.forEach { it.placeRelative(0, 0) }
        }
    }
}

private enum class BackdropLayers { Back, Front }

/**
 * Contains useful defaults for [BackdropScaffold].
 */
public object BackdropScaffoldDefaults {

    /**
     * The default peek height of the back layer.
     */
    public val PeekHeight: Dp = 56.dp

    /**
     * The default header height of the front layer.
     */
    public val HeaderHeight: Dp = 48.dp

    /**
     * The default shape of the front layer.
     */
    public val frontLayerShape: Shape
        @Composable
        get() = SparkTheme.shapes.extraLarge.copy(
            bottomEnd = CornerSize(0.dp),
            bottomStart = CornerSize(0.dp),
        )

    /**
     * The default elevation of the front layer.
     */
    public val FrontLayerElevation: Dp = 1.dp

    /**
     * The default color of the scrim applied to the front layer.
     */
    public val frontLayerScrimColor: Color
        @Composable get() = SparkTheme.colors.surface.copy(alpha = 0.60f)
}

private val AnimationSlideOffset = 20.dp
