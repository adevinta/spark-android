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
package com.adevinta.spark.catalog

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.backdrop.BackdropScaffold
import com.adevinta.spark.catalog.backdrop.BackdropScaffoldDefaults
import com.adevinta.spark.catalog.backdrop.BackdropValue
import com.adevinta.spark.catalog.backdrop.rememberBackdropScaffoldState
import com.adevinta.spark.catalog.configurator.ConfiguratorComponentsScreen
import com.adevinta.spark.catalog.examples.ComponentsScreen
import com.adevinta.spark.catalog.icons.IconDemoScreen
import com.adevinta.spark.catalog.model.Component
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
import com.adevinta.spark.catalog.themes.themeprovider.kleinanzeigen.KleinanzeigenTheme
import com.adevinta.spark.catalog.themes.themeprovider.leboncoin.LeboncoinTheme
import com.adevinta.spark.catalog.themes.themeprovider.milanuncios.MilanunciosTheme
import com.adevinta.spark.catalog.themes.themeprovider.subito.SubitoTheme
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.google.accompanist.testharness.TestHarness
import kotlinx.coroutines.launch

@OptIn(
    ExperimentalFoundationApi::class,
)
@Composable
internal fun ComponentActivity.CatalogApp(
    theme: Theme,
    onThemeChange: (theme: Theme) -> Unit,
    components: List<Component>,
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) {
    val themeProvider: ThemeProvider = when (theme.brandMode) {
        BrandMode.Leboncoin -> LeboncoinTheme
        BrandMode.Subito -> SubitoTheme
        BrandMode.Kleinanzeigen -> KleinanzeigenTheme
        BrandMode.Milanuncios -> MilanunciosTheme
    }

    val useDark = (theme.themeMode == ThemeMode.System && isSystemInDarkTheme()) || theme.themeMode == ThemeMode.Dark

    val colors =
        themeProvider.colors(useDarkColors = useDark, isPro = theme.userMode == UserMode.Pro)
    val shapes = themeProvider.shapes()
    val typography = themeProvider.typography()

    SparkTheme(
        colors = colors,
        shapes = shapes,
        typography = typography,
    ) {
        CompositionLocalProvider(LocalRippleTheme provides SparkRippleTheme) {
            val layoutDirection = when (theme.textDirection) {
                TextDirection.LTR -> LayoutDirection.Ltr
                TextDirection.RTL -> LayoutDirection.Rtl
                TextDirection.System -> LocalLayoutDirection.current
            }

            // Update the edge to edge configuration to match the theme
            // This is the same parameters as the default enableEdgeToEdge call, but we manually
            // resolve whether or not to show dark theme using uiState, since it can be different
            // than the configuration's dark theme value based on the user preference.
            DisposableEffect(useDark) {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.auto(
                        android.graphics.Color.TRANSPARENT,
                        android.graphics.Color.TRANSPARENT,
                    ) { useDark },
                    navigationBarStyle = SystemBarStyle.auto(
                        lightScrim,
                        darkScrim,
                    ) { useDark },
                )
                onDispose {}
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
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    val coroutineScope = rememberCoroutineScope()
                    val homeScreenValues = CatalogHomeScreen.entries
                    val pagerState = rememberPagerState(
                        initialPage = CatalogHomeScreen.Examples.ordinal,
                        pageCount = { homeScreenValues.size },
                    )

                    BackdropScaffold(
                        scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed),
                        frontLayerScrimColor = Color.Unspecified,
                        headerHeight = BackdropScaffoldDefaults.HeaderHeight +
                            WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding(),
                        peekHeight = BackdropScaffoldDefaults.PeekHeight + WindowInsets.statusBars.asPaddingValues()
                            .calculateTopPadding(),
                        backLayerBackgroundColor = SparkTheme.colors.mainContainer,
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
                                state = pagerState,
                                flingBehavior = PagerDefaults.flingBehavior(state = pagerState),
                            ) {
                                when (homeScreenValues[it]) {
                                    CatalogHomeScreen.Examples -> ComponentsScreen(
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

                                    CatalogHomeScreen.Configurator -> ConfiguratorComponentsScreen(
                                        components = components,
                                        contentPadding = innerPadding,
                                    )

                                    CatalogHomeScreen.Icons -> IconDemoScreen(
                                        contentPadding = innerPadding,
                                    )
                                }
                            }
                        },
                    )
                }
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
    val catalogScreens by remember { mutableStateOf(CatalogHomeScreen.entries) }
    val catalogScreensName by remember {
        derivedStateOf {
            catalogScreens.map { it.name }
        }
    }
    CatalogTabBar(
        modifier = modifier
            .wrapContentWidth()
            .sizeIn(maxWidth = 500.dp),
    ) { tabBarModifier ->
        CatalogTabs(
            modifier = tabBarModifier,
            titles = catalogScreensName,
            tabSelected = tabSelected,
            onTabSelected = { newTab -> onTabSelected(catalogScreens[newTab.ordinal]) },
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
    val showkaseBrowserScreenMetadataState by rememberSaveable {
        mutableStateOf(showkaseBrowserScreenMetadata)
    }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = HomeRoute,
        builder = {
            navGraph(
                navController = navController,
                contentPadding = contentPadding,
                showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadataState,
                groupedComponentMap = groupedComponentMap,
            )
        },
    )
}

private val SheetScrimColor = Color.Black.copy(alpha = 0.4f)

internal const val HomeRoute = "home"

public enum class CatalogHomeScreen { Examples, Showkase, Configurator, Icons }

/**
 * The default light scrim, as defined by androidx and the platform:
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/EdgeToEdge.kt;l=35-38;drc=27e7d52e8604a080133e8b842db10c89b4482598
 */
private val lightScrim = android.graphics.Color.argb(0xe6, 0xFF, 0xFF, 0xFF)

/**
 * The default dark scrim, as defined by androidx and the platform:
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/EdgeToEdge.kt;l=40-44;drc=27e7d52e8604a080133e8b842db10c89b4482598
 */
private val darkScrim = android.graphics.Color.argb(0x80, 0x1b, 0x1b, 0x1b)
