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

package com.adevinta.spark.components.toggles

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwitchDefaults as MaterialSwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import com.adevinta.spark.SparkTheme

internal object SwitchDefaults {

    @Composable
    fun colors(
        checkedThumbColor: Color = SparkTheme.colors.surface,
        checkedTrackColor: Color = SparkTheme.colors.primary,
        checkedBorderColor: Color = Color.Transparent,
        checkedIconColor: Color = SparkTheme.colors.primary,
        uncheckedThumbColor: Color = SparkTheme.colors.surface,
        uncheckedTrackColor: Color = SparkTheme.colors.onSurface.copy(alpha = SparkTheme.colors.dim4),
        uncheckedBorderColor: Color = Color.Transparent,
        uncheckedIconColor: Color =SparkTheme.colors.onSurface.copy(alpha = SparkTheme.colors.dim4),
        disabledCheckedThumbColor: Color = checkedThumbColor.copy(alpha = SparkTheme.colors.dim3)
            .compositeOver(MaterialTheme.colorScheme.surface),
        disabledCheckedTrackColor: Color = checkedTrackColor.copy(alpha = SparkTheme.colors.dim4)
            .compositeOver(MaterialTheme.colorScheme.surface),
        disabledCheckedBorderColor: Color = Color.Transparent,
        disabledCheckedIconColor: Color = checkedIconColor.copy(alpha = SparkTheme.colors.dim3)
            .compositeOver(MaterialTheme.colorScheme.surface),
        disabledUncheckedThumbColor: Color = uncheckedThumbColor.copy(alpha = SparkTheme.colors.dim3)
            .compositeOver(MaterialTheme.colorScheme.surface),
        disabledUncheckedTrackColor: Color = uncheckedTrackColor.copy(alpha = SparkTheme.colors.dim5)
            .compositeOver(MaterialTheme.colorScheme.surface),
        disabledUncheckedBorderColor: Color = Color.Transparent,
        disabledUncheckedIconColor: Color = uncheckedIconColor.copy(alpha = SparkTheme.colors.dim5)
            .compositeOver(MaterialTheme.colorScheme.surface),
    ) = MaterialSwitchDefaults.colors(
        checkedThumbColor = checkedThumbColor,
        checkedTrackColor = checkedTrackColor,
        checkedBorderColor = checkedBorderColor,
        checkedIconColor = checkedIconColor,
        uncheckedThumbColor = uncheckedThumbColor,
        uncheckedTrackColor = uncheckedTrackColor,
        uncheckedBorderColor = uncheckedBorderColor,
        uncheckedIconColor = uncheckedIconColor,
        disabledCheckedThumbColor = disabledCheckedThumbColor,
        disabledCheckedTrackColor = disabledCheckedTrackColor,
        disabledCheckedBorderColor = disabledCheckedBorderColor,
        disabledCheckedIconColor = disabledCheckedIconColor,
        disabledUncheckedThumbColor = disabledUncheckedThumbColor,
        disabledUncheckedTrackColor = disabledUncheckedTrackColor,
        disabledUncheckedBorderColor = disabledUncheckedBorderColor,
        disabledUncheckedIconColor = disabledUncheckedIconColor
    )
}
