/*
 * Copyright (c) 2023-2024 Adevinta
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
package com.adevinta.spark.components.bottomsheet.layout

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.semantics.collapse
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.dismiss
import androidx.compose.ui.semantics.expand
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.bottomsheet.handle.DragHandle
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.res.resources
import com.adevinta.spark.tokens.contentColorFor
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import kotlin.math.max
import kotlin.math.roundToInt

/**
 * Possible values of [ModalBottomSheetState].
 */
@ExperimentalMaterial3Api
@Deprecated(
    message = "Use [SheetState] instead.",
    level = DeprecationLevel.WARNING,
    replaceWith = ReplaceWith("SheetState", "androidx.compose.material3.SheetState"),
)
public enum class ModalBottomSheetValue {
    /**
     * The bottom sheet is not visible.
     */
    Hidden,

    /**
     * The bottom sheet is visible at full height.
     */
    Expanded,

    /**
     * The bottom sheet is partially visible at 50% of the screen height. This state is only
     * enabled if the height of the bottom sheet is more than 50% of the screen height.
     */
    HalfExpanded,
}

/**
 * State of the [ModalBottomSheetLayout] composable.
 *
 * @param initialValue The initial value of the state. <b>Must not be set to
 * [ModalBottomSheetValue.HalfExpanded] if [isSkipHalfExpanded] is set to true.</b>
 * @param animationSpec The default animation that will be used to animate to a new state.
 * @param isSkipHalfExpanded Whether the half expanded state, if the sheet is tall enough, should
 * be skipped. If true, the sheet will always expand to the [ModalBottomSheetValue.Expanded] state and move to the
 * [Hidden] state when hiding the sheet, either programmatically or by user interaction.
 * <b>Must not be set to true if the [initialValue] is [ModalBottomSheetValue.HalfExpanded].</b>
 * If supplied with [ModalBottomSheetValue.HalfExpanded] for the [initialValue], an
 * [IllegalArgumentException] will be thrown.
 * @param confirmStateChange Optional callback invoked to confirm or veto a pending state change.
 */
@ExperimentalMaterial3Api
@Deprecated(
    message = "Use [SheetState] instead.",
    level = DeprecationLevel.WARNING,
    replaceWith = ReplaceWith("SheetState", "androidx.compose.material3.SheetState"),
)
@Suppress("DEPRECATION")
public class ModalBottomSheetState(
    initialValue: ModalBottomSheetValue,
    animationSpec: AnimationSpec<Float> = SwipeableDefaults.AnimationSpec,
    internal val isSkipHalfExpanded: Boolean,
    confirmStateChange: (ModalBottomSheetValue) -> Boolean = { true },
) : SwipeableState<ModalBottomSheetValue>(
    initialValue = initialValue,
    animationSpec = animationSpec,
    confirmStateChange = confirmStateChange,
) {
    /**
     * Whether the bottom sheet is visible.
     */
    public val isVisible: Boolean
        get() = currentValue != ModalBottomSheetValue.Hidden

    internal val hasHalfExpandedState: Boolean
        get() = anchors.values.contains(ModalBottomSheetValue.HalfExpanded)

    public constructor(
        initialValue: ModalBottomSheetValue,
        animationSpec: AnimationSpec<Float> = SwipeableDefaults.AnimationSpec,
        confirmStateChange: (ModalBottomSheetValue) -> Boolean = { true },
    ) : this(initialValue, animationSpec, isSkipHalfExpanded = false, confirmStateChange)

    init {
        if (isSkipHalfExpanded) {
            require(initialValue != ModalBottomSheetValue.HalfExpanded) {
                "The initial value must not be set to HalfExpanded if skipHalfExpanded is set to" + " true."
            }
        }
    }

    /**
     * Show the bottom sheet with animation and suspend until it's shown. If the sheet is taller
     * than 50% of the parent's height, the bottom sheet will be half expanded. Otherwise it will be
     * fully expanded.
     *
     * @throws [CancellationException] if the animation is interrupted
     */
    public suspend fun show() {
        val targetValue = when {
            hasHalfExpandedState -> ModalBottomSheetValue.HalfExpanded
            else -> ModalBottomSheetValue.Expanded
        }
        animateTo(targetValue = targetValue)
    }

    /**
     * Half expand the bottom sheet if half expand is enabled with animation and suspend until it
     * animation is complete or cancelled
     *
     * @throws [CancellationException] if the animation is interrupted
     */
    internal suspend fun halfExpand() {
        if (!hasHalfExpandedState) {
            return
        }
        animateTo(ModalBottomSheetValue.HalfExpanded)
    }

    /**
     * Fully expand the bottom sheet with animation and suspend until it if fully expanded or
     * animation has been cancelled.
     * *
     * @throws [CancellationException] if the animation is interrupted
     */
    internal suspend fun expand() = animateTo(ModalBottomSheetValue.Expanded)

    /**
     * Hide the bottom sheet with animation and suspend until it if fully hidden or animation has
     * been cancelled.
     *
     * @throws [CancellationException] if the animation is interrupted
     */
    public suspend fun hide(): Unit = animateTo(ModalBottomSheetValue.Hidden)

    internal val nestedScrollConnection = this.PreUpPostDownNestedScrollConnection

    public companion object {
        /**
         * The default [Saver] implementation for [ModalBottomSheetState].
         */
        @Suppress("ktlint:standard:function-naming", "DEPRECATION")
        public fun Saver(
            animationSpec: AnimationSpec<Float>,
            skipHalfExpanded: Boolean,
            confirmStateChange: (ModalBottomSheetValue) -> Boolean,
        ): Saver<ModalBottomSheetState, *> = Saver(
            save = { it.currentValue },
            restore = {
                ModalBottomSheetState(
                    initialValue = it,
                    animationSpec = animationSpec,
                    isSkipHalfExpanded = skipHalfExpanded,
                    confirmStateChange = confirmStateChange,
                )
            },
        )
    }
}

/**
 * Create a [ModalBottomSheetState] and [remember] it.
 *
 * @param initialValue The initial value of the state.
 * @param animationSpec The default animation that will be used to animate to a new state.
 * @param skipHalfExpanded Whether the half expanded state, if the sheet is tall enough, should
 * be skipped. If true, the sheet will always expand to the [ModalBottomSheetValue.Expanded] state and move to the
 * [Hidden] state when hiding the sheet, either programmatically or by user interaction.
 * <b>Must not be set to true if the [initialValue] is [ModalBottomSheetValue.HalfExpanded].</b>
 * If supplied with [ModalBottomSheetValue.HalfExpanded] for the [initialValue], an
 * [IllegalArgumentException] will be thrown.
 * @param confirmStateChange Optional callback invoked to confirm or veto a pending state change.
 */
@Composable
@ExperimentalMaterial3Api
@Suppress("DEPRECATION")
public fun rememberModalBottomSheetState(
    initialValue: ModalBottomSheetValue,
    skipHalfExpanded: Boolean,
    animationSpec: AnimationSpec<Float> = SwipeableDefaults.AnimationSpec,
    confirmStateChange: (ModalBottomSheetValue) -> Boolean = { true },
): ModalBottomSheetState {
    @Suppress("DEPRECATION")
    return rememberSaveable(
        initialValue,
        animationSpec,
        skipHalfExpanded,
        confirmStateChange,
        saver = ModalBottomSheetState.Saver(
            animationSpec = animationSpec,
            skipHalfExpanded = skipHalfExpanded,
            confirmStateChange = confirmStateChange,
        ),
    ) {
        ModalBottomSheetState(
            initialValue = initialValue,
            animationSpec = animationSpec,
            isSkipHalfExpanded = skipHalfExpanded,
            confirmStateChange = confirmStateChange,
        )
    }
}

/**
 * Create a [ModalBottomSheetState] and [remember] it.
 *
 * @param initialValue The initial value of the state.
 * @param animationSpec The default animation that will be used to animate to a new state.
 * @param confirmStateChange Optional callback invoked to confirm or veto a pending state change.
 */
@Composable
@ExperimentalMaterial3Api
@Suppress("DEPRECATION")
public fun rememberModalBottomSheetState(
    initialValue: ModalBottomSheetValue,
    animationSpec: AnimationSpec<Float> = SwipeableDefaults.AnimationSpec,
    confirmStateChange: (ModalBottomSheetValue) -> Boolean = { true },
): ModalBottomSheetState = rememberModalBottomSheetState(
    initialValue = initialValue,
    skipHalfExpanded = false,
    animationSpec = animationSpec,
    confirmStateChange = confirmStateChange,
)

/**
 *
 * Modal bottom sheets present a set of choices while blocking interaction with the rest of the
 * screen. They are an alternative to inline menus and simple dialogs, providing
 * additional room for content, iconography, and actions.
 **
 * @param sheetContent The content of the bottom sheet.
 * @param modifier Optional [Modifier] for the entire component.
 * @param sheetState The state of the bottom sheet.
 * @param sheetShape The shape of the bottom sheet.
 * @param sheetElevation The elevation of the bottom sheet.
 * @param sheetBackgroundColor The background color of the bottom sheet.
 * @param sheetContentColor The preferred content color provided by the bottom sheet to its
 * children. Defaults to the matching content color for [sheetBackgroundColor], or if that is not
 * a color from the theme, this will keep the same content color set above the bottom sheet.
 * @param scrimColor The color of the scrim that is applied to the rest of the screen when the
 * bottom sheet is visible. If the color passed is [Color.Unspecified], then a scrim will no
 * longer be applied and the bottom sheet will not block interaction with the rest of the screen
 * when visible.
 * @param content The content of rest of the screen.
 */
@Composable
@ExperimentalMaterial3Api
@Deprecated(
    message = "Use one of the options: [BottomSheet] , [BottomSheetScaffold]",
    level = DeprecationLevel.WARNING,
    replaceWith = ReplaceWith("BottomSheet", "com.adevinta.spark.components.bottomsheet.BottomSheet"),
)
@Suppress("DEPRECATION")
public fun ModalBottomSheetLayout(
    sheetContent: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier,
    sheetState: ModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden),
    sheetShape: Shape = SparkTheme.shapes.large.copy(
        bottomStart = CornerSize(0.dp),
        bottomEnd = CornerSize(0.dp),
    ),
    sheetElevation: Dp = ModalBottomSheetDefaults.Elevation,
    sheetBackgroundColor: Color = SparkTheme.colors.surface,
    sheetContentColor: Color = contentColorFor(sheetBackgroundColor),
    scrimColor: Color = ModalBottomSheetDefaults.scrimColor,
    content: @Composable () -> Unit,
) {
    val scope = rememberCoroutineScope()
    BoxWithConstraints(modifier.sparkUsageOverlay()) {
        val fullHeight = constraints.maxHeight.toFloat()
        val sheetHeightState = remember { mutableStateOf<Float?>(null) }
        Box(Modifier.fillMaxSize()) {
            content()
            Scrim(
                color = scrimColor,
                onDismiss = {
                    if (sheetState.confirmStateChange(ModalBottomSheetValue.Hidden)) {
                        scope.launch { sheetState.hide() }
                    }
                },
                visible = sheetState.targetValue != ModalBottomSheetValue.Hidden,
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .nestedScroll(sheetState.nestedScrollConnection)
                .offset {
                    val y = if (sheetState.anchors.isEmpty()) {
                        // if we don't know our anchors yet, render the sheet as hidden
                        fullHeight.roundToInt()
                    } else {
                        // if we do know our anchors, respect them
                        sheetState.offset.value.roundToInt()
                    }
                    IntOffset(0, y)
                }
                .bottomSheetSwipeable(sheetState, fullHeight, sheetHeightState)
                .onGloballyPositioned {
                    sheetHeightState.value = it.size.height.toFloat()
                }
                .semantics {
                    if (sheetState.isVisible) {
                        dismiss {
                            if (sheetState.confirmStateChange(ModalBottomSheetValue.Hidden)) {
                                scope.launch { sheetState.hide() }
                            }
                            true
                        }
                        if (sheetState.currentValue == ModalBottomSheetValue.HalfExpanded) {
                            expand {
                                if (sheetState.confirmStateChange(ModalBottomSheetValue.Expanded)) {
                                    scope.launch { sheetState.expand() }
                                }
                                true
                            }
                        } else if (sheetState.hasHalfExpandedState) {
                            collapse {
                                if (sheetState.confirmStateChange(ModalBottomSheetValue.HalfExpanded)) {
                                    scope.launch { sheetState.halfExpand() }
                                }
                                true
                            }
                        }
                    }
                },
            shape = sheetShape,
            elevation = sheetElevation,
            // tonalElevation = sheetElevation, Only use shadow elevation
            // for now as brikke doesn't support tonal elevation yet
            color = sheetBackgroundColor,
            contentColor = sheetContentColor,
        ) {
            Column {
                DragHandle(
                    Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp, bottom = 16.dp), // specs to extract into default?
                )
                sheetContent()
            }
        }
    }
}

@Suppress("ModifierInspectorInfo", "DEPRECATION")
@OptIn(ExperimentalMaterial3Api::class)
private fun Modifier.bottomSheetSwipeable(
    sheetState: ModalBottomSheetState,
    fullHeight: Float,
    sheetHeightState: State<Float?>,
): Modifier {
    val sheetHeight = sheetHeightState.value
    val modifier = if (sheetHeight != null) {
        val anchors = if (sheetHeight < fullHeight / 2 || sheetState.isSkipHalfExpanded) {
            mapOf(
                fullHeight to ModalBottomSheetValue.Hidden,
                fullHeight - sheetHeight to ModalBottomSheetValue.Expanded,
            )
        } else {
            mapOf(
                fullHeight to ModalBottomSheetValue.Hidden,
                fullHeight / 2 to ModalBottomSheetValue.HalfExpanded,
                max(0f, fullHeight - sheetHeight) to ModalBottomSheetValue.Expanded,
            )
        }
        Modifier.swipeable(
            state = sheetState,
            anchors = anchors,
            orientation = Orientation.Vertical,
            enabled = sheetState.currentValue != ModalBottomSheetValue.Hidden,
            resistance = null,
        )
    } else {
        Modifier
    }

    return this.then(modifier)
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
        )

        @Suppress("PrivateResource") val closeSheet = resources().getString(androidx.compose.ui.R.string.close_sheet)
        val dismissModifier = if (visible) {
            Modifier
                .pointerInput(onDismiss) { detectTapGestures { onDismiss() } }
                .semantics(mergeDescendants = true) {
                    contentDescription = closeSheet
                    onClick {
                        onDismiss()
                        true
                    }
                }
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
 * Contains useful Defaults for [ModalBottomSheetLayout].
 */
public object ModalBottomSheetDefaults {

    /**
     * The default elevation used by [ModalBottomSheetLayout].
     */
    public val Elevation: Dp = 16.dp

    /**
     * The default scrim color used by [ModalBottomSheetLayout].
     */
    public val scrimColor: Color
        @Composable get() = SparkTheme.colors.onSurface.copy(alpha = 0.32f)
}
