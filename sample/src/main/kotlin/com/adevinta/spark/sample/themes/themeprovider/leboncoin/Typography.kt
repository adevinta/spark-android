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

package com.adevinta.spark.sample.themes.themeprovider.leboncoin

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.adevinta.spark.tokens.SparkTypography
import com.adevinta.spark.tokens.sparkTypography

internal val display1Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 40.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 56.sp,
)

internal val display2Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 32.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 44.sp,
)

internal val display3Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 24.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 32.sp,
)

internal val headline1Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 28.sp,
)

internal val headline2Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 24.sp,
)

internal val subheadType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 24.sp,
)

internal val body1Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 24.sp,
)

internal val body2Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 20.sp,
)

internal val captionType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 12.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 16.sp,
)

internal val smallType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 10.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 10.sp,
)

internal val calloutType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.Bold,
)

internal val tile1Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 24.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 28.sp,
    letterSpacing = 0.sp,
)

internal val title2Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 26.sp,
    letterSpacing = 0.15.sp,
)

internal val title3Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 18.sp,
    letterSpacing = 0.15.sp,
)

internal val largeImportantType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 16.sp,
    letterSpacing = 0.15.sp,
)

internal val largeType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp,
)

internal val bodyImportantType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 20.sp,
    letterSpacing = 0.1.sp,
)

internal val bodyType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 20.sp,
    letterSpacing = 0.25.sp,
)

internal val smallImportantType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 12.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 16.sp,
)

internal val smallLegacyType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 12.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 16.sp,
)

internal val extraSmallImportantType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 10.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 10.sp,
)

internal val extraSmallType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 10.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 10.sp,
)

internal val buttonType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    letterSpacing = 1.25.sp,
)

public fun brandTypography(
    isLegacy: Boolean,
    fontFamily: FontFamily = FontFamily.Default,
    display1: TextStyle = display1Type.copy(fontFamily = fontFamily),
    display2: TextStyle = display2Type.copy(fontFamily = fontFamily),
    display3: TextStyle = (if (isLegacy) tile1Type else display3Type).copy(fontFamily = fontFamily),
    headline1: TextStyle = (if (isLegacy) title2Type else headline1Type).copy(fontFamily = fontFamily),
    headline2: TextStyle = (if (isLegacy) title3Type else headline2Type).copy(fontFamily = fontFamily),
    subhead: TextStyle = subheadType.copy(fontFamily = fontFamily),
    body1: TextStyle = (if (isLegacy) largeType else body1Type).copy(fontFamily = fontFamily),
    body2: TextStyle = (if (isLegacy) bodyType else body2Type).copy(fontFamily = fontFamily),
    caption: TextStyle = (if (isLegacy) smallLegacyType else captionType).copy(fontFamily = fontFamily),
    small: TextStyle = (if (isLegacy) extraSmallType else smallType).copy(fontFamily = fontFamily),
    callout: TextStyle = (if (isLegacy) buttonType else calloutType).copy(fontFamily = fontFamily),
): SparkTypography = sparkTypography(
    fontFamily = fontFamily,
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
