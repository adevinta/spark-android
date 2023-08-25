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
package com.adevinta.spark.iconbuttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.Paparazzi
import com.adevinta.spark.MaxPercentDifference
import com.adevinta.spark.PaparazziTheme
import com.adevinta.spark.components.iconbuttons.IconButtonContrast
import com.adevinta.spark.components.iconbuttons.IconButtonFilled
import com.adevinta.spark.components.iconbuttons.IconButtonGhost
import com.adevinta.spark.components.iconbuttons.IconButtonIntent
import com.adevinta.spark.components.iconbuttons.IconButtonOutlined
import com.adevinta.spark.components.iconbuttons.IconButtonShape
import com.adevinta.spark.components.iconbuttons.IconButtonSize
import com.adevinta.spark.components.iconbuttons.IconButtonTinted
import com.adevinta.spark.icons.FavoriteFill
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

    private val icon = SparkIcons.FavoriteFill

    private val shapes = IconButtonShape.values()

    private val sizes = IconButtonSize.values()

    private val enableList: List<Boolean> = listOf(true, false)

    private val intents = IconButtonIntent.values()

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = MaxPercentDifference,
        theme = PaparazziTheme,
        renderingMode = SessionParams.RenderingMode.SHRINK,
        showSystemUi = false,
        environment = patchedEnvironment(),
    )

    @Test
    fun test() {
        shapes.forEach { shape ->
            sizes.forEach { size ->
                enableList.forEach { isEnabled ->
                    intents.forEach { intent ->
                        paparazzi.sparkSnapshot(
                            name = "_${shape}_shape" +
                                    "_${size}_size" +
                                    "_${intent}_intent" +
                                    "_enabled".takeIf { isEnabled }.orEmpty() +
                                    "_disabled".takeIf { isEnabled.not() }.orEmpty(),
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp),
                            ) {
                                IconButtonGhost(
                                    onClick = {},
                                    icon = icon,
                                    intent = intent,
                                    shape = shape,
                                    size = size,
                                    enabled = isEnabled,
                                )
                                IconButtonFilled(
                                    onClick = {},
                                    icon = icon,
                                    intent = intent,
                                    shape = shape,
                                    size = size,
                                    enabled = isEnabled,
                                )
                                IconButtonOutlined(
                                    onClick = {},
                                    icon = icon,
                                    intent = intent,
                                    shape = shape,
                                    size = size,
                                    enabled = isEnabled,
                                )
                                IconButtonContrast(
                                    onClick = {},
                                    icon = icon,
                                    intent = intent,
                                    shape = shape,
                                    size = size,
                                    enabled = isEnabled,
                                )
                                IconButtonTinted(
                                    onClick = {},
                                    icon = icon,
                                    intent = intent,
                                    shape = shape,
                                    size = size,
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
