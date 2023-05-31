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
package com.adevinta.spark.components.tab

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import androidx.compose.material3.Tab as MaterialTab

@ExperimentalSparkApi
@Composable
internal fun SparkTab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selectedContentColor: Color = LocalContentColor.current,
    unselectedContentColor: Color = selectedContentColor,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable ColumnScope.() -> Unit,
) {
    MaterialTab(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedContentColor,
        unselectedContentColor = unselectedContentColor,
        interactionSource = interactionSource,
        content = content,
    )
}

/**
 * Spark tab.
 *
 * Tabs organize content across different screens, data sets, and other interactions.
 * Generic Tab overload that is not opinionated about content / color.
 * See the other overload for a Tab that has specific slots for text and / or an icon,
 * as well as providing the correct colors for selected / unselected states.
 *
 * @param selected whether this tab is selected or not
 * @param onClick called when this tab is clicked
 * @param modifier the Modifier to be applied to this tab
 * @param enabled controls the enabled state of this tab. When false, this component will not respond to user input,
 * and it will appear visually disabled and disabled to accessibility services.
 * @param interactionSource the MutableInteractionSource representing the stream of Interactions for this tab.
 * You can create and pass in your own remembered instance to observe Interactions
 * and customize the appearance / behavior of this tab in different states.
 * @param content the content of this tab
 *
 **/
@ExperimentalSparkApi
@Composable
public fun Tab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable ColumnScope.() -> Unit,
) {
    SparkTab(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        content = content,
    )
}

@Preview(
    group = "Tabs",
    name = "Tab",
)
@Composable
internal fun TabPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        Tab(
            selected = false,
            onClick = {},
            enabled = true,
        ) {
            Text("Messagerie")
        }

        Tab(
            selected = true,
            onClick = {},
            enabled = true,
        ) {
            Text("Messagerie")
        }

        Tab(
            selected = true,
            onClick = {},
            enabled = false,
        ) {
            Text("Messagerie")
        }

        Tab(
            selected = false,
            onClick = {},
            enabled = true,
        ) {
            Text("Messagerie")
        }
    }
}
