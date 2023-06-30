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

// region Misc. colors
internal val Red10 = Color(0xFF410001)
internal val Red20 = Color(0xFF690002)
internal val Red30 = Color(0xFF910909)
internal val Red60 = Color(0xFFDB4437)
internal val Red80 = Color(0xFFFA5A4B)
internal val Red90 = Color(0xFFFFDAD5)

internal val Green10 = Color(0xFF002205)
internal val Green20 = Color(0xFF00390C)
internal val Green30 = Color(0xFF005315)
internal val Green60 = Color(0xFF4E9850)
internal val Green80 = Color(0xFF8BD989)
internal val Green90 = Color(0xFFA6F5A2)
// endregion

// region Brikke Colors
internal val BrikkeGreyExtraLight = Color(0xFFF4F6F7) // Information / Disabled Surface
internal val BrikkeGreyLight = Color(0xFFE6EBEF) // Highlight Surface
internal val BrikkeGreyMedium = Color(0xFFCAD1D9) // Disabled Content
internal val BrikkeGrey = Color(0xFFA8B4C0) // Quarternary Content
internal val BrikkeGreyDark = Color(0xFF8191A0) // Tertiary Content
internal val BrikkeBlack = Color(0xFF1A1A1A) // Action Secondary / Primary Content
internal val BrikkeWhite = Color(0xFFFFFFFF) // Secondary Content / Primary Surface
internal val BrikkeOpacityBlack = Color(0xFF707070) // Dark Surface Hilight
internal val BrikkeRed = Color(0xFFDB4437) // Content Error
internal val BrikkeRedLight = Color(0xFFE2695F) // Content Error Light
internal val BrikkeRedDark = Color(0xFFAF362C) // Content Error Dark
internal val BrikkeRedSurface = Color(0xFFFBECEB) // Surface Error
internal val BrikkeGreen = Color(0xFF4E9850) // Content Valid
internal val BrikkeGreenLight = Color(0xFF71AC73) // Content Valid Light
internal val BrikkeGreenDark = Color(0xFF3E7940) // Content Valid Dark
internal val BrikkeGreenSurface = Color(0xFFEEF9EF) // Surface Valid
internal val BrikkeBlue = Color(0xFF4183D7) // Primary Pro Action / Content / Surface
internal val BrikkeBlueDark = Color(0xFF336999) // Primary Pro Action Dark
internal val BrikkeBlueSurface = Color(0xFFD9E6F7) // Primary Action Light
internal val BrikkeOrange = Color(0xFFFF6E14) // Primary Action / Content / Surface
internal val BrikkeOrangeDark = Color(0xFFCB570F) // Primary Action Dark
internal val BrikkeOrangeSurface = Color(0xFFFEF0E9) // Primary Action Light
// endregion

// region Clementin colors
internal val Clementin900 = Color(0xFF2F1305)
internal val Clementin800 = Color(0xFF5C250A)
internal val Clementin700 = Color(0xFF89380F)
internal val Clementin600 = Color(0xFFB84A14)
internal val Clementin500 = Color(0xFFEC5A13)
internal val Clementin400 = Color(0xFFF07B42)
internal val Clementin300 = Color(0xFFF49D71)
internal val Clementin200 = Color(0xFFF7BEA1)
internal val Clementin100 = Color(0xFFFBDFD1)
internal val Clementin50 = Color(0xFFFDEFE8)
// endregion

// region Plum colors
internal val Plum900 = Color(0xFF14050D)
internal val Plum800 = Color(0xFF3D0F26)
internal val Plum700 = Color(0xFF531534)
internal val Plum600 = Color(0xFF7A1F4D)
internal val Plum500 = Color(0xFF8E2459)
internal val Plum400 = Color(0xFFA65980)
internal val Plum300 = Color(0xFFB87C9A)
internal val Plum200 = Color(0xFFDCBDCC)
internal val Plum100 = Color(0xFFEDDEE5)
internal val Plum50 = Color(0xFFF6EEF2)
// endregion

// region Blueberry colors
internal val Blueberry1000 = Color(0xFF010509)
internal val Blueberry900 = Color(0xFF06233D)
internal val Blueberry800 = Color(0xFF08365D)
internal val Blueberry700 = Color(0xFF0B518E)
internal val Blueberry600 = Color(0xFF0F6CBD)
internal val Blueberry500 = Color(0xFF1388EC)
internal val Blueberry400 = Color(0xFF429FF0)
internal val Blueberry300 = Color(0xFF71B7F4)
internal val Blueberry200 = Color(0xFFA0CFF7)
internal val Blueberry100 = Color(0xFFCFE6FB)
internal val Blueberry50 = Color(0xFFE7F3FD)
// endregion

// region Avocado colors
internal val Avocado900 = Color(0xFF101E10)
internal val Avocado800 = Color(0xFF1F3D20)
internal val Avocado700 = Color(0xFF2F5B30)
internal val Avocado600 = Color(0xFF3E7A40)
internal val Avocado500 = Color(0xFF4E9850)
internal val Avocado400 = Color(0xFF71AD73)
internal val Avocado300 = Color(0xFF95C196)
internal val Avocado200 = Color(0xFFB8D6B9)
internal val Avocado100 = Color(0xFFDCEADC)
internal val Avocado50 = Color(0xFFEDF5EE)
// endregion

// region Cherry colors
internal val Cherry900 = Color(0xFF2B0B08)
internal val Cherry800 = Color(0xFF57150F)
internal val Cherry700 = Color(0xFF822017)
internal val Cherry600 = Color(0xFFAD291F)
internal val Cherry500 = Color(0xFFD93426)
internal val Cherry400 = Color(0xFFE05D52)
internal val Cherry300 = Color(0xFFE8867D)
internal val Cherry200 = Color(0xFFF0AEA8)
internal val Cherry100 = Color(0xFFF7D7D4)
internal val Cherry50 = Color(0xFFFBECEB)
// endregion

// region Banana colors
internal val Banana900 = Color(0xFF332200)
internal val Banana800 = Color(0xFF664400)
internal val Banana700 = Color(0xFF996600)
internal val Banana600 = Color(0xFFCC8800)
internal val Banana500 = Color(0xFFFFAA00)
internal val Banana400 = Color(0xFFFFBB33)
internal val Banana300 = Color(0xFFFFCC66)
internal val Banana200 = Color(0xFFFFDD99)
internal val Banana100 = Color(0xFFFFEECC)
internal val Banana50 = Color(0xFFFFF6E5)
// endregion

// region NightShade colors
internal val NightShade900 = Color(0xFF14191F)
internal val NightShade800 = Color(0xFF2B3640)
internal val NightShade700 = Color(0xFF3D4D5C)
internal val NightShade600 = Color(0xFF4E6579)
internal val NightShade500 = Color(0xFF627C93)
internal val NightShade400 = Color(0xFF7F95A9)
internal val NightShade300 = Color(0xFFA3B4C2)
internal val NightShade200 = Color(0xFFBBCDDD)
internal val NightShade100 = Color(0xFFDAE6F1)
internal val NightShade50 = Color(0xFFF0F5FA)
internal val NightShade25 = Color(0xFFF7FAFD)
// endregion

// region Black & White colors
internal val AlmostWhite = Color(0xFFFAFAFA)
internal val AlmostBlack = Color(0xC7000000)
internal val Black = Color(0xFF121212)
internal val BlackLight = Color(0xFF474747)

internal val Grey0 = Color(0xFF000000)
internal val Grey10 = Color(0xFF1A1C1E)
internal val Grey20 = Color(0xFF2F3033)
internal val Grey30 = Color(0xFF46474A)
internal val Grey40 = Color(0xFF5E5E62)
internal val Grey50 = Color(0xFF76777A)
internal val Grey60 = Color(0xFF909094)
internal val Grey70 = Color(0xFFABABAE)
internal val Grey80 = Color(0xFFC7C6CA)
internal val Grey90 = Color(0xFFE3E2E6)
internal val Grey95 = Color(0xFFF1F0F4)
internal val Grey99 = Color(0xFFFDFBFF)
internal val Grey100 = Color(0xFFFFFFFF)

internal val GreyBlue10 = Color(0xFF0d1d29)
internal val GreyBlue20 = Color(0xFF23323f)
internal val GreyBlue30 = Color(0xFF394856)
internal val GreyBlue40 = Color(0xFF51606e)
internal val GreyBlue50 = Color(0xFF697987)
internal val GreyBlue60 = Color(0xFF8393a2)
internal val GreyBlue70 = Color(0xFF9dadbd)
internal val GreyBlue80 = Color(0xFFb8c8d8)
internal val GreyBlue90 = Color(0xFFd4e4f5)
internal val GreyBlue95 = Color(0xFFe6f2ff)
internal val GreyBlue99 = Color(0xFFfcfcff)

internal val LeboncoinColorPartLightLegacy: SparkColors = lightSparkColors(
    primary = BrikkeOrange,
    onPrimary = Color.White,
    primaryContainer = BrikkeOrangeSurface,
    onPrimaryContainer = Clementin900,
    primaryVariant = BrikkeOrangeDark,
    onPrimaryVariant = Color.White,
    secondary = BrikkeBlack,
    onSecondary = Color.White,
    secondaryContainer = BrikkeGreyLight, // Highlight Surface => backgroundVariant
    onSecondaryContainer = Blueberry900,
    secondaryVariant = BrikkeGreyDark, // tertiary => neutral / Dim 1
    onSecondaryVariant = Grey10,
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
    primary = BrikkeBlue,
    onPrimary = Color.White,
    primaryContainer = BrikkeBlueSurface,
    onPrimaryContainer = Blueberry900,
    primaryVariant = BrikkeBlueDark,
    onPrimaryVariant = Color.White,
    secondary = BrikkeBlack,
    onSecondary = Color.White,
    secondaryContainer = BrikkeGreyLight, // Highlight Surface => backgroundVariant
    onSecondaryContainer = Blueberry900,
    secondaryVariant = BrikkeGreyDark, // tertiary => neutral / Dim 1
    onSecondaryVariant = Grey10,
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
    primary = Clementin500,
    onPrimary = Color.White,
    primaryContainer = Clementin50,
    onPrimaryContainer = Clementin700,
    primaryVariant = Clementin600,
    onPrimaryVariant = Color.White,
    secondary = Blueberry900,
    onSecondary = Color.White,
    secondaryContainer = Blueberry50,
    onSecondaryContainer = Blueberry900,
    secondaryVariant = NightShade600, // tertiary => neutral / Dim 1
    onSecondaryVariant = Color.White,
    tertiary = Color.Magenta,
    onTertiary = Color.Blue,
    tertiaryContainer = Color.Magenta,
    onTertiaryContainer = Color.Blue,
    background = Color.White,
    onBackground = Blueberry900,
    backgroundVariant = NightShade25, // == surface disabled
    onBackgroundVariant = Blueberry900,
    surface = Color.White,
    onSurface = Blueberry900,
    surfaceInverse = Blueberry900,
    onSurfaceInverse = Color.White,
    surfaceTint = Clementin500,
    outline = NightShade300,
    outlineHigh = Blueberry900,
    success = Avocado500,
    onSuccess = Color.White,
    successContainer = Avocado100,
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
    infoContainer = Blueberry100,
    onInfoContainer = Blueberry700,
    neutral = NightShade500,
    onNeutral = Color.White,
    neutralContainer = NightShade50,
    onNeutralContainer = NightShade700,
)

internal val LeboncoinColorProLight: SparkColors = lightSparkColors(
    primary = Blueberry600,
    onPrimary = Color.White,
    primaryContainer = Blueberry50,
    onPrimaryContainer = Blueberry700,
    primaryVariant = Blueberry700,
    onPrimaryVariant = Color.White,
    secondary = Blueberry900,
    onSecondary = Color.White,
    secondaryContainer = Blueberry50,
    onSecondaryContainer = Blueberry900,
    secondaryVariant = NightShade600, // tertiary => neutral / Dim 1
    onSecondaryVariant = Color.White,
    tertiary = Color.Magenta,
    onTertiary = Color.Blue,
    tertiaryContainer = Color.Magenta,
    onTertiaryContainer = Color.Blue,
    background = Color.White,
    onBackground = Blueberry900,
    backgroundVariant = NightShade25, // == surface disabled
    onBackgroundVariant = Blueberry900,
    surface = Color.White,
    onSurface = Blueberry900,
    surfaceInverse = Blueberry900,
    onSurfaceInverse = Color.White,
    surfaceTint = Clementin500,
    outline = NightShade300,
    outlineHigh = Blueberry900,
    success = Avocado500,
    onSuccess = Color.White,
    successContainer = Avocado100,
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
    infoContainer = Blueberry100,
    onInfoContainer = Blueberry700,
    neutral = NightShade500,
    onNeutral = Color.White,
    neutralContainer = NightShade50,
    onNeutralContainer = NightShade700,
)

internal val LeboncoinColorPartDark: SparkColors = darkSparkColors(
    primary = Clementin400,
    onPrimary = NightShade900,
    primaryContainer = Clementin800,
    onPrimaryContainer = Clementin100,
    primaryVariant = Clementin200,
    onPrimaryVariant = NightShade900,
    secondary = NightShade50,
    onSecondary = NightShade900,
    secondaryContainer = NightShade800,
    onSecondaryContainer = NightShade100,
    secondaryVariant = NightShade200,
    onSecondaryVariant = NightShade900,
    success = Avocado400,
    onSuccess = NightShade900,
    successContainer = Avocado800,
    onSuccessContainer = Avocado100,
    alert = Banana300,
    onAlert = NightShade50,
    alertContainer = Banana800,
    onAlertContainer = Banana100,
    error = Cherry400,
    onError = NightShade900,
    errorContainer = Cherry800,
    onErrorContainer = Cherry100,
    info = Blueberry400,
    onInfo = NightShade100,
    infoContainer = Blueberry800,
    onInfoContainer = Blueberry100,
    neutral = NightShade400,
    onNeutral = NightShade900,
    neutralContainer = NightShade800,
    onNeutralContainer = NightShade100,
    background = NightShade900,
    onBackground = NightShade25,
    backgroundVariant = Blueberry900,
    onBackgroundVariant = NightShade25,
    surface = NightShade900,
    onSurface = NightShade25,
    surfaceInverse = NightShade50,
    onSurfaceInverse = NightShade900,
    surfaceTint = Clementin400,
    outline = NightShade700,
    outlineHigh = Color.White,
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)

internal val LeboncoinColorProDark: SparkColors = darkSparkColors(
    primary = Blueberry400,
    onPrimary = NightShade900,
    primaryContainer = Blueberry800,
    onPrimaryContainer = Blueberry100,
    primaryVariant = Blueberry200,
    onPrimaryVariant = NightShade900,
    secondary = NightShade50,
    onSecondary = NightShade900,
    secondaryContainer = NightShade800,
    onSecondaryContainer = NightShade100,
    secondaryVariant = NightShade200,
    onSecondaryVariant = NightShade900,
    success = Avocado400,
    onSuccess = NightShade900,
    successContainer = Avocado800,
    onSuccessContainer = Avocado100,
    alert = Banana300,
    onAlert = NightShade50,
    alertContainer = Banana800,
    onAlertContainer = Banana100,
    error = Cherry400,
    onError = NightShade900,
    errorContainer = Cherry800,
    onErrorContainer = Cherry100,
    info = Blueberry400,
    onInfo = NightShade100,
    infoContainer = Blueberry800,
    onInfoContainer = Blueberry100,
    neutral = NightShade400,
    onNeutral = NightShade900,
    neutralContainer = NightShade800,
    onNeutralContainer = NightShade100,
    background = NightShade900,
    onBackground = NightShade25,
    backgroundVariant = Blueberry900,
    onBackgroundVariant = NightShade25,
    surface = NightShade900,
    onSurface = NightShade25,
    surfaceInverse = NightShade50,
    onSurfaceInverse = NightShade900,
    surfaceTint = Blueberry400,
    outline = NightShade700,
    outlineHigh = Color.White,
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)
