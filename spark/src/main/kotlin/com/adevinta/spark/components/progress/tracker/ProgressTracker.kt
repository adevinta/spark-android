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
package com.adevinta.spark.components.progress.tracker

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MultiContentMeasurePolicy
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.IntentColor
import com.adevinta.spark.components.divider.Divider
import com.adevinta.spark.components.divider.VerticalDivider
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.progress.tracker.LayoutOrientation.Horizontal
import com.adevinta.spark.components.progress.tracker.LayoutOrientation.Vertical
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.LabelId
import com.adevinta.spark.icons.Check
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tokens.dim1
import com.adevinta.spark.tokens.disabled
import com.adevinta.spark.tokens.highlight
import com.adevinta.spark.tools.modifiers.ifTrue
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
@ExperimentalSparkApi
public fun ProgressTrackerRow(
    items: ImmutableList<ProgressStep>,
    modifier: Modifier = Modifier,
    intent: ProgressTrackerIntent = ProgressTrackerIntent.Basic,
    style: ProgressStyles = ProgressStyles.Outlined,
    size: ProgressSizes = ProgressSizes.Large,
    hasIndicatorContent: Boolean = true,
    onStepClick: ((index: Int) -> Unit)? = null,
    selectedStep: Int = 0,
) {
    ProgressTracker(
        items = items,
        orientation = Horizontal,
        modifier = modifier,
        intent = intent,
        style = style,
        size = size,
        hasIndicatorContent = hasIndicatorContent,
        onStepClick = onStepClick,
        selectedStep = selectedStep,
    )
}

@Composable
@ExperimentalSparkApi
public fun ProgressTrackerColumn(
    items: ImmutableList<ProgressStep>,
    modifier: Modifier = Modifier,
    intent: ProgressTrackerIntent = ProgressTrackerIntent.Basic,
    style: ProgressStyles = ProgressStyles.Outlined,
    size: ProgressSizes = ProgressSizes.Large,
    hasIndicatorContent: Boolean = true,
    onStepClick: ((index: Int) -> Unit)? = null,
    selectedStep: Int = 0,
) {
    ProgressTracker(
        items = items,
        orientation = Vertical,
        modifier = modifier,
        intent = intent,
        style = style,
        size = size,
        hasIndicatorContent = hasIndicatorContent,
        onStepClick = onStepClick,
        selectedStep = selectedStep,
    )
}

@Composable
private fun ProgressTracker(
    items: ImmutableList<ProgressStep>,
    orientation: LayoutOrientation,
    modifier: Modifier = Modifier,
    intent: ProgressTrackerIntent = ProgressTrackerIntent.Basic,
    style: ProgressStyles = ProgressStyles.Outlined,
    size: ProgressSizes = ProgressSizes.Large,
    hasIndicatorContent: Boolean = true,
    onStepClick: ((index: Int) -> Unit)? = null,
    selectedStep: Int = 0,
) {
    require(items.size in 2..6) {
        val baseMessage = if (items.size < 2) {
            "At least two progress indicators should be displayed"
        } else {
            "If a process needs more than six steps, consider simplifying the process or breaking it up " +
                "into multiple tasks"
        }
        baseMessage + " Found ${items.size} steps."
    }
    val colors = intent.colors()

    val progressTracks = @Composable {
        items.fastForEachIndexed { index, progressStep ->
            // Since the track is layouted after the step, we need to check the next step to know if the track
            // should be enabled
            val nextIndex = (index + 1).coerceAtMost(items.size - 1)
            val nextStep = items[nextIndex]
            ProgressTrack(
                enabled = progressStep.enabled && nextStep.enabled,
                color = colors.color,
                orientation = orientation,
            )
        }
    }

    val interactionSources = remember(items.size) { items.map { MutableInteractionSource() } }

    val stepLabels = @Composable {
        items.fastForEachIndexed { index, progressStep ->
            StepLabel(
                label = progressStep.label,
                enabled = progressStep.enabled,
                orientation = orientation,
                size = size,
                selected = index == selectedStep,
                interactionSource = interactionSources[index],
                onClick = { onStepClick?.invoke(index) },
            )
        }
    }
    val stepIndicators = @Composable {
        items.forEachIndexed { index, progressStep ->
            val isDone = index < selectedStep
            StepIndicator(
                colors = colors,
                size = size,
                style = style,
                index = index,
                enabled = progressStep.enabled,
                selected = index == selectedStep,
                done = isDone,
                hasIndicatorContent = hasIndicatorContent,
                onClick = onStepClick?.let {
                    { onStepClick.invoke(index) }
                },
                interactionSource = interactionSources[index],
            )
        }
    }
    val measurePolicy = progressTrackerMeasurePolicy(orientation, size.size)
    ProvideTextStyle(value = SparkTheme.typography.body2.highlight) {
        Layout(
            modifier = modifier
                .selectableGroup()
                .sparkUsageOverlay(),
            measurePolicy = measurePolicy,
            contents = listOf(progressTracks, stepLabels, stepIndicators),
        )
    }
}

/**
 * [Row] will be [Horizontal], [Column] is [Vertical].
 */
internal enum class LayoutOrientation {
    Horizontal,
    Vertical,
}

private val DefaultRowMeasurePolicy: MultiContentMeasurePolicy = ProgressTrackerMeasurePolicy(
    orientation = Horizontal,
    arrangementSpacing = 8.dp,
    indicatorSize = ProgressSizes.Large.size,
)

private val DefaultColumnMeasurePolicy: MultiContentMeasurePolicy = ProgressTrackerMeasurePolicy(
    orientation = Vertical,
    arrangementSpacing = 8.dp,
    indicatorSize = ProgressSizes.Large.size,
)

@Composable
internal fun progressTrackerMeasurePolicy(
    orientation: LayoutOrientation,
    indicatorSize: Dp,
): MultiContentMeasurePolicy {
    return if (indicatorSize == ProgressSizes.Large.size && orientation == Horizontal) {
        DefaultRowMeasurePolicy
    } else if (indicatorSize == ProgressSizes.Large.size && orientation == Vertical) {
        DefaultColumnMeasurePolicy
    } else {
        ProgressTrackerMeasurePolicy(
            orientation = orientation,
            arrangementSpacing = 8.dp,
            indicatorSize = indicatorSize,
        )
    }
}

@Composable
private fun StepLabel(
    onClick: () -> Unit,
    orientation: LayoutOrientation,
    size: ProgressSizes,
    modifier: Modifier = Modifier,
    label: CharSequence = "",
    selected: Boolean = false,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    if (label.isBlank()) return Spacer(modifier = Modifier.size(0.dp))
    val labelColor by animateColorAsState(
        targetValue = if (enabled) SparkTheme.colors.onSurface else SparkTheme.colors.onSurface.dim1,
        label = "Label color",
    )
    CompositionLocalProvider(LocalContentColor provides labelColor) {
        val labelModifier = modifier
            .layoutId(LabelId)
            .paddingFromBaseline(top = 16.dp)
            .ifTrue(size == ProgressSizes.Large) {
                selectable(
                    selected = selected,
                    interactionSource = interactionSource,
                    indication = LocalIndication.current,
                    enabled = enabled,
                ) {
                    onClick()
                }
            }
        val textAlign = if (orientation == Horizontal) TextAlign.Center else TextAlign.Start
        when (label) {
            is AnnotatedString -> Text(
                text = label,
                textAlign = textAlign,
                modifier = labelModifier,
            )

            else -> Text(
                text = label.toString(),
                textAlign = textAlign,
                modifier = labelModifier,
            )
        }
    }
}

@Composable
private fun ProgressTrack(
    color: Color,
    orientation: LayoutOrientation,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val trackColor by animateColorAsState(
        targetValue = if (enabled) color else color.disabled,
        label = "Track color",
    )
    if (orientation == Horizontal) {
        Divider(modifier = modifier, color = trackColor)
    } else {
        VerticalDivider(modifier = modifier, color = trackColor)
    }
}

@Composable
private fun StepIndicator(
    colors: IntentColor,
    size: ProgressSizes,
    style: ProgressStyles,
    index: Int,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selected: Boolean = true,
    done: Boolean = false,
    hasIndicatorContent: Boolean = true,
    onClick: (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val elevation = animateStepElevation(enabled, style, interactionSource).value
    val isOutlined = style == ProgressStyles.Outlined
    val indicatorColor by animateColorAsState(
        targetValue = if (selected) {
            if (isOutlined) colors.containerColor else colors.color
        } else {
            if (isOutlined) Color.Transparent else colors.containerColor
        },
        label = "Indicator color",
    )
    val indicatorAlpha by animateFloatAsState(
        targetValue = if (enabled) 1f else SparkTheme.colors.dim3,
        label = "Indicator color",
    )
    val borderSize by animateDpAsState(
        targetValue = if (isOutlined) 1.dp else 0.dp,
        label = "Border size",
    )

    Surface(
        shape = SparkTheme.shapes.full,
        modifier = modifier
            .graphicsLayer {
                alpha = indicatorAlpha
            }
            .size(size.size),
        color = indicatorColor,
        border = if (isOutlined) {
            BorderStroke(borderSize, colors.color)
        } else {
            null
        },
        elevation = elevation,
        enabled = enabled && size == ProgressSizes.Large,
        onClick = { onClick?.invoke() },
        interactionSource = interactionSource,
    ) {
        AnimatedVisibility(visible = size != ProgressSizes.Small && hasIndicatorContent) {
            Box(
                contentAlignment = Alignment.Center,
            ) {
                AnimatedContent(
                    targetState = done,
                    contentAlignment = Alignment.Center,
                    label = "Step status indicator",
                ) { isStepDone ->
                    if (isStepDone) {
                        Icon(
                            sparkIcon = SparkIcons.Check,
                            modifier = Modifier.size(16.dp),
                            contentDescription = null, // content description is handle on the Layout
                        )
                    } else {
                        val stepPosition = index + 1
                        Text(
                            text = "$stepPosition",
                            style = SparkTheme.typography.body2.highlight.copy(lineHeight = 16.sp),
                        )
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewProgressTracker() {
    PreviewTheme(padding = PaddingValues(0.dp)) {
        var selectedStep by remember { mutableIntStateOf(0) }
        val size = ProgressSizes.Medium
        ProgressTrackerRow(
            items = persistentListOf(
                ProgressStep("Lorem ipsume", false),
                ProgressStep("Lorem ipsume dolar sit amet", true),
                ProgressStep("Lorem ipsume", false),
                ProgressStep("Lorem ipsume", true),
                ProgressStep("Lorem ipsume", false),
            ),
            size = size,
            onStepClick = {
                selectedStep = it
            },
            selectedStep = selectedStep,
        )
        ProgressTrackerColumn(
            items = persistentListOf(
                ProgressStep(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
                        "ut labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation.",
                    true,
                ),
                ProgressStep(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
                        "ut labore et dolore magna aliqua.",
                    true,
                ),
                ProgressStep("Lorem ipsume dolar sit amet", true),
            ),
            size = size,
            onStepClick = {
                selectedStep = it
            },
            selectedStep = selectedStep,
        )
    }
}

@Composable
@Preview
private fun PreviewProgressSizes() {
    PreviewTheme(padding = PaddingValues(0.dp)) {
        var selectedStep by remember { mutableIntStateOf(1) }
        val items = persistentListOf(
            ProgressStep("Lorem ipsume", true),
            ProgressStep("Lorem ipsume dolar sit amet", true),
            ProgressStep("Lorem ipsume", false),
        )
        ProgressTrackerRow(
            items = items,
            size = ProgressSizes.Large,
            onStepClick = {
                selectedStep = it
            },
            selectedStep = selectedStep,
        )
        ProgressTrackerRow(
            items = items,
            size = ProgressSizes.Medium,
            onStepClick = {
                selectedStep = it
            },
            selectedStep = selectedStep,
        )
        ProgressTrackerRow(
            items = items,
            size = ProgressSizes.Small,
            onStepClick = {
                selectedStep = it
            },
            selectedStep = selectedStep,
        )
    }
}

@Composable
@Preview
private fun PreviewProgressStyles() {
    PreviewTheme(padding = PaddingValues(0.dp)) {
        var selectedStep by remember { mutableIntStateOf(1) }
        val items = persistentListOf(
            ProgressStep("Lorem ipsume", true),
            ProgressStep("Lorem ipsume dolar sit amet", true),
            ProgressStep("Lorem ipsume", false),
        )
        ProgressTrackerRow(
            items = items,
            size = ProgressSizes.Large,
            style = ProgressStyles.Tinted,
            onStepClick = {
                selectedStep = it
            },
            selectedStep = selectedStep,
        )
        ProgressTrackerRow(
            items = items,
            size = ProgressSizes.Medium,
            style = ProgressStyles.Tinted,
            onStepClick = {
                selectedStep = it
            },
            selectedStep = selectedStep,
        )
        ProgressTrackerRow(
            items = items,
            size = ProgressSizes.Small,
            style = ProgressStyles.Tinted,
            onStepClick = {
                selectedStep = it
            },
            selectedStep = selectedStep,
        )
    }
}
