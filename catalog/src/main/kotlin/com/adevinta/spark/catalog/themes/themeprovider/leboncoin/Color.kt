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

import androidx.compose.ui.graphics.Color
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.darkSparkColors
import com.adevinta.spark.tokens.lightSparkColors

// region Misc. colors
private val Red10 = Color(0xFF410001)
private val Red20 = Color(0xFF690002)
private val Red30 = Color(0xFF910909)
private val Red60 = Color(0xFFDB4437)
private val Red80 = Color(0xFFFA5A4B)
private val Red90 = Color(0xFFFFDAD5)

private val Green10 = Color(0xFF002205)
private val Green20 = Color(0xFF00390C)
private val Green30 = Color(0xFF005315)
private val Green60 = Color(0xFF4E9850)
private val Green80 = Color(0xFF8BD989)
private val Green90 = Color(0xFFA6F5A2)
// endregion

// region Brikke Colors
private val BrikkeGreyExtraLight = Color(0xFFF4F6F7) // Information / Disabled Surface
private val BrikkeGreyLight = Color(0xFFE6EBEF) // Highlight Surface
private val BrikkeGreyMedium = Color(0xFFCAD1D9) // Disabled Content
private val BrikkeGrey = Color(0xFFA8B4C0) // Quarternary Content
private val BrikkeGreyDark = Color(0xFF8191A0) // Tertiary Content
private val BrikkeBlack = Color(0xFF1A1A1A) // Action Support / Main Content
private val BrikkeWhite = Color(0xFFFFFFFF) // Support Content / Main Surface
private val BrikkeOpacityBlack = Color(0xFF707070) // Dark Surface Hilight
private val BrikkeRed = Color(0xFFDB4437) // Content Error
private val BrikkeRedLight = Color(0xFFE2695F) // Content Error Light
private val BrikkeRedDark = Color(0xFFAF362C) // Content Error Dark
private val BrikkeRedSurface = Color(0xFFFBECEB) // Surface Error
private val BrikkeGreen = Color(0xFF4E9850) // Content Valid
private val BrikkeGreenLight = Color(0xFF71AC73) // Content Valid Light
private val BrikkeGreenDark = Color(0xFF3E7940) // Content Valid Dark
private val BrikkeGreenSurface = Color(0xFFEEF9EF) // Surface Valid
private val BrikkeBlue = Color(0xFF4183D7) // Main Pro Action / Content / Surface
private val BrikkeBlueDark = Color(0xFF336999) // Main Pro Action Dark
private val BrikkeBlueSurface = Color(0xFFD9E6F7) // Main Action Light
private val BrikkeOrange = Color(0xFFFF6E14) // Main Action / Content / Surface
private val BrikkeOrangeDark = Color(0xFFCB570F) // Main Action Dark
private val BrikkeOrangeSurface = Color(0xFFFEF0E9) // Main Action Light
// endregion

// region Clementin colors
private val Clementin900 = Color(0xFF2F1305)
private val Clementin800 = Color(0xFF5C250A)
private val Clementin700 = Color(0xFF89380F)
private val Clementin600 = Color(0xFFB84A14)
private val Clementin500 = Color(0xFFEC5A13)
private val Clementin400 = Color(0xFFF07B42)
private val Clementin300 = Color(0xFFF49D71)
private val Clementin200 = Color(0xFFF7BEA1)
private val Clementin100 = Color(0xFFFBDFD1)
private val Clementin50 = Color(0xFFFDEFE8)
// endregion

// region Plum colors
private val Plum900 = Color(0xFF1B0033)
private val Plum800 = Color(0xFF370066)
private val Plum700 = Color(0xFF520099)
private val Plum600 = Color(0xFF6D00CC)
private val Plum500 = Color(0xFF8800FF)
private val Plum400 = Color(0xFFA038FA)
private val Plum300 = Color(0xFFB866FF)
private val Plum200 = Color(0xFFD099FF)
private val Plum100 = Color(0xFFE5C7FF)
private val Plum50 = Color(0xFFF3E5FF)
// endregion

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

// region Avocado colors
private val Avocado900 = Color(0xFF101E10)
private val Avocado800 = Color(0xFF1F3D20)
private val Avocado700 = Color(0xFF2F5B30)
private val Avocado600 = Color(0xFF3E7A40)
private val Avocado500 = Color(0xFF4E9850)
private val Avocado400 = Color(0xFF71AD73)
private val Avocado300 = Color(0xFF95C196)
private val Avocado200 = Color(0xFFB8D6B9)
private val Avocado100 = Color(0xFFDCEADC)
private val Avocado50 = Color(0xFFEDF5EE)
// endregion

// region Cherry colors
private val Cherry900 = Color(0xFF2B0B08)
private val Cherry800 = Color(0xFF57150F)
private val Cherry700 = Color(0xFF822017)
private val Cherry600 = Color(0xFFAD291F)
private val Cherry500 = Color(0xFFD93426)
private val Cherry400 = Color(0xFFE05D52)
private val Cherry300 = Color(0xFFE8867D)
private val Cherry200 = Color(0xFFF0AEA8)
private val Cherry100 = Color(0xFFF7D7D4)
private val Cherry50 = Color(0xFFFBECEB)
// endregion

// region Banana colors
private val Banana900 = Color(0xFF332200)
private val Banana800 = Color(0xFF664400)
private val Banana700 = Color(0xFF996600)
private val Banana600 = Color(0xFFCC8800)
private val Banana500 = Color(0xFFFFAA00)
private val Banana400 = Color(0xFFFFBB33)
private val Banana300 = Color(0xFFFFCC66)
private val Banana200 = Color(0xFFFFDD99)
private val Banana100 = Color(0xFFFFEECC)
private val Banana50 = Color(0xFFFFF6E5)
// endregion

// region NightShade colors
private val NightShade900 = Color(0xFF202730)
private val NightShade800 = Color(0xFF2B3441)
private val NightShade700 = Color(0xFF3A4757)
private val NightShade600 = Color(0xFF4F6076)
private val NightShade500 = Color(0xFF627C93)
private val NightShade400 = Color(0xFFACB8C7)
private val NightShade300 = Color(0xFFD0D7DF)
private val NightShade200 = Color(0xFFE4E8ED)
private val NightShade100 = Color(0xFFF0F2F5)
private val NightShade50 = Color(0xFFF6F8F9)
private val NightShade25 = Color(0xFFF7FAFD)
// endregion

// region Black & White colors
private val AlmostWhite = Color(0xFFFAFAFA)
private val AlmostBlack = Color(0xC7000000)
private val Black = Color(0xFF121212)
private val BlackLight = Color(0xFF474747)

private val Grey0 = Color(0xFF000000)
private val Grey10 = Color(0xFF1A1C1E)
private val Grey20 = Color(0xFF2F3033)
private val Grey30 = Color(0xFF46474A)
private val Grey40 = Color(0xFF5E5E62)
private val Grey50 = Color(0xFF76777A)
private val Grey60 = Color(0xFF909094)
private val Grey70 = Color(0xFFABABAE)
private val Grey80 = Color(0xFFC7C6CA)
private val Grey90 = Color(0xFFE3E2E6)
private val Grey95 = Color(0xFFF1F0F4)
private val Grey99 = Color(0xFFFDFBFF)
private val Grey100 = Color(0xFFFFFFFF)

private val GreyBlue10 = Color(0xFF0d1d29)
private val GreyBlue20 = Color(0xFF23323f)
private val GreyBlue30 = Color(0xFF394856)
private val GreyBlue40 = Color(0xFF51606e)
private val GreyBlue50 = Color(0xFF697987)
private val GreyBlue60 = Color(0xFF8393a2)
private val GreyBlue70 = Color(0xFF9dadbd)
private val GreyBlue80 = Color(0xFFb8c8d8)
private val GreyBlue90 = Color(0xFFd4e4f5)
private val GreyBlue95 = Color(0xFFe6f2ff)
private val GreyBlue99 = Color(0xFFfcfcff)

internal val LeboncoinColorPartLightLegacy: SparkColors = lightSparkColors(
    accent = BrikkeOrange,
    onAccent = Color.White,
    accentContainer = BrikkeOrangeSurface,
    onAccentContainer = Clementin900,
    accentVariant = BrikkeOrangeDark,
    onAccentVariant = Color.White,
    basic = BrikkeBlack,
    onBasic = Color.White,
    basicContainer = BrikkeGreyLight, // Highlight Surface => backgroundVariant
    onBasicContainer = Blueberry900,
    main = BrikkeOrange,
    onMain = Color.White,
    mainContainer = BrikkeOrangeSurface,
    onMainContainer = Clementin900,
    mainVariant = BrikkeOrangeDark,
    onMainVariant = Color.White,
    support = BrikkeBlack,
    onSupport = Color.White,
    supportContainer = BrikkeGreyLight, // Highlight Surface => backgroundVariant
    onSupportContainer = Blueberry900,
    supportVariant = BrikkeGreyDark, // tertiary => neutral / Dim 1
    onSupportVariant = Grey10,
    tertiary = BrikkeGrey,
    onTertiary = GreyBlue99,
    tertiaryContainer = BrikkeGreyExtraLight,
    onTertiaryContainer = GreyBlue10,
    success = BrikkeGreen,
    onSuccess = Grey100,
    successContainer = BrikkeGreenSurface,
    onSuccessContainer = Green10,
    alert = Banana500,
    onAlert = NightShade900,
    alertContainer = Banana100,
    onAlertContainer = Banana700,
    error = BrikkeRed,
    onError = Grey100,
    errorContainer = BrikkeRedSurface,
    onErrorContainer = Red10,
    info = Blueberry500,
    onInfo = Color.White,
    infoContainer = Blueberry100,
    onInfoContainer = Blueberry700,
    neutral = NightShade50,
    onNeutral = Color.White,
    neutralContainer = NightShade50, // == surface Highlight
    onNeutralContainer = NightShade700,
    background = Color.White,
    onBackground = Blueberry900,
    backgroundVariant = GreyBlue90, // == surface disabled
    onBackgroundVariant = GreyBlue30,
    surface = Color.White,
    onSurface = Grey10,
    surfaceInverse = Grey20,
    onSurfaceInverse = Grey95,
    surfaceTint = BrikkeOrange,
    outline = GreyBlue50,
    outlineHigh = GreyBlue80,
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)

internal val LeboncoinColorProLightLegacy: SparkColors = lightSparkColors(
    accent = BrikkeBlue,
    onAccent = Color.White,
    accentContainer = BrikkeBlueSurface,
    onAccentContainer = Blueberry900,
    accentVariant = BrikkeBlueDark,
    onAccentVariant = Color.White,
    basic = BrikkeBlack,
    onBasic = Color.White,
    basicContainer = BrikkeGreyLight, // Highlight Surface => backgroundVariant
    onBasicContainer = Blueberry900,
    main = BrikkeBlue,
    onMain = Color.White,
    mainContainer = BrikkeBlueSurface,
    onMainContainer = Blueberry900,
    mainVariant = BrikkeBlueDark,
    onMainVariant = Color.White,
    support = BrikkeBlack,
    onSupport = Color.White,
    supportContainer = BrikkeGreyLight, // Highlight Surface => backgroundVariant
    onSupportContainer = Blueberry900,
    supportVariant = BrikkeGreyDark, // tertiary => neutral / Dim 1
    onSupportVariant = Grey10,
    tertiary = BrikkeGrey,
    onTertiary = GreyBlue99,
    tertiaryContainer = BrikkeGreyExtraLight,
    onTertiaryContainer = GreyBlue10,
    success = BrikkeGreen,
    onSuccess = Grey100,
    successContainer = BrikkeGreenSurface,
    onSuccessContainer = Green10,
    alert = Banana500,
    onAlert = NightShade900,
    alertContainer = Banana100,
    onAlertContainer = Banana700,
    error = BrikkeRed,
    onError = Grey100,
    errorContainer = BrikkeRedSurface,
    onErrorContainer = Red10,
    info = Blueberry500,
    onInfo = Color.White,
    infoContainer = Blueberry100,
    onInfoContainer = Blueberry700,
    neutral = NightShade50,
    onNeutral = Color.White,
    neutralContainer = NightShade50, // == surface Highlight
    onNeutralContainer = NightShade700,
    background = Color.White,
    onBackground = Blueberry900,
    backgroundVariant = GreyBlue90, // == surface disabled
    onBackgroundVariant = GreyBlue30,
    surface = Color.White,
    onSurface = Grey10,
    surfaceInverse = Grey20,
    onSurfaceInverse = Grey95,
    surfaceTint = BrikkeOrange,
    outline = GreyBlue50,
    outlineHigh = GreyBlue80,
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)

internal val LeboncoinColorPartLight: SparkColors = lightSparkColors(
    accent = Plum500,
    onAccent = Color.White,
    accentContainer = Plum100,
    onAccentContainer = Plum800,
    accentVariant = Plum700,
    onAccentVariant = Color.White,
    basic = Blueberry800,
    onBasic = Color.White,
    basicContainer = Blueberry100,
    onBasicContainer = Blueberry900,
    main = Clementin500,
    onMain = Color.White,
    mainContainer = Clementin100,
    onMainContainer = Clementin700,
    mainVariant = Clementin600,
    onMainVariant = Color.White,
    support = Blueberry800,
    onSupport = Color.White,
    supportContainer = Blueberry100,
    onSupportContainer = Blueberry900,
    supportVariant = Blueberry700, // tertiary => neutral / Dim 1
    onSupportVariant = Color.White,
    tertiary = Color.Magenta,
    onTertiary = Color.Blue,
    tertiaryContainer = Color.Magenta,
    onTertiaryContainer = Color.Blue,
    success = Avocado500,
    onSuccess = Color.White,
    successContainer = Avocado100, // == surface disabled
    onSuccessContainer = Avocado700,
    alert = Banana500,
    onAlert = NightShade900,
    alertContainer = Banana100,
    onAlertContainer = Banana700,
    error = Cherry500,
    onError = Color.White,
    errorContainer = Cherry100,
    onErrorContainer = Cherry700,
    info = Blueberry500,
    onInfo = Color.White,
    infoContainer = Blueberry200,
    onInfoContainer = Blueberry700,
    neutral = NightShade500,
    onNeutral = Color.White,
    neutralContainer = NightShade100,
    onNeutralContainer = NightShade700,
    background = Color.White,
    onBackground = Blueberry900,
    backgroundVariant = Blueberry50,
    onBackgroundVariant = Blueberry900,
    surface = Color.White,
    onSurface = Blueberry900,
    surfaceInverse = NightShade800,
    onSurfaceInverse = Color.White,
    surfaceTint = Clementin500,
    outline = NightShade400,
    outlineHigh = NightShade900,
)

internal val LeboncoinColorProLight: SparkColors = lightSparkColors(
    accent = Plum500,
    onAccent = Color.White,
    accentContainer = Plum100,
    onAccentContainer = Plum800,
    accentVariant = Plum700,
    onAccentVariant = Color.White,
    basic = Blueberry800,
    onBasic = Color.White,
    basicContainer = Blueberry100,
    onBasicContainer = Blueberry900,
    main = Blueberry600,
    onMain = Color.White,
    mainContainer = Blueberry100,
    onMainContainer = Blueberry700,
    mainVariant = Blueberry700,
    onMainVariant = Color.White,
    support = Blueberry800,
    onSupport = Color.White,
    supportContainer = Blueberry100,
    onSupportContainer = Blueberry900,
    supportVariant = Blueberry700, // tertiary => neutral / Dim 1
    onSupportVariant = Color.White,
    tertiary = Color.Magenta,
    onTertiary = Color.Blue,
    tertiaryContainer = Color.Magenta,
    onTertiaryContainer = Color.Blue,
    success = Avocado500,
    onSuccess = Color.White,
    successContainer = Avocado100, // == surface disabled
    onSuccessContainer = Avocado700,
    alert = Banana500,
    onAlert = NightShade900,
    alertContainer = Banana100,
    onAlertContainer = Banana700,
    error = Cherry500,
    onError = Color.White,
    errorContainer = Cherry100,
    onErrorContainer = Cherry700,
    info = Blueberry500,
    onInfo = Color.White,
    infoContainer = Blueberry200,
    onInfoContainer = Blueberry700,
    neutral = NightShade500,
    onNeutral = Color.White,
    neutralContainer = NightShade100,
    onNeutralContainer = NightShade700,
    background = Color.White,
    onBackground = Blueberry900,
    backgroundVariant = Blueberry50,
    onBackgroundVariant = Blueberry900,
    surface = Color.White,
    onSurface = Blueberry900,
    surfaceInverse = NightShade800,
    onSurfaceInverse = Color.White,
    surfaceTint = Clementin500,
    outline = NightShade400,
    outlineHigh = NightShade900,
)

internal val LeboncoinColorPartDark: SparkColors = darkSparkColors(
    accent = Plum200,
    onAccent = NightShade900,
    accentContainer = Plum700,
    onAccentContainer = Color.White,
    accentVariant = Plum300,
    onAccentVariant = NightShade900,
    basic = Blueberry100,
    onBasic = NightShade900,
    basicContainer = Blueberry800,
    onBasicContainer = Blueberry50,
    main = Clementin400,
    onMain = NightShade900,
    mainContainer = Clementin700,
    onMainContainer = Clementin50,
    mainVariant = Clementin300,
    onMainVariant = NightShade900,
    support = Blueberry100,
    onSupport = Blueberry900,
    supportContainer = Blueberry800,
    onSupportContainer = Blueberry50,
    supportVariant = Blueberry50,
    onSupportVariant = Blueberry900,
    success = Avocado400,
    onSuccess = NightShade900,
    successContainer = Avocado800,
    onSuccessContainer = Avocado50,
    alert = Banana300,
    onAlert = NightShade900,
    alertContainer = Banana800,
    onAlertContainer = Banana50,
    error = Cherry400,
    onError = NightShade900,
    errorContainer = Cherry800,
    onErrorContainer = Cherry50,
    info = Blueberry200,
    onInfo = NightShade900,
    infoContainer = Blueberry800,
    onInfoContainer = Blueberry50,
    neutral = NightShade300,
    onNeutral = NightShade900,
    neutralContainer = NightShade800,
    onNeutralContainer = NightShade50,
    background = NightShade900,
    onBackground = Color.White,
    backgroundVariant = Blueberry1000,
    onBackgroundVariant = Color.White,
    surface = NightShade900,
    onSurface = Color.White,
    surfaceInverse = NightShade50,
    onSurfaceInverse = NightShade700,
    surfaceTint = Clementin400,
    outline = NightShade600,
    outlineHigh = NightShade50,
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)

internal val LeboncoinColorProDark: SparkColors = darkSparkColors(
    accent = Plum200,
    onAccent = NightShade900,
    accentContainer = Plum700,
    onAccentContainer = Color.White,
    accentVariant = Plum300,
    onAccentVariant = NightShade900,
    basic = Blueberry100,
    onBasic = NightShade900,
    basicContainer = Blueberry800,
    onBasicContainer = Blueberry50,
    main = Blueberry400,
    onMain = NightShade900,
    mainContainer = Blueberry800,
    onMainContainer = Blueberry100,
    mainVariant = Blueberry200,
    onMainVariant = NightShade900,
    support = Blueberry100,
    onSupport = Blueberry900,
    supportContainer = Blueberry800,
    onSupportContainer = Blueberry50,
    supportVariant = Blueberry50,
    onSupportVariant = Blueberry900,
    success = Avocado400,
    onSuccess = NightShade900,
    successContainer = Avocado800,
    onSuccessContainer = Avocado50,
    alert = Banana300,
    onAlert = NightShade900,
    alertContainer = Banana800,
    onAlertContainer = Banana50,
    error = Cherry400,
    onError = NightShade900,
    errorContainer = Cherry800,
    onErrorContainer = Cherry50,
    info = Blueberry200,
    onInfo = NightShade900,
    infoContainer = Blueberry800,
    onInfoContainer = Blueberry50,
    neutral = NightShade300,
    onNeutral = NightShade900,
    neutralContainer = NightShade800,
    onNeutralContainer = NightShade50,
    background = NightShade900,
    onBackground = Color.White,
    backgroundVariant = Blueberry1000,
    onBackgroundVariant = Color.White,
    surface = NightShade900,
    onSurface = Color.White,
    surfaceInverse = NightShade50,
    onSurfaceInverse = NightShade700,
    surfaceTint = Clementin400,
    outline = NightShade600,
    outlineHigh = NightShade50,
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)
