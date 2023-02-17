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
import com.adevinta.spark.utils.ShowkaseComposable

internal val tile1Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 24.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 28.sp,
    letterSpacing = 0.sp,
)

internal val title2Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 26.sp,
    letterSpacing = 0.15.sp,
)

internal val title3Type = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 18.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 18.sp,
    letterSpacing = 0.15.sp,
)

internal val largeImportantType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 16.sp,
    letterSpacing = 0.15.sp,
)

internal val largeType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp,
)

internal val bodyImportantType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 20.sp,
    letterSpacing = 0.1.sp,
)

internal val bodyType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 20.sp,
    letterSpacing = 0.25.sp,
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

internal val extraSmallImportantType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 10.sp,
    fontWeight = FontWeight.SemiBold,
    lineHeight = 10.sp,
)

internal val extraSmallType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 10.sp,
    fontWeight = FontWeight.Normal,
    lineHeight = 10.sp,
)

internal val buttonType = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold,
    letterSpacing = 1.25.sp,
)

public fun sparkTypography(
    fontFamily: FontFamily = FontFamily.Default,
    title1: TextStyle = tile1Type.copy(fontFamily = fontFamily),
    title2: TextStyle = title2Type.copy(fontFamily = fontFamily),
    title3: TextStyle = title3Type.copy(fontFamily = fontFamily),
    largeImportant: TextStyle = largeImportantType.copy(fontFamily = fontFamily),
    large: TextStyle = largeType.copy(fontFamily = fontFamily),
    bodyImportant: TextStyle = bodyImportantType.copy(fontFamily = fontFamily),
    body: TextStyle = bodyType.copy(fontFamily = fontFamily),
    smallImportant: TextStyle = smallImportantType.copy(fontFamily = fontFamily),
    small: TextStyle = smallType.copy(fontFamily = fontFamily),
    extraSmallImportant: TextStyle = extraSmallImportantType.copy(fontFamily = fontFamily),
    extraSmall: TextStyle = extraSmallType.copy(fontFamily = fontFamily),
    button: TextStyle = buttonType.copy(fontFamily = fontFamily),
): SparkTypography = SparkTypography(
    title1 = title1,
    title2 = title2,
    title3 = title3,
    largeImportant = largeImportant,
    large = large,
    bodyImportant = bodyImportant,
    body = body,
    smallImportant = smallImportant,
    small = small,
    extraSmallImportant = extraSmallImportant,
    extraSmall = extraSmall,
    button = button,
)

@Immutable
public data class SparkTypography(
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val largeImportant: TextStyle,
    val large: TextStyle,
    val bodyImportant: TextStyle,
    val body: TextStyle,
    val smallImportant: TextStyle,
    val small: TextStyle,
    val extraSmallImportant: TextStyle,
    val extraSmall: TextStyle,
    val button: TextStyle,
)

@Suppress("CompositionLocalAllowlist") // We need it to get access to our typo like Material
internal val LocalSparkTypography = staticCompositionLocalOf { sparkTypography() }

public fun SparkTypography.asMaterial3Typography(): Typography = Typography(
    headlineSmall = title1,
    titleLarge = title2,
    titleMedium = large,
    titleSmall = body,
    bodyLarge = large,
    bodyMedium = body,
    labelLarge = button,
    bodySmall = small,
    labelSmall = extraSmall,
)

@Preview(
    group = "Tokens",
    name = "Spark Typography",
)
@ShowkaseComposable(skip = true)
@Composable
internal fun TextPreview(
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
