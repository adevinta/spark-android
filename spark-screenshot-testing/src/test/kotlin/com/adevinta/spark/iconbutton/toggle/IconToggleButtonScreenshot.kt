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
package com.adevinta.spark.iconbutton.toggle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.MaxPercentDifference
import com.adevinta.spark.PaparazziTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.iconbuttons.IconButtonIntent
import com.adevinta.spark.components.iconbuttons.IconButtonShape
import com.adevinta.spark.components.iconbuttons.IconButtonSize
import com.adevinta.spark.components.iconbuttons.toggle.IconToggleButtonContrast
import com.adevinta.spark.components.iconbuttons.toggle.IconToggleButtonFilled
import com.adevinta.spark.components.iconbuttons.toggle.IconToggleButtonGhost
import com.adevinta.spark.components.iconbuttons.toggle.IconToggleButtonIcons
import com.adevinta.spark.components.iconbuttons.toggle.IconToggleButtonOutlined
import com.adevinta.spark.components.iconbuttons.toggle.IconToggleButtonTinted
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.AccountFill
import com.adevinta.spark.icons.AccountOutline
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.patchedEnvironment
import com.adevinta.spark.sparkSnapshot
import com.android.ide.common.rendering.api.SessionParams
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
internal class IconToggleButtonScreenshot {

    private val icons: IconToggleButtonIcons = IconToggleButtonIcons(SparkIcons.AccountOutline, SparkIcons.AccountFill)

    private val shapes = IconButtonShape.entries.toTypedArray()

    private val sizes = IconButtonSize.entries.toTypedArray()

    private val checkList: List<Boolean> = listOf(true, false)

    private val enableList: List<Boolean> = listOf(true, false)

    private val intents = IconButtonIntent.entries.toTypedArray()

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = MaxPercentDifference,
        theme = PaparazziTheme,
        renderingMode = SessionParams.RenderingMode.SHRINK,
        showSystemUi = true,
        environment = patchedEnvironment(),
        deviceConfig = DeviceConfig.PIXEL_C.copy(
            softButtons = false,
            locale = "fr-rFR",
        ),
    )

    @OptIn(ExperimentalSparkApi::class)
    @Test
    fun test() {
        shapes.forEach { shape ->
            sizes.forEach { size ->
                paparazzi.sparkSnapshot(
                    name = "$shape" +
                        "_$size",
                ) {
                    Row {
                        enableList.forEach { isEnabled ->
                            checkList.forEach { isChecked ->
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                ) {
                                    Text(
                                        text = "Enabled: $isEnabled, Checked: $isChecked",
                                    )
                                    intents.forEach { intent ->
                                        Surface(
                                            color = if (intent == IconButtonIntent.Surface) {
                                                SparkTheme.colors.surfaceInverse
                                            } else {
                                                SparkTheme.colors.surface
                                            },
                                        ) {
                                            Row {
                                                IconToggleButtonFilled(
                                                    checked = isChecked,
                                                    onCheckedChange = {},
                                                    icons = icons,
                                                    shape = shape,
                                                    size = size,
                                                    intent = intent,
                                                    enabled = isEnabled,
                                                )
                                                IconToggleButtonOutlined(
                                                    checked = isChecked,
                                                    onCheckedChange = {},
                                                    icons = icons,
                                                    shape = shape,
                                                    size = size,
                                                    intent = intent,
                                                    enabled = isEnabled,
                                                )
                                                IconToggleButtonTinted(
                                                    checked = isChecked,
                                                    onCheckedChange = {},
                                                    icons = icons,
                                                    shape = shape,
                                                    size = size,
                                                    intent = intent,
                                                    enabled = isEnabled,
                                                )
                                                IconToggleButtonContrast(
                                                    checked = isChecked,
                                                    onCheckedChange = {},
                                                    icons = icons,
                                                    shape = shape,
                                                    size = size,
                                                    intent = intent,
                                                    enabled = isEnabled,
                                                )
                                                IconToggleButtonGhost(
                                                    checked = isChecked,
                                                    onCheckedChange = {},
                                                    icons = icons,
                                                    shape = shape,
                                                    size = size,
                                                    intent = intent,
                                                    enabled = isEnabled,
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
