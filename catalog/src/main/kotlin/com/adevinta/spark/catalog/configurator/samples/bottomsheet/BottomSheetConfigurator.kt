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
package com.adevinta.spark.catalog.configurator.samples.bottomsheet

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.bottomsheet.BottomSheet
import com.adevinta.spark.components.bottomsheet.DragHandle
import com.adevinta.spark.components.buttons.ButtonFilled
import com.adevinta.spark.components.buttons.ButtonIntent
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.image.Illustration
import com.adevinta.spark.components.image.Image
import com.adevinta.spark.components.list.ListItem
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.spacer.VerticalSpacer
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.text.TextLinkButton
import com.adevinta.spark.components.textfields.SelectTextField
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.icons.LikeFill
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.icons.Store
import com.adevinta.spark.tokens.highlight
import kotlinx.coroutines.launch

public val BottomSheetConfigurator: Configurator = Configurator(
    name = "BottomSheet",
    description = "BottomSheet configuration",
    sourceUrl = "$SampleSourceUrl/BottomSheetSamples.kt",
) {
    BottomSheetSample()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ColumnScope.BottomSheetSample() {
    var isDragHandlerEnabled by remember { mutableStateOf(true) }
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    var skipPartiallyExpanded by remember { mutableStateOf(false) }
    var bottomSheetContentExample by remember { mutableStateOf(BottomSheetContentExamples.Text) }

    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = skipPartiallyExpanded,
    )
    val scope = rememberCoroutineScope()

    SwitchLabelled(
        checked = isDragHandlerEnabled,
        onCheckedChange = {
            isDragHandlerEnabled = it
        },
    ) {
        Text(
            text = "Show Drag Handle",
            modifier = Modifier.fillMaxWidth(),
        )
    }

    SwitchLabelled(
        checked = skipPartiallyExpanded,
        onCheckedChange = {
            skipPartiallyExpanded = it
        },
    ) {
        Text(
            text = "Skip Partially Expanded",
            modifier = Modifier.fillMaxWidth(),
        )
    }

    val contentExamples = BottomSheetContentExamples.entries.toTypedArray()
    var expanded by remember { mutableStateOf(false) }
    SelectTextField(
        modifier = Modifier.fillMaxWidth(),
        value = bottomSheetContentExample.name,
        onValueChange = {},
        readOnly = true,
        label = "BottomSheet Content Example",
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        onDismissRequest = { expanded = false },
        dropdownContent = {
            contentExamples.forEach {
                DropdownMenuItem(
                    text = { Text(it.name) },
                    onClick = {
                        bottomSheetContentExample = it
                        expanded = false
                    },
                )
            }
        },
    )

    VerticalSpacer(24.dp)

    ButtonFilled(
        text = "Show BottomSheet",
        onClick = { openBottomSheet = !openBottomSheet },
    )

    ConfiguredBottomSheet(
        bottomSheetContentExample = bottomSheetContentExample,
        openBottomSheet = openBottomSheet,
        isDragHandlerEnabled = isDragHandlerEnabled,
        onDismissRequest = { openBottomSheet = false },
        onHideBottomSheetClicked = {
            scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                if (!bottomSheetState.isVisible) {
                    openBottomSheet = false
                }
            }
        },
        bottomSheetState = bottomSheetState,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ConfiguredBottomSheet(
    bottomSheetContentExample: BottomSheetContentExamples,
    openBottomSheet: Boolean,
    isDragHandlerEnabled: Boolean,
    onDismissRequest: () -> Unit,
    onHideBottomSheetClicked: () -> Unit,
    bottomSheetState: SheetState,
) {
    if (openBottomSheet) {
        BottomSheet(
            dragHandle = if (isDragHandlerEnabled) {
                { DragHandle() }
            } else {
                null
            },
            onDismissRequest = onDismissRequest,
            sheetState = bottomSheetState,
        ) {
            when (bottomSheetContentExample) {
                BottomSheetContentExamples.Text -> TextContent()
                BottomSheetContentExamples.Image -> ImageContent()
                BottomSheetContentExamples.Illustration -> IllustrationContent()
                BottomSheetContentExamples.List -> ListContent(onHideBottomSheetClicked)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ListContent(onHideBottomSheetClicked: () -> Unit) {
    LazyColumn {
        stickyHeader {
            Row(horizontalArrangement = Arrangement.Center) {
                // Note: If you provide logic outside of onDismissRequest to remove the sheet,
                // you must additionally handle intended state cleanup, if any.
                ButtonFilled(
                    modifier = Modifier.padding(24.dp),
                    text = "Hide Bottom Sheet",
                    onClick = onHideBottomSheetClicked,
                )
            }
        }

        items(50) {
            ListItem(
                headlineContent = { Text("Item $it") },
                leadingContent = {
                    Icon(
                        SparkIcons.LikeFill,
                        contentDescription = "Localized description",
                    )
                },
            )
        }
    }
}

@Composable
private fun TextContent() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Title",
            modifier = Modifier.padding(bottom = 16.dp),
            style = SparkTheme.typography.headline1.highlight,
        )
        Text(
            text = "Do you want to have this cookie now?",
            modifier = Modifier.padding(bottom = 16.dp),
            style = SparkTheme.typography.body2.highlight,
        )
        TextLinkButton(
            text = "Text Link",
            onClick = {},
            intent = ButtonIntent.Alert,
        )
    }
}

@Composable
private fun ImageContent() {
    Box(
        contentAlignment = Alignment.TopCenter,
    ) {
        Image(
            modifier = Modifier
                .height(500.dp)
                .fillMaxWidth(),
            model = "https://upload.wikimedia.org/wikipedia/commons/f/fd/Pink_flower.jpg",
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )
    }
}

@Composable
private fun IllustrationContent() {
    Illustration(
        sparkIcon = SparkIcons.Store,
        contentDescription = null,
        modifier = Modifier.size(100.dp),
    )
}

public enum class BottomSheetContentExamples {
    Text,
    Image,
    Illustration,
    List,
}
