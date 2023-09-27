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
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.themes.SegmentedButton
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.buttons.ButtonShape
import com.adevinta.spark.components.iconbuttons.IconButtonContrast
import com.adevinta.spark.components.iconbuttons.IconButtonFilled
import com.adevinta.spark.components.iconbuttons.IconButtonGhost
import com.adevinta.spark.components.iconbuttons.IconButtonIntent
import com.adevinta.spark.components.iconbuttons.IconButtonOutlined
import com.adevinta.spark.components.iconbuttons.IconButtonSize
import com.adevinta.spark.components.iconbuttons.IconButtonTinted
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.SelectTextField
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.icons.LikeFill
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons

public val IconButtonsConfigurator: Configurator = Configurator(
    name = "IconButton",
    description = "IconButton configuration",
    sourceUrl = "$SampleSourceUrl/IconButtonSamples.kt",
) {
    IconButtonSample()
}

@Preview(
    showBackground = true,
)
@Composable
private fun IconButtonSample() {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.verticalScroll(scrollState),
    ) {
        var style by remember { mutableStateOf(IconButtonStyle.Filled) }
        val icon: SparkIcon by remember { mutableStateOf(SparkIcons.LikeFill) }
        var isLoading by remember { mutableStateOf(false) }
        var isEnabled by remember { mutableStateOf(true) }
        var shape by remember { mutableStateOf(ButtonShape.Pill) }
        var size by remember { mutableStateOf(IconButtonSize.Medium) }
        var intent by remember { mutableStateOf(IconButtonIntent.Main) }
        var contentDescription by remember { mutableStateOf("Content Description") }

        ConfiguredIconButton(
            style = style,
            shape = shape,
            contentDescription = contentDescription,
            onClick = { },
            size = size,
            intent = intent,
            isEnabled = isEnabled,
            isLoading = isLoading,
            icon = icon,
        )

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
                text = "Style",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val buttonStyles = IconButtonStyle.values()
            val buttonStylesLabel = buttonStyles.map { it.name }
            SegmentedButton(
                options = buttonStylesLabel,
                selectedOption = style.name,
                onOptionSelect = { style = IconButtonStyle.valueOf(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }

        val intents = IconButtonIntent.values()
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
                text = "Shape",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val buttonShapes = ButtonShape.values()
            val buttonShapesLabel = buttonShapes.map { it.name }
            SegmentedButton(
                options = buttonShapesLabel,
                selectedOption = shape.name,
                onOptionSelect = { shape = ButtonShape.valueOf(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }
        Column {
            Text(
                text = "Size",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val buttonSizes = IconButtonSize.values()
            val buttonSizesLabel = buttonSizes.map { it.name }
            SegmentedButton(
                options = buttonSizesLabel,
                selectedOption = size.name,
                onOptionSelect = { size = IconButtonSize.valueOf(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = contentDescription,
            onValueChange = {
                contentDescription = it
            },
            label = "Content Description",
            placeholder = "Content Description",
        )
    }
}

@Composable
private fun ConfiguredIconButton(
    modifier: Modifier = Modifier,
    style: IconButtonStyle,
    shape: ButtonShape,
    contentDescription: String?,
    onClick: () -> Unit = {},
    size: IconButtonSize,
    intent: IconButtonIntent,
    isEnabled: Boolean,
    isLoading: Boolean,
    icon: SparkIcon,
) {
    val containerColor by animateColorAsState(
        targetValue = if (intent != IconButtonIntent.Surface) {
            SparkTheme.colors.surface
        } else {
            SparkTheme.colors.surfaceInverse
        },
        label = "Button container color",
    )
    Surface(
        color = containerColor,
    ) {
        when (style) {
            IconButtonStyle.Filled -> IconButtonFilled(
                modifier = modifier,
                contentDescription = contentDescription,
                onClick = onClick,
                size = size,
                shape = shape,
                intent = intent,
                enabled = isEnabled,
                isLoading = isLoading,
                icon = icon,
            )

            IconButtonStyle.Outlined -> IconButtonOutlined(
                modifier = modifier,
                contentDescription = contentDescription,
                onClick = onClick,
                size = size,
                shape = shape,
                intent = intent,
                enabled = isEnabled,
                isLoading = isLoading,
                icon = icon,
            )

            IconButtonStyle.Tinted -> IconButtonTinted(
                modifier = modifier,
                contentDescription = contentDescription,
                onClick = onClick,
                size = size,
                shape = shape,
                intent = intent,
                enabled = isEnabled,
                isLoading = isLoading,
                icon = icon,
            )

            IconButtonStyle.Ghost -> IconButtonGhost(
                modifier = modifier,
                contentDescription = contentDescription,
                onClick = onClick,
                size = size,
                shape = shape,
                intent = intent,
                enabled = isEnabled,
                isLoading = isLoading,
                icon = icon,
            )

            IconButtonStyle.Contrast -> IconButtonContrast(
                modifier = modifier,
                contentDescription = contentDescription,
                onClick = onClick,
                size = size,
                shape = shape,
                intent = intent,
                enabled = isEnabled,
                isLoading = isLoading,
                icon = icon,
            )
        }
    }
}

private enum class IconButtonStyle {
    Filled,
    Outlined,
    Tinted,
    Contrast,
    Ghost,
}
