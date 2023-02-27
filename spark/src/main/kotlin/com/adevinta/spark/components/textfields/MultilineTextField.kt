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

package com.adevinta.spark.components.textfields

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

/**
 * Outlined text input to get an input value from the user.
 * Which can can scroll its content when [value] takes more place than the available width.
 * We can also set the amount of maximum lines it can expand before overscrolling.
 * @param value the input [TextFieldValue] to be shown in the text field
 * @param onValueChange the callback that is triggered when the input service updates values in
 * [TextFieldValue]. An updated [TextFieldValue] comes as a parameter of the callback
 * @param onCancelClick the callback that is triggered when the user try to cancel his input. Most of the times it would
 * require removing the content from The [MultilineTextField]
 * @param modifier a [Modifier] for this text field
 * @param enabled True controls the enabled state of the [TextField]. When `false`, the text field will
 * be neither editable nor focusable, the input of the text field will not be selectable,
 * visually text field will appear in the disabled UI state
 * @param readOnly controls the editable state of the [TextField]. When `true`, the text
 * field can not be modified, however, a user can focus it and copy text from it. Read-only text
 * fields are usually used to display pre-filled forms that user can not edit
 * @param label the optional label to be displayed inside the text field container. The default
 * text style for internal [Text] is [Typography.small] when the text field is in focus and
 * [Typography.large] when the text field is not in focus
 * @param placeholder the optional placeholder to be displayed when the text field is in focus and
 * the input text is empty. The default text style for internal [Text] is [Typography.large]
 * @param helper The optional helper text to be displayed at the bottom outside the text input container that give some
 * informations about expected text
 * @param counter The optional counter to be displayed the the end bottom outside the text input container
 * @param leadingIcon the optional leading icon to be displayed at the beginning of the text field
 * container
 * @param isError indicates if the text field's current value is in error. If set to true, the
 * label, bottom indicator and trailing icon by default will be displayed in error color
 * @param error the optional error text to be displayed at the helper position that give more information about
 * the error, it's displayed only when [isError] is true
 * @param visualTransformation transforms the visual representation of the input [value]
 * For example, you can use [PasswordVisualTransformation][androidx.compose.ui.text.input.PasswordVisualTransformation]
 * to create a password text field. By default no visual transformation is applied
 * @param keyboardOptions software keyboard options that contains configuration such as
 * [KeyboardType] and [ImeAction]
 * @param keyboardActions when the input service emits an IME action, the corresponding callback
 * is called. Note that this IME action may be different from what you specified in
 * [KeyboardOptions.imeAction]
 * @param maxLines the maximum height in terms of maximum number of visible lines. Should be
 * equal or greater than 1
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this TextField. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this TextField in different [Interaction]s.
 */
@Composable
fun MultilineTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    onCancelClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    helper: String? = null,
    counter: TextFieldCharacterCounter? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    error: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(capitalization = KeyboardCapitalization.Sentences),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    maxLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val trailingIconComposable: (@Composable () -> Unit)? = getTrailingIcon(isError, value.text, onCancelClick)

    SparkTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        label = label,
        placeholder = placeholder,
        helper = helper,
        counter = counter,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIconComposable,
        isError = isError,
        error = error,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = false,
        maxLines = maxLines,
        interactionSource = interactionSource,
    )
}

@Composable
private fun getTrailingIcon(
    isError: Boolean,
    value: String,
    onCancelClick: () -> Unit,
): (@Composable () -> Unit)? = when {
    isError -> {
        {
            Icon(
                modifier = Modifier
                    .rotate(180f),
                imageVector = Icons.Default.Info,
                contentDescription = null, // We should walready knnow that we're on error
            )
        }
    }

    value.isNotBlank() -> {
        {
            Icon(
                modifier = Modifier
                    .rotate(45f)
                    .clickable {
                        onCancelClick()
                    }
                    .semantics {
                        role = Role.Button
                    },
                imageVector = Icons.Default.AddCircle,
                contentDescription = "Cancel",
            )
        }
    }

    else -> null
}

/**
 * Outlined text input to get an input value from the user.
 * Which can can scroll its content when [value] takes more place than the available width.
 * We can also set the amount of maximum lines it can expand before overscrolling.
 * @param value the input text to be shown in the text field
 * @param onValueChange the callback that is triggered when the input service updates the text. An
 * updated text comes as a parameter of the callback
 * @param onCancelClick the callback that is triggered when the user try to cancel his input. Most of the times it would
 * require removing the content from The [MultilineTextField]
 * @param modifier a [Modifier] for this text field
 * @param enabled True controls the enabled state of the [TextField]. When `false`, the text field will
 * be neither editable nor focusable, the input of the text field will not be selectable,
 * visually text field will appear in the disabled UI state
 * @param readOnly controls the editable state of the [TextField]. When `true`, the text
 * field can not be modified, however, a user can focus it and copy text from it. Read-only text
 * fields are usually used to display pre-filled forms that user can not edit
 * @param label the optional label to be displayed inside the text field container. The default
 * text style for internal [Text] is [Typography.small] when the text field is in focus and
 * [Typography.large] when the text field is not in focus
 * @param placeholder the optional placeholder to be displayed when the text field is in focus and
 * the input text is empty. The default text style for internal [Text] is [Typography.large]
 * @param helper The optional helper text to be displayed at the bottom outside the text input container that give some
 * informations about expected text
 * @param counter The optional counter to be displayed the the end bottom outside the text input container
 * @param leadingIcon the optional leading icon to be displayed at the beginning of the text field
 * container
 * @param isError indicates if the text field's current value is in error. If set to true, the
 * label, bottom indicator and trailing icon by default will be displayed in error color
 * @param error the optional error text to be displayed at the helper position that give more information about
 * the error, it's displayed only when [isError] is true
 * @param visualTransformation transforms the visual representation of the input [value]
 * For example, you can use [PasswordVisualTransformation][androidx.compose.ui.text.input.PasswordVisualTransformation]
 * to create a password text field. By default no visual transformation is applied
 * @param keyboardOptions software keyboard options that contains configuration such as
 * [KeyboardType] and [ImeAction]
 * @param keyboardActions when the input service emits an IME action, the corresponding callback
 * is called. Note that this IME action may be different from what you specified in
 * [KeyboardOptions.imeAction]
 * @param maxLines the maximum height in terms of maximum number of visible lines. Should be
 * equal or greater than 1
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this TextField. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this TextField in different [Interaction]s.
 */
@Composable
fun MultilineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onCancelClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    helper: String? = null,
    counter: TextFieldCharacterCounter? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    error: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(capitalization = KeyboardCapitalization.Sentences),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    maxLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val trailingIconComposable: (@Composable () -> Unit)? = getTrailingIcon(isError, value, onCancelClick)

    SparkTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        label = label,
        placeholder = placeholder,
        helper = helper,
        counter = counter,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIconComposable,
        isError = isError,
        error = error,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = false,
        maxLines = maxLines,
        interactionSource = interactionSource,
    )
}

@Preview(
    group = "TextFields",
    name = "MultilineTextField",
)
@Composable
internal fun AllStatesMultilineTextFieldPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        val icon = @Composable {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize),
            )
        }

        PreviewTextFields(enabled = true, isError = false, icon = icon)
        PreviewTextFields(enabled = true, isError = true, icon = icon)
        PreviewTextFields(enabled = false, isError = false, icon = icon)
    }
}

@Composable
private fun PreviewTextFields(
    enabled: Boolean,
    isError: Boolean,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    icon: @Composable (() -> Unit),
) {
    Column {
        MultilineTextField(
            value = "",
            onValueChange = {},
            onCancelClick = {},
            enabled = enabled,
            label = "Label",
            placeholder = "Placeholder",
            helper = "helper helper helper helper helper helper helper helper helper=",
            counter = TextFieldCharacterCounter(12, 24),
            leadingIcon = icon,
            isError = isError,
            interactionSource = interactionSource,
        )
        Spacer(modifier = Modifier.size(16.dp))

        MultilineTextField(
            value = "Value Value Value Value Value Value Value Value Value Value Value Value Value Value Value",
            onValueChange = {},
            onCancelClick = {},
            enabled = enabled,
            label = "Label",
            placeholder = "Placeholder",
            counter = TextFieldCharacterCounter(12, 24),
            leadingIcon = icon,
            isError = isError,
            maxLines = 3,
            interactionSource = interactionSource,
        )
        Spacer(modifier = Modifier.size(16.dp))
    }
}
