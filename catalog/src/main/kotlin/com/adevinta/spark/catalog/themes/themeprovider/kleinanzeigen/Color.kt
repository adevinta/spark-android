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
internal val Neutral50 = Color(0xFFF7F7F7)
internal val Neutral100 = Color(0xFFF4F2EF)
internal val Neutral200 = Color(0xFFDDDBD5)
internal val Neutral300 = Color(0xFFBEBCB7)
internal val Neutral400 = Color(0xFF9F9D98)
internal val Neutral500 = Color(0xFF77756F)
internal val Neutral600 = Color(0xFF504E48)
internal val Neutral700 = Color(0xFF33322E)
internal val Neutral800 = Color(0xFF201F1D)
internal val Neutral900 = Color(0xFF0C0C0B)

internal val Green50 = Color(0xFFF7FDEB)
internal val Green100 = Color(0xFFE9F8C6)
internal val Green200 = Color(0xFFD3F28D)
internal val Green300 = Color(0xFFB5E941)
internal val Green400 = Color(0xFF88CC28)
internal val Green500 = Color(0xFF609F28)
internal val Green600 = Color(0xFF326916)
internal val Green700 = Color(0xFF1D4B00)
internal val Green800 = Color(0xFF112D00)
internal val Green900 = Color(0xFF0C1F00)

internal val Yellow50 = Color(0xFFFFEAD1)
internal val Yellow100 = Color(0xFFFFCB8D)
internal val Yellow200 = Color(0xFFFFB763)
internal val Yellow300 = Color(0xFFFFA73F)
internal val Yellow400 = Color(0xFFFB9A27)
internal val Yellow500 = Color(0xFFE98713)
internal val Yellow600 = Color(0xFFCF7204)
internal val Yellow700 = Color(0xFFB76200)
internal val Yellow800 = Color(0xFF844A07)
internal val Yellow900 = Color(0xFF633908)

internal val Purple50 = Color(0xFFF2ECFF)
internal val Purple100 = Color(0xFFE0D1FF)
internal val Purple200 = Color(0xFFCBB4FF)
internal val Purple300 = Color(0xFFB28FFF)
internal val Purple400 = Color(0xFFA278FF)
internal val Purple500 = Color(0xFF8659E4)
internal val Purple600 = Color(0xFF5A33AE)
internal val Purple700 = Color(0xFF432387)
internal val Purple800 = Color(0xFF371975)
internal val Purple900 = Color(0xFF1D064E)

internal val Red50 = Color(0xFFFFD7D7)
internal val Red100 = Color(0xFFFFAAAA)
internal val Red200 = Color(0xFFFF8080)
internal val Red300 = Color(0xFFF24848)
internal val Red400 = Color(0xFFD72222)
internal val Red500 = Color(0xFFB30C0C)
internal val Red600 = Color(0xFF9C1515)
internal val Red700 = Color(0xFF8D1010)
internal val Red800 = Color(0xFF700A0A)
internal val Red900 = Color(0xFF550000)

internal val Black = Color(0xFF000000)
internal val White = Color(0xFFFFFFFF)

internal val Facebook = Color(0xFF4267B2)
internal val Twitter = Color(0xFF1DA1F2)
internal val WhatsApp = Color(0xFF25D366)
internal val YouTube = Color(0xFFFF0000)
internal val Instagram = Color(0xFFE1306C)
internal val TikTok = Color(0xFF000000)
internal val Telegram = Color(0xFF0088CC)

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
