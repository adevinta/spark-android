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

package com.adevinta.spark.tokens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isFinite
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tools.preview.ThemesPreviews

public object Layout {

    /// TODO: Use M3 WindowHeightSizeClass instead of our custom size ranges

    public val bodyMargin: Dp
        @Composable get() = when (LocalConfiguration.current.screenWidthDp) {
            in 0..599 -> 16.dp
            in 600..904 -> 32.dp
            in 905..1239 -> 0.dp
            in 1240..1439 -> 200.dp
            else -> 0.dp
        }

    public val gutter: Dp
        @Composable get() = when (LocalConfiguration.current.screenWidthDp) {
            in 0..599 -> 8.dp
            in 600..904 -> 16.dp
            in 905..1239 -> 16.dp
            in 1240..1439 -> 32.dp
            else -> 32.dp
        }

    public val bodyMaxWidth: Dp
        @Composable get() = when (LocalConfiguration.current.screenWidthDp) {
            in 0..599 -> Dp.Infinity
            in 600..904 -> Dp.Infinity
            in 905..1239 -> 840.dp
            in 1240..1439 -> Dp.Infinity
            else -> 1040.dp
        }

    public val columns: Int
        @Composable get() = when (LocalConfiguration.current.screenWidthDp) {
            in 0..599 -> 4
            in 600..904 -> 8
            else -> 12
        }
}


/**
 * Support wide screen by making the content width max 840dp, centered horizontally.
 */
public fun Modifier.bodyWidth(): Modifier = fillMaxWidth()
    .wrapContentWidth(align = Alignment.CenterHorizontally)
    .composed {
        val bodyMaxWidth = Layout.bodyMaxWidth
        if (bodyMaxWidth.isFinite) widthIn(max = bodyMaxWidth) else this
    }
    .composed {
        padding(
            WindowInsets.systemBars
                .only(WindowInsetsSides.Horizontal)
                .asPaddingValues(),
        )
    }

@Composable
@ThemesPreviews
internal fun LayoutPreview() {
    PreviewTheme(
        padding = PaddingValues(0.dp),
    ) {
        val columns = Layout.columns
        val bodyMargin = Layout.bodyMargin
        val gutter = Layout.gutter

        Box(Modifier.fillMaxSize()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(columns / 4),
                contentPadding = PaddingValues(
                    horizontal = bodyMargin,
                    vertical = gutter,
                ),
                // We minus 8.dp off the grid padding, as we use content padding on the items below
                horizontalArrangement = Arrangement.spacedBy(gutter),
                verticalArrangement = Arrangement.spacedBy(gutter),
                modifier = Modifier
                    .bodyWidth()
                    .fillMaxHeight()
                    .background(SparkTheme.colors.primaryContainer),
            ) {
                items(
                    count = 20,
                ) {
                    Item()
                }
            }
        }
    }
}

@Composable
private fun Item() {
    SparkTheme(isPro = true) {
        Surface(
            modifier = Modifier
                .aspectRatio(2 / 3f),
            color = SparkTheme.colors.primary,
            shape = SparkTheme.shapes.medium,
            shadowElevation = 4.dp,
            tonalElevation = 4.dp,
        ) {
            Box(
                modifier = Modifier.padding(8.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "",
                    style = SparkTheme.typography.body,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}
