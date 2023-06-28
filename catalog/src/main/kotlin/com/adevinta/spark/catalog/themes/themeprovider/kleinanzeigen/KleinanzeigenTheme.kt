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

package com.adevinta.spark.catalog.themes.themeprovider.kleinanzeigen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.adevinta.spark.catalog.themes.themeprovider.ThemeProvider
import com.adevinta.spark.catalog.themes.themeprovider.leboncoin.LeboncoinColorPartDark
import com.adevinta.spark.catalog.themes.themeprovider.leboncoin.LeboncoinColorPartLight
import com.adevinta.spark.catalog.themes.themeprovider.leboncoin.LeboncoinColorPartLightLegacy
import com.adevinta.spark.catalog.themes.themeprovider.leboncoin.LeboncoinColorProDark
import com.adevinta.spark.catalog.themes.themeprovider.leboncoin.LeboncoinColorProLight
import com.adevinta.spark.catalog.themes.themeprovider.leboncoin.LeboncoinColorProLightLegacy
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.SparkShapes
import com.adevinta.spark.tokens.SparkTypography
import com.adevinta.spark.tokens.sparkShapes
import com.adevinta.spark.tokens.sparkTypography

public object KleinanzeigenTheme : ThemeProvider {
    @Composable
    override fun colors(useDarkColors: Boolean, isPro: Boolean, isLegacy: Boolean): SparkColors {
        return when {
            useDarkColors || isSystemInDarkTheme() -> {
                if (isPro) LeboncoinColorProDark else LeboncoinColorPartDark
            }

            isLegacy -> {
                if (isPro) LeboncoinColorProLightLegacy else LeboncoinColorPartLightLegacy
            }

            else -> {
                if (isPro) LeboncoinColorProLight else LeboncoinColorPartLight
            }
        }
    }

    @Composable
    override fun shapes(isLegacy: Boolean): SparkShapes = sparkShapes()

    @Composable
    override fun typography(isLegacy: Boolean): SparkTypography {
        return sparkTypography()
    }
}
