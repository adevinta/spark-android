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
internal fun SparkCheckbox(
    state: ToggleableState,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    androidx.compose.material3.TriStateCheckbox(
        state = state,
        onClick = onClick,
        interactionSource = interactionSource,
        enabled = enabled,
        modifier = modifier.sparkUsageOverlay(),
    )
}

/**
 *
 * Checkboxes allows users to select one or more items from a set. Checkboxes can turn an option on or off.
 *
 *  - Toggle a single item on or off.
 *  - Require another action to activate or deactivate something.
 *
 * @see [SparkCheckbox] if you require support for an indeterminate state, or more advanced
 * color customization between states. Be aware that this is still an internal composable so if you need such
 * state contact the Spark team.
 *
 * @param state whether TriStateCheckbox is checked, unchecked or in indeterminate state
 * @param onClick callback to be invoked when checkbox is being clicked,
 * therefore the change of checked state in requested.  If null, then this is passive
 * and relies entirely on a higher-level component to control the "checked" state.
 * @param modifier Modifier to be applied to the layout of the checkbox
 * @param enabled whether the component is enabled or grayed out
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this Checkbox. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this Checkbox in different [Interaction]s.
 */
@Composable
public fun Checkbox(
    state: ToggleableState,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    SparkCheckbox(
        state = state,
        onClick = onClick,
        interactionSource = interactionSource,
        enabled = enabled,
        modifier = modifier,
    )
}

/**
 *
 * Checkboxes allows users to select one or more items from a set. Checkboxes can turn an option on or off.
 *
 *  - Toggle a single item on or off.
 *  - Require another action to activate or deactivate something.
 *
 * @see [SparkCheckbox] if you require support for an indeterminate state, or more advanced
 * color customization between states. Be aware that this is still an internal composable so if you need such
 * state contact the Spark team
 *
 * @param state whether TriStateCheckbox is checked, unchecked or in indeterminate state
 * @param onClick callback to be invoked when checkbox is being clicked,
 * therefore the change of checked state in requested.  If null, then this is passive
 * and relies entirely on a higher-level component to control the "checked" state.
 * @param modifier Modifier to be applied to the layout of the checkbox
 * @param enabled whether the component is enabled or grayed out
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this Checkbox. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this Checkbox in different [Interaction]s.
 * @param contentSide The side where we want to show the label, default to [ContentSide.End].
 * @param content The content displayed after the checkbox, usually a Text composable shown at the end.
 */
@Composable
public fun CheckboxLabelled(
    state: ToggleableState,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    contentSide: ContentSide = ContentSide.End,
    content: @Composable RowScope.() -> Unit,
) {
    SparkToggleLabelledContainer(
        state = state,
        toggle = {
            Checkbox(
                modifier = Modifier.minimumTouchTargetSize(),
                state = state,
                onClick = null,
                interactionSource = interactionSource,
                enabled = enabled,
            )
        },
        role = Role.Checkbox,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentSide = contentSide,
        content = content,
    )
}

@Preview(
    group = "Toggles",
    name = "Checkbox",
)
@Composable
internal fun AllStatesCheckboxPreview(
    @PreviewParameter(SparkPreviewParamProvider::class) param: SparkPreviewParam,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        Row {
            Checkbox(enabled = true, state = ToggleableState.On, onClick = {})
            Checkbox(enabled = false, state = ToggleableState.On, onClick = {})
            Checkbox(enabled = true, state = ToggleableState.Indeterminate, onClick = {})
            Checkbox(enabled = false, state = ToggleableState.Indeterminate, onClick = {})
            Checkbox(enabled = true, state = ToggleableState.Off, onClick = {})
            Checkbox(enabled = false, state = ToggleableState.Off, onClick = {})
        }
    }
}

@Preview(
    group = "Toggles",
    name = "CheckboxLabelled",
)
@Composable
internal fun AllStatesCheckBoxLabelledPreview(
    @PreviewParameter(SparkPreviewParamProvider::class) param: SparkPreviewParam,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        CheckboxLabelled(
            enabled = true,
            state = ToggleableState.On,
            onClick = {},
        ) { Text("CheckBox On") }
        CheckboxLabelled(
            enabled = false,
            state = ToggleableState.On,
            onClick = {},
        ) { Text("CheckBox On") }
        CheckboxLabelled(
            enabled = true,
            state = ToggleableState.Indeterminate,
            onClick = {},
        ) { Text("CheckBox Indeterminate") }
        CheckboxLabelled(
            enabled = false,
            state = ToggleableState.Indeterminate,
            onClick = {},
        ) { Text("CheckBox Indeterminate") }
        CheckboxLabelled(
            enabled = true,
            state = ToggleableState.Off,
            onClick = {},
        ) { Text("CheckBox Off") }
        CheckboxLabelled(
            enabled = false,
            state = ToggleableState.Off,
            onClick = {},
        ) { Text("CheckBox Off") }
    }
}
