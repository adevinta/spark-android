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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.card.Card
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.tokens.Layout
import com.airbnb.android.showkase.models.ShowkaseCategory
import java.util.Locale

@OptIn(ExperimentalLayoutApi::class, ExperimentalSparkApi::class)
@Composable
internal fun ShowkaseCategoriesScreen(
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
    contentPadding: PaddingValues,
    navController: NavHostController,
    categoryMetadataMap: Map<ShowkaseCategory, Int>,
) {
    val activity = LocalContext.current as AppCompatActivity
    LazyVerticalGrid(
        modifier = Modifier.consumedWindowInsets(contentPadding),
        columns = GridCells.Fixed(Layout.columns / 2),
        contentPadding = PaddingValues(
            horizontal = Layout.bodyMargin / 2,
            vertical = Layout.gutter,
        ),
    ) {
        items(
            items = categoryMetadataMap.entries.toList(),
            key = { it.key.name },
            span = { GridItemSpan(2) },
            itemContent = { (category, categorySize) ->
                val defaultLocale = Locale.getDefault()
                val title = category.name
                    .lowercase(defaultLocale)
                    .replaceFirstChar { it.titlecase(defaultLocale) }

                Card(
                    onClick = {
                        showkaseBrowserScreenMetadata.update {
                            copy(
                                currentGroup = null,
                                isSearchActive = false,
                                searchQuery = null,
                            )
                        }
                        navController.navigate(CurrentScreen.COMPONENT_GROUPS)
                    },
                ) {
                    Text(
                        text = "$title ($categorySize)",
                        modifier = Modifier.padding(16.dp),
                        style = SparkTheme.typography.body1,
                    )
                }
            },
        )
    }
    BackHandler {
        goBackFromCategoriesScreen(activity, showkaseBrowserScreenMetadata)
    }
}

private fun goBackFromCategoriesScreen(
    activity: AppCompatActivity,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) {
    val isSearchActive = showkaseBrowserScreenMetadata.value.isSearchActive
    when {
        isSearchActive -> showkaseBrowserScreenMetadata.clearActiveSearch()
        else -> activity.finish()
    }
}

internal fun goBackToCategoriesScreen(
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
    navController: NavHostController,
    onBackPressOnRoot: () -> Unit,
) {
    when {
        showkaseBrowserScreenMetadata.value.isSearchActive -> {
            showkaseBrowserScreenMetadata.clearActiveSearch()
        }

        navController.currentDestination?.id == navController.graph.startDestinationId -> {
            onBackPressOnRoot()
        }

        else -> {
            showkaseBrowserScreenMetadata.clear()
            navController.navigate(CurrentScreen.CATEGORIES)
        }
    }
}
