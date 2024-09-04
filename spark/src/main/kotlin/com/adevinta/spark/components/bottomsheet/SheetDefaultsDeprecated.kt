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
package com.adevinta.spark.components.bottomsheet

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.bottomsheet.SheetValue.Expanded
import com.adevinta.spark.components.bottomsheet.SheetValue.Hidden
import com.adevinta.spark.components.bottomsheet.SheetValue.PartiallyExpanded
import com.adevinta.spark.components.bottomsheet.layout.SwipeableV2Defaults
import com.adevinta.spark.components.bottomsheet.layout.SwipeableV2State
import kotlinx.coroutines.CancellationException

/**
 * State of a sheet composable, such as [ModalBottomSheet]
 *
 * Contains states relating to it's swipe position as well as animations between state values.
 *
 * @param skipPartiallyExpanded Whether the partially expanded state, if the sheet is large
 * enough, should be skipped. If true, the sheet will always expand to the [Expanded] state and move
 * to the [Hidden] state if available when hiding the sheet, either programmatically or by user
 * interaction.
 * @param initialValue The initial value of the state.
 * @param confirmValueChange Optional callback invoked to confirm or veto a pending state change.
 * @param skipHiddenState Whether the hidden state should be skipped. If true, the sheet will always
 * expand to the [Expanded] state and move to the [PartiallyExpanded] if available, either
 * programmatically or by user interaction.
 */
@Stable
@ExperimentalMaterial3Api
public class SheetState(
    internal val skipPartiallyExpanded: Boolean,
    initialValue: SheetValue = Hidden,
    confirmValueChange: (SheetValue) -> Boolean = { true },
    internal val skipHiddenState: Boolean = false,
) {
    init {
        if (skipPartiallyExpanded) {
            require(initialValue != PartiallyExpanded) {
                "The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded " +
                    "is set to true."
            }
        }
        if (skipHiddenState) {
            require(initialValue != Hidden) {
                "The initial value must not be set to Hidden if skipHiddenState is set to true."
            }
        }
    }

    /**
     * The current value of the state.
     *
     * If no swipe or animation is in progress, this corresponds to the state the bottom sheet is
     * currently in. If a swipe or an animation is in progress, this corresponds the state the sheet
     * was in before the swipe or animation started.
     */

    public val currentValue: SheetValue get() = swipeableState.currentValue

    /**
     * The target value of the bottom sheet state.
     *
     * If a swipe is in progress, this is the value that the sheet would animate to if the
     * swipe finishes. If an animation is running, this is the target value of that animation.
     * Finally, if no swipe or animation is in progress, this is the same as the [currentValue].
     */
    public val targetValue: SheetValue get() = swipeableState.targetValue

    /**
     * Whether the modal bottom sheet is visible.
     */
    public val isVisible: Boolean
        get() = swipeableState.currentValue != Hidden

    /**
     * Require the current offset (in pixels) of the bottom sheet.
     *
     * The offset will be initialized during the first measurement phase of the provided sheet
     * content.
     *
     * These are the phases:
     * Composition { -> Effects } -> Layout { Measurement -> Placement } -> Drawing
     *
     * During the first composition, an [IllegalStateException] is thrown. In subsequent
     * compositions, the offset will be derived from the anchors of the previous pass. Always prefer
     * accessing the offset from a LaunchedEffect as it will be scheduled to be executed the next
     * frame, after layout.
     *
     * @throws IllegalStateException If the offset has not been initialized yet
     */
    public fun requireOffset(): Float = swipeableState.requireOffset()

    /**
     * Whether the sheet has an expanded state defined.
     */

    public val hasExpandedState: Boolean
        get() = swipeableState.hasAnchorForValue(Expanded)

    /**
     * Whether the modal bottom sheet has a partially expanded state defined.
     */
    internal val hasPartiallyExpandedState: Boolean
        get() = swipeableState.hasAnchorForValue(PartiallyExpanded)

    /**
     * Fully expand the bottom sheet with animation and suspend until it is fully expanded or
     * animation has been cancelled.
     * *
     * @throws [CancellationException] if the animation is interrupted
     */
    public suspend fun expand() {
        swipeableState.animateTo(Expanded)
    }

    /**
     * Animate the bottom sheet and suspend until it is partially expanded or animation has been
     * cancelled.
     * @throws [CancellationException] if the animation is interrupted
     * @throws [IllegalStateException] if [skipPartiallyExpanded] is set to true
     */
    public suspend fun partialExpand() {
        check(!skipPartiallyExpanded) {
            "Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set" +
                " skipPartiallyExpanded to false to use this function."
        }
        animateTo(PartiallyExpanded)
    }

    /**
     * Expand the bottom sheet with animation and suspend until it is [PartiallyExpanded] if defined
     * else [Expanded].
     * @throws [CancellationException] if the animation is interrupted
     */
    public suspend fun show() {
        val targetValue = when {
            hasPartiallyExpandedState -> PartiallyExpanded
            else -> Expanded
        }
        animateTo(targetValue)
    }

    /**
     * Hide the bottom sheet with animation and suspend until it is fully hidden or animation has
     * been cancelled.
     * @throws [CancellationException] if the animation is interrupted
     */
    public suspend fun hide() {
        check(!skipHiddenState) {
            "Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState" +
                " to false to use this function."
        }
        animateTo(Hidden)
    }

    /**
     * Animate to a [targetValue].
     * If the [targetValue] is not in the set of anchors, the [currentValue] will be updated to the
     * [targetValue] without updating the offset.
     *
     * @throws CancellationException if the interaction interrupted by another interaction like a
     * gesture interaction or another programmatic interaction like a [animateTo] or [snapTo] call.
     *
     * @param targetValue The target value of the animation
     */
    internal suspend fun animateTo(
        targetValue: SheetValue,
        velocity: Float = swipeableState.lastVelocity,
    ) {
        swipeableState.animateTo(targetValue, velocity)
    }

    /**
     * Snap to a [targetValue] without any animation.
     *
     * @throws CancellationException if the interaction interrupted by another interaction like a
     * gesture interaction or another programmatic interaction like a [animateTo] or [snapTo] call.
     *
     * @param targetValue The target value of the animation
     */
    internal suspend fun snapTo(targetValue: SheetValue) {
        swipeableState.snapTo(targetValue)
    }

    /**
     * Find the closest anchor taking into account the velocity and settle at it with an animation.
     */
    internal suspend fun settle(velocity: Float) {
        swipeableState.settle(velocity)
    }

    internal var swipeableState = SwipeableV2State(
        initialValue = initialValue,
        animationSpec = SwipeableV2Defaults.AnimationSpec,
        confirmValueChange = confirmValueChange,
    )

    internal val offset: Float? get() = swipeableState.offset

    public companion object {
        /**
         * The default [Saver] implementation for [SheetState].
         */
        @Suppress("ktlint:standard:function-naming")
        public fun Saver(
            skipPartiallyExpanded: Boolean,
            confirmValueChange: (SheetValue) -> Boolean,
        ): Saver<SheetState, SheetValue> = Saver(
            save = { it.currentValue },
            restore = { savedValue ->
                SheetState(skipPartiallyExpanded, savedValue, confirmValueChange)
            },
        )
    }
}

/**
 * Possible values of [SheetState].
 */
@ExperimentalMaterial3Api
public enum class SheetValue {
    /**
     * The sheet is not visible.
     */
    Hidden,

    /**
     * The sheet is visible at full height.
     */
    Expanded,

    /**
     * The sheet is partially visible.
     */
    PartiallyExpanded,
}

/**
 * Contains the default values used by [ModalBottomSheet] and [BottomSheetScaffold].
 */
@Stable
@ExperimentalMaterial3Api
public object BottomSheetDefaults {
    /** The default shape for bottom sheets in a [Hidden] state. */
    public val HiddenShape: Shape
        @Composable get() = SparkTheme.shapes.none

    /** The default shape for a bottom sheets in [PartiallyExpanded] and [Expanded] states. */
    public val ExpandedShape: Shape
        @Composable get() = SparkTheme.shapes.extraLarge.copy(
            bottomStart = CornerSize(0.dp),
            bottomEnd = CornerSize(0.dp),
        )

    /** The default container color for a bottom sheet. */
    public val ContainerColor: Color
        @Composable get() = SparkTheme.colors.surface

    /** The default elevation for a bottom sheet. */
    public val Elevation: Dp = 1.0.dp

    /** The default color of the scrim overlay for background content. */
    public val ScrimColor: Color
        @Composable get() = SparkTheme.colors.onSurface.copy(alpha = 0.32f)

    /**
     * The default peek height used by [BottomSheetScaffold].
     */
    public val SheetPeekHeight: Dp = 56.dp
}

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ktlint:standard:function-naming")
internal fun consumeSwipeWithinBottomSheetBoundsNestedScrollConnection(
    sheetState: SheetState,
    orientation: Orientation,
    onFling: (velocity: Float) -> Unit,
): NestedScrollConnection = object : NestedScrollConnection {
    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
        val delta = available.toFloat()
        return if (delta < 0 && source == NestedScrollSource.Drag) {
            sheetState.swipeableState.dispatchRawDelta(delta).toOffset()
        } else {
            Offset.Zero
        }
    }

    override fun onPostScroll(
        consumed: Offset,
        available: Offset,
        source: NestedScrollSource,
    ): Offset {
        return if (source == NestedScrollSource.Drag) {
            sheetState.swipeableState.dispatchRawDelta(available.toFloat()).toOffset()
        } else {
            Offset.Zero
        }
    }

    override suspend fun onPreFling(available: Velocity): Velocity {
        val toFling = available.toFloat()
        val currentOffset = sheetState.requireOffset()
        return if (toFling < 0 && currentOffset > sheetState.swipeableState.minOffset) {
            onFling(toFling)
            // since we go to the anchor with tween settling, consume all for the best UX
            available
        } else {
            Velocity.Zero
        }
    }

    override suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity {
        onFling(available.toFloat())
        return available
    }

    private fun Float.toOffset(): Offset = Offset(
        x = if (orientation == Orientation.Horizontal) this else 0f,
        y = if (orientation == Orientation.Vertical) this else 0f,
    )

    @JvmName("velocityToFloat")
    private fun Velocity.toFloat() = if (orientation == Orientation.Horizontal) x else y

    @JvmName("offsetToFloat")
    private fun Offset.toFloat(): Float = if (orientation == Orientation.Horizontal) x else y
}

@Composable
@ExperimentalMaterial3Api
internal fun rememberSheetState(
    skipPartiallyExpanded: Boolean = false,
    confirmValueChange: (SheetValue) -> Boolean = { true },
    initialValue: SheetValue = Hidden,
    skipHiddenState: Boolean = false,
): SheetState {
    return rememberSaveable(
        skipPartiallyExpanded,
        confirmValueChange,
        saver = SheetState.Saver(
            skipPartiallyExpanded = skipPartiallyExpanded,
            confirmValueChange = confirmValueChange,
        ),
    ) {
        SheetState(skipPartiallyExpanded, initialValue, confirmValueChange, skipHiddenState)
    }
}

private val DragHandleVerticalPadding = 22.dp
internal val BottomSheetMaxWidth = 640.dp
