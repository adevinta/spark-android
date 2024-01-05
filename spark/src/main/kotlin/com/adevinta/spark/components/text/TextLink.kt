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
package com.adevinta.spark.components.text

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.buttons.IconSide
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.scaffold.Scaffold
import com.adevinta.spark.components.snackbars.SnackbarHost
import com.adevinta.spark.components.snackbars.SnackbarHostState
import com.adevinta.spark.icons.InfoFill
import com.adevinta.spark.icons.InfoOutline
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.persistentMapOf
import kotlinx.coroutines.launch

/**
 * Component that displays an underlined text link
 * As per specs only one link per instance is allowed,
 * If you want a paragraph with 2 links, just break them into two separate paragraphs
 *
 * The default [style] uses the [LocalTextStyle] provided by the [MaterialTheme] / components. If
 * you are setting your own style, you may want to consider first retrieving [LocalTextStyle],
 * and using [TextStyle.copy] to keep any theme defined attributes, only modifying the specific
 * attributes you want to override.
 *
 * For ease of use, commonly used parameters from [TextStyle] are also present here. The order of
 * precedence is as follows:
 * - If a parameter is explicitly set here (i.e, it is _not_ `null` or [TextUnit.Unspecified]),
 * then this parameter will always be used.
 * - If a parameter is _not_ set, (`null` or [TextUnit.Unspecified]), then the corresponding value
 * from [style] will be used instead.
 *
 * Additionally, for [color], if [color] is not set, and [style] does not have a color, then
 * [LocalContentColor] will be used.
 *
 * @param text the text to be displayed that has link, should be provided as Anottated string, with colors & underlined link parts
 * @param modifier the [Modifier] to be applied to this layout node
 * @param overflow how visual overflow should be handled.
 * @param softWrap whether the text should break at soft line breaks. If false, the glyphs in the
 * text will be positioned as if there was unlimited horizontal space. If [softWrap] is false,
 * [overflow] and TextAlign may have unexpected effects.
 * @param maxLines an optional maximum number of lines for the text to span, wrapping if
 * necessary. If the text exceeds the given number of lines, it will be truncated according to
 * [overflow] and [softWrap]. If it is not null, then it must be greater than zero.
 * @param minLines The minimum height in terms of minimum number of visible lines. It is required
 * that 1 <= [minLines] <= [maxLines].
 * @param onTextLayout callback that is executed when a new text layout is calculated. A
 * [TextLayoutResult] object that callback provides contains paragraph information, size of the
 * text, baselines and other details. The callback can be used to add additional decoration or
 * functionality to the text. For example, to draw selection around the text.
 * @param style style configuration for the text such as color, font, line height etc.
 * @param icon The optional icon to be displayed at the start or the end of the Text.
 * @param iconColor [Color] to applied to the icon. If [Color.Unspecified], and [style] has no color set,
 * this will be [LocalContentColor]. usually should be set to the color of the text not links
 * @param iconSide If an icon is added, you can configure the side where is should be displayed, at the start or end of the button
 * @param onClick callback when textLink container is clicked.
 */

@SuppressLint("VisibleForTests")
@Composable
public fun TextLink(
    text: AnnotatedString,
    onClickLabel: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    inlineContent: ImmutableMap<String, InlineTextContent> = persistentMapOf(),
    onTextLayout: (TextLayoutResult) -> Unit = {},
    icon: SparkIcon? = null,
    iconColor: Color = Color.Unspecified,
    iconSide: IconSide = IconSide.END,
    onClick: () -> Unit,
) {
    val layoutResult = remember { mutableStateOf<TextLayoutResult?>(null) }
    val measuredIconSize = style.fontSize.value
    val measuredIconPadding = measuredIconSize / 3

    Row(
        modifier = modifier.clickable(onClickLabel = onClickLabel) { onClick() },
    ) {
        if (icon != null && iconSide == IconSide.START) {
            Icon(
                sparkIcon = icon,
                tint = iconColor,
                modifier = Modifier
                    .alignByBaseline()
                    .padding(top = measuredIconPadding.dp / 2, end = measuredIconPadding.dp)
                    .size(measuredIconSize.dp)
                    .testTag("TextLinkIcon"),
                contentDescription = null, // Text link text should be enough for context
            )
        }
        SparkText(
            text = text,
            modifier = Modifier
                .weight(1F, false)
                .alignByBaseline(),
            style = style.copy(platformStyle = PlatformTextStyle(includeFontPadding = false)),
            overflow = overflow,
            softWrap = softWrap,
            maxLines = maxLines,
            minLines = minLines,
            inlineContent = inlineContent,
            onTextLayout = {
                layoutResult.value = it
                onTextLayout(it)
            },
        )
        if (icon != null && iconSide == IconSide.END) {
            Icon(
                sparkIcon = icon,
                tint = iconColor,
                modifier = Modifier
                    .alignByBaseline()
                    .padding(top = measuredIconPadding.dp / 2, start = measuredIconPadding.dp)
                    .size(measuredIconSize.dp)
                    .testTag("TextLinkIcon"),
                contentDescription = null, // Text link text should be enough for context
            )
        }

    }
}

@Preview(
    group = "Text",
    name = "TextLink",
)
@Composable
private fun SparkTextLinkPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(
        themeVariant = theme,
        color = { SparkTheme.colors.backgroundVariant },
    ) {
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                SnackbarHost(snackbarHostState)
            },
        ) {
            Column {
                val annotatedString = buildAnnotatedString {
                    append("Know more about the ")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline,
                        ),
                    ) {
                        append("Privacy & Policy")
                    }
                    append(
                        """
                         also lots of that that you may be interested in,
                        it's really necessary
                        to know them or i will have to tell your mom
                        """.trimIndent(),
                    )
                }

                TextLink(
                    style = SparkTheme.typography.subhead,
                    text = annotatedString,
                    iconSide = IconSide.START,
                    onClickLabel = "Privacy & Policy",
                    icon = SparkIcons.InfoFill,
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Know more Clicked",
                                actionLabel = "Action",
                                duration = SnackbarDuration.Short,
                            )
                        }
                    },
                )
            }
        }
    }
}
