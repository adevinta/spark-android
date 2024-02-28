/*
 * Copyright (c) 2023-2024 Adevinta
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
@file:Suppress("DEPRECATION")

package com.adevinta.spark.components.tags

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.icons.Booster
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

/**
 * Tinted tag represent support information like `OutlinedTag`
 * @param modifier The [Modifier] to be applied to the component
 * @param intent The [TagIntent] color to use
 * @param leadingIcon The spark icon shown at the start of the tag
 * @param tint The tint color for the icon. Use Color.Unspecified to not apply tint.
 */
@Composable
public fun TagTinted(
    modifier: Modifier = Modifier,
    intent: TagIntent = TagIntent.Basic,
    leadingIcon: SparkIcon? = null,
    tint: Color? = null,
    content: @Composable RowScope.() -> Unit,
) {
    SparkTag(
        colors = TagDefaults.tintedColors(intent),
        modifier = modifier,
        leadingIcon = leadingIcon,
        tint = tint,
        content = content,
    )
}

/**
 * Tinted tag represent support information like `OutlinedTag`
 * @param text The item label
 * @param modifier The [Modifier] to be applied to the component
 * @param intent The [TagIntent] color to use
 * @param leadingIcon The spark icon shown at the start of the tag
 * @param tint The tint color for the icon. Use Color.Unspecified to not apply tint.
 */
@Composable
public fun TagTinted(
    text: String,
    modifier: Modifier = Modifier,
    intent: TagIntent = TagIntent.Basic,
    leadingIcon: SparkIcon? = null,
    tint: Color? = null,
) {
    SparkTag(
        colors = TagDefaults.tintedColors(intent),
        modifier = modifier,
        leadingIcon = leadingIcon,
        tint = tint,
        text = text,
    )
}

/**
 * Tinted tag represent support information like `OutlinedTag`
 * @param text The item label
 * @param modifier The [Modifier] to be applied to the component
 * @param intent The [TagIntent] color to use
 * @param leadingIcon The spark icon shown at the start of the tag
 * @param tint The tint color for the icon. Use Color.Unspecified to not apply tint.
 */
@Composable
public fun TagTinted(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    intent: TagIntent = TagIntent.Basic,
    leadingIcon: SparkIcon? = null,
    tint: Color? = null,
) {
    SparkTag(
        colors = TagDefaults.tintedColors(intent),
        modifier = modifier,
        leadingIcon = leadingIcon,
        tint = tint,
        text = text,
    )
}

@Deprecated(
    "Use TagTinted instead",
    ReplaceWith("TagTinted"),
)
@Composable
public fun TagTonal(
    modifier: Modifier = Modifier,
    intent: TagIntent = TagIntent.Basic,
    leadingIcon: SparkIcon? = null,
    tint: Color? = null,
    content: @Composable RowScope.() -> Unit,
) {
    BaseSparkTag(
        colors = TagDefaults.tintedColors(intent),
        modifier = modifier,
        leadingIcon = leadingIcon,
        tint = tint,
        content = content,
    )
}

@Deprecated(
    "Use TagTinted instead with neutral intent",
    ReplaceWith("TagTinted"),
)
@Composable
public fun TagCriteria(
    modifier: Modifier = Modifier,
    leadingIcon: SparkIcon? = null,
    tint: Color? = null,
    content: @Composable RowScope.() -> Unit,
) {
    TagTonal(
        modifier = modifier,
        intent = TagIntent.Neutral,
        leadingIcon = leadingIcon,
        tint = tint,
        content = content,
    )
}

@Deprecated(
    "Use TagTinted instead with main intent",
    ReplaceWith("TagTinted"),
)
@Composable
public fun TagService(
    modifier: Modifier = Modifier,
    leadingIcon: SparkIcon? = null,
    tint: Color? = null,
    content: @Composable RowScope.() -> Unit,
) {
    TagTonal(
        modifier = modifier,
        intent = TagIntent.Main,
        leadingIcon = leadingIcon,
        tint = tint,
        content = content,
    )
}

@Preview(
    group = "Tags",
)
@Composable
internal fun TagTonalPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        val icon = SparkIcons.Booster
        TagTinted("", leadingIcon = icon)
        TagTinted("Tag Basic")
        TagTinted("Tag Basic", leadingIcon = icon)
    }
}
