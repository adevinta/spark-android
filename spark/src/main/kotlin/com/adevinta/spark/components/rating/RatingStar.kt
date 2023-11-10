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
package com.adevinta.spark.components.rating

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.icons.StarFill
import com.adevinta.spark.icons.StarOutline
import com.adevinta.spark.tokens.dim3
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

/**
 * RatingStar is the atomic element of rating components
 * @param modifier to be applied
 * @param size of the star, can be any size but preferably
 * use [RatingDefault.StarSize] or [RatingDefault.SmallStarSize].
 * @param enabled whether the star should be colored
 */
@Composable
@InternalSparkApi
internal fun SparkRatingStar(
    modifier: Modifier = Modifier,
    size: Dp = RatingDefault.SmallStarSize,
    enabled: Boolean = true,
) {
    val color by animateColorAsState(
        targetValue = if (enabled) {
            SparkTheme.colors.mainVariant
        } else {
            SparkTheme.colors.onSurface.dim3
        },
        label = "star color",
    )
    val icon = if (enabled) SparkIcons.StarFill else SparkIcons.StarOutline

    CompositionLocalProvider(LocalContentColor provides color) {
        Icon(
            modifier = modifier.size(size),
            sparkIcon = icon,
            contentDescription = null,
        )
    }
    val isRtl = LocalLayoutDirection.current == LayoutDirection.Rtl
    Box(modifier = modifier) {
        FilledStar(
            fraction,
            style,
            isRtl,
            painterFilled
        )
        EmptyStar(fraction, style, isRtl, painterEmpty)
    }
}

public object RatingDefault {
    public val StarSize: Dp = 16.dp
    public val SmallStarSize: Dp = 12.dp
    public val LabelSide: RatingLabelSide = RatingLabelSide.End
}

@Composable
@Preview
private fun RatingStarPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        SparkRatingStar(enabled = true)
        SparkRatingStar(enabled = false)
    }
}
