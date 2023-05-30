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
package com.adevinta.spark.sample.themes

import androidx.compose.runtime.saveable.Saver

public data class Theme(
    val themeMode: ThemeMode = ThemeMode.System,
    val colorMode: ColorMode = ColorMode.Baseline,
    val brandMode: BrandMode = BrandMode.Polaris,
    val userMode: UserMode = UserMode.Part,
    val fontScale: Float = 1.0f,
    val fontScaleMode: FontScaleMode = FontScaleMode.System,
    val textDirection: TextDirection = TextDirection.System,
)

/**
 * A class for defining layout directions.
 *
 * A layout direction can be left-to-right (LTR) or right-to-left (RTL).
 */
public enum class TextDirection {
    System,

    /** Horizontal layout direction is from Left to Right. */
    LTR,

    /** Horizontal layout direction is from Right to Left. */
    RTL,
}

/**
 * Determines what color scheme should be used when viewing the catalog in the Google Material 3
 * theme.
 */
public enum class ColorMode(public val label: String) {
    /**
     * The baseline light/dark colors schemes.
     *
     * This is the default behavior, and the fallback if dynamic colors are not available on the
     * current device.
     */
    Baseline("Baseline"),

    /**
     * Build a color scheme from a pre-selected color palette from the selected brand.
     *
     * Useful to test that the brand palette works with Spark.
     */
    Brand("Brand"),

    /**
     * Build a color scheme from the dynamic colors taken from the Android System.
     *
     * If the dynamic colors are not available, the baseline color scheme will be used as a fallback.
     */
    Dynamic("Dynamic (Android 12+)"),
}

public enum class FontScaleMode(public val label: String) {
    Custom("Custom"),
    System("System"),
}

public enum class ThemeMode {
    System,
    Light,
    Dark,
}

public enum class BrandMode(public val label: String) {
    LeboncoinLegacy("Leboncoin (Legacy)"),
    Leboncoin("Leboncoin (New Ui)"),
    Polaris("Polaris"),
}

public enum class UserMode {
    Part,
    Pro,
}

public val ThemeSaver: Saver<Theme, Map<String, Int>> = Saver(
    save = { theme ->
        mapOf(
            ThemeModeKey to theme.themeMode.ordinal,
            ColorModeKey to theme.colorMode.ordinal,
            BrandModeKey to theme.colorMode.ordinal,
            UserModeKey to theme.colorMode.ordinal,
            FontScaleKey to theme.fontScale.toInt(),
            TextDirectionKey to theme.textDirection.ordinal,
        )
    },
    restore = { map ->
        Theme(
            themeMode = ThemeMode.values()[map.getValue(ThemeModeKey)],
            colorMode = ColorMode.values()[map.getValue(ColorModeKey)],
            brandMode = BrandMode.values()[map.getValue(BrandModeKey)],
            userMode = UserMode.values()[map.getValue(UserModeKey)],
            fontScale = map.getValue(FontScaleKey).toFloat(),
            textDirection = TextDirection.values()[map.getValue(TextDirectionKey)],
        )
    },
)

public const val MinFontScale: Float = 0.4f
public const val MaxFontScale: Float = 2f

private const val ThemeModeKey = "themeMode"
private const val ColorModeKey = "colorMode"
private const val BrandModeKey = "brandMode"
private const val UserModeKey = "userMode"
private const val FontScaleKey = "fontScale"
private const val TextDirectionKey = "textDirection"
