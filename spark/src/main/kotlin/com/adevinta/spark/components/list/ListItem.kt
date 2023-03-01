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

package com.adevinta.spark.components.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalSparkApi
@Composable
internal fun SparkListItem(
    headlineText: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    overlineText: (@Composable () -> Unit)? = null,
    supportingText: (@Composable () -> Unit)? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    colors: ListItemColors = ListItemDefault.colors(),
    tonalElevation: Dp = ListItemDefault.Elevation,
    shadowElevation: Dp = ListItemDefault.Elevation,
) {
    ListItem(
        headlineText = headlineText,
        modifier = modifier,
        overlineText = overlineText,
        supportingText = supportingText,
        leadingContent = leadingContent,
        trailingContent = trailingContent,
        colors = colors,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
    )
}

/**
 * Spark ListItem.
 *
 * A ListItem is a simple list of items
 *
 * ![ListItem image](https://developer.android.com/images/reference/androidx/compose/material3/lists.png)
 *
 * @param headlineText the headline text of the list item
 * @param modifier the [Modifier] to be applied to the list item
 * @param overlineText the text displayed above the headline text
 * @param supportingText the supporting text of the list item
 * @param leadingContent the leading supporting visual of the list item
 * @param trailingContent the trailing meta text, icon, switch or checkbox
 * @param colors ListItemColors that will be used to resolve the background and content color for this list item in different states. See ListItemDefaults.colors
 * @param tonalElevation the tonal elevation of this list item
 * @param shadowElevation the shadow elevation of this list item
 */
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalSparkApi
@Composable
public fun ListItem(
    headlineText: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    overlineText: (@Composable () -> Unit)? = null,
    supportingText: (@Composable () -> Unit)? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    colors: ListItemColors = ListItemDefault.colors(),
    tonalElevation: Dp = ListItemDefault.Elevation,
    shadowElevation: Dp = ListItemDefault.Elevation,
) {
    SparkListItem(
        headlineText = headlineText,
        modifier = modifier,
        overlineText = overlineText,
        supportingText = supportingText,
        leadingContent = leadingContent,
        trailingContent = trailingContent,
        colors = colors,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    group = "List",
    name = "ListItem",
)
@Composable
internal fun ListItemPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        ListItem(
            headlineText = {
                Text(text = "Headline text")
            },
        )
    }
}
