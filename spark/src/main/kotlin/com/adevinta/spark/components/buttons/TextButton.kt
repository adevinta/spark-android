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

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.LocalHighlightToken
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

/**
 * The text button is the button for non important actions. The mandatory icon help to indicate that it's a
 * clickable text
 *
 * The minimal usage of the component is the text of the button but you can add an icon or indicate a loading state
 * after a click action for example.
 *
 * @param onClick Will be called when the user clicks the button
 * @param modifier Modifier to be applied to the button
 * @param enabled Controls the enabled state of the button. When `false`, this button will not
 * be clickable
 * @param icon The icon to be displayed at the start or the end of the button container. If null, then will display
 * the text with a underline.
 * @param iconSide If an icon is added, you can configure the side at the start or end of the button
 * @param isLoading show or hide a CircularProgressIndicator at the start that push the content to indicate a
 * loading state
 * @param isDanger The danger button should only be used once per view(screen) (not including a modal dialog),
 * these buttons have the most emphasis.
 */
@Composable
fun TextButton(
    onClick: () -> Unit,
    icon: SparkIcon?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
    isDanger: Boolean = false,
    content: @Composable() (RowScope.() -> Unit),
) {
    SparkButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        elevation = null,
        colors = if (LocalHighlightToken.current) {
            ButtonDefaults.filledTonalButtonColors()
        } else {
            ButtonDefaults.textButtonColors(
                contentColor = if (isDanger) SparkTheme.colors.error else SparkTheme.colors.onSurface,
            )
        },
        contentPadding = SparkButtonDefaults.TextButtonContentPadding,
        icon = icon,
        iconSide = iconSide,
        isLoading = isLoading,
    ) {
        if (icon == null) {
            ProvideTextStyle(value = TextStyle(textDecoration = TextDecoration.Underline)) {
                content()
            }
        } else {
            content()
        }
    }
}

@Preview(
    group = "Buttons",
    name = "TextButton",
)
@Composable
internal fun TextPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        val icon = SparkIcon.Share.Link
        val buttonText = "Text Button"
        TextButton(onClick = {}, icon = icon) {
            Text(buttonText)
        }
        TextButton(onClick = {}, icon = null) {
            Text(buttonText)
        }
        TextButton(
            onClick = {},
            icon = icon,
            enabled = false,
            iconSide = IconSide.END,
        ) {
            Text(buttonText)
        }
        TextButton(
            onClick = {},
            icon = icon,
            iconSide = IconSide.END,
            isDanger = true,
        ) {
            Text("Danger Button")
        }
        TextButton(
            onClick = {},
            icon = icon,
            enabled = false,
            iconSide = IconSide.END,
            isDanger = true,
        ) {
            Text("Danger Button")
        }
    }
}
