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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.model.Example
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.scaffold.Scaffold
import com.adevinta.spark.components.snackbars.SnackbarHost
import com.adevinta.spark.components.snackbars.SnackbarHostState
import com.adevinta.spark.components.text.TextLink
import com.adevinta.spark.icons.InfoOutline
import com.adevinta.spark.icons.SparkIcons
import kotlinx.coroutines.launch


private const val TextLinksExampleSourceUrl = "$SampleSourceUrl/TextLinkExamples.kt"

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
        "also lots of that that you may " + "be interested in, it's really necessary" + " to know them or i will have to tell your mom",
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
public val TextLinksExamples: List<Example> = listOf(
    Example(
        name = "Link inside title no icon",
        description = "Link inside title no icon",
        sourceUrl = TextLinksExampleSourceUrl,
    ) {
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                SnackbarHost(snackbarHostState)
            },
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(),
            ) {

                TextLink(
                    style = SparkTheme.typography.subhead,
                    text = annotatedString3,
                    iconColor = Color.Magenta,
                    onClickLabel = "textLink",
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Link Clicked",
                                actionLabel = "Action",
                                duration = SnackbarDuration.Short,
                            )
                        }

                    },
                )
            }
        }
    },
    Example(
        name = "Link inside paragraph no icon",
        description = "Link inside paragraph no icon",
        sourceUrl = TextLinksExampleSourceUrl,
    ) {
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                SnackbarHost(snackbarHostState)
            },
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(),
            ) {

                TextLink(
                    style = SparkTheme.typography.subhead,
                    text = annotatedString1,
                    iconColor = Color.Magenta,
                    onClickLabel = "textLink",
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Link Clicked",
                                actionLabel = "Action",
                                duration = SnackbarDuration.Short,
                            )
                        }
                    },
                )
            }
        }
    },
    Example(
        name = "Entire text as link no icon",
        description = "Entire text as link no icon",
        sourceUrl = TextLinksExampleSourceUrl,
    ) {
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                SnackbarHost(snackbarHostState)
            },
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(),
            ) {


                TextLink(
                    style = SparkTheme.typography.subhead,
                    text = annotatedString2,
                    iconColor = Color.Magenta,
                    onClickLabel = "textLink",
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Link Clicked",
                                actionLabel = "Action",
                                duration = SnackbarDuration.Short,
                            )
                        }
                    },
                )
            }
        }
    },
    Example(
        name = "Entire text as link with icon",
        description = "Entire text as link with icon",
        sourceUrl = TextLinksExampleSourceUrl,
    ) {
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                SnackbarHost(snackbarHostState)
            },
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(),
            ) {

                TextLink(
                    style = SparkTheme.typography.subhead,
                    text = annotatedString2,
                    icon = SparkIcons.InfoOutline,
                    iconColor = Color.Magenta,
                    onClickLabel = "textLink",
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Link Clicked",
                                actionLabel = "Action",
                                duration = SnackbarDuration.Short,
                            )
                        }
                    },
                )
            }
        }
    },
)
