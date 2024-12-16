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
package com.adevinta.spark.catalog.themes.themeprovider.leboncoin

import androidx.compose.ui.graphics.Color
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.darkSparkColors
import com.adevinta.spark.tokens.lightSparkColors

// region Blueberry colors
private val Blueberry1000 = Color(0xFF010509)
private val Blueberry900 = Color(0xFF152233)
private val Blueberry800 = Color(0xFF094171)
private val Blueberry700 = Color(0xFF0C5291)
private val Blueberry600 = Color(0xFF0F69B9)
private val Blueberry500 = Color(0xFF1388EC)
private val Blueberry400 = Color(0xFF69B2F3)
private val Blueberry300 = Color(0xFF9FCEF7)
private val Blueberry200 = Color(0xFFC2E0FA)
private val Blueberry100 = Color(0xFFE6F2FD)
private val Blueberry50 = Color(0xFFF4F9FE)
// endregion

internal val LeboncoinColorProLight: SparkColors = lightSparkColors(
    main = Blueberry600,
    onMain = Color.White,
    mainContainer = Blueberry100,
    onMainContainer = Blueberry700,
    mainVariant = Blueberry700,
    onMainVariant = Color.White,
)

internal val LeboncoinColorProDark: SparkColors = darkSparkColors(
    main = Blueberry400,
    onMain = Blueberry900,
    mainContainer = Blueberry800,
    onMainContainer = Blueberry50,
    mainVariant = Blueberry300,
    onMainVariant = Blueberry900,
)
