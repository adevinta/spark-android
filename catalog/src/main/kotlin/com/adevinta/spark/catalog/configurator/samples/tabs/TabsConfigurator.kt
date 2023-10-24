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
package com.adevinta.spark.catalog.configurator.samples.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.adevinta.spark.components.badge.Badge
import com.adevinta.spark.components.iconbuttons.IconButtonFilled
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.tab.Tab
import com.adevinta.spark.components.tab.TabGroup
import com.adevinta.spark.components.tab.TabIntent
import com.adevinta.spark.components.tab.TabSize
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.SelectTextField
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.icons.MessageOutline
import com.adevinta.spark.icons.Minus
import com.adevinta.spark.icons.Plus
import com.adevinta.spark.icons.SparkIcons

public val TabsConfigurator: Configurator = Configurator(
    name = "Tab",
    description = "Tab configuration",
    sourceUrl = "$SampleSourceUrl/TabSamples.kt",
) {
    TabSample()
}

@Preview(
    showBackground = true,
)
@Composable
private fun TabSample() {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.verticalScroll(scrollState),
    ) {
        var isEnabled by remember { mutableStateOf(true) }
        var tabSize by remember { mutableStateOf(TabSize.Medium) }
        var intent by remember { mutableStateOf(TabIntent.Main) }
        var selectedIndex by remember { mutableIntStateOf(0) }
        var unreadIndex by remember { mutableIntStateOf(1) }

        val tabs = mutableListOf(
            Pair("Home", null) to 0,
            Pair("Message", SparkIcons.MessageOutline) to unreadIndex,
        )

        TabGroup(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = selectedIndex,
            intent = intent,
        ) {
            tabs.forEachIndexed { index, (tab, unread) ->
                Tab(
                    intent = intent,
                    text = tab.first,
                    icon = tab.second,
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    enabled = isEnabled,
                    size = tabSize,
                    trailingContent = {
                        if (unread > 0) {
                            Badge(count = unread)
                        } else {
                            Unit
                        }
                    },
                )
            }
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

        val intents = TabIntent.entries.toTypedArray()
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
                text = "Tab size",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            val sizes = TabSize.entries.toTypedArray()
            val sizesLabel = sizes.map { it.name }
            SegmentedButton(
                options = sizesLabel,
                selectedOption = tabSize.name,
                onOptionSelect = { tabSize = TabSize.valueOf(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
            )
        }
        Column {
            Text(
                text = "Tab Badge number",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
            )
            Row {
                Spacer(modifier = Modifier.padding(start = 16.dp))
                IconButtonFilled(
                    icon = SparkIcons.Minus,
                    onClick = { if (unreadIndex > 0) unreadIndex-- },
                )
                Spacer(modifier = Modifier.padding(start = 16.dp))

                IconButtonFilled(
                    icon = SparkIcons.Plus,
                    onClick = { unreadIndex++ },
                )
            }
        }
    }
}
