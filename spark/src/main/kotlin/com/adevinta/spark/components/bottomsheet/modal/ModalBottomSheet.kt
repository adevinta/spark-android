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
package com.adevinta.spark.components.bottomsheet.modal

import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.collapse
import androidx.compose.ui.semantics.dismiss
import androidx.compose.ui.semantics.expand
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.adevinta.spark.components.bottomsheet.AnchorChangeHandler
import com.adevinta.spark.components.bottomsheet.BottomSheetDefaults
import com.adevinta.spark.components.bottomsheet.BottomSheetMaxWidth
import com.adevinta.spark.components.bottomsheet.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection
import com.adevinta.spark.components.bottomsheet.SheetState
import com.adevinta.spark.components.bottomsheet.SheetValue
import com.adevinta.spark.components.bottomsheet.SheetValue.Expanded
import com.adevinta.spark.components.bottomsheet.SheetValue.Hidden
import com.adevinta.spark.components.bottomsheet.SheetValue.PartiallyExpanded
import com.adevinta.spark.components.bottomsheet.rememberSheetState
import com.adevinta.spark.components.bottomsheet.swipeAnchors
import com.adevinta.spark.components.buttons.ButtonFilled
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.list.ListItem
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.toggles.CheckboxLabelled
import com.adevinta.spark.icons.LikeFill
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tokens.contentColorFor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.max

/**
 *
 * Modal bottom sheets are used as an alternative to inline menus or simple dialogs on mobile,
 * especially when offering a long list of action items, or when items require longer descriptions
 * and icons. Like dialogs, modal bottom sheets appear in front of app content, disabling all other
 * app functionality when they appear, and remaining on screen until confirmed, dismissed, or a
 * required action has been taken.
 *
 *
 * @param onDismissRequest Executes when the user clicks outside of the bottom sheet, after sheet
 * animates to [Hidden].
 * @param modifier Optional [Modifier] for the bottom sheet.
 * @param sheetState The state of the bottom sheet.
 * @param content The content to be displayed inside the bottom sheet.
 */
@Composable
@ExperimentalMaterial3Api
public fun ModalBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(),
    content: @Composable ColumnScope.() -> Unit,
) {
    SparkModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = sheetState,
        content = content,
    )
}

/**
 * <a href="https://m3.material.io/components/bottom-sheets/overview" class="external" target="_blank">Material Design modal bottom sheet</a>.
 *
 * Modal bottom sheets are used as an alternative to inline menus or simple dialogs on mobile,
 * especially when offering a long list of action items, or when items require longer descriptions
 * and icons. Like dialogs, modal bottom sheets appear in front of app content, disabling all other
 * app functionality when they appear, and remaining on screen until confirmed, dismissed, or a
 * required action has been taken.
 *
 * ![Bottom sheet image](https://developer.android.com/images/reference/androidx/compose/material3/bottom_sheet.png)
 *
 * A simple example of a modal bottom sheet looks like this:
 *
 * @sample androidx.compose.material3.samples.ModalBottomSheetSample
 *
 * @param onDismissRequest Executes when the user clicks outside of the bottom sheet, after sheet
 * animates to [Hidden].
 * @param modifier Optional [Modifier] for the bottom sheet.
 * @param sheetState The state of the bottom sheet.
 * @param shape The shape of the bottom sheet.
 * @param containerColor The color used for the background of this bottom sheet
 * @param contentColor The preferred color for content inside this bottom sheet. Defaults to either
 * the matching content color for [containerColor], or to the current [LocalContentColor] if
 * [containerColor] is not a color from the theme.
 * @param tonalElevation The tonal elevation of this bottom sheet.
 * @param scrimColor Color of the scrim that obscures content when the bottom sheet is open.
 * @param dragHandle Optional visual marker to swipe the bottom sheet.
 * @param content The content to be displayed inside the bottom sheet.
 */

@Composable
@ExperimentalMaterial3Api
internal fun SparkModalBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(),
    shape: Shape = BottomSheetDefaults.ExpandedShape,
    containerColor: Color = BottomSheetDefaults.ContainerColor,
    contentColor: Color = contentColorFor(containerColor),
    tonalElevation: Dp = BottomSheetDefaults.Elevation,
    scrimColor: Color = BottomSheetDefaults.ScrimColor,
    dragHandle: @Composable (() -> Unit)? = {
        BottomSheetDefaults.DragHandle(Modifier.padding(vertical = 8.dp))
    },
    content: @Composable ColumnScope.() -> Unit,
) {
    val scope = rememberCoroutineScope()
    val animateToDismiss: () -> Unit = {
        if (sheetState.swipeableState.confirmValueChange(Hidden)) {
            scope.launch { sheetState.hide() }.invokeOnCompletion {
                if (!sheetState.isVisible) {
                    onDismissRequest()
                }
            }
        }
    }
    val settleToDismiss: (velocity: Float) -> Unit = {
        scope.launch { sheetState.settle(it) }.invokeOnCompletion {
            if (!sheetState.isVisible) onDismissRequest()
        }
    }

    // Callback that is invoked when the anchors have changed.
    val anchorChangeHandler = remember(sheetState, scope) {
        ModalBottomSheetAnchorChangeHandler(
            state = sheetState,
            animateTo = { target, velocity ->
                scope.launch { sheetState.animateTo(target, velocity = velocity) }
            },
            snapTo = { target -> scope.launch { sheetState.snapTo(target) } },
        )
    }
    val systemBarHeight = WindowInsets.systemBars.getBottom(LocalDensity.current)

    ModalBottomSheetPopup(
        onDismissRequest = {
            if (sheetState.currentValue == Expanded && sheetState.hasPartiallyExpandedState) {
                scope.launch { sheetState.partialExpand() }
            } else { // Is expanded without collapsed state or is collapsed.
                scope.launch { sheetState.hide() }.invokeOnCompletion { onDismissRequest() }
            }
        },
    ) {
        BoxWithConstraints(Modifier.fillMaxSize()) {
            val fullHeight = constraints.maxHeight
            Scrim(
                color = scrimColor,
                onDismissRequest = animateToDismiss,
                visible = sheetState.targetValue != Hidden,
            )
            Surface(
                modifier = modifier
                    .widthIn(max = BottomSheetMaxWidth)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .offset {
                        IntOffset(
                            0,
                            sheetState
                                .requireOffset()
                                .toInt(),
                        )
                    }
                    .nestedScroll(
                        remember(sheetState) {
                            ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(
                                sheetState = sheetState,
                                orientation = Orientation.Vertical,
                                onFling = settleToDismiss,
                            )
                        },
                    )
                    .modalBottomSheetSwipeable(
                        sheetState = sheetState,
                        anchorChangeHandler = anchorChangeHandler,
                        screenHeight = fullHeight.toFloat(),
                        bottomPadding = systemBarHeight.toFloat(),
                        onDragStopped = {
                            settleToDismiss(it)
                        },
                    ),
                shape = shape,
                color = containerColor,
                contentColor = contentColor,
                elevation = tonalElevation,
            ) {
                Column(Modifier.fillMaxWidth()) {
                    if (dragHandle != null) {
                        Box(
                            Modifier
                                .align(Alignment.CenterHorizontally)
                                .semantics(mergeDescendants = true) {
                                    // Provides semantics to interact with the bottomsheet based on its
                                    // current value.
                                    with(sheetState) {
                                        dismiss {
                                            animateToDismiss()
                                            true
                                        }
                                        if (currentValue == SheetValue.PartiallyExpanded) {
                                            expand {
                                                if (swipeableState.confirmValueChange(Expanded)) {
                                                    scope.launch { sheetState.expand() }
                                                }
                                                true
                                            }
                                        } else if (hasPartiallyExpandedState) {
                                            collapse {
                                                val confirmPartial =
                                                    swipeableState.confirmValueChange(SheetValue.PartiallyExpanded)
                                                if (confirmPartial) {
                                                    scope.launch { partialExpand() }
                                                }
                                                true
                                            }
                                        }
                                    }
                                },
                        ) {
                            dragHandle()
                        }
                    }
                    content()
                }
            }
        }
    }
    if (sheetState.hasExpandedState) {
        LaunchedEffect(sheetState) {
            sheetState.show()
        }
    }
}

/**
 * Create and [remember] a [SheetState] for [ModalBottomSheet].
 *
 * @param skipPartiallyExpanded Whether the partially expanded state, if the sheet is tall enough,
 * should be skipped. If true, the sheet will always expand to the [Expanded] state and move to the
 * [Hidden] state when hiding the sheet, either programmatically or by user interaction.
 * @param confirmValueChange Optional callback invoked to confirm or veto a pending state change.
 */
@Composable
@ExperimentalMaterial3Api
public fun rememberModalBottomSheetState(
    skipPartiallyExpanded: Boolean = false,
    initialValue: SheetValue = Hidden,
    confirmValueChange: (SheetValue) -> Boolean = { true },
): SheetState = rememberSheetState(skipPartiallyExpanded, confirmValueChange, initialValue)

@Composable
private fun Scrim(
    color: Color,
    onDismissRequest: () -> Unit,
    visible: Boolean,
) {
    if (color.isSpecified) {
        val alpha by animateFloatAsState(
            targetValue = if (visible) 1f else 0f,
            animationSpec = TweenSpec(),
        )
        val dismissSheet = if (visible) {
            Modifier
                .pointerInput(onDismissRequest) {
                    detectTapGestures {
                        onDismissRequest()
                    }
                }
                .clearAndSetSemantics {}
        } else {
            Modifier
        }
        Canvas(
            Modifier
                .fillMaxSize()
                .then(dismissSheet),
        ) {
            drawRect(color = color, alpha = alpha)
        }
    }
}

@ExperimentalMaterial3Api
private fun Modifier.modalBottomSheetSwipeable(
    sheetState: SheetState,
    anchorChangeHandler: AnchorChangeHandler<SheetValue>,
    screenHeight: Float,
    bottomPadding: Float,
    onDragStopped: CoroutineScope.(velocity: Float) -> Unit,
) = draggable(
    state = sheetState.swipeableState.swipeDraggableState,
    orientation = Orientation.Vertical,
    enabled = sheetState.isVisible,
    startDragImmediately = sheetState.swipeableState.isAnimationRunning,
    onDragStopped = onDragStopped,
).swipeAnchors(
    state = sheetState.swipeableState,
    anchorChangeHandler = anchorChangeHandler,
    possibleValues = setOf(Hidden, SheetValue.PartiallyExpanded, Expanded),
) { value, sheetSize ->
    when (value) {
        Hidden -> screenHeight + bottomPadding
        SheetValue.PartiallyExpanded -> when {
            sheetSize.height < screenHeight / 2 -> null
            sheetState.skipPartiallyExpanded -> null
            else -> screenHeight / 2f
        }

        Expanded -> if (sheetSize.height != 0) {
            max(0f, screenHeight - sheetSize.height)
        } else {
            null
        }
    }
}

@ExperimentalMaterial3Api
@Suppress("ktlint:standard:function-naming")
private fun ModalBottomSheetAnchorChangeHandler(
    state: SheetState,
    animateTo: (target: SheetValue, velocity: Float) -> Unit,
    snapTo: (target: SheetValue) -> Unit,
) = AnchorChangeHandler<SheetValue> { previousTarget, previousAnchors, newAnchors ->
    val previousTargetOffset = previousAnchors[previousTarget]
    val newTarget = when (previousTarget) {
        Hidden -> Hidden
        SheetValue.PartiallyExpanded, Expanded -> {
            val hasPartiallyExpandedState = newAnchors.containsKey(SheetValue.PartiallyExpanded)
            val newTarget = if (hasPartiallyExpandedState) {
                SheetValue.PartiallyExpanded
            } else if (newAnchors.containsKey(Expanded)) Expanded else Hidden
            newTarget
        }
    }
    val newTargetOffset = newAnchors.getValue(newTarget)
    if (newTargetOffset != previousTargetOffset) {
        if (state.swipeableState.isAnimationRunning || previousAnchors.isEmpty()) {
            // Re-target the animation to the new offset if it changed
            animateTo(newTarget, state.swipeableState.lastVelocity)
        } else {
            // Snap to the new offset value of the target if no animation was running
            snapTo(newTarget)
        }
    }
}

/**
 * Popup specific for modal bottom sheet.
 */
@Composable
@ExperimentalMaterial3Api
internal fun ModalBottomSheetPopup(
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit,
) = Popup(
    onDismissRequest = onDismissRequest,
    properties = PopupProperties(focusable = true),
    content = content,
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Preview(
    group = "BottomSheet",
    name = "ModalBottomSheet",
)
@Composable
private fun ModalBottomSheetSample() {
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    var skipPartiallyExpanded by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = skipPartiallyExpanded,
        initialValue = PartiallyExpanded,
    )

    // App content
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        CheckboxLabelled(
            state = if (skipPartiallyExpanded) ToggleableState.On else ToggleableState.Off,
            onClick = { skipPartiallyExpanded = !skipPartiallyExpanded },
        ) {
            Text("Skip Partially Expanded State")
        }

        ButtonFilled(
            text = "Show Bottom Sheet",
            onClick = { openBottomSheet = !openBottomSheet },
        )
    }

    // Sheet content
    if (openBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { openBottomSheet = false },
            sheetState = bottomSheetState,
        ) {
            LazyColumn {
                stickyHeader {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        // Note: If you provide logic outside of onDismissRequest to remove the sheet,
                        // you must additionally handle intended state cleanup, if any.
                        ButtonFilled(
                            text = "Hide Bottom Sheet",
                            onClick = {
                                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                    if (!bottomSheetState.isVisible) {
                                        openBottomSheet = false
                                    }
                                }
                            },
                        )
                    }
                }

                items(50) {
                    ListItem(
                        headlineContent = { Text("Item $it") },
                        leadingContent = {
                            Icon(
                                SparkIcons.LikeFill,
                                contentDescription = "Localized description",
                            )
                        },
                    )
                }
            }
        }
    }
}
