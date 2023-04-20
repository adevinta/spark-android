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

package com.adevinta.spark.sample

import androidx.activity.compose.BackHandler
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.card.OutlinedCard
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.tokens.Layout
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
internal fun GroupsScreen(
    groupedTypographyMap: Map<String, List<*>>,
    contentPadding: PaddingValues,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
    navController: NavHostController,
    onClick: () -> Unit,
) {
    val filteredMap = getFilteredSearchList(
        groupedTypographyMap.toSortedMap(),
        showkaseBrowserScreenMetadata,
    )

    LazyVerticalGrid(
        modifier = Modifier.consumedWindowInsets(contentPadding),
        columns = GridCells.Fixed(Layout.columns / 2),
        contentPadding = PaddingValues(
            start = Layout.bodyMargin / 2 + contentPadding.calculateLeftPadding(LocalLayoutDirection.current),
            end = Layout.bodyMargin / 2 + contentPadding.calculateRightPadding(LocalLayoutDirection.current),
            top = contentPadding.calculateTopPadding(),
            bottom = contentPadding.calculateBottomPadding(),
        ),
    ) {
        items(
            items = filteredMap.entries.toList(),
            key = { it.key },
            span = { GridItemSpan(1) },
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
                        onClick()
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

    val activity = LocalContext.current as AppCompatActivity
    BackHandler {
        goBackToCategoriesScreen(showkaseBrowserScreenMetadata, navController) { activity.finish() }
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

@Composable
internal fun ShowkaseComponentGroupsScreen(
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
    contentPadding: PaddingValues,
    navController: NavHostController,
) {
    GroupsScreen(
        groupedTypographyMap = groupedComponentMap,
        contentPadding = contentPadding,
        showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
        navController = navController,
    ) {
        navController.navigate(CurrentScreen.COMPONENTS_IN_A_GROUP)
    }
}

internal fun matchSearchQuery(
    searchQuery: String,
    vararg properties: String,
) = properties.any { it.contains(searchQuery, ignoreCase = true) }
