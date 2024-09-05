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
package com.adevinta.spark.catalog.themes.themeprovider.leboncoin

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.adevinta.spark.tokens.SparkTypography
import com.adevinta.spark.tokens.sparkTypography

private val display1Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 40.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 56.sp,
)

private val display2Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 32.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 44.sp,
)

private val display3Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 24.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 32.sp,
)

private val headline1Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 28.sp,
)

private val headline2Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 24.sp,
)

private val subheadType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 24.sp,
)

private val body1Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 24.sp,
)

private val body2Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 20.sp,
)

private val captionType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 12.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 16.sp,
)

private val smallType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 10.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 10.sp,
)

private val calloutType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.Bold,
)

internal val LeboncoinTypo: SparkTypography = sparkTypography(
    display1 = display1Type,
    display2 = display2Type,
    display3 = display3Type,
    headline1 = headline1Type,
    headline2 = headline2Type,
    subhead = subheadType,
    body1 = body1Type,
    body2 = body2Type,
    caption = captionType,
    small = smallType,
    callout = calloutType,
)

public fun brandTypography(
    display1: TextStyle = display1Type,
    display2: TextStyle = display2Type,
    display3: TextStyle = display3Type,
    headline1: TextStyle = headline1Type,
    headline2: TextStyle = headline2Type,
    subhead: TextStyle = subheadType,
    body1: TextStyle = body1Type,
    body2: TextStyle = body2Type,
    caption: TextStyle = captionType,
    small: TextStyle = smallType,
    callout: TextStyle = calloutType,
): SparkTypography = sparkTypography(
    display1 = display1,
    display2 = display2,
    display3 = display3,
    headline1 = headline1,
    headline2 = headline2,
    subhead = subhead,
    body1 = body1,
    body2 = body2,
    caption = caption,
    small = small,
    callout = callout,
)
