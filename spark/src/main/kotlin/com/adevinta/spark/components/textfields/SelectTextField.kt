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

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

/**
 * Outlined text input to get an input value from a list of elements selectable through a dropdown by the user.
 * @param value the input [TextFieldValue] to be shown in the text field
 * @param onValueChange the callback that is triggered when the input service updates values in
 * [TextFieldValue]. An updated [TextFieldValue] comes as a parameter of the callback
 * @param expanded Whether Dropdown Menu should be expanded or not
 * @param onExpandedChange Executes when the user clicks on the ExposedDropdownMenuBox
 * @param onDismissRequest Called when the user requests to dismiss the menu, such as by
 * tapping outside the menu's bounds
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
 * @param leadingIcon the optional leading icon to be displayed at the beginning of the text field
 * container
 * @param isError indicates if the text field's current value is in error. If set to true, the
 * label, bottom indicator and trailing icon by default will be displayed in error color
 * @param error The optional error text to be displayed at the helper position that give more informations
 * about the error,  it's displayed only when [isError] is true
 * @param visualTransformation transforms the visual representation of the input [value]
 * For example, you can use [PasswordVisualTransformation][androidx.compose.ui.text.input.PasswordVisualTransformation]
 * to create a password text field. By default no visual transformation is applied
 * @param keyboardOptions software keyboard options that contains configuration such as
 * [KeyboardType] and [ImeAction]
 * @param keyboardActions when the input service emits an IME action, the corresponding callback
 * is called. Note that this IME action may be different from what you specified in
 * [KeyboardOptions.imeAction]
 * @param properties PopupProperties for further customization of this popup's behavior.
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this TextField. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this TextField in different [Interaction]s.
 * @param dropdownContent The content to be displayed inside ExposedDropdownMenuBox.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun SelectTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    helper: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    error: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    properties: PopupProperties = PopupProperties(focusable = readOnly, dismissOnClickOutside = readOnly),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    dropdownContent: @Composable ColumnScope.() -> Unit,
) {
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = onExpandedChange) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.menuAnchor(),
            enabled = enabled,
            readOnly = readOnly,
            label = label,
            placeholder = placeholder,
            helper = helper,
            leadingIcon = leadingIcon,
            trailingIcon = {
                SparkSelectTrailingIcon(
                    expanded = expanded,
                )
            },
            isError = isError,
            error = error,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            interactionSource = interactionSource,
        )
        // Use Exposed when b/205589613 is fixed
//        ExposedDropdownMenu(
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onDismissRequest,
            modifier = Modifier.exposedDropdownSize(),
            properties = properties,
            content = dropdownContent,
        )
    }
}

/**
 * Outlined text input to get an input value from a list of elements selectable through a dropdown by the user.
 * @param value the input text to be shown in the text field
 * @param onValueChange the callback that is triggered when the input service updates the text. An
 * updated text comes as a parameter of the callback
 * @param expanded Whether Dropdown Menu should be expanded or not
 * @param onExpandedChange Executes when the user clicks on the ExposedDropdownMenuBox
 * @param onDismissRequest Called when the user requests to dismiss the menu, such as by
 * tapping outside the menu's bounds
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
 * @param leadingIcon the optional leading icon to be displayed at the beginning of the text field
 * container
 * @param isError indicates if the text field's current value is in error. If set to true, the
 * label, bottom indicator and trailing icon by default will be displayed in error color
 * @param error The optional error text to be displayed at the helper position that give more informations
 * about the error,  it's displayed only when [isError] is true
 * @param visualTransformation transforms the visual representation of the input [value]
 * For example, you can use [PasswordVisualTransformation][androidx.compose.ui.text.input.PasswordVisualTransformation]
 * to create a password text field. By default no visual transformation is applied
 * @param keyboardOptions software keyboard options that contains configuration such as
 * [KeyboardType] and [ImeAction]
 * @param keyboardActions when the input service emits an IME action, the corresponding callback
 * is called. Note that this IME action may be different from what you specified in
 * [KeyboardOptions.imeAction]
 * @param properties commentCountPopupProperties for further customization of this popup's behavior.
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this TextField. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this TextField in different [Interaction]s.
 * @param dropdownContent The content to be displayed inside ExposedDropdownMenuBox.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun SelectTextField(
    value: String,
    onValueChange: (String) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    helper: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    error: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    properties: PopupProperties = PopupProperties(focusable = readOnly, dismissOnClickOutside = readOnly),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    dropdownContent: @Composable ColumnScope.() -> Unit,
) {
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = onExpandedChange) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.menuAnchor(),
            enabled = enabled,
            readOnly = readOnly,
            label = label,
            placeholder = placeholder,
            helper = helper,
            leadingIcon = leadingIcon,
            trailingIcon = {
                SparkSelectTrailingIcon(
                    expanded = expanded,
                )
            },
            isError = isError,
            error = error,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            interactionSource = interactionSource,
        )
        // Use Exposed when b/205589613 is fixed
//        ExposedDropdownMenu(
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onDismissRequest,
            modifier = Modifier.exposedDropdownSize(),
            properties = properties,
            content = dropdownContent,
        )
    }
}

/**
 * trailing icon for Exposed Dropdown Menu.
 *
 * @param expanded Whether [ExposedDropdownMenuBoxScope.ExposedDropdownMenu]
 * is expanded or not. Affects the appearance of the icon.
 * @param onIconClick Called when the icon was clicked.
 */
@ExperimentalSparkApi
@Composable
public fun SparkSelectTrailingIcon(
    expanded: Boolean,
    modifier: Modifier = Modifier,
    onIconClick: () -> Unit = {},
) {
    // Clear semantics here as otherwise icon will be a11y focusable but without an
    // action. When there's an API to check if Talkback is on, developer will be able to
    // expand the menu on icon click in a11y mode only esp. if using their own custom
    // trailing icon.
    IconButton(onClick = onIconClick, modifier = modifier.clearAndSetSemantics { }) {
        Icon(
            Icons.Filled.KeyboardArrowDown, // TODO scott.rayapoulle.ext-12/07/2022: Use or create ImageVector variant of this Spark icon
            "Trailing icon for exposed dropdown menu",
            Modifier
                .size(ButtonDefaults.IconSize)
                .rotate(
                    if (expanded) 180f else 360f,
                ),
        )
    }
}

@Preview(
    group = "TextFields",
    name = "SelectTextField",
)
@Composable
internal fun AllStatesSelectTextFieldPreview(
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

        PreviewSelectTextFields(enabled = true, isError = false, icon = icon)
        PreviewSelectTextFields(enabled = true, isError = true, icon = icon)
        PreviewSelectTextFields(enabled = false, isError = false, icon = icon)
    }
}

@Composable
internal fun PreviewSelectTextFields(
    enabled: Boolean,
    isError: Boolean,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    icon: @Composable (() -> Unit),
) {
    Column {
        SelectTextField(
            value = "",
            onValueChange = {},
            enabled = enabled,
            isError = isError,
            label = "Label",
            placeholder = "Placeholder",
            helper = "helperhelperh elperhelperh elperhelp erhelperhelperhe lperhel perhelper helper helper",
            leadingIcon = icon,
            interactionSource = interactionSource,
            expanded = false,
            onExpandedChange = {},
            onDismissRequest = {},
            dropdownContent = {},
        )
        Spacer(modifier = Modifier.size(16.dp))

        SelectTextField(
            value = "Value",
            onValueChange = {},
            enabled = enabled,
            isError = isError,
            label = "Label",
            placeholder = "Placeholder",
            leadingIcon = icon,
            interactionSource = interactionSource,
            expanded = false,
            onExpandedChange = {},
            onDismissRequest = {},
            dropdownContent = {},
        )
        Spacer(modifier = Modifier.size(16.dp))
    }
}
