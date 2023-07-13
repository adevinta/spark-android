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
package com.adevinta.spark.components.tooltips

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PlainTooltipState
import androidx.compose.material3.RichTooltipColors
import androidx.compose.material3.RichTooltipState
import androidx.compose.material3.TooltipBoxScope
import androidx.compose.material3.TooltipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.components.buttons.ButtonGhost
import com.adevinta.spark.components.buttons.ButtonOutlined
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.icons.IconButton
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.AddOutline
import com.adevinta.spark.icons.FavoriteFill
import com.adevinta.spark.icons.InfoOutline
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import kotlinx.coroutines.launch
import androidx.compose.material3.PlainTooltipBox as MaterialPlainTooltipBox
import androidx.compose.material3.RichTooltipBox as MaterialRichTooltipBox

/**
 * Plain tooltip that provides a descriptive message for an anchor.
 *
 *
 * If control of when the tooltip is shown is desired please see
 *
 * @param tooltip the composable that will be used to populate the tooltip's content.
 * @param modifier the [Modifier] to be applied to the tooltip.
 * @param tooltipState handles the state of the tooltip's visibility.
 * @param shape the [Shape] that should be applied to the tooltip container.
 * @param containerColor [Color] that will be applied to the tooltip's container.
 * @param contentColor [Color] that will be applied to the tooltip's content.
 * @param content the composable that the tooltip will anchor to.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun PlainTooltipBox(
    tooltip: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    tooltipState: PlainTooltipState = remember { PlainTooltipState() },
    shape: Shape = TooltipDefaults.plainTooltipContainerShape,
    containerColor: Color = TooltipDefaults.plainTooltipContainerColor,
    contentColor: Color = TooltipDefaults.plainTooltipContentColor,
    content: @Composable TooltipBoxScope.() -> Unit,
) {
    MaterialPlainTooltipBox(
        tooltip = tooltip,
        modifier = modifier,
        tooltipState = tooltipState,
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor,
        content = content,
    )
}

/**
 * Rich text tooltip that allows the user to pass in a title, text, and action.
 * Tooltips are used to provide a descriptive message for an anchor.
 *
 * Tooltip that is invoked when the anchor is long pressed:
 *
 * @sample androidx.compose.material3.samples.RichTooltipSample
 *
 * If control of when the tooltip is shown is desired please see
 *
 * @sample androidx.compose.material3.samples.RichTooltipWithManualInvocationSample
 *
 * @param text the message to be displayed in the center of the tooltip.
 * @param modifier the [Modifier] to be applied to the tooltip.
 * @param tooltipState handles the state of the tooltip's visibility.
 * @param title An optional title for the tooltip.
 * @param action An optional action for the tooltip.
 * @param shape the [Shape] that should be applied to the tooltip container.
 * @param colors [RichTooltipColors] that will be applied to the tooltip's container and content.
 * @param content the composable that the tooltip will anchor to.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun PlainTooltipBox(
    text: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    tooltipState: RichTooltipState = remember { RichTooltipState() },
    title: (@Composable () -> Unit)? = null,
    action: (@Composable () -> Unit)? = null,
    shape: Shape = TooltipDefaults.richTooltipContainerShape,
    colors: RichTooltipColors = TooltipDefaults.richTooltipColors(),
    content: @Composable TooltipBoxScope.() -> Unit,
) {
    MaterialRichTooltipBox(
        text = text,
        modifier = modifier,
        tooltipState = tooltipState,
        title = title,
        action = action,
        shape = shape,
        colors = colors,
        content = content,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    group = "Tooltip",
    name = "LongPress",
)
@Composable
internal fun LongPressTooltipPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(
        theme,
        padding = PaddingValues(0.dp),
    ) {
        PlainTooltipBox(
            tooltip = { Text("Add to favorites") },
        ) {
            IconButton(
                onClick = { /* Icon button's click event */ },
                modifier = Modifier.tooltipAnchor(),
            ) {
                Icon(
                    SparkIcons.FavoriteFill,
                    contentDescription = "Localized Description",
                )
            }
        }
        val tooltipState = remember { RichTooltipState() }
        val scope = rememberCoroutineScope()
        MaterialRichTooltipBox(
            title = { Text("richTooltipSubheadText") },
            action = {
                ButtonGhost(
                    onClick = { scope.launch { tooltipState.dismiss() } },
                    text = "richTooltipActionText",
                )
            },
            text = { Text("richTooltipText") },
            tooltipState = tooltipState,
        ) {
            IconButton(
                onClick = { /* Icon button's click event */ },
                modifier = Modifier.tooltipAnchor(),
            ) {
                Icon(
                    SparkIcons.InfoOutline,
                    contentDescription = "Localized Description",
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    group = "Tooltip",
    name = "Control",
)
@Composable
internal fun ControlTooltipPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(
        theme,
        padding = PaddingValues(0.dp),
    ) {
        val tooltipState = remember { PlainTooltipState() }
        val scope = rememberCoroutineScope()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PlainTooltipBox(
                tooltip = { Text("Add to list") },
                tooltipState = tooltipState,
            ) {
                Icon(
                    SparkIcons.AddOutline,
                    contentDescription = "Localized Description",
                )
            }
            Spacer(Modifier.requiredHeight(30.dp))
            ButtonOutlined(
                onClick = { scope.launch { tooltipState.show() } },
                text = "Display tooltip",
            )
        }
        val richTooltipState = remember { RichTooltipState() }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MaterialRichTooltipBox(
                title = { Text("richTooltipSubheadText") },
                action = {
                    ButtonGhost(
                        onClick = {
                            scope.launch {
                                richTooltipState.dismiss()
                            }
                        },
                        text = "richTooltipActionText",
                    )
                },
                text = { Text("richTooltipText") },
                tooltipState = richTooltipState,
            ) {
                Icon(
                    SparkIcons.InfoOutline,
                    contentDescription = "Localized Description",
                )
            }
            Spacer(Modifier.requiredHeight(30.dp))
            ButtonOutlined(
                onClick = { scope.launch { richTooltipState.show() } },
                text = "Display tooltip",
            )
        }
    }
}
