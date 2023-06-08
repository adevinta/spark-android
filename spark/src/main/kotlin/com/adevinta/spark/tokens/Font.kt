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

package com.adevinta.spark.tokens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.adevinta.spark.R
import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * Creates a [SparkFontFamily] with the given [fontFamily] and [useSparkTokensHighlighter].
 * @param fontFamily The [FontFamily] you want to use globally inside your app.
 * @param useSparkTokensHighlighter If true, the [FontFamily] will be replaced by [FontFamily.Cursive] when the
 * token highlighting is enabled in the SparkTheme.
 * @param isLegacy If true, the [FontFamily] will be replaced by [FontFamily.Default] as we still need to support the legacy UI in LBC.
 * @param fontHandler The [CoroutineExceptionHandler] you want to use to handle the font loading errors from the spark default [FontFamily.Resolver].
 */
public fun sparkFontFamily(
    fontFamily: FontFamily = nunitoFontFamily,
    useSparkTokensHighlighter: Boolean = false,
    isLegacy: Boolean = false,
    fontHandler: CoroutineExceptionHandler = defaultFontHandler,
): SparkFontFamily = SparkFontFamily(
    isLegacy = isLegacy,
    useSparkTokensHighlighter = useSparkTokensHighlighter,
    fontFamily = fontFamily,
    fontHandler = fontHandler,
)

/**
 *
 */
public class SparkFontFamily(
    private val isLegacy: Boolean,
    private val useSparkTokensHighlighter: Boolean,
    private val fontFamily: FontFamily,
    public val fontHandler: CoroutineExceptionHandler,
) {
    /**
     *
     */
    public val default: FontFamily
        @Composable @ReadOnlyComposable get() = when {
            LocalInspectionMode.current -> fontFamily
            useSparkTokensHighlighter -> FontFamily.Cursive
            isLegacy -> FontFamily.Default
            else -> fontFamily
        }
}

internal val nunitoFont = GoogleFont("Nunito")

internal val sparkFontProvider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.spark_com_google_android_gms_fonts_certs,
)

internal val nunitoFontFamily = FontFamily(
    fonts = listOf(
        Font(googleFont = nunitoFont, fontProvider = sparkFontProvider, weight = FontWeight.Normal),
        Font(googleFont = nunitoFont, fontProvider = sparkFontProvider, weight = FontWeight.SemiBold),
        Font(googleFont = nunitoFont, fontProvider = sparkFontProvider, weight = FontWeight.Bold),
    ),
)

internal val defaultFontHandler = CoroutineExceptionHandler { _, throwable ->
    // Log the Throwable
    Log.e("Font Resolver", "" , throwable)
}
