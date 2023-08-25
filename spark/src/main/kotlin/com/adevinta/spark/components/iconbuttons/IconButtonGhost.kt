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
package com.adevinta.spark.components.iconbuttons

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.components.progress.Spinner
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.icons.WheelOutline
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

/**
 * Icon buttons help people take supplementary actions with a single tap. They’re used when a
 * compact button is required, such as in a toolbar or image list.
 *
 * @param icon a content to be drawn inside the IconButton
 * @param onClick called when this icon button is clicked
 * @param modifier the [Modifier] to be applied to this icon button
 * @param intent one of [IconButtonIntent] values that will be used to determine [IconButtonColors] to be applied
 * @param enabled controls the enabled state of this icon button. When `false`, this component will
 * not respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param isLoading show or hide a [Spinner] instead of the [icon] to indicate a
 * loading state
 * @param shape to be applied to the IconButton background. It should be one of [IconButtonShape] values
 * @param size one of the [IconButtonSize] values that sets width and height of the IconButton
 * @param contentDescription text used by accessibility services to describe what this icon button
 * represents. This text should be localized, such as by using [androidx.compose.ui.res.stringResource] or similar
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this icon button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this icon button in different states.
 */
@Composable
public fun IconButtonGhost(
    icon: SparkIcon,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    intent: IconButtonIntent = IconButtonDefaults.DefaultIntent,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    shape: IconButtonShape = IconButtonDefaults.DefaultShape,
    size: IconButtonSize = IconButtonDefaults.DefaultSize,
    contentDescription: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val colors = IconButtonDefaults.ghostIconButtonColors(intent.colors())
    SparkIconButton(
        icon = icon,
        onClick = onClick,
        modifier = modifier,
        colors = colors,
        enabled = enabled,
        isLoading = isLoading,
        shape = shape,
        size = size,
        contentDescription = contentDescription,
        interactionSource = interactionSource,
    )
}

@Preview(
    group = "IconButtons",
    name = "IconButton Ghost Medium",
)
@Composable
internal fun IconButtonGhostMediumPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        IconButtonPreview { intent, shape ->
            IconButtonGhostPair(
                intent = intent,
                size = IconButtonSize.Medium,
                shape = shape,
            )
        }
    }
}

@Composable
internal fun IconButtonGhostPair(
    intent: IconButtonIntent,
    size: IconButtonSize,
    shape: IconButtonShape,
) {
    val icon = SparkIcons.WheelOutline
    val contentDescription = "Localized description"
    Row {
        listOf(true, false).forEach { enabled ->
            IconButtonGhost(
                icon = icon,
                onClick = {},
                intent = intent,
                enabled = enabled,
                contentDescription = contentDescription,
                size = size,
                shape = shape,
            )
        }
    }
}
