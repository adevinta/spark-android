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
package com.adevinta.spark.catalog.examples.samples.checkbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.model.Example
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.spacer.VerticalSpacer
import com.adevinta.spark.components.toggles.Checkbox
import com.adevinta.spark.components.toggles.CheckboxLabelled
import com.adevinta.spark.components.toggles.ContentSide

private const val CheckboxExampleDescription = "Checkbox examples"
private const val CheckboxExampleSourceUrl = "$SampleSourceUrl/CheckboxSamples.kt"
public val CheckboxExamples: List<Example> = listOf(
    Example(
        name = "Standalone checkbox",
        description = CheckboxExampleDescription,
        sourceUrl = CheckboxExampleSourceUrl,
    ) {
        var checkboxState by remember { mutableStateOf(ToggleableState.Off) }
        Row {
            Column {
                Checkbox(
                    enabled = true,
                    state = checkboxState,
                    onClick = {
                        checkboxState = when (checkboxState) {
                            ToggleableState.On -> ToggleableState.Off
                            ToggleableState.Off -> ToggleableState.Indeterminate
                            ToggleableState.Indeterminate -> ToggleableState.On
                        }
                    },
                )
                Checkbox(enabled = false, state = checkboxState, onClick = {})
            }
        }
    },
    Example(
        name = "Labeled checkbox group",
        description = CheckboxExampleDescription,
        sourceUrl = CheckboxExampleSourceUrl,
    ) {
        LabeledCheckboxGroupExample()
    },
    Example(
        name = "Labeled checkbox content side",
        description = CheckboxExampleDescription,
        sourceUrl = CheckboxExampleSourceUrl,
    ) {
        LabeledCheckboxContentSideExample()
    },
)

@Composable
private fun LabeledCheckboxContentSideExample() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        val label = stringResource(id = R.string.component_checkbox_content_side_example_label)
        ContentSide.values().forEach { side ->
            var checkboxState by remember { mutableStateOf(ToggleableState.Off) }
            CheckboxLabelled(
                enabled = true,
                state = checkboxState,
                onClick = {
                    checkboxState = when (checkboxState) {
                        ToggleableState.Indeterminate, ToggleableState.Off -> ToggleableState.On
                        ToggleableState.On -> ToggleableState.Off
                    }
                },
                contentSide = side,
            ) { Text(label) }
        }
    }
}

@Composable
private fun LabeledCheckboxGroupExample() {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        LabeledCheckboxGroupHorizontalExample()
        LabeledCheckboxGroupVerticalExample()
    }
}

@Composable
private fun LabeledCheckboxGroupVerticalExample() {
    var checkboxEmailState by remember { mutableStateOf(ToggleableState.Off) }
    var checkboxNotificationsState by remember { mutableStateOf(ToggleableState.Off) }
    val groupState by remember {
        derivedStateOf {
            when {
                checkboxEmailState == ToggleableState.On && checkboxNotificationsState == ToggleableState.On ->
                    ToggleableState.On

                checkboxEmailState == ToggleableState.Off && checkboxNotificationsState == ToggleableState.Off ->
                    ToggleableState.Off

                else -> ToggleableState.Indeterminate
            }
        }
    }
    Column {
        Text(
            text = stringResource(id = R.string.component_checkbox_vertical_group_title),
            style = SparkTheme.typography.headline2,
        )
        VerticalSpacer(space = 8.dp)
        CheckboxLabelled(
            enabled = true,
            state = groupState,
            onClick = {
                when (groupState) {
                    ToggleableState.Indeterminate, ToggleableState.Off -> {
                        checkboxEmailState = ToggleableState.On
                        checkboxNotificationsState = ToggleableState.On
                    }

                    ToggleableState.On -> {
                        checkboxEmailState = ToggleableState.Off
                        checkboxNotificationsState = ToggleableState.Off
                    }
                }
            },
        ) { Text(text = stringResource(id = R.string.component_checkbox_group_example_group_label)) }
        Column(
            modifier = Modifier.padding(start = 32.dp),
        ) {
            CheckboxLabelled(
                enabled = true,
                state = checkboxNotificationsState,
                onClick = {
                    checkboxNotificationsState = when (checkboxNotificationsState) {
                        ToggleableState.Indeterminate, ToggleableState.Off -> ToggleableState.On
                        ToggleableState.On -> ToggleableState.Off
                    }
                },
            ) { Text(text = stringResource(id = R.string.component_checkbox_group_example_option1_label)) }
            CheckboxLabelled(
                enabled = true,
                state = checkboxEmailState,
                onClick = {
                    checkboxEmailState = when (checkboxEmailState) {
                        ToggleableState.Indeterminate, ToggleableState.Off -> ToggleableState.On
                        ToggleableState.On -> ToggleableState.Off
                    }
                },
            ) { Text(text = stringResource(id = R.string.component_checkbox_group_example_option2_label)) }
        }
    }
}

@Composable
private fun LabeledCheckboxGroupHorizontalExample() {
    val labels = listOf(
        stringResource(id = R.string.component_checkbox_group_example_option1_label),
        stringResource(id = R.string.component_checkbox_group_example_option2_label),
    )
    Column {
        Text(
            text = stringResource(id = R.string.component_checkbox_horizontal_group_title),
            style = SparkTheme.typography.headline2,
        )
        VerticalSpacer(space = 8.dp)
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            labels.forEach { label ->
                var checkboxState by remember { mutableStateOf(ToggleableState.Off) }
                CheckboxLabelled(
                    enabled = true,
                    state = checkboxState,
                    onClick = {
                        checkboxState = when (checkboxState) {
                            ToggleableState.Indeterminate, ToggleableState.Off -> ToggleableState.On
                            ToggleableState.On -> ToggleableState.Off
                        }
                    },
                ) { Text(label) }
            }
        }
    }
}
