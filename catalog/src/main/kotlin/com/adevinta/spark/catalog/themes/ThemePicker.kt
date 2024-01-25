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
package com.adevinta.spark.catalog.themes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.R
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.slider.Slider
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.SelectTextField
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.icons.Check
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tokens.Layout
import com.adevinta.spark.tokens.highlight

@Composable
public fun ThemePicker(
    modifier: Modifier = Modifier,
    theme: Theme,
    onThemeChange: (theme: Theme) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = WindowInsets.safeDrawing
            .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
            .add(
                WindowInsets(
                    top = ThemePickerPadding,
                    bottom = ThemePickerPadding,
                    left = Layout.bodyMargin,
                    right = Layout.bodyMargin,
                ),
            )
            .asPaddingValues(),
        verticalArrangement = Arrangement.spacedBy(ThemePickerPadding),
    ) {
        item {
            Column {
                Text(
                    text = stringResource(id = R.string.theme_picker_mode_title),
                    style = SparkTheme.typography.body2.highlight,
                    modifier = Modifier.padding(vertical = 8.dp),
                )
                val themeModes = ThemeMode.entries.toTypedArray()
                val themeModesLabel = themeModes.map { it.name }
                SegmentedButton(
                    options = themeModesLabel,
                    selectedOption = theme.themeMode.name,
                    onOptionSelect = { onThemeChange(theme.copy(themeMode = ThemeMode.valueOf(it))) },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(48.dp),
                )
            }
        }
        item {
            Column {
                Text(
                    text = stringResource(id = R.string.theme_picker_theme_title),
                    style = SparkTheme.typography.body2.highlight,
                    modifier = Modifier.padding(vertical = 8.dp),
                )
                val colorModes = ColorMode.entries.toTypedArray()
                val colorModesLabel = colorModes.map { it.name }
                SegmentedButton(
                    options = colorModesLabel,
                    selectedOption = theme.colorMode.name,
                    onOptionSelect = { onThemeChange(theme.copy(colorMode = ColorMode.valueOf(it))) },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(48.dp),
                )
                AnimatedVisibility(
                    visible = theme.colorMode == ColorMode.Brand,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    var expanded by remember { mutableStateOf(false) }
                    val selectedIcon = @Composable { Icon(SparkIcons.Check, contentDescription = null) }
                    SelectTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(ThemePickerPadding),
                        value = theme.brandMode.name,
                        label = stringResource(id = R.string.brand),
                        readOnly = true,
                        onValueChange = { onThemeChange(theme.copy(brandMode = BrandMode.valueOf(it))) },
                        onDismissRequest = {
                            expanded = false
                        },
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        },
                    ) {
                        BrandMode.entries.forEach { brand ->
                            DropdownMenuItem(
                                text = {
                                    Text(text = brand.name)
                                },
                                trailingIcon = if (brand == theme.brandMode) {
                                    selectedIcon
                                } else {
                                    {}
                                },
                                onClick = {
                                    onThemeChange(theme.copy(brandMode = brand))
                                    expanded = false
                                },
                            )
                        }
                    }
                }
                AnimatedVisibility(visible = theme.colorMode == ColorMode.Brand) {
                    SwitchLabelled(
                        modifier = Modifier.padding(ThemePickerPadding),
                        checked = theme.userMode == UserMode.Pro,
                        onCheckedChange = { checked ->
                            onThemeChange(theme.copy(userMode = if (checked) UserMode.Pro else UserMode.Part))
                        },
                    ) {
                        Text(
                            text = stringResource(id = R.string.pro),
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                }
            }
        }

        item {
            Column {
                Text(
                    text = stringResource(id = R.string.theme_picker_text_direction_title),
                    style = SparkTheme.typography.body2.highlight,
                    modifier = Modifier.padding(vertical = 8.dp),
                )
                val textDirections = TextDirection.entries.toTypedArray()
                val textDirectionsLabel = textDirections.map { it.name }
                SegmentedButton(
                    options = textDirectionsLabel,
                    selectedOption = theme.textDirection.name,
                    onOptionSelect = { onThemeChange(theme.copy(textDirection = TextDirection.valueOf(it))) },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(48.dp),
                )
            }
        }
        item {
            Column {
                Text(
                    text = stringResource(id = R.string.theme_picker_font_scale_title),
                    style = SparkTheme.typography.body2.highlight,
                    modifier = Modifier.padding(vertical = 8.dp),
                )
                val fontScaleModes = FontScaleMode.entries.toTypedArray()
                val colorModesLabel = fontScaleModes.map { it.name }
                SegmentedButton(
                    options = colorModesLabel,
                    selectedOption = theme.fontScaleMode.name,
                    onOptionSelect = { onThemeChange(theme.copy(fontScaleMode = FontScaleMode.valueOf(it))) },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(48.dp),
                )
            }
            var fontScale by remember { mutableFloatStateOf(theme.fontScale) }
            AnimatedVisibility(visible = theme.fontScaleMode == FontScaleMode.Custom) {
                FontScaleItem(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = theme.fontScaleMode == FontScaleMode.Custom,
                    fontScale = fontScale,
                    onValueChange = { fontScale = it },
                    onValueChangeFinished = { onThemeChange(theme.copy(fontScale = fontScale)) },
                )
            }
        }
    }
}

@Composable
private fun FontScaleItem(
    modifier: Modifier = Modifier,
    enabled: Boolean,
    fontScale: Float,
    fontScaleMin: Float = MinFontScale,
    fontScaleMax: Float = MaxFontScale,
    onValueChange: (textScale: Float) -> Unit,
    onValueChangeFinished: () -> Unit,
) {
    Column(modifier = modifier) {
        Slider(
            enabled = enabled,
            value = fontScale,
            steps = 10,
            onValueChange = onValueChange,
            onValueChangeFinished = onValueChangeFinished,
            valueRange = fontScaleMin..fontScaleMax,
        )
        Text(
            text = stringResource(id = R.string.scale, fontScale),
            style = SparkTheme.typography.body2.highlight,
        )
    }
}

private val ThemePickerPadding = 16.dp
