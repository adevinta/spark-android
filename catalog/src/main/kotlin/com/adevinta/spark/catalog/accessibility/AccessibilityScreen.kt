/*
 * Copyright (c) 2024 Adevinta
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
package com.adevinta.spark.catalog.accessibility

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.R
import com.adevinta.spark.components.buttons.ButtonOutlined
import com.adevinta.spark.components.divider.DividerIntent
import com.adevinta.spark.components.divider.HorizontalDivider
import com.adevinta.spark.components.spacer.VerticalSpacer
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.icons.WheelOutline
import com.adevinta.spark.res.annotatedStringResource
import com.adevinta.spark.tokens.highlight

@Composable
public fun AccessibilityScreen(
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val accessibilityTypes: List<AccessibilityType> by remember {
        mutableStateOf(getAllAccessibilityRes())
    }
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        ButtonOutlined(
            icon = SparkIcons.WheelOutline,
            onClick = {
                context.startActivity(Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS))
            },
            modifier = Modifier.padding(16.dp),
        ) {
            Text(text = stringResource(id = R.string.accessibility_settings_shortcut))
        }

        LazyColumn(
            modifier = modifier
                .consumeWindowInsets(contentPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentPadding = contentPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(accessibilityTypes.size) { index ->
                val accessibilityType = accessibilityTypes[index]
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = stringResource(id = R.string.accessibility_settings_type_label))
                    Text(
                        text = stringResource(id = accessibilityType.type),
                        style = SparkTheme.typography.body1.highlight,
                    )
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = stringResource(id = R.string.accessibility_settings_input_label))
                    Text(
                        text = annotatedStringResource(id = accessibilityType.input),
                        color = SparkTheme.colors.support,
                    )
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = stringResource(id = R.string.accessibility_settings_result_label))
                    Text(
                        text = annotatedStringResource(id = accessibilityType.result),
                        color = SparkTheme.colors.accent,
                    )
                }
                VerticalSpacer(8.dp)
                HorizontalDivider(intent = DividerIntent.Outline)
            }
        }
    }
}

private data class AccessibilityType(
    val type: Int,
    val input: Int,
    val result: Int,
)

private fun getAllAccessibilityRes() = listOf(
    AccessibilityType(
        type = R.string.accessibility_settings_cardinal_type,
        input = R.string.accessibility_settings_cardinal_input,
        result = R.string.accessibility_settings_cardinal_result,
    ),
    AccessibilityType(
        type = R.string.accessibility_settings_date_type,
        input = R.string.accessibility_settings_date_input,
        result = R.string.accessibility_settings_date_result,
    ),
    AccessibilityType(
        type = R.string.accessibility_settings_decimal_type,
        input = R.string.accessibility_settings_decimal_input,
        result = R.string.accessibility_settings_decimal_result,
    ),
    AccessibilityType(
        type = R.string.accessibility_settings_digits_type,
        input = R.string.accessibility_settings_digits_input,
        result = R.string.accessibility_settings_digits_result,
    ),
    AccessibilityType(
        type = R.string.accessibility_settings_electronic_type,
        input = R.string.accessibility_settings_electronic_input,
        result = R.string.accessibility_settings_electronic_result,
    ),
    AccessibilityType(
        type = R.string.accessibility_settings_fraction_type,
        input = R.string.accessibility_settings_fraction_input,
        result = R.string.accessibility_settings_fraction_result,
    ),
    AccessibilityType(
        type = R.string.accessibility_settings_measure_type,
        input = R.string.accessibility_settings_measure_input,
        result = R.string.accessibility_settings_measure_result,
    ),
    AccessibilityType(
        type = R.string.accessibility_settings_money_type,
        input = R.string.accessibility_settings_money_input,
        result = R.string.accessibility_settings_money_result,
    ),
    AccessibilityType(
        type = R.string.accessibility_settings_ordinal_type,
        input = R.string.accessibility_settings_ordinal_input,
        result = R.string.accessibility_settings_ordinal_result,
    ),
    AccessibilityType(
        type = R.string.accessibility_settings_telephone_type,
        input = R.string.accessibility_settings_telephone_input,
        result = R.string.accessibility_settings_telephone_result,
    ),
    AccessibilityType(
        type = R.string.accessibility_settings_text_type,
        input = R.string.accessibility_settings_text_input,
        result = R.string.accessibility_settings_text_result,
    ),
    AccessibilityType(
        type = R.string.accessibility_settings_time_type,
        input = R.string.accessibility_settings_time_input,
        result = R.string.accessibility_settings_time_result,
    ),
    AccessibilityType(
        type = R.string.accessibility_settings_verbatim_type,
        input = R.string.accessibility_settings_verbatim_input,
        result = R.string.accessibility_settings_verbatim_result,
    ),
)