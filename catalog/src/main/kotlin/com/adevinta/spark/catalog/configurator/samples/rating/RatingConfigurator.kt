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
package com.adevinta.spark.catalog.configurator.samples.rating

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.themes.SegmentedButton
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.rating.RatingDefault
import com.adevinta.spark.components.rating.RatingDisplay
import com.adevinta.spark.components.slider.Slider
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.tokens.highlight

public val RatingsConfigurator: Configurator = Configurator(
    name = "Rating Display",
    description = "Rating Display configuration",
    sourceUrl = "$SampleSourceUrl/RatingDisplaySample.kt",
) {
    RatingSample()
}

@Suppress("DEPRECATION")
@Preview(
    showBackground = true,
)
@Composable
private fun RatingSample() {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.verticalScroll(scrollState),
    ) {
        var value by remember { mutableFloatStateOf(3.5f) }
        var size by remember { mutableStateOf(RatingSize.Small) }

        ConfiguredRating(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            value = value,
            size = size.size,
        )

        Column {
            Text(
                text = "Size",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.highlight,
            )
            val ratingSizes = RatingSize.entries
            val ratingSizesLabel = ratingSizes.map { it.name }
            SegmentedButton(
                options = ratingSizesLabel,
                selectedOption = size.name,
                onOptionSelect = { size = RatingSize.valueOf(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }

        Column {
            Text(
                text = "Rating value: $value",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.highlight,
            )
            Slider(
                modifier = Modifier.fillMaxWidth().safeGesturesPadding(),
                value = value,
                onValueChange = { value = it },
                enabled = true,
                steps = 9,
                valueRange = 0.5f..5f,
            )
        }
    }
}

private enum class RatingSize(val size: Dp) {
    Small(RatingDefault.SmallStarSize),
    Medium(RatingDefault.StarSize),
}

@Composable
private fun ConfiguredRating(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.5, to = 5.0)
    value: Float,
    size: Dp = RatingDefault.SmallStarSize,
) {
    Surface(
        modifier = modifier,
        color = SparkTheme.colors.backgroundVariant,
    ) {
        Box(
            modifier = Modifier.padding(8.dp),
        ) {
            RatingDisplay(
                value = value.coerceIn(0.5f, 5f),
                size = size,
            )
        }
    }
}

private enum class TagStyle {
    Filled,
    Outlined,
    Tinted,
}
