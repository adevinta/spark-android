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
package com.adevinta.spark.catalog.examples.samples.tokens.colors

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.surface.Surface

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ColorSample() {
    val scrollState = rememberScrollState()
    FlowRow(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxWidth(),
        maxItemsInEachRow = 3,
    ) {
        ColorItem(SparkTheme.colors.main, "main")
        ColorItem(SparkTheme.colors.mainContainer, "main Container")
        ColorItem(SparkTheme.colors.mainVariant, "main Variant")
        ColorItem(SparkTheme.colors.support, "support")
        ColorItem(SparkTheme.colors.supportContainer, "support Container")
        ColorItem(SparkTheme.colors.supportVariant, "support Variant")
        ColorItem(SparkTheme.colors.accent, "accent")
        ColorItem(SparkTheme.colors.accentContainer, "accent Container")
        ColorItem(SparkTheme.colors.accentVariant, "accent Variant")
        ColorItem(SparkTheme.colors.basic, "basic")
        ColorItem(SparkTheme.colors.basicContainer, "basic Container")
        ColorItem(SparkTheme.colors.background, "background")
        ColorItem(SparkTheme.colors.backgroundVariant, "backgroundVariant")
        ColorItem(SparkTheme.colors.surface, "surface")
        ColorItem(SparkTheme.colors.surfaceInverse, "surface inverse")
        ColorItem(SparkTheme.colors.outline, "outline")
        ColorItem(SparkTheme.colors.outlineHigh, "outline High")
        ColorItem(SparkTheme.colors.success, "success")
        ColorItem(SparkTheme.colors.successContainer, "success Container")
        ColorItem(SparkTheme.colors.alert, "alert")
        ColorItem(SparkTheme.colors.alertContainer, "alert Container")
        ColorItem(SparkTheme.colors.error, "error")
        ColorItem(SparkTheme.colors.errorContainer, "error Container")
        ColorItem(SparkTheme.colors.info, "info")
        ColorItem(SparkTheme.colors.infoContainer, "info Container")
        ColorItem(SparkTheme.colors.neutral, "neutral")
        ColorItem(SparkTheme.colors.neutralContainer, "neutral Container")
    }
}

@Composable
private fun RowScope.ColorItem(color: Color, colorName: String) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .sizeIn(minWidth = 104.dp, minHeight = 104.dp)
            .weight(1f),
        shape = SparkTheme.shapes.extraLarge,
        color = color,
        border = BorderStroke(2.dp, SparkTheme.colors.onBackground),
    ) {
        Box(
            modifier = Modifier.padding(8.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = colorName,
                style = SparkTheme.typography.body2,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
private fun ColorSamplePreview() {
    SparkTheme {
        ColorSample()
    }
}
