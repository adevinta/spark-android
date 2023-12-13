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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.Paparazzi
import com.adevinta.spark.MaxPercentDifference
import com.adevinta.spark.PaparazziTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.TextLink
import com.adevinta.spark.patchedEnvironment
import com.adevinta.spark.sparkSnapshot
import com.android.ide.common.rendering.api.SessionParams
import org.junit.Rule
import org.junit.Test

internal class TextLinkScreenshot {

    private val textToTextLinkPairs = mutableListOf(
        Pair(
            """
            Know more about the management of my personal data and other
            RGPD details. (wordings to come)
            """.trimIndent(),
            "Know more",
        ),
        Pair("Try out Android Development", "Try out Android Development"),
        Pair("Learn Kotlin Programming https://kotlinlang.org", "https://kotlinlang.org"),
    )

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = MaxPercentDifference,
        theme = PaparazziTheme,
        renderingMode = SessionParams.RenderingMode.SHRINK,
        showSystemUi = true,
        environment = patchedEnvironment(),
        deviceConfig = app.cash.paparazzi.DeviceConfig.PIXEL_6_PRO.copy(
            softButtons = false,
            locale = "fr-rFR",
        ),
    )

    @Test
    fun test() {
        textToTextLinkPairs.forEachIndexed { index, textToTextLink ->
            paparazzi.sparkSnapshot(
                name = "Link_$index",
            ) {
                Surface(
                    color = SparkTheme.colors.surface,
                ) {
                    Row(modifier = Modifier.padding(24.dp)) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            TextLink(
                                style = SparkTheme.typography.display2,
                                textFull = textToTextLink.first,
                                textLink = textToTextLink.second,
                                colorLink = Color.Magenta,
                                colorText = Color.Blue,
                                onClick = {},
                            )
                        }
                    }
                }
            }
        }
    }
}
