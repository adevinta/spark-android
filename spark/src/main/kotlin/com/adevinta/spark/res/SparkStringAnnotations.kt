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

package com.adevinta.spark.res

import android.util.Log
import androidx.compose.ui.text.SpanStyle
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.SparkTypography

/**
 * Represents a set of annotations supported by spark that can be used in a string resource.
 */
public object SparkStringAnnotations {

    /**
     * Given a string representing an annotation key and a string representing an annotation value, returns the corresponding [SpanStyle].
     */
    public fun toSpanStyle(
        key: String,
        value: String,
        colors: SparkColors,
        typography: SparkTypography,
    ): SpanStyle? = when (key) {
        "color" -> value.toColorSpanStyle(colors)
        "typography" -> value.toTypographySpanStyle(typography)
        else -> null.also { _ ->
            Log.d("StringResources", "Annotation  $this is not supported by spark")
        }
    }

    /**
     * Given a string representing annotation value of a spark color, returns the corresponding [SpanStyle] with the color token.
     */
    private fun String.toColorSpanStyle(token: SparkColors): SpanStyle? = when (this) {
        "primary" -> token.primary
        "secondary" -> token.secondary
        "success" -> token.success
        "alert" -> token.alert
        "error" -> token.error
        "info" -> token.info
        "neutral" -> token.neutral
        else -> null.also { _ ->
            Log.d("StringResources", "Spark color annotation : $this is not supported")
        }
    }?.let(::SpanStyle)

    /**
     * Given a string representing annotation value of a spark typography, returns the corresponding [SpanStyle] with the typography token.
     */
    private fun String.toTypographySpanStyle(token: SparkTypography): SpanStyle? = when (this) {
        "title1" -> token.title1
        "title2" -> token.title2
        "title3" -> token.title3
        "large" -> token.large
        "largeImportant" -> token.largeImportant
        "bodyImportant" -> token.bodyImportant
        "body" -> token.body
        "smallImportant" -> token.smallImportant
        "small" -> token.small
        "extraSmallImportant" -> token.extraSmallImportant
        "extraSmall" -> token.extraSmall
        "button" -> token.button
        else -> null.also { _ ->
            Log.d("StringResources", "Spark typography annotation : $this is not supported")
        }
    }?.toSpanStyle()
}
