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

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

@Composable
public fun ButtonOutlined(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.Medium,
    intent: ButtonIntent = ButtonIntent.Secondary,
    enabled: Boolean = true,
    icon: SparkIcon? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
) {
    val contentColor by animateColorAsState(
        targetValue = intent.colors().color,
        label = "content color",
    )
    val colors = ButtonDefaults.outlinedButtonColors(
        contentColor = contentColor,
    )
    SparkButton(
        onClick = onClick,
        text = text,
        modifier = modifier,
        size = size,
        enabled = enabled,
        elevation = null,
        border = SparkButtonDefaults.outlinedBorder(contentColor),
        colors = colors,
        icon = icon,
        iconSide = iconSide,
        isLoading = isLoading,
    )
}

@Composable
public fun ButtonOutlined(
    onClick: () -> Unit,
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.Medium,
    intent: ButtonIntent = ButtonIntent.Secondary,
    enabled: Boolean = true,
    icon: SparkIcon? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
) {
    val contentColor by animateColorAsState(
        targetValue = intent.colors().onColor,
        label = "content color",
    )
    val colors = ButtonDefaults.outlinedButtonColors(
        contentColor = contentColor,
    )
    SparkButton(
        onClick = onClick,
        text = text,
        modifier = modifier,
        size = size,
        enabled = enabled,
        elevation = null,
        border = SparkButtonDefaults.outlinedBorder(contentColor),
        colors = colors,
        icon = icon,
        iconSide = iconSide,
        isLoading = isLoading,
    )
}

/**
 * The secondary button is the standard button for most use cases. The outlined styling
 * places less emphasis on these buttons
 *
 * The minimal usage of the component is the text of the button but you can add an icon or indicate a loading state
 * after a click action for example.
 *
 * @param onClick Will be called when the user clicks the button
 * @param modifier Modifier to be applied to the button
 * @param enabled Controls the enabled state of the button. When `false`, this button will not
 * be clickable
 * @param icon The optional icon to be displayed at the start or the end of the button container, you
 * can use [SparkButtonDefaults.IconSize] as a good default icon size.
 * @param iconSide If an icon is added, you can configure the side at the start or end of the button
 * @param isLoading show or hide a CircularProgressIndicator at the start that push the content to indicate a
 * loading state
 * @param isDanger The danger button should only be used once per view(screen) (not including a modal dialog),
 * these buttons have the most emphasis.
 */
@Deprecated(
    "Use ButtonOutlined instead with secondary intent",
    ReplaceWith(
        "ButtonOutlined(onClick, text, modifier, ButtonIntent.Secondary, enabled, icon, iconSide, isLoading)",
        "com.adevinta.spark.components.buttons.ButtonIntent",
    ),
)
@Composable
public fun SecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: SparkIcon? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
    isDanger: Boolean = false,
    content: @Composable RowScope.() -> Unit,
) {
    val color by animateColorAsState(
        targetValue = if (isDanger) {
            SparkTheme.colors.error
        } else {
            SparkTheme.colors.onSurface
        },
        label = "button color",
    )

    BaseSparkButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        elevation = null,
        border = SparkButtonDefaults.outlinedBorder(color),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = color),
        icon = icon,
        iconSide = iconSide,
        isLoading = isLoading,
        content = content,
    )
}

@Preview(
    group = "Buttons",
    name = "SecondaryButton",
)
@Composable
internal fun SecondaryButtonPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        val icon = SparkIcon.Infos.Camera
        val buttonText = "Secondary Button"
        ButtonOutlined(
            onClick = {},
            text = buttonText,
        )
        ButtonOutlined(
            icon = icon,
            onClick = {},
            text = buttonText,
        )
        ButtonOutlined(
            icon = icon,
            iconSide = IconSide.END,
            enabled = false,
            onClick = {},
            text = buttonText,
        )
    }
}

@Preview(
    group = "Buttons",
    name = "ButtonOutlinedIntents",
)
@Composable
internal fun ButtonOutlinedIntentPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(
        themeVariant = theme,
        color = { SparkTheme.colors.backgroundVariant },
    ) {
        val icon = SparkIcon.Account.Identity
        ButtonIntent.values().forEach { intent ->
            ButtonOutlined(
                text = intent.name,
                onClick = { },
                intent = intent,
                icon = icon,
                iconSide = IconSide.END,
            )
        }
    }
}
