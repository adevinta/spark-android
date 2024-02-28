/*
 * Copyright (c) 2023-2024 Adevinta
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
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.themes.SegmentedButton
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.iconbuttons.toggle.IconToggleButtonFilled
import com.adevinta.spark.components.iconbuttons.toggle.IconToggleButtonIcons
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.components.textfields.TextFieldState
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.icons.LikeFill
import com.adevinta.spark.icons.LikeOutline
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons

public val TextFieldsConfigurator: Configurator = Configurator(
    name = "TextFields",
    description = "TextFields configuration",
    sourceUrl = "$SampleSourceUrl/ButtonSamples.kt",
) {
    TextFieldSample()
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(
    showBackground = true,
)
@Composable
private fun TextFieldSample() {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .verticalScroll(scrollState)
            .imePadding(),
    ) {
        var icon: SparkIcon? by remember { mutableStateOf(null) }
        var isReadOnly by remember { mutableStateOf(false) }
        var isEnabled by remember { mutableStateOf(true) }
        var isRequired by remember { mutableStateOf(true) }
        var state: TextFieldState? by remember { mutableStateOf(null) }
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
            trailingContent = icon?.let { { Icon(it, contentDescription = null) } },
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
            IconToggleButtonFilled(
                checked = icon != null,
                onCheckedChange = {
                    icon = if (it) SparkIcons.LikeFill else null
                },
                icons = IconToggleButtonIcons(
                    checked = SparkIcons.LikeFill,
                    unchecked = SparkIcons.LikeOutline,
                ),
            )
        }
        SwitchLabelled(
            checked = isRequired,
            onCheckedChange = { isRequired = it },
        ) {
            Text(
                text = "Required",
                modifier = Modifier.fillMaxWidth(),
            )
        }
        SwitchLabelled(
            checked = isReadOnly,
            onCheckedChange = { isReadOnly = it },
        ) {
            Text(
                text = "Read Only",
                modifier = Modifier.fillMaxWidth(),
            )
        }
        SwitchLabelled(
            checked = isEnabled,
            onCheckedChange = { isEnabled = it },
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
                TextFieldState.entries.toMutableSet<TextFieldState?>().apply { add(null) }
            val buttonStylesLabel = textFieldStates.map { it?.run { name } ?: "Default" }
            SegmentedButton(
                options = buttonStylesLabel,
                selectedOption = state?.name ?: "Default",
                onOptionSelect = { state = if (it == "Default") null else TextFieldState.valueOf(it) },
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
