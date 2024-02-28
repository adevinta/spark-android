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
package com.adevinta.spark.catalog.showkase

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.card.OutlinedCard
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.tokens.Layout
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ShowkaseComponentsInAGroupScreen(
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
    navController: NavHostController,
    contentPadding: PaddingValues,
) {
    val groupByComponentName = groupedComponentMap[showkaseBrowserScreenMetadata.value.currentGroup]
        ?.groupBy { it.componentName } ?: return
    // Use the default style as the preview if its available or take the first style for the component
    val componentList = groupByComponentName.values.map {
        it.firstOrNull { it.isDefaultStyle } ?: it.first()
    }
    val filteredList = getFilteredSearchList(componentList, showkaseBrowserScreenMetadata)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .consumeWindowInsets(contentPadding),
        contentPadding = PaddingValues(
            start = Layout.bodyMargin / 2 + contentPadding.calculateLeftPadding(LocalLayoutDirection.current),
            end = Layout.bodyMargin / 2 + contentPadding.calculateRightPadding(LocalLayoutDirection.current),
            top = contentPadding.calculateTopPadding(),
            bottom = contentPadding.calculateBottomPadding(),
        ),
    ) {
        items(
            items = filteredList,
            itemContent = { groupComponent ->
                Text(
                    text = groupComponent.componentName,
                    modifier = Modifier
                        .padding(
                            top = 32.dp,
                            bottom = 8.dp,
                        )
                        .padding(
                            horizontal = Layout.bodyMargin / 2,
                        ),
                    style = SparkTheme.typography.subhead,
                )
                val composableModifier = Modifier.generateComposableModifier(groupComponent)
                OutlinedCard(
                    modifier = Modifier
                        .padding(horizontal = Layout.bodyMargin / 2),
                ) {
                    Box {
                        Column(modifier = composableModifier) {
                            groupComponent.component()
                        }
                        // Need to add this as part of the stack so that we can intercept the touch of the
                        // component when we are on the "Group components" screen. If
                        // composableContainerModifier does not have any clickable modifiers, this column has no
                        // impact and the touches go through to the component(this happens in the "Component
                        // Detail" screen.
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .clickable {
                                    showkaseBrowserScreenMetadata.update {
                                        copy(
                                            currentComponentKey = groupComponent.componentKey,
                                            currentComponentName = groupComponent.componentName,
                                            currentComponentStyleName = groupComponent.styleName,
                                            isSearchActive = false,
                                        )
                                    }
                                    navController.navigate(CurrentScreen.COMPONENT_DETAIL)
                                },
                        ) {
                            // empty content to catch the touch events
                        }
                    }
                }
            },
        )
    }
    BackHandler {
        goBackFromComponentsInAGroupScreen(showkaseBrowserScreenMetadata, navController)
    }
}

private fun goBackFromComponentsInAGroupScreen(
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
    navController: NavHostController,
) {
    val isSearchActive = showkaseBrowserScreenMetadata.value.isSearchActive
    when {
        isSearchActive -> showkaseBrowserScreenMetadata.clearActiveSearch()
        else -> {
            showkaseBrowserScreenMetadata.clear()
            navController.popBackStack()
        }
    }
}

private fun getFilteredSearchList(
    list: List<ShowkaseBrowserComponent>,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) =
    when (showkaseBrowserScreenMetadata.value.isSearchActive) {
        false -> list
        !showkaseBrowserScreenMetadata.value.searchQuery.isNullOrBlank() -> {
            list.filter {
                matchSearchQuery(
                    showkaseBrowserScreenMetadata.value.searchQuery!!,
                    it.componentName,
                )
            }
        }

        else -> list
    }
