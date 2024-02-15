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
package com.adevinta.spark.components.slider

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SliderPositions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.lerp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tokens.dim3
import com.adevinta.spark.tokens.dim4
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import androidx.compose.material3.Slider as MaterialSlider

@OptIn(ExperimentalMaterial3Api::class)
@InternalSparkApi
@Composable
internal fun SparkSlider(
    value: Float,
    intent: SliderIntent,
    steps: Int,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    onValueChangeFinished: (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    handle: @Composable (SliderPositions) -> Unit = remember(interactionSource, enabled, intent, steps) {
        {
            Handle(
                interactionSource = interactionSource,
                intent = intent,
                enabled = enabled,
            )
        }
    },
    track: @Composable (SliderPositions) -> Unit = remember(interactionSource, enabled, intent, steps) {
        {
            Track(
                intent = intent,
                enabled = enabled,
                sliderPositions = it,
            )
        }
    },

) {
    MaterialSlider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        onValueChangeFinished = onValueChangeFinished,
        interactionSource = interactionSource,
        thumb = handle,
        track = track,
    )
}

private val HandleDefaultOutline = 1.dp
private val DefaultHandleSizeInnerWidth = 24.dp
private val DefaultHandleSizeWidth = 32.dp
private val DefaultHandleSize = DpSize(DefaultHandleSizeWidth, DefaultHandleSizeWidth)

@Composable
internal fun Handle(
    intent: SliderIntent = remember { SliderIntent.Accent },
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    enabled: Boolean = true,
    handleSize: DpSize = DefaultHandleSize,
) {
    enabled.toString()
    val interactions = remember { mutableStateListOf<Interaction>() }
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> interactions.add(interaction)
                is PressInteraction.Release -> interactions.remove(interaction.press)
                is PressInteraction.Cancel -> interactions.remove(interaction.press)
                is DragInteraction.Start -> interactions.add(interaction)
                is DragInteraction.Stop -> interactions.remove(interaction.start)
                is DragInteraction.Cancel -> interactions.remove(interaction.start)
            }
        }
    }

    val handleColor = if (enabled) intent.colors().color else intent.colors().color.dim3
    val handleColorBg = if (interactions.isNotEmpty()) SparkTheme.colors.basicContainer else Color.Unspecified
    val handleColorBorder = if (interactions.isNotEmpty()) intent.colors().color else Color.Unspecified

    Box(contentAlignment = Alignment.Center) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(DefaultHandleSizeWidth)
                .background(handleColorBg, CircleShape)
                .border(
                    width = HandleDefaultOutline,
                    color = handleColorBorder,
                    shape = CircleShape,
                ),
        ) {
            Box(
                modifier = Modifier
                    .size(DefaultHandleSizeInnerWidth)
                    .background(SparkTheme.colors.basicContainer, CircleShape),
            )
            Box(
                modifier = Modifier
                    .size(DefaultHandleSizeInnerWidth)
                    .background(handleColor, CircleShape)
                    .hoverable(interactionSource = interactionSource),
            )
            Box(
                Modifier
                    .size(handleSize)
                    .hoverable(interactionSource = interactionSource),

            )
        }
    }
}

internal val TrackHeight = 4.dp
private val TickSize = 2.dp

/**
 * The Default track for [Slider] and [RangeSlider]
 *
 * @param sliderPositions [SliderPositions] which is used to obtain the current active track
 * and the tick positions if the slider is discrete.
 * @param modifier the [Modifier] to be applied to the track.
 * @param intent The intent color for the Track.
 * @param enabled controls the enabled state of this slider. When `false`, this component will
 * not respond to user input, and it will appear visually disabled and disabled to
 * accessibility services.
 */
@Composable
internal fun Track(
    sliderPositions: SliderPositions,
    modifier: Modifier = Modifier,
    intent: SliderIntent = SliderIntent.Accent,
    enabled: Boolean = true,
) {
    val indicatorColor = rememberUpdatedState(
        if (enabled) {
            intent.colors().color
        } else {
            intent.colors().color.dim3
        },
    ).value

    val trackColor = SparkTheme.colors.onBackground.dim4

    val stepActiveColor = intent.colors().onColor
    val stepInactiveColor = intent.colors().color

    Canvas(
        modifier
            .fillMaxWidth()
            .height(TrackHeight),
    ) {
        val isRtl = layoutDirection == LayoutDirection.Rtl
        val sliderLeft = Offset(0f, center.y)
        val sliderRight = Offset(size.width, center.y)
        val sliderStart = if (isRtl) sliderRight else sliderLeft
        val sliderEnd = if (isRtl) sliderLeft else sliderRight
        val tickSize = TickSize.toPx()
        val trackStrokeWidth = TrackHeight.toPx()
        drawLine(
            trackColor,
            sliderStart,
            sliderEnd,
            trackStrokeWidth,
            StrokeCap.Round,
        )
        val sliderValueEnd = Offset(
            sliderStart.x + (sliderEnd.x - sliderStart.x) * sliderPositions.activeRange.endInclusive,
            center.y,
        )

        val sliderValueStart = Offset(
            sliderStart.x + (sliderEnd.x - sliderStart.x) * sliderPositions.activeRange.start,
            center.y,
        )

        drawLine(
            indicatorColor,
            sliderValueStart,
            sliderValueEnd,
            trackStrokeWidth,
            StrokeCap.Round,
        )
        sliderPositions.tickFractions.groupBy {
            it > sliderPositions.activeRange.endInclusive || it < sliderPositions.activeRange.start
        }.forEach { (outsideFraction, list) ->
            drawPoints(
                list.map { Offset(lerp(sliderStart, sliderEnd, it).x, center.y) },
                PointMode.Points,
                (if (outsideFraction) stepInactiveColor else stepActiveColor),
                tickSize,
                StrokeCap.Round,
            )
        }
    }
}

/**
 * Spark slider.
 * Sliders allow users to make selections from a range of values.
 * Sliders reflect a range of values along a bar, from which users may select a single value.
 * They are ideal for adjusting settings such as volume, brightness, or applying image filters.
 *
 * @param value current value of the slider. If outside of valueRange provided,
 * value will be coerced to this range.
 * @param onValueChange callback in which value should be updated
 * @param modifier the Modifier to be applied to this slider
 * @param valueRange range of values that this slider can take. The passed value will be coerced to this range.
 * @param onValueChangeFinished called when value change has ended. This should not be used to update the slider value
 * (use onValueChange instead), but rather to know when the user has completed selecting a new value by ending a drag or a click.
 * @param enabled controls the enabled state of this slider. When false, this component will not respond to user input,
 * and it will appear visually disabled and disabled to accessibility services.
 * @param steps if greater than 0, specifies the amount of discrete allowable values, evenly distributed across the whole value range.
 * If 0, the slider will behave continuously and allow any value from the range specified. Must not be negative.
 * @param intent The intent color for the Slider.
 * @param interactionSource the MutableInteractionSource representing the stream of Interactions for this slider.
 * You can create and pass in your own remembered instance to observe Interactions
 * and customize the appearance / behavior of this slider in different states.
 */
@ExperimentalSparkApi
@Composable
public fun Slider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    onValueChangeFinished: (() -> Unit)? = null,
    enabled: Boolean = true,
    steps: Int = 0,
    intent: SliderIntent = SliderIntent.Basic,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    SparkSlider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        intent = intent,
        enabled = enabled,
        valueRange = valueRange,
        onValueChangeFinished = onValueChangeFinished,
        steps = steps,
        interactionSource = interactionSource,
    )
}

@Preview(
    group = "Slider",
    name = "Slider",
)
@Composable
internal fun SliderPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    var progress by remember { mutableFloatStateOf(0.75f) }

    PreviewTheme(theme) {
        Slider(
            value = progress,
            intent = SliderIntent.Error,
            onValueChange = { progress = it },
            enabled = true,
            valueRange = 0f..1f,
            steps = 4,
        )
        Slider(
            value = 0.5f,
            intent = SliderIntent.Success,
            onValueChange = {},
            enabled = false,
        )
    }
}
