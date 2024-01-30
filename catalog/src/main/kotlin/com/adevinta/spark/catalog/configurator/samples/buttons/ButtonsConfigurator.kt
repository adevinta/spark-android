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

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.adevinta.spark.components.buttons.ButtonContrast
import com.adevinta.spark.components.buttons.ButtonFilled
import com.adevinta.spark.components.buttons.ButtonGhost
import com.adevinta.spark.components.buttons.ButtonIntent
import com.adevinta.spark.components.buttons.ButtonOutlined
import com.adevinta.spark.components.buttons.ButtonShape
import com.adevinta.spark.components.buttons.ButtonSize
import com.adevinta.spark.components.buttons.ButtonTinted
import com.adevinta.spark.components.buttons.IconSide
import com.adevinta.spark.components.iconbuttons.toggle.IconToggleButtonFilled
import com.adevinta.spark.components.iconbuttons.toggle.IconToggleButtonIcons
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.SelectTextField
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.icons.LikeFill
import com.adevinta.spark.icons.LikeOutline
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons

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
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.verticalScroll(scrollState),
    ) {
        var icon: SparkIcon? by remember { mutableStateOf(null) }
        var isLoading by remember { mutableStateOf(false) }
        var isEnabled by remember { mutableStateOf(true) }
        var iconSide by remember { mutableStateOf(IconSide.START) }
        var style by remember { mutableStateOf(ButtonStyle.Filled) }
        var size by remember { mutableStateOf(ButtonSize.Medium) }
        var shape by remember { mutableStateOf(ButtonShape.Rounded) }
        var intent by remember { mutableStateOf(ButtonIntent.Main) }
        var buttonText by remember { mutableStateOf("Filled Button") }

        ConfiguredButton(
            modifier = Modifier.fillMaxWidth(),
            style = style,
            buttonText = buttonText,
            onClick = { isLoading = !isLoading },
            isLoading = isLoading,
            size = size,
            shape = shape,
            intent = intent,
            isEnabled = isEnabled,
            icon = icon,
            iconSide = iconSide,
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
            checked = isLoading,
            onCheckedChange = { isLoading = it },
        ) {
            Text(
                text = "Loading",
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
                text = "Icon side",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val iconsSidesLabel = IconSide.entries.map(IconSide::name)
            SegmentedButton(
                options = iconsSidesLabel,
                selectedOption = iconSide.name,
                onOptionSelect = { iconSide = IconSide.valueOf(it) },
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
            val buttonStylesLabel = ButtonStyle.entries.map(ButtonStyle::name)
            SegmentedButton(
                options = buttonStylesLabel,
                selectedOption = style.name,
                onOptionSelect = { style = ButtonStyle.valueOf(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }

        Column {
            Text(
                text = "Shape",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val buttonShapesLabel = ButtonShape.entries.map(ButtonShape::name)
            SegmentedButton(
                options = buttonShapesLabel,
                selectedOption = shape.name,
                onOptionSelect = { shape = ButtonShape.valueOf(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }

        val intents = ButtonIntent.entries.toTypedArray()
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

        Column {
            Text(
                text = "Button size",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val sizesLabel = ButtonSize.entries.map(ButtonSize::name)
            SegmentedButton(
                options = sizesLabel,
                selectedOption = size.name,
                onOptionSelect = { size = ButtonSize.valueOf(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = buttonText,
            onValueChange = {
                buttonText = it
            },
            label = "Button text",
            placeholder = "Vérifier les Disponibilité",
        )
    }
}

@Composable
private fun ConfiguredButton(
    modifier: Modifier = Modifier,
    style: ButtonStyle,
    buttonText: String,
    onClick: () -> Unit,
    isLoading: Boolean,
    size: ButtonSize,
    shape: ButtonShape,
    intent: ButtonIntent,
    isEnabled: Boolean,
    icon: SparkIcon?,
    iconSide: IconSide,
) {
    val containerColor by animateColorAsState(
        targetValue = if (intent != ButtonIntent.Surface) {
            SparkTheme.colors.backgroundVariant
        } else {
            SparkTheme.colors.surfaceInverse
        },
        label = "Button container color",
    )
    Surface(
        color = containerColor,
    ) {
        Box(
            modifier = Modifier.padding(8.dp),
        ) {
            when (style) {
                ButtonStyle.Filled -> ButtonFilled(
                    modifier = modifier,
                    text = buttonText,
                    onClick = onClick,
                    isLoading = isLoading,
                    size = size,
                    shape = shape,
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
                    shape = shape,
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
                    shape = shape,
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
                    shape = shape,
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
                    shape = shape,
                    intent = intent,
                    enabled = isEnabled,
                    icon = icon,
                    iconSide = iconSide,
                )
            }
        }
    }
}

private enum class ButtonStyle {
    Filled,
    Outlined,
    Tinted,
    Ghost,
    Contrast,
}
