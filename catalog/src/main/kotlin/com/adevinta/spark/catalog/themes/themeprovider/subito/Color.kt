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
package com.adevinta.spark.catalog.themes.themeprovider.subito

import androidx.compose.ui.graphics.Color
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.lightSparkColors

// Brand Palette
private val Neutral50 = Color(0xFFF7F8F9)
private val Neutral100 = Color(0xFFF3F5F6)
private val Neutral200 = Color(0xFFE6E9ED)
private val Neutral300 = Color(0xFFAEB9C6)
private val Neutral400 = Color(0xFF9DA7B2)
private val Neutral500 = Color(0xFF8B949E)
private val Neutral600 = Color(0xFF838B95)
private val Neutral700 = Color(0xFF686F77)
private val Neutral800 = Color(0xFF4E5359)
private val Neutral900 = Color(0xFF3D4145)

private val RedHot50 = Color(0xFFFEECEB)
private val RedHot100 = Color(0xFFFEE3E1)
private val RedHot200 = Color(0xFFFDC4C2)
private val RedHot300 = Color(0xFFF9423A)
private val RedHot400 = Color(0xFFE03B34)
private val RedHot500 = Color(0xFFC7352E)
private val RedHot600 = Color(0xFFBB322C)
private val RedHot700 = Color(0xFF952823)
private val RedHot800 = Color(0xFF701E1A)
private val RedHot900 = Color(0xFF571714)

private val BlueDaBaDee50 = Color(0xFFE9EEFF)
private val BlueDaBaDee100 = Color(0xFFDEE5FF)
private val BlueDaBaDee200 = Color(0xFFBCC9FF)
private val BlueDaBaDee300 = Color(0xFF2650FF)
private val BlueDaBaDee400 = Color(0xFF2248E6)
private val BlueDaBaDee500 = Color(0xFF1E40CC)
private val BlueDaBaDee600 = Color(0xFF1D3CBF)
private val BlueDaBaDee700 = Color(0xFF173099)
private val BlueDaBaDee800 = Color(0xFF112473)
private val BlueDaBaDee900 = Color(0xFF0D1C59)

private val PurpleRain50 = Color(0xFFF5E9FF)
private val PurpleRain100 = Color(0xFFF0DEFF)
private val PurpleRain200 = Color(0xFFDFBBFF)
private val PurpleRain300 = Color(0xFF9924FF)
private val PurpleRain400 = Color(0xFF8A20E6)
private val PurpleRain500 = Color(0xFF7A1DCC)
private val PurpleRain600 = Color(0xFF731BBF)
private val PurpleRain700 = Color(0xFF5C1699)
private val PurpleRain800 = Color(0xFF451073)
private val PurpleRain900 = Color(0xFF360D59)

private val YellowSubmarine50 = Color(0xFFFEF6E6)
private val YellowSubmarine100 = Color(0xFFFDF2D9)
private val YellowSubmarine200 = Color(0xFFFBE4B0)
private val YellowSubmarine300 = Color(0xFFF2A700)
private val YellowSubmarine400 = Color(0xFFDA9600)
private val YellowSubmarine500 = Color(0xFFC28600)
private val YellowSubmarine600 = Color(0xFFB67D00)
private val YellowSubmarine700 = Color(0xFF916400)
private val YellowSubmarine800 = Color(0xFF6D4B00)
private val YellowSubmarine900 = Color(0xFF553A00)

private val GreenDay50 = Color(0xFFE6F8F5)
private val GreenDay100 = Color(0xFFDAF5F0)
private val GreenDay200 = Color(0xFFB2EAE0)
private val GreenDay300 = Color(0xFF07BB9C)
private val GreenDay400 = Color(0xFF06A88C)
private val GreenDay500 = Color(0xFF06967D)
private val GreenDay600 = Color(0xFF058C75)
private val GreenDay700 = Color(0xFF04705E)
private val GreenDay800 = Color(0xFF035446)
private val GreenDay900 = Color(0xFF024137)

private val Black = Color(0xFF000000)
private val White = Color(0xFFFFFFFF)

internal val SubitoLight: SparkColors = lightSparkColors(
    main = RedHot300,
    onMain = White,
    mainContainer = RedHot200,
    onMainContainer = RedHot800,
    mainVariant = RedHot300,
    onMainVariant = White,
    support = Neutral900,
    onSupport = White,
    supportContainer = Neutral200,
    onSupportContainer = Neutral900,
    supportVariant = Neutral700,
    onSupportVariant = White,
    accent = PurpleRain300,
    onAccent = White,
    accentContainer = PurpleRain200,
    onAccentContainer = PurpleRain800,
    accentVariant = PurpleRain700,
    onAccentVariant = White,
    basic = Neutral900,
    onBasic = White,
    basicContainer = Neutral200,
    onBasicContainer = Neutral900,
    success = GreenDay500,
    onSuccess = White,
    successContainer = GreenDay200,
    onSuccessContainer = GreenDay900,
    alert = YellowSubmarine300,
    onAlert = Neutral900,
    alertContainer = YellowSubmarine200,
    onAlertContainer = YellowSubmarine900,
    error = RedHot700,
    onError = White,
    errorContainer = RedHot200,
    onErrorContainer = RedHot900,
    info = BlueDaBaDee500,
    onInfo = White,
    infoContainer = BlueDaBaDee200,
    onInfoContainer = BlueDaBaDee900,
    neutral = Neutral700,
    onNeutral = White,
    neutralContainer = Neutral200,
    onNeutralContainer = Neutral900,
    background = White,
    onBackground = Neutral900,
    backgroundVariant = Neutral100,
    onBackgroundVariant = Neutral700,
    surface = White,
    onSurface = Neutral900,
    surfaceInverse = Neutral900,
    onSurfaceInverse = White,
    outline = Neutral200,
    outlineHigh = Neutral700,
)

internal val SubitoDark: SparkColors = lightSparkColors(
    main = RedHot300,
    onMain = Black,
    mainContainer = RedHot800,
    onMainContainer = RedHot200,
    mainVariant = RedHot200,
    onMainVariant = Black,
    support = Neutral400,
    onSupport = Black,
    supportContainer = Neutral800,
    onSupportContainer = Neutral200,
    supportVariant = Neutral300,
    onSupportVariant = Black,
    accent = PurpleRain300,
    onAccent = Black,
    accentContainer = PurpleRain700,
    onAccentContainer = PurpleRain100,
    accentVariant = PurpleRain200,
    onAccentVariant = PurpleRain900,
    basic = White,
    onBasic = Neutral900,
    basicContainer = Neutral900,
    onBasicContainer = White,
    success = GreenDay400,
    onSuccess = Black,
    successContainer = GreenDay800,
    onSuccessContainer = GreenDay200,
    alert = YellowSubmarine200,
    onAlert = Black,
    alertContainer = YellowSubmarine800,
    onAlertContainer = YellowSubmarine200,
    error = RedHot200,
    onError = Black,
    errorContainer = RedHot800,
    onErrorContainer = RedHot200,
    info = BlueDaBaDee200,
    onInfo = Black,
    infoContainer = BlueDaBaDee800,
    onInfoContainer = BlueDaBaDee200,
    neutral = Neutral400,
    onNeutral = Black,
    neutralContainer = Neutral900,
    onNeutralContainer = Neutral200,
    background = White,
    onBackground = Black,
    backgroundVariant = Neutral200,
    onBackgroundVariant = Neutral900,
    surface = Black,
    onSurface = White,
    surfaceInverse = White,
    onSurfaceInverse = Neutral900,
    outline = Neutral800,
    outlineHigh = White,
)
