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

public interface SparkStringAnnotations<T : Any> {

    public fun toSpanStyle(value: String, token: T): SpanStyle?

    public object Colors : SparkStringAnnotations<SparkColors> {
        public override fun toSpanStyle(value: String, token: SparkColors): SpanStyle = when (value) {
            "primary" -> token.primary
            "secondary" -> token.secondary
            "success" -> token.success
            "alert" -> token.alert
            "error" -> token.error
            "info" -> token.info
            "neutral" -> token.neutral
            else -> null
        }?.let(::SpanStyle) ?: SpanStyle().also { _ ->
            Log.d("StringResources", "Spark color annotation : $value is not supported")
        }
    }

    public object Typography : SparkStringAnnotations<SparkTypography> {
        public override fun toSpanStyle(value: String, token: SparkTypography): SpanStyle = when (value) {
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
            else -> null
        }?.toSpanStyle() ?: SpanStyle().also { _ ->
            Log.d("StringResources", "Spark typography annotation : $value is not supported")
        }
    }

    public companion object {
        public fun toSpanStyle(
            key: String,
            value: String,
            colors: SparkColors,
            typography: SparkTypography,
        ): SpanStyle {
            return when (key) {
                "color" -> Colors.toSpanStyle(value, colors)
                "typography" -> Typography.toSpanStyle(value, typography)
                else -> SpanStyle().also { _ ->
                    Log.d("StringResources", "Annotation  $this is not supported by spark")
                }
            }
        }
    }
}
