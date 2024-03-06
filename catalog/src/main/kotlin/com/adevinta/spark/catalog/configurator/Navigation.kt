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
package com.adevinta.spark.catalog.configurator

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.adevinta.spark.catalog.configurator.component.ConfiguratorComponentScreen
import com.adevinta.spark.catalog.model.Component

internal fun NavGraphBuilder.navGraph(
    navController: NavHostController,
    components: List<Component>,
    contentPadding: PaddingValues,
) {
    composable(route = ConfiguratorRoute) {
        ComponentsListScreen(
            components = components,
            navController = navController,
            contentPadding = contentPadding,
        )
    }

    composable(
        route = "$ConfiguratorRoute/" +
            "{$ComponentIdArgName}",
        arguments = listOf(
            navArgument(ComponentIdArgName) { type = NavType.IntType },
        ),
    ) { navBackStackEntry ->
        val arguments = requireNotNull(navBackStackEntry.arguments) { "No arguments" }
        val componentId = arguments.getInt(ComponentIdArgName)
        val component = components.first { component -> component.configurator != null && component.id == componentId }
        ConfiguratorComponentScreen(
            component = component,
            configurator = requireNotNull(component.configurator),
        )
    }
}

internal const val ConfiguratorRoute = "configurator"
internal const val ComponentIdArgName = "componentId"
