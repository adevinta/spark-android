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
package com.adevinta.spark.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import app.cash.paparazzi.Paparazzi
import com.adevinta.spark.MaxPercentDifference
import com.adevinta.spark.PaparazziTheme
import com.adevinta.spark.R
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.buttons.ButtonIntent
import com.adevinta.spark.components.buttons.IconSide
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.TextLink
import com.adevinta.spark.components.text.TextLinkButton
import com.adevinta.spark.icons.InfoOutline
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.patchedEnvironment
import com.adevinta.spark.sparkSnapshot
import com.android.ide.common.rendering.api.SessionParams
import org.junit.Rule
import org.junit.Test

internal class TextLinkScreenshot {

    private val intents = ButtonIntent.entries

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = MaxPercentDifference,
        theme = PaparazziTheme,
        renderingMode = SessionParams.RenderingMode.SHRINK,
        showSystemUi = true,
        environment = patchedEnvironment(),
        deviceConfig = app.cash.paparazzi.DeviceConfig.PIXEL_6_PRO.copy(
            softButtons = false,
            locale = "en-rUS",
        ),
    )

    @Test
    fun testTextLink() {
        paparazzi.sparkSnapshot(
            name = "TextLink",
        ) {
            Surface(
                color = SparkTheme.colors.surface,
            ) {
                TextLink(
                    style = SparkTheme.typography.subhead,
                    text = R.string.spark_text_link_short_example,
                    onClickLabel = "textLink",
                    onClick = {},
                )
            }
        }
    }

    @Test
    fun testTextLinkButton() {
        intents.forEachIndexed { _, intent ->
            paparazzi.sparkSnapshot(
                name = "TextLinkButton_${intent.name}",
            ) {
                Surface(
                    color = SparkTheme.colors.backgroundVariant,
                ) {
                    Column {
                        IconSide.entries.forEach { iconSide ->
                            Row {
                                TextLinkButton(
                                    text = "Click me",
                                    icon = SparkIcons.InfoOutline,
                                    intent = intent,
                                    iconSide = iconSide,
                                    onClick = {},
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
