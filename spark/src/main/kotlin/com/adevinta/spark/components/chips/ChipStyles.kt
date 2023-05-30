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
package com.adevinta.spark.components.chips

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import com.adevinta.spark.SparkTheme

public enum class ChipStyles {
    Outlined {
        @Composable
        override fun colors(intent: ChipIntent): ChipColors {
            val contentColor = intent.colors().color
            return ChipColors(
                backgroundColor = Color.Transparent,
                contentColor = contentColor,
                disabledBackgroundColor = Color.Transparent,
                disabledContentColor = contentColor.copy(alpha = SparkTheme.colors.dim3)
                    .compositeOver(SparkTheme.colors.surface),
            )
        }
    },
    Filled {
        @Composable
        override fun colors(intent: ChipIntent): ChipColors {
            val backgroundColor = intent.colors().color
            val contentColor = intent.colors().onColor
            return ChipColors(
                backgroundColor = backgroundColor,
                contentColor = contentColor,
                disabledBackgroundColor = backgroundColor.copy(alpha = SparkTheme.colors.dim3)
                    .compositeOver(SparkTheme.colors.surface),
                disabledContentColor = contentColor.copy(alpha = SparkTheme.colors.dim3)
                    .compositeOver(SparkTheme.colors.surface),
            )
        }
    },
    Tinted {
        @Composable
        override fun colors(intent: ChipIntent): ChipColors {
            val backgroundColor = intent.colors().containerColor
            val contentColor = intent.colors().onContainerColor
            return ChipColors(
                backgroundColor = backgroundColor,
                contentColor = contentColor,
                disabledBackgroundColor = backgroundColor.copy(alpha = SparkTheme.colors.dim3)
                    .compositeOver(SparkTheme.colors.surface),
                disabledContentColor = contentColor.copy(alpha = SparkTheme.colors.dim3)
                    .compositeOver(SparkTheme.colors.surface),
            )
        }
    },
    Dashed {
        @Composable
        override fun colors(intent: ChipIntent): ChipColors {
            val contentColor = intent.colors().color
            return ChipColors(
                backgroundColor = Color.Transparent,
                contentColor = contentColor,
                disabledBackgroundColor = Color.Transparent,
                disabledContentColor = contentColor.copy(alpha = SparkTheme.colors.dim3)
                    .compositeOver(SparkTheme.colors.surface),
            )
        }
    },
    ;

    @Composable
    internal abstract fun colors(intent: ChipIntent): ChipColors
}

@Immutable
internal data class ChipColors(
    val backgroundColor: Color,
    val contentColor: Color,
    val disabledBackgroundColor: Color,
    val disabledContentColor: Color,
)

@Composable
public fun ChipStyles.border(intent: ChipIntent, enabled: Boolean): BorderStroke? {
    if (this != ChipStyles.Outlined) return null
    val colors = this.colors(intent = intent)
    val borderColor = if (enabled) colors.contentColor else colors.disabledContentColor
    return BorderStroke(width = ChipDefaults.BorderStrokeWidth, color = borderColor)
}
