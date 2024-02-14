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
package com.adevinta.spark.components.divider

import androidx.compose.material3.DividerDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tokens.dim3
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import androidx.compose.material3.HorizontalDivider as MaterialDivider
import androidx.compose.material3.VerticalDivider as MaterialVerticalDivider

@ExperimentalSparkApi
@Composable
internal fun SparkDivider(
    modifier: Modifier = Modifier,
    color: Color = SparkTheme.colors.outline,
    thickness: Dp = DividerDefaults.Thickness,
) {
    MaterialDivider(
        modifier,
        thickness,
        color,
    )
}

/**
 * Spark divider.
 *
 * A divider is a thin line that groups content in lists and layouts.
 *
 * ![Divider image](https://developer.android.com/images/reference/androidx/compose/material3/divider.png)
 *
 * @param modifier the [Modifier] to be applied to this divider line.
 * @param color the color of the divider, we recommend to use either outline or onSurface dim 3.
 */
@ExperimentalSparkApi
@Composable
public fun Divider(
    modifier: Modifier = Modifier,
    color: Color = SparkTheme.colors.onSurface.dim3,
) {
    SparkDivider(
        modifier = modifier,
        thickness = DividerDefaults.Thickness,
        color = color,
    )
}

/**
 * Spark divider.
 *
 * A divider is a thin line that groups content in lists and layouts.
 *
 * ![Divider image](https://developer.android.com/images/reference/androidx/compose/material3/divider.png)
 *
 * @param modifier the [Modifier] to be applied to this divider line.
 * @param color the color of the divider, we recommend to use either outline or onSurface dim 3.
 */
@ExperimentalSparkApi
@Composable
public fun VerticalDivider(
    modifier: Modifier = Modifier,
    color: Color = SparkTheme.colors.onSurface.dim3,
) {
    MaterialVerticalDivider(
        modifier = modifier,
        thickness = DividerDefaults.Thickness,
        color = color,
    )
}

@Preview(
    group = "Separator",
    name = "Divider",
)
@Composable
internal fun DividerPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        Divider()
        Divider()
    }
}
