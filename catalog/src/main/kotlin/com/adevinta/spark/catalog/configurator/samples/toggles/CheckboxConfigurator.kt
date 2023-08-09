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
package com.adevinta.spark.catalog.configurator.samples.toggles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.datastore.checkboxconfigurator.CheckboxConfiguratorProperties
import com.adevinta.spark.catalog.datastore.checkboxconfigurator.CheckboxConfiguratorPropertiesHandler
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.themes.SegmentedButton
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.SelectTextField
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.components.toggles.Checkbox
import com.adevinta.spark.components.toggles.CheckboxLabelled
import com.adevinta.spark.components.toggles.ContentSide
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.components.toggles.ToggleIntent
import kotlinx.coroutines.launch

public val CheckboxConfigurator: Configurator = Configurator(
    name = "Checkbox",
    description = "Checkbox configuration",
    sourceUrl = "$SampleSourceUrl/CheckboxSamples.kt",
) {
    CheckboxSample()
}

@Preview(
    showBackground = true,
)
@Composable
private fun CheckboxSample() {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val propertiesHandler = remember { CheckboxConfiguratorPropertiesHandler(context) }
    val properties by propertiesHandler
        .properties
        .collectAsState(initial = CheckboxConfiguratorProperties.DEFAULT)

    fun updateProperties(block: (CheckboxConfiguratorProperties) -> CheckboxConfiguratorProperties) {
        lifecycleOwner.lifecycleScope.launch {
            propertiesHandler.updateProperties(block(properties))
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.verticalScroll(scrollState),
    ) {
        var label: String? by remember { mutableStateOf(null) }
        val intent: ToggleIntent = remember(key1 = properties.intent, calculation = properties::intent)
        val isEnabled: Boolean = remember(key1 = properties.isEnabled, calculation = properties::isEnabled)
        val contentSide: ContentSide = remember(key1 = properties.contentSide, calculation = properties::contentSide)
        val state: ToggleableState = remember(key1 = properties.state, calculation = properties::state)
        val onClick = {
            updateProperties {
                it.copy(
                    state = when (state) {
                        ToggleableState.On -> ToggleableState.Off
                        ToggleableState.Off -> ToggleableState.Indeterminate
                        ToggleableState.Indeterminate -> ToggleableState.On
                    },
                )
            }
        }
        ConfigedCheckbox(
            label = label,
            onClick = onClick,
            state = state,
            isEnabled = isEnabled,
            intent = intent,
            contentSide = contentSide,
        )
        SwitchLabelled(
            checked = isEnabled,
            onCheckedChange = {
                updateProperties { properties -> properties.copy(isEnabled = it) }
                focusManager.clearFocus()
            },
        ) {
            Text(
                text = stringResource(id = R.string.configurator_component_screen_enabled_label),
                modifier = Modifier.fillMaxWidth(),
            )
        }
        Column {
            Text(
                text = stringResource(id = R.string.configurator_component_checkbox_toggleable_state_label),
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val states = ToggleableState.values()
            val contentSidesLabel = states.map { it.name }
            SegmentedButton(
                options = contentSidesLabel,
                selectedOption = state.name,
                onOptionSelect = {
                    updateProperties { properties -> properties.copy(state = ToggleableState.valueOf(it)) }
                    focusManager.clearFocus()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }
        val intents = ToggleIntent.values()
        var expanded by remember { mutableStateOf(false) }
        SelectTextField(
            modifier = Modifier.fillMaxWidth(),
            value = intent.name,
            onValueChange = {},
            readOnly = true,
            label = stringResource(id = R.string.configurator_component_screen_intent_label),
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            onDismissRequest = { expanded = false },
            dropdownContent = {
                intents.forEach { intent ->
                    DropdownMenuItem(
                        text = { Text(intent.name) },
                        onClick = {
                            updateProperties { properties -> properties.copy(intent = intent) }
                            expanded = false
                        },
                    )
                }
            },
        )
        Column {
            Text(
                text = stringResource(id = R.string.configurator_component_toggle_content_side_label),
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val contentSides = ContentSide.values()
            val contentSidesLabel = contentSides.map { it.name }
            SegmentedButton(
                options = contentSidesLabel,
                selectedOption = contentSide.name,
                onOptionSelect = {
                    updateProperties { properties ->
                        properties.copy(contentSide = ContentSide.valueOf(it))
                    }
                    focusManager.clearFocus()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = label.orEmpty(),
            onValueChange = {
                label = it
            },
            label = stringResource(id = R.string.configurator_component_screen_textfield_label),
            placeholder = stringResource(id = R.string.configurator_component_toggle_placeholder_label),
        )
    }
}

@Composable
private fun ConfigedCheckbox(
    modifier: Modifier = Modifier,
    label: String?,
    onClick: () -> Unit,
    state: ToggleableState,
    isEnabled: Boolean,
    contentSide: ContentSide,
    intent: ToggleIntent,
) {
    if (label.isNullOrBlank().not()) {
        CheckboxLabelled(
            modifier = modifier,
            enabled = isEnabled,
            state = state,
            onClick = onClick,
            contentSide = contentSide,
            intent = intent,
        ) { Text(text = label!!) }
    } else {
        Checkbox(
            modifier = modifier,
            enabled = isEnabled,
            state = state,
            onClick = onClick,
            intent = intent,
        )
    }
}
