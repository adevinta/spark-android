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

import androidx.compose.ui.graphics.Color
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.lightSparkColors

// Brand Palette
private val Neutral50 = Color(0xFFF7F7F7)
private val Neutral100 = Color(0xFFF4F2EF)
private val Neutral200 = Color(0xFFDDDBD5)
private val Neutral300 = Color(0xFFBEBCB7)
private val Neutral400 = Color(0xFF9F9D98)
private val Neutral500 = Color(0xFF77756F)
private val Neutral600 = Color(0xFF504E48)
private val Neutral700 = Color(0xFF33322E)
private val Neutral800 = Color(0xFF201F1D)
private val Neutral900 = Color(0xFF0C0C0B)

private val Green50 = Color(0xFFF7FDEB)
private val Green100 = Color(0xFFE9F8C6)
private val Green200 = Color(0xFFD3F28D)
private val Green300 = Color(0xFFB5E941)
private val Green400 = Color(0xFF88CC28)
private val Green500 = Color(0xFF609F28)
private val Green600 = Color(0xFF326916)
private val Green700 = Color(0xFF1D4B00)
private val Green800 = Color(0xFF112D00)
private val Green900 = Color(0xFF0C1F00)

private val Yellow50 = Color(0xFFFFEAD1)
private val Yellow100 = Color(0xFFFFCB8D)
private val Yellow200 = Color(0xFFFFB763)
private val Yellow300 = Color(0xFFFFA73F)
private val Yellow400 = Color(0xFFFB9A27)
private val Yellow500 = Color(0xFFE98713)
private val Yellow600 = Color(0xFFCF7204)
private val Yellow700 = Color(0xFFB76200)
private val Yellow800 = Color(0xFF844A07)
private val Yellow900 = Color(0xFF633908)

private val Purple50 = Color(0xFFF2ECFF)
private val Purple100 = Color(0xFFE0D1FF)
private val Purple200 = Color(0xFFCBB4FF)
private val Purple300 = Color(0xFFB28FFF)
private val Purple400 = Color(0xFFA278FF)
private val Purple500 = Color(0xFF8659E4)
private val Purple600 = Color(0xFF5A33AE)
private val Purple700 = Color(0xFF432387)
private val Purple800 = Color(0xFF371975)
private val Purple900 = Color(0xFF1D064E)

private val Red50 = Color(0xFFFFD7D7)
private val Red100 = Color(0xFFFFAAAA)
private val Red200 = Color(0xFFFF8080)
private val Red300 = Color(0xFFF24848)
private val Red400 = Color(0xFFD72222)
private val Red500 = Color(0xFFB30C0C)
private val Red600 = Color(0xFF9C1515)
private val Red700 = Color(0xFF8D1010)
private val Red800 = Color(0xFF700A0A)
private val Red900 = Color(0xFF550000)

private val Black = Color(0xFF000000)
private val White = Color(0xFFFFFFFF)

private val Facebook = Color(0xFF4267B2)
private val Twitter = Color(0xFF1DA1F2)
private val WhatsApp = Color(0xFF25D366)
private val YouTube = Color(0xFFFF0000)
private val Instagram = Color(0xFFE1306C)
private val TikTok = Color(0xFF000000)
private val Telegram = Color(0xFF0088CC)

internal val KleinanzeigenLight: SparkColors = lightSparkColors(
    accent = Purple600,
    onAccent = White,
    accentContainer = Purple100,
    onAccentContainer = Purple800,
    accentVariant = Purple700,
    onAccentVariant = White,
    basic = Green700,
    onBasic = White,
    basicContainer = Green200,
    onBasicContainer = Green700,
    main = Green300,
    onMain = Green700,
    mainContainer = Green100,
    onMainContainer = Green700,
    mainVariant = Green500,
    onMainVariant = White,
    support = Green700,
    onSupport = White,
    supportContainer = Green200,
    onSupportContainer = Green700,
    supportVariant = Green800,
    onSupportVariant = White,
    success = Green600,
    onSuccess = White,
    successContainer = Green100, // == surface disabled
    onSuccessContainer = Green600,
    alert = Yellow300,
    onAlert = Neutral900,
    alertContainer = Yellow100,
    onAlertContainer = Yellow900,
    error = Red500,
    onError = White,
    errorContainer = Red100,
    onErrorContainer = Red900,
    info = Purple500,
    onInfo = White,
    infoContainer = Purple100,
    onInfoContainer = Purple700,
    neutral = Neutral600,
    onNeutral = White,
    neutralContainer = Neutral100,
    onNeutralContainer = Neutral600,
    background = White,
    onBackground = Neutral900,
    backgroundVariant = Neutral100,
    onBackgroundVariant = Neutral700,
    surface = White,
    onSurface = Neutral900,
    surfaceInverse = Neutral900,
    onSurfaceInverse = White,
    outline = Neutral300,
    outlineHigh = Neutral400,
)

internal val KleinanzeigenDark: SparkColors = lightSparkColors(
    accent = Purple100,
    onAccent = Neutral900,
    accentContainer = Purple800,
    onAccentContainer = White,
    accentVariant = Purple700,
    onAccentVariant = White,
    basic = Green200,
    onBasic = Neutral900,
    basicContainer = Green700,
    onBasicContainer = White,
    main = Green300,
    onMain = Green700,
    mainContainer = Green800,
    onMainContainer = Green100,
    mainVariant = Green500,
    onMainVariant = White,
    support = Green200,
    onSupport = Neutral900,
    supportContainer = Green700,
    onSupportContainer = Green100,
    supportVariant = Green800, // tertiary => neutral / Dim 1
    onSupportVariant = White,
    success = Green100,
    onSuccess = Neutral900,
    successContainer = Green600,
    onSuccessContainer = Green50,
    alert = Yellow200,
    onAlert = Neutral900,
    alertContainer = Yellow800,
    onAlertContainer = Yellow50,
    error = Red200,
    onError = Neutral900,
    errorContainer = Red700,
    onErrorContainer = Red50,
    info = Purple200,
    onInfo = Neutral900,
    infoContainer = Purple700,
    onInfoContainer = Purple100,
    neutral = Neutral200,
    onNeutral = Neutral900,
    neutralContainer = Neutral600,
    onNeutralContainer = Neutral100,
    background = Neutral900,
    onBackground = White,
    backgroundVariant = Neutral700,
    onBackgroundVariant = White,
    surface = Neutral900,
    onSurface = White,
    surfaceInverse = White,
    onSurfaceInverse = Neutral900,
    outline = Neutral700,
    outlineHigh = Neutral500,
)
