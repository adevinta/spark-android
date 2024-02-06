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

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderPositions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import androidx.compose.material3.RangeSlider as MaterialRangeSlider

@OptIn(ExperimentalMaterial3Api::class)
@InternalSparkApi
@Composable
internal fun SparkRangeSlider(
    intent: SliderIntent,
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    /*@IntRange(from = 0)*/
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    colors: SliderColors = SliderDefaults.colors(),
    enabled: Boolean = true,
    startInteractionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    endInteractionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    startHandle: @Composable (SliderPositions) -> Unit = remember(startInteractionSource, enabled) {
        {
            Handle(
                interactionSource = startInteractionSource,
                intent = intent,
                enabled = enabled,
            )
        }
    },
    endHandle: @Composable (SliderPositions) -> Unit = remember(endInteractionSource, enabled) {
        {
            Handle(
                interactionSource = endInteractionSource,
                intent = intent,
                enabled = enabled,
            )
        }
    },

    ) {
    MaterialRangeSlider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        onValueChangeFinished = onValueChangeFinished,
        colors = colors,

        startThumb = startHandle,
        endThumb = endHandle,
        startInteractionSource = startInteractionSource,
        endInteractionSource = endInteractionSource,
        track = { sliderPositions ->
            Track(
                intent = intent,
                enabled = enabled,
                sliderPositions = sliderPositions,
            )
        },
    )
}

/**
 * Spark Range slider.
 * Range Sliders expand upon Slider using the same concepts but allow the user to select 2 values.
 * The two values are still bounded by the value range but they also cannot cross each other.
 * Use continuous Range Sliders to allow users to make meaningful selections that don’t require a specific values:
 * @param value current values of the RangeSlider. If either value is outside of valueRange provided, it will be coerced to this range.
 * @param onValueChange lambda in which values should be updated
 * @param modifier modifiers for the Range Slider layout
 * @param enabled whether or not component is enabled and can we interacted with or not
 * @param valueRange range of values that Range Slider values can take. Passed value will be coerced to this range
 * @param steps if greater than 0, specifies the amounts of discrete values, evenly distributed between across the whole value range.
 * If 0, range slider will behave as a continuous slider and allow to choose any value from the range specified. Must not be negative.
 * @param onValueChangeFinished lambda to be invoked when value change has ended.
 * This callback shouldn't be used to update the range slider values (use onValueChange for that),
 * but rather to know when the user has completed selecting a new value by ending a drag or a click.
 */
@ExperimentalSparkApi
@Composable
public fun RangeSlider(
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    /*@IntRange(from = 0)*/
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
) {
    SparkRangeSlider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        intent = SliderIntent.Accent,
        onValueChangeFinished = onValueChangeFinished,
    )
}

@Preview(
    group = "RangeSlider",
    name = "RangeSlider",
)
@Composable
internal fun RangeSliderPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    var progress by remember { mutableStateOf(0.1f..0.5f) }

    PreviewTheme(theme) {
        RangeSlider(
            value = progress,
            onValueChange = { progress = it },
            enabled = true,
            steps = 3,
        )

        RangeSlider(
            value = 0.1f..0.5f,
            onValueChange = {},
            enabled = false,
        )
    }
}
