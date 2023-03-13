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

@Deprecated(
    "This property will be removed as it is not part of Spark Token",
    replaceWith = ReplaceWith("display3"),
    level = DeprecationLevel.WARNING,
)
internal val tile1Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 24.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 28.sp,
    letterSpacing = 0.sp,
)

@Deprecated(
    "This property will be removed as it is not part of Spark Token",
    replaceWith = ReplaceWith("headline"),
    level = DeprecationLevel.WARNING,
)
internal val title2Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 26.sp,
    letterSpacing = 0.15.sp,
)

@Deprecated(
    "This property will be removed as it is not part of Spark Token",
    replaceWith = ReplaceWith("headline2"),
    level = DeprecationLevel.WARNING,
)
internal val title3Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 18.sp,
    letterSpacing = 0.15.sp,
)

@Deprecated(
    "This property will be removed as it is not part of Spark Token",
    replaceWith = ReplaceWith("body1Highlight"),
    level = DeprecationLevel.WARNING,
)
internal val largeImportantType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 16.sp,
    letterSpacing = 0.15.sp,
)

@Deprecated(
    "This property will be removed as it is not part of Spark Token",
    replaceWith = ReplaceWith("body1"),
    level = DeprecationLevel.WARNING,
)
internal val largeType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp,
)

@Deprecated(
    "This property will be removed as it is not part of Spark Token",
    replaceWith = ReplaceWith("body2Highlight"),
    level = DeprecationLevel.WARNING,
)
internal val bodyImportantType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 20.sp,
    letterSpacing = 0.1.sp,
)

@Deprecated(
    "This property will be removed as it is not part of Spark Token",
    replaceWith = ReplaceWith("body2"),
    level = DeprecationLevel.WARNING,
)
internal val bodyType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 20.sp,
    letterSpacing = 0.25.sp,
)

@Deprecated(
    "This property will be removed as it is not part of Spark Token",
    replaceWith = ReplaceWith("smallHighlight"),
    level = DeprecationLevel.WARNING,
)
internal val smallImportantType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 12.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 16.sp,
)

internal val smallType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 12.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 16.sp,
)

@Deprecated(
    "This property will be removed as it is not part of Spark Token",
    replaceWith = ReplaceWith("captionHighlight"),
    level = DeprecationLevel.WARNING,
)
internal val extraSmallImportantType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 10.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 10.sp,
)

@Deprecated(
    "This property will be removed as it is not part of Spark Token",
    replaceWith = ReplaceWith("caption"),
    level = DeprecationLevel.WARNING,
)
internal val extraSmallType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 10.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 10.sp,
)

@Deprecated(
    "This property will be removed as it is not part of Spark Token",
    replaceWith = ReplaceWith("callout"),
    level = DeprecationLevel.WARNING,
)
internal val buttonType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    letterSpacing = 1.25.sp,
)

public fun sparkTypography(
    fontFamily: FontFamily = FontFamily.Default,
    display1: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    display2: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    display3: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    headline1: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    headline2: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    subhead: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    body1: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    body1Highlight: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    body2: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    body2Highlight: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    caption: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    captionHighlight: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    /* deprecated*/ title1: TextStyle = tile1Type.copy(fontFamily = fontFamily),
    /* deprecated*/ title2: TextStyle = title2Type.copy(fontFamily = fontFamily),
    /* deprecated*/ title3: TextStyle = title3Type.copy(fontFamily = fontFamily),
    /* deprecated*/ largeImportant: TextStyle = largeImportantType.copy(fontFamily = fontFamily),
    /* deprecated*/ large: TextStyle = largeType.copy(fontFamily = fontFamily),
    /* deprecated*/ bodyImportant: TextStyle = bodyImportantType.copy(fontFamily = fontFamily),
    /* deprecated*/ body: TextStyle = bodyType.copy(fontFamily = fontFamily),
    /* deprecated*/ smallImportant: TextStyle = smallImportantType.copy(fontFamily = fontFamily),
    small: TextStyle = smallType.copy(fontFamily = fontFamily),
    smallHighlight: TextStyle = TextStyle.Default.copy(fontFamily = fontFamily),
    /* deprecated*/ extraSmallImportant: TextStyle = extraSmallImportantType.copy(fontFamily = fontFamily),
    /* deprecated*/ extraSmall: TextStyle = extraSmallType.copy(fontFamily = fontFamily),
    /* deprecated*/ button: TextStyle = buttonType.copy(fontFamily = fontFamily),
): SparkTypography = SparkTypography(
    display1 = display1,
    display2 = display2,
    display3 = display3,
    headline1 = headline1,
    headline2 = headline2,
    subhead = subhead,
    body1 = body1,
    body1Highlight = body1Highlight,
    body2 = body2,
    body2Highlight = body2Highlight,
    caption = caption,
    captionHighlight = captionHighlight,
    title1 = title1,
    title2 = title2,
    title3 = title3,
    largeImportant = largeImportant,
    large = large,
    bodyImportant = bodyImportant,
    body = body,
    smallImportant = smallImportant,
    small = small,
    smallHighlight = smallHighlight,
    extraSmallImportant = extraSmallImportant,
    extraSmall = extraSmall,
    button = button,
)

@Immutable
public data class SparkTypography(
    val display1: TextStyle,
    val display2: TextStyle,
    val display3: TextStyle,
    val headline1: TextStyle,
    val headline2: TextStyle,
    val subhead: TextStyle,
    val body1: TextStyle,
    val body1Highlight: TextStyle,
    val body2: TextStyle,
    val body2Highlight: TextStyle,
    val caption: TextStyle,
    val captionHighlight: TextStyle,
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("display3"),
        level = DeprecationLevel.WARNING,
    )
    val title1: TextStyle,
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("headline"),
        level = DeprecationLevel.WARNING,
    )
    val title2: TextStyle,
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("headline2"),
        level = DeprecationLevel.WARNING,
    )
    val title3: TextStyle,
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("body1Highlight"),
        level = DeprecationLevel.WARNING,
    )
    val largeImportant: TextStyle,
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("body1"),
        level = DeprecationLevel.WARNING,
    )
    val large: TextStyle,
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("body2Highlight"),
        level = DeprecationLevel.WARNING,
    )
    val bodyImportant: TextStyle,
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("body2"),
        level = DeprecationLevel.WARNING,
    )
    val body: TextStyle,
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("smallHighlight"),
        level = DeprecationLevel.WARNING,
    )
    val smallImportant: TextStyle,
    val small: TextStyle,
    val smallHighlight: TextStyle,
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("captionHighlight"),
        level = DeprecationLevel.WARNING,
    )
    val extraSmallImportant: TextStyle,
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("caption"),
        level = DeprecationLevel.WARNING,
    )
    val extraSmall: TextStyle,
    @Deprecated(
        "This property will be removed as it is not part of Spark Token",
        replaceWith = ReplaceWith("callout"),
        level = DeprecationLevel.WARNING,
    )
    val button: TextStyle,
)

@Suppress("CompositionLocalAllowlist") // We need it to get access to our typo like Material
internal val LocalSparkTypography = staticCompositionLocalOf { sparkTypography() }

public fun SparkTypography.asMaterial3Typography(): Typography = Typography(
    displayLarge = display1,
    displayMedium = display2,
    displaySmall = display3,
    headlineLarge = headline1,
    headlineMedium = headline2,
    headlineSmall = subhead,
    titleLarge = display1,
    titleMedium = display2,
    titleSmall = display3,
    bodyLarge = body1,
    bodyMedium = body1,
    bodySmall = small,
    labelLarge = body1Highlight,
    labelMedium = body2Highlight,
    labelSmall = smallHighlight,
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
            text = "This is font family text Title1",
            style = SparkTheme.typography.title1,
        )
        Text(
            text = "This is font family text Title2",
            style = SparkTheme.typography.title2,
        )
        Text(
            text = "This is font family text Title3",
            style = SparkTheme.typography.title3,
        )
        Text(
            text = "This is font family text Large Important",
            style = SparkTheme.typography.largeImportant,
        )
        Text(
            text = "This is font family text Large",
            style = SparkTheme.typography.large,
        )
        Text(
            text = "This is font family text Body Important",
            style = SparkTheme.typography.bodyImportant,
        )
        Text(
            text = "This is font family text Body",
            style = SparkTheme.typography.body,
        )
        Text(
            text = "This is font family text Body",
        )
        Text(
            text = "This is font family text Small Important",
            style = SparkTheme.typography.smallImportant,
        )
        Text(
            text = "This is font family text Small",
            style = SparkTheme.typography.small,
        )
        Text(
            text = "This is font family text Extra Small Important",
            style = SparkTheme.typography.extraSmallImportant,
        )
        Text(
            text = "This is font family text Extra Small",
            style = SparkTheme.typography.extraSmall,
        )
        Text(
            text = "This is font family text Button",
            style = SparkTheme.typography.button,
        )
    }
}
