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
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.sparkSnapshot
import com.adevinta.spark.tools.preview.ThemeVariant
import com.adevinta.spark.tools.preview.ThemeVariant.Light
import com.android.ide.common.rendering.api.SessionParams
import org.junit.Rule
import org.junit.Test

internal class ColorsScreenshot {

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = .01, // We can have in some cases 2/3 pixels being different for no apparent reasons :(
        theme = "android:Theme.MaterialComponent.Light.NoActionBar",
        renderingMode = SessionParams.RenderingMode.SHRINK,
        deviceConfig = DeviceConfig.PIXEL_C.copy(
            softButtons = false,
            locale = "fr-rFR",
        ),
        showSystemUi = true,
    )

    @Test
    fun themesColors() {
        ThemeVariant.values().forEach {
            paparazzi.sparkSnapshot(name = it.name) {
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

    @Test
    fun verifyColorsDoChangeOnThemeChange() {
        ThemeVariant.values().forEach {
            paparazzi.snapshot(name = it.name) {
                var debugColors by remember {
                    mutableStateOf(if (it == Light) lightSparkColors() else darkSparkColors())
                }
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

    @Composable
    private fun Colors() {
        Row {
            Column {
                Row {
                    ColorItem(SparkTheme.colors.main, "main")
                    ColorItem(SparkTheme.colors.mainContainer, "main Container")
                    ColorItem(SparkTheme.colors.mainVariant, "main Variant")
                }
                Row {
                    ColorItem(SparkTheme.colors.support, "support")
                    ColorItem(SparkTheme.colors.supportContainer, "support Container")
                    ColorItem(SparkTheme.colors.supportVariant, "support Variant")
                }
                Row {
                    ColorItem(SparkTheme.colors.accent, "accent")
                    ColorItem(SparkTheme.colors.accentContainer, "accent Container")
                    ColorItem(SparkTheme.colors.accentVariant, "accent Variant")
                }
                Row {
                    ColorItem(SparkTheme.colors.basic, "basic")
                    ColorItem(SparkTheme.colors.basicContainer, "basic Container")
                }
            }
            Column {
                Row {
                    ColorItem(SparkTheme.colors.success, "success")
                    ColorItem(SparkTheme.colors.successContainer, "success Container")
                }
                Row {
                    ColorItem(SparkTheme.colors.alert, "alert")
                    ColorItem(SparkTheme.colors.alertContainer, "alert Container")
                }
                Row {
                    ColorItem(SparkTheme.colors.error, "error")
                    ColorItem(SparkTheme.colors.errorContainer, "error Container")
                }
                Row {
                    ColorItem(SparkTheme.colors.info, "info")
                    ColorItem(SparkTheme.colors.infoContainer, "info Container")
                }
                Row {
                    ColorItem(SparkTheme.colors.neutral, "neutral")
                    ColorItem(SparkTheme.colors.neutralContainer, "neutral Container")
                }
            }
            Column {
                Row {
                    ColorItem(SparkTheme.colors.background, "background")
                    ColorItem(SparkTheme.colors.backgroundVariant, "backgroundVariant")
                }
                Row {
                    ColorItem(SparkTheme.colors.surface, "surface")
                    ColorItem(SparkTheme.colors.surfaceInverse, "surface inverse")
                }
                Row {
                    ColorItem(SparkTheme.colors.outline, "outline")
                    ColorItem(SparkTheme.colors.outlineHigh, "outline High")
                }
            }
        }
    }

    @Composable
    private fun ColorItem(color: Color, colorName: String) {
        CompositionLocalProvider(
            LocalContentColor provides contentColorFor(backgroundColor = color),
        ) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(104.dp)
                    .clip(SparkTheme.shapes.extraLarge)
                    .border(BorderStroke(2.dp, SparkTheme.colors.onBackground), SparkTheme.shapes.extraLarge)
                    .background(color),
                propagateMinConstraints = true,
            ) {
                Box(
                    modifier = Modifier.padding(8.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = colorName,
                        style = SparkTheme.typography.body2,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}
