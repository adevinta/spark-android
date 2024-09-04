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
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adevinta.spark.components.buttons.ButtonFilled
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.toggles.Checkbox
import com.adevinta.spark.tokens.LocalSparkColors
import com.adevinta.spark.tokens.LocalSparkShapes
import com.adevinta.spark.tokens.LocalSparkTypography
import com.adevinta.spark.tokens.LocalWindowSizeClass
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.SparkFontFamily
import com.adevinta.spark.tokens.SparkShapes
import com.adevinta.spark.tokens.SparkTypography
import com.adevinta.spark.tokens.asMaterial3Colors
import com.adevinta.spark.tokens.asMaterial3Shapes
import com.adevinta.spark.tokens.asMaterial3Typography
import com.adevinta.spark.tokens.calculateWindowSizeClass
import com.adevinta.spark.tokens.darkSparkColors
import com.adevinta.spark.tokens.debugColors
import com.adevinta.spark.tokens.lightSparkColors
import com.adevinta.spark.tokens.sparkFontFamily
import com.adevinta.spark.tokens.sparkShapes
import com.adevinta.spark.tokens.sparkTypography
import com.adevinta.spark.tokens.updateColorsFrom
import com.adevinta.spark.tokens.updateFontFamily
import com.adevinta.spark.tools.preview.ThemeVariant

/**
 * **Spark Theming** refers to the customization of your Spark Design app to better reflect your
 * product’s brand.
 *
 * Spark components such as [ButtonFilled] and [Checkbox] use values provided here when retrieving
 * default values.
 *
 * All values may be set by providing this component with the [colors][SparkColors],
 * [typography][SparkTypography] and [shapes][SparkShapes] attributes. Use this to configure the overall
 * theme of elements within this SparkTheme.
 *
 * Any values that are not set will inherit the current value from the theme, falling back to the
 * defaults if there is no parent SparkTheme.
 *
 * @param colors A complete definition of the Spark Color theme for this hierarchy.
 * @param typography A set of text styles to be used as this hierarchy's typography system.
 * @param shapes A set of corner shapes to be used as this hierarchy's shape system.
 * @param fontFamily the font family to be applied on [typography].
 * @param useSparkTokensHighlighter flag that use for typography, colors and shapes exaggerated values to find
 * which part of a screen is themed or not.
 * @param useSparkComponentsHighlighter flag to highlight the spark components with an overlay to recognize
 * which component is from spark or not.
 */
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
public fun SparkTheme(
    // We don't want to automatically support dark theme in the app but still want it in the previews
    colors: SparkColors = SparkTheme.colors,
    shapes: SparkShapes = SparkTheme.shapes,
    typography: SparkTypography = SparkTheme.typography,
    useSparkTokensHighlighter: Boolean = false,
    useSparkComponentsHighlighter: Boolean = false,
    fontFamily: SparkFontFamily = sparkFontFamily(
        useSparkTokensHighlighter = useSparkTokensHighlighter,
    ),
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

    val typo = typography.updateFontFamily(fontFamily = fontFamily)

    CompositionLocalProvider(
        LocalSparkColors provides rememberedColors,
        LocalSparkTypography provides typo,
        LocalSparkShapes provides internalShapes,
        LocalHighlightToken provides useSparkTokensHighlighter,
        LocalHighlightComponents provides useSparkComponentsHighlighter,
        LocalWindowSizeClass provides calculateWindowSizeClass(),
    ) {
        MaterialTheme(
            colorScheme = rememberedColors.asMaterial3Colors(),
            typography = typo.asMaterial3Typography(),
            shapes = internalShapes.asMaterial3Shapes(),
        ) {
            CompositionLocalProvider(
                LocalContentColor provides SparkTheme.colors.onSurface,
            ) {
                ProvideTextStyle(value = SparkTheme.typography.body2) {
                    content()
                }
            }
        }
    }
}

/**
 * A wrapper composable that provides a consistent preview environment for other composables using Spark.
 *
 * This composable creates a Surface with a padding, and place the content inside a Column.
 *
 * @param padding The padding to be applied to the Surface.
 * @param contentPadding The vertical spacing between the items in the Column.
 * @param color A lambda that returns the color of the Surface.
 * @param content The composable you want to showcase in the preview.
 */
@Suppress("ComposeModifierMissing") // It's okay since it’s a base theme
@Composable
public fun PreviewWrapper(
    padding: PaddingValues = PaddingValues(16.dp),
    contentPadding: Dp = 16.dp,
    color: @Composable () -> Color = { SparkTheme.colors.background },
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(
        color = color(),
    ) {
        Column(
            modifier = Modifier.padding(padding),
            verticalArrangement = Arrangement.spacedBy(contentPadding),
        ) {
            content()
        }
    }
}

@Suppress("ComposeModifierMissing") // It's okay since it’s a base theme
@Composable
internal fun PreviewTheme(
    themeVariant: ThemeVariant = if (LocalInspectionMode.current && isSystemInDarkTheme()) {
        ThemeVariant.Dark
    } else {
        ThemeVariant.Light
    },
    padding: PaddingValues = PaddingValues(16.dp),
    contentPadding: Dp = 16.dp,
    color: @Composable () -> Color = { SparkTheme.colors.background },
    content: @Composable ColumnScope.() -> Unit,
) {
    SparkTenantTheme(
        // We don't want to automatically support dark theme in the app but still want it in the previews
        useDarkColors = themeVariant == ThemeVariant.Dark,
    ) {
        PreviewWrapper(
            padding = padding,
            contentPadding = contentPadding,
            color = color,
            content = content,
        )
    }
}

@Composable
internal fun SparkTenantTheme(
    // We don't want to automatically support dark theme in the app but still want it in the previews
    useDarkColors: Boolean = isSystemInDarkTheme(),
    useSparkTokensHighlighter: Boolean = false,
    useSparkComponentsHighlighter: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colors = if (useDarkColors) {
        darkSparkColors()
    } else {
        lightSparkColors()
    }
    SparkTheme(
        colors = colors,
        shapes = sparkShapes(),
        typography = sparkTypography(),
        useSparkTokensHighlighter = useSparkTokensHighlighter,
        useSparkComponentsHighlighter = useSparkComponentsHighlighter,
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
