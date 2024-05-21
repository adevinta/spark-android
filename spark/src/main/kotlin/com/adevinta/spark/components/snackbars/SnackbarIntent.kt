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
package com.adevinta.spark.components.snackbars

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.adevinta.spark.SparkTheme

public enum class SnackbarIntent {

    @Deprecated(
        message = "Use Success instead",
        replaceWith = ReplaceWith("Success")
    )
    Valid {
        override val filledColor: Color
            @Composable get() = SparkTheme.colors.success
        override val outlinedColor: Color
            @Composable get() = SparkTheme.colors.successContainer
    },

    Success {
        override val filledColor: Color
            @Composable get() = SparkTheme.colors.success
        override val outlinedColor: Color
            @Composable get() = SparkTheme.colors.successContainer
    },

    Alert {
        override val filledColor: Color
            @Composable get() = SparkTheme.colors.alert
        override val outlinedColor: Color
            @Composable get() = SparkTheme.colors.alertContainer
    },

    Error {
        override val filledColor: Color
            @Composable get() = SparkTheme.colors.error
        override val outlinedColor: Color
            @Composable get() = SparkTheme.colors.errorContainer
    },

    Info {
        override val filledColor: Color
            @Composable get() = SparkTheme.colors.info
        override val outlinedColor: Color
            @Composable get() = SparkTheme.colors.infoContainer
    },

    Neutral {
        override val filledColor: Color
            @Composable get() = SparkTheme.colors.neutral
        override val outlinedColor: Color
            @Composable get() = SparkTheme.colors.neutralContainer
    },

    Main {
        override val filledColor: Color
            @Composable get() = SparkTheme.colors.main
        override val outlinedColor: Color
            @Composable get() = SparkTheme.colors.mainContainer
    },

    Basic {
        override val filledColor: Color
            @Composable get() = SparkTheme.colors.basic
        override val outlinedColor: Color
            @Composable get() = SparkTheme.colors.basicContainer
    },

    @Deprecated(
        message = "Use Support instead",
        replaceWith = ReplaceWith("Support")
    )
    Default {
        override val filledColor: Color
            @Composable get() = SparkTheme.colors.support
        override val outlinedColor: Color
            @Composable get() = SparkTheme.colors.supportContainer
    },

    Support {
        override val filledColor: Color
            @Composable get() = SparkTheme.colors.support
        override val outlinedColor: Color
            @Composable get() = SparkTheme.colors.supportContainer
    },

    Accent {
        override val filledColor: Color
            @Composable get() = SparkTheme.colors.accent
        override val outlinedColor: Color
            @Composable get() = SparkTheme.colors.accentContainer
    },

    SurfaceInverse {
        override val filledColor: Color
            @Composable get() = SparkTheme.colors.surfaceInverse
        override val outlinedColor: Color
            @Composable get() = Color.Unspecified
    },

    ;

    @get:Composable
    internal abstract val filledColor: Color

    @get:Composable
    internal abstract val outlinedColor: Color
}
