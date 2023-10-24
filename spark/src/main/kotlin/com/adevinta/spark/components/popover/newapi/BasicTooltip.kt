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

import android.annotation.SuppressLint
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.MutatorMutex
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.onLongClick
import androidx.compose.ui.semantics.paneTitle
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * This class is copied from Material design 3 compose open source library
 * TODO: Please remove it after the library reaches to 1.2.0 stable version
 */

/**
 * BasicTooltipBox that wraps a composable with a tooltip.
 *
 * Tooltip that provides a descriptive message for an anchor.
 * It can be used to call the users attention to the anchor.
 *
 * @param positionProvider [PopupPositionProvider] that will be used to place the tooltip
 * relative to the anchor content.
 * @param tooltip the composable that will be used to populate the tooltip's content.
 * @param state handles the state of the tooltip's visibility.
 * @param modifier the [Modifier] to be applied to this BasicTooltipBox.
 * @param focusable [Boolean] that determines if the tooltip is focusable. When true,
 * the tooltip will consume touch events while it's shown and will have accessibility
 * focus move to the first element of the component. When false, the tooltip
 * won't consume touch events while it's shown but assistive-tech users will need
 * to swipe or drag to get to the first element of the component.
 * @param enableUserInput [Boolean] which determines if this BasicTooltipBox will handle
 * long press and mouse hover to trigger the tooltip through the state provided.
 * @param content the composable that the tooltip will anchor to.
 */
@Composable
public fun BasicTooltipBox(
    positionProvider: PopupPositionProvider,
    tooltip: @Composable () -> Unit,
    state: BasicTooltipState,
    @SuppressLint("ComposeModifierWithoutDefault") modifier: Modifier,
    focusable: Boolean,
    enableUserInput: Boolean,
    content: @Composable () -> Unit,
) {
    val scope = rememberCoroutineScope()
    Box {
        if (state.isVisible) {
            TooltipPopup(
                positionProvider = positionProvider,
                state = state,
                scope = scope,
                focusable = focusable,
                content = tooltip,
            )
        }
        WrappedAnchor(
            enableUserInput = enableUserInput,
            state = state,
            modifier = modifier,
            content = content,
        )
    }
    DisposableEffect(state) {
        onDispose { state.onDispose() }
    }
}

@Composable
private fun WrappedAnchor(
    enableUserInput: Boolean,
    state: BasicTooltipState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val longPressLabel = "label"
    Box(
        modifier = modifier
            .handleGestures(enableUserInput, state)
            .anchorSemantics(longPressLabel, enableUserInput, state, scope),
    ) { content() }
}

@Composable
private fun TooltipPopup(
    positionProvider: PopupPositionProvider,
    state: BasicTooltipState,
    scope: CoroutineScope,
    focusable: Boolean,
    content: @Composable () -> Unit,
) {
    val tooltipDescription = ""
    Popup(
        popupPositionProvider = positionProvider,
        onDismissRequest = {
            if (state.isVisible) {
                scope.launch { state.dismiss() }
            }
        },
        properties = PopupProperties(focusable = focusable),
    ) {
        Box(
            modifier = Modifier.semantics {
                liveRegion = LiveRegionMode.Assertive
                paneTitle = tooltipDescription
            },
        ) { content() }
    }
}

private fun Modifier.handleGestures(
    enabled: Boolean,
    state: BasicTooltipState,
): Modifier = if (enabled) {
    this
        .pointerInput(state) {
            coroutineScope {
                awaitEachGesture {
                    val longPressTimeout = viewConfiguration.longPressTimeoutMillis
                    val pass = PointerEventPass.Initial
                    // wait for the first down press
                    val inputType = awaitFirstDown(pass = pass).type
                    if (inputType == PointerType.Touch || inputType == PointerType.Stylus) {
                        try {
                            // listen to if there is up gesture
                            // within the longPressTimeout limit
                            withTimeout(longPressTimeout) {
                                waitForUpOrCancellation(pass = pass)
                            }
                        } catch (_: PointerEventTimeoutCancellationException) {
                            // handle long press - Show the tooltip
                            launch { state.show(MutatePriority.UserInput) }
                            // consume the children's click handling
                            val changes = awaitPointerEvent(pass = pass).changes
                            for (i in 0 until changes.size) {
                                changes[i].consume()
                            }
                        }
                    }
                }
            }
        }
        .pointerInput(state) {
            coroutineScope {
                awaitPointerEventScope {
                    val pass = PointerEventPass.Main
                    while (true) {
                        val event = awaitPointerEvent(pass)
                        val inputType = event.changes[0].type
                        if (inputType == PointerType.Mouse) {
                            when (event.type) {
                                PointerEventType.Enter -> {
                                    launch { state.show(MutatePriority.UserInput) }
                                }

                                PointerEventType.Exit -> {
                                    state.dismiss()
                                }
                            }
                        }
                    }
                }
            }
        }
} else {
    this
}

private fun Modifier.anchorSemantics(
    label: String,
    enabled: Boolean,
    state: BasicTooltipState,
    scope: CoroutineScope,
): Modifier = if (enabled) {
    this.semantics(mergeDescendants = true) {
        onLongClick(
            label = label,
            action = {
                scope.launch { state.show() }
                true
            },
        )
    }
} else {
    this
}

/**
 * The state that is associated with an instance of a tooltip.
 * Each instance of tooltips should have its own [BasicTooltipState].
 */
@Stable
public interface BasicTooltipState {
    /**
     * [Boolean] that indicates if the tooltip is currently being shown or not.
     */
    public val isVisible: Boolean

    /**
     * [Boolean] that determines if the tooltip associated with this
     * will be persistent or not. If isPersistent is true, then the tooltip will
     * only be dismissed when the user clicks outside the bounds of the tooltip or if
     * [BasicTooltipState.dismiss] is called. When isPersistent is false, the tooltip will
     * dismiss after a short duration. Ideally, this should be set to true when there
     * is actionable content being displayed within a tooltip.
     */
    public val isPersistent: Boolean

    /**
     * Show the tooltip associated with the current [BasicTooltipState].
     * When this method is called all of the other tooltips currently
     * being shown will dismiss.
     *
     * @param mutatePriority [MutatePriority] to be used.
     */
    public suspend fun show(mutatePriority: MutatePriority = MutatePriority.Default)

    /**
     * Dismiss the tooltip associated with
     * this [BasicTooltipState] if it's currently being shown.
     */
    public fun dismiss()

    /**
     * Clean up when the this state leaves Composition.
     */
    public fun onDispose()
}

/**
 * BasicTooltip defaults that contain default values for tooltips created.
 */
public object BasicTooltipDefaults {
    /**
     * The global/default [MutatorMutex] used to sync Tooltips.
     */
    public val GlobalMutatorMutex: MutatorMutex = MutatorMutex()

    /**
     * The default duration, in milliseconds, that non-persistent tooltips
     * will show on the screen before dismissing.
     */
    public const val TooltipDuration: Long = 1500L
}
