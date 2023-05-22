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

package com.adevinta.spark.components.badge

import androidx.compose.runtime.Composable
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.IntentColor

/**
 * BadgeIntent is used to define the intent of the badge.
 */
public enum class BadgeIntent {

    /**
     * Used for first level information
     */
    Danger {
        @Composable
        override fun colors() = IntentColor(
            color = SparkTheme.colors.error,
            onColor = SparkTheme.colors.onError,
            containerColor = SparkTheme.colors.errorContainer,
            onContainerColor = SparkTheme.colors.onErrorContainer,
        )
    },

    /**
     * Used to give information with no emphasis
     */
    Info {
        @Composable
        override fun colors() = IntentColor(
            color = SparkTheme.colors.info,
            onColor = SparkTheme.colors.onInfo,
            containerColor = SparkTheme.colors.infoContainer,
            onContainerColor = SparkTheme.colors.onInfoContainer,
        )
    };

    @Composable
    internal abstract fun colors(): IntentColor
}
