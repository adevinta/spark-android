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
package com.adevinta.spark.tokens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.adevinta.spark.MaxPercentDifference
import com.adevinta.spark.PaparazziTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.sparkSnapshot
import com.adevinta.spark.tools.preview.ThemeVariant
import com.adevinta.spark.tools.preview.ThemeVariant.Light
import com.android.ide.common.rendering.api.SessionParams
import org.junit.Rule
import org.junit.Test
import kotlin.reflect.KProperty0

internal class ColorsScreenshot {

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = MaxPercentDifference,
        theme = PaparazziTheme,
        renderingMode = SessionParams.RenderingMode.SHRINK,
        deviceConfig = DeviceConfig.PIXEL_C.copy(
            softButtons = false,
            locale = "fr-rFR",
        ),
        showSystemUi = true,
    )

    private val colors
        @Composable
        get() = with(SparkTheme.colors) {
            listOf(
                listOf(
                    listOf(::main, ::mainContainer, ::mainVariant),
                    listOf(::support, ::supportContainer, ::supportVariant),
                    listOf(::accent, ::accentContainer, ::accentVariant),
                    listOf(::basic, ::basicContainer),
                ),
                listOf(
                    listOf(::success, ::successContainer),
                    listOf(::alert, ::alertContainer),
                    listOf(::error, ::errorContainer),
                    listOf(::info, ::infoContainer),
                    listOf(::neutral, ::neutralContainer),
                ),
                listOf(
                    listOf(::background, ::backgroundVariant),
                    listOf(::surface, ::surfaceInverse),
                    listOf(::outline, ::outlineHigh),
                ),
            )
        }

    @Test
    fun themesColors() {
        ThemeVariant.values().forEach {
            paparazzi.sparkSnapshot(name = it.name) {
                CompositionLocalProvider(LocalInspectionMode provides true) {
                    SparkTheme(
                        colors = if (it == Light) lightSparkColors() else darkSparkColors(),
                    ) {
                        Surface {
                            Colors()
                        }
                    }
                }
            }
        }
    }

    @Test
    fun verifyColorsDoChangeOnThemeChange() {
        ThemeVariant.values().forEach {
            paparazzi.snapshot(name = it.name) {
                var debugColors by remember {
                    mutableStateOf(if (it == Light) lightSparkColors() else darkSparkColors())
                }
                CompositionLocalProvider(LocalInspectionMode provides true) {
                    SparkTheme(
                        colors = debugColors,
                    ) {
                        Surface {
                            Colors()
                            LaunchedEffect(key1 = Unit) {
                                debugColors = debugColors()
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun Colors() {
        Row {
            colors.forEach { column ->
                Column {
                    column.forEach { row ->
                        Row {
                            row.forEach { color ->
                                ColorItem(color)
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ColorItem(color: KProperty0<Color>) {
        Surface(
            modifier = Modifier
                .padding(8.dp)
                .size(104.dp),
            color = color.get(),
            shape = SparkTheme.shapes.extraLarge,
            border = BorderStroke(2.dp, SparkTheme.colors.onBackground),
        ) {
            Box(
                modifier = Modifier.padding(8.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = color.name,
                    style = SparkTheme.typography.body2,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}
