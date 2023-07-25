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

import androidx.compose.runtime.Composable
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.IntentColor

/**
 * ChipIntent is used to define the intent of the chip.
 */
public enum class ChipIntent {
    /**
     * Used for the most important information.
     */
    Main {
        @Composable
        override fun colors() = IntentColor(
            color = SparkTheme.colors.main,
            onColor = SparkTheme.colors.onMain,
            containerColor = SparkTheme.colors.mainContainer,
            onContainerColor = SparkTheme.colors.onMainContainer,
        )
    },

    /**
     * Used to highlight information.
     */
    Support {
        @Composable
        override fun colors() = IntentColor(
            color = SparkTheme.colors.support,
            onColor = SparkTheme.colors.onSupport,
            containerColor = SparkTheme.colors.supportContainer,
            onContainerColor = SparkTheme.colors.onSupportContainer,
        )
    },

    /**
     * Used for feedbacks that are positive.
     */
    Success {
        @Composable
        override fun colors() = IntentColor(
            color = SparkTheme.colors.success,
            onColor = SparkTheme.colors.onSuccess,
            containerColor = SparkTheme.colors.successContainer,
            onContainerColor = SparkTheme.colors.onSuccessContainer,
        )
    },

    /**
     * Used for feedbacks that are negative.
     */
    Alert {
        @Composable
        override fun colors() = IntentColor(
            color = SparkTheme.colors.alert,
            onColor = SparkTheme.colors.onAlert,
            containerColor = SparkTheme.colors.alertContainer,
            onContainerColor = SparkTheme.colors.onAlertContainer,
        )
    },

    /**
     * Used for feedbacks that are negative and dangerous.
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
     * Used for feedbacks that are informative.
     */
    Info {
        @Composable
        override fun colors() = IntentColor(
            color = SparkTheme.colors.info,
            onColor = SparkTheme.colors.onInfo,
            containerColor = SparkTheme.colors.infoContainer,
            onContainerColor = SparkTheme.colors.onInfoContainer,
        )
    },

    /**
     * Used for feedbacks that are neutral.
     */
    Neutral {
        @Composable
        override fun colors() = IntentColor(
            color = SparkTheme.colors.neutral,
            onColor = SparkTheme.colors.onNeutral,
            containerColor = SparkTheme.colors.neutralContainer,
            onContainerColor = SparkTheme.colors.onNeutralContainer,
        )
    },

    /**
     * Chip on a color / image panel without on intent color.
     */
    Surface {
        @Composable
        override fun colors() = IntentColor(
            color = SparkTheme.colors.surface,
            onColor = SparkTheme.colors.onSurface,
            containerColor = SparkTheme.colors.surface,
            onContainerColor = SparkTheme.colors.onSurface,
        )
    },
    ;

    @Composable
    internal abstract fun colors(): IntentColor
}
