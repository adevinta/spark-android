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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.appbar.TopAppBar
import com.adevinta.spark.components.bottomsheet.ModalBottomSheetLayout
import com.adevinta.spark.components.bottomsheet.ModalBottomSheetValue
import com.adevinta.spark.components.bottomsheet.rememberModalBottomSheetState
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.icons.IconButton
import com.adevinta.spark.components.scaffold.Scaffold
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.sample.themes.BrandMode
import com.adevinta.spark.sample.themes.FontScaleMode
import com.adevinta.spark.sample.themes.TextDirection
import com.adevinta.spark.sample.themes.Theme
import com.adevinta.spark.sample.themes.ThemeMode
import com.adevinta.spark.sample.themes.ThemePicker
import com.adevinta.spark.sample.themes.UserMode
import com.adevinta.spark.sample.themes.themeprovider.ThemeProvider
import com.adevinta.spark.sample.themes.themeprovider.leboncoin.LeBoncoinTheme
import com.adevinta.spark.sample.themes.themeprovider.polaris.PolarisTheme
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.airbnb.android.showkase.ui.SemanticsUtils.lineCountVal
import com.airbnb.android.showkase.ui.ToolbarTitle
import com.google.accompanist.testharness.TestHarness
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ShowkaseBrowserApp(
    theme: Theme,
    onThemeChange: (theme: Theme) -> Unit,
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) {
    val themeProvider: ThemeProvider = when (theme.brandMode) {
        BrandMode.Polaris -> PolarisTheme
        BrandMode.Leboncoin -> LeBoncoinTheme
        BrandMode.LeboncoinLegacy -> LeBoncoinTheme
    }

    val isLegacy = theme.brandMode == BrandMode.LeboncoinLegacy

    val useDark = (theme.themeMode == ThemeMode.System && isSystemInDarkTheme()) || theme.themeMode == ThemeMode.Dark

    val colors =
        themeProvider.colors(useDarkColors = useDark, isPro = theme.userMode == UserMode.Pro, isLegacy = isLegacy)
    val shapes = themeProvider.shapes(isLegacy = isLegacy)
    val typography = themeProvider.typography(isLegacy = isLegacy)

    SparkTheme(
        colors = colors,
        shapes = shapes,
        typography = typography,
        useLegacyStyle = isLegacy,
    ) {
        val layoutDirection = when (theme.textDirection) {
            TextDirection.LTR -> LayoutDirection.Ltr
            TextDirection.RTL -> LayoutDirection.Rtl
            TextDirection.System -> LocalLayoutDirection.current
        }

        TestHarness(
            layoutDirection = layoutDirection,
            fontScale = if (theme.fontScaleMode == FontScaleMode.System) {
                LocalDensity.current.fontScale
            } else {
                theme.fontScale
            },
        ) {
            val navController = rememberNavController()
            val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
            val coroutineScope = rememberCoroutineScope()
            val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
            ModalBottomSheetLayout(
                sheetState = sheetState,
                sheetContent = {
                    ThemePicker(
                        theme = theme,
                        onThemeChange = { theme ->
                            coroutineScope.launch {
                                onThemeChange(theme)
                            }
                        },
                    )
                },
                // Default scrim color is onSurface which is incorrect in dark theme
                // https://issuetracker.google.com/issues/183697056
                scrimColor = SheetScrimColor,
            ) {
                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        AppBar(
                            navController = navController,
                            scrollBehavior = scrollBehavior,
                            metadata = showkaseBrowserScreenMetadata,
                            onThemeClick = { coroutineScope.launch { sheetState.show() } },
                        )
                    },
                    content = {
                        BodyContent(
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
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSparkApi::class)
@Composable
internal fun AppBar(
    navController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior,
    metadata: MutableState<ShowkaseBrowserScreenMetadata>,
    onThemeClick: () -> Unit = {},
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            SampleAppBarTitle(
                isSearchActive = metadata.value.isSearchActive,
                group = metadata.value.currentGroup,
                componentName = metadata.value.currentComponentName,
                componentStyleName = metadata.value.currentComponentStyleName,
                route = currentRoute,
                searchQuery = metadata.value.searchQuery,
                searchQueryValueChange = {
                    metadata.value =
                        metadata.value.copy(searchQuery = it)
                },
                onCloseSearchFieldClick = {
                    metadata.value =
                        metadata.value.copy(isSearchActive = false)
                },
                onClearSearchField = {
                    metadata.value =
                        metadata.value.copy(searchQuery = "")
                },
            )
        },
        actions = {
            ShowkaseAppBarActions(
                metadata = metadata,
                currentRoute = currentRoute,
                onThemeClick = onThemeClick,
            )
        },
    )
}

@Suppress("LongParameterList")
@Composable
private fun SampleAppBarTitle(
    isSearchActive: Boolean,
    group: String?,
    componentName: String?,
    componentStyleName: String?,
    route: String?,
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
            currentRoute = route,
            modifier = modifier,
            currentGroup = group,
            currentComponentName = componentName,
            currentComponentStyleName = componentStyleName,
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
    onThemeClick: () -> Unit = {},
) {
    Row {
        when {
            metadata.value.isSearchActive -> {
            }

            currentRoute == CurrentScreen.COMPONENT_DETAIL.name -> {
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
                IconButton(onClick = onThemeClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_palette_24dp),
                        contentDescription = null,
                    )
                }
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
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = CurrentScreen.COMPONENT_GROUPS.name,
        builder = {
            navGraph(
                navController = navController,
                contentPadding = contentPadding,
                showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
                groupedComponentMap = groupedComponentMap,
            )
        },
    )
}

private fun NavGraphBuilder.navGraph(
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

/**
 * Helper function to navigate to the passed [CurrentScreen]
 */
internal fun NavHostController.navigate(destinationScreen: CurrentScreen) = navigate(destinationScreen.name)

private val SheetScrimColor = Color.Black.copy(alpha = 0.4f)
