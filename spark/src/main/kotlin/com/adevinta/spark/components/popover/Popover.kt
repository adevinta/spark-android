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
package com.adevinta.spark.components.popover

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.SparkTheme.colors
import com.adevinta.spark.components.buttons.ButtonOutlined
import com.adevinta.spark.components.iconbuttons.IconButtonGhost
import com.adevinta.spark.components.popover.PopoverDefaults.PopoverAnchorPadding
import com.adevinta.spark.components.popover.PopoverDefaults.PopoverContentPadding
import com.adevinta.spark.components.popover.PopoverDefaults.PopoverDismissButtonPadding
import com.adevinta.spark.components.popover.PopoverDefaults.PopoverMinHeight
import com.adevinta.spark.components.popover.PopoverDefaults.PopoverMinWidth
import com.adevinta.spark.components.popover.newapi.RichTooltipColors
import com.adevinta.spark.components.popover.newapi.TooltipBox
import com.adevinta.spark.components.popover.newapi.TooltipDefaults
import com.adevinta.spark.components.popover.newapi.TooltipState
import com.adevinta.spark.components.popover.newapi.rememberTooltipState
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.Close
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tokens.ElevationTokens
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import kotlinx.coroutines.launch

/**
 * Popover is kinda similar to Plain tooltip from Compose UI
 * Provides a descriptive message or Info for an Anchor.
 * Popover that is invoked when the anchor is pressed/long pressed:
 *
 * Params:
 * @param popoverContent the composable that will be used to populate the Popover's content.
 * @param isDismissButtonEnabled [Boolean] that determines if we show a dismiss iconbutton on the Popover,
 * @param popoverState handles the state of the Popover's visibility.
 * @param actionContent the composable that the Popover will anchor to.
 */

@ExperimentalSparkApi
@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ComposeModifierMissing")
public fun Popover(
    popoverContent: @Composable () -> Unit,
    isDismissButtonEnabled: Boolean = false,
    popoverState: TooltipState = rememberTooltipState(isPersistent = true),
    actionContent: @Composable () -> Unit,
) {
    val shape: Shape = TooltipDefaults.richTooltipContainerShape

    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = {
            val colors: RichTooltipColors = TooltipDefaults.richTooltipColors()
            Surface(
                modifier = Modifier
                    .sizeIn(minWidth = PopoverMinWidth, minHeight = PopoverMinHeight)
                    .padding(bottom = PopoverAnchorPadding),
                shape = shape,
                elevation = ElevationTokens.Level2,
                color = colors.containerColor,
            ) {
                Row {
                    Box(
                        modifier = Modifier.padding(all = PopoverContentPadding),
                    ) {
                        CompositionLocalProvider(
                            content = popoverContent,
                        )
                    }
                    if (isDismissButtonEnabled) {
                        IconButtonGhost(
                            modifier = Modifier.padding(
                                top = PopoverDismissButtonPadding,
                                end = PopoverDismissButtonPadding,
                            ),
                            icon = SparkIcons.Close,
                            onClick = { popoverState.dismiss() },
                        )
                    }
                }
            }
        },
        state = popoverState,
        content = actionContent,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    group = "Popovers",
    name = "Popovers",
)
@Composable
private fun PopoverPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        val state = rememberTooltipState(isPersistent = true)
        val scope = rememberCoroutineScope()

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Popover(
                popoverContent = {
                    Column {
                        Text(
                            text = "Title",
                            modifier = Modifier.padding(bottom = 16.dp),
                            style = SparkTheme.typography.headline1.copy(fontWeight = FontWeight.Bold),
                        )
                        Text(
                            text = "Do you want to have this cookie now?",
                            modifier = Modifier.padding(bottom = 16.dp),
                            style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
                        )
                        Text(
                            text = "Text Link",
                            textDecoration = TextDecoration.Underline,
                            style = SparkTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                                .copy(color = colors.accent),
                        )
                    }
                },
                isDismissButtonEnabled = true,
                popoverState = state,
            ) {
                ButtonOutlined(
                    text = "Display Popover",
                    onClick = { scope.launch { state.show() } },
                )
            }
        }
    }
}
