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

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.progressSemantics
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.setProgress
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.R
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.stepper.internal.SparkStepper
import com.adevinta.spark.components.stepper.internal.supportText
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.FormFieldStatus
import com.adevinta.spark.components.textfields.TextFieldDefault
import com.adevinta.spark.components.textfields.sparkOutlinedTextFieldColors
import com.adevinta.spark.tokens.EmphasizeDim3
import com.adevinta.spark.tokens.dim1
import com.adevinta.spark.tokens.dim5
import com.adevinta.spark.tokens.transparent
import com.adevinta.spark.tools.modifiers.invisibleSemantic
import kotlin.math.roundToInt

/**
 * [Stepper] come with decrease and increase buttons on either side of the selected value. A minimum and maximum value
 * need to be provided
 * @param value Value of the quantity picker
 * @param onValueChange The callback to be called when [value] has been incremented or decremented
 * @param modifier The [Modifier] to be applied to the component
 * @param range The min/max accepted value by the [Stepper] until it blocks increments and decrements
 * @param enabled True controls the enabled state of the [Stepper]. When `false`, the stepper will
 * be neither editable nor focusable, visually stepper will appear in the disabled UI state
 * @param status indicates the validation state of the stepper. The outline is tinted by the state color
 * @param flexible if true, component will fill max width, otherwise get default width
 * @param testTag A test tag to find the internal [Stepper] inside the [StepperForm] in a test
 */
@Composable
public fun Stepper(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    range: IntRange = 0..10,
    suffix: String = "",
    enabled: Boolean = true,
    status: FormFieldStatus? = null,
    flexible: Boolean = false,
    testTag: String? = null,
    allowSemantics: Boolean = true,
) {
    SparkStepper(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        range = range,
        suffix = suffix,
        enabled = enabled,
        status = status,
        flexible = flexible,
        testTag = testTag,
        allowSemantics = allowSemantics,
    )
}

/**
 * Variant of [Stepper] that insert it with a label and a helper.
 * @param value Value of the quantity picker
 * @param onValueChange The callback to be called when [value] has been incremented or decremented
 * @param modifier The [Modifier] to be applied to the component
 * @param label the optional label to be displayed
 * @param helper The optional helper text to be displayed at the bottom outside the text input container that give some
 * information about expected text
 * @param range The min/max accepted value by the [Stepper] until it blocks increments and decrements
 * @param suffix optional string displayed after [value]
 * @param enabled True controls the enabled state of the [Stepper]. When `false`, the stepper will
 * be neither editable nor focusable, visually stepper will appear in the disabled UI state
 * @param required add an asterisk to the label to indicate that this field is required and read it as "label mandatory field"
 * but doesn't do anything else so it's up to the developer to handle the behavior
 * @param status indicates the validation state of the stepper. The outline is tinted by the state color
 * @param flexible if true, component will fill max width, otherwise get default width
 * @param testTag A test tag to find the internal [Stepper] inside the [StepperForm] in a test
 */
@Composable
public fun StepperForm(
    value: Int,
    onValueChange: (Int) -> Unit,
    label: String,
    helper: String?,
    modifier: Modifier = Modifier,
    range: IntRange = 0..10,
    suffix: String = "",
    enabled: Boolean = true,
    required: Boolean = false,
    status: FormFieldStatus? = null,
    flexible: Boolean = false,
    testTag: String? = null,
) {
    val colors = StepperDefaults.stepperColors()
    val mandatoryDescription = if (required) stringResource(id = R.string.spark_textfield_content_description) else null
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .semantics {
                text = listOfNotNull(label, mandatoryDescription, helper)
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

        SparkStepper(
            value = value,
            onValueChange = onValueChange,
            range = range,
            enabled = enabled,
            suffix = suffix,
            flexible = flexible,
            testTag = testTag,
            status = status,
            allowSemantics = false,
        )

        helper?.let {
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
    }
}

/**
 * Adds semantics to a [Stepper] component, enabling accessibility features from TalkBack.
 *
 * This modifier configures the component to behave like a slider, allowing users to adjust the `value` within
 * the specified `range` using accessibility features from TalkBack.
 *
 * @param value The current value of the stepper.
 * @param onValueChange When the value has been incremented or decremented.
 * @param range The same range used with the [Stepper] or [StepperForm].
 * @param enabled Whether the stepper is enabled or disabled. Disabled steppers cannot be interacted with and will
 * be announced as disabled
 *
 * Usage Example:
 *
 * ```kotlin
 *  var stepperValue by remember { mutableStateOf(50) }
 *
 *  Row(
 *     Modifier
 *        .fillMaxWidth()
 *        .semantics { text = label }
 *        .stepperSemantics(
 *            value = stepperValue,
 *            onValueChange = { stepperValue = it },
 *            range = 0..100,
 *            enabled = true
 *         )
 *   ) {
 *     Text(
 *       text = label,
 *       modifier = Modifier.invisibleSemantic()
 *     )
 *     Stepper(
 *       ...
 *          allowSemantics = false // Important otherwise the semantics will be duplicated
 *       ...
 *      )
 *   }
 *
 * ```
 */
// TODO-scott.rayapoulle.ext (30-01-2025): Move to spark a11y lib once it's initiated
public fun Modifier.stepperSemantics(
    value: Int,
    onValueChange: (Int) -> Unit,
    range: IntRange,
    enabled: Boolean,
): Modifier = semantics(mergeDescendants = true) {
    // this is needed to use volume keys or slide up / down
    setProgress { targetValue ->
        // without this rounding the values will only decrease
        val newValue = targetValue
            .roundToInt()
            .coerceIn(range)
        if (newValue != value) {
            onValueChange(newValue)
            true
        } else {
            false
        }
    }

    // override describing percents
    stateDescription = value.toString()

    if (!enabled) disabled()
}.progressSemantics(
    // this is needed to use volume keys or slide up / down
    value = value.toFloat(),
    valueRange = range.first.toFloat()..range.last.toFloat(),
    steps = range.last - range.first,
)


public object StepperDefaults {
    @Composable
    internal fun stepperColors() = sparkOutlinedTextFieldColors(
        unfocusedBorderColor = SparkTheme.colors.outline,
        containerColor = SparkTheme.colors.onSurface.transparent,
        disabledContainerColor = SparkTheme.colors.onSurface.dim5,
    )

    internal val textAnimationSpec = spring(
        stiffness = Spring.StiffnessMediumLow,
        visibilityThreshold = IntOffset.VisibilityThreshold,
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
        StepperForm(
            value = 1,
            onValueChange = {},
            status = FormFieldStatus.Error,
            label = "Label",
            helper = "helper message",
        )
        StepperForm(
            value = -1,
            onValueChange = {},
            status = FormFieldStatus.Alert,
            label = "Label",
            helper = "helper message",
        )
        StepperForm(
            value = -1234,
            onValueChange = {},
            status = FormFieldStatus.Success,
            label = "Label",
            helper = "helper message",
        )
    }
}
