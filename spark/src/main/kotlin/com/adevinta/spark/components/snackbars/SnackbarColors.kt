/*
 * Copyright (c) 2023-2024 Adevinta
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

@Deprecated(
    message = "Use SnackbarIntent instead as this class supported only 3 intents out of 10",
    replaceWith = ReplaceWith(
        "SnackbarIntent",
        "com.adevinta.spark.components.snackbars.SnackbarIntent",
    ),
    level = DeprecationLevel.ERROR,
)
public enum class SnackbarColors {

    @Deprecated(
        message = "Use SnackbarDefaults.intent instead as it's the new default snackbar color",
        replaceWith = ReplaceWith(
            "SnackbarDefaults.intent",
            "com.adevinta.spark.components.snackbars.intent",
            "androidx.compose.material3.SnackbarDefaults",
        ),
        level = DeprecationLevel.ERROR,
    )
    Default {
        override val baseColor: Color
            @Composable get() {
                return SparkTheme.colors.supportContainer
            }
    },

    @Deprecated(
        message = "Use SnackbarIntent.Error instead",
        replaceWith = ReplaceWith(
            "SnackbarIntent.Error",
            "com.adevinta.spark.components.snackbars.SnackbarIntent",
        ),
        level = DeprecationLevel.ERROR,
    )
    Error {
        override val baseColor: Color
            @Composable get() {
                return SparkTheme.colors.errorContainer
            }
    },

    @Deprecated(
        message = "Use SnackbarIntent.Success instead",
        replaceWith = ReplaceWith(
            "SnackbarIntent.Success",
            "com.adevinta.spark.components.snackbars.SnackbarIntent",
        ),
        level = DeprecationLevel.ERROR,
    )
    Valid {
        override val baseColor: Color
            @Composable get() {
                return SparkTheme.colors.successContainer
            }
    },
    ;

    @get:Composable
    public abstract val baseColor: Color
}
