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
package com.adevinta.spark.sample.themes

import android.os.Build
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.divider.Divider
import com.adevinta.spark.components.slider.Slider
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.SelectTextField
import com.adevinta.spark.components.toggles.RadioButton
import com.adevinta.spark.components.toggles.RadioButtonLabelled
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.sample.R

@Composable
public fun ThemePicker(
    theme: Theme,
    onThemeChange: (theme: Theme) -> Unit,
) {
    LazyColumn(
        contentPadding = WindowInsets.safeDrawing
            .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
            .add(
                WindowInsets(
                    top = ThemePickerPadding,
                    bottom = ThemePickerPadding,
                ),
            )
            .asPaddingValues(),
        verticalArrangement = Arrangement.spacedBy(ThemePickerPadding),
    ) {
        item {
            Text(
                text = stringResource(id = R.string.app_name),
                style = SparkTheme.typography.body2,
                modifier = Modifier.padding(horizontal = ThemePickerPadding),
            )
            // LazyVerticalGrid can't be used within LazyColumn due to nested scrolling
            val themeModes = ThemeMode.values()
            Column(
                modifier = Modifier.padding(ThemePickerPadding),
                verticalArrangement = Arrangement.spacedBy(ThemePickerPadding),
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(ThemePickerPadding)) {
                    ThemeModeItem(
                        modifier = Modifier.weight(1f),
                        themeMode = themeModes[0],
                        selected = themeModes[0] == theme.themeMode,
                        onClick = { onThemeChange(theme.copy(themeMode = it)) },
                    )
                    ThemeModeItem(
                        modifier = Modifier.weight(1f),
                        themeMode = themeModes[1],
                        selected = themeModes[1] == theme.themeMode,
                        onClick = { onThemeChange(theme.copy(themeMode = it)) },
                    )
                }
                Row {
                    ThemeModeItem(
                        modifier = Modifier.weight(1f),
                        themeMode = themeModes[2],
                        selected = themeModes[2] == theme.themeMode,
                        onClick = { onThemeChange(theme.copy(themeMode = it)) },
                    )
                }
            }
            Divider(
                modifier = Modifier.padding(horizontal = ThemePickerPadding),
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.color_mode),
                style = SparkTheme.typography.body2,
                modifier = Modifier.padding(horizontal = ThemePickerPadding),
            )
            // LazyVerticalGrid can't be used within LazyColumn due to nested scrolling
            val colorModes = ColorMode.values()
            Column(
                modifier = Modifier.padding(ThemePickerPadding),
                verticalArrangement = Arrangement.spacedBy(ThemePickerPadding),
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(ThemePickerPadding)) {
                    ColorModeItem(
                        modifier = Modifier.weight(1f),
                        colorMode = colorModes[0],
                        selected = colorModes[0] == theme.colorMode,
                        onClick = { onThemeChange(theme.copy(colorMode = it)) },
                    )
                    ColorModeItem(
                        modifier = Modifier.weight(1f),
                        colorMode = colorModes[1],
                        selected = colorModes[1] == theme.colorMode,
                        onClick = { onThemeChange(theme.copy(colorMode = it)) },
                    )
                }
                Row {
                    ColorModeItem(
                        modifier = Modifier.weight(1f),
                        colorMode = colorModes[2],
                        selected = colorModes[2] == theme.colorMode,
                        onClick = { onThemeChange(theme.copy(colorMode = it)) },
                    )
                }
            }

            AnimatedVisibility(visible = theme.colorMode == ColorMode.Brand) {
                var expanded by remember { mutableStateOf(false) }
                SelectTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(ThemePickerPadding),
                    value = theme.brandMode.name,
                    label = stringResource(id = R.string.brand),
                    onValueChange = { onThemeChange(theme.copy(brandMode = BrandMode.valueOf(it))) },
                    onDismissRequest = {
                        expanded = false
                    },
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    },
                ) {
                    BrandMode.values().forEach { brand ->
                        DropdownMenuItem(
                            text = {
                                Text(text = brand.name)
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(ThemePickerPadding),
                    checked = theme.userMode == UserMode.Pro,
                    onCheckedChange = { checked ->
                        onThemeChange(theme.copy(userMode = if (checked) UserMode.Pro else UserMode.Part))
                    },
                ) {
                    Text(text = stringResource(id = R.string.pro))
                }
            }
            Divider(
                modifier = Modifier.padding(horizontal = ThemePickerPadding),
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.text_direction),
                style = SparkTheme.typography.body2,
                modifier = Modifier.padding(horizontal = ThemePickerPadding),
            )
            // LazyVerticalGrid can't be used within LazyColumn due to nested scrolling
            val textDirections = TextDirection.values()
            Column(
                modifier = Modifier.padding(ThemePickerPadding),
                verticalArrangement = Arrangement.spacedBy(ThemePickerPadding),
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(ThemePickerPadding)) {
                    TextDirectionItem(
                        modifier = Modifier.weight(1f),
                        textDirection = textDirections[0],
                        selected = textDirections[0] == theme.textDirection,
                        onClick = { onThemeChange(theme.copy(textDirection = it)) },
                    )
                    TextDirectionItem(
                        modifier = Modifier.weight(1f),
                        textDirection = textDirections[1],
                        selected = textDirections[1] == theme.textDirection,
                        onClick = { onThemeChange(theme.copy(textDirection = it)) },
                    )
                }
                Row {
                    TextDirectionItem(
                        modifier = Modifier.weight(1f),
                        textDirection = textDirections[2],
                        selected = textDirections[2] == theme.textDirection,
                        onClick = { onThemeChange(theme.copy(textDirection = it)) },
                    )
                }
            }
            Divider(
                modifier = Modifier.padding(horizontal = ThemePickerPadding),
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.font_scale),
                style = SparkTheme.typography.body2,
                modifier = Modifier.padding(horizontal = ThemePickerPadding),
            )
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(ThemePickerPadding),
                ) {
                    RadioButton(
                        selected = theme.fontScaleMode == FontScaleMode.System,
                        onClick = {
                            onThemeChange(theme.copy(fontScaleMode = FontScaleMode.System))
                        },
                    )
                    Text(
                        text = FontScaleMode.System.label,
                        style = SparkTheme.typography.body2,
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(ThemePickerPadding),
                ) {
                    RadioButton(
                        selected = theme.fontScaleMode == FontScaleMode.Custom,
                        onClick = {
                            onThemeChange(theme.copy(fontScaleMode = FontScaleMode.Custom))
                        },
                    )
                    Text(
                        text = FontScaleMode.Custom.label,
                        style = SparkTheme.typography.body2,
                    )
                }

                var fontScale by remember { mutableStateOf(theme.fontScale) }
                FontScaleItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = ThemePickerPadding),
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
private fun ThemeModeItem(
    modifier: Modifier = Modifier,
    themeMode: ThemeMode,
    selected: Boolean,
    onClick: (ThemeMode) -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(ThemePickerPadding),
    ) {
        RadioButtonLabelled(
            selected = selected,
            onClick = { onClick(themeMode) },
        ) {
            Text(text = themeMode.toString())
        }
    }
}

@Composable
private fun ColorModeItem(
    modifier: Modifier = Modifier,
    colorMode: ColorMode,
    selected: Boolean,
    onClick: (ColorMode) -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(ThemePickerPadding),
    ) {
        val enabled = when {
            colorMode == ColorMode.Dynamic && Build.VERSION.SDK_INT < Build.VERSION_CODES.S -> false
            else -> true
        }
        RadioButtonLabelled(
            selected = selected,
            enabled = enabled,
            onClick = { onClick(colorMode) },
        ) {
            Text(text = colorMode.label)
        }
    }
}

@Composable
private fun TextDirectionItem(
    modifier: Modifier = Modifier,
    textDirection: TextDirection,
    selected: Boolean,
    onClick: (TextDirection) -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(ThemePickerPadding),
    ) {
        RadioButtonLabelled(
            selected = selected,
            onClick = { onClick(textDirection) },
        ) {
            Text(text = textDirection.toString())
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
            style = SparkTheme.typography.body2,
        )
    }
}

private val ThemePickerPadding = 16.dp
