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
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tokens.PaletteTokens.Blue10
import com.adevinta.spark.tokens.PaletteTokens.Blue20
import com.adevinta.spark.tokens.PaletteTokens.Blue30
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
import com.adevinta.spark.tools.preview.SparkPreviewProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import com.adevinta.spark.tools.preview.UserType
import com.adevinta.spark.utils.ShowkaseComposable

fun lightSparkColors(
    isPro: Boolean = false,
    primary: Color = if (isPro) BrikkeBlue else BrikkeOrange,
    onPrimary: Color = if (isPro) Grey100 else Grey100,
    primaryContainer: Color = if (isPro) BrikkeBlueSurface else BrikkeOrangeSurface,
    onPrimaryContainer: Color = if (isPro) Blue10 else Orange10,
    secondary: Color = BrikkeBlack,
    onSecondary: Color = Grey100,
    secondaryContainer: Color = BrikkeGreyLight,
    onSecondaryContainer: Color = Grey10,
    tertiary: Color = BrikkeGrey,
    onTertiary: Color = GreyBlue99,
    tertiaryContainer: Color = BrikkeGreyExtraLight,
    onTertiaryContainer: Color = GreyBlue10,
    error: Color = BrikkeRed,
    onError: Color = Grey100,
    errorContainer: Color = BrikkeRedSurface,
    onErrorContainer: Color = Red10,
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
    surfaceTint: Color = primary,
    outline: Color = GreyBlue50,
    outlineVariant: Color = GreyBlue80,
    inversePrimary: Color = Orange80,
    inverseSurface: Color = Grey20,
    inverseOnSurface: Color = Grey95,
    scrim: Color = Grey0,
) = SparkColors(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,
    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = tertiaryContainer,
    onTertiaryContainer = onTertiaryContainer,
    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,
    valid = valid,
    onValid = onValid,
    validContainer = validContainer,
    onValidContainer = onValidContainer,
    background = background,
    onBackground = onBackground,
    surface = surface,
    onSurface = onSurface,
    surfaceVariant = surfaceVariant,
    onSurfaceVariant = onSurfaceVariant,
    surfaceTint = surfaceTint,
    outline = outline,
    outlineVariant = outlineVariant,
    scrim = scrim,
    inversePrimary = inversePrimary,
    inverseSurface = inverseSurface,
    inverseOnSurface = inverseOnSurface,
)

fun darkSparkColors(
    isPro: Boolean = false,
    primary: Color = if (isPro) Blue80 else Orange80,
    onPrimary: Color = if (isPro) Blue20 else Orange20,
    primaryContainer: Color = if (isPro) Blue30 else Orange30,
    onPrimaryContainer: Color = if (isPro) Blue90 else Orange90,
    secondary: Color = Grey99,
    onSecondary: Color = Color.Black,
    secondaryContainer: Color = Grey30,
    onSecondaryContainer: Color = Grey90,
    tertiary: Color = GreyBlue40,
    onTertiary: Color = GreyBlue90,
    tertiaryContainer: Color = GreyBlue20,
    onTertiaryContainer: Color = GreyBlue95,
    error: Color = Red80,
    onError: Color = Red20,
    errorContainer: Color = Red30,
    onErrorContainer: Color = Red90,
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
    surfaceTint: Color = primary,
    outline: Color = GreyBlue50,
    outlineVariant: Color = GreyBlue30,
    inversePrimary: Color = Orange40,
    inverseSurface: Color = onSurface,
    inverseOnSurface: Color = Grey20,
    scrim: Color = Grey0,
) = SparkColors(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,
    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = tertiaryContainer,
    onTertiaryContainer = onTertiaryContainer,
    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,
    valid = valid,
    onValid = onValid,
    validContainer = validContainer,
    onValidContainer = onValidContainer,
    background = background,
    onBackground = onBackground,
    surface = surface,
    onSurface = onSurface,
    surfaceVariant = surfaceVariant,
    onSurfaceVariant = onSurfaceVariant,
    surfaceTint = surfaceTint,
    outline = outline,
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
 * @property tertiary The tertiary color that can be used to balance primary and secondary
 * colors, or bring heightened attention to an element such as an input field.
 * @property onTertiary Color used for text and icons displayed on top of the tertiary color.
 * @property tertiaryContainer A tonal color to be used in containers.
 * @property onTertiaryContainer The color (and state variants) that should be used for content on
 * top of [tertiaryContainer].
 * @property background The background color that appears behind scrollable content.
 * @property onBackground Color used for text and icons displayed on top of the background color.
 * @property surface The surface color that affect surfaces of components, such as cards, sheets,
 * and menus.
 * @property onSurface Color used for text and icons displayed on top of the surface color.
 * @property surfaceVariant Another option for a color with similar uses of [surface].
 * @property onSurfaceVariant The color (and state variants) that can be used for content on top of
 * [surface].
 * @property surfaceTint This color will be used by components that apply tonal elevation and is
 * applied on top of [surface]. The higher the elevation the more this color is used.
 * @property inverseSurface A color that contrasts sharply with [surface]. Useful for surfaces that
 * sit on top of other surfaces with [surface] color.
 * @property inverseOnSurface A color that contrasts well with [inverseSurface]. Useful for content
 * that sits on top of containers that are [inverseSurface].
 * @property error The error color is used to indicate errors in components, such as invalid text in
 * a text field.
 * @property onError Color used for text and icons displayed on top of the error color.
 * @property errorContainer The preferred tonal color of error containers.
 * @property onErrorContainer The color (and state variants) that should be used for content on
 * top of [errorContainer].
 * @property outline Subtle color used for boundaries. Outline color role adds contrast for
 * accessibility purposes.
 * @property outlineVariant Utility color used for boundaries for decorative elements when strong
 * contrast is not required.
 * @property scrim Color of a scrim that obscures content. On Android platforms, the scrim color
 * and opacity is automatically handled by the system UI.
 */
@Stable
class SparkColors(
    primary: Color,
    onPrimary: Color,
    primaryContainer: Color,
    onPrimaryContainer: Color,
    secondary: Color,
    onSecondary: Color,
    secondaryContainer: Color,
    onSecondaryContainer: Color,
    tertiary: Color,
    onTertiary: Color,
    tertiaryContainer: Color,
    onTertiaryContainer: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface: Color,
    surfaceVariant: Color,
    onSurfaceVariant: Color,
    surfaceTint: Color,
    inversePrimary: Color,
    inverseSurface: Color,
    inverseOnSurface: Color,
    error: Color,
    onError: Color,
    errorContainer: Color,
    onErrorContainer: Color,
    valid: Color,
    onValid: Color,
    validContainer: Color,
    onValidContainer: Color,
    outline: Color,
    outlineVariant: Color,
    scrim: Color,
) {
    var primary by mutableStateOf(primary, structuralEqualityPolicy())
        internal set
    var onPrimary by mutableStateOf(onPrimary, structuralEqualityPolicy())
        internal set
    var primaryContainer by mutableStateOf(primaryContainer, structuralEqualityPolicy())
        internal set
    var onPrimaryContainer by mutableStateOf(onPrimaryContainer, structuralEqualityPolicy())
        internal set

    var secondary by mutableStateOf(secondary, structuralEqualityPolicy())
        internal set
    var onSecondary by mutableStateOf(onSecondary, structuralEqualityPolicy())
        internal set

    var secondaryContainer by mutableStateOf(secondaryContainer, structuralEqualityPolicy())
        internal set
    var onSecondaryContainer by mutableStateOf(onSecondaryContainer, structuralEqualityPolicy())
        internal set
    var tertiary by mutableStateOf(tertiary, structuralEqualityPolicy())
        internal set
    var onTertiary by mutableStateOf(onTertiary, structuralEqualityPolicy())
        internal set
    var tertiaryContainer by mutableStateOf(tertiaryContainer, structuralEqualityPolicy())
        internal set
    var onTertiaryContainer by mutableStateOf(onTertiaryContainer, structuralEqualityPolicy())
        internal set
    var background by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    var onBackground by mutableStateOf(onBackground, structuralEqualityPolicy())
        internal set
    var surface by mutableStateOf(surface, structuralEqualityPolicy())
        internal set
    var onSurface by mutableStateOf(onSurface, structuralEqualityPolicy())
        internal set
    var surfaceVariant by mutableStateOf(surfaceVariant, structuralEqualityPolicy())
        internal set
    var onSurfaceVariant by mutableStateOf(onSurfaceVariant, structuralEqualityPolicy())
        internal set
    var surfaceTint by mutableStateOf(surfaceTint, structuralEqualityPolicy())
        internal set
    var outline by mutableStateOf(outline, structuralEqualityPolicy())
        internal set
    var outlineVariant by mutableStateOf(outlineVariant, structuralEqualityPolicy())
        internal set
    var scrim by mutableStateOf(scrim, structuralEqualityPolicy())
        internal set
    var error by mutableStateOf(error, structuralEqualityPolicy())
        internal set
    var onError by mutableStateOf(onError, structuralEqualityPolicy())
        internal set
    var errorContainer by mutableStateOf(errorContainer, structuralEqualityPolicy())
        internal set
    var onErrorContainer by mutableStateOf(onErrorContainer, structuralEqualityPolicy())
        internal set
    var valid by mutableStateOf(valid, structuralEqualityPolicy())
        internal set
    var onValid by mutableStateOf(onValid, structuralEqualityPolicy())
        internal set
    var validContainer by mutableStateOf(validContainer, structuralEqualityPolicy())
        internal set
    var onValidContainer by mutableStateOf(onValidContainer, structuralEqualityPolicy())
        internal set
    var inversePrimary by mutableStateOf(inversePrimary, structuralEqualityPolicy())
        internal set
    var inverseSurface by mutableStateOf(inverseSurface, structuralEqualityPolicy())
        internal set
    var inverseOnSurface by mutableStateOf(inverseOnSurface, structuralEqualityPolicy())
        internal set

    /**
     * Returns a copy of this Colors, optionally overriding some of the values.
     */
    fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        primaryContainer: Color = this.primaryContainer,
        onPrimaryContainer: Color = this.onPrimaryContainer,
        secondary: Color = this.secondary,
        onSecondary: Color = this.onSecondary,
        secondaryContainer: Color = this.secondaryContainer,
        onSecondaryContainer: Color = this.onSecondaryContainer,
        tertiary: Color = this.tertiary,
        onTertiary: Color = this.onTertiary,
        tertiaryContainer: Color = this.tertiaryContainer,
        onTertiaryContainer: Color = this.onTertiaryContainer,
        background: Color = this.background,
        onBackground: Color = this.onBackground,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        surfaceVariant: Color = this.surfaceVariant,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        surfaceTint: Color = this.surfaceTint,
        outline: Color = this.outline,
        outlineVariant: Color = this.outlineVariant,
        scrim: Color = this.scrim,
        error: Color = this.error,
        onError: Color = this.onError,
        errorContainer: Color = this.errorContainer,
        onErrorContainer: Color = this.onErrorContainer,
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
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onErrorContainer,
        valid = valid,
        onValid = onValid,
        validContainer = validContainer,
        onValidContainer = onValidContainer,
        inversePrimary = inversePrimary,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
    )

    override fun toString(): String {
        return buildString {
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
}

fun SparkColors.asMaterial3Colors(): ColorScheme = ColorScheme(
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
fun SparkColors.contentColorFor(backgroundColor: Color): Color {
    return when (backgroundColor) {
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
fun contentColorFor(backgroundColor: Color): Color {
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
fun debugColors(
    debugColor: Color = Color.Magenta,
    onDebugColor: Color = Color.Green,
) = SparkColors(
    primary = debugColor,
    onPrimary = onDebugColor,
    primaryContainer = debugColor,
    onPrimaryContainer = onDebugColor,
    secondary = debugColor,
    onSecondary = onDebugColor,
    secondaryContainer = debugColor,
    onSecondaryContainer = onDebugColor,
    tertiary = debugColor,
    onTertiary = onDebugColor,
    tertiaryContainer = debugColor,
    onTertiaryContainer = onDebugColor,
    error = debugColor,
    onError = onDebugColor,
    errorContainer = debugColor,
    onErrorContainer = onDebugColor,
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
    surfaceTint = debugColor,
    outline = debugColor,
    outlineVariant = debugColor,
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
@ShowkaseComposable(skip = true) // FIXME: This preview doesn't render dark mode with paparazzi which fail the tests
internal fun ColorPreview(
    @PreviewParameter(SparkPreviewProvider::class) param: Pair<ThemeVariant, UserType>,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        Row() {
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
