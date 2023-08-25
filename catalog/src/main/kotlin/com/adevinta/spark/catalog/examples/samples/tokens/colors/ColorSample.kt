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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.tokens.SparkColors
import kotlin.reflect.KProperty0
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.memberProperties

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ColorSample() {
    val tokens = tokensColors
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        items(tokens) { token ->
            Row {
                token.forEach {
                    ColorItem(it)
                }
            }
        }
    }
}

@Composable
private fun RowScope.ColorItem(color: KProperty0<Color>) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .heightIn(104.dp)
            .weight(1f),
        color = color.get(),
        shape = SparkTheme.shapes.extraLarge,
        border = BorderStroke(2.dp, SparkTheme.colors.onBackground),
    ) {
        Box(
            modifier = Modifier.padding(8.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = color.name,
                style = SparkTheme.typography.body2,
                textAlign = TextAlign.Center,
            )
        }
    }
}

private val tokensColors
    @Composable
    get() = SparkColors::class.memberProperties.filterIsInstance<KProperty0<Color>>()
        .filterNot { field ->
            field.hasAnnotation<Deprecated>()
        }.groupBy {
            // Group by token name like "main",  "mainContainer" or "mainVariant"
            it.name.takeWhile { !it.isUpperCase() }
        }.values.toList()

@Preview
@Composable
private fun ColorSamplePreview() {
    SparkTheme {
        ColorSample()
    }
}
