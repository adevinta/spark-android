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
package com.adevinta.spark.catalog

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.backdrop.BackdropScaffold
import com.adevinta.spark.catalog.backdrop.BackdropScaffoldDefaults
import com.adevinta.spark.catalog.backdrop.BackdropValue
import com.adevinta.spark.catalog.backdrop.rememberBackdropScaffoldState
import com.adevinta.spark.catalog.examples.ComponentsScreen
import com.adevinta.spark.catalog.examples.model.Component
import com.adevinta.spark.catalog.showkase.ShowkaseBrowserScreenMetadata
import com.adevinta.spark.catalog.showkase.navGraph
import com.adevinta.spark.catalog.tabbar.CatalogTabBar
import com.adevinta.spark.catalog.tabbar.CatalogTabs
import com.adevinta.spark.catalog.themes.BrandMode
import com.adevinta.spark.catalog.themes.FontScaleMode
import com.adevinta.spark.catalog.themes.TextDirection
import com.adevinta.spark.catalog.themes.Theme
import com.adevinta.spark.catalog.themes.ThemeMode
import com.adevinta.spark.catalog.themes.ThemePicker
import com.adevinta.spark.catalog.themes.UserMode
import com.adevinta.spark.catalog.themes.themeprovider.ThemeProvider
import com.adevinta.spark.catalog.themes.themeprovider.leboncoin.LeboncoinTheme
import com.adevinta.spark.catalog.themes.themeprovider.polaris.PolarisTheme
import com.adevinta.spark.components.text.Text
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.google.accompanist.testharness.TestHarness
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
internal fun CatalogApp(
    theme: Theme,
    onThemeChange: (theme: Theme) -> Unit,
    components: List<Component>,
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) {
    val themeProvider: ThemeProvider = when (theme.brandMode) {
        BrandMode.Polaris -> PolarisTheme
        BrandMode.Leboncoin -> LeboncoinTheme
        BrandMode.LeboncoinLegacy -> LeboncoinTheme
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
        CompositionLocalProvider(LocalRippleTheme provides SparkRippleTheme) {
            val layoutDirection = when (theme.textDirection) {
                TextDirection.LTR -> LayoutDirection.Ltr
                TextDirection.RTL -> LayoutDirection.Rtl
                TextDirection.System -> LocalLayoutDirection.current
            }

            TestHarness(
                darkMode = useDark,
                layoutDirection = layoutDirection,
                fontScale = if (theme.fontScaleMode == FontScaleMode.System) {
                    LocalDensity.current.fontScale
                } else {
                    theme.fontScale
                },
            ) {
                val coroutineScope = rememberCoroutineScope()
                val homeScreenValues = CatalogHomeScreen.values()
                val pagerState = rememberPagerState(initialPage = CatalogHomeScreen.Exemples.ordinal)

                BackdropScaffold(
                    scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed),
                    frontLayerScrimColor = Color.Unspecified,
                    headerHeight = BackdropScaffoldDefaults.HeaderHeight + WindowInsets.navigationBars.asPaddingValues()
                        .calculateBottomPadding(),
                    peekHeight = BackdropScaffoldDefaults.PeekHeight + WindowInsets.statusBars.asPaddingValues()
                        .calculateTopPadding(),
                    backLayerBackgroundColor = SparkTheme.colors.primaryContainer,
                    appBar = {
                        HomeTabBar(
                            modifier = Modifier.statusBarsPadding(),
                            tabSelected = homeScreenValues[pagerState.currentPage],
                            onTabSelected = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(
                                        it.ordinal,
                                        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
                                    )
                                }
                            },
                        )
                    },
                    backLayerContent = {
                        ThemePicker(
                            theme = theme,
                            onThemeChange = { theme ->
                                coroutineScope.launch {
                                    onThemeChange(theme)
                                }
                            },
                        )
                    },
                    frontLayerContent = {
                        val insetsPadding = WindowInsets.navigationBars.asPaddingValues()
                        val innerPadding = PaddingValues(
                            top = 16.dp + insetsPadding.calculateTopPadding(),
                            end = insetsPadding.calculateEndPadding(LocalLayoutDirection.current),
                            bottom = insetsPadding.calculateBottomPadding(),
                            start = insetsPadding.calculateStartPadding(LocalLayoutDirection.current),
                        )
                        HorizontalPager(
                            pageCount = homeScreenValues.size,
                            state = pagerState,
                            flingBehavior = PagerDefaults.flingBehavior(state = pagerState, ),
                        ) {
                            when (homeScreenValues[it]) {
                                CatalogHomeScreen.Exemples -> ComponentsScreen(
                                    components = components,
                                    contentPadding = innerPadding,
                                )

                                CatalogHomeScreen.Showkase -> {
                                    BodyContent(
                                        contentPadding = innerPadding,
                                        groupedComponentMap = groupedComponentMap,
                                        showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
                                    )
                                }

                                CatalogHomeScreen.Configurator -> {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.TopCenter,
                                    ) {
                                        Text(
                                            text = stringResource(R.string.configurator_wip_text),
                                            modifier = Modifier
                                                .padding(horizontal = 16.dp, vertical = 32.dp)
                                                .padding(innerPadding),
                                            textAlign = TextAlign.Center,
                                        )
                                    }
                                }
                            }
                        }
                    },
                )
            }
        }
    }
}

@Immutable
private object SparkRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = LocalContentColor.current

    @Composable
    override fun rippleAlpha() = DefaultRippleAlpha
}

private val DefaultRippleAlpha = RippleAlpha(
    pressedAlpha = 0.36f,
    focusedAlpha = 0.24f,
    draggedAlpha = 0.16f,
    hoveredAlpha = 0.24f,
)

@Composable
private fun HomeTabBar(
    tabSelected: CatalogHomeScreen,
    onTabSelected: (CatalogHomeScreen) -> Unit,
    modifier: Modifier = Modifier,
) {
    CatalogTabBar(
        modifier = modifier
            .wrapContentWidth()
            .sizeIn(maxWidth = 500.dp),
    ) { tabBarModifier ->
        CatalogTabs(
            modifier = tabBarModifier,
            titles = CatalogHomeScreen.values().map { it.name },
            tabSelected = tabSelected,
            onTabSelected = { newTab -> onTabSelected(CatalogHomeScreen.values()[newTab.ordinal]) },
        )
    }
}

@Composable
internal fun BodyContent(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues,
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = HomeRoute,
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

private val SheetScrimColor = Color.Black.copy(alpha = 0.4f)

internal const val HomeRoute = "home"

public enum class CatalogHomeScreen {
    Exemples, Showkase, Configurator
}
