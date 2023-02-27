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

package com.adevinta.spark.tokens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tokens.PaletteTokens.Apple10
import com.adevinta.spark.tokens.PaletteTokens.Apple20
import com.adevinta.spark.tokens.PaletteTokens.Apple40
import com.adevinta.spark.tokens.PaletteTokens.Apple50
import com.adevinta.spark.tokens.PaletteTokens.Apple70
import com.adevinta.spark.tokens.PaletteTokens.Apple80
import com.adevinta.spark.tokens.PaletteTokens.Black
import com.adevinta.spark.tokens.PaletteTokens.Blue10
import com.adevinta.spark.tokens.PaletteTokens.Blue20
import com.adevinta.spark.tokens.PaletteTokens.Blue30
import com.adevinta.spark.tokens.PaletteTokens.Blue70
import com.adevinta.spark.tokens.PaletteTokens.Blue80
import com.adevinta.spark.tokens.PaletteTokens.Blue90
import com.adevinta.spark.tokens.PaletteTokens.BrikkeBlack
import com.adevinta.spark.tokens.PaletteTokens.BrikkeBlue
import com.adevinta.spark.tokens.PaletteTokens.BrikkeBlueSurface
import com.adevinta.spark.tokens.PaletteTokens.BrikkeGreen
import com.adevinta.spark.tokens.PaletteTokens.BrikkeGreenSurface
import com.adevinta.spark.tokens.PaletteTokens.BrikkeGrey
import com.adevinta.spark.tokens.PaletteTokens.BrikkeGreyExtraLight
import com.adevinta.spark.tokens.PaletteTokens.BrikkeGreyLight
import com.adevinta.spark.tokens.PaletteTokens.BrikkeOrange
import com.adevinta.spark.tokens.PaletteTokens.BrikkeOrangeSurface
import com.adevinta.spark.tokens.PaletteTokens.BrikkeRed
import com.adevinta.spark.tokens.PaletteTokens.BrikkeRedSurface
import com.adevinta.spark.tokens.PaletteTokens.Green10
import com.adevinta.spark.tokens.PaletteTokens.Green20
import com.adevinta.spark.tokens.PaletteTokens.Green30
import com.adevinta.spark.tokens.PaletteTokens.Green80
import com.adevinta.spark.tokens.PaletteTokens.Green90
import com.adevinta.spark.tokens.PaletteTokens.Grey0
import com.adevinta.spark.tokens.PaletteTokens.Grey10
import com.adevinta.spark.tokens.PaletteTokens.Grey100
import com.adevinta.spark.tokens.PaletteTokens.Grey20
import com.adevinta.spark.tokens.PaletteTokens.Grey30
import com.adevinta.spark.tokens.PaletteTokens.Grey80
import com.adevinta.spark.tokens.PaletteTokens.Grey90
import com.adevinta.spark.tokens.PaletteTokens.Grey95
import com.adevinta.spark.tokens.PaletteTokens.Grey99
import com.adevinta.spark.tokens.PaletteTokens.GreyBlue10
import com.adevinta.spark.tokens.PaletteTokens.GreyBlue20
import com.adevinta.spark.tokens.PaletteTokens.GreyBlue30
import com.adevinta.spark.tokens.PaletteTokens.GreyBlue40
import com.adevinta.spark.tokens.PaletteTokens.GreyBlue50
import com.adevinta.spark.tokens.PaletteTokens.GreyBlue80
import com.adevinta.spark.tokens.PaletteTokens.GreyBlue90
import com.adevinta.spark.tokens.PaletteTokens.GreyBlue95
import com.adevinta.spark.tokens.PaletteTokens.GreyBlue99
import com.adevinta.spark.tokens.PaletteTokens.Orange10
import com.adevinta.spark.tokens.PaletteTokens.Orange20
import com.adevinta.spark.tokens.PaletteTokens.Orange30
import com.adevinta.spark.tokens.PaletteTokens.Orange40
import com.adevinta.spark.tokens.PaletteTokens.Orange80
import com.adevinta.spark.tokens.PaletteTokens.Orange90
import com.adevinta.spark.tokens.PaletteTokens.Red10
import com.adevinta.spark.tokens.PaletteTokens.Red20
import com.adevinta.spark.tokens.PaletteTokens.Red30
import com.adevinta.spark.tokens.PaletteTokens.Red80
import com.adevinta.spark.tokens.PaletteTokens.Red90
import com.adevinta.spark.tokens.PaletteTokens.Sky10
import com.adevinta.spark.tokens.PaletteTokens.Sky20
import com.adevinta.spark.tokens.PaletteTokens.Sky40
import com.adevinta.spark.tokens.PaletteTokens.Sky50
import com.adevinta.spark.tokens.PaletteTokens.Sky70
import com.adevinta.spark.tokens.PaletteTokens.Sky80
import com.adevinta.spark.tokens.PaletteTokens.Sugarcotton10
import com.adevinta.spark.tokens.PaletteTokens.Sugarcotton30
import com.adevinta.spark.tokens.PaletteTokens.Sugarcotton50
import com.adevinta.spark.tokens.PaletteTokens.Sugarcotton70
import com.adevinta.spark.tokens.PaletteTokens.Surfer10
import com.adevinta.spark.tokens.PaletteTokens.Surfer20
import com.adevinta.spark.tokens.PaletteTokens.Surfer50
import com.adevinta.spark.tokens.PaletteTokens.Surfer70
import com.adevinta.spark.tokens.PaletteTokens.Surfer80
import com.adevinta.spark.tokens.PaletteTokens.Surfer90
import com.adevinta.spark.tokens.PaletteTokens.TheBlue20
import com.adevinta.spark.tokens.PaletteTokens.White
import com.adevinta.spark.tokens.PaletteTokens.Wiggings10
import com.adevinta.spark.tokens.PaletteTokens.Wiggings20
import com.adevinta.spark.tokens.PaletteTokens.Wiggings40
import com.adevinta.spark.tokens.PaletteTokens.Wiggings50
import com.adevinta.spark.tokens.PaletteTokens.Wiggings70
import com.adevinta.spark.tokens.PaletteTokens.Wiggings80
import com.adevinta.spark.tools.preview.SparkPreviewProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import com.adevinta.spark.tools.preview.UserType

public fun lightSparkColors(
    isPro: Boolean = false,
    primary: Color = if (isPro) BrikkeBlue else BrikkeOrange,
    onPrimary: Color = if (isPro) Grey100 else Grey100,
    primaryContainer: Color = if (isPro) BrikkeBlueSurface else BrikkeOrangeSurface,
    onPrimaryContainer: Color = if (isPro) Blue10 else Orange10,
    primaryVariant: Color = Blue70,
    onPrimaryVariant: Color = Grey100,
    secondary: Color = BrikkeBlack,
    onSecondary: Color = Grey100,
    secondaryContainer: Color = Sugarcotton10,
    onSecondaryContainer: Color = White,
    secondaryVariant: Color = Sugarcotton70,
    onSecondaryVariant: Color = White,
    tertiary: Color = BrikkeGrey,
    onTertiary: Color = GreyBlue99,
    tertiaryContainer: Color = BrikkeGreyExtraLight,
    onTertiaryContainer: Color = GreyBlue10,
    success: Color = Apple50,
    onSuccess: Color = White,
    successContainer: Color = Apple10,
    onSuccessContainer: Color = Apple70,
    alert: Color = Wiggings50,
    onAlert: Color = Black,
    alertContainer: Color = Wiggings10,
    onAlertContainer: Color = Wiggings70,
    error: Color = BrikkeRed,
    onError: Color = Grey100,
    errorContainer: Color = BrikkeRedSurface,
    onErrorContainer: Color = Red10,
    info: Color = Sky50,
    onInfo: Color = White,
    infoContainer: Color = Sky10,
    onInfoContainer: Color = Sky70,
    neutral: Color = Surfer50,
    onNeutral: Color = White,
    neutralContainer: Color = Surfer10,
    onNeutralContainer: Color = Surfer70,
    valid: Color = BrikkeGreen,
    onValid: Color = Grey100,
    validContainer: Color = BrikkeGreenSurface,
    onValidContainer: Color = Green10,
    background: Color = Grey100,
    onBackground: Color = Grey10,
    surface: Color = Grey100,
    onSurface: Color = Grey10,
    surfaceVariant: Color = GreyBlue90,
    onSurfaceVariant: Color = GreyBlue30,
    surfaceInverse: Color = Surfer90,
    onSurfaceInverse: Color = White,
    surfaceTint: Color = primary,
    inversePrimary: Color = Orange80,
    inverseSurface: Color = Grey20,
    inverseOnSurface: Color = Grey95,
    outline: Color = GreyBlue50,
    outlineHigh: Color = Surfer20,
    overlay: Color = Surfer80.copy(alpha = 0.75f),
    outlineVariant: Color = GreyBlue80,
    scrim: Color = Grey0,
): SparkColors = SparkColors(
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
    success = success,
    onSuccess = onSuccess,
    successContainer = successContainer,
    onSuccessContainer = onSuccessContainer,
    alert = alert,
    onAlert = onAlert,
    alertContainer = alertContainer,
    onAlertContainer = onAlertContainer,
    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,
    info = info,
    onInfo = onInfo,
    infoContainer = infoContainer,
    onInfoContainer = onInfoContainer,
    neutral = neutral,
    onNeutral = onNeutral,
    neutralContainer = neutralContainer,
    onNeutralContainer = onNeutralContainer,
    valid = valid,
    onValid = onValid,
    validContainer = validContainer,
    onValidContainer = onValidContainer,
    background = background,
    onBackground = onBackground,
    surface = surface,
    onSurface = onSurface,
    surfaceInverse = surfaceInverse,
    onSurfaceInverse = onSurfaceInverse,
    surfaceVariant = surfaceVariant,
    onSurfaceVariant = onSurfaceVariant,
    surfaceTint = surfaceTint,
    outline = outline,
    outlineHigh = outlineHigh,
    overlay = overlay,
    outlineVariant = outlineVariant,
    scrim = scrim,
    inversePrimary = inversePrimary,
    inverseSurface = inverseSurface,
    inverseOnSurface = inverseOnSurface,
)

public fun darkSparkColors(
    isPro: Boolean = false,
    primary: Color = if (isPro) Blue80 else Orange80,
    onPrimary: Color = if (isPro) Blue20 else Orange20,
    primaryContainer: Color = if (isPro) Blue30 else Orange30,
    onPrimaryContainer: Color = if (isPro) Blue90 else Orange90,
    primaryVariant: Color = TheBlue20,
    onPrimaryVariant: Color = Black,
    secondary: Color = Grey99,
    onSecondary: Color = Color.Black,
    secondaryContainer: Color = Grey30,
    onSecondaryContainer: Color = Grey90,
    secondaryVariant: Color = Sugarcotton30,
    onSecondaryVariant: Color = Black,
    tertiary: Color = GreyBlue40,
    onTertiary: Color = GreyBlue90,
    tertiaryContainer: Color = GreyBlue20,
    onTertiaryContainer: Color = GreyBlue95,
    success: Color = Apple40,
    onSuccess: Color = Black,
    successContainer: Color = Apple80,
    onSuccessContainer: Color = Apple20,
    alert: Color = Wiggings40,
    onAlert: Color = Black,
    alertContainer: Color = Wiggings80,
    onAlertContainer: Color = Wiggings20,
    error: Color = Red80,
    onError: Color = Red20,
    errorContainer: Color = Red30,
    onErrorContainer: Color = Red90,
    info: Color = Sky40,
    onInfo: Color = Black,
    infoContainer: Color = Sky80,
    onInfoContainer: Color = Sky20,
    neutral: Color = Surfer50,
    onNeutral: Color = Black,
    neutralContainer: Color = Surfer80,
    onNeutralContainer: Color = Surfer20,
    valid: Color = Green80,
    onValid: Color = Green20,
    validContainer: Color = Green30,
    onValidContainer: Color = Green90,
    background: Color = Grey10,
    onBackground: Color = Grey90,
    surface: Color = Grey10,
    onSurface: Color = Grey80,
    surfaceVariant: Color = GreyBlue30,
    onSurfaceVariant: Color = GreyBlue80,
    surfaceInverse: Color = Surfer50,
    onSurfaceInverse: Color = Black,
    surfaceTint: Color = primary,
    outline: Color = GreyBlue50,
    outlineHigh: Color = Surfer70,
    overlay: Color = Surfer80.copy(alpha = 0.75f),
    outlineVariant: Color = GreyBlue30,
    inversePrimary: Color = Orange40,
    inverseSurface: Color = onSurface,
    inverseOnSurface: Color = Grey20,
    scrim: Color = Grey0,
): SparkColors = SparkColors(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,
    primaryVariant = primaryContainer,
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
    success = success,
    onSuccess = onSuccess,
    successContainer = successContainer,
    onSuccessContainer = onSuccessContainer,
    alert = alert,
    onAlert = onAlert,
    alertContainer = alertContainer,
    onAlertContainer = onAlertContainer,
    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,
    info = info,
    onInfo = onInfo,
    infoContainer = infoContainer,
    onInfoContainer = onInfoContainer,
    neutral = neutral,
    onNeutral = onNeutral,
    neutralContainer = neutralContainer,
    onNeutralContainer = onNeutralContainer,
    valid = valid,
    onValid = onValid,
    validContainer = validContainer,
    onValidContainer = onValidContainer,
    background = background,
    onBackground = onBackground,
    surface = surface,
    onSurface = onSurface,
    surfaceInverse = surfaceInverse,
    onSurfaceInverse = onSurfaceInverse,
    surfaceVariant = surfaceVariant,
    onSurfaceVariant = onSurfaceVariant,
    surfaceTint = surfaceTint,
    outline = outline,
    outlineHigh = outlineHigh,
    overlay = overlay,
    outlineVariant = outlineVariant,
    scrim = scrim,
    inversePrimary = inversePrimary,
    inverseSurface = inverseSurface,
    inverseOnSurface = inverseOnSurface,
)


/**
 * A color scheme holds all the named color parameters for a [SparkTheme] highly inspired by Material 3 ColorScheme.
 *
 * SparkColors are designed to be harmonious, ensure accessible text, and distinguish UI
 * elements and surfaces from one another. There are two built-in baseline schemes,
 * [lightSparkColors] and a [darkSparkColors], that can be used as-is or customized.
 *
 * To learn more about colors, see [Material Design colors](https://m3.material.io/styles/color/overview) and
 * [Spark colors](https://zeroheight.com/25c15666f/p/40105d-colors/b/77b3e7).
 *
 * @property primary The primary color is the color displayed most frequently across your app’s
 * screens and components.
 * @property onPrimary Color used for text and icons displayed on top of the primary color.
 * @property primaryContainer The preferred tonal color of containers.
 * @property onPrimaryContainer The color (and state variants) that should be used for content on
 * top of [primaryContainer].
 * @property primaryVariant Darker variation of [primary] color.
 * @property onPrimaryVariant Color used for text and icons displayed on top of the [primaryVariant] color.
 * @property inversePrimary Color to be used as a "primary" color in places where the inverse color
 * scheme is needed.
 * @property secondary The secondary color provides more ways to accent and distinguish your
 * product. Secondary colors are best for:
 * - Floating action buttons
 * - Selection controls, like checkboxes and radio buttons
 * - Highlighting selected text
 * - Links and headlines
 * @property onSecondary Color used for text and icons displayed on top of the secondary color.
 * @property secondaryContainer A tonal color to be used in containers.
 * @property onSecondaryContainer The color (and state variants) that should be used for content on
 * top of [secondaryContainer].
 * @property secondaryVariant Darker variation of [secondary] color.
 * @property onSecondaryVariant Color used for text and icons displayed on top of the [secondaryVariant] color.
 * @property tertiary The tertiary color that can be used to balance primary and secondary
 * colors, or bring heightened attention to an element such as an input field.
 * @property onTertiary Color used for text and icons displayed on top of the tertiary color.
 * @property tertiaryContainer A tonal color to be used in containers.
 * @property onTertiaryContainer The color (and state variants) that should be used for content on
 * top of [tertiaryContainer].
 * @property success An emphasis color used to provide a positive feedback.
 * @property onSuccess Color used for text and icons displayed on top of the [success] color.
 * @property successContainer The preferred tonal color of success containers.
 * @property onSuccessContainer Color used for text and icons displayed on top of the [successContainer] color.
 * @property alert An emphasis color used to provide a warning feedback.
 * @property onAlert Color used for text and icons displayed on top of the [alert] color.
 * @property alertContainer The preferred tonal color of warning containers.
 * @property onAlertContainer Color used for text and icons displayed on top of the [alertContainer] color.
 * @property error The error color is used to indicate errors in components, such as invalid text in
 * a text field.
 * @property onError Color used for text and icons displayed on top of the error color.
 * @property errorContainer The preferred tonal color of error containers.
 * @property onErrorContainer The color (and state variants) that should be used for content on
 * top of [errorContainer].
 * @property info An emphasis color used to provide an informative feedback.
 * @property onInfo Color used for text and icons displayed on top of the [info] color.
 * @property infoContainer The preferred tonal color of info containers.
 * @property onInfoContainer Color used for text and icons displayed on top of the [infoContainer] color.
 * @property neutral An emphasis color used to provide a neutral feedback.
 * @property onNeutral Color used for text and icons displayed on top of the [neutral] color.
 * @property neutralContainer The preferred tonal color of neutral containers.
 * @property onNeutralContainer Color used for text and icons displayed on top of the [neutralContainer] color.
 * @property background The background color that appears behind scrollable content.
 * @property onBackground Color used for text and icons displayed on top of the background color.
 * @property surface The surface color that affect surfaces of components, such as cards, sheets,
 * and menus.
 * @property onSurface Color used for text and icons displayed on top of the surface color.
 * @property surfaceInverse
 * @property onSurfaceInverse
 * @property surfaceVariant Another option for a color with similar uses of [surface].
 * @property onSurfaceVariant The color (and state variants) that can be used for content on top of
 * [surface].
 * @property surfaceTint This color will be used by components that apply tonal elevation and is
 * applied on top of [surface]. The higher the elevation the more this color is used.
 * @property inverseSurface A color that contrasts sharply with [surface]. Useful for surfaces that
 * sit on top of other surfaces with [surface] color.
 * @property inverseOnSurface A color that contrasts well with [inverseSurface]. Useful for content
 * that sits on top of containers that are [inverseSurface].
 * @property outline Subtle color used for boundaries. Outline color role adds contrast for
 * accessibility purposes.
 * @property outlineHigh Utility color used for boundaries for decorative elements when strong
 *  * contrast is not required.
 * @property outlineVariant Utility color used for boundaries for decorative elements when strong
 * contrast is not required.
 * @property overlay Color of a scrim that obscures content. Commonly used for layers in Modals, Drawers, etc.
 * @property scrim Color of a scrim that obscures content. On Android platforms, the scrim color
 * and opacity is automatically handled by the system UI.
 */
@Stable
public class SparkColors(
    primary: Color,
    onPrimary: Color,
    primaryContainer: Color,
    onPrimaryContainer: Color,
    primaryVariant: Color,
    onPrimaryVariant: Color,
    secondary: Color,
    onSecondary: Color,
    secondaryContainer: Color,
    onSecondaryContainer: Color,
    secondaryVariant: Color,
    onSecondaryVariant: Color,
    tertiary: Color,
    onTertiary: Color,
    tertiaryContainer: Color,
    onTertiaryContainer: Color,
    success: Color,
    onSuccess: Color,
    successContainer: Color,
    onSuccessContainer: Color,
    alert: Color,
    onAlert: Color,
    alertContainer: Color,
    onAlertContainer: Color,
    error: Color,
    onError: Color,
    errorContainer: Color,
    onErrorContainer: Color,
    info: Color,
    onInfo: Color,
    infoContainer: Color,
    onInfoContainer: Color,
    neutral: Color,
    onNeutral: Color,
    neutralContainer: Color,
    onNeutralContainer: Color,
    valid: Color,
    onValid: Color,
    validContainer: Color,
    onValidContainer: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface: Color,
    surfaceVariant: Color,
    onSurfaceVariant: Color,
    surfaceInverse: Color,
    onSurfaceInverse: Color,
    surfaceTint: Color,
    inversePrimary: Color,
    inverseSurface: Color,
    inverseOnSurface: Color,
    outline: Color,
    outlineHigh: Color,
    overlay: Color,
    outlineVariant: Color,
    scrim: Color,
) {
    public var primary: Color by mutableStateOf(primary, structuralEqualityPolicy())
        internal set
    public var onPrimary: Color by mutableStateOf(onPrimary, structuralEqualityPolicy())
        internal set
    public var primaryContainer: Color by mutableStateOf(primaryContainer, structuralEqualityPolicy())
        internal set
    public var onPrimaryContainer: Color by mutableStateOf(onPrimaryContainer, structuralEqualityPolicy())
        internal set
    public var primaryVariant: Color by mutableStateOf(primaryVariant, structuralEqualityPolicy())
        internal set
    public var onPrimaryVariant: Color by mutableStateOf(onPrimaryVariant, structuralEqualityPolicy())
        internal set

    public var secondary: Color by mutableStateOf(secondary, structuralEqualityPolicy())
        internal set
    public var onSecondary: Color by mutableStateOf(onSecondary, structuralEqualityPolicy())
        internal set
    public var secondaryContainer: Color by mutableStateOf(secondaryContainer, structuralEqualityPolicy())
        internal set
    public var onSecondaryContainer: Color by mutableStateOf(onSecondaryContainer, structuralEqualityPolicy())
        internal set
    public var secondaryVariant: Color by mutableStateOf(secondaryVariant, structuralEqualityPolicy())
        internal set
    public var onSecondaryVariant: Color by mutableStateOf(onSecondaryVariant, structuralEqualityPolicy())
        internal set

    @Deprecated("This property will be removed as it is not part of Spark Token")
    public var tertiary: Color by mutableStateOf(tertiary, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token")
    public var onTertiary: Color by mutableStateOf(onTertiary, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token")
    public var tertiaryContainer: Color by mutableStateOf(tertiaryContainer, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token")
    public var onTertiaryContainer: Color by mutableStateOf(onTertiaryContainer, structuralEqualityPolicy())
        internal set

    public var background: Color by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    public var onBackground: Color by mutableStateOf(onBackground, structuralEqualityPolicy())
        internal set
    public var surface: Color by mutableStateOf(surface, structuralEqualityPolicy())
        internal set
    public var onSurface: Color by mutableStateOf(onSurface, structuralEqualityPolicy())
        internal set
    public var surfaceInverse: Color by mutableStateOf(surfaceInverse, structuralEqualityPolicy())
        internal set
    public var onSurfaceInverse: Color by mutableStateOf(onSurfaceInverse, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token")
    public var surfaceVariant: Color by mutableStateOf(surfaceVariant, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token")
    public var onSurfaceVariant: Color by mutableStateOf(onSurfaceVariant, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token")
    public var surfaceTint: Color by mutableStateOf(surfaceTint, structuralEqualityPolicy())
        internal set
    public var outline: Color by mutableStateOf(outline, structuralEqualityPolicy())
        internal set
    public var outlineHigh: Color by mutableStateOf(outlineHigh, structuralEqualityPolicy())
        internal set
    public var overlay: Color by mutableStateOf(overlay, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token", replaceWith = ReplaceWith("outlineHigh"), level = DeprecationLevel.WARNING)
    public var outlineVariant: Color by mutableStateOf(outlineVariant, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token", replaceWith = ReplaceWith("overlay"), level = DeprecationLevel.WARNING)
    public var scrim: Color by mutableStateOf(scrim, structuralEqualityPolicy())
        internal set

    public var success: Color by mutableStateOf(success, structuralEqualityPolicy())
        internal set
    public var onSuccess: Color by mutableStateOf(onSuccess, structuralEqualityPolicy())
        internal set
    public var successContainer: Color by mutableStateOf(successContainer, structuralEqualityPolicy())
        internal set
    public var onSuccessContainer: Color by mutableStateOf(onSuccessContainer, structuralEqualityPolicy())
        internal set

    public var alert: Color by mutableStateOf(alert, structuralEqualityPolicy())
        internal set
    public var onAlert: Color by mutableStateOf(onAlert, structuralEqualityPolicy())
        internal set
    public var alertContainer: Color by mutableStateOf(alertContainer, structuralEqualityPolicy())
        internal set
    public var onAlertContainer: Color by mutableStateOf(onAlertContainer, structuralEqualityPolicy())
        internal set

    public var error: Color by mutableStateOf(error, structuralEqualityPolicy())
        internal set
    public var onError: Color by mutableStateOf(onError, structuralEqualityPolicy())
        internal set
    public var errorContainer: Color by mutableStateOf(errorContainer, structuralEqualityPolicy())
        internal set
    public var onErrorContainer: Color by mutableStateOf(onErrorContainer, structuralEqualityPolicy())
        internal set

    public var info: Color by mutableStateOf(info, structuralEqualityPolicy())
        internal set
    public var onInfo: Color by mutableStateOf(onInfo, structuralEqualityPolicy())
        internal set
    public var infoContainer: Color by mutableStateOf(infoContainer, structuralEqualityPolicy())
        internal set
    public var onInfoContainer: Color by mutableStateOf(onInfoContainer, structuralEqualityPolicy())
        internal set

    public var neutral: Color by mutableStateOf(neutral, structuralEqualityPolicy())
        internal set
    public var onNeutral: Color by mutableStateOf(onNeutral, structuralEqualityPolicy())
        internal set
    public var neutralContainer: Color by mutableStateOf(neutralContainer, structuralEqualityPolicy())
        internal set
    public var onNeutralContainer: Color by mutableStateOf(onNeutralContainer, structuralEqualityPolicy())
        internal set

    @Deprecated("This property will be removed as it is not part of Spark Token", replaceWith = ReplaceWith("success"), level = DeprecationLevel.WARNING)
    public var valid: Color by mutableStateOf(valid, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token", replaceWith = ReplaceWith("onSuccess"), level = DeprecationLevel.WARNING)
    public var onValid: Color by mutableStateOf(onValid, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token", replaceWith = ReplaceWith("successContainer"), level = DeprecationLevel.WARNING)
    public var validContainer: Color by mutableStateOf(validContainer, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token", replaceWith = ReplaceWith("onSuccessContainer"), level = DeprecationLevel.WARNING)
    public var onValidContainer: Color by mutableStateOf(onValidContainer, structuralEqualityPolicy())
        internal set

    @Deprecated("This property will be removed as it is not part of Spark Token")
    public var inversePrimary: Color by mutableStateOf(inversePrimary, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token", replaceWith = ReplaceWith("surfaceInverse"), level = DeprecationLevel.WARNING)
    public var inverseSurface: Color by mutableStateOf(inverseSurface, structuralEqualityPolicy())
        internal set
    @Deprecated("This property will be removed as it is not part of Spark Token", replaceWith = ReplaceWith("onSurfaceInverse"), level = DeprecationLevel.WARNING)
    public var inverseOnSurface: Color by mutableStateOf(inverseOnSurface, structuralEqualityPolicy())
        internal set

    /**
     * Returns a copy of this Colors, optionally overriding some of the values.
     */
    public fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        primaryContainer: Color = this.primaryContainer,
        onPrimaryContainer: Color = this.onPrimaryContainer,
        primaryVariant: Color = this.primaryVariant,
        onPrimaryVariant: Color = this.onPrimaryVariant,
        secondary: Color = this.secondary,
        onSecondary: Color = this.onSecondary,
        secondaryContainer: Color = this.secondaryContainer,
        onSecondaryContainer: Color = this.onSecondaryContainer,
        secondaryVariant: Color = this.secondaryVariant,
        onSecondaryVariant: Color = this.onSecondaryVariant,
        tertiary: Color = this.tertiary,
        onTertiary: Color = this.onTertiary,
        tertiaryContainer: Color = this.tertiaryContainer,
        onTertiaryContainer: Color = this.onTertiaryContainer,
        background: Color = this.background,
        onBackground: Color = this.onBackground,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        surfaceInverse: Color = this.surfaceInverse,
        onSurfaceInverse: Color = this.onSurfaceInverse,
        surfaceVariant: Color = this.surfaceVariant,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        surfaceTint: Color = this.surfaceTint,
        outline: Color = this.outline,
        outlineHigh: Color = this.outlineHigh,
        overlay: Color = this.overlay,
        outlineVariant: Color = this.outlineVariant,
        scrim: Color = this.scrim,
        success: Color = this.success,
        onSuccess: Color = this.onSuccess,
        successContainer: Color = this.successContainer,
        onSuccessContainer: Color = this.onSuccessContainer,
        alert: Color = this.alert,
        onAlert: Color = this.onAlert,
        alertContainer: Color = this.alertContainer,
        onAlertContainer: Color = this.onAlertContainer,
        error: Color = this.error,
        onError: Color = this.onError,
        errorContainer: Color = this.errorContainer,
        onErrorContainer: Color = this.onErrorContainer,
        info: Color = this.info,
        onInfo: Color = this.onInfo,
        infoContainer: Color = this.infoContainer,
        onInfoContainer: Color = this.onInfoContainer,
        neutral: Color = this.neutral,
        onNeutral: Color = this.onNeutral,
        neutralContainer: Color = this.neutralContainer,
        onNeutralContainer: Color = this.onNeutralContainer,
        valid: Color = this.valid,
        onValid: Color = this.onValid,
        validContainer: Color = this.validContainer,
        onValidContainer: Color = this.onValidContainer,
        inversePrimary: Color = this.inversePrimary,
        inverseSurface: Color = this.inverseSurface,
        inverseOnSurface: Color = this.inverseOnSurface,
    ): SparkColors = SparkColors(
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
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceInverse = surfaceInverse,
        onSurfaceInverse = onSurfaceInverse,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        outline = outline,
        outlineHigh = outlineHigh,
        overlay = overlay,
        outlineVariant = outlineVariant,
        scrim = scrim,
        success = success,
        onSuccess = onSuccess,
        successContainer = successContainer,
        onSuccessContainer = onSuccessContainer,
        alert = alert,
        onAlert = onAlert,
        alertContainer = alertContainer,
        onAlertContainer = onAlertContainer,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        info = info,
        onInfo = onInfo,
        infoContainer = infoContainer,
        onInfoContainer = onInfoContainer,
        neutral = neutral,
        onNeutral = onNeutral,
        neutralContainer = neutralContainer,
        onNeutralContainer = onNeutralContainer,
        valid = valid,
        onValid = onValid,
        validContainer = validContainer,
        onValidContainer = onValidContainer,
        inversePrimary = inversePrimary,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
    )

    override fun toString(): String = buildString {
        append("SparkColors(")
        append("primary=$primary, ")
        append("onPrimary=$onPrimary, ")
        append("primaryContainer=$primaryContainer, ")
        append("onPrimaryContainer=$onPrimaryContainer, ")
        append("secondary=$secondary, ")
        append("onSecondary=$onSecondary, ")
        append("secondaryContainer=$secondaryContainer, ")
        append("onSecondaryContainer=$onSecondaryContainer, ")
        append("tertiary=$tertiary, ")
        append("onTertiary=$onTertiary, ")
        append("tertiaryContainer=$tertiaryContainer, ")
        append("onTertiaryContainer=$onTertiaryContainer, ")
        append("background=$background, ")
        append("onBackground=$onBackground, ")
        append("surface=$surface, ")
        append("onSurface=$onSurface, ")
        append("surfaceVariant=$surfaceVariant, ")
        append("onSurfaceVariant=$onSurfaceVariant, ")
        append("surfaceTint=$surfaceTint, ")
        append("outline=$outline, ")
        append("outlineVariant=$outlineVariant, ")
        append("scrim=$scrim, ")
        append("error=$error, ")
        append("onError=$onError, ")
        append("errorContainer=$errorContainer, ")
        append("onErrorContainer=$onErrorContainer, ")
        append("valid=$valid, ")
        append("onValid=$onValid, ")
        append("validContainer=$validContainer, ")
        append("onValidContainer=$onValidContainer, ")
        append("inversePrimary=$inversePrimary, ")
        append("inverseSurface=$inverseSurface, ")
        append("inverseOnSurface=$inverseOnSurface, ")
        append(")")
    }
}

public fun SparkColors.asMaterial3Colors(): ColorScheme = ColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,
    inversePrimary = inversePrimary,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,
    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = tertiaryContainer,
    onTertiaryContainer = onTertiaryContainer,
    background = background,
    onBackground = onBackground,
    surface = surface,
    onSurface = onSurface,
    surfaceVariant = surfaceVariant,
    onSurfaceVariant = onSurfaceVariant,
    surfaceTint = surfaceTint,
    inverseSurface = inverseSurface,
    inverseOnSurface = inverseOnSurface,
    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,
    outline = outline,
    outlineVariant = outlineVariant,
    scrim = scrim,
)

/**
 * The Material color system contains pairs of colors that are typically used for the background
 * and content color inside a component. For example, a [Button] typically uses `primary` for its
 * background, and `onPrimary` for the color of its content (usually text or iconography).
 *
 * This function tries to match the provided [backgroundColor] to a 'background' color in this
 * [Colors], and then will return the corresponding color used for content. For example, when
 * [backgroundColor] is [Colors.primary], this will return [Colors.onPrimary].
 *
 * If [backgroundColor] does not match a background color in the theme, this will return
 * [Color.Unspecified].
 *
 * @return the matching content color for [backgroundColor]. If [backgroundColor] is not present in
 * the theme's [Colors], then returns [Color.Unspecified].
 *
 * @see contentColorFor
 */
public fun SparkColors.contentColorFor(backgroundColor: Color): Color = when (backgroundColor) {
    primary -> onPrimary
    primaryContainer -> onPrimaryContainer
    secondary -> onSecondary
    secondaryContainer -> onSecondaryContainer
    tertiary -> onTertiary
    tertiaryContainer -> onTertiaryContainer
    background -> onBackground
    surface -> onSurface
    surfaceVariant -> onSurfaceVariant
    inverseSurface -> inverseOnSurface
    error -> onError
    errorContainer -> onErrorContainer
    valid -> onValid
    validContainer -> onValidContainer
    else -> Color.Unspecified
}

/**
 * The Material color system contains pairs of colors that are typically used for the background
 * and content color inside a component. For example, a [Button] typically uses `primary` for its
 * background, and `onPrimary` for the color of its content (usually text or iconography).
 *
 * This function tries to match the provided [backgroundColor] to a 'background' color in this
 * [Colors], and then will return the corresponding color used for content. For example, when
 * [backgroundColor] is [Colors.primary], this will return [Colors.onPrimary].
 *
 * If [backgroundColor] does not match a background color in the theme, this will return
 * the current value of [LocalContentColor] as a best-effort color.
 *
 * @return the matching content color for [backgroundColor]. If [backgroundColor] is not present in
 * the theme's [Colors], then returns the current value of [LocalContentColor].
 *
 * @see Colors.contentColorFor
 */
@Composable
@ReadOnlyComposable
public fun contentColorFor(backgroundColor: Color): Color {
    return SparkTheme.colors.contentColorFor(backgroundColor).takeOrElse {
        LocalContentColor.current
    }
}

/**
 * Updates the internal values of the given [SparkColors] with values from the [other] [SparkColors]. This
 * allows efficiently updating a subset of [SparkColors], without recomposing every composable that
 * consumes values from [LocalSparkColors].
 *
 * Because [SparkColors] is very wide-reaching, and used by many expensive composables in the
 * hierarchy, providing a new value to [LocalSparkColors] causes every composable consuming
 * [LocalSparkColors] to recompose, which is prohibitively expensive in cases such as animating one
 * color in the theme. Instead, [SparkColors] is internally backed by [mutableStateOf], and this
 * function mutates the internal state of [this] to match values in [other]. This means that any
 * changes will mutate the internal state of [this], and only cause composables that are reading
 * the specific changed value to recompose.
 */
internal fun SparkColors.updateColorsFrom(other: SparkColors) {
    primary = other.primary
    onPrimary = other.onPrimary
    primaryContainer = other.primaryContainer
    onPrimaryContainer = other.onPrimaryContainer
    secondary = other.secondary
    onSecondary = other.onSecondary
    secondaryContainer = other.secondaryContainer
    onSecondaryContainer = other.onSecondaryContainer
    tertiary = other.tertiary
    onTertiary = other.onTertiary
    tertiaryContainer = other.tertiaryContainer
    onTertiaryContainer = other.onTertiaryContainer
    background = other.background
    onBackground = other.onBackground
    surface = other.surface
    onSurface = other.onSurface
    surfaceVariant = other.surfaceVariant
    onSurfaceVariant = other.onSurfaceVariant
    surfaceTint = other.surfaceTint
    outline = other.outline
    outlineVariant = other.outlineVariant
    scrim = other.scrim
    error = other.error
    onError = other.onError
    errorContainer = other.errorContainer
    onErrorContainer = other.onErrorContainer
    valid = other.valid
    onValid = other.onValid
    validContainer = other.validContainer
    onValidContainer = other.onValidContainer
    inversePrimary = other.inversePrimary
    inverseSurface = other.inverseSurface
    inverseOnSurface = other.inverseOnSurface
}

/**
 * CompositionLocal used to pass [SparkColors] down the tree.
 *
 * Setting the value here is typically done as part of [SparkTheme], which will
 * automatically handle efficiently updating any changed colors without causing unnecessary
 * recompositions, using [SparkColors.updateColorsFrom].
 * To retrieve the current value of this CompositionLocal, use [SparkTheme.colors].
 */
@Suppress("CompositionLocalAllowlist") // We need it to get access to our color like Material
internal val LocalSparkColors = staticCompositionLocalOf { lightSparkColors() }


/**
 * A [SparkColors] implementation which sets all colors to [debugColor] to help highlighting the usage
 * of [SparkTheme.colors] to more easily detect where they're not used.
 */
public fun debugColors(
    debugColor: Color = Color.Magenta,
    onDebugColor: Color = Color.Green,
): SparkColors = SparkColors(
    primary = debugColor,
    onPrimary = onDebugColor,
    primaryContainer = debugColor,
    onPrimaryContainer = onDebugColor,
    primaryVariant = debugColor,
    onPrimaryVariant = onDebugColor,
    secondary = debugColor,
    onSecondary = onDebugColor,
    secondaryContainer = debugColor,
    onSecondaryContainer = onDebugColor,
    secondaryVariant = debugColor,
    onSecondaryVariant = onDebugColor,
    tertiary = debugColor,
    onTertiary = onDebugColor,
    tertiaryContainer = debugColor,
    onTertiaryContainer = onDebugColor,
    success = debugColor,
    onSuccess = onDebugColor,
    successContainer = debugColor,
    onSuccessContainer = onDebugColor,
    alert = debugColor,
    onAlert = onDebugColor,
    alertContainer = debugColor,
    onAlertContainer = onDebugColor,
    error = debugColor,
    onError = onDebugColor,
    errorContainer = debugColor,
    onErrorContainer = onDebugColor,
    info = debugColor,
    onInfo = onDebugColor,
    infoContainer = debugColor,
    onInfoContainer = onDebugColor,
    neutral = debugColor,
    onNeutral = onDebugColor,
    neutralContainer = debugColor,
    onNeutralContainer = onDebugColor,
    valid = debugColor,
    onValid = onDebugColor,
    validContainer = debugColor,
    onValidContainer = onDebugColor,
    background = Color.Blue,
    onBackground = onDebugColor,
    surface = Color.Blue,
    onSurface = onDebugColor,
    surfaceVariant = Color.Blue,
    onSurfaceVariant = onDebugColor,
    surfaceInverse = Color.Blue,
    onSurfaceInverse = onDebugColor,
    surfaceTint = debugColor,
    outline = debugColor,
    outlineHigh = debugColor,
    outlineVariant = debugColor,
    overlay = debugColor,
    scrim = debugColor,
    inversePrimary = debugColor,
    inverseSurface = Color.Blue,
    inverseOnSurface = onDebugColor,
)

@Preview(
    group = "Tokens",
    name = "Colors",
)
@Composable
private fun ColorPreview(
    @PreviewParameter(SparkPreviewProvider::class) param: Pair<ThemeVariant, UserType>,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        Row {
            ColorItem(SparkTheme.colors.primary, "primary")
            ColorItem(SparkTheme.colors.primaryContainer, "primary Container")
        }
        Row {
            ColorItem(SparkTheme.colors.secondary, "secondary")
            ColorItem(SparkTheme.colors.secondaryContainer, "secondary Container")
        }
        Row {
            ColorItem(SparkTheme.colors.tertiary, "tertiary")
            ColorItem(SparkTheme.colors.tertiaryContainer, "tertiary Container")
        }
        Row {
            ColorItem(SparkTheme.colors.background, "background")
            ColorItem(SparkTheme.colors.surface, "surface")
            ColorItem(SparkTheme.colors.inverseSurface, "inverse Surface")
        }
        Row {
            ColorItem(SparkTheme.colors.surfaceVariant, "surface Variant")
            ColorItem(SparkTheme.colors.outline, "outline")
            ColorItem(SparkTheme.colors.outlineVariant, "outline Variant")
        }
        Row {
            ColorItem(SparkTheme.colors.error, "error")
            ColorItem(SparkTheme.colors.errorContainer, "error Container")
        }
        Row {
            ColorItem(SparkTheme.colors.valid, "valid")
            ColorItem(SparkTheme.colors.validContainer, "valid Container")
        }
    }
}

@Composable
private fun ColorItem(color: Color, colorName: String) {
    CompositionLocalProvider(
        LocalContentColor provides contentColorFor(backgroundColor = color),
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(104.dp)
                .clip(SparkTheme.shapes.extraLarge)
                .border(BorderStroke(2.dp, SparkTheme.colors.onBackground), SparkTheme.shapes.extraLarge)
                .background(color),
            propagateMinConstraints = true,
        ) {
            Box(
                modifier = Modifier.padding(8.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = colorName,
                    style = SparkTheme.typography.body,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}
