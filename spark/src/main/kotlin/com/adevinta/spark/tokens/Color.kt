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
@file:Suppress("DEPRECATION")

package com.adevinta.spark.tokens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tokens.PaletteTokens.Apple100
import com.adevinta.spark.tokens.PaletteTokens.Apple200
import com.adevinta.spark.tokens.PaletteTokens.Apple400
import com.adevinta.spark.tokens.PaletteTokens.Apple500
import com.adevinta.spark.tokens.PaletteTokens.Apple700
import com.adevinta.spark.tokens.PaletteTokens.Apple800
import com.adevinta.spark.tokens.PaletteTokens.Black
import com.adevinta.spark.tokens.PaletteTokens.Chili100
import com.adevinta.spark.tokens.PaletteTokens.Chili200
import com.adevinta.spark.tokens.PaletteTokens.Chili400
import com.adevinta.spark.tokens.PaletteTokens.Chili500
import com.adevinta.spark.tokens.PaletteTokens.Chili700
import com.adevinta.spark.tokens.PaletteTokens.Chili800
import com.adevinta.spark.tokens.PaletteTokens.Sky100
import com.adevinta.spark.tokens.PaletteTokens.Sky200
import com.adevinta.spark.tokens.PaletteTokens.Sky400
import com.adevinta.spark.tokens.PaletteTokens.Sky500
import com.adevinta.spark.tokens.PaletteTokens.Sky700
import com.adevinta.spark.tokens.PaletteTokens.Sky800
import com.adevinta.spark.tokens.PaletteTokens.SugarCotton100
import com.adevinta.spark.tokens.PaletteTokens.SugarCotton200
import com.adevinta.spark.tokens.PaletteTokens.SugarCotton300
import com.adevinta.spark.tokens.PaletteTokens.SugarCotton400
import com.adevinta.spark.tokens.PaletteTokens.SugarCotton500
import com.adevinta.spark.tokens.PaletteTokens.SugarCotton700
import com.adevinta.spark.tokens.PaletteTokens.SugarCotton800
import com.adevinta.spark.tokens.PaletteTokens.Surfer100
import com.adevinta.spark.tokens.PaletteTokens.Surfer200
import com.adevinta.spark.tokens.PaletteTokens.Surfer50
import com.adevinta.spark.tokens.PaletteTokens.Surfer500
import com.adevinta.spark.tokens.PaletteTokens.Surfer700
import com.adevinta.spark.tokens.PaletteTokens.Surfer800
import com.adevinta.spark.tokens.PaletteTokens.Surfer900
import com.adevinta.spark.tokens.PaletteTokens.TheBlue100
import com.adevinta.spark.tokens.PaletteTokens.TheBlue200
import com.adevinta.spark.tokens.PaletteTokens.TheBlue500
import com.adevinta.spark.tokens.PaletteTokens.TheBlue700
import com.adevinta.spark.tokens.PaletteTokens.TheBlue800
import com.adevinta.spark.tokens.PaletteTokens.TheBlueV
import com.adevinta.spark.tokens.PaletteTokens.White
import com.adevinta.spark.tokens.PaletteTokens.Wiggings100
import com.adevinta.spark.tokens.PaletteTokens.Wiggings200
import com.adevinta.spark.tokens.PaletteTokens.Wiggings400
import com.adevinta.spark.tokens.PaletteTokens.Wiggings500
import com.adevinta.spark.tokens.PaletteTokens.Wiggings700
import com.adevinta.spark.tokens.PaletteTokens.Wiggings800
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

public fun lightSparkColors(
    primary: Color = TheBlue500,
    onPrimary: Color = White,
    primaryContainer: Color = TheBlue100,
    onPrimaryContainer: Color = TheBlue700,
    primaryVariant: Color = TheBlue700,
    onPrimaryVariant: Color = White,
    secondary: Color = SugarCotton500,
    onSecondary: Color = White,
    secondaryContainer: Color = SugarCotton100,
    onSecondaryContainer: Color = SugarCotton700,
    secondaryVariant: Color = SugarCotton700,
    onSecondaryVariant: Color = White,
    tertiary: Color = Color.Magenta,
    onTertiary: Color = Color.Blue,
    tertiaryContainer: Color = Color.Magenta,
    onTertiaryContainer: Color = Color.Blue,
    success: Color = Apple500,
    onSuccess: Color = White,
    successContainer: Color = Apple100,
    onSuccessContainer: Color = Apple700,
    alert: Color = Wiggings500,
    onAlert: Color = Black,
    alertContainer: Color = Wiggings100,
    onAlertContainer: Color = Wiggings700,
    error: Color = Chili500,
    onError: Color = White,
    errorContainer: Color = Chili100,
    onErrorContainer: Color = Chili700,
    info: Color = Sky500,
    onInfo: Color = White,
    infoContainer: Color = Sky100,
    onInfoContainer: Color = Sky700,
    neutral: Color = Surfer500,
    onNeutral: Color = White,
    neutralContainer: Color = Surfer100,
    onNeutralContainer: Color = Surfer700,
    background: Color = White,
    onBackground: Color = Black,
    backgroundVariant: Color = Surfer50,
    onBackgroundVariant: Color = Black,
    surface: Color = White,
    onSurface: Color = Color.Black,
    surfaceInverse: Color = Surfer900,
    onSurfaceInverse: Color = White,
    surfaceTint: Color = primary,
    inversePrimary: Color = Color.Magenta,
    outline: Color = Surfer200,
    outlineHigh: Color = Color.Black,
    scrim: Color = Black,
    dimContent1: Float = .72f,
    dimContent2: Float = .56f,
    dimContent3: Float = .40f,
    dimContent4: Float = .16f,
    dimContent5: Float = .08f,
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
    valid = success,
    onValid = onSuccess,
    validContainer = successContainer,
    onValidContainer = onSuccessContainer,
    background = background,
    onBackground = onBackground,
    backgroundVariant = backgroundVariant,
    onBackgroundVariant = onBackgroundVariant,
    surface = surface,
    onSurface = onSurface,
    surfaceInverse = surfaceInverse,
    onSurfaceInverse = onSurfaceInverse,
    surfaceVariant = backgroundVariant,
    onSurfaceVariant = onBackgroundVariant,
    surfaceTint = surfaceTint,
    outline = outline,
    outlineHigh = outlineHigh,
    outlineVariant = outlineHigh,
    scrim = scrim,
    inversePrimary = inversePrimary,
    inverseSurface = surfaceInverse,
    inverseOnSurface = onSurfaceInverse,
    dimContent1 = dimContent1,
    dimContent2 = dimContent2,
    dimContent3 = dimContent3,
    dimContent4 = dimContent4,
    dimContent5 = dimContent5,
)

public fun darkSparkColors(
    primary: Color = TheBlueV,
    onPrimary: Color = Black,
    primaryContainer: Color = TheBlue800,
    onPrimaryContainer: Color = TheBlue200,
    primaryVariant: Color = TheBlue200,
    onPrimaryVariant: Color = Black,
    secondary: Color = SugarCotton400,
    onSecondary: Color = Black,
    secondaryContainer: Color = SugarCotton800,
    onSecondaryContainer: Color = SugarCotton200,
    secondaryVariant: Color = SugarCotton300,
    onSecondaryVariant: Color = Black,
    success: Color = Apple400,
    onSuccess: Color = Black,
    successContainer: Color = Apple800,
    onSuccessContainer: Color = Apple200,
    alert: Color = Wiggings400,
    onAlert: Color = Black,
    alertContainer: Color = Wiggings800,
    onAlertContainer: Color = Wiggings200,
    error: Color = Chili400,
    onError: Color = Black,
    errorContainer: Color = Chili800,
    onErrorContainer: Color = Chili200,
    info: Color = Sky400,
    onInfo: Color = Black,
    infoContainer: Color = Sky800,
    onInfoContainer: Color = Sky200,
    neutral: Color = Surfer500,
    onNeutral: Color = Black,
    neutralContainer: Color = Surfer800,
    onNeutralContainer: Color = Surfer200,
    background: Color = Black,
    onBackground: Color = White,
    backgroundVariant: Color = Surfer900,
    onBackgroundVariant: Color = Color.White,
    surface: Color = Black,
    onSurface: Color = White,
    surfaceInverse: Color = Surfer50,
    onSurfaceInverse: Color = Black,
    surfaceTint: Color = primary,
    outline: Color = Surfer700,
    outlineHigh: Color = White,
    inversePrimary: Color = Color.Magenta,
    scrim: Color = Black,
    dimContent1: Float = .72f,
    dimContent2: Float = .56f,
    dimContent3: Float = .40f,
    dimContent4: Float = .16f,
    dimContent5: Float = .08f,
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
    tertiary = Color.Magenta,
    onTertiary = Color.Blue,
    tertiaryContainer = Color.Magenta,
    onTertiaryContainer = Color.Blue,
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
    valid = success,
    onValid = onSuccess,
    validContainer = successContainer,
    onValidContainer = onSuccessContainer,
    background = background,
    onBackground = onBackground,
    backgroundVariant = backgroundVariant,
    onBackgroundVariant = onBackgroundVariant,
    surface = surface,
    onSurface = onSurface,
    surfaceInverse = surfaceInverse,
    onSurfaceInverse = onSurfaceInverse,
    surfaceVariant = backgroundVariant,
    onSurfaceVariant = onBackgroundVariant,
    surfaceTint = surfaceTint,
    outline = outline,
    outlineHigh = outlineHigh,
    outlineVariant = outlineHigh,
    scrim = scrim,
    inversePrimary = inversePrimary,
    inverseSurface = surfaceInverse,
    inverseOnSurface = onSurfaceInverse,
    dimContent1 = dimContent1,
    dimContent2 = dimContent2,
    dimContent3 = dimContent3,
    dimContent4 = dimContent4,
    dimContent5 = dimContent5,
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
 * @property backgroundVariant The background color that appears behind scrollable content.
 * @property onBackgroundVariant Color used for text and icons displayed on top of the background color.
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
 * contrast is not required.
 * @property outlineVariant Utility color used for boundaries for decorative elements when strong
 * contrast is not required.
 * @property scrim Color of a scrim that obscures content. On Android platforms, the scrim color
 * and opacity is automatically handled by the system UI.
 * @property dim1 An alpha used to apply a medium emphasis to text.
 * @property dim2 An alpha used to apply a medium emphasis to icons.
 * @property dim3 An alpha used to apply a disabled emphasis to all components.
 * @property dim4 An alpha used to show a low element.
 * @property dim5 An alpha used to apply a pressed/ripple visual but should not be used on Android.
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
    backgroundVariant: Color,
    onBackgroundVariant: Color,
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
    outlineVariant: Color,
    scrim: Color,
    dimContent1: Float,
    dimContent2: Float,
    dimContent3: Float,
    dimContent4: Float,
    dimContent5: Float,
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

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("neutral"),
    )
    public var tertiary: Color by mutableStateOf(tertiary, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("onNeutral"),
    )
    public var onTertiary: Color by mutableStateOf(onTertiary, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("backgroundVariant"),

    )
    public var tertiaryContainer: Color by mutableStateOf(tertiaryContainer, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("onBackgroundVariant"),
    )
    public var onTertiaryContainer: Color by mutableStateOf(onTertiaryContainer, structuralEqualityPolicy())
        internal set

    public var background: Color by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    public var onBackground: Color by mutableStateOf(onBackground, structuralEqualityPolicy())
        internal set
    public var backgroundVariant: Color by mutableStateOf(backgroundVariant, structuralEqualityPolicy())
        internal set
    public var onBackgroundVariant: Color by mutableStateOf(onBackgroundVariant, structuralEqualityPolicy())
        internal set
    public var surface: Color by mutableStateOf(surface, structuralEqualityPolicy())
        internal set
    public var onSurface: Color by mutableStateOf(onSurface, structuralEqualityPolicy())
        internal set
    public var surfaceInverse: Color by mutableStateOf(surfaceInverse, structuralEqualityPolicy())
        internal set
    public var onSurfaceInverse: Color by mutableStateOf(onSurfaceInverse, structuralEqualityPolicy())
        internal set

    @Deprecated(
        message = "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("backgroundVariant"),
    )
    public var surfaceVariant: Color by mutableStateOf(surfaceVariant, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("onBackgroundVariant"),
    )
    public var onSurfaceVariant: Color by mutableStateOf(onSurfaceVariant, structuralEqualityPolicy())
        internal set

    internal var surfaceTint: Color by mutableStateOf(surfaceTint, structuralEqualityPolicy())
    public var outline: Color by mutableStateOf(outline, structuralEqualityPolicy())
        internal set
    public var outlineHigh: Color by mutableStateOf(outlineHigh, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("outlineHigh"),
        level = DeprecationLevel.WARNING,
    )
    public var outlineVariant: Color by mutableStateOf(outlineVariant, structuralEqualityPolicy())
        internal set

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

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("success"),
        level = DeprecationLevel.WARNING,
    )
    public var valid: Color by mutableStateOf(valid, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("onSuccess"),
        level = DeprecationLevel.WARNING,
    )
    public var onValid: Color by mutableStateOf(onValid, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("successContainer"),
        level = DeprecationLevel.WARNING,
    )
    public var validContainer: Color by mutableStateOf(validContainer, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("onSuccessContainer"),
        level = DeprecationLevel.WARNING,
    )
    public var onValidContainer: Color by mutableStateOf(onValidContainer, structuralEqualityPolicy())
        internal set

    @Deprecated("This property will be removed as it is not part of Spark Token")
    public var inversePrimary: Color by mutableStateOf(inversePrimary, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("surfaceInverse"),
        level = DeprecationLevel.WARNING,
    )
    public var inverseSurface: Color by mutableStateOf(inverseSurface, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("onSurfaceInverse"),
        level = DeprecationLevel.WARNING,
    )
    public var inverseOnSurface: Color by mutableStateOf(inverseOnSurface, structuralEqualityPolicy())
        internal set

    public var dim1: Float by mutableStateOf(dimContent1, structuralEqualityPolicy())
        internal set
    public var dim2: Float by mutableStateOf(dimContent2, structuralEqualityPolicy())
        internal set
    public var dim3: Float by mutableStateOf(dimContent3, structuralEqualityPolicy())
        internal set
    public var dim4: Float by mutableStateOf(dimContent4, structuralEqualityPolicy())
        internal set
    public var dim5: Float by mutableStateOf(dimContent5, structuralEqualityPolicy())
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
        backgroundVariant: Color = this.backgroundVariant,
        onBackgroundVariant: Color = this.onBackgroundVariant,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        surfaceInverse: Color = this.surfaceInverse,
        onSurfaceInverse: Color = this.onSurfaceInverse,
        surfaceVariant: Color = this.surfaceVariant,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        surfaceTint: Color = this.surfaceTint,
        outline: Color = this.outline,
        outlineHigh: Color = this.outlineHigh,
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
        dimContent1: Float = this.dim1,
        dimContent2: Float = this.dim2,
        dimContent3: Float = this.dim3,
        dimContent4: Float = this.dim4,
        dimContent5: Float = this.dim5,
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
        backgroundVariant = backgroundVariant,
        onBackgroundVariant = onBackgroundVariant,
        surface = surface,
        onSurface = onSurface,
        surfaceInverse = surfaceInverse,
        onSurfaceInverse = onSurfaceInverse,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        outline = outline,
        outlineHigh = outlineHigh,
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
        dimContent1 = dimContent1,
        dimContent2 = dimContent2,
        dimContent3 = dimContent3,
        dimContent4 = dimContent4,
        dimContent5 = dimContent5,
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
        append("backgroundVariant=$backgroundVariant, ")
        append("onBackgroundVariant=$onBackgroundVariant, ")
        append("surface=$surface, ")
        append("onSurface=$onSurface, ")
        append("surfaceVariant=$surfaceVariant, ")
        append("onSurfaceVariant=$onSurfaceVariant, ")
        append("surfaceTint=$surfaceTint, ")
        append("outline=$outline, ")
        append("outlineHigh=$outlineHigh, ")
        append("scrim=$scrim, ")
        append("valid=$valid, ")
        append("onValid=$onValid, ")
        append("validContainer=$validContainer, ")
        append("onValidContainer=$onValidContainer, ")
        append("alert=$alert, ")
        append("onAlert=$onAlert, ")
        append("alertContainer=$alertContainer, ")
        append("onAlertContainer=$onAlertContainer, ")
        append("error=$error, ")
        append("onError=$onError, ")
        append("errorContainer=$errorContainer, ")
        append("onErrorContainer=$onErrorContainer, ")
        append("info=$info, ")
        append("onInfo=$onInfo, ")
        append("infoContainer=$infoContainer, ")
        append("onInfoContainer=$onInfoContainer, ")
        append("neutral=$neutral, ")
        append("onNeutral=$onNeutral, ")
        append("neutralContainer=$neutralContainer, ")
        append("onNeutralContainer=$onNeutralContainer, ")
        append("inversePrimary=$inversePrimary, ")
        append("inverseSurface=$inverseSurface, ")
        append("dim1=$dim1, ")
        append("dim2=$dim2, ")
        append("dim3=$dim3, ")
        append("dim4=$dim4, ")
        append("dim5=$dim5, ")
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
    surfaceVariant = backgroundVariant,
    onSurfaceVariant = onBackgroundVariant,
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
    primaryVariant -> onPrimaryVariant
    secondary -> onSecondary
    secondaryContainer -> onSecondaryContainer
    secondaryVariant -> onSecondaryVariant
    tertiary -> onTertiary
    tertiaryContainer -> onTertiaryContainer
    background -> onBackground
    backgroundVariant -> onBackgroundVariant
    surface -> onSurface
    surfaceVariant -> onSurfaceVariant
    surfaceInverse -> onSurfaceInverse
    inverseSurface -> inverseOnSurface
    valid -> onValid
    validContainer -> onValidContainer
    alert -> onAlert
    alertContainer -> onAlertContainer
    error -> onError
    errorContainer -> onErrorContainer
    info -> onInfo
    infoContainer -> onInfoContainer
    neutral -> onNeutral
    neutralContainer -> onNeutralContainer
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
    backgroundVariant = other.backgroundVariant
    onBackgroundVariant = other.onBackgroundVariant
    surface = other.surface
    onSurface = other.onSurface
    surfaceVariant = other.surfaceVariant
    onSurfaceVariant = other.onSurfaceVariant
    surfaceInverse = other.surfaceInverse
    onSurfaceInverse = other.onSurfaceInverse
    surfaceTint = other.surfaceTint
    outline = other.outline
    outlineHigh = other.outlineHigh
    outlineVariant = other.outlineVariant
    scrim = other.scrim
    valid = other.valid
    onValid = other.onValid
    validContainer = other.validContainer
    onValidContainer = other.onValidContainer
    alert = other.alert
    onAlert = other.onAlert
    alertContainer = other.alertContainer
    onAlertContainer = other.onAlertContainer
    error = other.error
    onError = other.onError
    errorContainer = other.errorContainer
    onErrorContainer = other.onErrorContainer
    info = other.info
    onInfo = other.onInfo
    infoContainer = other.infoContainer
    onInfoContainer = other.onInfoContainer
    neutral = other.neutral
    onNeutral = other.onNeutral
    neutralContainer = other.neutralContainer
    onNeutralContainer = other.onNeutralContainer
    inversePrimary = other.inversePrimary
    inverseSurface = other.inverseSurface
    inverseOnSurface = other.inverseOnSurface
    dim1 = other.dim1
    dim2 = other.dim2
    dim3 = other.dim3
    dim4 = other.dim4
    dim5 = other.dim5
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
    backgroundVariant = Color.Blue,
    onBackgroundVariant = onDebugColor,
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
    scrim = debugColor,
    inversePrimary = debugColor,
    inverseSurface = Color.Blue,
    inverseOnSurface = onDebugColor,
    dimContent1 = .72f,
    dimContent2 = .56f,
    dimContent3 = .40f,
    dimContent4 = .16f,
    dimContent5 = .08f,
)

@Preview(
    group = "Tokens",
    name = "Colors",
    device = Devices.TABLET,
    showSystemUi = true,
)
@Composable
private fun ColorPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        Row {
            Column {
                Row {
                    ColorItem(SparkTheme.colors.primary, "primary")
                    ColorItem(SparkTheme.colors.primaryContainer, "primary Container")
                    ColorItem(SparkTheme.colors.primaryVariant, "primary Variant")
                }
                Row {
                    ColorItem(SparkTheme.colors.secondary, "secondary")
                    ColorItem(SparkTheme.colors.secondaryContainer, "secondary Container")
                    ColorItem(SparkTheme.colors.secondaryVariant, "secondary Variant")
                }
                Row {
                    ColorItem(SparkTheme.colors.background, "background")
                    ColorItem(SparkTheme.colors.backgroundVariant, "backgroundVariant")
                }
                Row {
                    ColorItem(SparkTheme.colors.surface, "surface")
                    ColorItem(SparkTheme.colors.surfaceInverse, "surface inverse")
                }
                Row {
                    ColorItem(SparkTheme.colors.outline, "outline")
                    ColorItem(SparkTheme.colors.outlineHigh, "outline High")
                }
            }
            Column {
                Row {
                    ColorItem(SparkTheme.colors.success, "success")
                    ColorItem(SparkTheme.colors.successContainer, "success Container")
                }
                Row {
                    ColorItem(SparkTheme.colors.alert, "alert")
                    ColorItem(SparkTheme.colors.alertContainer, "alert Container")
                }
                Row {
                    ColorItem(SparkTheme.colors.error, "error")
                    ColorItem(SparkTheme.colors.errorContainer, "error Container")
                }
                Row {
                    ColorItem(SparkTheme.colors.info, "info")
                    ColorItem(SparkTheme.colors.infoContainer, "info Container")
                }
                Row {
                    ColorItem(SparkTheme.colors.neutral, "neutral")
                    ColorItem(SparkTheme.colors.neutralContainer, "neutral Container")
                }
            }
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

public val Color.dim1: Color
    @Composable get() = this.copy(alpha = SparkTheme.colors.dim1)
public val Color.dim2: Color
    @Composable get() = this.copy(alpha = SparkTheme.colors.dim2)
public val Color.dim3: Color
    @Composable get() = this.copy(alpha = SparkTheme.colors.dim3)
public val Color.dim4: Color
    @Composable get() = this.copy(alpha = SparkTheme.colors.dim4)
public val Color.dim5: Color
    @Composable get() = this.copy(alpha = SparkTheme.colors.dim5)
