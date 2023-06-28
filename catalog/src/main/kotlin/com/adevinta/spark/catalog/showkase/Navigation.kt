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

package com.adevinta.spark.catalog.showkase

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.adevinta.spark.catalog.HomeRoute
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent

internal fun NavGraphBuilder.navGraph(
    navController: NavHostController,
    groupedComponentMap: Map<String, List<ShowkaseBrowserComponent>>,
    contentPadding: PaddingValues,
    showkaseBrowserScreenMetadata: MutableState<ShowkaseBrowserScreenMetadata>,
) {
    composable(
        route = HomeRoute,
    ) {
        HomeScreen(
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
