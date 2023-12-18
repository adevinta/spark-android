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

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.scaffold.Scaffold
import com.adevinta.spark.components.snackbars.SnackbarHost
import com.adevinta.spark.components.snackbars.SnackbarHostState
import com.adevinta.spark.components.spacer.HorizontalSpacer
import com.adevinta.spark.components.spacer.Spacer
import com.adevinta.spark.icons.FavoriteOutline
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
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
 * @param textFull the full text to be displayed
 * @param textLink the text to be underlined as link (it will be the clickable part
 * WARNING if textFull does not include textLink it will @throws IndexOutOfBoundsException
 *
 * @param modifier the [Modifier] to be applied to this layout node
 * @param colorText [Color] to apply to the text. If [Color.Unspecified], and [style] has no color set,
 * this will be [LocalContentColor].
 * @param colorLink [Color] to apply to the link. by default if no color specified it will
 * be assigned to the value of @param colorText
 * @param fontSize the size of glyphs to use when painting the text. See [TextStyle.fontSize].
 * @param fontStyle the typeface variant to use when drawing the letters (e.g., italic).
 * See [TextStyle.fontStyle].
 * @param fontWeight the typeface thickness to use when painting the text (e.g., [FontWeight.Bold]).
 * @param fontFamily the font family to be used when rendering the text. See [TextStyle.fontFamily].
 * @param letterSpacing the amount of space to add between each letter.
 * See [TextStyle.letterSpacing].
 * @param textAlign the alignment of the text within the lines of the paragraph.
 * See [TextStyle.textAlign].
 * @param lineHeight line height for the [Paragraph] in [TextUnit] unit, e.g. SP or EM.
 * See [TextStyle.lineHeight].
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
 * @param onClick callback when textLink part is clicked.
 */

@Composable
public fun TextLink(
    textFull: String,
    textLink: String,
    modifier: Modifier = Modifier,
    colorText: Color = Color.Unspecified,
    colorLink: Color = colorText,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    inlineContent: ImmutableMap<String, InlineTextContent> = persistentMapOf(),
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current,
    onClick: () -> Unit,
) {
    val start = textFull.indexOf(textLink)
    val end = start + textLink.length

    val annotatedText = buildAnnotatedString {
        append(textFull)
        addStyle(
            style = SpanStyle(
                color = colorLink,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
            ),
            start,
            end,
        )
    }

    val layoutResult = remember { mutableStateOf<TextLayoutResult?>(null) }
    val pressIndicator = Modifier.pointerInput(onClick) {
        detectTapGestures { pos ->
            layoutResult.value?.let { layoutResult ->
                val offset = layoutResult.getOffsetForPosition(pos)
                if (offset in start..end) onClick()
            }
        }
    }

    SparkText(
        text = annotatedText,
        modifier = modifier.then(pressIndicator),
        style = style,
        color = colorText,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textAlign = textAlign,
        lineHeight = lineHeight,
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
                Row {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        sparkIcon = SparkIcons.FavoriteOutline,
                        contentDescription = "Favorite",
                    )
                    HorizontalSpacer(8.dp)
                    TextLink(

                        textFull = "Know more about the management of my personal data and other " + "RGPD details. (wordings to come)",
                        textLink = "Know more",
                        style = SparkTheme.typography.headline1,
                        colorText = Color.Cyan,
                        colorLink = Color.Magenta,
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
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                        .sparkUsageOverlay(Color.Green),
                )
                TextLink(
                    textFull = "Know more about the management of my personal data and other " + "RGPD details. (wordings to come)",
                    textLink = "Know more",
                    style = SparkTheme.typography.body2,
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
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                        .sparkUsageOverlay(Color.Green),
                )

                TextLink(
                    style = SparkTheme.typography.display2,
                    textFull = "Know more about the management of my personal data and other" + " RGPD details. (wordings to come)",
                    textLink = "Know more",
                    colorLink = Color.Blue,
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
