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
package com.adevinta.spark.iconbutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.adevinta.spark.MaxPercentDifference
import com.adevinta.spark.PaparazziTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.buttons.ButtonShape
import com.adevinta.spark.components.iconbuttons.IconButtonContrast
import com.adevinta.spark.components.iconbuttons.IconButtonFilled
import com.adevinta.spark.components.iconbuttons.IconButtonGhost
import com.adevinta.spark.components.iconbuttons.IconButtonIntent
import com.adevinta.spark.components.iconbuttons.IconButtonOutlined
import com.adevinta.spark.components.iconbuttons.IconButtonSize
import com.adevinta.spark.components.iconbuttons.IconButtonTinted
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
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
internal class IconButtonScreenshot {

    private val shapes: Array<ButtonShape> = ButtonShape.entries.toTypedArray()

    private val sizes = IconButtonSize.entries.toTypedArray()

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

    @Test
    fun test() {
        //      shapes.forEach { shape -> TODO: Uncomment after Polaris app adapt new @ButtonShape class
        sizes.forEach { size ->
            paparazzi.sparkSnapshot(name = "$size") {
                Row {
                    enableList.forEach { isEnabled ->
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            Text(
                                text = "Enabled: $isEnabled",
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
                                        IconButtonFilled(
                                            onClick = {},
                                            icon = SparkIcons.AccountOutline,
                                            size = size,
                                            intent = intent,
                                            enabled = isEnabled,
                                        )
                                        IconButtonOutlined(
                                            onClick = {},
                                            icon = SparkIcons.AccountOutline,
                                            size = size,
                                            intent = intent,
                                            enabled = isEnabled,
                                        )
                                        IconButtonTinted(
                                            onClick = {},
                                            icon = SparkIcons.AccountOutline,
                                            size = size,
                                            intent = intent,
                                            enabled = isEnabled,
                                        )
                                        IconButtonContrast(
                                            onClick = {},
                                            icon = SparkIcons.AccountOutline,
                                            size = size,
                                            intent = intent,
                                            enabled = isEnabled,
                                        )
                                        IconButtonGhost(
                                            onClick = {},
                                            icon = SparkIcons.AccountOutline,
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
