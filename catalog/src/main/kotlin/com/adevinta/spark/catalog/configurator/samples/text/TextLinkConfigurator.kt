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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.themes.SegmentedButton
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.buttons.ButtonOutlined
import com.adevinta.spark.components.buttons.ButtonSize
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.icons.IconSize
import com.adevinta.spark.components.scaffold.Scaffold
import com.adevinta.spark.components.snackbars.SnackbarHost
import com.adevinta.spark.components.snackbars.SnackbarHostState
import com.adevinta.spark.components.spacer.HorizontalSpacer
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.text.TextLink
import com.adevinta.spark.components.toggles.SwitchLabelled
import com.adevinta.spark.icons.LikeOutline
import com.adevinta.spark.icons.Link
import com.adevinta.spark.icons.SparkIcons
import io.mhssn.colorpicker.ColorPickerDialog
import io.mhssn.colorpicker.ColorPickerType
import kotlinx.coroutines.launch

public val TextLinksConfigurator: Configurator = Configurator(
    name = "TextLink",
    description = "TextLink configuration",
    sourceUrl = "$SampleSourceUrl/TextLinkSamples.kt",
) {
    TextLinkSample()
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview(
    showBackground = true,
)
@Composable
private fun TextLinkSample() {
    val scrollState = rememberScrollState()
    var isIconAdded by remember { mutableStateOf(true) }
    var shouldShowTextColorDialog by remember { mutableStateOf(false) }
    var shouldShowLinkColorDialog by remember { mutableStateOf(false) }
    var iconAlignment by remember { mutableStateOf(IconAlignment.Right) }
    var colorText by remember { mutableStateOf(Color.Magenta) }
    var colorLink by remember { mutableStateOf(Color.Cyan) }
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.verticalScroll(scrollState),
        ) {

            when (iconAlignment) {
                IconAlignment.Right -> Row {
                    if (isIconAdded) {
                        Icon(
                            modifier = Modifier.padding(top = 1.5.dp),
                            sparkIcon = SparkIcons.Link,
                            tint = colorText,
                            contentDescription = "Link",
                            size = IconSize.Small,
                        )
                        HorizontalSpacer(5.dp)
                    }


                    TextLink(
                        textFull = "This is Adevinta Privacy & Policy details.",
                        textLink = "Privacy & Policy",
                        colorText = colorText,
                        colorLink = colorLink,
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
                }

                IconAlignment.Left -> Row {
                    TextLink(
                        textFull = "This is Adevinta Privacy & Policy details.",
                        textLink = "Privacy & Policy",
                        colorText = colorText,
                        colorLink = colorLink,
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
                    if (isIconAdded) {
                        HorizontalSpacer(5.dp)
                        Icon(
                            modifier = Modifier.padding(top = 1.5.dp),
                            sparkIcon = SparkIcons.LikeOutline,
                            tint = colorText,
                            contentDescription = "Heart",
                            size = IconSize.Small,
                        )
                    }
                }
            }

            SwitchLabelled(
                checked = isIconAdded,
                onCheckedChange = { isIconAdded = it },
            ) {
                Text(
                    text = "Add Icon component next to TextLink",
                    modifier = Modifier.fillMaxWidth(),
                )
            }

            Column {
                Text(
                    text = "Icon Alignment",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
                )
                val iconAlignmentStyles = IconAlignment.entries.toTypedArray()
                val iconAlignmentStylesLabel = iconAlignmentStyles.map { it.name }
                SegmentedButton(
                    options = iconAlignmentStylesLabel,
                    selectedOption = iconAlignment.name,
                    onOptionSelect = { iconAlignment = IconAlignment.valueOf(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                )
            }


            Row(verticalAlignment = Alignment.CenterVertically) {
                ButtonOutlined(
                    size = ButtonSize.Medium, text = "Change Text Color",
                    onClick = {
                        shouldShowTextColorDialog = true
                    },
                )

                HorizontalSpacer(5.dp)
                Box(
                    modifier = Modifier
                        .width(44.dp)
                        .height(44.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(colorText),
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                ButtonOutlined(
                    size = ButtonSize.Medium, text = "Change Link Color",
                    onClick = { shouldShowLinkColorDialog = true },
                )

                HorizontalSpacer(5.dp)
                Box(
                    modifier = Modifier
                        .width(44.dp)
                        .height(44.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(colorLink),
                )
            }

            ColorPickerDialog(
                show = shouldShowTextColorDialog,
                type = ColorPickerType.SimpleRing(
                    colorWidth = 20.dp,
                    tracksCount = 5,
                    sectorsCount = 24,
                ),
                properties = DialogProperties(),
                onDismissRequest = {
                    shouldShowTextColorDialog = false
                },
                onPickedColor = {
                    shouldShowTextColorDialog = false
                    colorText = it
                },
            )
            ColorPickerDialog(
                show = shouldShowLinkColorDialog,
                type = ColorPickerType.SimpleRing(
                    colorWidth = 20.dp,
                    tracksCount = 5,
                    sectorsCount = 24,
                ),
                properties = DialogProperties(),
                onDismissRequest = {
                    shouldShowLinkColorDialog = false
                },
                onPickedColor = {
                    shouldShowLinkColorDialog = false
                    colorLink = it
                },
            )

        }
    }
}

private enum class IconAlignment {
    Right, Left
}
