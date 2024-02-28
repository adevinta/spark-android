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

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.R
import com.adevinta.spark.components.card.OutlinedCard
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.tokens.Layout
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent

@Composable
internal fun HomeScreen(
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
    contentPadding: PaddingValues,
    navController: NavHostController,
) {
    HomeScreen(
        groupedTypographyMap = groupedComponentMap,
        contentPadding = contentPadding,
        showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
        navController = navController,
    )
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    groupedTypographyMap: Map<String, List<*>>,
    contentPadding: PaddingValues,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
    navController: NavHostController,
) {
    val filteredMap = getFilteredSearchList(
        groupedTypographyMap.toSortedMap(),
        showkaseBrowserScreenMetadata,
    )

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .consumeWindowInsets(contentPadding),
        columns = GridCells.Fixed(Layout.columns / 2),
        contentPadding = PaddingValues(
            start = Layout.bodyMargin / 2 + contentPadding.calculateLeftPadding(LocalLayoutDirection.current),
            end = Layout.bodyMargin / 2 + contentPadding.calculateRightPadding(LocalLayoutDirection.current),
            top = contentPadding.calculateTopPadding(),
            bottom = contentPadding.calculateBottomPadding(),
        ),
    ) {
        item(
            key = -2,
            contentType = HomeItemType.Header,
            span = { GridItemSpan(2) },
        ) {
            Column(
                modifier = Modifier.padding(
                    horizontal = Layout.bodyMargin / 2,
                    vertical = Layout.gutter,
                ),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "Showkase previews",
                    style = SparkTheme.typography.headline1,
                )
                Text(
                    text = stringResource(R.string.showkase_home_warning_title),
                    style = SparkTheme.typography.subhead,
                )
                Text(
                    text = stringResource(R.string.showkase_home_warning_description),
                    style = SparkTheme.typography.body2,
                )
            }
        }
        items(
            items = filteredMap.entries.toList(),
            key = { it.key },
            span = { GridItemSpan(1) },
            contentType = { HomeItemType.Preview },
            itemContent = { (group, list) ->
                val size = getNumOfUIElements(list)

                OutlinedCard(
                    modifier = Modifier.padding(
                        horizontal = Layout.bodyMargin / 2,
                        vertical = Layout.gutter,
                    ),
                    onClick = {
                        showkaseBrowserScreenMetadata.update {
                            copy(
                                currentGroup = group,
                                isSearchActive = false,
                                searchQuery = null,
                            )
                        }
                        navController.navigate(CurrentScreen.COMPONENTS_IN_A_GROUP)
                    },
                ) {
                    Text(
                        text = "$group ($size)",
                        modifier = Modifier.padding(16.dp),
                        style = SparkTheme.typography.body1,
                    )
                }
            },
        )
    }
    BackHandler {
        when {
            showkaseBrowserScreenMetadata.value.isSearchActive -> {
                showkaseBrowserScreenMetadata.clearActiveSearch()
            }
            navController.currentDestination?.id == navController.graph.startDestinationId -> {
                navController.popBackStack()
            }
        }
    }
}
internal fun getNumOfUIElements(list: List<*>): Int {
    val isComponentList = list.filterIsInstance<ShowkaseBrowserComponent>()
    return when {
        isComponentList.isNotEmpty() -> isComponentList.distinctBy { it.componentName }.size
        else -> list.size
    }
}
internal fun <T> getFilteredSearchList(
    map: Map<String, List<T>>,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) =
    when (showkaseBrowserScreenMetadata.value.isSearchActive) {
        false -> map
        !showkaseBrowserScreenMetadata.value.searchQuery.isNullOrBlank() -> {
            map.filter {
                matchSearchQuery(
                    showkaseBrowserScreenMetadata.value.searchQuery!!,
                    it.key,
                )
            }
        }
        else -> map
    }

internal fun matchSearchQuery(
    searchQuery: String,
    vararg properties: String,
) = properties.any { it.contains(searchQuery, ignoreCase = true) }
private tailrec fun Context.findActivity(): Activity =
    when (this) {
        is Activity -> this
        is ContextWrapper -> this.baseContext.findActivity()
        else -> throw IllegalArgumentException("Could not find activity!")
    }

private enum class HomeItemType {
    Header,
    Preview,
}
