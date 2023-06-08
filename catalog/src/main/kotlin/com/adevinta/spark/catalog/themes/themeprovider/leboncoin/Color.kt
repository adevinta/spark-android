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
import androidx.compose.ui.graphics.compositeOver
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
internal val Clementin10 = Color(0xFF2F1305)
internal val Clementin20 = Color(0xFF5C250A)
internal val Clementin30 = Color(0xFF89380F)
internal val Clementin40 = Color(0xFFB84A14)
internal val Clementin50 = Color(0xFFEC5A13)
internal val Clementin60 = Color(0xFFF07B42)
internal val Clementin70 = Color(0xFFF49D71)
internal val Clementin80 = Color(0xFFF7BEA1)
internal val Clementin90 = Color(0xFFFBDFD1)
internal val Clementin95 = Color(0xFFFDEFE8)
// endregion

// region Plum colors
internal val Plum10 = Color(0xFF14050D)
internal val Plum20 = Color(0xFF3D0F26)
internal val Plum30 = Color(0xFF531534)
internal val Plum40 = Color(0xFF7A1F4D)
internal val Plum50 = Color(0xFF8E2459)
internal val Plum60 = Color(0xFFA65980)
internal val Plum70 = Color(0xFFB87C9A)
internal val Plum80 = Color(0xFFDCBDCC)
internal val Plum90 = Color(0xFFEDDEE5)
internal val Plum95 = Color(0xFFF6EEF2)

// endregion

// region Cherry colors
internal val Cherry10 = Color(0xFF14050D)
internal val Cherry20 = Color(0xFF3D0F26)
internal val Cherry30 = Color(0xFF822017)
internal val Cherry40 = Color(0xFF7A1F4D)
internal val Cherry50 = Color(0xFFD93426)
internal val Cherry60 = Color(0xFFA65980)
internal val Cherry70 = Color(0xFFB87C9A)
internal val Cherry80 = Color(0xFFDCBDCC)
internal val Cherry90 = Color(0xFFEDDEE5)
internal val Cherry95 = Color(0xFFFBECEB)
// endregion

// region Avocado colors
internal val Avocado10 = Color(0xFF14050D)
internal val Avocado20 = Color(0xFF3D0F26)
internal val Avocado30 = Color(0xFF2F5B30)
internal val Avocado40 = Color(0xFF7A1F4D)
internal val Avocado50 = Color(0xFF4E9850)
internal val Avocado60 = Color(0xFFA65980)
internal val Avocado70 = Color(0xFFB87C9A)
internal val Avocado80 = Color(0xFFDCBDCC)
internal val Avocado90 = Color(0xFFEDDEE5)
internal val Avocado95 = Color(0xFFEDF5EE)
// endregion

// region Blueberry colors
internal val Blueberry10 = Color(0xFF06233D)
internal val Blueberry20 = Color(0xFF08365D)
internal val Blueberry30 = Color(0xFF0B518E)
internal val Blueberry40 = Color(0xFF0F6CBD)
internal val Blueberry50 = Color(0xFF1388EC)
internal val Blueberry60 = Color(0xFF429FF0)
internal val Blueberry70 = Color(0xFF71B7F4)
internal val Blueberry80 = Color(0xFFA0CFF7)
internal val Blueberry90 = Color(0xFFCFE6FB)
internal val Blueberry95 = Color(0xFFE7F3FD)
// endregion

// region NightShade colors
internal val NightShade0 = Color(0xFF010509)
internal val NightShade10 = Color(0xFF14191F)
internal val NightShade20 = Color(0xFF2B3640)
internal val NightShade30 = Color(0xFF3D4D5C)
internal val NightShade40 = Color(0xFF4E6579)
internal val NightShade50 = Color(0xFF627C93)
internal val NightShade60 = Color(0xFF7F95A9)
internal val NightShade70 = Color(0xFFA3B4C2)
internal val NightShade80 = Color(0xFFBBCDDD)
internal val NightShade90 = Color(0xFFDAE6F1)
internal val NightShade95 = Color(0xFFF0F5FA)
internal val NightShade975 = Color(0xFFF7FAFD)
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
    onPrimaryContainer = Clementin10,
    primaryVariant = BrikkeOrangeDark,
    secondary = BrikkeBlack,
    onSecondary = Color.White,
    secondaryContainer = BrikkeGreyLight, // Highlight Surface => backgroundVariant
    onSecondaryContainer = Blueberry10,
    secondaryVariant = BrikkeGreyDark, // tertiary => neutral / Dim 1
    onSecondaryVariant = Grey10,
    tertiary = BrikkeGrey,
    onTertiary = GreyBlue99,
    tertiaryContainer = BrikkeGreyExtraLight,
    onTertiaryContainer = GreyBlue10,
    success = BrikkeGreen,
    onSuccess = Color.White,
    successContainer = BrikkeGreenSurface,
    onSuccessContainer = Green10,
    alert = Color(0xFFffaa00),
    onAlert = NightShade10,
    alertContainer = Color(0xFFFFEECC),
    onAlertContainer = Color(0xFF996600),
    error = BrikkeRed,
    onError = Color.White,
    errorContainer = BrikkeRedSurface,
    onErrorContainer = Red10,
    info = Color(0xFF1388ec),
    onInfo = Color.White,
    infoContainer = Color(0xFFcfe6fb),
    onInfoContainer = Color(0xFF0b518e),
    neutral = NightShade50,
    onNeutral = Color.White,
    neutralContainer = NightShade90, // == surface Highlight
    onNeutralContainer = NightShade30,
    background = Color.White,
    onBackground = Blueberry10,
    backgroundVariant = GreyBlue90, // == surface disabled
    onBackgroundVariant = GreyBlue30,
    surface = Color.White,
    onSurface = Grey10,
    surfaceInverse = Grey20,
    onSurfaceInverse = Grey95,
    surfaceTint = Clementin50,
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
    onPrimaryContainer = Blueberry10,
    primaryVariant = BrikkeBlueDark,
    secondary = BrikkeBlack,
    onSecondary = Color.White,
    secondaryContainer = BrikkeGreyLight,
    onSecondaryContainer = Blueberry10,
    secondaryVariant = BrikkeGreyDark,
    onSecondaryVariant = Grey10,
    tertiary = BrikkeGrey,
    onTertiary = GreyBlue99,
    tertiaryContainer = BrikkeGreyExtraLight,
    onTertiaryContainer = GreyBlue10,
    success = BrikkeGreen,
    onSuccess = Color.White,
    successContainer = BrikkeGreenSurface,
    onSuccessContainer = Green10,
    alert = Color(0xFFffaa00),
    onAlert = NightShade10,
    alertContainer = Color(0xFFFFEECC),
    onAlertContainer = Color(0xFF996600),
    error = BrikkeRed,
    onError = Color.White,
    errorContainer = BrikkeRedSurface,
    onErrorContainer = Red10,
    info = Color(0xFF1388ec),
    onInfo = Color.White,
    infoContainer = Color(0xFFcfe6fb),
    onInfoContainer = Color(0xFF0b518e),
    neutral = NightShade50,
    onNeutral = Color.White,
    neutralContainer = NightShade90,
    onNeutralContainer = NightShade30,
    background = Color.White,
    onBackground = Blueberry10,
    backgroundVariant = GreyBlue90,
    onBackgroundVariant = GreyBlue30,
    surface = Color.White,
    onSurface = Grey10,
    surfaceInverse = Grey20,
    onSurfaceInverse = Grey95,
    surfaceTint = Clementin50,
    outline = GreyBlue50,
    outlineHigh = GreyBlue80,
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)

internal val LeboncoinColorPartLight: SparkColors = lightSparkColors(
    primary = Clementin50,
    onPrimary = Color.White,
    primaryContainer = Clementin90,
    onPrimaryContainer = Clementin30,
    primaryVariant = Clementin40,
    secondary = Blueberry10,
    onSecondary = Color.White,
    secondaryContainer = Blueberry90,
    onSecondaryContainer = Blueberry10,
    secondaryVariant = NightShade40,
    onSecondaryVariant = Color.White,
    tertiary = Color.Magenta,
    onTertiary = Color.Blue,
    tertiaryContainer = Color.Magenta,
    onTertiaryContainer = Color.Blue,
    success = Avocado50,
    onSuccess = Color.White,
    successContainer = Avocado95,
    onSuccessContainer = Avocado30,
    alert = Color(0xFFffaa00),
    onAlert = NightShade10,
    alertContainer = Color(0xFFFFEECC),
    onAlertContainer = Color(0xFF996600),
    error = Cherry50,
    onError = Color.White,
    errorContainer = Cherry95,
    onErrorContainer = Cherry30,
    info = Color(0xFF1388ec),
    onInfo = Color.White,
    infoContainer = Color(0xFFcfe6fb),
    onInfoContainer = Color(0xFF0b518e),
    neutral = NightShade50,
    onNeutral = Color.White,
    neutralContainer = NightShade90,
    onNeutralContainer = NightShade30,
    background = Color.White,
    onBackground = Blueberry10,
    backgroundVariant = NightShade975,
    onBackgroundVariant = Blueberry10,
    surface = Color.White,
    onSurface = Blueberry10,
    surfaceInverse = Blueberry10,
    onSurfaceInverse = Color.White,
    surfaceTint = Clementin50,
    outline = NightShade70,
    outlineHigh = Blueberry10,
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)

internal val LeboncoinColorProLight: SparkColors = lightSparkColors(
    primary = Blueberry50,
    onPrimary = Color.White,
    primaryContainer = Blueberry90,
    onPrimaryContainer = Blueberry30,
    primaryVariant = Blueberry30,
    secondary = Blueberry10,
    onSecondary = Color.White,
    secondaryContainer = Blueberry90,
    onSecondaryContainer = Blueberry10,
    secondaryVariant = NightShade40,
    onSecondaryVariant = Color.White,
    tertiary = Color.Magenta,
    onTertiary = Color.Blue,
    tertiaryContainer = Color.Magenta,
    onTertiaryContainer = Color.Blue,
    success = Avocado50,
    onSuccess = Color.White,
    successContainer = Avocado95,
    onSuccessContainer = Avocado30,
    alert = Color(0xFFffaa00),
    onAlert = NightShade10,
    alertContainer = Color(0xFFFFEECC),
    onAlertContainer = Color(0xFF996600),
    error = Cherry50,
    onError = Color.White,
    errorContainer = Cherry95,
    onErrorContainer = Cherry30,
    info = Color(0xFF1388ec),
    onInfo = Color.White,
    infoContainer = Color(0xFFcfe6fb),
    onInfoContainer = Color(0xFF0b518e),
    neutral = NightShade50,
    onNeutral = Color.White,
    neutralContainer = NightShade90,
    onNeutralContainer = NightShade30,
    background = Color.White,
    onBackground = Blueberry10,
    backgroundVariant = NightShade975,
    onBackgroundVariant = Blueberry10,
    surface = Color.White,
    onSurface = Blueberry10,
    surfaceInverse = Blueberry10,
    onSurfaceInverse = Color.White,
    surfaceTint = Clementin50,
    outline = NightShade70,
    outlineHigh = Blueberry10,
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)

internal val LeboncoinColorPartDark: SparkColors = darkSparkColors(
    primary = Clementin60,
    onPrimary = NightShade10,
    primaryContainer = Clementin20,
    onPrimaryContainer = Clementin90,
    primaryVariant = NightShade10,
    secondary = NightShade975,
    onSecondary = NightShade10,
    secondaryContainer = NightShade20,
    onSecondaryContainer = NightShade90,
    secondaryVariant = NightShade80,
    onSecondaryVariant = NightShade10,
    success = Avocado60,
    onSuccess = NightShade10,
    successContainer = Avocado20,
    onSuccessContainer = Avocado90,
    alert = Color(0xFFffcc66),
    onAlert = NightShade975,
    alertContainer = Color(0xFF664400),
    onAlertContainer = Color(0xFFffeecc),
    error = Cherry60,
    onError = NightShade10,
    errorContainer = Cherry20,
    onErrorContainer = Cherry90,
    info = Color(0xFF429ff0),
    onInfo = NightShade10,
    infoContainer = Color(0xFF08365d),
    onInfoContainer = Color(0xFFcfe6fb),
    neutral = NightShade60,
    onNeutral = NightShade10,
    neutralContainer = NightShade20,
    onNeutralContainer = NightShade90,
    background = NightShade10,
    onBackground = NightShade975,
    backgroundVariant = NightShade20,
    onBackgroundVariant = NightShade975,
    surface = NightShade10,
    onSurface = NightShade975,
    surfaceInverse = NightShade975,
    onSurfaceInverse = NightShade10,
    surfaceTint = Clementin60,
    outline = NightShade30,
    outlineHigh = NightShade20.copy(alpha = .75f).compositeOver(NightShade10),
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)

internal val LeboncoinColorProDark: SparkColors = darkSparkColors(
    primary = Blueberry60,
    onPrimary = NightShade10,
    primaryContainer = Blueberry20,
    onPrimaryContainer = Blueberry90,
    primaryVariant = Blueberry80,
    secondary = NightShade975,
    onSecondary = NightShade10,
    secondaryContainer = NightShade20,
    onSecondaryContainer = NightShade90,
    secondaryVariant = NightShade80,
    onSecondaryVariant = NightShade10,
    success = Avocado60,
    onSuccess = NightShade10,
    successContainer = Avocado20,
    onSuccessContainer = Avocado90,
    alert = Color(0xFFffcc66),
    onAlert = NightShade975,
    alertContainer = Color(0xFF664400),
    onAlertContainer = Color(0xFFffeecc),
    error = Cherry60,
    onError = NightShade10,
    errorContainer = Cherry20,
    onErrorContainer = Cherry90,
    info = Color(0xFF429ff0),
    onInfo = NightShade10,
    infoContainer = Color(0xFF08365d),
    onInfoContainer = Color(0xFFcfe6fb),
    neutral = NightShade60,
    onNeutral = NightShade10,
    neutralContainer = NightShade20,
    onNeutralContainer = NightShade90,
    background = NightShade10,
    onBackground = NightShade975,
    backgroundVariant = NightShade20,
    onBackgroundVariant = NightShade975,
    surface = NightShade10,
    onSurface = NightShade975,
    surfaceInverse = NightShade975,
    onSurfaceInverse = NightShade10,
    surfaceTint = Clementin60,
    outline = NightShade30,
    outlineHigh = NightShade20.copy(alpha = .75f).compositeOver(NightShade10),
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)
