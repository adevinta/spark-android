/*
 * Copyright (c) 2024 Adevinta
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
    Success,
    Alert,
    Error,
    Info,
    Neutral,
    Main,
    Basic,
    Support,
    Accent,
    SurfaceInverse,
    ;

    internal val filledColor: Color
        @Composable get() = when (this) {
            Success -> SparkTheme.colors.success
            Alert -> SparkTheme.colors.alert
            Error -> SparkTheme.colors.error
            Info -> SparkTheme.colors.info
            Neutral -> SparkTheme.colors.neutral
            Main -> SparkTheme.colors.main
            Basic -> SparkTheme.colors.basic
            Support -> SparkTheme.colors.support
            Accent -> SparkTheme.colors.accent
            SurfaceInverse -> SparkTheme.colors.surfaceInverse
        }

    internal val tintedColor: Color
        @Composable get() = when (this) {
            Success -> SparkTheme.colors.successContainer
            Alert -> SparkTheme.colors.alertContainer
            Error -> SparkTheme.colors.errorContainer
            Info -> SparkTheme.colors.infoContainer
            Neutral -> SparkTheme.colors.neutralContainer
            Main -> SparkTheme.colors.mainContainer
            Basic -> SparkTheme.colors.basicContainer
            Support -> SparkTheme.colors.supportContainer
            Accent -> SparkTheme.colors.accentContainer
            SurfaceInverse -> SparkTheme.colors.surfaceInverse
        }
}
