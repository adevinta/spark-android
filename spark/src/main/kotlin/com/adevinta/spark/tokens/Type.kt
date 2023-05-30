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

import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

internal val display1Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 40.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 56.sp,
)

internal val display2Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 32.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 44.sp,
)

internal val display3Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 24.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 32.sp,
)

internal val headline1Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 28.sp,
)

internal val headline2Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 24.sp,
)

internal val subheadType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 24.sp,
)

internal val body1Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 24.sp,
)

internal val body2Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 20.sp,
)

internal val captionType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 12.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 16.sp,
)

internal val smallType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 10.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 14.sp,
)

internal val calloutType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.Bold,
    lineHeight = 24.sp,
)

public fun sparkTypography(
    fontFamily: FontFamily = FontFamily.SansSerif,
    display1: TextStyle = display1Type.copy(fontFamily = fontFamily),
    display2: TextStyle = display2Type.copy(fontFamily = fontFamily),
    display3: TextStyle = display3Type.copy(fontFamily = fontFamily),
    headline1: TextStyle = headline1Type.copy(fontFamily = fontFamily),
    headline2: TextStyle = headline2Type.copy(fontFamily = fontFamily),
    subhead: TextStyle = subheadType.copy(fontFamily = fontFamily),
    body1: TextStyle = body1Type.copy(fontFamily = fontFamily),
    body2: TextStyle = body2Type.copy(fontFamily = fontFamily),
    caption: TextStyle = captionType.copy(fontFamily = fontFamily),
    small: TextStyle = smallType.copy(fontFamily = fontFamily),
    callout: TextStyle = calloutType.copy(fontFamily = fontFamily),
): SparkTypography = SparkTypography(
    display1 = display1,
    display2 = display2,
    display3 = display3,
    headline1 = headline1,
    headline2 = headline2,
    subhead = subhead,
    body1 = body1,
    body2 = body2,
    caption = caption,
    small = small,
    callout = callout,
)

@Immutable
public data class SparkTypography(
    /**
     * Reserved for short/important large text.
     */
    val display1: TextStyle,
    /**
     * Reserved for short/important medium text.
     */
    val display2: TextStyle,
    /**
     * Reserved for short/important small text.
     */
    val display3: TextStyle,
    /**
     * High-emphasis large text.
     */
    val headline1: TextStyle,
    /**
     * High-emphasis medium text.
     */
    val headline2: TextStyle,
    /**
     * High-emphasis small text.
     */
    val subhead: TextStyle,
    /**
     * Content base text.
     */
    val body1: TextStyle,
    /**
     * Content base text low hierarchy.
     */
    val body2: TextStyle,
    /**
     * Support text or error texts.
     */
    val caption: TextStyle,
    /**
     * Legal text, App bar labels
     */
    val small: TextStyle,
    /**
     * Call to actions
     */
    val callout: TextStyle,
) {
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith(
            expression = "display3",
        ),
        level = DeprecationLevel.WARNING,
    )
    val title1: TextStyle = display3

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith(
            expression = "headline1",
        ),
        level = DeprecationLevel.WARNING,
    )
    val title2: TextStyle = headline1

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith(
            expression = "headline2",
        ),
        level = DeprecationLevel.WARNING,
    )
    val title3: TextStyle = headline2

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith(
            expression = "body1.copy(fontWeight = FontWeight.Bold)",
            "androidx.compose.ui.text.font.FontWeight",
        ),
        level = DeprecationLevel.WARNING,
    )
    val largeImportant: TextStyle = body1.copy(fontWeight = FontWeight.Bold)

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith(
            expression = "body1",
        ),
        level = DeprecationLevel.WARNING,
    )
    val large: TextStyle = body1

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith(
            expression = "body2.copy(fontWeight = FontWeight.Bold)",
            "androidx.compose.ui.text.font.FontWeight",
        ),
        level = DeprecationLevel.WARNING,
    )
    val bodyImportant: TextStyle = body2.copy(fontWeight = FontWeight.Bold)

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith(
            expression = "body2",
        ),
        level = DeprecationLevel.WARNING,
    )
    val body: TextStyle = body2

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith(
            expression = "caption.copy(fontWeight = FontWeight.Bold)",
            "androidx.compose.ui.text.font.FontWeight",
        ),
        level = DeprecationLevel.WARNING,
    )
    val smallImportantLegacy: TextStyle = caption.copy(fontWeight = FontWeight.Bold)

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith(
            expression = "caption",
        ),
        level = DeprecationLevel.WARNING,
    )
    val smallLegacy: TextStyle = caption

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith(
            expression = "small.copy(fontWeight = FontWeight.Bold)",
            "androidx.compose.ui.text.font.FontWeight",
        ),
        level = DeprecationLevel.WARNING,
    )
    val extraSmallImportant: TextStyle = small.copy(fontWeight = FontWeight.Bold)

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith(
            expression = "small",
        ),
        level = DeprecationLevel.WARNING,
    )
    val extraSmall: TextStyle = small

    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith(expression = "callout"),
        level = DeprecationLevel.WARNING,
    )
    val button: TextStyle = callout
}

@Suppress("CompositionLocalAllowlist") // We need it to get access to our typo like Material
internal val LocalSparkTypography = staticCompositionLocalOf { sparkTypography() }

public fun SparkTypography.asMaterial3Typography(): Typography = Typography(
    displayLarge = display1,
    displayMedium = display2,
    displaySmall = display3,
    headlineLarge = headline1,
    headlineMedium = display2.copy(fontWeight = FontWeight.Normal),
    headlineSmall = display3,
    titleLarge = headline1,
    titleMedium = display2,
    titleSmall = display3,
    bodyLarge = body1,
    bodyMedium = body2,
    bodySmall = caption,
    labelLarge = body2.copy(fontWeight = FontWeight.Bold),
    labelMedium = caption,
    labelSmall = small,
)

@Preview(
    group = "Tokens",
    name = "Spark Typography",
)
@Composable
private fun TextPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        Text(
            text = "This is font family text display1",
            style = SparkTheme.typography.display1,
        )
        Text(
            text = "This is font family text display2",
            style = SparkTheme.typography.display2,
        )
        Text(
            text = "This is font family text display3",
            style = SparkTheme.typography.display3,
        )
        Text(
            text = "This is font family text headline1",
            style = SparkTheme.typography.headline1,
        )
        Text(
            text = "This is font family text headline2",
            style = SparkTheme.typography.headline2,
        )
        Text(
            text = "This is font family text subhead",
            style = SparkTheme.typography.subhead,
        )
        Text(
            text = "This is font family text body1",
            style = SparkTheme.typography.body1,
        )
        Text(
            text = "This is font family text body1 highlight",
            style = SparkTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
        )
        Text(
            text = "This is font family text body2 (default)",
            style = SparkTheme.typography.body2,
        )
        Text(
            text = "This is font family text body2 highlight",
            style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
        )
        Text(
            text = "This is font family text caption",
            style = SparkTheme.typography.caption,
        )
        Text(
            text = "This is font family text caption highlight",
            style = SparkTheme.typography.caption.copy(fontWeight = FontWeight.Bold),
        )
        Text(
            text = "This is font family text small",
            style = SparkTheme.typography.small,
        )
        Text(
            text = "This is font family text small highlight",
            style = SparkTheme.typography.small.copy(fontWeight = FontWeight.Bold),
        )
        Text(
            text = "This is font family text callout",
            style = SparkTheme.typography.callout,
        )
    }
}
