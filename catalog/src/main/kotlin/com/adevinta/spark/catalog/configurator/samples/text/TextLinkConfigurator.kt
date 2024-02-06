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
package com.adevinta.spark.catalog.configurator.samples.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.themes.SegmentedButton
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.buttons.ButtonIntent
import com.adevinta.spark.components.buttons.IconSide
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.scaffold.Scaffold
import com.adevinta.spark.components.snackbars.SnackbarHost
import com.adevinta.spark.components.snackbars.SnackbarHostState
import com.adevinta.spark.components.spacer.VerticalSpacer
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.text.TextLink
import com.adevinta.spark.components.text.TextLinkButton
import com.adevinta.spark.components.textfields.SelectTextField
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.icons.LikeFill
import com.adevinta.spark.icons.SparkIcons
import kotlinx.coroutines.launch

public val TextLinksConfigurator: Configurator = Configurator(
    name = "TextLink",
    description = "TextLink configuration",
    sourceUrl = "$SampleSourceUrl/TextLinkSamples.kt",
) {
    TextLinkSample()
}

@Preview(showBackground = true)
@Composable
private fun TextLinkSample() {
    val scrollState = rememberScrollState()
    var isIconAdded by remember { mutableStateOf(true) }
    var isLoading by remember { mutableStateOf(false) }
    var iconSide by remember { mutableStateOf(IconSide.START) }
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    var intent by remember { mutableStateOf(ButtonIntent.Basic) }
    val intents = ButtonIntent.entries
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.verticalScroll(scrollState),
        ) {
            Text(text = "Text Link Component", style = SparkTheme.typography.headline1)

            TextLink(
                text = R.string.spark_text_link_paragraph_example_,
                style = SparkTheme.typography.subhead,
                onClickLabel = "Privacy & Policy",
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Privacy & Policy Clicked",
                            actionLabel = "Action",
                            duration = SnackbarDuration.Short,
                        )
                    }
                },
            )
            VerticalSpacer(8.dp)
            Text(text = "Text Link Button Component", style = SparkTheme.typography.headline1)

            TextLinkButton(
                text = "Click me",
                intent = intent,
                icon = if (isIconAdded) SparkIcons.LikeFill else null,
                iconSide = iconSide,
                isLoading = isLoading,
                onClick = {
                    isLoading = !isLoading

                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Privacy & Policy Clicked",
                            actionLabel = "Action",
                            duration = SnackbarDuration.Short,
                        )
                    }
                },
            )

            SwitchLabelled(
                checked = isIconAdded,
                onCheckedChange = { isIconAdded = it },
            ) {
                Text(
                    text = "Enable Icon",
                    modifier = Modifier.fillMaxWidth(),
                )
            }

            Column {
                Text(
                    text = "Icon Alignment",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
                )
                val iconSides = IconSide.entries.toTypedArray()
                val iconSideLabel = iconSides.map { it.name }
                SegmentedButton(
                    options = iconSideLabel,
                    selectedOption = iconSide.name,
                    onOptionSelect = { iconSide = IconSide.valueOf(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                )
            }

            SelectTextField(
                modifier = Modifier.fillMaxWidth(),
                value = intent.name,
                onValueChange = {},
                readOnly = true,
                label = stringResource(id = R.string.configurator_component_screen_intent_label),
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                onDismissRequest = { expanded = false },
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
        }
    }
}
