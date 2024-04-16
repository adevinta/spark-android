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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.buttons.ButtonFilled
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.tokens.PaletteTokens.Apple100
import com.adevinta.spark.tokens.PaletteTokens.Apple400
import com.adevinta.spark.tokens.PaletteTokens.Apple500
import com.adevinta.spark.tokens.PaletteTokens.Apple700
import com.adevinta.spark.tokens.PaletteTokens.Apple800
import com.adevinta.spark.tokens.PaletteTokens.Black
import com.adevinta.spark.tokens.PaletteTokens.BlackAdevinta100
import com.adevinta.spark.tokens.PaletteTokens.BlackAdevinta300
import com.adevinta.spark.tokens.PaletteTokens.BlackAdevinta50
import com.adevinta.spark.tokens.PaletteTokens.BlackAdevinta700
import com.adevinta.spark.tokens.PaletteTokens.BlackAdevinta800
import com.adevinta.spark.tokens.PaletteTokens.BlackAdevinta900
import com.adevinta.spark.tokens.PaletteTokens.BlueRibbon100
import com.adevinta.spark.tokens.PaletteTokens.BlueRibbon200
import com.adevinta.spark.tokens.PaletteTokens.BlueRibbon400
import com.adevinta.spark.tokens.PaletteTokens.BlueRibbon500
import com.adevinta.spark.tokens.PaletteTokens.BlueRibbon700
import com.adevinta.spark.tokens.PaletteTokens.BlueRibbon800
import com.adevinta.spark.tokens.PaletteTokens.Chili100
import com.adevinta.spark.tokens.PaletteTokens.Chili400
import com.adevinta.spark.tokens.PaletteTokens.Chili500
import com.adevinta.spark.tokens.PaletteTokens.Chili700
import com.adevinta.spark.tokens.PaletteTokens.Chili800
import com.adevinta.spark.tokens.PaletteTokens.PaleAdevinta100
import com.adevinta.spark.tokens.PaletteTokens.PaleAdevinta50
import com.adevinta.spark.tokens.PaletteTokens.PaleAdevinta700
import com.adevinta.spark.tokens.PaletteTokens.PaleAdevinta800
import com.adevinta.spark.tokens.PaletteTokens.PaleAdevinta900
import com.adevinta.spark.tokens.PaletteTokens.Sky100
import com.adevinta.spark.tokens.PaletteTokens.Sky400
import com.adevinta.spark.tokens.PaletteTokens.Sky500
import com.adevinta.spark.tokens.PaletteTokens.Sky700
import com.adevinta.spark.tokens.PaletteTokens.Sky800
import com.adevinta.spark.tokens.PaletteTokens.Violet100
import com.adevinta.spark.tokens.PaletteTokens.Violet200
import com.adevinta.spark.tokens.PaletteTokens.Violet300
import com.adevinta.spark.tokens.PaletteTokens.Violet500
import com.adevinta.spark.tokens.PaletteTokens.Violet700
import com.adevinta.spark.tokens.PaletteTokens.Violet800
import com.adevinta.spark.tokens.PaletteTokens.White
import com.adevinta.spark.tokens.PaletteTokens.Wiggings100
import com.adevinta.spark.tokens.PaletteTokens.Wiggings400
import com.adevinta.spark.tokens.PaletteTokens.Wiggings500
import com.adevinta.spark.tokens.PaletteTokens.Wiggings800
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import kotlin.math.ln
import kotlin.reflect.KProperty0

public fun lightSparkColors(
    accent: Color = Violet300,
    onAccent: Color = BlackAdevinta900,
    accentContainer: Color = Violet100,
    onAccentContainer: Color = Violet800,
    accentVariant: Color = Violet700,
    onAccentVariant: Color = White,
    basic: Color = PaleAdevinta800,
    onBasic: Color = White,
    basicContainer: Color = PaleAdevinta100,
    onBasicContainer: Color = PaleAdevinta900,
    main: Color = BlueRibbon500,
    onMain: Color = White,
    mainContainer: Color = BlueRibbon100,
    onMainContainer: Color = BlueRibbon700,
    mainVariant: Color = BlueRibbon700,
    onMainVariant: Color = White,
    support: Color = PaleAdevinta800,
    onSupport: Color = White,
    supportContainer: Color = PaleAdevinta100,
    onSupportContainer: Color = PaleAdevinta900,
    supportVariant: Color = PaleAdevinta700,
    onSupportVariant: Color = White,
    tertiary: Color = Color.Magenta,
    onTertiary: Color = Color.Blue,
    tertiaryContainer: Color = Color.Magenta,
    onTertiaryContainer: Color = Color.Blue,
    success: Color = Apple500,
    onSuccess: Color = White,
    successContainer: Color = Apple100,
    onSuccessContainer: Color = Apple700,
    alert: Color = Wiggings500,
    onAlert: Color = BlackAdevinta900,
    alertContainer: Color = Wiggings100,
    onAlertContainer: Color = Wiggings800,
    error: Color = Chili500,
    onError: Color = White,
    errorContainer: Color = Chili100,
    onErrorContainer: Color = Chili700,
    info: Color = Sky500,
    onInfo: Color = White,
    infoContainer: Color = Sky100,
    onInfoContainer: Color = Sky700,
    neutral: Color = BlackAdevinta800,
    onNeutral: Color = White,
    neutralContainer: Color = BlackAdevinta100,
    onNeutralContainer: Color = BlackAdevinta800,
    background: Color = White,
    onBackground: Color = BlackAdevinta900,
    backgroundVariant: Color = BlackAdevinta50,
    onBackgroundVariant: Color = BlackAdevinta900,
    surface: Color = White,
    onSurface: Color = BlackAdevinta900,
    surfaceInverse: Color = BlackAdevinta800,
    onSurfaceInverse: Color = White,
    surfaceTint: Color = main,
    inversePrimary: Color = Color.Magenta,
    outline: Color = BlackAdevinta100,
    outlineHigh: Color = BlackAdevinta900,
    scrim: Color = Black,
    dimContent1: Float = .72f,
    dimContent2: Float = .56f,
    dimContent3: Float = .40f,
    dimContent4: Float = .16f,
    dimContent5: Float = .08f,
): SparkColors = SparkColors(
    accent = accent,
    onAccent = onAccent,
    accentContainer = accentContainer,
    onAccentContainer = onAccentContainer,
    accentVariant = accentVariant,
    onAccentVariant = onAccentVariant,
    basic = basic,
    onBasic = onBasic,
    basicContainer = basicContainer,
    onBasicContainer = onBasicContainer,
    main = main,
    onMain = onMain,
    mainContainer = mainContainer,
    onMainContainer = onMainContainer,
    mainVariant = mainVariant,
    onMainVariant = onMainVariant,
    support = support,
    onSupport = onSupport,
    supportContainer = supportContainer,
    onSupportContainer = onSupportContainer,
    supportVariant = supportVariant,
    onSupportVariant = onSupportVariant,
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
    accent: Color = Violet300,
    onAccent: Color = BlackAdevinta900,
    accentContainer: Color = Violet500,
    onAccentContainer: Color = White,
    accentVariant: Color = Violet200,
    onAccentVariant: Color = BlackAdevinta900,
    basic: Color = PaleAdevinta100,
    onBasic: Color = BlackAdevinta900,
    basicContainer: Color = PaleAdevinta700,
    onBasicContainer: Color = White,
    main: Color = BlueRibbon400,
    onMain: Color = White,
    mainContainer: Color = BlueRibbon800,
    onMainContainer: Color = White,
    mainVariant: Color = BlueRibbon200,
    onMainVariant: Color = BlackAdevinta900,
    support: Color = PaleAdevinta100,
    onSupport: Color = BlackAdevinta900,
    supportContainer: Color = PaleAdevinta700,
    onSupportContainer: Color = White,
    supportVariant: Color = PaleAdevinta50,
    onSupportVariant: Color = BlackAdevinta900,
    success: Color = Apple400,
    onSuccess: Color = BlackAdevinta900,
    successContainer: Color = Apple800,
    onSuccessContainer: Color = White,
    alert: Color = Wiggings400,
    onAlert: Color = BlackAdevinta900,
    alertContainer: Color = Wiggings800,
    onAlertContainer: Color = White,
    error: Color = Chili400,
    onError: Color = BlackAdevinta900,
    errorContainer: Color = Chili800,
    onErrorContainer: Color = White,
    info: Color = Sky400,
    onInfo: Color = BlackAdevinta900,
    infoContainer: Color = Sky800,
    onInfoContainer: Color = White,
    neutral: Color = BlackAdevinta300,
    onNeutral: Color = BlackAdevinta900,
    neutralContainer: Color = BlackAdevinta800,
    onNeutralContainer: Color = White,
    background: Color = BlackAdevinta900,
    onBackground: Color = White,
    backgroundVariant: Color = Black,
    onBackgroundVariant: Color = BlackAdevinta50,
    surface: Color = BlackAdevinta900,
    onSurface: Color = White,
    surfaceInverse: Color = BlackAdevinta50,
    onSurfaceInverse: Color = BlackAdevinta800,
    surfaceTint: Color = main,
    outline: Color = BlackAdevinta700,
    outlineHigh: Color = White,
    inverseMain: Color = Color.Magenta,
    scrim: Color = Black,
    dimContent1: Float = .72f,
    dimContent2: Float = .56f,
    dimContent3: Float = .40f,
    dimContent4: Float = .16f,
    dimContent5: Float = .08f,
): SparkColors = SparkColors(
    accent = accent,
    onAccent = onAccent,
    accentContainer = accentContainer,
    onAccentContainer = onAccentContainer,
    accentVariant = accentVariant,
    onAccentVariant = onAccentVariant,
    basic = basic,
    onBasic = onBasic,
    basicContainer = basicContainer,
    onBasicContainer = onBasicContainer,
    main = main,
    onMain = onMain,
    mainContainer = mainContainer,
    onMainContainer = onMainContainer,
    mainVariant = mainVariant,
    onMainVariant = onMainVariant,
    support = support,
    onSupport = onSupport,
    supportContainer = supportContainer,
    onSupportContainer = onSupportContainer,
    supportVariant = supportVariant,
    onSupportVariant = onSupportVariant,
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
    inversePrimary = inverseMain,
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
 * [Spark colors](https://spark.adevinta.com/1186e1705/p/0879a9-colors/b/27d7a3).
 *
 * @property accent
 * @property onAccent
 * @property accentContainer
 * @property onAccentContainer
 * @property accentVariant
 * @property onAccentVariant
 * @property basic
 * @property onBasic
 * @property basicContainer
 * @property onBasicContainer
 * @property main The main color is the color displayed most frequently across your app’s
 * screens and components.
 * @property onMain Color used for text and icons displayed on top of the main color.
 * @property mainContainer The preferred tonal color of containers.
 * @property onMainContainer The color (and state variants) that should be used for content on
 * top of [mainContainer].
 * @property mainVariant Darker variation of [main] color.
 * @property onMainVariant Color used for text and icons displayed on top of the [mainVariant] color.
 * @property inversePrimary Color to be used as a "main" color in places where the inverse color
 * scheme is needed.
 * @property support The support color provides more ways to accent and distinguish your
 * product. Support colors are best for:
 * - Floating action buttons
 * - Selection controls, like checkboxes and radio buttons
 * - Highlighting selected text
 * - Links and headlines
 * @property onSupport Color used for text and icons displayed on top of the support color.
 * @property supportContainer A tonal color to be used in containers.
 * @property onSupportContainer The color (and state variants) that should be used for content on
 * top of [supportContainer].
 * @property supportVariant Darker variation of [support] color.
 * @property onSupportVariant Color used for text and icons displayed on top of the [supportVariant] color.
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
    accent: Color,
    onAccent: Color,
    accentContainer: Color,
    onAccentContainer: Color,
    accentVariant: Color,
    onAccentVariant: Color,
    basic: Color,
    onBasic: Color,
    basicContainer: Color,
    onBasicContainer: Color,
    main: Color,
    onMain: Color,
    mainContainer: Color,
    onMainContainer: Color,
    mainVariant: Color,
    onMainVariant: Color,
    support: Color,
    onSupport: Color,
    supportContainer: Color,
    onSupportContainer: Color,
    supportVariant: Color,
    onSupportVariant: Color,
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
    @Order(2)
    public var accent: Color by mutableStateOf(accent, structuralEqualityPolicy())
        internal set
    public var onAccent: Color by mutableStateOf(onAccent, structuralEqualityPolicy())
        internal set
    public var accentContainer: Color by mutableStateOf(accentContainer, structuralEqualityPolicy())
        internal set
    public var onAccentContainer: Color by mutableStateOf(onAccentContainer, structuralEqualityPolicy())
        internal set
    public var accentVariant: Color by mutableStateOf(accentVariant, structuralEqualityPolicy())
        internal set
    public var onAccentVariant: Color by mutableStateOf(onAccentVariant, structuralEqualityPolicy())
        internal set

    @Order(3)
    public var basic: Color by mutableStateOf(basic, structuralEqualityPolicy())
        internal set
    public var onBasic: Color by mutableStateOf(onBasic, structuralEqualityPolicy())
        internal set
    public var basicContainer: Color by mutableStateOf(basicContainer, structuralEqualityPolicy())
        internal set
    public var onBasicContainer: Color by mutableStateOf(onBasicContainer, structuralEqualityPolicy())
        internal set

    @Order(0)
    public var main: Color by mutableStateOf(main, structuralEqualityPolicy())
        internal set
    public var onMain: Color by mutableStateOf(onMain, structuralEqualityPolicy())
        internal set
    public var mainContainer: Color by mutableStateOf(mainContainer, structuralEqualityPolicy())
        internal set
    public var onMainContainer: Color by mutableStateOf(onMainContainer, structuralEqualityPolicy())
        internal set
    public var mainVariant: Color by mutableStateOf(mainVariant, structuralEqualityPolicy())
        internal set
    public var onMainVariant: Color by mutableStateOf(onMainVariant, structuralEqualityPolicy())
        internal set

    @Order(1)
    public var support: Color by mutableStateOf(support, structuralEqualityPolicy())
        internal set
    public var onSupport: Color by mutableStateOf(onSupport, structuralEqualityPolicy())
        internal set
    public var supportContainer: Color by mutableStateOf(supportContainer, structuralEqualityPolicy())
        internal set
    public var onSupportContainer: Color by mutableStateOf(onSupportContainer, structuralEqualityPolicy())
        internal set
    public var supportVariant: Color by mutableStateOf(supportVariant, structuralEqualityPolicy())
        internal set
    public var onSupportVariant: Color by mutableStateOf(onSupportVariant, structuralEqualityPolicy())
        internal set

    @Order(4)
    public var background: Color by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    public var onBackground: Color by mutableStateOf(onBackground, structuralEqualityPolicy())
        internal set
    public var backgroundVariant: Color by mutableStateOf(backgroundVariant, structuralEqualityPolicy())
        internal set
    public var onBackgroundVariant: Color by mutableStateOf(onBackgroundVariant, structuralEqualityPolicy())
        internal set

    @Order(5)
    public var surface: Color by mutableStateOf(surface, structuralEqualityPolicy())
        internal set
    public var onSurface: Color by mutableStateOf(onSurface, structuralEqualityPolicy())
        internal set
    public var surfaceInverse: Color by mutableStateOf(surfaceInverse, structuralEqualityPolicy())
        internal set
    public var onSurfaceInverse: Color by mutableStateOf(onSurfaceInverse, structuralEqualityPolicy())
        internal set
    internal var surfaceTint: Color by mutableStateOf(surfaceTint, structuralEqualityPolicy())

    @Order(6)
    public var outline: Color by mutableStateOf(outline, structuralEqualityPolicy())
        internal set
    public var outlineHigh: Color by mutableStateOf(outlineHigh, structuralEqualityPolicy())
        internal set
    public var scrim: Color by mutableStateOf(scrim, structuralEqualityPolicy())
        internal set

    @Order(7)
    public var success: Color by mutableStateOf(success, structuralEqualityPolicy())
        internal set
    public var onSuccess: Color by mutableStateOf(onSuccess, structuralEqualityPolicy())
        internal set
    public var successContainer: Color by mutableStateOf(successContainer, structuralEqualityPolicy())
        internal set
    public var onSuccessContainer: Color by mutableStateOf(onSuccessContainer, structuralEqualityPolicy())
        internal set

    @Order(8)
    public var alert: Color by mutableStateOf(alert, structuralEqualityPolicy())
        internal set
    public var onAlert: Color by mutableStateOf(onAlert, structuralEqualityPolicy())
        internal set
    public var alertContainer: Color by mutableStateOf(alertContainer, structuralEqualityPolicy())
        internal set
    public var onAlertContainer: Color by mutableStateOf(onAlertContainer, structuralEqualityPolicy())
        internal set

    @Order(9)
    public var error: Color by mutableStateOf(error, structuralEqualityPolicy())
        internal set
    public var onError: Color by mutableStateOf(onError, structuralEqualityPolicy())
        internal set
    public var errorContainer: Color by mutableStateOf(errorContainer, structuralEqualityPolicy())
        internal set
    public var onErrorContainer: Color by mutableStateOf(onErrorContainer, structuralEqualityPolicy())
        internal set

    @Order(10)
    public var info: Color by mutableStateOf(info, structuralEqualityPolicy())
        internal set
    public var onInfo: Color by mutableStateOf(onInfo, structuralEqualityPolicy())
        internal set
    public var infoContainer: Color by mutableStateOf(infoContainer, structuralEqualityPolicy())
        internal set
    public var onInfoContainer: Color by mutableStateOf(onInfoContainer, structuralEqualityPolicy())
        internal set

    @Order(11)
    public var neutral: Color by mutableStateOf(neutral, structuralEqualityPolicy())
        internal set
    public var onNeutral: Color by mutableStateOf(onNeutral, structuralEqualityPolicy())
        internal set
    public var neutralContainer: Color by mutableStateOf(neutralContainer, structuralEqualityPolicy())
        internal set
    public var onNeutralContainer: Color by mutableStateOf(onNeutralContainer, structuralEqualityPolicy())
        internal set

    public var dim1: Float by mutableFloatStateOf(dimContent1)
        internal set
    public var dim2: Float by mutableFloatStateOf(dimContent2)
        internal set
    public var dim3: Float by mutableFloatStateOf(dimContent3)
        internal set
    public var dim4: Float by mutableFloatStateOf(dimContent4)
        internal set
    public var dim5: Float by mutableFloatStateOf(dimContent5)
        internal set

    // region @Deprecated
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("main"),
    )
    public var primary: Color by mutableStateOf(main, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("onMain"),
    )
    public var onPrimary: Color by mutableStateOf(onMain, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("mainContainer"),
    )
    public var primaryContainer: Color by mutableStateOf(mainContainer, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("onMainContainer"),
    )
    public var onPrimaryContainer: Color by mutableStateOf(onMainContainer, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("mainVariant"),
    )
    public var primaryVariant: Color by mutableStateOf(mainVariant, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("onMainVariant"),
    )
    public var onPrimaryVariant: Color by mutableStateOf(onMainVariant, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("support"),
    )
    public var secondary: Color by mutableStateOf(support, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("onSupport"),
    )
    public var onSecondary: Color by mutableStateOf(onSupport, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("supportContainer"),
    )
    public var secondaryContainer: Color by mutableStateOf(supportContainer, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("onSupportContainer"),
    )
    public var onSecondaryContainer: Color by mutableStateOf(onSupportContainer, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("supportVariant"),
    )
    public var secondaryVariant: Color by mutableStateOf(supportVariant, structuralEqualityPolicy())
        internal set

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        ReplaceWith("onSupportVariant"),
    )
    public var onSecondaryVariant: Color by mutableStateOf(onSupportVariant, structuralEqualityPolicy())
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

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("outlineHigh"),
        level = DeprecationLevel.WARNING,
    )
    public var outlineVariant: Color by mutableStateOf(outlineVariant, structuralEqualityPolicy())
        internal set
    // endregion

    /**
     * Returns a copy of this Colors, optionally overriding some of the values.
     */
    public fun copy(
        accent: Color = this.accent,
        onAccent: Color = this.onAccent,
        accentContainer: Color = this.accentContainer,
        onAccentContainer: Color = this.onAccentContainer,
        accentVariant: Color = this.accentVariant,
        onAccentVariant: Color = this.onAccentVariant,
        basic: Color = this.basic,
        onBasic: Color = this.onBasic,
        basicContainer: Color = this.basicContainer,
        onBasicContainer: Color = this.onBasicContainer,
        main: Color = this.main,
        onMain: Color = this.onMain,
        mainContainer: Color = this.mainContainer,
        onMainContainer: Color = this.onMainContainer,
        mainVariant: Color = this.mainVariant,
        onMainVariant: Color = this.onMainVariant,
        support: Color = this.support,
        onSupport: Color = this.onSupport,
        supportContainer: Color = this.supportContainer,
        onSupportContainer: Color = this.onSupportContainer,
        supportVariant: Color = this.supportVariant,
        onSupportVariant: Color = this.onSupportVariant,
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
        inverseMain: Color = this.inversePrimary,
        inverseSurface: Color = this.inverseSurface,
        inverseOnSurface: Color = this.inverseOnSurface,
        dimContent1: Float = this.dim1,
        dimContent2: Float = this.dim2,
        dimContent3: Float = this.dim3,
        dimContent4: Float = this.dim4,
        dimContent5: Float = this.dim5,
    ): SparkColors = SparkColors(
        accent = accent,
        onAccent = onAccent,
        accentContainer = accentContainer,
        onAccentContainer = onAccentContainer,
        accentVariant = accentVariant,
        onAccentVariant = onAccentVariant,
        basic = basic,
        onBasic = onBasic,
        basicContainer = basicContainer,
        onBasicContainer = onBasicContainer,
        main = main,
        onMain = onMain,
        mainContainer = mainContainer,
        onMainContainer = onMainContainer,
        mainVariant = mainVariant,
        onMainVariant = onMainVariant,
        support = support,
        onSupport = onSupport,
        supportContainer = supportContainer,
        onSupportContainer = onSupportContainer,
        supportVariant = supportVariant,
        onSupportVariant = onSupportVariant,
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
        inversePrimary = inverseMain,
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
        append("accent=$accent, ")
        append("onAccent=$onAccent, ")
        append("accentContainer=$accentContainer, ")
        append("onAccentContainer=$onAccentContainer, ")
        append("accentVariant=$accentVariant, ")
        append("onAccentVariant=$onAccentVariant, ")
        append("basic=$basic, ")
        append("onBasic=$onBasic, ")
        append("basicContainer=$basicContainer, ")
        append("onBasicContainer=$onBasicContainer, ")
        append("main=$main, ")
        append("onMain=$onMain, ")
        append("mainContainer=$mainContainer, ")
        append("onMainContainer=$onMainContainer, ")
        append("mainVariant=$mainVariant, ")
        append("onMainVariant=$onMainVariant, ")
        append("support=$support, ")
        append("onSupport=$onSupport, ")
        append("supportContainer=$supportContainer, ")
        append("onSupportContainer=$onSupportContainer, ")
        append("supportVariant=$supportVariant, ")
        append("onSupportVariant=$onSupportVariant, ")
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
        append("inverseMain=$inversePrimary, ")
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
    primary = main,
    onPrimary = onMain,
    primaryContainer = mainContainer,
    onPrimaryContainer = onMainContainer,
    inversePrimary = inversePrimary,
    secondary = support,
    onSecondary = onSupport,
    secondaryContainer = supportContainer,
    onSecondaryContainer = onSupportContainer,
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
 * and content color inside a component. For example, a [ButtonFilled] typically uses `main` for its
 * background, and `onMain` for the color of its content (usually text or iconography).
 *
 * This function tries to match the provided [backgroundColor] to a 'background' color in this
 * [SparkColors], and then will return the corresponding color used for content. For example, when
 * [backgroundColor] is [SparkColors.main], this will return [SparkColors.onMain].
 *
 * If [backgroundColor] does not match a background color in the theme, this will return
 * [Color.Unspecified].
 *
 * @return the matching content color for [backgroundColor]. If [backgroundColor] is not present in
 * the theme's [SparkColors], then returns [Color.Unspecified].
 *
 * @see contentColorFor
 */
public fun SparkColors.contentColorFor(backgroundColor: Color): Color = when (backgroundColor) {
    accent -> onAccent
    accentContainer -> onAccentContainer
    accentVariant -> onAccentVariant
    basic -> onBasic
    basicContainer -> onBasicContainer
    main -> onMain
    mainContainer -> onMainContainer
    mainVariant -> onMainVariant
    support -> onSupport
    supportContainer -> onSupportContainer
    supportVariant -> onSupportVariant
    tertiary -> onTertiary
    tertiaryContainer -> onTertiaryContainer
    background -> onBackground
    backgroundVariant -> onBackgroundVariant
    surface -> onSurface
    surfaceVariant -> onSurfaceVariant
    surfaceInverse -> onSurfaceInverse
    inverseSurface -> inverseOnSurface
    success -> onSuccess
    successContainer -> onSuccessContainer
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
 * and content color inside a component. For example, a [ButtonFilled] typically uses `main` for its
 * background, and `onMain` for the color of its content (usually text or iconography).
 *
 * This function tries to match the provided [backgroundColor] to a 'background' color in this
 * [SparkColors], and then will return the corresponding color used for content. For example, when
 * [backgroundColor] is [SparkColors.main], this will return [SparkColors.onMain].
 *
 * If [backgroundColor] does not match a background color in the theme, this will return
 * the current value of [LocalContentColor] as a best-effort color.
 *
 * @return the matching content color for [backgroundColor]. If [backgroundColor] is not present in
 * the theme's [Colors], then returns the current value of [LocalContentColor].
 *
 * @see SparkColors.contentColorFor
 */
@Composable
@ReadOnlyComposable
public fun contentColorFor(backgroundColor: Color): Color {
    return SparkTheme.colors.contentColorFor(backgroundColor).takeOrElse {
        LocalContentColor.current
    }
}

/**
 * Extension property to get a [Color] with dim1(a medium emphasis to text) applied
 */
public val Color.dim1: Color
    @Composable get() = this.copy(alpha = SparkTheme.colors.dim1)

/**
 * Extension property to get a [Color] with dim2(a medium emphasis to icons) applied
 */
public val Color.dim2: Color
    @Composable get() = this.copy(alpha = SparkTheme.colors.dim2)

/**
 * Extension property to get a [Color] with dim3(disabled emphasis to all components) applied
 */
public val Color.dim3: Color
    @Composable get() = this.copy(alpha = SparkTheme.colors.dim3)

/**
 * Extension property to get a [Color] with dim4(low element) applied
 */
public val Color.dim4: Color
    @Composable get() = this.copy(alpha = SparkTheme.colors.dim4)

/**
 * Extension property to get a [Color] with dim5(pressed/ripple visual but should not be used on Android) applied
 */
public val Color.dim5: Color
    @Composable get() = this.copy(alpha = SparkTheme.colors.dim5)

/**
 * Extension property to get a [Color] with dim3(disabled element) applied composite over SparkTheme.colors.surface
 * to prevent the color being transparent
 */
public val Color.disabled: Color
    @Composable get() = this.dim3.compositeOver(SparkTheme.colors.surface)

/**
 * Extension property to get a [Color] that apply an alpha of zero to the color.
 * This is useful when you want to animate fro ma transparent color to a colored one
 * since using  [Color.Transparent] will start with a black background.
 */
public val Color.transparent: Color
    @Composable get() = this.copy(alpha = 0f)

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
    accent = other.accent
    onAccent = other.onAccent
    accentContainer = other.accentContainer
    onAccentContainer = other.onAccentContainer
    accentVariant = other.accentVariant
    onAccentVariant = other.onAccentVariant
    basic = other.basic
    onBasic = other.onBasic
    basicContainer = other.basicContainer
    onBasicContainer = other.onBasicContainer
    main = other.main
    onMain = other.onMain
    mainContainer = other.mainContainer
    onMainContainer = other.onMainContainer
    mainVariant = other.mainVariant
    onMainVariant = other.onMainVariant
    support = other.support
    onSupport = other.onSupport
    supportContainer = other.supportContainer
    onSupportContainer = other.onSupportContainer
    supportVariant = other.supportVariant
    onSupportVariant = other.onSupportVariant
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
    success = other.success
    onSuccess = other.onSuccess
    successContainer = other.successContainer
    onSuccessContainer = other.onSuccessContainer
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
 * Returns the new background [Color] to use, representing the original background [color] with an
 * overlay corresponding to [elevation] applied. The overlay will only be applied to
 * [ColorScheme.surface].
 */
internal fun SparkColors.applyTonalElevation(backgroundColor: Color, elevation: Dp): Color {
    return if (backgroundColor == surface) {
        surfaceColorAtElevation(elevation)
    } else {
        backgroundColor
    }
}

/**
 * Computes the surface tonal color at different elevation levels e.g. surface1 through surface5.
 *
 * @param elevation Elevation value used to compute alpha of the color overlay layer.
 *
 * @return the [ColorScheme.surface] color with an alpha of the [ColorScheme.surfaceTint] color
 * overlaid on top of it.

 */
public fun SparkColors.surfaceColorAtElevation(
    elevation: Dp,
): Color {
    if (elevation > 0.dp && surface.luminance() >= 0.5) return surface
    val alpha = ((4.5f * ln(elevation.value + 1)) + 2f) / 100f
    return surfaceTint.copy(alpha = alpha).compositeOver(surface)
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
    accent = debugColor,
    onAccent = onDebugColor,
    accentContainer = debugColor,
    onAccentContainer = onDebugColor,
    accentVariant = debugColor,
    onAccentVariant = onDebugColor,
    basic = debugColor,
    onBasic = onDebugColor,
    basicContainer = debugColor,
    onBasicContainer = onDebugColor,
    main = debugColor,
    onMain = onDebugColor,
    mainContainer = debugColor,
    onMainContainer = onDebugColor,
    mainVariant = debugColor,
    onMainVariant = onDebugColor,
    support = debugColor,
    onSupport = onDebugColor,
    supportContainer = debugColor,
    onSupportContainer = onDebugColor,
    supportVariant = debugColor,
    onSupportVariant = onDebugColor,
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
)
@Composable
private fun ColorPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        Colors()
    }
}

@Composable
private fun Colors() {
    Row {
        previewColors.forEach { column ->
            Column {
                column.forEach { row ->
                    Row {
                        row.forEach { color ->
                            ColorItem(color)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ColorItem(color: KProperty0<Color>) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .size(104.dp),
        color = color.get(),
        shape = SparkTheme.shapes.extraLarge,
        border = BorderStroke(2.dp, SparkTheme.colors.onBackground),
    ) {
        Box(
            modifier = Modifier.padding(8.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = color.name,
                style = SparkTheme.typography.body2,
                textAlign = TextAlign.Center,
            )
        }
    }
}

private val previewColors
    @Composable
    get() = with(SparkTheme.colors) {
        listOf(
            listOf(
                listOf(::main, ::mainContainer, ::mainVariant),
                listOf(::support, ::supportContainer, ::supportVariant),
                listOf(::accent, ::accentContainer, ::accentVariant),
                listOf(::basic, ::basicContainer),
            ),
            listOf(
                listOf(::success, ::successContainer),
                listOf(::alert, ::alertContainer),
                listOf(::error, ::errorContainer),
                listOf(::info, ::infoContainer),
                listOf(::neutral, ::neutralContainer),
            ),
            listOf(
                listOf(::background, ::backgroundVariant),
                listOf(::surface, ::surfaceInverse),
                listOf(::outline, ::outlineHigh),
            ),
        )
    }
