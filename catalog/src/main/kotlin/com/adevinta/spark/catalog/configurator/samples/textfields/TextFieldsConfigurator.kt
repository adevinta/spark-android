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
package com.adevinta.spark.catalog.configurator.samples.textfields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.datastore.textfieldsconfigurator.TextFieldsConfiguratorProperties
import com.adevinta.spark.catalog.datastore.textfieldsconfigurator.TextFieldsConfiguratorPropertiesHandler
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.themes.SegmentedButton
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.icons.FilledIconToggleButton
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.components.textfields.TextFieldState
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.icons.LikeFill
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import kotlinx.coroutines.launch

public val TextFieldsConfigurator: Configurator = Configurator(
    name = "TextFields",
    description = "TextFields configuration",
    sourceUrl = "$SampleSourceUrl/ButtonSamples.kt",
) {
    TextFieldSample()
}

@Preview(
    showBackground = true,
)
@Composable
private fun TextFieldSample() {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val scrollState = rememberScrollState()
    val propertiesHandler = remember { TextFieldsConfiguratorPropertiesHandler(context) }
    val properties by propertiesHandler
        .properties
        .collectAsState(initial = TextFieldsConfiguratorProperties.DEFAULT)

    fun updateProperties(block: (TextFieldsConfiguratorProperties) -> TextFieldsConfiguratorProperties) {
        lifecycleOwner.lifecycleScope.launch {
            propertiesHandler.updateProperties(block(properties))
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.verticalScroll(scrollState),
    ) {
        val state: TextFieldState? = remember(key1 = properties.state, calculation = properties::state)
        val isEnabled: Boolean = remember(key1 = properties.isEnabled, calculation = properties::isEnabled)
        val isReadOnly: Boolean = remember(key1 = properties.isReadOnly, calculation = properties::isReadOnly)
        val isRequired: Boolean = remember(key1 = properties.isRequired, calculation = properties::isRequired)
        val isFilledIconToggleChecked = remember(key1 = properties.iconId) {
            properties.iconId != ResourcesCompat.ID_NULL
        }
        val trailingContent: @Composable (() -> Unit) = remember(key1 = properties.iconId) {
            {
                if (properties.iconId != ResourcesCompat.ID_NULL) {
                    Icon(sparkIcon = SparkIcon.DrawableRes(properties.iconId), contentDescription = null)
                }
            }
        }

        var labelText by remember { mutableStateOf("Label") }
        var valueText by remember { mutableStateOf("Value") }
        var placeHolderText by remember { mutableStateOf("Placeholder") }
        var helperText by remember { mutableStateOf("Helper message") }
        var stateMessageText by remember { mutableStateOf("State Message") }
        var addonText: String? by remember { mutableStateOf(null) }

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = valueText,
            onValueChange = { valueText = it },
            enabled = isEnabled,
            readOnly = isReadOnly,
            required = isRequired,
            label = labelText,
            placeholder = placeHolderText,
            helper = helperText,
            leadingContent = addonText?.let { { Text(it) } },
            trailingContent = trailingContent,
            state = state,
            stateMessage = stateMessageText,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = spacedBy(8.dp),
        ) {
            Text(
                text = "With Icon",
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            FilledIconToggleButton(
                checked = isFilledIconToggleChecked,
                onCheckedChange = { isChecked ->
                    updateProperties {
                        it.copy(iconId = if (isChecked) SparkIcons.LikeFill.drawableId else ResourcesCompat.ID_NULL)
                    }
                },
            ) {
                Icon(
                    sparkIcon = SparkIcons.LikeFill,
                    contentDescription = null,
                )
            }
        }
        SwitchLabelled(
            checked = isRequired,
            onCheckedChange = {
                updateProperties { properties -> properties.copy(isRequired = it) }
            },
        ) {
            Text(
                text = "Required",
                modifier = Modifier.fillMaxWidth(),
            )
        }
        SwitchLabelled(
            checked = isReadOnly,
            onCheckedChange = {
                updateProperties { properties -> properties.copy(isReadOnly = it) }
            },
        ) {
            Text(
                text = "Read Only",
                modifier = Modifier.fillMaxWidth(),
            )
        }
        SwitchLabelled(
            checked = isEnabled,
            onCheckedChange = {
                updateProperties { properties -> properties.copy(isEnabled = it) }
            },
        ) {
            Text(
                text = "Enabled",
                modifier = Modifier.fillMaxWidth(),
            )
        }

        Column {
            Text(
                text = "State",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val textFieldStates: MutableSet<TextFieldState?> =
                TextFieldState.values().toMutableSet<TextFieldState?>().apply { add(null) }
            val buttonStylesLabel = textFieldStates.map { it?.run { name } ?: "Default" }
            SegmentedButton(
                options = buttonStylesLabel,
                selectedOption = state?.name ?: "Default",
                onOptionSelect = {
                    updateProperties { properties ->
                        properties.copy(
                            state = if (it == "Default") null else TextFieldState.valueOf(it),
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = labelText,
            onValueChange = {
                labelText = it
            },
            label = "Label text",
            placeholder = "Label of the TextField",
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = placeHolderText,
            onValueChange = {
                placeHolderText = it
            },
            label = "Placeholder text",
            placeholder = "Placeholder of the TextField",
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = helperText,
            onValueChange = {
                helperText = it
            },
            label = "Helper text",
            placeholder = "Helper of the TextField",
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = stateMessageText,
            onValueChange = {
                stateMessageText = it
            },
            label = "State message",
            placeholder = "State message of the TextField",
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = addonText ?: "",
            onValueChange = {
                addonText = it.ifBlank { null }
            },
            label = "Prefix",
            placeholder = "State message of the TextField",
        )
    }
}
