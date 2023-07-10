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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
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
import com.adevinta.spark.tokens.highlight
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

/**
 * Component that displays rating of an user with stars in the following form:
 *  - ***** (5)
 *  - ***** 5 avis
 * @param value rating value as a float, should be between 1.0 and 5.0
 * @param contentDescription description indicate wha is the rating and how many comments are associated with it
 * @param label the nb of comments to be displayed after the rating stars.
 * @param modifier to apply
 */
@InternalSparkApi
@Composable
internal fun SparkRatingLong(
    @FloatRange(from = 0.0, to = 5.0)
    value: Float,
    contentDescription: String,
    label: String?,
    modifier: Modifier = Modifier,
) {
    if (value !in 1f..5f) return

    Row(
        modifier = modifier.semantics(mergeDescendants = true) {
            this.contentDescription = contentDescription
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        repeat(5) {
            SparkRatingStar(
                modifier = Modifier,
                enabled = value >= (it + 1),
            )
        }

        if (label != null) {
            Text(
                modifier = Modifier,
                text = label,
                textAlign = TextAlign.Center,
                style = SparkTheme.typography.body2.highlight,
            )
        }
    }
}

/**
 * Component that displays rating of an user with stars in the following form `*****`
 *
 * @param value rating value as a float, should be between 0.0 and 5.0
 * @param modifier to be applied to this rating
 */
@Composable
public fun RatingNaked(
    @FloatRange(from = 0.0, to = 5.0)
    value: Float,
    modifier: Modifier = Modifier,
) {
    SparkRatingLong(
        modifier = modifier,
        value = value,
        contentDescription = stringResource(id = R.string.spark_rating_a11y, value),
        label = null,
    )
}

/**
 * Display the [value] rating of an user with stars followed by the [commentCount] in the following form `***** (5)`
 *
 * @param value rating value as a float, should be between 0.0 and 5.0
 * @param commentCount the nb of comments to be displayed after the rating stars.
 * @param modifier to apply
 */
@Composable
@Suppress("ktlint:trailing-comma-on-call-site")
public fun RatingCompressed(
    @FloatRange(from = 0.0, to = 5.0)
    value: Float,
    commentCount: Int,
    modifier: Modifier = Modifier,
) {
    SparkRatingLong(
        modifier = modifier,
        value = value,
        contentDescription = pluralStringResource(
            id = R.plurals.spark_rating_with_comments_a11y,
            commentCount,
            value,
            commentCount,
        ),
        label = stringResource(id = R.string.spark_rating_label, commentCount),
    )
}

/**
 * Display the [value] rating of an user with stars followed by the [commentCount] in the following form `***** 5 avis`
 *
 * @param value rating value as a float, should be between 0.0 and 5.0
 * @param commentCount the nb of comments to be displayed after the rating stars.
 * @param modifier to apply
 */
@Composable
@Suppress("ktlint:trailing-comma-on-call-site")
public fun RatingFull(
    @FloatRange(from = 0.0, to = 5.0)
    value: Float,
    commentCount: Int,
    modifier: Modifier = Modifier,
) {
    SparkRatingLong(
        modifier = modifier,
        value = value,
        contentDescription = pluralStringResource(
            id = R.plurals.spark_rating_with_comments_a11y,
            commentCount,
            value,
            commentCount,
        ),
        label = pluralStringResource(id = R.plurals.spark_rating_with_comments_count_label, commentCount, commentCount),
    )
}

@Composable
@Preview(
    group = "Ratings",
    name = "RatingFull",
)
internal fun RatingFullPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        RatingFull(value = 1.6f, commentCount = 1)
        RatingFull(value = 3.6f, commentCount = 23)
        RatingFull(value = 5f, commentCount = 1000002)
    }
}

@Composable
@Preview(
    group = "Ratings",
    name = "RatingCompressed",
)
internal fun RatingCompressedPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        RatingCompressed(value = 1.6f, commentCount = 0)
        RatingCompressed(value = 2.8f, commentCount = 23)
        RatingCompressed(value = 4.2f, commentCount = 1000002)
    }
}

@Composable
@Preview(
    group = "Ratings",
    name = "RatingNaked",
)
internal fun RatingNakedPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        RatingNaked(value = 1f)
        RatingNaked(value = 2.1f)
        RatingNaked(value = 3.999999f)
        RatingNaked(value = 4.2f)
        RatingNaked(value = 5f)
    }
}
