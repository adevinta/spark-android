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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.AccountFill
import com.adevinta.spark.icons.House
import com.adevinta.spark.icons.Search
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import androidx.compose.material3.LeadingIconTab as MaterialLeadingIconTab

@InternalSparkApi
@Composable
internal fun SparkLeadingIconTab(
    selected: Boolean,
    onClick: () -> Unit,
    text: String,
    icon: SparkIcon,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selectedContentColor: Color = LocalContentColor.current,
    unselectedContentColor: Color = selectedContentColor,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },

) {
    MaterialLeadingIconTab(
        selected = selected,
        onClick = onClick,
        text = {
            Text(
                text = text,
                style = SparkTheme.typography.caption.copy(fontWeight = FontWeight.Bold),
            )
        },
        icon = {
            Icon(sparkIcon = icon, contentDescription = text, modifier = Modifier.size(16.dp))
        },
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedContentColor,
        unselectedContentColor = unselectedContentColor,
        interactionSource = interactionSource,
    )
}

/**
 * Spark tab.
 *
 * Tabs organize content across different screens, data sets, and other interactions.
 * A LeadingIconTab represents a single page of content using a text label and an icon in front of the label.
 * It represents its selected state by tinting the text label and icon with selectedContentColor.
 * This should typically be used inside of a TabRow, see the corresponding documentation for example usage.
 * @param selected whether this tab is selected or not
 * @param onClick called when this tab is clicked
 * @param text the text label displayed in this tab
 * @ icon the icon displayed in this tab
 * @param modifier the Modifier to be applied to this tab
 * @param enabled controls the enabled state of this tab. When false, this component will not respond to user input, and it will appear visually disabled and disabled to accessibility services.
 * @param interactionSource the MutableInteractionSource representing the stream of Interactions for this tab. You can create and pass in your own remembered instance to observe Interactions and customize the appearance / behavior of this tab in different states.
 *
 * See Also: [Tab]
 */
@ExperimentalSparkApi
@Composable
public fun LeadingIconTab(
    selected: Boolean,
    onClick: () -> Unit,
    text: String,
    icon: SparkIcon,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },

) {
    SparkLeadingIconTab(
        selected = selected,
        onClick = onClick,
        text = text,
        icon = icon,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
    )
}

@Preview(
    group = "Tabs",
    name = "LeadingIconTab",
)
@Composable
internal fun LeadingIconTabPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        val tabs = mutableListOf(
            Pair("Home", SparkIcons.House),
            Pair("Search", SparkIcons.Search),
            Pair("Account", SparkIcons.AccountFill),
        )
        TabRow(
            selectedTabIndex = 0,
            tabs = {
                tabs.forEachIndexed { index, tab ->
                    LeadingIconTab(
                        selected = index == 0,
                        onClick = { },
                        text = tab.first,
                        icon = tab.second,
                        enabled = true,
                    )
                }
            },
        )
    }
}
