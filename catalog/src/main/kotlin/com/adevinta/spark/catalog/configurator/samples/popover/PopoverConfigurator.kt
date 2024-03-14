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
package com.adevinta.spark.catalog.configurator.samples.popover

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TooltipState
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.themes.SegmentedButton
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.buttons.ButtonOutlined
import com.adevinta.spark.components.iconbuttons.IconButtonFilled
import com.adevinta.spark.components.image.Illustration
import com.adevinta.spark.components.image.Image
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.popover.Popover
import com.adevinta.spark.components.popover.PopoverIntent
import com.adevinta.spark.components.spacer.VerticalSpacer
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.text.TextLinkButton
import com.adevinta.spark.components.textfields.SelectTextField
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.icons.BurgerMenu
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.icons.Store
import com.adevinta.spark.tokens.highlight
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

public val PopoverConfigurator: Configurator = Configurator(
    name = "Popover",
    description = "Popover configuration",
    sourceUrl = "$SampleSourceUrl/PopoverSamples.kt",
) {
    PopoverSample()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ColumnScope.PopoverSample() {
    var isDismissButtonEnabled by remember { mutableStateOf(true) }
    var popoverContentExample by remember { mutableStateOf(PopoverContentExamples.TextList) }
    var popoverTriggerExample by remember { mutableStateOf(PopoverTriggerExamples.Button) }
    var intent by remember { mutableStateOf(PopoverIntent.Surface) }
    val popoverState = rememberTooltipState(isPersistent = true)
    val scope = rememberCoroutineScope()

    SwitchLabelled(
        checked = isDismissButtonEnabled,
        onCheckedChange = {
            isDismissButtonEnabled = it
        },
    ) {
        Text(
            text = "Show dismiss icon",
            modifier = Modifier.fillMaxWidth(),
        )
    }

    val contentExamples = PopoverContentExamples.entries.toTypedArray()
    var expanded by remember { mutableStateOf(false) }
    SelectTextField(
        modifier = Modifier.fillMaxWidth(),
        value = popoverContentExample.name,
        onValueChange = {},
        readOnly = true,
        label = "Popover Content Example",
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        onDismissRequest = { expanded = false },
        dropdownContent = {
            contentExamples.forEach {
                DropdownMenuItem(
                    text = { Text(it.name) },
                    onClick = {
                        popoverContentExample = it
                        expanded = false
                    },
                )
            }
        },
    )
    Column {
        Text(
            text = "Popover Anchor",
            modifier = Modifier.padding(bottom = 8.dp),
            style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
        )
        val triggerExamples = PopoverTriggerExamples.entries.toTypedArray()
        val contentSidesLabel = triggerExamples.map { it.name }
        SegmentedButton(
            options = contentSidesLabel,
            selectedOption = popoverTriggerExample.name,
            onOptionSelect = {
                popoverTriggerExample = PopoverTriggerExamples.valueOf(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
        )

        val intents = PopoverIntent.entries
        var intentExpanded by remember { mutableStateOf(false) }
        SelectTextField(
            modifier = Modifier.fillMaxWidth(),
            value = intent.name,
            onValueChange = {},
            readOnly = true,
            label = "Popover Intent",
            expanded = intentExpanded,
            onExpandedChange = { intentExpanded = !intentExpanded },
            onDismissRequest = { intentExpanded = false },
            dropdownContent = {
                intents.forEach {
                    DropdownMenuItem(
                        text = { Text(it.name) },
                        onClick = {
                            intent = it
                            intentExpanded = false
                        },
                    )
                }
            },
        )
        VerticalSpacer(40.dp)

        ConfiguredPopover(scope, popoverState, isDismissButtonEnabled, popoverContentExample, popoverTriggerExample)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ConfiguredPopover(
    scope: CoroutineScope,
    popoverState: TooltipState,
    isDismissButtonEnabled: Boolean,
    popoverContentExample: PopoverContentExamples,
    popoverTriggerExample: PopoverTriggerExamples,
) {
    Popover(
        popoverState = popoverState,
        popover = {
            when (popoverContentExample) {
                PopoverContentExamples.TextList -> LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    items(5) { index ->
                        Text(text = "Text: $index")
                    }
                }

                PopoverContentExamples.Text -> Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Text(
                        text = "Title",
                        style = SparkTheme.typography.headline1.highlight,
                    )
                    Text(
                        text = "Do you want to have this cookie now?",
                        style = SparkTheme.typography.body2.highlight,
                    )
                    TextLinkButton(
                        text = "Text Link",
                        onClick = {},
                    )
                }

                PopoverContentExamples.Image -> Image(
                    contentScale = ContentScale.Inside,
                    model = "https://images.unsplash.com/photo-1606041008023-472dfb5e530f",
                    contentDescription = null,
                )

                PopoverContentExamples.Illustration -> Illustration(
                    sparkIcon = SparkIcons.Store,
                    contentDescription = null,

                    modifier = Modifier.size(100.dp),
                )
            }
        },
        isDismissButtonEnabled = isDismissButtonEnabled,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            when (popoverTriggerExample) {
                PopoverTriggerExamples.Button -> {
                    ButtonOutlined(
                        text = "Display Popover",
                        onClick = { scope.launch { popoverState.show() } },
                    )
                }

                PopoverTriggerExamples.Icon -> {
                    IconButtonFilled(
                        onClick = { scope.launch { popoverState.show() } },
                        icon = SparkIcons.BurgerMenu,
                        contentDescription = "Burger Menu",
                    )
                }
            }
        }
    }
}

private enum class PopoverContentExamples {
    TextList,
    Image,
    Illustration,
    Text,
}

private enum class PopoverTriggerExamples {
    Button,
    Icon,
}
