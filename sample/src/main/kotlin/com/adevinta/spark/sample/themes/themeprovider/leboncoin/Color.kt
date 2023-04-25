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

import androidx.compose.ui.graphics.Color
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.darkSparkColors
import com.adevinta.spark.tokens.lightSparkColors

public fun lightLighthouseColors(
    isLegacy: Boolean,
    isPro: Boolean = false,
    primary: Color = if (isPro) {
        if (isLegacy) BrikkeBlue else Blueberry50
    } else {
        if (isLegacy) BrikkeOrange else Clementin50
    },
    onPrimary: Color = Color.White,
    primaryContainer: Color = if (isPro) {
        if (isLegacy) BrikkeBlueSurface else Blueberry90
    } else {
        if (isLegacy) BrikkeOrangeSurface else Clementin90
    },
    onPrimaryContainer: Color = if (isPro) {
        if (isLegacy) Blueberry10 else Blueberry30
    } else {
        if (isLegacy) Clementin10 else Clementin30
    },
    primaryVariant: Color = if (isPro) {
        if (isLegacy) BrikkeBlueDark else Blueberry30
    } else {
        if (isLegacy) BrikkeOrangeDark else Clementin40
    },
    onPrimaryVariant: Color = Color.White,
    secondary: Color = if (isLegacy) BrikkeBlack else Blueberry10,
    onSecondary: Color = Color.White,
    secondaryContainer: Color = if (isLegacy) BrikkeGreyLight else Blueberry90, // Highlight Surface => backgroundVariant
    onSecondaryContainer: Color = Blueberry10,
    secondaryVariant: Color = if (isLegacy) BrikkeGreyDark else NightShade40, // tertiary => neutral / Dim 1
    onSecondaryVariant: Color = if (isLegacy) Grey10 else Color.White,
    tertiary: Color = if (isLegacy) BrikkeGrey else Color.Magenta,
    onTertiary: Color = if (isLegacy) GreyBlue99 else Color.Blue,
    tertiaryContainer: Color = if (isLegacy) BrikkeGreyExtraLight else Color.Magenta,
    onTertiaryContainer: Color = if (isLegacy) GreyBlue10 else Color.Blue,
    error: Color = if (isLegacy) BrikkeRed else Cherry50,
    onError: Color = Grey100,
    errorContainer: Color = if (isLegacy) BrikkeRedSurface else Cherry95,
    onErrorContainer: Color = if (isLegacy) Red10 else Cherry30,
    success: Color = if (isLegacy) BrikkeGreen else Avocado50,
    onSuccess: Color = Grey100,
    successContainer: Color = if (isLegacy) BrikkeGreenSurface else Avocado95,
    onSuccessContainer: Color = if (isLegacy) Green10 else Avocado30,
    neutral: Color = NightShade50,
    onNeutral: Color = Color.White,
    neutralContainer: Color = NightShade90, // == surface Highlight
    onNeutralContainer: Color = NightShade30,
    background: Color = Color.White,
    onBackground: Color = Blueberry10,
    backgroundVariant: Color = if (isLegacy) GreyBlue90 else NightShade975, // == surface disabled
    onBackgroundVariant: Color = if (isLegacy) GreyBlue30 else Blueberry10,
    surface: Color = Color.White,
    onSurface: Color = if (isLegacy) Grey10 else Blueberry10,
    surfaceInverse: Color = if (isLegacy) Grey20 else Blueberry10,
    onSurfaceInverse: Color = if (isLegacy) Grey95 else Color.White,
    surfaceTint: Color = primary,
    outline: Color = if (isLegacy) GreyBlue50 else NightShade70,
    outlineHigh: Color = if (isLegacy) GreyBlue80 else Blueberry10,
): SparkColors = lightSparkColors(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,
    primaryVariant = primaryVariant,
    onPrimaryVariant = onPrimaryVariant,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,
    secondaryVariant = secondaryVariant,
    onSecondaryVariant = onSecondaryVariant,
    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = tertiaryContainer,
    onTertiaryContainer = onTertiaryContainer,
    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,
    success = success,
    onSuccess = onSuccess,
    successContainer = successContainer,
    onSuccessContainer = onSuccessContainer,
    neutral = neutral,
    onNeutral = onNeutral,
    neutralContainer = neutralContainer,
    onNeutralContainer = onNeutralContainer,
    background = background,
    onBackground = onBackground,
    backgroundVariant = backgroundVariant,
    onBackgroundVariant = onBackgroundVariant,
    surface = surface,
    onSurface = onSurface,
    surfaceInverse = surfaceInverse,
    onSurfaceInverse = onSurfaceInverse,
    surfaceTint = surfaceTint,
    outline = outline,
    outlineHigh = outlineHigh,
)

public fun darkLighthouseColors(
    isPro: Boolean = false,
    primary: Color = if (isPro) Blueberry60 else Clementin60,
    onPrimary: Color = NightShade10,
    primaryContainer: Color = if (isPro) Blueberry20 else Clementin20,
    onPrimaryContainer: Color = if (isPro) Blueberry90 else Clementin90,
    primaryVariant: Color = if (isPro) Blueberry80 else Clementin80,
    onPrimaryVariant: Color = NightShade10,
    secondary: Color = NightShade975,
    onSecondary: Color = NightShade10,
    secondaryContainer: Color = NightShade20,
    onSecondaryContainer: Color = NightShade90,
    secondaryVariant: Color = NightShade80,
    onSecondaryVariant: Color = NightShade10,
    neutral: Color = NightShade60,
    onNeutral: Color = NightShade90,
    neutralContainer: Color = NightShade20,
    onNeutralContainer: Color = NightShade90,
    background: Color = NightShade10,
    onBackground: Color = NightShade975,
    backgroundVariant: Color = Blueberry10,
    onBackgroundVariant: Color = NightShade975,
    surface: Color = NightShade10,
    onSurface: Color = NightShade975,
    surfaceInverse: Color = Blueberry10,
    onSurfaceInverse: Color = Color.White,
    surfaceTint: Color = primary,
    outline: Color = NightShade30,
    outlineHigh: Color = Blueberry10,
): SparkColors = darkSparkColors(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,
    primaryVariant = primaryVariant,
    onPrimaryVariant = onPrimaryVariant,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,
    secondaryVariant = secondaryVariant,
    onSecondaryVariant = onSecondaryVariant,
    neutral = neutral,
    onNeutral = onNeutral,
    neutralContainer = neutralContainer,
    onNeutralContainer = onNeutralContainer,
    background = background,
    onBackground = onBackground,
    backgroundVariant = backgroundVariant,
    onBackgroundVariant = onBackgroundVariant,
    surface = surface,
    onSurface = onSurface,
    surfaceInverse = surfaceInverse,
    onSurfaceInverse = onSurfaceInverse,
    surfaceTint = surfaceTint,
    outline = outline,
    outlineHigh = outlineHigh,
)

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
