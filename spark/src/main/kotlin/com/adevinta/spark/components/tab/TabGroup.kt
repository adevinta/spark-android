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

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.components.badge.Badge
import com.adevinta.spark.components.divider.SparkDivider
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.tab.TabGroupDefaults.tabIndicatorOffset
import com.adevinta.spark.icons.AccountFill
import com.adevinta.spark.icons.MessageOutline
import com.adevinta.spark.icons.Search
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@InternalSparkApi
@Composable
internal fun SparkTabGroup(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    justified: Boolean = true,
    selectedContentColor: TabSelectedContentColor = TabSelectedContentColor.Primary,
    indicator: @Composable (tabPositions: List<TabPosition>) -> Unit = @Composable { tabPositions ->
        TabGroupDefaults.Indicator(
            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
            color = selectedContentColor.color(),
        )
    },
    spaceEvenly: @Composable () -> Unit = @Composable {
        SparkDivider()
    },
    tabs: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
    ) {
        val scrollState = rememberScrollState()
        val coroutineScope = rememberCoroutineScope()
        val scrollableTabData = remember(scrollState, coroutineScope) {
            ScrollableTabData(
                scrollState = scrollState,
                coroutineScope = coroutineScope,
            )
        }
        var tabRowWidth by remember { mutableStateOf(Int.MAX_VALUE) }
        BoxWithConstraints {
            tabRowWidth = constraints.maxWidth
        }
        SubcomposeLayout(
            Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.CenterStart)
                .horizontalScroll(scrollState)
                .selectableGroup()
                .clipToBounds(),
        ) { constraints ->
            val minTabWidth = TabGroupDefaults.minTabWidth.roundToPx()
            val tabMeasurables = subcompose(TabSlots.Tabs, tabs)
            val layoutHeight = tabMeasurables.fold(initial = 0) { curr, measurable ->
                maxOf(curr, measurable.maxIntrinsicHeight(Constraints.Infinity))
            }
            val tabCount = tabMeasurables.size
            val tabWidth = (tabRowWidth / tabCount)
            val tabConstraints = constraints.copy(minWidth = minTabWidth, minHeight = layoutHeight)

            val layoutWidth = tabMeasurables.fold(initial = 0) { curr, measurable ->
                curr + maxOf(minTabWidth, measurable.maxIntrinsicWidth(Constraints.Infinity))
            }

            val scrollable = !(justified && tabRowWidth >= layoutWidth)
            val tabPlaceables = tabMeasurables.map {
                it.measure(
                    if (scrollable) tabConstraints else tabConstraints.copy(
                        minWidth = tabWidth,
                        maxWidth = tabWidth,
                    ),
                )
            }

            val tabPositions: MutableList<TabPosition> = mutableListOf()
            layout(if (scrollable) layoutWidth else tabRowWidth, layoutHeight) {
                /* Tabs */
                var left = 0
                tabPlaceables.forEach {
                    it.placeRelative(left, 0)
                    tabPositions.add(TabPosition(left = left.toDp(), width = it.width.toDp()))
                    left += it.width
                }
                /* Divider */
                subcompose(TabSlots.Divider, spaceEvenly).forEach {
                    val placeable = it.measure(
                        constraints.copy(
                            minHeight = 0,
                            minWidth = if (scrollable) layoutWidth else tabRowWidth,
                            maxWidth = if (scrollable) layoutWidth else tabRowWidth,
                        ),
                    )
                    placeable.placeRelative(0, layoutHeight - placeable.height)
                }
                /* Indicator */
                subcompose(TabSlots.Indicator) {
                    indicator(tabPositions)
                }.forEach {
                    it.measure(Constraints.fixed(if (scrollable) layoutWidth else tabRowWidth, layoutHeight))
                        .placeRelative(0, 0)
                }

                scrollableTabData.onLaidOut(
                    density = this@SubcomposeLayout,
                    edgeOffset = 0,
                    tabPositions = tabPositions,
                    selectedTab = selectedTabIndex,
                )
            }
        }
    }
}

private enum class TabSlots {
    Tabs,
    Divider,
    Indicator
}


/**
 * Class holding onto state needed for [ScrollableTabRow]
 */
private class ScrollableTabData(
    private val scrollState: ScrollState,
    private val coroutineScope: CoroutineScope,
) {
    private var selectedTab: Int? = null

    fun onLaidOut(
        density: Density,
        edgeOffset: Int,
        tabPositions: List<TabPosition>,
        selectedTab: Int,
    ) {
        // Animate if the new tab is different from the old tab, or this is called for the first
        // time (i.e selectedTab is `null`).
        if (this.selectedTab != selectedTab) {
            this.selectedTab = selectedTab
            tabPositions.getOrNull(selectedTab)?.let {
                // Scrolls to the tab with [tabPosition], trying to place it in the center of the
                // screen or as close to the center as possible.
                val calculatedOffset = it.calculateTabOffset(density, edgeOffset, tabPositions)
                if (scrollState.value != calculatedOffset) {
                    coroutineScope.launch {
                        scrollState.animateScrollTo(
                            calculatedOffset,
                            animationSpec = TabGroupDefaults.ScrollableTabRowScrollSpec,
                        )
                    }
                }
            }
        }
    }

    /**
     * @return the offset required to horizontally center the tab inside this TabRow.
     * If the tab is at the start / end, and there is not enough space to fully centre the tab, this
     * will just clamp to the min / max position given the max width.
     */
    private fun TabPosition.calculateTabOffset(
        density: Density,
        edgeOffset: Int,
        tabPositions: List<TabPosition>,
    ): Int = with(density) {
        val totalTabRowWidth = tabPositions.last().right.roundToPx() + edgeOffset
        val visibleWidth = totalTabRowWidth - scrollState.maxValue
        val tabOffset = left.roundToPx()
        val scrollerCenter = visibleWidth / 2
        val tabWidth = width.roundToPx()
        val centeredTabOffset = tabOffset - (scrollerCenter - tabWidth / 2)
        // How much space we have to scroll. If the visible width is <= to the total width, then
        // we have no space to scroll as everything is always visible.
        val availableSpace = (totalTabRowWidth - visibleWidth).coerceAtLeast(0)
        return centeredTabOffset.coerceIn(0, availableSpace)
    }
}


/**
 * Data class that contains information about a tab's position on screen, used for calculating
 * where to place the indicator that shows which tab is selected.
 *
 * @property left the left edge's x position from the start of the [TabRow]
 * @property right the right edge's x position from the start of the [TabRow]
 * @property width the width of this tab
 */
@Immutable
internal class TabPosition internal constructor(val left: Dp, val width: Dp) {
    internal val right: Dp get() = left + width

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TabPosition) return false

        if (left != other.left) return false
        if (width != other.width) return false

        return true
    }

    override fun hashCode(): Int {
        var result = left.hashCode()
        result = 31 * result + width.hashCode()
        return result
    }

    override fun toString(): String {
        return "TabPosition(left=$left, right=$right, width=$width)"
    }
}


@Preview(
    group = "Tabs",
    name = "TabGroup",
)
@Composable
internal fun TabGroupPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    val tabs = mutableListOf(
        Pair("Home", null) to 0,
        Pair("Search", SparkIcons.Search) to 0,
        Pair("Message", SparkIcons.MessageOutline) to 0,
        Pair(null, SparkIcons.AccountFill) to 0,
    )
    var selectedIndex by remember { mutableStateOf(0) }
    PreviewTheme(theme) {
        TabStyle.values().forEach { tabStyle ->
            TabSelectedContentColor.values().forEach { color ->
                SparkTabGroup(
                    selectedTabIndex = selectedIndex,
                    selectedContentColor = color,
                ) {
                    tabs.forEachIndexed { index, (tab, unread) ->
                        SparkTab(
                            selectedContentColor = color.color(),
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index },
                            enabled = true,
                            icon = tab.second,
                            text = tab.first,
                            style = tabStyle,
                            trailingContent = {
                                if (unread > 0) {
                                    Badge(count = unread)
                                } else Unit
                            },
                        )
                    }
                }
            }
        }
    }
}

@Preview(
    group = "Tabs",
    name = "TabGroup with Fixed Size",
)
@Composable
internal fun TabGroupFixedSizePreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    val tabs = mutableListOf(
        Pair("Home", null) to 0,
        Pair("Message", SparkIcons.MessageOutline) to 100,
    )
    var selectedIndex by remember { mutableStateOf(0) }
    PreviewTheme(theme) {
        TabStyle.values().forEach { tabStyle ->
            TabSelectedContentColor.values().forEach { color ->
                SparkTabGroup(
                    selectedTabIndex = selectedIndex,
                    selectedContentColor = color,
                ) {
                    tabs.forEachIndexed { index, (tab, unread) ->
                        SparkTab(
                            selectedContentColor = color.color(),
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index },
                            enabled = true,
                            icon = tab.second,
                            text = tab.first,
                            style = tabStyle,
                            trailingContent = {
                                if (unread > 0) {
                                    Badge(count = unread)
                                } else Unit
                            },
                        )
                    }
                }
            }
        }
    }
}
