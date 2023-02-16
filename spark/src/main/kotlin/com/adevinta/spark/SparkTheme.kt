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

package com.adevinta.spark

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontFamily.Companion
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adevinta.spark.tokens.LocalSparkColors
import com.adevinta.spark.tokens.LocalSparkShapes
import com.adevinta.spark.tokens.LocalSparkTypography
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.SparkShapes
import com.adevinta.spark.tokens.SparkTypography
import com.adevinta.spark.tokens.asMaterial3Colors
import com.adevinta.spark.tokens.asMaterial3Shapes
import com.adevinta.spark.tokens.asMaterial3Typography
import com.adevinta.spark.tokens.darkSparkColors
import com.adevinta.spark.tokens.debugColors
import com.adevinta.spark.tokens.lightSparkColors
import com.adevinta.spark.tokens.sparkShapes
import com.adevinta.spark.tokens.sparkTypography
import com.adevinta.spark.tokens.updateColorsFrom
import com.adevinta.spark.tools.preview.ThemeVariant
import com.adevinta.spark.tools.preview.UserType

@Composable
public fun SparkTheme(
    // We don't want to automatically support dark theme in the app but still want it in the previews
    colors: SparkColors = SparkTheme.colors,
    shapes: SparkShapes = SparkTheme.shapes,
    typography: SparkTypography = SparkTheme.typography,
    useSparkTokensHighlighter: Boolean = false,
    useSparkComponentsHighlighter: Boolean = false,
    isPro: Boolean = false,
    content: @Composable () -> Unit,
) {
    val internalColors = if (useSparkTokensHighlighter) debugColors() else colors
    val rememberedColors = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        internalColors.copy()
    }.apply { updateColorsFrom(internalColors) }

    val internalShapes = if (useSparkTokensHighlighter) {
        sparkShapes(
            none = CutCornerShape(50),
            extraSmall = CutCornerShape(50),
            small = CutCornerShape(50),
            medium = CutCornerShape(50),
            large = CutCornerShape(50),
            extraLarge = CutCornerShape(50),
            full = CutCornerShape(50),
        )
    } else {
        shapes
    }
    val typo = if (useSparkTokensHighlighter) {
        sparkTypography(
            fontFamily = FontFamily.Cursive,
        )
    } else {
        typography
    }
    CompositionLocalProvider(
        LocalSparkColors provides rememberedColors,
        LocalSparkTypography provides typo,
        LocalSparkShapes provides internalShapes,
        LocalHighlightToken provides useSparkTokensHighlighter,
        LocalHighlightComponents provides useSparkComponentsHighlighter,
        LocalIsUserPro provides isPro,
    ) {
        MaterialTheme(
            colorScheme = rememberedColors.asMaterial3Colors(),
            typography = typo.asMaterial3Typography(),
            shapes = internalShapes.asMaterial3Shapes(),
        ) {
            CompositionLocalProvider(
                LocalContentColor provides SparkTheme.colors.onSurface,
            ) {
                ProvideTextStyle(value = SparkTheme.typography.body) {
                    content()
                }
            }
        }
    }
}

@Suppress("ModifierMissing") // It's okay since it’s a base theme
@Composable
public fun PreviewTheme(
    themeVariant: ThemeVariant = if (LocalInspectionMode.current && isSystemInDarkTheme()) {
        ThemeVariant.Dark
    } else {
        ThemeVariant.Light
    },
    userType: UserType = UserType.Part,
    padding: PaddingValues = PaddingValues(16.dp),
    contentPadding: Dp = 16.dp,
    content: @Composable ColumnScope.() -> Unit,
) {
    SparkTenantTheme(
        // We don't want to automatically support dark theme in the app but still want it in the previews
        useDarkColors = themeVariant == ThemeVariant.Dark,
        isPro = userType == UserType.Pro,
    ) {
        val previewContent = movableContentOf {
            Column(
                modifier = Modifier.padding(padding),
                verticalArrangement = Arrangement.spacedBy(contentPadding),
            ) {
                content()
            }
        }
        Surface(
            color = SparkTheme.colors.surface,
            content = previewContent,
        )
    }
}

@Composable
internal fun SparkTenantTheme(
    // We don't want to automatically support dark theme in the app but still want it in the previews
    useDarkColors: Boolean = isSystemInDarkTheme(),
    useSparkTokensHighlighter: Boolean = false,
    useSparkComponentsHighlighter: Boolean = false,
    isPro: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colors = if (useDarkColors) {
        darkSparkColors(isPro = isPro)
    } else {
        lightSparkColors(isPro = isPro)
    }
    SparkTheme(
        colors = colors,
        shapes = sparkShapes(),
        typography = sparkTypography(),
        useSparkTokensHighlighter = useSparkTokensHighlighter,
        useSparkComponentsHighlighter = useSparkComponentsHighlighter,
        isPro = isPro,
        content = content,
    )
}

/**
 * Contains functions to access the current theme values provided at the call site's position in
 * the hierarchy.
 */
public object SparkTheme {
    /**
     * Retrieves the current [SparkColors] at the call site's position in the hierarchy.
     */
    public val colors: SparkColors
        @Composable
        @ReadOnlyComposable
        get() = LocalSparkColors.current

    /**
     * Retrieves the current [SparkTypography] at the call site's position in the hierarchy.
     *
     */
    public val typography: SparkTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalSparkTypography.current

    /**
     * Retrieves the current [SparkShapes] at the call site's position in the hierarchy.
     */
    public val shapes: SparkShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalSparkShapes.current
}

/**
 * CompositionLocal used to highlight visually where the spark tokens are used or not.
 * Setting it to true makes the text in cursive, colors in red/green/blue and shapes in full cut corners
 */
internal val LocalHighlightToken = staticCompositionLocalOf { false }

/**
 * CompositionLocal used to highlight visually with an overlay where the spark components are used or not.
 * Setting it to true show an overlay on spark components.
 */
internal val LocalHighlightComponents = staticCompositionLocalOf { false }

/**
 * CompositionLocal used to pass the status of the user.
 *
 * We already have a isPro parameter to our theme but it affects only the primary color, if we need to modify a
 * composable to get a particular image or icon asset based on its status it’s complicated as the app is not
 * entirely migrated.
 *
 * If you use this CompositionLocal you must provide it has a default parameter to your composable isPro parameter
 *
 */
@ExperimentalSparkApi
public val LocalIsUserPro: ProvidableCompositionLocal<Boolean> = staticCompositionLocalOf { false }
