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
@file:Suppress("DEPRECATION")
package com.adevinta.spark.components.tags

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.preview.SparkPreviewProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import com.adevinta.spark.tools.preview.UserType

/**
 * Outlined tag represent secondary information
 * @param text The item label
 * @param modifier The [Modifier] to be applied to the component
 * @param intent The [TagIntent] color to use
 * @param leadingIcon The spark icon shown at the start of the tag
 * @param tint The tint color for the icon. Use Color.Unspecified to not apply tint.
 */
@Composable
public fun TagOutlined(
    text: String,
    modifier: Modifier = Modifier,
    intent: TagIntent = TagIntent.Primary,
    leadingIcon: SparkIcon? = null,
    tint: Color? = null,
) {
    val colors = TagDefaults.outlinedColors(intent)
    SparkTag(
        text = text,
        colors = colors,
        modifier = modifier,
        border = BorderStroke(
            TagDefaults.OutlinedBorderSize,
            colors.contentColor,
        ),
        leadingIcon = leadingIcon,
        tint = tint,
    )
}

/**
 * Outlined tag represent secondary information
 * @param text The item label
 * @param modifier The [Modifier] to be applied to the component
 * @param intent The [TagIntent] color to use
 * @param leadingIcon The spark icon shown at the start of the tag
 * @param tint The tint color for the icon. Use Color.Unspecified to not apply tint.
 */
@Composable
public fun TagOutlined(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    intent: TagIntent = TagIntent.Primary,
    leadingIcon: SparkIcon? = null,
    tint: Color? = null,
) {
    val colors = TagDefaults.outlinedColors(intent)
    SparkTag(
        text = text,
        colors = colors,
        modifier = modifier,
        border = BorderStroke(
            TagDefaults.OutlinedBorderSize,
            colors.contentColor,
        ),
        leadingIcon = leadingIcon,
        tint = tint,
    )
}

@Deprecated(
    "Use TagOutlined with text param instead",
    ReplaceWith("TagOutlined(text, modifier, intent, leadingIcon, tint)"),
)
@Composable
public fun TagOutlined(
    modifier: Modifier = Modifier,
    intent: TagIntent = TagIntent.Primary,
    leadingIcon: SparkIcon? = null,
    tint: Color? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val colors = TagDefaults.outlinedColors(intent)
    BaseSparkTag(
        colors = colors,
        modifier = modifier,
        border = BorderStroke(
            TagDefaults.OutlinedBorderSize,
            colors.contentColor,
        ),
        leadingIcon = leadingIcon,
        tint = tint,
        content = content,
    )
}

@Deprecated(
    "Use TagOutlined with neutral intent instead",
    ReplaceWith("TagOutlined(text, modifier, intent, leadingIcon, tint)"),
)
@Composable
public fun TagPromote(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    TagOutlined(
        modifier = modifier,
        intent = TagIntent.Neutral,
        content = content,
    )
}

@Deprecated(
    "Use TagOutlined with primary intent instead",
    ReplaceWith("TagOutlined(text, modifier, intent, leadingIcon, tint)"),
)
@Composable
public fun TagUrgent(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    TagOutlined(
        modifier = modifier,
        intent = TagIntent.Primary,
        content = content,
    )
}

@Deprecated(
    "Use TagOutlined with secondary intent instead",
    ReplaceWith("TagOutlined(text, modifier, intent, leadingIcon, tint)"),
)
@Composable
public fun TagPro(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    TagOutlined(
        modifier = modifier,
        intent = TagIntent.Secondary,
        content = content,
    )
}

@Preview(
    group = "Tags",
)
@Composable
internal fun TagOutlinedPreview(
    @PreviewParameter(SparkPreviewProvider::class) param: Pair<ThemeVariant, UserType>,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        TagIntent.values().forEach {
            TagOutlined("Tag ${it.name}", intent = it)
        }
    }
}
