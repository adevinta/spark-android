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

package com.adevinta.spark.components.toggles

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.tools.modifiers.minimumTouchTargetSize
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import com.adevinta.spark.tools.preview.SparkPreviewParam
import com.adevinta.spark.tools.preview.SparkPreviewParamProvider


@Composable
@InternalSparkApi
internal fun SparkRadioButton(
    selected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    androidx.compose.material3.RadioButton(
        selected = selected,
        onClick = onClick,
        interactionSource = interactionSource,
        enabled = enabled,
        modifier = modifier.sparkUsageOverlay(),
    )
}

/**
 *
 * Radio buttons allow users to select one option from a set.
 *
 *  - Use radio buttons to select a single option from a list
 *  - It should be visible at a glance if a radio button has been selected, and selected items should be more visually
 *  prominent than unselected items.
 *  - Present a list showing all available options. If available options can be collapsed, consider using a dropdown
 *  menu because it uses less space.
 *
 * @see [SparkRadioButton] if you require color customization between states. Be aware that this is still an internal
 * composable so if you need such state contact the Spark team
 *
 * @param selected whether this radio button is selected or not
 * @param onClick callback to be invoked when the RadioButton is clicked. If null, then this RadioButton will not
 * handle input events, and only act as a visual indicator of selected state
 * @param modifier Modifier to be applied to the layout of the radiobutton
 * @param enabled whether the component is enabled or grayed out
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this RadioButton. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this RadioButton in different [Interaction]s.
 */
@Composable
public fun RadioButton(
    selected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    SparkRadioButton(
        selected = selected,
        onClick = onClick,
        interactionSource = interactionSource,
        enabled = enabled,
        modifier = modifier,
    )
}

/**
 *
 * Radio buttons allow users to select one option from a set.
 *
 *  - Use radio buttons to select a single option from a list
 *  - It should be visible at a glance if a radio button has been selected, and selected items should be more visually
 *  prominent than unselected items.
 *  - Present a list showing all available options. If available options can be collapsed, consider using a dropdown
 *  menu because it uses less space.
 *
 * @see [SparkRadioButton] if you require color customization between states. Be aware that this is still an internal
 * composable so if you need such state contact the Spark team
 *
 * @param selected whether this radio button is selected or not
 * @param onClick callback to be invoked when the RadioButton is clicked. If null, then this RadioButton will not
 * handle input events, and only act as a visual indicator of selected state
 * @param modifier Modifier to be applied to the layout of the checkbox
 * @param enabled whether the component is enabled or grayed out
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this Checkbox. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this Checkbox in different [Interaction]s.
 * @param endContent The end content displayed after the radio button, usually a Text composable
 */
@Composable
public fun RadioButtonLabelled(
    selected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    endContent: @Composable RowScope.() -> Unit,
) {
    SparkToggleLabelledContainer(
        state = ToggleableState(selected),
        toggle = {
            RadioButton(
                modifier = Modifier.minimumTouchTargetSize(),
                selected = selected,
                onClick = null,
                interactionSource = interactionSource,
                enabled = enabled,
            )
        },
        role = Role.RadioButton,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        endContent = endContent,
    )
}

@Preview(
    group = "Toggles",
    name = "RadioButton",
)
@Composable
internal fun AllStatesRadioButtonPreview(
    @PreviewParameter(SparkPreviewParamProvider::class) param: SparkPreviewParam,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        Row {
            RadioButton(enabled = true, selected = true, onClick = {})
            RadioButton(enabled = false, selected = true, onClick = {})
            RadioButton(enabled = true, selected = false, onClick = {})
            RadioButton(enabled = false, selected = false, onClick = {})
        }
    }
}

@Preview(
    group = "Toggles",
    name = "RadioButtonLabelled",
)
@Composable
internal fun AllStatesRadioButtonLabelledPreview(
    @PreviewParameter(SparkPreviewParamProvider::class) param: SparkPreviewParam,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        RadioButtonLabelled(
            enabled = true,
            selected = true, onClick = {},
        ) { Text("RadioButton On") }
        RadioButtonLabelled(
            enabled = false,
            selected = true, onClick = {},
        ) { Text("RadioButton On") }
        RadioButtonLabelled(
            enabled = true,
            selected = false, onClick = {},
        ) { Text("RadioButton Off") }
        RadioButtonLabelled(
            enabled = false,
            selected = false, onClick = {},
        ) { Text("RadioButton Off") }
    }
}
