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

package com.adevinta.spark.components.icons

import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.adevinta.spark.SparkTheme

public enum class IconTints {
    /**
     * Used for the most important information.
     */
    Primary {
        @Composable
        override fun color() = SparkTheme.colors.primary
    },

    /**
     * Used to highlight/accentuate.
     */
    Secondary {
        @Composable
        override fun color() = SparkTheme.colors.secondary
    },

    /**
     * Icon on a color / image panel without on intent color.
     */
    Surface {
        @Composable
        override fun color() = SparkTheme.colors.surface
    },

    /**
     * Used for confirmation.
     */
    Success {
        @Composable
        override fun color() = SparkTheme.colors.success
    },

    /**
     * Used for warning.
     */
    Alert {
        @Composable
        override fun color() = SparkTheme.colors.alert
    },

    /**
     * Used to alert.
     */
    Danger {
        @Composable
        override fun color() = SparkTheme.colors.error
    },

    /**
     * Used for low importance information.
     */
    Neutral {
        @Composable
        override fun color() = SparkTheme.colors.neutral
    },

    /**
     * Used for low importance information.
     */
    Current {
        @Composable
        override fun color() = LocalContentColor.current
    },

    /**
     * Used for low importance information.
     */
    Unspecified {
        @Composable
        override fun color() = Color.Unspecified
    };

    @Composable
    internal abstract fun color(): Color
}
