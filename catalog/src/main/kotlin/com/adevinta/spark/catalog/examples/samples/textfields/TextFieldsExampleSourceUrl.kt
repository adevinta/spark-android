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
package com.adevinta.spark.catalog.examples.samples.textfields

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.model.Example

import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.SparkSelectTrailingIcon
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.icons.Booster
import com.adevinta.spark.icons.EyeFill
import com.adevinta.spark.icons.EyeOffFill
import com.adevinta.spark.icons.QuestionOutline
import com.adevinta.spark.icons.SparkIcons
import kotlin.random.Random

private const val TextFieldsExampleSourceUrl = "$SampleSourceUrl/DropdownExamples.kt"

public val TextFieldsExamples: List<Example> = listOf(
    Example(
        id = "addons",
        name = "Default Addons",
        description = "Sample of addons provided by Spark through the AddonScope api",
        sourceUrl = TextFieldsExampleSourceUrl,
    ) {
        Addons()
    },
)

@Composable
private fun ColumnScope.Addons() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        TextFieldWithDropdown()
        TextFieldWithButton()
        TextFieldWithIcon()
        TextFieldWithIconButton()
        TextFieldWithIconToggleButton()
        TextFieldWithPrefixSuffixButton()
    }
}

@Composable
private fun TextFieldWithDropdown() {
    var expanded by remember { mutableStateOf(false) }
    var valueText by remember { mutableStateOf("+33 0123456789") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = valueText,
        label = "Phone number - Dropdown addon",
        onValueChange = { valueText = it },
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
                dropdownLabel = {
                    Canvas(
                        modifier = Modifier.size(width = 24.dp, height = 14.dp),
                    ) {
                        drawRect(color = Color.Blue)
                        drawRect(color = Color.White, topLeft = Offset(24.dp.toPx() / 3, 0f))
                        drawRect(color = Color.Red, topLeft = Offset(24.dp.toPx() / 3 * 2, 0f))
                    }
                    Text(text = "FR", style = SparkTheme.typography.body1)
                    SparkSelectTrailingIcon(expanded = expanded)
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

@Composable
private fun TextFieldWithButton() {
    var isLoading by remember { mutableStateOf(false) }
    var valueText by remember { mutableStateOf("AA-123-BB") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = valueText,
        label = "Button addon",
        onValueChange = { valueText = it },
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

@Composable
private fun TextFieldWithIcon() {
    var valueText by remember { mutableStateOf("AA-123-BB") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = valueText,
        label = "Icon addon",
        onValueChange = { valueText = it },
        trailingContent = {
            TextFieldIcon(
                icon = SparkIcons.QuestionOutline,
                modifier = Modifier,
                contentDescription = "",
            )
        },
    )
}

@Composable
private fun TextFieldWithIconButton() {
    var value by remember {
        mutableStateOf("AA-123-BB")
    }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        label = "Icon button addon",
        onValueChange = { value = it },
        trailingContent = {
            TextFieldIconButton(
                modifier = Modifier,
                icon = SparkIcons.Booster,
                contentDescription = "",
                onClick = { value = Random.nextInt(0, 8000).toString() },
            )
        },
    )
}

@Composable
private fun TextFieldWithIconToggleButton() {
    var checked by remember {
        mutableStateOf(false)
    }
    var valueText by remember { mutableStateOf("AA-123-BB") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = valueText,
        label = "Icon toggle button addon",
        onValueChange = { valueText = it },
        trailingContent = {
            TextFieldIconToggleButton(
                modifier = Modifier,
                checked = checked,
                checkedIcon = SparkIcons.EyeFill,
                unCheckedIcon = SparkIcons.EyeOffFill,
                contentDescription = "",
                onCheckedChange = { checked = it },
            )
        },
    )
}

@Composable
private fun TextFieldWithPrefixSuffixButton() {
    var valueText by remember { mutableStateOf("www.adevinta.com") }

    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = valueText,
        label = "Url - Prefix/Suffix addon",
        onValueChange = { valueText = it },
        leadingContent = {
            TextFieldText(text = "https://")
        },
        trailingContent = {
            TextFieldText(text = ".com")
        },
    )
}
