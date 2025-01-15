/*
 * Copyright (c) 2025 Adevinta
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

package com.adevinta.spark.components.stepper

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.R
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.SparkTheme.colors
import com.adevinta.spark.components.stepper.internal.SparkStepper
import com.adevinta.spark.components.stepper.internal.stepperSemantics
import com.adevinta.spark.components.stepper.internal.supportText
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.FormFieldStatus
import com.adevinta.spark.components.textfields.TextFieldDefault
import com.adevinta.spark.components.textfields.sparkOutlinedTextFieldColors
import com.adevinta.spark.tokens.EmphasizeDim3
import com.adevinta.spark.tokens.dim1
import com.adevinta.spark.tools.modifiers.invisibleSemantic

/**
 * A quantity allows users to change the number of items.
 * @param value Value of the quantity picker
 * @param modifier The [Modifier] to be applied to the component
 * @param addEnabled Whether add button is enable or not
 * @param subtractEnabled Whether substract button is enable or not
 * @param editTextEnabled Whether textField is enable or not
 * @param isFlexible if true, component will fill max width, otherwise get default width
 * @param helperText Helper text displayed at the QuantityPicker's bottom
 * @param keyboardOptions Software keyboard options that contains such as KeyboardType and ImeAction
 * @param keyboardActions When the text input emit an IME action, the corresponding callback is called
 * @param colors The color to notify your user if they are in normal or error state
 * @param sizes Sizes to be applied to the QuantityPicker. (VitaminQuantitiesSizes.primary())
 * @param onAddClicked The callback to be called when add button is clicked
 * @param onSubtractClicked The callback to be called when substract button is clicked
 * @param onValueChange The callback to be called when text is set into textfield
 */
@Composable
public fun Stepper(
    value: Int,
    onValueChange: (Int) -> Unit,
    helperText: String?,
    label: String,
    modifier: Modifier = Modifier,
    range: IntRange = 0..10,
    enabled: Boolean = true,
    required: Boolean = false,
    status: FormFieldStatus? = null,
    isFlexible: Boolean = false,
    testTag: String? = null,
) {
    val colors = sparkOutlinedTextFieldColors(
        unfocusedBorderColor = SparkTheme.colors.outline,
    )
    val mandatoryDescription = if (required) stringResource(id = R.string.spark_textfield_content_description) else null
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .semantics {
                text = listOfNotNull(label, mandatoryDescription, helperText)
                    .joinToString(separator = " ")
                    .let(::AnnotatedString)
            }
            .stepperSemantics(value, onValueChange, range, enabled),
    ) {
        Row(modifier = Modifier.invisibleSemantic()) {
            Text(
                text = label,
                modifier = Modifier.weight(weight = 1f, fill = false),
                style = SparkTheme.typography.body2,
                color = colors.labelColor(enabled, interactionSource).value,
            )
            if (required) {
                EmphasizeDim3 {
                    Text(
                        text = "*",
                        modifier = Modifier.padding(start = 4.dp),
                        style = SparkTheme.typography.caption,
                        color = SparkTheme.colors.onSurface.dim1,
                    )
                }
            }
        }
        helperText?.let {
            val stateIcon = TextFieldDefault.getStatusIcon(state = status)
            val color by colors.supportingTextColor(enabled, status, interactionSource)
            ProvideTextStyle(SparkTheme.typography.caption) {
                CompositionLocalProvider(
                    LocalContentColor provides color,
                ) {
                    supportText(
                        helper = it,
                        status = status,
                        stateMessage = "TODO()",
                        stateIcon = stateIcon,
                    )?.invoke()
                }
            }
        }

        SparkStepper(
            value = value,
            onValueChange = onValueChange,
            range = range,
            enabled = enabled,
            isFlexible = isFlexible,
            testTag = testTag,
            status = status,
            allowSemantics = false,
        )


    }
}

@Composable
public fun Stepper(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    range: IntRange = 0..10,
    enabled: Boolean = true,
    status: FormFieldStatus? = null,
    isFlexible: Boolean = false,
    testTag: String? = null,
    allowSemantics: Boolean = true,
) {
    SparkStepper(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        range = range,
        enabled = enabled,
        status = status,
        isFlexible = isFlexible,
        testTag = testTag,
        allowSemantics = allowSemantics,
    )
}


@Preview
@Composable
private fun StepperPreview() {
    PreviewTheme {
        Stepper(
            value = 1234,
            onValueChange = {},
        )
        Stepper(
            value = 1,
            onValueChange = {},
            status = FormFieldStatus.Error,
            label = "Label",
            helperText = "helper message",
        )
        Stepper(
            value = -1,
            onValueChange = {},
            status = FormFieldStatus.Alert,
            label = "Label",
            helperText = "helper message",
        )
        Stepper(
            value = -1234,
            onValueChange = {},
            status = FormFieldStatus.Success,
            label = "Label",
            helperText = "helper message",
        )
    }

}
