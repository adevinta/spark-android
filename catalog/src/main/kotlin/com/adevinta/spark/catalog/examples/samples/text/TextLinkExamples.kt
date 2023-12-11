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
package com.adevinta.spark.catalog.examples.samples.text

import androidx.compose.ui.graphics.Color
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.model.Example
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.text.TextLink

private const val TextLinksExampleDescription = "TextLink examples"
private const val TextLinksExampleSourceUrl = "$SampleSourceUrl/TextLinkExamples.kt"
public val TextLinksExamples: List<Example> = listOf(
    Example(
        name = "Link inside title",
        description = "Link inside title",
        sourceUrl = TextLinksExampleSourceUrl,
    ) {
        TextLink(
            textFull = "Learn Kotlin Programming https://kotlinlang.org",
            textLink = "https://kotlinlang.org",
            colorLink = Color.Magenta,
            onClick = {},
        )
    },
    Example(
        name = "Link inside paragraph",
        description = "Link inside paragraph",
        sourceUrl = TextLinksExampleSourceUrl,
    ) {
        TextLink(
            textFull = """
                This Adevinta Privacy Policy & Statement (“Privacy Statement\")
                \n\n outlines our privacy policies and practices;
                \n\n describes how we collect, use, share, and otherwise process Personal Data (as defined in the GDPR)
            """.trimIndent(),
            textLink = "Adevinta",
            colorLink = Color.Blue,
            onClick = {},
        )
    },
    Example(
        name = "Link inside paragraph with style",
        description = "Entire text as link",
        sourceUrl = TextLinksExampleSourceUrl,
    ) {
        TextLink(
            textFull = "Try out Android Development",
            textLink = "Try out Android Development",
            colorLink = Color.Green,
            onClick = {},
        )
    },
    Example(
        name = "Entire text as link",
        description = "Entire text as link",
        sourceUrl = TextLinksExampleSourceUrl,
    ) {
        TextLink(
            style = SparkTheme.typography.display2,
            textFull = """
                Know more about the management of my personal data and other
                 RGPD details. (wordings to come)
            """.trimIndent(),
            textLink = "Know more",
            colorLink = Color.Blue,
            onClick = {},
        )
    },
)
