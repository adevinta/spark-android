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
package com.adevinta.spark.catalog.examples

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import com.adevinta.spark.catalog.AppBasePath
import com.adevinta.spark.catalog.examples.component.Component
import com.adevinta.spark.catalog.examples.example.Example
import com.adevinta.spark.catalog.model.Component
import kotlinx.serialization.Serializable

@Serializable
internal data class ExampleSection(val componentId: String) {
    companion object {
        val deepLinks = listOf(
            navDeepLink<ExampleSection>(basePath = "${AppBasePath}examples/component"),
        )
    }
}

@Serializable
internal data class ExampleShowcase(val componentId: String, val exampleId: String) {

    companion object {
        val deepLinks = listOf(
            navDeepLink<ExampleShowcase>(basePath = "${AppBasePath}examples/component/detail"),
        )
    }
}

internal fun NavGraphBuilder.examplesDestination(
    navController: NavHostController,
    components: List<Component>,
    contentPadding: PaddingValues,
) {
    composable<ExamplesList>(
        deepLinks = ExamplesList.deepLinks,
    ) {
        ComponentsListScreen(
            components = components,
            contentPadding = contentPadding,
            onExampleSectionClick = { id ->
                navController.navigate(route = ExampleSection(componentId = id))
            },
        )
    }

    composable<ExampleSection>(
        deepLinks = ExampleSection.deepLinks,
    ) { navBackStackEntry ->
        val exampleSection = navBackStackEntry.toRoute<ExampleSection>()
        val componentId = exampleSection.componentId
        val component = components.first { component -> component.id == componentId }
        Component(
            component = component,
            contentPadding = contentPadding,
            onExampleClick = { exampleId ->
                navController.navigate(route = ExampleShowcase(componentId = componentId, exampleId = exampleId))
            },
        )
    }
    composable<ExampleShowcase>(
        deepLinks = ExampleShowcase.deepLinks,
    ) { navBackStackEntry ->
        val exampleShowkase = navBackStackEntry.toRoute<ExampleShowcase>()
        val componentId = exampleShowkase.componentId
        val exampleId = exampleShowkase.exampleId
        val component = components.first { component -> component.id == componentId }
        val example = component.examples.first { it.id == exampleId }
        Example(example = example)
    }
}
