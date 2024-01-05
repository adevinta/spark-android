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
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.Paparazzi
import com.adevinta.spark.MaxPercentDifference
import com.adevinta.spark.PaparazziTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.buttons.IconSide
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.TextLink
import com.adevinta.spark.icons.InfoOutline
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.patchedEnvironment
import com.adevinta.spark.sparkSnapshot
import com.android.ide.common.rendering.api.SessionParams
import org.junit.Rule
import org.junit.Test

internal class TextLinkScreenshot {

    private val iconValues: List<SparkIcon?> = listOf(SparkIcons.InfoOutline, null)

    private val annotatedString1 = buildAnnotatedString {
        append("Know more about the ")
        withStyle(
            style = SpanStyle(
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
            ),
        ) {
            append("Privacy & Policy")
        }
        append(
            "also lots of that that you may " +
                "be interested in, it's really necessary" +
                " to know them or i will have to tell your mom",
        )
    }

    private val annotatedString2 = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Magenta,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
            ),
        ) {
            append("Try out Android Development")
        }
    }

    private val annotatedString3 = buildAnnotatedString {
        append("Learn Kotlin Programming  ")
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
            ),
        ) {
            append("https://kotlinlang.org")
        }
    }

    private val textLinks = mutableListOf(
        annotatedString1,
        annotatedString2,
        annotatedString3,
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
            locale = "en-rUS",
        ),
    )

    @Test
    fun test() {
        iconValues.forEach { icon ->
            textLinks.forEachIndexed { index, textLink ->
                paparazzi.sparkSnapshot(
                    name = "Link_${index}_IconExists${icon == null}",
                ) {
                    Surface(
                        color = SparkTheme.colors.surface,
                    ) {
                        Column {
                            IconSide.entries.forEach { iconSide ->
                                Row(modifier = Modifier.padding(24.dp)) {
                                    TextLink(
                                        style = SparkTheme.typography.subhead,
                                        text = textLink,
                                        icon = icon,
                                        iconColor = Color.Magenta,
                                        onClickLabel = "textLink",
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
}
