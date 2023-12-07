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
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
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
import com.adevinta.spark.components.scaffold.Scaffold
import com.adevinta.spark.components.snackbars.SnackbarHost
import com.adevinta.spark.components.snackbars.SnackbarHostState
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import kotlinx.coroutines.launch

/**
 *
 * WARNING if textFull does not include textLink it will @throws IndexOutOfBoundsException
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
    @SuppressLint("ComposeUnstableCollections") inlineContent: Map<String, InlineTextContent> = mapOf(),
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
            start, end,
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
private fun SparkTagPreview(
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

                TextLink(
                    textFull = "Know more about the management of my personal data and other RGPD details. (wordings to come)",
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
                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                        .sparkUsageOverlay(Color.Green),
                )
                TextLink(
                    textFull = "Know more about the management of my personal data and other RGPD details. (wordings to come)",
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
                    textFull = "Know more about the management of my personal data and other RGPD details. (wordings to come)",
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
