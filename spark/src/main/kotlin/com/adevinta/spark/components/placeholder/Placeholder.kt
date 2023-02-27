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

package com.adevinta.spark.components.placeholder

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tokens.contentColorFor
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import com.google.accompanist.placeholder.PlaceholderDefaults
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.fade
import com.google.accompanist.placeholder.material.color
import com.google.accompanist.placeholder.material.fadeHighlightColor
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmerHighlightColor
import com.google.accompanist.placeholder.shimmer

@Composable
private fun PlaceholderDefaults.sparkColor() = color(
    backgroundColor = SparkTheme.colors.surface,
    contentColor = contentColorFor(backgroundColor = SparkTheme.colors.surface),
    contentAlpha = 0.15f,
)

@Composable
private fun PlaceholderHighlight.Companion.sparkFade() = fade(
    highlightColor = PlaceholderDefaults.fadeHighlightColor(alpha = 0.3f),
    animationSpec = PlaceholderDefaults.fadeAnimationSpec,
)

@Composable
private fun PlaceholderHighlight.Companion.sparkShimmer() = shimmer(
    highlightColor = PlaceholderDefaults.shimmerHighlightColor(alpha = 0.3f),
    animationSpec = PlaceholderDefaults.shimmerAnimationSpec,
)

fun Modifier.defaultPlaceholder(visible: Boolean) =
    composed {
        placeholder(
            visible = visible,
            highlight = PlaceholderHighlight.sparkFade(),
            color = PlaceholderDefaults.sparkColor(),
            shape = SparkTheme.shapes.small,
        )
    }

fun Modifier.textPlaceholder(visible: Boolean) = composed {
    placeholder(
        visible = visible,
        highlight = PlaceholderHighlight.sparkFade(),
        color = PlaceholderDefaults.sparkColor(),
        shape = SparkTheme.shapes.full,
    )
}

fun Modifier.illustrationPlaceholder(
    visible: Boolean,
    shape: Shape,
) = composed {
    placeholder(
        visible = visible,
        highlight = PlaceholderHighlight.sparkShimmer(),
        color = PlaceholderDefaults.sparkColor(),
        shape = shape,
    )
}

@Preview(
    group = "Tokens",
    name = "Placeholder",
)
@Composable
internal fun PreviewPlaceHolder(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        Column(verticalArrangement = spacedBy(4.dp)) {
            Text("Text Placeholder")
            Text("Text Placeholder", modifier = Modifier.textPlaceholder(true))
            Text("Text Placeholder with longer text", modifier = Modifier.textPlaceholder(true))
            Text("Text short", modifier = Modifier.textPlaceholder(true))
        }
        Column(verticalArrangement = spacedBy(4.dp)) {
            Text("Default Placeholder")
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .defaultPlaceholder(true),
            )
        }
        Column(verticalArrangement = spacedBy(4.dp)) {
            Text("Illustration Placeholder")
            Box(
                modifier = Modifier
                    .size(128.dp)
                    .illustrationPlaceholder(visible = true, shape = SparkTheme.shapes.extraLarge),
            )
        }
    }
}
