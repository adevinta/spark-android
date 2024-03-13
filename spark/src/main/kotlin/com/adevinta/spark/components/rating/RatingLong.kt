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
import java.util.Locale

/**
 * Component that displays rating of an user with stars in the following form:
 *  - ★★★★★ (5)
 *  - ★★★★★ 5 avis
 * @param value rating value as a float, should be between 1.0 and 5.0
 * @param label the number of reviews to be displayed after the rating stars.
 * @param commentCount the number of reviews to be displayed after the rating stars.
 * @param locale the local used to format the rating value, use the first available Locale by default.
 * @param modifier to be applied to this rating
 */
@InternalSparkApi
@Composable
internal fun SparkRating(
    @FloatRange(from = 0.0, to = 5.0) value: Float,
    label: String?,
    commentCount: Int?,
    locale: Locale?,
    modifier: Modifier = Modifier,
) {
    if (value !in 1f..5f) return

    val labelText = locale?.let { formattedRatingValue(locale, value) }

    val contentDescription = if (commentCount != null) {
        pluralStringResource(
            id = R.plurals.spark_rating_with_comments_a11y,
            count = commentCount,
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
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        if (labelText != null) {
            Text(
                text = labelText,
                textAlign = TextAlign.Center,
                style = SparkTheme.typography.caption.highlight,
            )
        }

        RatingDisplay(value = value)

        if (label != null) {
            Text(
                modifier = Modifier,
                text = label,
                textAlign = TextAlign.Center,
                style = SparkTheme.typography.body2.highlight,
            )
        }
        if (commentCount != null) {
            Text(
                text = stringResource(id = R.string.spark_rating_label, commentCount),
                textAlign = TextAlign.Center,
                style = SparkTheme.typography.caption,
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
@Deprecated(
    message = "Use RatingFull instead as the label is not the same anymore",
    replaceWith = ReplaceWith(
        expression = "RatingFull(value = value, modifier = modifier, locale = null)",
        imports = [
            "com.adevinta.spark.components.rating.RatingFull",
        ],
    ),
)
/**
 * @param value rating value as a float, should be between 0.0 and 5.0
 * @param modifier to be applied to this rating
 */
@Composable
public fun RatingNaked(
    @FloatRange(from = 0.0, to = 5.0) value: Float,
    modifier: Modifier = Modifier,
) {
    SparkRating(
        modifier = modifier,
        value = value,
        label = null,
        commentCount = null,
        locale = null,
    )
}

/**
 * Display the [value] rating of an user with stars followed by the [commentCount] in the following form `★★★★★ (5)`
 *
 * @param value rating value as a float, should be between 0.0 and 5.0
 * @param commentCount the nb of reviews to be displayed after the rating stars.
 * @param modifier to apply
 */
@Composable
@Deprecated(
    message = "Use RatingFull instead as the label is not the same anymore",
    replaceWith = ReplaceWith(
        expression = "RatingFull(value = value, modifier = modifier, commentCount = commentCount, locale = null)",
        imports = [
            "com.adevinta.spark.components.rating.RatingFull",
            "com.adevinta.spark.components.rating.firstLocale",
        ],
    ),
)
/**
 * @param value rating value as a float, should be between 0.0 and 5.0
 * @param commentCount the nb of reviews to be displayed after the rating stars.
 * @param modifier to apply
 */
public fun RatingCompressed(
    @FloatRange(from = 0.0, to = 5.0) value: Float,
    commentCount: Int,
    modifier: Modifier = Modifier,
) {
    SparkRating(
        modifier = modifier,
        value = value,
        commentCount = commentCount,
        label = null,
        locale = null,
    )
}

/**
 * Display the [value] rating of an user with stars followed by the [commentCount] in the following form `★★★★★ 5 avis`
 *
 * @param value rating value as a float, should be between 0.0 and 5.0
 * @param commentCount the nb of reviews to be displayed after the rating stars.
 * @param modifier to apply
 */
@Deprecated(
    message = "Use RatingFull instead as the label is not the same anymore",
    replaceWith = ReplaceWith(
        expression = "RatingFull(value = value, modifier = modifier, commentCount = null, locale = null," +
            " label = pluralStringResource(R.plurals.spark_rating_with_comments_count_label," +
            " commentCount, commentCount))",
        imports = [
            "com.adevinta.spark.components.rating.RatingFull",
            "com.adevinta.spark.components.rating.firstLocale",
            "androidx.compose.ui.res.pluralStringResource",
            "com.adevinta.spark.R",
        ],
    ),
)
/**
 * @param value rating value as a float, should be between 0.0 and 5.0
 * @param commentCount the nb of reviews to be displayed after the rating stars.
 * @param modifier to apply
 */
@Composable
public fun RatingFull(
    @FloatRange(from = 0.0, to = 5.0) value: Float,
    commentCount: Int,
    modifier: Modifier = Modifier,
) {
    SparkRating(
        modifier = modifier,
        value = value,
        label = pluralStringResource(id = R.plurals.spark_rating_with_comments_count_label, commentCount, commentCount),
        commentCount = null,
        locale = null,
    )
}

/**
 * Display the [value] rating of an user with stars optionally followed by a label and/or
 * [commentCount] in the following form **`3,4 ★★★☆☆ Communication (5)`**
 *
 * @param value rating value as a float, should be between 0.0 and 5.0
 * @param modifier to apply
 * @param commentCount the nb of reviews to be displayed after the rating stars.
 * @param label the nb of reviews to be displayed after the rating stars.
 * @param locale the local used to format the rating value, use the first available Locale by default.
 * Use `null` to hide the rating value before the stars
 */
@Composable
public fun RatingFull(
    @FloatRange(from = 0.0, to = 5.0) value: Float,
    modifier: Modifier = Modifier,
    commentCount: Int? = null,
    label: String? = null,
    locale: Locale? = firstLocale(),
) {
    SparkRating(
        modifier = modifier,
        value = value,
        label = label,
        commentCount = commentCount,
        locale = locale,
    )
}

@Suppress("DEPRECATION")
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
        RatingFull(
            value = 3.6f,
            commentCount = null,
            locale = null,
            label = pluralStringResource(R.plurals.spark_rating_with_comments_count_label, count = 23, 23),
        )
        RatingFull(value = 5f, commentCount = 1000002)
    }
}

@Suppress("DEPRECATION")
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
        RatingFull(value = 2.8f, modifier = Modifier, commentCount = 23, locale = null)
        RatingCompressed(value = 4.2f, commentCount = 1000002)
    }
}

@Suppress("DEPRECATION")
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
        RatingFull(value = 3.999999f, locale = Locale.US)
        RatingNaked(value = 4.2f)
        RatingNaked(value = 5f)
    }
}

@Composable
@Preview(
    group = "Ratings",
    name = "SparkRatingFull",
)
private fun SparkRatingFullPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        RatingFull(value = 1f, label = "Communication")
        RatingFull(value = 2.1f, label = "Communication", commentCount = 5)
        RatingFull(value = 3.999999f, commentCount = 5, locale = null)
        RatingFull(value = 4.2f)
        RatingFull(value = 5f)
    }
}
