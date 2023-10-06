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

package com.adevinta.spark.components.textfields

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.LayoutModifierNode
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.buttons.SparkButtonDefaults
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.SparkIcon
import androidx.compose.material3.FilledTonalButton as MaterialButton

public interface AddonScope {

    @ExperimentalSparkApi
    @Composable
    public fun Button(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        icon: SparkIcon? = null,
        isLoading: Boolean = false,
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    ) {
        MaterialButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            elevation = ButtonDefaults.buttonElevation(),
            shape = SparkTheme.shapes.full,
            colors = ButtonDefaults.filledTonalButtonColors(
                containerColor = SparkTheme.colors.mainContainer,
            ),
            interactionSource = interactionSource,
        ) {
            Text(
                text = text,
                style = SparkTheme.typography.callout,
            )
            if (icon != null) {
                Spacer(Modifier.width(SparkButtonDefaults.IconSpacing))
                Icon(
                    sparkIcon = icon,
                    modifier = Modifier.size(SparkButtonDefaults.IconSize),
                    contentDescription = null, // button text should be enough for context
                )
            }
            AnimatedVisibility(visible = isLoading) {
                Row {
                    Spacer(Modifier.width(8.dp))
                    Box(Modifier.size(SparkButtonDefaults.IconSize)) {
                        CircularProgressIndicator(
                            color = LocalContentColor.current,
                            strokeWidth = 2.dp,
                        )
                    }
                }
            }
        }
    }

    @ExperimentalSparkApi
    @Composable
    public fun Button(
        text: String,
        onClick: () -> Unit
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        icon: SparkIcon? = null,
        isLoading: Boolean = false,
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    ) {
        LayoutModifierNode
        MaterialButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            elevation = ButtonDefaults.buttonElevation(),
            shape = SparkTheme.shapes.full,
            colors = ButtonDefaults.filledTonalButtonColors(
                containerColor = SparkTheme.colors.mainContainer,
            ),
            interactionSource = interactionSource,
        ) {
            Text(
                text = text,
                style = SparkTheme.typography.callout,
            )
            if (icon != null) {
                Spacer(Modifier.width(SparkButtonDefaults.IconSpacing))
                Icon(
                    sparkIcon = icon,
                    modifier = Modifier.size(SparkButtonDefaults.IconSize),
                    contentDescription = null, // button text should be enough for context
                )
            }
            AnimatedVisibility(visible = isLoading) {
                Row {
                    Spacer(Modifier.width(8.dp))
                    Box(Modifier.size(SparkButtonDefaults.IconSize)) {
                        CircularProgressIndicator(
                            color = LocalContentColor.current,
                            strokeWidth = 2.dp,
                        )
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @ExperimentalSparkApi
    @Composable
    public fun Dropdown(
        expanded: Boolean,
        onExpandedChange: (Boolean) -> Unit,
        onDismissRequest: () -> Unit,
        dropdownLabel: @Composable RowScope.() -> Unit,
        modifier: Modifier = Modifier,
        properties: PopupProperties= PopupProperties(),
        interactionSource: MutableInteractionSource= remember { MutableInteractionSource() },
        popupDropdownContent: @Composable ColumnScope.() -> Unit,
    ) {
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = onExpandedChange) {
            Surface(
                modifier = modifier.menuAnchor(),
                onClick = {},
                shape = SparkTheme.shapes.small,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    dropdownLabel()
                }
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = onDismissRequest,
                modifier = Modifier.exposedDropdownSize(false),
                properties = properties,
                content = popupDropdownContent,
            )
        }
    }
}

internal object AddonScopeInstance : AddonScope


@Preview(device = Devices.PIXEL_4_XL)
@Composable
private fun TextFieldWithDropdownPreview() {
    var expanded by remember { mutableStateOf(false) }
    PreviewTheme() {
        Box(modifier = Modifier.fillMaxSize()) {
            TextField(
                value = "+33 0123456789",
                label = "Phone number",
                onValueChange = {},
                leadingContent = {
                    Dropdown(
                        modifier = Modifier,
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        },
                        onDismissRequest = {
                            expanded = false
                        },
                        properties = PopupProperties(),
                        interactionSource = MutableInteractionSource(),
                        dropdownLabel = {
                            Canvas(
                                modifier = Modifier.size(width = 24.dp, height = 14.dp),
                            ) {
                                drawRect(color = Color.Blue)
                                drawRect(color = Color.White, topLeft = Offset(24.dp.toPx() / 3, 0f))
                                drawRect(color = Color.Red, topLeft = Offset(24.dp.toPx() / 3 * 2, 0f))
                            }
                            Text(text = "FR", style = SparkTheme.typography.body1)
                            SparkSelectTrailingIcon(
                                expanded = expanded,
                                enabled = false,
                            )
                        },
                    ) {
                        repeat(4) {
                            DropdownMenuItem(
                                onClick = {
                                    expanded = false
                                },
                                text = { Text(text = "Dropdown") },
                            )
                        }
                    }
                },
            )
        }
    }
}

@Preview
@Composable
private fun TextFieldWithPrefixPreview() {
    var isLoading by remember { mutableStateOf(false) }
    PreviewTheme {
            TextField(
                value = "AA-123-BB",
                label = "Plate number",
                onValueChange = {},
                trailingContent = {
                    Button(
                        text = "Validate",
                        modifier = Modifier,
                        onClick = { isLoading = !isLoading },
                        isLoading = isLoading,
                    )
                },
            )
    }
}

