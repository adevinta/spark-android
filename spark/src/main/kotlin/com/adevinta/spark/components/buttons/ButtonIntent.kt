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

package com.adevinta.spark.components.buttons

import androidx.compose.runtime.Composable
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.IntentColor

/**
 * ButtonIntent is used to define the intent of the buttons.
 */
public enum class ButtonIntent {
    /**
     * Primary buttons are used for the most important actions.
     */
    Primary {
        @Composable
        override fun colors() = IntentColor(
            color = SparkTheme.colors.primary,
            onColor = SparkTheme.colors.onPrimary,
            containerColor = SparkTheme.colors.primaryContainer,
            onContainerColor = SparkTheme.colors.onPrimaryContainer,
        )
    },

    /**
     * Secondary buttons are used to highlight/accentuate actions.
     */
    Secondary {
        @Composable
        override fun colors() = IntentColor(
            color = SparkTheme.colors.secondary,
            onColor = SparkTheme.colors.onSecondary,
            containerColor = SparkTheme.colors.secondaryContainer,
            onContainerColor = SparkTheme.colors.onSecondaryContainer,
        )
    },

    /**
     * Actions on a color / image panel without on intent color.
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

    /**
     * Used for confirmation actions.
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
     * Used for warning actions.
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
     * Used for risky actions.
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
     * Used for low or irrelevant actions.
     */
    Neutral {
        @Composable
        override fun colors() = IntentColor(
            color = SparkTheme.colors.neutral,
            onColor = SparkTheme.colors.onNeutral,
            containerColor = SparkTheme.colors.neutralContainer,
            onContainerColor = SparkTheme.colors.onNeutralContainer,
        )
    };

    @Composable
    internal abstract fun colors(): IntentColor
}
