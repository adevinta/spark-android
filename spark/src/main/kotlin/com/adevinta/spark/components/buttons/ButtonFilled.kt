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
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.icons.IdentityOutline
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tokens.dim3
import com.adevinta.spark.tokens.disabled

/**
 * The filled button should only be used once per view (not including a modal dialog),
 * these buttons have the most emphasis.
 *
 * The minimal usage of the component is the text of the button but you can add an icon or indicate a loading state
 * after a click action for example.
 *
 * @sample com.adevinta.spark.samples.components.ButtonSample
 *
 * @param onClick Will be called when the user clicks the button
 * @param modifier Modifier to be applied to the button
 * @param size The size of the button
 * @param intent The intent color for the button.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not be clickable
 * @param icon The optional icon to be displayed at the start or the end of the button container.
 * @param iconSide If an icon is added, you can configure the side where is should be displayed, at the start
 * or end of the button
 * @param isLoading show or hide a CircularProgressIndicator at the start that push the content to indicate a
 * loading state
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 */
@Composable
public fun ButtonFilled(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.Medium,
    shape: ButtonShape = SparkButtonDefaults.DefaultShape,
    intent: ButtonIntent = ButtonIntent.Main,
    enabled: Boolean = true,
    icon: SparkIcon? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    val backgroundColor by animateColorAsState(
        targetValue = intent.colors().color,
        label = "background color",
    )
    val contentColor by animateColorAsState(
        targetValue = intent.colors().onColor,
        label = "content color",
    )
    val colors = ButtonDefaults.buttonColors(
        containerColor = backgroundColor,
        contentColor = contentColor,
        disabledContainerColor = backgroundColor.disabled,
        disabledContentColor = contentColor.dim3,
    )
    BaseSparkButton(
        onClick = onClick,
        modifier = modifier,
        size = size,
        shape = shape.shape,
        enabled = enabled,
        elevation = ButtonDefaults.buttonElevation(),
        colors = colors,
        icon = icon,
        iconSide = iconSide,
        isLoading = isLoading,
        interactionSource = interactionSource,
        content = content,
    )
}

/**
 * The filled button should only be used once per view (not including a modal dialog),
 * these buttons have the most emphasis.
 *
 * The minimal usage of the component is the text of the button but you can add an icon or indicate a loading state
 * after a click action for example.
 *
 * @sample com.adevinta.spark.samples.components.ButtonSample
 *
 * @param onClick Will be called when the user clicks the button
 * @param text The text to be displayed in the button
 * @param modifier Modifier to be applied to the button
 * @param size The size of the button
 * @param intent The intent color for the button.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not be clickable
 * @param icon The optional icon to be displayed at the start or the end of the button container.
 * @param iconSide If an icon is added, you can configure the side where is should be displayed, at the start
 * or end of the button
 * @param isLoading show or hide a CircularProgressIndicator at the start that push the content to indicate a
 * loading state
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 */
@Composable
public fun ButtonFilled(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.Medium,
    shape: ButtonShape = SparkButtonDefaults.DefaultShape,
    intent: ButtonIntent = ButtonIntent.Main,
    enabled: Boolean = true,
    icon: SparkIcon? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    atEnd: Boolean = false,
) {
    val backgroundColor by animateColorAsState(
        targetValue = intent.colors().color,
        label = "background color",
    )
    val contentColor by animateColorAsState(
        targetValue = intent.colors().onColor,
        label = "content color",
    )
    val colors = ButtonDefaults.buttonColors(
        containerColor = backgroundColor,
        contentColor = contentColor,
        disabledContainerColor = backgroundColor.disabled,
        disabledContentColor = contentColor.disabled,
    )
    SparkButton(
        onClick = onClick,
        text = text,
        modifier = modifier,
        size = size,
        shape = shape,
        enabled = enabled,
        elevation = ButtonDefaults.buttonElevation(),
        colors = colors,
        icon = icon,
        iconSide = iconSide,
        isLoading = isLoading,
        interactionSource = interactionSource,
        atEnd = atEnd,
    )
}

/**
 * The filled button should only be used once per view (not including a modal dialog),
 * these buttons have the most emphasis.
 *
 * The minimal usage of the component is the text of the button but you can add an icon or indicate a loading state
 * after a click action for example.
 *
 * @param onClick Will be called when the user clicks the button
 * @param text The text to be displayed in the button
 * @param modifier Modifier to be applied to the button
 * @param size The size of the button
 * @param intent The intent color for the button.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not be clickable
 * @param icon The optional icon to be displayed at the start or the end of the button container.
 * @param iconSide If an icon is added, you can configure the side where is should be displayed, at the start
 * or end of the button
 * @param isLoading show or hide a CircularProgressIndicator at the start that push the content to indicate a
 * loading state
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 */
@Composable
public fun ButtonFilled(
    onClick: () -> Unit,
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.Medium,
    intent: ButtonIntent = ButtonIntent.Main,
    enabled: Boolean = true,
    icon: SparkIcon? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    atEnd: Boolean = false,
) {
    val backgroundColor by animateColorAsState(
        targetValue = intent.colors().color,
        label = "background color",
    )
    val contentColor by animateColorAsState(
        targetValue = intent.colors().onColor,
        label = "content color",
    )
    val colors = ButtonDefaults.buttonColors(
        containerColor = backgroundColor,
        contentColor = contentColor,
    )
    SparkButton(
        onClick = onClick,
        text = text,
        modifier = modifier,
        size = size,
        enabled = enabled,
        elevation = ButtonDefaults.buttonElevation(),
        colors = colors,
        icon = icon,
        iconSide = iconSide,
        isLoading = isLoading,
        interactionSource = interactionSource,
        atEnd = atEnd,
    )
}

@Preview(
    group = "Buttons",
    name = "Button Filled",
)
@Composable
internal fun MainButtonPreview() {
    PreviewTheme {
        val icon = SparkIcons.IdentityOutline
        var isLoading by remember { mutableStateOf(false) }
        val buttonText = "Main Button"
        ButtonFilled(
            onClick = {
                isLoading = !isLoading
            },
            text = buttonText,
            isLoading = isLoading,
        )
        ButtonFilled(
            onClick = {
                isLoading = !isLoading
            },
            icon = icon,
            text = buttonText,
            isLoading = isLoading,
        )
        ButtonFilled(
            onClick = { isLoading = !isLoading },
            icon = icon,
            iconSide = IconSide.END,
            isLoading = isLoading,
            enabled = false,
            text = buttonText,
        )
    }
}

@Preview(
    group = "Buttons",
    name = "Button Filled Intents",
)
@Composable
internal fun ButtonFilledIntentPreview() {
    PreviewTheme(
        color = { SparkTheme.colors.backgroundVariant },
    ) {
        val icon = SparkIcons.IdentityOutline
        ButtonIntent.entries.forEach { intent ->
            ButtonFilled(
                text = intent.name,
                onClick = { },
                intent = intent,
                icon = icon,
                iconSide = IconSide.END,
            )
        }
    }
}

@Preview(
    group = "Buttons",
    name = "Button Sizes",
)
@Composable
internal fun ButtonSizePreview() {
    PreviewTheme(
        color = { SparkTheme.colors.backgroundVariant },
    ) {
        val icon = SparkIcons.IdentityOutline
        ButtonSize.entries.forEach { size ->
            ButtonFilled(
                text = size.name,
                onClick = { },
                size = size,
                icon = icon,
                iconSide = IconSide.END,
            )
        }
    }
}
