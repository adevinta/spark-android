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

package com.adevinta.spark.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.card.CardDefaults.OutlinedCardTokens.DisabledContainerElevation
import com.adevinta.spark.components.card.CardDefaults.OutlinedCardTokens.DisabledOutlineOpacity
import com.adevinta.spark.components.card.CardDefaults.OutlinedCardTokens.OutlineWidth
import com.adevinta.spark.tokens.DisabledAlpha
import com.adevinta.spark.tokens.contentColorFor
import androidx.compose.material3.CardDefaults as MaterialCardDefaults

public object CardDefaults {
    @Composable
    public fun cardColors(
        containerColor: Color = SparkTheme.colors.neutralContainer,
        disabledContainerColor: Color = SparkTheme.colors.neutralContainer
            .copy(alpha = DisabledAlpha)
            .compositeOver(SparkTheme.colors.surface),
        disabledContentColor: Color = SparkTheme.colors.contentColorFor(containerColor).copy(DisabledAlpha),
    ): CardColors = MaterialCardDefaults.cardColors(
        containerColor = containerColor,
        contentColor = SparkTheme.colors.contentColorFor(containerColor),
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor,
    )

    @Composable
    public fun elevatedCardColors(
        containerColor: Color = SparkTheme.colors.neutralContainer,
        contentColor: Color = SparkTheme.colors.contentColorFor(containerColor),
        disabledContainerColor: Color =
            SparkTheme.colors.surface
                .copy(alpha = DisabledAlpha)
                .compositeOver(
                    MaterialTheme.colorScheme.surfaceColorAtElevation(ElevationTokens.Level1),
                ),
        disabledContentColor: Color = contentColor.copy(DisabledAlpha),
    ): CardColors =
        MaterialCardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    public fun outlinedCardColors(
        containerColor: Color = SparkTheme.colors.neutralContainer,
        contentColor: Color = SparkTheme.colors.contentColorFor(containerColor),
        disabledContainerColor: Color = containerColor,
        disabledContentColor: Color = contentColor.copy(DisabledAlpha),
    ): CardColors =
        MaterialCardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    public fun outlinedCardBorder(enabled: Boolean = true): BorderStroke {
        val color = if (enabled) {
            SparkTheme.colors.outline
        } else {
            SparkTheme.colors.outline
                .copy(alpha = DisabledOutlineOpacity)
                .compositeOver(
                    MaterialTheme.colorScheme.surfaceColorAtElevation(
                        DisabledContainerElevation,
                    ),
                )
        }
        return remember(color) { BorderStroke(OutlineWidth, color) }
    }

    internal object ElevationTokens {
        val Level0 = 0.0.dp
        val Level1 = 1.0.dp
    }

    internal object OutlinedCardTokens {
        const val DisabledOutlineOpacity = 0.12f
        val DisabledContainerElevation = ElevationTokens.Level0
        val OutlineWidth = 1.0.dp
    }
}
