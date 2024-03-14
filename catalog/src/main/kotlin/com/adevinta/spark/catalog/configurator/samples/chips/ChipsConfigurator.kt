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
package com.adevinta.spark.catalog.configurator.samples.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.themes.SegmentedButton
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.chips.ChipIntent
import com.adevinta.spark.components.chips.ChipSelectable
import com.adevinta.spark.components.chips.ChipStyles
import com.adevinta.spark.components.icons.FilledTonalIconToggleButton
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.SelectTextField
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.icons.LikeFill
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tokens.highlight

public val ChipsConfigurator: Configurator = Configurator(
    name = "Chip",
    description = "Chip configuration",
    sourceUrl = "$SampleSourceUrl/ChipSamples.kt",
) {
    ChipSample()
}

@Suppress("DEPRECATION")
@Composable
private fun ColumnScope.ChipSample() {
    var icon: SparkIcon? by remember { mutableStateOf(null) }
    var style by remember { mutableStateOf(ChipStyles.Outlined) }
    var intent by remember { mutableStateOf(ChipIntent.Basic) }
    var enabled by remember { mutableStateOf(true) }
    var closable by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(false) }
    var buttonText by remember { mutableStateOf("Outlined Chip") }

    ConfiguredChip(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        style = style,
        chipText = buttonText,
        enabled = enabled,
        intent = intent,
        icon = icon,
        closable = closable,
        selected = selected,
        onClick = { selected = !selected },
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.spacedBy(8.dp),
    ) {
        Text(
            text = "With Icon",
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 8.dp),
            style = SparkTheme.typography.body2.highlight,
        )
        FilledTonalIconToggleButton(
            checked = icon != null,
            onCheckedChange = {
                icon = if (it) SparkIcons.LikeFill else null
            },
        ) {
            Icon(
                sparkIcon = SparkIcons.LikeFill,
                contentDescription = null,
            )
        }
    }

    Column {
        Text(
            text = "Style",
            modifier = Modifier.padding(bottom = 8.dp),
            style = SparkTheme.typography.body2.highlight,
        )
        val tagStyles = ChipStyles.entries
        val tagStylesLabel = tagStyles.map { it.name }
        SegmentedButton(
            options = tagStylesLabel,
            selectedOption = style.name,
            onOptionSelect = { style = ChipStyles.valueOf(it) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
        )
    }

    val intents = ChipIntent.entries
    var expanded by remember { mutableStateOf(false) }
    SelectTextField(
        modifier = Modifier.fillMaxWidth(),
        value = intent.name,
        onValueChange = {},
        readOnly = true,
        label = "Intent",
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        onDismissRequest = {
            expanded = false
        },
        dropdownContent = {
            intents.forEach {
                DropdownMenuItem(
                    text = { Text(it.name) },
                    onClick = {
                        intent = it
                        expanded = false
                    },
                )
            }
        },
    )

    SwitchLabelled(
        checked = enabled,
        onCheckedChange = { enabled = it },
    ) {
        Text(text = "Enabled", modifier = Modifier.fillMaxWidth())
    }

    SwitchLabelled(
        checked = closable,
        onCheckedChange = { closable = it },
    ) {
        Text(text = "Closable", modifier = Modifier.fillMaxWidth())
    }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = buttonText,
        onValueChange = {
            buttonText = it
        },
        label = "Chip text",
        placeholder = "jane.doe@email.com",
    )
}

@Composable
private fun ConfiguredChip(
    modifier: Modifier = Modifier,
    style: ChipStyles,
    enabled: Boolean,
    chipText: String,
    intent: ChipIntent,
    icon: SparkIcon?,
    selected: Boolean,
    closable: Boolean,
    onClick: () -> Unit,
) {
    ChipSelectable(
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        leadingIcon = icon,
        text = chipText,
        enabled = enabled,
        style = style,
        intent = intent,
        onClose = if (closable) {
            { }
        } else {
            null
        },
        onCloseLabel = "Close",
    )
}
