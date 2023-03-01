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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.preview.SparkPreviewParam
import com.adevinta.spark.tools.preview.SparkPreviewParamProvider

/**
 * The primary button should only be used once per view (not including a modal dialog),
 * these buttons have the most emphasis.
 *
 * The minimal usage of the component is the text of the button but you can add an icon or indicate a loading state
 * after a click action for example.
 *
 * @param onClick Will be called when the user clicks the button
 * @param modifier Modifier to be applied to the button
 * @param enabled Controls the enabled state of the button. When `false`, this button will not
 * be clickable
 * @param icon The optional icon to be displayed at the start or the end of the button container, you can
 * use [SparkButtonDefaults.IconSize] as a good default icon size.
 * @param iconSide If an icon is added, you can configure the side at the start or end of the button
 * @param isLoading show or hide a CircularProgressIndicator at the start that push the content to indicate a
 * loading state
 * @param isDanger The danger button should only be used once per view(screen) (not including a modal dialog),
 * these buttons have the most emphasis.
 */
@Composable
public fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: SparkIcon? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
    isDanger: Boolean = false,
    content: @Composable RowScope.() -> Unit,
) {
    val colors = if (isDanger) {
        ButtonDefaults.buttonColors(
            containerColor = SparkTheme.colors.error,
            contentColor = SparkTheme.colors.onError,
        )
    } else {
        ButtonDefaults.buttonColors()
    }
    SparkButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        elevation = ButtonDefaults.buttonElevation(),
        colors = colors,
        contentPadding = SparkButtonDefaults.ButtonContentPadding,
        icon = icon,
        iconSide = iconSide,
        isLoading = isLoading,
        content = content,
    )
}

@Preview(
    group = "Buttons",
    name = "PrimaryButton",
)
@Composable
internal fun PrimaryButtonPreview(
    @PreviewParameter(SparkPreviewParamProvider::class) param: SparkPreviewParam,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        val icon = SparkIcon.Account.Identity
        var isLoading by remember { mutableStateOf(false) }
        val buttonText = "Primary Button"
        PrimaryButton(
            onClick = {
                isLoading = !isLoading
            },
            isLoading = isLoading,
        ) {
            Text(buttonText)
        }
        PrimaryButton(
            onClick = {
                isLoading = !isLoading
            },
            icon = icon,
            isLoading = isLoading,
        ) {
            Text(buttonText)
        }
        PrimaryButton(
            onClick = { isLoading = !isLoading },
            icon = icon,
            iconSide = IconSide.END,
            isLoading = isLoading,
            enabled = false,
        ) {
            Text(buttonText)
        }
        PrimaryButton(
            onClick = { isLoading = !isLoading },
            icon = icon,
            iconSide = IconSide.END,
            isLoading = isLoading,
            isDanger = true,
        ) {
            Text("Danger Button")
        }
        PrimaryButton(
            onClick = { isLoading = !isLoading },
            icon = icon,
            iconSide = IconSide.END,
            isLoading = isLoading,
            enabled = false,
            isDanger = true,
        ) {
            Text("Danger Button")
        }
    }
}
