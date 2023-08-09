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
package com.adevinta.spark.catalog.configurator.samples.buttons

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
import com.adevinta.spark.catalog.datastore.buttonconfigurator.ButtonsConfiguratorProperties
import com.adevinta.spark.catalog.datastore.buttonconfigurator.ButtonsConfiguratorPropertiesHandler
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.themes.SegmentedButton
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.buttons.ButtonContrast
import com.adevinta.spark.components.buttons.ButtonFilled
import com.adevinta.spark.components.buttons.ButtonGhost
import com.adevinta.spark.components.buttons.ButtonIntent
import com.adevinta.spark.components.buttons.ButtonOutlined
import com.adevinta.spark.components.buttons.ButtonSize
import com.adevinta.spark.components.buttons.ButtonTinted
import com.adevinta.spark.components.buttons.IconSide
import com.adevinta.spark.components.icons.FilledIconToggleButton
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.SelectTextField
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.icons.LikeFill
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import kotlinx.coroutines.launch

public val ButtonsConfigurator: Configurator = Configurator(
    name = "Button",
    description = "Button configuration",
    sourceUrl = "$SampleSourceUrl/ButtonSamples.kt",
) {
    ButtonSample()
}

@Preview(
    showBackground = true,
)
@Composable
private fun ButtonSample() {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val scrollState = rememberScrollState()
    val propertiesHandler = remember { ButtonsConfiguratorPropertiesHandler(context = context) }
    val properties by propertiesHandler
        .properties
        .collectAsState(initial = ButtonsConfiguratorProperties.DEFAULT)

    fun updateProperties(block: (ButtonsConfiguratorProperties) -> ButtonsConfiguratorProperties) {
        lifecycleOwner.lifecycleScope.launch {
            propertiesHandler.updateProperties(block(properties))
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.verticalScroll(scrollState),
    ) {
        var buttonText: String by remember { mutableStateOf(value = "Filled button") }
        val isLoading: Boolean = remember(key1 = properties.isLoading, calculation = properties::isLoading)
        val isEnabled: Boolean = remember(key1 = properties.isEnabled, calculation = properties::isEnabled)
        val iconSide: IconSide = remember(key1 = properties.iconSide, calculation = properties::iconSide)
        val buttonSize: ButtonSize = remember(key1 = properties.size, calculation = properties::size)
        val buttonStyle: ButtonStyle = remember(key1 = properties.style, calculation = properties::style)
        val buttonIntent: ButtonIntent = remember(key1 = properties.intent, calculation = properties::intent)
        val icon: SparkIcon? = remember(key1 = properties.iconId) {
            if (properties.iconId == ResourcesCompat.ID_NULL) null else SparkIcon.DrawableRes(properties.iconId)
        }
        val isFilledIconToggleChecked = remember(key1 = icon) {
            icon != null
        }

        ConfigedButton(
            modifier = Modifier.fillMaxWidth(),
            style = buttonStyle,
            buttonText = buttonText,
            onClick = {
                updateProperties { it.copy(isLoading = !it.isLoading) }
            },
            isLoading = isLoading,
            size = buttonSize,
            intent = buttonIntent,
            isEnabled = isEnabled,
            iconSide = iconSide,
            icon = icon,
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
            checked = isLoading,
            onCheckedChange = { isChecked ->
                updateProperties { it.copy(isLoading = isChecked) }
            },
        ) {
            Text(
                text = "Loading",
                modifier = Modifier.fillMaxWidth(),
            )
        }
        SwitchLabelled(
            checked = isEnabled,
            onCheckedChange = { isChecked ->
                updateProperties { it.copy(isEnabled = isChecked) }
            },
        ) {
            Text(
                text = "Enabled",
                modifier = Modifier.fillMaxWidth(),
            )
        }

        Column {
            Text(
                text = "IconSide",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val iconsSides = IconSide.values()
            val iconsSidesLabel = iconsSides.map(IconSide::name)
            SegmentedButton(
                options = iconsSidesLabel,
                selectedOption = iconSide.name,
                onOptionSelect = { iconSide ->
                    updateProperties { it.copy(iconSide = IconSide.valueOf(iconSide)) }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }
        Column {
            Text(
                text = "Style",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val buttonStyles = ButtonStyle.values()
            val buttonStylesLabel = buttonStyles.map { it.name }
            SegmentedButton(
                options = buttonStylesLabel,
                selectedOption = buttonStyle.name,
                onOptionSelect = { buttonStyle ->
                    updateProperties { it.copy(style = ButtonStyle.valueOf(buttonStyle)) }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }

        val intents = ButtonIntent.values()
        var expanded by remember { mutableStateOf(false) }
        SelectTextField(
            modifier = Modifier.fillMaxWidth(),
            value = buttonIntent.name,
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
                intents.forEach { intent ->
                    DropdownMenuItem(
                        text = { Text(intent.name) },
                        onClick = {
                            updateProperties { it.copy(intent = intent) }
                            expanded = false
                        },
                    )
                }
            },
        )

        Column {
            Text(
                text = "IconSize",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val sizes = ButtonSize.values()
            val sizesLabel = sizes.map { it.name }
            SegmentedButton(
                options = sizesLabel,
                selectedOption = buttonSize.name,
                onOptionSelect = { buttonSize ->

                    updateProperties { it.copy(size = ButtonSize.valueOf(buttonSize)) }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            value = buttonText,
            onValueChange = { text -> buttonText = text },
            label = "Button text",
            placeholder = "Vérifier les Disponibilité",
        )
    }
}

@Composable
private fun ConfigedButton(
    modifier: Modifier = Modifier,
    style: ButtonStyle,
    buttonText: String,
    onClick: () -> Unit,
    isLoading: Boolean,
    size: ButtonSize,
    intent: ButtonIntent,
    isEnabled: Boolean,
    icon: SparkIcon?,
    iconSide: IconSide,
) {
    when (style) {
        ButtonStyle.Filled -> ButtonFilled(
            modifier = modifier,
            text = buttonText,
            onClick = onClick,
            isLoading = isLoading,
            size = size,
            intent = intent,
            enabled = isEnabled,
            icon = icon,
            iconSide = iconSide,
        )

        ButtonStyle.Outlined -> ButtonOutlined(
            modifier = modifier,
            text = buttonText,
            onClick = onClick,
            isLoading = isLoading,
            size = size,
            intent = intent,
            enabled = isEnabled,
            icon = icon,
            iconSide = iconSide,
        )

        ButtonStyle.Tinted -> ButtonTinted(
            modifier = modifier,
            text = buttonText,
            onClick = onClick,
            isLoading = isLoading,
            size = size,
            intent = intent,
            enabled = isEnabled,
            icon = icon,
            iconSide = iconSide,
        )

        ButtonStyle.Ghost -> ButtonGhost(
            modifier = modifier,
            text = buttonText,
            onClick = onClick,
            isLoading = isLoading,
            size = size,
            intent = intent,
            enabled = isEnabled,
            icon = icon,
            iconSide = iconSide,
        )

        ButtonStyle.Contrast -> ButtonContrast(
            modifier = modifier,
            text = buttonText,
            onClick = onClick,
            isLoading = isLoading,
            size = size,
            intent = intent,
            enabled = isEnabled,
            icon = icon,
            iconSide = iconSide,
        )
    }
}

internal enum class ButtonStyle {
    Filled,
    Outlined,
    Tinted,
    Ghost,
    Contrast,
}
