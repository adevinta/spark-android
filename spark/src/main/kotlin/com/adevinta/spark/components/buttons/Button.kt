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
package com.adevinta.spark.components.buttons

import androidx.annotation.VisibleForTesting
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.LocalLegacyStyle
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.buttons.SparkButtonTags.TAG_PROGRESS_INDICATOR
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay

@InternalSparkApi
@Composable
internal fun BaseSparkButton(
    onClick: () -> Unit,
    colors: ButtonColors,
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.Medium,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    icon: SparkIcon? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(height = size.height)
            .sparkUsageOverlay(),
        enabled = enabled,
        elevation = elevation,
        shape = if (LocalLegacyStyle.current) SparkTheme.shapes.extraSmall else SparkTheme.shapes.large,
        border = border,
        colors = colors,
        interactionSource = interactionSource,
        contentPadding = SparkButtonDefaults.buttonContentPadding(size),
    ) {
        AnimatedVisibility(visible = isLoading) {
            Row {
                Box(Modifier.size(SparkButtonDefaults.IconSize)) {
                    CircularProgressIndicator(
                        Modifier.testTag(TAG_PROGRESS_INDICATOR),
                        color = LocalContentColor.current,
                        strokeWidth = 2.dp,
                    )
                }
                Spacer(Modifier.width(8.dp))
            }
        }
        if (icon != null && iconSide == IconSide.START) {
            Icon(
                sparkIcon = icon,
                modifier = Modifier
                    .size(SparkButtonDefaults.IconSize)
                    .testTag("buttonIcon"),
                contentDescription = null, // button text should be enough for context
            )
            Spacer(Modifier.width(SparkButtonDefaults.IconSpacing))
        }
        content()
        if (icon != null && iconSide == IconSide.END) {
            Spacer(Modifier.width(SparkButtonDefaults.IconSpacing))
            Icon(
                sparkIcon = icon,
                modifier = Modifier
                    .size(SparkButtonDefaults.IconSize)
                    .testTag("buttonIcon"),
                contentDescription = null, // button text should be enough for context
            )
        }
    }
}

@InternalSparkApi
@Composable
internal fun SparkButton(
    text: String,
    onClick: () -> Unit,
    colors: ButtonColors,
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.Medium,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    icon: SparkIcon? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    BaseSparkButton(
        onClick = onClick,
        modifier = modifier,
        size = size,
        enabled = enabled,
        elevation = elevation,
        border = border,
        colors = colors,
        icon = icon,
        iconSide = iconSide,
        isLoading = isLoading,
        interactionSource = interactionSource,
    ) {
        Text(
            text = text,
            style = SparkTheme.typography.callout,
        )
    }
}

@InternalSparkApi
@Composable
internal fun SparkButton(
    text: AnnotatedString,
    onClick: () -> Unit,
    colors: ButtonColors,
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.Medium,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    icon: SparkIcon? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    BaseSparkButton(
        onClick = onClick,
        modifier = modifier,
        size = size,
        enabled = enabled,
        elevation = elevation,
        border = border,
        colors = colors,
        icon = icon,
        iconSide = iconSide,
        isLoading = isLoading,
        interactionSource = interactionSource,
    ) {
        Text(
            text = text,
            style = SparkTheme.typography.callout,
        )
    }
}

@VisibleForTesting
public object SparkButtonTags {
    public const val TAG_PROGRESS_INDICATOR: String = "progress_indicator"
}

public enum class IconSide { START, END }

public object SparkButtonDefaults {

    /**
     * The default size of the icon when used inside a [SparkButtonTags].
     */
    public val IconSize: Dp = 16.dp

    /**
     * The default size of the spacing between an icon and a text when they used inside a [SparkButtonTags].
     */
    internal val IconSpacing: Dp = ButtonDefaults.IconSpacing

    /**
     * The default content padding used by [TextButton]
     */
    internal fun buttonContentPadding(size: ButtonSize) = PaddingValues(
        horizontal = 16.dp,
        vertical = size.contentVerticalPadding,
    )

    /**
     * The default border of [ButtonOutlined]
     */
    @Composable
    internal fun outlinedBorder(color: Color): BorderStroke = BorderStroke(
        width = if (LocalLegacyStyle.current) LegacyOutlinedBorderSize else OutlinedBorderSize,
        color = color,
    )

    private val OutlinedBorderSize = 2.0.dp
    private val LegacyOutlinedBorderSize = 1.0.dp
}

@Preview
@Composable
private fun SparkButtonPreview() {
    PreviewTheme(
        color = { SparkTheme.colors.backgroundVariant },
    ) {
        val icon = SparkIcon.Account.Identity
        ButtonSize.values().forEach { size ->
            SparkButton(
                text = "Button",
                onClick = { },
                colors = ButtonDefaults.buttonColors(),
                size = size,
                icon = icon,
                iconSide = IconSide.END,
            )
        }
    }
}
