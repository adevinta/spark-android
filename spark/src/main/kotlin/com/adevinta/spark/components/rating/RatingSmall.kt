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

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.R
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tokens.EmphasizeMedium
import com.adevinta.spark.tools.preview.SparkPreviewParam
import com.adevinta.spark.tools.preview.SparkPreviewParamProvider
import java.lang.String.format
import java.util.Locale

/**
 * Component that displays rating of an user with a star in the following form:
 *  - * 3,4
 *  - * 3,4 (5)
 * @param value rating value as a float, should be between 1.0 and 5.0
 * @param modifier to apply
 * @param commentCount the count of comments are associated with this rating
 */
@InternalSparkApi
@Composable
internal fun SparkRatingSmall(
    @FloatRange(from = 0.0, to = 5.0)
    value: Float,
    modifier: Modifier = Modifier,
    commentCount: Int? = null,
    locale: Locale = firstLocale(),
) {
    if (value !in 1f..5f) return
// TODO scott.rayapoulle.ext-21/12/2022: Use NumberFormat instead
    val format = if (value / value.toInt() == 1f) "%.0f" else "%.1f"
    val contentDescription: String = if (commentCount != null) {
        stringResource(
            id = R.string.spark_rating_with_comments_a11y,
            value,
            commentCount,
        )
    } else {
        stringResource(id = R.string.spark_rating_a11y, value)
    }

    Row(
        modifier = modifier.semantics(mergeDescendants = true) {
            this.contentDescription = contentDescription
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = spacedBy(4.dp),
    ) {
        SparkRatingStar(enabled = true)
        Text(
            text = format(locale, format, value),
            textAlign = TextAlign.Center,
            style = SparkTheme.typography.caption,
        )
        if (commentCount != null) {
            EmphasizeMedium {
                Text(
                    text = format(locale, "(%d)", commentCount),
                    textAlign = TextAlign.Center,
                    style = SparkTheme.typography.caption,
                )
            }
        }
    }
}

/**
 * Component that displays a compressed version of user rating
 *
 * @param value the rating value included between [1..5]
 * @param modifier to be applied to this rating
 * @param commentCount number of collected ratings
 */
@Composable
public fun RatingSmall(
    @FloatRange(from = 0.0, to = 5.0)
    value: Float,
    modifier: Modifier = Modifier,
    commentCount: Int? = null,
    locale: Locale = firstLocale(),
) {
    SparkRatingSmall(
        value = value,
        modifier = modifier,
        commentCount = commentCount,
        locale = locale,
    )
}

@Composable
internal fun firstLocale(): Locale {
    LocalConfiguration.current
    return LocalContext.current.resources.configuration.locales.get(0)
}

@Composable
@Preview(
    group = "Ratings",
    name = "RatingSmall",
)
internal fun RatingSmallPreview(
    @PreviewParameter(SparkPreviewParamProvider::class) param: SparkPreviewParam,
) {
    val (theme, userType) = param
    val frenchLocale = Locale("fr", "rFR")
    PreviewTheme(theme, userType) {
        RatingSmall(value = 3.0f, locale = frenchLocale)
        RatingSmall(value = 4.50f, locale = frenchLocale)

        RatingSmall(value = 3.0f, commentCount = 8, locale = frenchLocale)
        RatingSmall(value = 4.50f, commentCount = 12, locale = frenchLocale)
    }
}
