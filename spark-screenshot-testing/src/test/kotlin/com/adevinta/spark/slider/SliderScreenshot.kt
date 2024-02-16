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
package com.adevinta.spark.slider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adevinta.spark.DefaultTestDevices
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.components.slider.RangeSlider
import com.adevinta.spark.components.slider.Slider
import com.adevinta.spark.components.slider.SliderIntent
import com.adevinta.spark.paparazziRule
import com.adevinta.spark.sparkSnapshot
import com.android.ide.common.rendering.api.SessionParams.RenderingMode.SHRINK
import org.junit.Rule
import org.junit.Test

internal class SliderScreenshot {

    private val intents = SliderIntent.entries

    @get:Rule
    val paparazzi = paparazziRule(
        renderingMode = SHRINK,
        deviceConfig = DefaultTestDevices.Tablet,
    )

    @Test
    fun sliderSquare() {
        paparazzi.sparkSnapshot {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = spacedBy(16.dp),
            ) {
                intents.forEach { intent ->
                    Sliders(
                        intent = intent,
                        rounded = false,
                    )
                }
            }
        }
    }

    @Test
    fun sliderRounded() {
        paparazzi.sparkSnapshot {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = spacedBy(16.dp),
            ) {
                intents.forEach { intent ->
                    Sliders(
                        intent = intent,
                        rounded = true,
                    )
                }
            }
        }
    }

    @Test
    fun sliderRoundedDisabled() {
        paparazzi.sparkSnapshot {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = spacedBy(16.dp),
            ) {
                intents.forEach { intent ->
                    Sliders(
                        intent = intent,
                        enabled = false,
                        rounded = true,
                    )
                }
            }
        }
    }

    @Test
    fun rangeSliderSquare() {
        paparazzi.sparkSnapshot {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = spacedBy(16.dp),
            ) {
                intents.forEach { intent ->
                    RangeSliders(
                        intent = intent,
                        rounded = false,
                    )
                }
            }
        }
    }

    @Test
    fun rangeSliderRounded() {
        paparazzi.sparkSnapshot {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = spacedBy(16.dp),
            ) {
                intents.forEach { intent ->
                    RangeSliders(
                        intent = intent,
                        rounded = true,
                    )
                }
            }
        }
    }

    @Test
    fun rangeSliderRoundedDisabled() {
        paparazzi.sparkSnapshot {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = spacedBy(16.dp),
            ) {
                intents.forEach { intent ->
                    RangeSliders(
                        intent = intent,
                        enabled = false,
                        rounded = true,
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalSparkApi::class)
    @Composable
    private fun Sliders(
        intent: SliderIntent,
        enabled: Boolean = true,
        rounded: Boolean,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Slider(
                value = 0.25f,
                intent = intent,
                onValueChange = { },
                enabled = enabled,
                rounded = rounded,
                valueRange = 0f..1f,
            )
            Slider(
                value = 0.5f,
                intent = intent,
                onValueChange = { },
                enabled = enabled,
                rounded = rounded,
                valueRange = 0f..1f,
            )
            Slider(
                value = 0.75f,
                intent = intent,
                onValueChange = { },
                enabled = enabled,
                rounded = rounded,
                valueRange = 0f..1f,
            )
            Slider(
                value = 1f,
                intent = intent,
                onValueChange = { },
                enabled = enabled,
                rounded = rounded,
                valueRange = 0f..1f,
            )
        }
    }

    @OptIn(ExperimentalSparkApi::class)
    @Composable
    private fun RangeSliders(
        intent: SliderIntent,
        enabled: Boolean = true,
        rounded: Boolean,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            RangeSlider(
                value = 0.3f..0.6f,
                intent = intent,
                onValueChange = { },
                enabled = enabled,
                rounded = rounded,
            )
            RangeSlider(
                value = 0.2f..0.7f,
                intent = intent,
                onValueChange = { },
                enabled = enabled,
                rounded = rounded,
            )
            RangeSlider(
                value = 0.1f..0.8f,
                intent = intent,
                onValueChange = { },
                enabled = enabled,
                rounded = rounded,
            )
        }
    }
}
