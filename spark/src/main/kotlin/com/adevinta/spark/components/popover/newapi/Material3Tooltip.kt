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
package com.adevinta.spark.components.popover.newapi

/**
 * This class is copied from Material design 3 compose open source library
 * TODO: Please remove it after the library reaches to 1.2.0 stable version
 */

/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.MutatorMutex
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupPositionProvider
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.tokens.SparkShapes
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeout

@Composable
public fun TooltipBox(
    positionProvider: PopupPositionProvider,
    tooltip: @Composable () -> Unit,
    state: TooltipState,
    modifier: Modifier = Modifier,
    focusable: Boolean = true,
    enableUserInput: Boolean = true,
    content: @Composable () -> Unit,
) {
    val transition = updateTransition(state.transition, label = "tooltip transition")
    BasicTooltipBox(
        positionProvider = positionProvider,
        tooltip = { Box(Modifier.animateTooltip(transition)) { tooltip() } },
        focusable = focusable,
        enableUserInput = enableUserInput,
        state = state,
        modifier = modifier,
        content = content,
    )
}

/**
 * Plain tooltip that provides a descriptive message.
 *
 * Usually used with [TooltipBox].
 *
 * @param modifier the [Modifier] to be applied to the tooltip.
 * @param contentColor [Color] that will be applied to the tooltip's content.
 * @param containerColor [Color] that will be applied to the tooltip's container.
 * @param shape the [Shape] that should be applied to the tooltip container.
 * @param content the composable that will be used to populate the tooltip's content.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun PlainTooltip(
    modifier: Modifier = Modifier,
    contentColor: Color = TooltipDefaults.plainTooltipContentColor,
    containerColor: Color = TooltipDefaults.plainTooltipContainerColor,
    shape: Shape = TooltipDefaults.plainTooltipContainerShape,
    content: @Composable () -> Unit,
) {
    Surface(
        shape = shape,
        color = containerColor,
    ) {
        Box(
            modifier = modifier
                .sizeIn(
                    minWidth = TooltipMinWidth,
                    maxWidth = PlainTooltipMaxWidth,
                    minHeight = TooltipMinHeight,
                )
                .padding(PlainTooltipContentPadding),
        ) {
            val textStyle = SparkTheme.typography.body1
            CompositionLocalProvider(
                LocalContentColor provides contentColor,
                LocalTextStyle provides textStyle,
                content = content,
            )
        }
    }
}

/**
 * Rich text tooltip that allows the user to pass in a title, text, and action.
 * Tooltips are used to provide a descriptive message.
 *
 * Usually used with [TooltipBox]
 *
 * @param modifier the [Modifier] to be applied to the tooltip.
 * @param title An optional title for the tooltip.
 * @param action An optional action for the tooltip.
 * @param colors [RichTooltipColors] that will be applied to the tooltip's container and content.
 * @param shape the [Shape] that should be applied to the tooltip container.
 * @param text the composable that will be used to populate the rich tooltip's text.
 */

/**
 * Tooltip defaults that contain default values for both [PlainTooltip] and [RichTooltip]
 */
@ExperimentalMaterial3Api
public object TooltipDefaults {
    /**
     * The default [Shape] for a [PlainTooltip]'s container.
     */
    public val plainTooltipContainerShape: Shape
        @Composable get() = SparkShapes().small

    /**
     * The default [Color] for a [PlainTooltip]'s container.
     */
    public val plainTooltipContainerColor: Color
        @Composable get() = SparkTheme.colors.surfaceInverse

    /**
     * The default [Color] for the content within the [PlainTooltip].
     */
    public val plainTooltipContentColor: Color
        @Composable get() = SparkTheme.colors.onSurfaceInverse

    /**
     * The default [Shape] for a [RichTooltip]'s container.
     */
    public val richTooltipContainerShape: Shape
        @Composable get() = SparkShapes().medium

    /**
     * Method to create a [RichTooltipColors] for [RichTooltip]
     * using [RichTooltipTokens] to obtain the default colors.
     */
    @Composable
    public fun richTooltipColors(
        containerColor: Color = SparkTheme.colors.surface,
        contentColor: Color = SparkTheme.colors.onBackgroundVariant,
        titleContentColor: Color = SparkTheme.colors.onBackgroundVariant,
        actionContentColor: Color = SparkTheme.colors.main,
    ): RichTooltipColors = RichTooltipColors(
        containerColor = containerColor,
        contentColor = contentColor,
        titleContentColor = titleContentColor,
        actionContentColor = actionContentColor,
    )

    /**
     * [PopupPositionProvider] that should be used with [PlainTooltip].
     * It correctly positions the tooltip in respect to the anchor content.
     *
     * @param spacingBetweenTooltipAndAnchor the spacing between the tooltip and the anchor content.
     */
    @Composable
    public fun rememberPlainTooltipPositionProvider(
        spacingBetweenTooltipAndAnchor: Dp = SpacingBetweenTooltipAndAnchor,
    ): PopupPositionProvider {
        val tooltipAnchorSpacing = with(LocalDensity.current) {
            spacingBetweenTooltipAndAnchor.roundToPx()
        }
        return remember(tooltipAnchorSpacing) {
            object : PopupPositionProvider {
                override fun calculatePosition(
                    anchorBounds: IntRect,
                    windowSize: IntSize,
                    layoutDirection: LayoutDirection,
                    popupContentSize: IntSize,
                ): IntOffset {
                    val x = anchorBounds.left + (anchorBounds.width - popupContentSize.width) / 2
                    // Tooltip prefers to be above the anchor,
                    // but if this causes the tooltip to overlap with the anchor
                    // then we place it below the anchor
                    var y = anchorBounds.top - popupContentSize.height - tooltipAnchorSpacing
                    if (y < 0) y = anchorBounds.bottom + tooltipAnchorSpacing
                    return IntOffset(x, y)
                }
            }
        }
    }

    /**
     * [PopupPositionProvider] that should be used with [RichTooltip].
     * It correctly positions the tooltip in respect to the anchor content.
     *
     * @param spacingBetweenTooltipAndAnchor the spacing between the tooltip and the anchor content.
     */
    @Composable
    public fun rememberRichTooltipPositionProvider(
        spacingBetweenTooltipAndAnchor: Dp = SpacingBetweenTooltipAndAnchor,
    ): PopupPositionProvider {
        val tooltipAnchorSpacing = with(LocalDensity.current) {
            spacingBetweenTooltipAndAnchor.roundToPx()
        }
        return remember(tooltipAnchorSpacing) {
            object : PopupPositionProvider {
                override fun calculatePosition(
                    anchorBounds: IntRect,
                    windowSize: IntSize,
                    layoutDirection: LayoutDirection,
                    popupContentSize: IntSize,
                ): IntOffset {
                    var x = anchorBounds.right
                    // Try to shift it to the left of the anchor
                    // if the tooltip would collide with the right side of the screen
                    if (x + popupContentSize.width > windowSize.width) {
                        x = anchorBounds.left - popupContentSize.width
                        // Center if it'll also collide with the left side of the screen
                        if (x < 0) x = anchorBounds.left + (anchorBounds.width - popupContentSize.width) / 2
                    }
                    // Tooltip prefers to be above the anchor,
                    // but if this causes the tooltip to overlap with the anchor
                    // then we place it below the anchor
                    var y = anchorBounds.top - popupContentSize.height - tooltipAnchorSpacing
                    if (y < 0) y = anchorBounds.bottom + tooltipAnchorSpacing
                    return IntOffset(x, y)
                }
            }
        }
    }
}

@Stable
@Immutable
@ExperimentalMaterial3Api
public class RichTooltipColors(
    public val contentColor: Color,
    public val containerColor: Color,
    public val titleContentColor: Color,
    public val actionContentColor: Color,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RichTooltipColors) return false
        if (containerColor != other.containerColor) return false
        if (contentColor != other.contentColor) return false
        if (titleContentColor != other.titleContentColor) return false
        if (actionContentColor != other.actionContentColor) return false
        return true
    }

    override fun hashCode(): Int {
        var result = containerColor.hashCode()
        result = 31 * result + contentColor.hashCode()
        result = 31 * result + titleContentColor.hashCode()
        result = 31 * result + actionContentColor.hashCode()
        return result
    }
}

/**
 * Create and remember the default [TooltipState] for [TooltipBox].
 *
 * @param initialIsVisible the initial value for the tooltip's visibility when drawn.
 * @param isPersistent [Boolean] that determines if the tooltip associated with this
 * will be persistent or not. If isPersistent is true, then the tooltip will
 * only be dismissed when the user clicks outside the bounds of the tooltip or if
 * [TooltipState.dismiss] is called. When isPersistent is false, the tooltip will dismiss after
 * a short duration. Ideally, this should be set to true when there is actionable content
 * being displayed within a tooltip.
 * @param mutatorMutex [MutatorMutex] used to ensure that for all of the tooltips associated
 * with the mutator mutex, only one will be shown on the screen at any time.
 *
 */
@Composable
@ExperimentalMaterial3Api
public fun rememberTooltipState(
    initialIsVisible: Boolean = false,
    isPersistent: Boolean = false,
    mutatorMutex: MutatorMutex = BasicTooltipDefaults.GlobalMutatorMutex,
): TooltipState = remember(
    isPersistent,
    mutatorMutex,
) {
    TooltipStateImpl(
        initialIsVisible = initialIsVisible,
        isPersistent = isPersistent,
        mutatorMutex = mutatorMutex,
    )
}

/**
 * Constructor extension function for [TooltipState]
 *
 * @param initialIsVisible the initial value for the tooltip's visibility when drawn.
 * @param isPersistent [Boolean] that determines if the tooltip associated with this
 * will be persistent or not. If isPersistent is true, then the tooltip will
 * only be dismissed when the user clicks outside the bounds of the tooltip or if
 * [TooltipState.dismiss] is called. When isPersistent is false, the tooltip will dismiss after
 * a short duration. Ideally, this should be set to true when there is actionable content
 * being displayed within a tooltip.
 * @param mutatorMutex [MutatorMutex] used to ensure that for all of the tooltips associated
 * with the mutator mutex, only one will be shown on the screen at any time.
 */
public fun TooltipState(
    initialIsVisible: Boolean = false,
    isPersistent: Boolean = true,
    mutatorMutex: MutatorMutex = BasicTooltipDefaults.GlobalMutatorMutex,
): TooltipState = TooltipStateImpl(
    initialIsVisible = initialIsVisible,
    isPersistent = isPersistent,
    mutatorMutex = mutatorMutex,
)

@Stable
private class TooltipStateImpl(
    initialIsVisible: Boolean,
    override val isPersistent: Boolean,
    private val mutatorMutex: MutatorMutex,
) : TooltipState {
    override val transition: MutableTransitionState<Boolean> = MutableTransitionState(initialIsVisible)
    override val isVisible: Boolean
        get() = transition.currentState || transition.targetState

    /**
     * continuation used to clean up
     */
    private var job: (CancellableContinuation<Unit>)? = null

    /**
     * Show the tooltip associated with the current [BasicTooltipState].
     * When this method is called, all of the other tooltips associated
     * with [mutatorMutex] will be dismissed.
     *
     * @param mutatePriority [MutatePriority] to be used with [mutatorMutex].
     */
    override suspend fun show(
        mutatePriority: MutatePriority,
    ) {
        val cancellableShow: suspend () -> Unit = {
            suspendCancellableCoroutine { continuation ->
                transition.targetState = true
                job = continuation
            }
        }
        // Show associated tooltip for [TooltipDuration] amount of time
        // or until tooltip is explicitly dismissed depending on [isPersistent].
        mutatorMutex.mutate(mutatePriority) {
            try {
                if (isPersistent) {
                    cancellableShow()
                } else {
                    withTimeout(BasicTooltipDefaults.TooltipDuration) {
                        cancellableShow()
                    }
                }
            } finally {
                // timeout or cancellation has occurred
                // and we close out the current tooltip.
                dismiss()
            }
        }
    }

    /**
     * Dismiss the tooltip associated with
     * this [TooltipState] if it's currently being shown.
     */
    override fun dismiss() {
        transition.targetState = false
    }

    /**
     * Cleans up [mutatorMutex] when the tooltip associated
     * with this state leaves Composition.
     */
    override fun onDispose() {
        job?.cancel()
    }
}

/**
 * The state that is associated with a [TooltipBox].
 * Each instance of [TooltipBox] should have its own [TooltipState].
 */
public interface TooltipState : BasicTooltipState {
    /**
     * The current transition state of the tooltip.
     * Used to start the transition of the tooltip when fading in and out.
     */
    public val transition: MutableTransitionState<Boolean>
}

private fun Modifier.textVerticalPadding(
    subheadExists: Boolean,
    actionExists: Boolean,
): Modifier {
    return if (!subheadExists && !actionExists) {
        this.padding(vertical = PlainTooltipVerticalPadding)
    } else {
        this
            .paddingFromBaseline(top = HeightFromSubheadToTextFirstLine)
            .padding(bottom = TextBottomPadding)
    }
}

private fun Modifier.animateTooltip(
    transition: Transition<Boolean>,
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "animateTooltip"
        properties["transition"] = transition
    },
) {
    val scale by transition.animateFloat(
        transitionSpec = {
            if (false isTransitioningTo true) {
                // show tooltip
                tween(
                    durationMillis = TooltipFadeInDuration,
                    easing = LinearOutSlowInEasing,
                )
            } else {
                // dismiss tooltip
                tween(
                    durationMillis = TooltipFadeOutDuration,
                    easing = LinearOutSlowInEasing,
                )
            }
        },
        label = "tooltip transition: scaling",
    ) { if (it) 1f else 0.8f }
    val alpha by transition.animateFloat(
        transitionSpec = {
            if (false isTransitioningTo true) {
                // show tooltip
                tween(
                    durationMillis = TooltipFadeInDuration,
                    easing = LinearEasing,
                )
            } else {
                // dismiss tooltip
                tween(
                    durationMillis = TooltipFadeOutDuration,
                    easing = LinearEasing,
                )
            }
        },
        label = "tooltip transition: alpha",
    ) { if (it) 1f else 0f }
    this.graphicsLayer(
        scaleX = scale,
        scaleY = scale,
        alpha = alpha,
    )
}

private val SpacingBetweenTooltipAndAnchor = 4.dp
internal val TooltipMinHeight = 24.dp
internal val TooltipMinWidth = 40.dp
private val PlainTooltipMaxWidth = 200.dp
private val PlainTooltipVerticalPadding = 4.dp
private val PlainTooltipHorizontalPadding = 8.dp
private val PlainTooltipContentPadding = PaddingValues(PlainTooltipHorizontalPadding, PlainTooltipVerticalPadding)
private val HeightFromSubheadToTextFirstLine = 24.dp
private val TextBottomPadding = 16.dp

// No specification for fade in and fade out duration, so aligning it with the behavior for snack bar
internal const val TooltipFadeInDuration = 150
internal const val TooltipFadeOutDuration = 75
