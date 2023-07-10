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

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.LocalLegacyStyle
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.R
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.icons.IconSize
import com.adevinta.spark.icons.Check
import com.adevinta.spark.icons.InfoOutline
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.icons.WarningOutline
import com.adevinta.spark.tokens.EmphasizeDim3
import com.adevinta.spark.tools.modifiers.SlotArea
import com.adevinta.spark.tools.modifiers.ifNotNull
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay

// FIXME: Duplicate of Material OutlinedTextField while the counter is not supported on their end
// b/236761202
@InternalSparkApi
@Composable
internal fun SparkTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    enabled: Boolean,
    readOnly: Boolean,
    required: Boolean,
    label: String?,
    placeholder: String?,
    helper: String?,
    counter: TextFieldCharacterCounter?,
    leadingContent: @Composable (() -> Unit)?,
    trailingContent: @Composable (() -> Unit)?,
    state: TextFieldState?,
    stateMessage: String?,
    visualTransformation: VisualTransformation,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    maxLines: Int,
    minLines: Int,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val colors = sparkOutlinedTextFieldColors()
    CompositionLocalProvider(LocalTextSelectionColors provides colors.selectionColors) {
        @OptIn(ExperimentalMaterial3Api::class)
        BasicTextField(
            value = value,
            modifier = modifier
                .ifNotNull(label) {
                    // Merge semantics at the beginning of the modifier chain to ensure padding is
                    // considered part of the text field.
                    this
                        .semantics(mergeDescendants = true) {}
                        .padding(top = OutlinedTextFieldTopPadding)
                }
                .defaultMinSize(
                    minWidth = TextFieldDefaults.MinWidth,
                    minHeight = if (LocalLegacyStyle.current) TextFieldDefaults.MinHeight else TextFieldMinHeight,
                )
                .sparkUsageOverlay(),
            onValueChange = onValueChange,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = SparkTheme.typography.body1.merge(TextStyle(colors.textColor(enabled).value)),
            cursorBrush = SolidColor(colors.cursorColor(state).value),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            interactionSource = interactionSource,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            decorationBox = @Composable { innerTextField ->
                val counterComposable: @Composable (() -> Unit)? = counter?.let {
                    { Text(text = "${counter.count}/${counter.maxCharacter}") }
                }
                val supportingTextComposable: @Composable (() -> Unit)? =
                    if (stateMessage != null && state != null) {
                        { Text(text = stateMessage) }
                    } else if (helper != null) {
                        { Text(text = helper) }
                    } else {
                        null
                    }

                SparkDecorationBox(
                    value = value.text,
                    innerTextField = innerTextField,
                    visualTransformation = visualTransformation,
                    label = { Label(text = label, required = required) },
                    interactionSource = interactionSource,
                    colors = colors,
                    placeholder = { PlaceHolder(text = placeholder) },
                    supportingText = supportingTextComposable,
                    counter = counterComposable,
                    leadingIcon = leadingContent,
                    trailingIcon = trailingContent,
                    singleLine = singleLine,
                    enabled = enabled,
                    state = state,
                ) {
                    OutlinedBorderContainerBox(
                        enabled,
                        state,
                        interactionSource,
                        colors,
                    )
                }
            },
            onTextLayout = {},
        )
    }
}

@InternalSparkApi
@Composable
internal fun SparkTextField(
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean,
    readOnly: Boolean,
    required: Boolean,
    label: String?,
    placeholder: String?,
    helper: String?,
    counter: TextFieldCharacterCounter?,
    leadingIcon: @Composable (() -> Unit)?, // Should we rename it to leadingContent?
    trailingIcon: @Composable (() -> Unit)?, // Should we rename it to trailingContent?
    state: TextFieldState?,
    stateMessage: String?,
    visualTransformation: VisualTransformation,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    maxLines: Int,
    minLines: Int,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val colors = sparkOutlinedTextFieldColors()
    CompositionLocalProvider(LocalTextSelectionColors provides colors.selectionColors) {
        @OptIn(ExperimentalMaterial3Api::class)
        BasicTextField(
            value = value,
            modifier = if (label != null) {
                // Merge semantics at the beginning of the modifier chain to ensure padding is
                // considered part of the text field.
                modifier
                    .semantics(mergeDescendants = true) {}
                    .padding(top = OutlinedTextFieldTopPadding)
            } else {
                modifier
            }
                .defaultMinSize(
                    minWidth = TextFieldDefaults.MinWidth,
                    minHeight = if (LocalLegacyStyle.current) TextFieldDefaults.MinHeight else TextFieldMinHeight,
                )
                .sparkUsageOverlay(),
            onValueChange = onValueChange,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = SparkTheme.typography.body1.merge(TextStyle(colors.textColor(enabled).value)),
            cursorBrush = SolidColor(colors.cursorColor(state).value),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            interactionSource = interactionSource,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            decorationBox = @Composable { innerTextField ->
                val counterComposable: @Composable (() -> Unit)? = counter?.let {
                    { Text(text = "${counter.count}/${counter.maxCharacter}") }
                }
                val supportingTextComposable: @Composable (() -> Unit)? =
                    if (stateMessage != null && state != null) {
                        { Text(text = stateMessage) }
                    } else if (helper != null) {
                        { Text(text = helper) }
                    } else {
                        null
                    }

                SparkDecorationBox(
                    value = value,
                    innerTextField = innerTextField,
                    visualTransformation = visualTransformation,
                    label = { Label(text = label, required = required) },
                    interactionSource = interactionSource,
                    colors = colors,
                    placeholder = { PlaceHolder(text = placeholder) },
                    supportingText = supportingTextComposable,
                    counter = counterComposable,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    singleLine = singleLine,
                    enabled = enabled,
                    state = state,
                ) {
                    OutlinedBorderContainerBox(
                        enabled,
                        state,
                        interactionSource,
                        colors,
                    )
                }
            },
            onTextLayout = {},
        )
    }
}

/**
 * Composable that draws a default container for [SparkTextField] with a border stroke. You
 * can use it to draw a border stroke in your custom text field based on
 * [OutlinedBorderContainerBox]. The [SparkTextField] applies it automatically.
 *
 * @param enabled whether the text field is enabled
 * @param isError whether the text field's current value is in error
 * @param interactionSource the [InteractionSource] of this text field. Helps to determine if
 * the text field is in focus or not
 * @param colors [TextFieldColors] used to resolve colors of the text field
 */
@ExperimentalMaterial3Api
@Composable
private fun OutlinedBorderContainerBox(
    enabled: Boolean,
    state: TextFieldState?,
    interactionSource: InteractionSource,
    colors: DefaultSparkTextFieldColors,
) {
    val shape = if (LocalLegacyStyle.current) SparkTheme.shapes.extraSmall else SparkTheme.shapes.large
    val borderStroke = animateBorderStrokeAsState(
        enabled,
        state,
        interactionSource,
        colors,
    )
    Box(
        Modifier
            .border(borderStroke.value, shape)
            .background(colors.containerColor().value, shape),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun animateBorderStrokeAsState(
    enabled: Boolean,
    state: TextFieldState?,
    interactionSource: InteractionSource,
    colors: DefaultSparkTextFieldColors,
): State<BorderStroke> {
    val focused by interactionSource.collectIsFocusedAsState()
    val indicatorColor = colors.indicatorColor(enabled, state, interactionSource)
    val targetThickness = if (focused || state != null) {
        TextFieldDefaults.FocusedBorderThickness
    } else {
        TextFieldDefaults.UnfocusedBorderThickness
    }
    val animatedThickness = if (enabled) {
        animateDpAsState(targetThickness, tween(durationMillis = 150))
    } else {
        rememberUpdatedState(TextFieldDefaults.UnfocusedBorderThickness)
    }
    return rememberUpdatedState(
        BorderStroke(animatedThickness.value, SolidColor(indicatorColor.value)),
    )
}

@Stable
public data class TextFieldCharacterCounter(
    val count: Int,
    val maxCharacter: Int,
)

@Composable
private fun Label(text: String?, required: Boolean) {
    if (text != null) {
        Row(modifier = Modifier.semantics(mergeDescendants = true) {}) {
            Text(text = text)
            if (required) {
                val mandatoryDescription = stringResource(id = R.string.spark_textfield_content_description)
                EmphasizeDim3 {
                    Text(
                        text = "*",
                        modifier = Modifier
                            .semantics {
                                contentDescription = mandatoryDescription
                            }
                            .padding(start = 4.dp),
                    )
                }
            }
        }
    }
}

@Composable
private fun PlaceHolder(text: String?) {
    if (text != null) {
        Box {
            Text(text = text)
        }
    }
}

internal object TextFieldDefault {
    @Composable
    internal fun getTrailingContent(
        state: TextFieldState?,
        trailingIcon: (@Composable () -> Unit)?,
    ): (@Composable () -> Unit)? = when {
        state != null -> {
            {
                val icon = when (state) {
                    TextFieldState.Error -> SparkIcons.InfoOutline
                    TextFieldState.Alert -> SparkIcons.WarningOutline
                    TextFieldState.Success -> SparkIcons.Check
                }
                Icon(
                    sparkIcon = icon,
                    contentDescription = null,
                    size = IconSize.Medium,
                )
            }
        }

        else -> trailingIcon
    }
}

/*
This padding is used to allow label not overlap with the content above it. This 8.dp will work
for default cases when developers do not override the label's font size. If they do, they will
need to add additional padding themselves
*/
internal val OutlinedTextFieldTopPadding = 8.dp

// The dMaterial height is 56.dp with 16.dp vertical padding, since we want 12.dp for ours we subtract 8.dp
private val TextFieldMinHeight = 44.dp

@Preview(
    group = "TextFields",
    name = "TextField Slots",
)
@Composable
internal fun TextFieldSlotsPreview() {
    PreviewTheme {
        val icon = @Composable {
            SlotArea(color = LocalContentColor.current) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                )
            }
        }

        TextField(
            value = "din.djarin@adevinta.com",
            onValueChange = {},
            enabled = true,
            required = true,
            label = "Label",
            placeholder = "Placeholder",
            helper = "helper helper",
            leadingContent = icon,
            trailingContent = icon,
        )

        TextField(
            value = "din.djarin@adevinta.com",
            onValueChange = {},
            enabled = true,
            required = true,
            label = "Label",
            placeholder = "Placeholder",
            leadingContent = icon,
            trailingContent = icon,
        )
    }
}
