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
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.compose.ui.util.fastMaxOfOrNull
import androidx.compose.ui.util.fastSumBy
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.IntentColor
import com.adevinta.spark.components.badge.BadgeIntent
import com.adevinta.spark.components.divider.Divider
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.LabelId
import com.adevinta.spark.icons.Check
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tokens.dim1
import com.adevinta.spark.tokens.disabled
import com.adevinta.spark.tokens.highlight
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
internal fun ProgressTrackerRow(
    items: ImmutableList<ProgressStep>,
    modifier: Modifier = Modifier,
    intent: BadgeIntent = BadgeIntent.Basic,
    onStepClick: ((index: Int) -> Unit)? = null,
    selectedStep: Int = 0,
) {
    val colors = intent.colors()

    val progressTracks = @Composable {
        items.forEach {
            ProgressTrack(enabled = it.enabled, color = colors.color)
        }
    }

    val interactionSource = remember { MutableInteractionSource() }

    val stepLabels = @Composable {
        items.fastForEachIndexed { index, progressStep ->
            StepLabel(
                label = progressStep.label,
                enabled = progressStep.enabled,
                selected = index == selectedStep,
                interactionSource = interactionSource,
                onClick = { onStepClick?.invoke(index) },
            )
        }
    }
    val stepIndicators = @Composable {
        items.forEachIndexed { index, progressStep ->
            val isDone = index < selectedStep
            StepIndicator(
                colors = colors,
                index = index,
                enabled = progressStep.enabled,
                done = isDone,
                onClick = onStepClick?.let {
                    { onStepClick.invoke(index) }
                },
                interactionSource = interactionSource,
            )
        }
    }
    Layout(
        modifier = modifier.selectableGroup(),
        contents = listOf(progressTracks, stepLabels, stepIndicators),
    ) {
            (trackMeasurables, labelMeasurables, indicatorMeasurables),
            constraints,
        ->

        val stepsCount = indicatorMeasurables.size
        // Calculate the width of each step, taking into account the padding between steps
        val stepsWidth = (constraints.maxWidth / stepsCount) /*- (16.dp.roundToPx() * stepsCount - 1)*/
        // Measure each label to fit within the calculated step width
        val labelPlaceables = labelMeasurables.map {
            it.measure(constraints.copy(minWidth = stepsWidth, maxWidth = stepsWidth))
        }
        // Each indicator  have a fixed size coming from the size object
        val indicatorSize = 32.dp.roundToPx()
        val indicatorPlaceables = indicatorMeasurables.map {
            it.measure(Constraints.fixed(indicatorSize, indicatorSize))
        }

        // Calculate the width of the track, taking into account the width of the indicators and padding
        val trackWidth = stepsWidth - (indicatorPlaceables.first().width + 16.dp.roundToPx())
        val trackPlaceables = trackMeasurables.map {
            it.measure(constraints.copy(minWidth = trackWidth, maxWidth = trackWidth))
        }

        val totalWidth = labelPlaceables.fastSumBy(Placeable::width)

        val labelTopPadding = 16.dp.roundToPx()
        // Calculate height of the layout by taking into account the height maximum height of all labels, indicator
        // and padding
        val totalHeight = labelPlaceables.fastMaxOfOrNull(Placeable::height)
            ?.plus(16.dp.roundToPx())
            ?.plus(indicatorPlaceables.first().width) ?: 0
        layout(
            width = totalWidth,
            height = totalHeight,
        ) {
            indicatorPlaceables.fastForEachIndexed { index, indicatorPlaceable ->
                // Center the indicator horizontaly and place it at the top of the layout
                val indicatorX = (stepsWidth * index) + stepsWidth / 2 - indicatorPlaceable.width / 2
                indicatorPlaceable.placeRelative(
                    x = indicatorX,
                    y = 0,
                )
                labelPlaceables[index].placeRelative(
                    x = stepsWidth * index,
                    y = indicatorPlaceable.height + labelTopPadding, // centered
                )
                if (index < indicatorPlaceables.size - 1) {
                    trackPlaceables[index].placeRelative(
                        x = indicatorX + indicatorPlaceable.width + 8.dp.roundToPx(),
                        y = indicatorPlaceable.width / 2,
                    )
                }
            }
        }
    }
}

@Composable
private fun StepLabel(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    label: CharSequence = "",
    selected: Boolean = false,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val labelColor by animateColorAsState(
        targetValue = if (enabled) SparkTheme.colors.onSurface else SparkTheme.colors.onSurface.dim1,
        label = "Label color",
    )
    CompositionLocalProvider(LocalContentColor provides labelColor) {
        ProvideTextStyle(value = SparkTheme.typography.body2.highlight) {
            val labelModifier = modifier
                .layoutId(LabelId)
                .paddingFromBaseline(top = 16.dp)
                .selectable(
                    selected = selected,
                    interactionSource = interactionSource,
                    indication = LocalIndication.current,
                    enabled = enabled,
                ) {
                    onClick()
                }
            when (label) {
                is AnnotatedString -> Text(
                    text = label,
                    textAlign = TextAlign.Center,
                    modifier = labelModifier,
                )

                else -> Text(
                    text = label.toString(),
                    textAlign = TextAlign.Center,
                    modifier = labelModifier,
                )
            }
        }
    }
}

@Composable
private fun ProgressTrack(
    color: Color,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    val trackColor by animateColorAsState(
        targetValue = if (enabled) color else color.disabled,
        label = "Track color",
    )
    Divider(modifier = modifier, color = trackColor)
}

@Composable
private fun StepIndicator(
    colors: IntentColor,
    modifier: Modifier = Modifier,
    index: Int? = null,
    enabled: Boolean = true,
    done: Boolean = false,
    onClick: (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val elevation = animateStepElevation(enabled, interactionSource).value

    Surface(
        shape = SparkTheme.shapes.full,
        modifier = modifier,
        color = colors.containerColor,
        elevation = elevation,
        enabled = enabled,
        onClick = { onClick?.invoke() },
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            AnimatedContent(
                targetState = done,
                label = "Step status indicator",
            ) { isStepDone ->
                if (isStepDone) {
                    Icon(
                        sparkIcon = SparkIcons.Check,
                        modifier = Modifier
                            .size(16.dp)
                            .align(Alignment.Center),
                        contentDescription = null, // content description is handle on the Layout
                    )
                } else {
                    index?.let {
                        val stepPosition = it + 1
                        Text(text = "$stepPosition")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewProgressStep() {
    PreviewTheme(padding = PaddingValues(0.dp)) {
        var selectedStep by remember { mutableIntStateOf(0) }
        ProgressTrackerRow(
            items = persistentListOf(
                ProgressStep("Lorem ipsume", true),
                ProgressStep("Lorem ipsume dolar sit amet", true),
                ProgressStep("Lorem ipsume", true),
            ),
            onStepClick = {
                selectedStep = it
            },
            selectedStep = selectedStep,
        )
    }
}
