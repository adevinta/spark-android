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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.appbar.TopAppBar
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.icons.IconButton
import com.adevinta.spark.components.scaffold.Scaffold
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tokens.darkSparkColors
import com.adevinta.spark.tokens.lightSparkColors
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.airbnb.android.showkase.models.ShowkaseCategory
import com.airbnb.android.showkase.ui.SemanticsUtils.lineCountVal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ShowkaseBrowserApp(
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) {
    val colors = if (isSystemInDarkTheme()) darkSparkColors() else lightSparkColors()
    SparkTheme(colors = colors) {
        CompositionLocalProvider(
            LocalInspectionMode provides true,
        ) {
            val navController = rememberNavController()
            val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
            Scaffold(
                modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                topBar = {
                    AppBar(
                        navController = navController,
                        scrollBehavior = scrollBehavior,
                        showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
                    )
                },
                content = {
                    BodyContent(
//                        modifier = Modifier.fillMaxSize(),
                        contentPadding = it,
                        navController = navController,
                        groupedComponentMap = groupedComponentMap,
                        showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
                    )
                },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSparkApi::class)
@Composable
internal fun AppBar(
    navController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            SampleAppBarTitle(
                isSearchActive = showkaseBrowserScreenMetadata.value.isSearchActive,
                currentGroup = showkaseBrowserScreenMetadata.value.currentGroup,
                currentComponentName = showkaseBrowserScreenMetadata.value.currentComponentName,
                currentComponentStyleName = showkaseBrowserScreenMetadata.value.currentComponentStyleName,
                currentRoute = currentRoute,
                searchQuery = showkaseBrowserScreenMetadata.value.searchQuery,
                searchQueryValueChange = {
                    showkaseBrowserScreenMetadata.value =
                        showkaseBrowserScreenMetadata.value.copy(searchQuery = it)
                },
                onCloseSearchFieldClick = {
                    showkaseBrowserScreenMetadata.value =
                        showkaseBrowserScreenMetadata.value.copy(isSearchActive = false)
                },
                onClearSearchField = {
                    showkaseBrowserScreenMetadata.value =
                        showkaseBrowserScreenMetadata.value.copy(searchQuery = "")
                },
            )
        },
        actions = {
            ShowkaseAppBarActions(
                showkaseBrowserScreenMetadata,
                currentRoute,
            )
        },
    )
}

@Suppress("LongParameterList")
@Composable
private fun SampleAppBarTitle(
    isSearchActive: Boolean,
    currentGroup: String?,
    currentComponentName: String?,
    currentComponentStyleName: String?,
    currentRoute: String?,
    searchQuery: String?,
    searchQueryValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onCloseSearchFieldClick: () -> Unit,
    onClearSearchField: () -> Unit,
) {

    AnimatedVisibility(
        visible = isSearchActive,
        enter = expandHorizontally(),
        exit = shrinkHorizontally(),
    ) {
        SearchField(
            searchQuery = searchQuery,
            searchQueryValueChange = searchQueryValueChange,
            onCloseSearchFieldClick = onCloseSearchFieldClick,
            onClearSearchField = onClearSearchField,
        )
    }
    AnimatedVisibility(
        visible = !isSearchActive,
        enter = slideInHorizontally() + expandIn(),
    ) {
        AppBarTitle(
            currentRoute = currentRoute,
            modifier = modifier,
            currentGroup = currentGroup,
            currentComponentName = currentComponentName,
            currentComponentStyleName = currentComponentStyleName,
        )
    }
}

@Composable
private fun AppBarTitle(
    modifier: Modifier,
    currentRoute: String?,
    currentGroup: String?,
    currentComponentName: String?,
    currentComponentStyleName: String?,
) {
    when {
        currentRoute == CurrentScreen.CATEGORIES.name -> {
            ToolbarTitle(stringResource(R.string.app_name), modifier)
        }

        currentRoute == CurrentScreen.COMPONENT_GROUPS.name -> {
            ToolbarTitle(stringResource(R.string.components_category), modifier)
        }

        currentRoute.insideGroup() -> {
            ToolbarTitle(currentGroup ?: "currentGroup", modifier)
        }

        currentRoute == CurrentScreen.COMPONENT_STYLES.name -> {
            ToolbarTitle(currentComponentName.orEmpty(), modifier)
        }

        currentRoute == CurrentScreen.COMPONENT_DETAIL.name -> {
            val styleName = currentComponentStyleName?.let { "[$it]" }.orEmpty()
            ToolbarTitle(
                string = "${currentComponentName.orEmpty()} $styleName",
                modifier = modifier,
            )
        }
    }
}


@Composable
public fun ToolbarTitle(
    string: String,
    modifier: Modifier,
) {
    val lineCount = remember { mutableStateOf(0) }

    Text(
        text = string,
        modifier = modifier.semantics {
            lineCountVal = lineCount.value
        },
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        onTextLayout = {
            lineCount.value = it.lineCount
        },
    )
}

@Composable
internal fun SearchField(
    searchQuery: String?,
    searchQueryValueChange: (String) -> Unit,
    onCloseSearchFieldClick: () -> Unit,
    onClearSearchField: () -> Unit,
) {
    TextField(
        value = searchQuery.orEmpty(),
        // Update value of textValue with the latest value of the text field
        onValueChange = searchQueryValueChange,
        label = LocalContext.current.getString(R.string.search_label),
        modifier = Modifier
            .testTag("SearchTextField")
            .fillMaxWidth(),
        leadingIcon = {
            IconButton(
                onClick = onCloseSearchFieldClick,
                modifier = Modifier.testTag("close_search_bar_tag"),
            ) {
                Icon(sparkIcon = SparkIcon.Actions.Search, contentDescription = "Search Icon")
            }
        },
        trailingIcon = {
            IconButton(
                onClick = onClearSearchField,
                modifier = Modifier.testTag("clear_search_field"),
                enabled = !searchQuery.isNullOrEmpty(),
            ) {
                Icon(sparkIcon = SparkIcon.Arrows.Close.Full, contentDescription = "Clear Search Field")
            }
        },
    )
}

@Composable
private fun ShowkaseAppBarActions(
    metadata: MutableState<ShowkaseBrowserScreenMetadata>,
    currentRoute: String?,
    modifier: Modifier = Modifier,
) {
    when {
        metadata.value.isSearchActive -> {
        }

        currentRoute == CurrentScreen.COMPONENT_DETAIL.name ||
                currentRoute == CurrentScreen.CATEGORIES.name -> {
        }

        else -> {
            IconButton(
                modifier = modifier.testTag("SearchIcon"),
                onClick = {
                    metadata.value = metadata.value.copy(isSearchActive = true)
                },
            ) {
                Icon(sparkIcon = SparkIcon.Actions.Search, contentDescription = "Search Icon")
            }
        }
    }
}

@Composable
internal fun BodyContent(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues,
    navController: NavHostController,
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) {
    val startDestination = startDestination()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        builder = {
            navGraph(
                navController,
                contentPadding = contentPadding,
                showkaseBrowserScreenMetadata,
                groupedComponentMap,
            )
        },
    )
}

private fun startDestination(
) = CurrentScreen.COMPONENT_GROUPS.name

private fun NavGraphBuilder.navGraph(
    navController: NavHostController,
    contentPadding: PaddingValues,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
) = fullNavGraph(
    navController,
    contentPadding = contentPadding,
    groupedComponentMap,
    showkaseBrowserScreenMetadata,
)

private fun NavGraphBuilder.componentsNavGraph(
    navController: NavHostController,
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
    contentPadding: PaddingValues,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) {
    composable(CurrentScreen.COMPONENT_GROUPS.name) {
        ShowkaseComponentGroupsScreen(
            groupedComponentMap = groupedComponentMap,
            showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
            contentPadding = contentPadding,
            navController = navController,
        )
    }
    composable(CurrentScreen.COMPONENTS_IN_A_GROUP.name) {
        ShowkaseComponentsInAGroupScreen(
            groupedComponentMap = groupedComponentMap,
            showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
            navController = navController,
            contentPadding = contentPadding,
        )
    }
    composable(CurrentScreen.COMPONENT_DETAIL.name) {
        ComponentDetailScreen(
            groupedComponentMap = groupedComponentMap,
            showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
            navController = navController,
            contentPadding = contentPadding,
        )
    }
}

private fun NavGraphBuilder.fullNavGraph(
    navController: NavHostController,
    contentPadding: PaddingValues,
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) {
    composable(CurrentScreen.CATEGORIES.name) {
        ShowkaseCategoriesScreen(
            showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
            navController = navController,
            contentPadding = contentPadding,
            categoryMetadataMap = getCategoryMetadataMap(groupedComponentMap),
        )
    }
    componentsNavGraph(
        navController = navController,
        groupedComponentMap = groupedComponentMap,
        contentPadding = contentPadding,
        showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
    )
}

private fun getCategoryMetadataMap(
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
) = mapOf(
    ShowkaseCategory.COMPONENTS to groupedComponentMap.flatComponentCount(),
)

private fun Map<String, List<ShowkaseBrowserComponent>>.flatComponentCount() = flatMap { entry ->
    // Only group name and component name is taken into account for the count to ensure that the
    // styles of the same component aren't added  in this calculation.
    entry.value.distinctBy { "${it.group}_${it.componentName}" }
}.count()

/**
 * Helper function to navigate to the passed [CurrentScreen]
 */
internal fun NavHostController.navigate(destinationScreen: CurrentScreen) =
    navigate(destinationScreen.name)
