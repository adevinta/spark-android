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
@file:Suppress("DEPRECATION")
// TODO: Revisit after upgrading material3 library to 1.2.0

package com.adevinta.spark.components.tab

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.components.divider.Divider
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import androidx.compose.material3.ScrollableTabRow as MaterialScrollableTabRow
import androidx.compose.material3.TabRow as MaterialTabRow

@ExperimentalSparkApi
@Composable
internal fun SparkTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = TabRowDefaults.containerColor,
    contentColor: Color = TabRowDefaults.contentColor,
    indicator: @Composable (tabPositions: List<TabPosition>) -> Unit = @Composable { tabPositions ->
        TabRowDefaults.Indicator(
            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
        )
    },
    divider: @Composable () -> Unit = @Composable { Divider() },
    tabs: @Composable () -> Unit,
) {
    MaterialTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        indicator = indicator,
        divider = divider,
        tabs = tabs,
    )
}

/**
 * Material Design fixed tabs.
 *
 * Fixed tabs display all tabs in a set simultaneously. They are best for switching between related
 * content quickly, such as between transportation methods in a map. To navigate between fixed tabs,
 * tap an individual tab, or swipe left or right in the content area.
 *
 * A TabRow contains a row of [Tab]s, and displays an indicator underneath the currently
 * selected tab. A TabRow places its tabs evenly spaced along the entire row, with each tab
 * taking up an equal amount of space. See [ScrollableTabRow] for a tab row that does not enforce
 * equal size, and allows scrolling to tabs that do not fit on screen.
 *
 * @param selectedTabIndex the index of the currently selected tab
 * @param modifier the [Modifier] to be applied to this tab row
 * @param tabs the tabs inside this tab row. Typically this will be multiple [Tab]s. Each element
 * inside this lambda will be measured and placed evenly across the row, each taking up equal space.
 */
@ExperimentalSparkApi
@Composable
@Deprecated(
    message = "This component is no longer compliant with Spark specs",
    replaceWith = ReplaceWith(
        expression = "TabGroup(selectedTabIndex, modifier, intent, tabs)",
        imports = ["com.adevinta.spark.components.tab.TabGroup"],
    ),
)
public fun TabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    tabs: @Composable () -> Unit,
) {
    SparkTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        tabs = tabs,
    )
}

/**
 * Material Design scrollable tabs.
 *
 * When a set of tabs cannot fit on screen, use scrollable tabs. Scrollable tabs can use longer text
 * labels and a larger number of tabs. They are best used for browsing on touch interfaces.
 *
 * A ScrollableTabRow contains a row of [Tab]s, and displays an indicator underneath the currently
 * selected tab. A ScrollableTabRow places its tabs offset from the starting edge, and allows
 * scrolling to tabs that are placed off screen. For a fixed tab row that does not allow
 * scrolling, and evenly places its tabs, see [TabRow].
 *
 * @param selectedTabIndex the index of the currently selected tab
 * @param modifier the [Modifier] to be applied to this tab row
 * @param containerColor the color used for the background of this tab row. Use [Color.Transparent]
 * to have no color.
 * @param contentColor the preferred color for content inside this tab row. Defaults to either the
 * matching content color for [containerColor], or to the current [LocalContentColor] if
 * [containerColor] is not a color from the theme.
 * @param edgePadding the padding between the starting and ending edge of the scrollable tab row,
 * and the tabs inside the row. This padding helps inform the user that this tab row can be
 * scrolled, unlike a [TabRow].
 * @param indicator the indicator that represents which tab is currently selected. By default this
 * will be a [TabRowDefaults.Indicator], using a [TabRowDefaults.tabIndicatorOffset] modifier to
 * animate its position. Note that this indicator will be forced to fill up the entire tab row, so
 * you should use [TabRowDefaults.tabIndicatorOffset] or similar to animate the actual drawn
 * indicator inside this space, and provide an offset from the start.
 * @param divider the divider displayed at the bottom of the tab row. This provides a layer of
 * separation between the tab row and the content displayed underneath.
 * @param tabs the tabs inside this tab row. Typically this will be multiple [Tab]s. Each element
 * inside this lambda will be measured and placed evenly across the row, each taking up equal space.
 */
@ExperimentalSparkApi
@Composable
@Deprecated(
    message = "This component is no longer compliant with Spark specs",
    replaceWith = ReplaceWith(
        expression = "TabGroup(selectedTabIndex, modifier, intent, tabs)",
        imports = ["com.adevinta.spark.components.tab.TabGroup"],
    ),
)
public fun ScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = TabRowDefaults.containerColor,
    contentColor: Color = TabRowDefaults.contentColor,
    edgePadding: Dp = ScrollableTabRowPadding,
    indicator: @Composable (tabPositions: List<TabPosition>) -> Unit = @Composable { tabPositions ->
        TabRowDefaults.Indicator(
            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
        )
    },
    divider: @Composable () -> Unit = @Composable {
        Divider()
    },
    tabs: @Composable () -> Unit,
) {
    MaterialScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        edgePadding = edgePadding,
        indicator = indicator,
        divider = divider,
        tabs = tabs,
    )
}

/**
 * The default padding from the starting edge before a tab in a [ScrollableTabRow].
 */
internal val ScrollableTabRowPadding = 52.dp

@Suppress("DEPRECATION")
@Preview(
    group = "Tabs",
    name = "TabRow",
)
@Composable
private fun TabRowPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    val tabs = mutableListOf("Home", "Search", "Messaging", "Account")
    var selectedIndex by remember { mutableIntStateOf(0) }
    PreviewTheme(theme) {
        TabRow(
            selectedTabIndex = 0,
            tabs = {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        enabled = true,
                        content = {
                            Text(title)
                        },
                    )
                }
            },
        )
    }
}
