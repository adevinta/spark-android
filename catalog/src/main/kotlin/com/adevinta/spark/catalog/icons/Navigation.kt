/*
 * Copyright (c) 2024 Adevinta
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
package com.adevinta.spark.catalog.icons

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import com.adevinta.spark.catalog.AppBasePath
import com.adevinta.spark.icons.SparkIcon
import kotlinx.serialization.Serializable

@Serializable
internal data class IconShowcase(val iconId: Int, val iconName: String, val isIconAnimated: Boolean) {
    companion object {
        val deepLinks = listOf(
            navDeepLink<IconShowcase>(basePath = "${AppBasePath}icons/detail"),
        )
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
internal fun NavGraphBuilder.iconsDemoDestination(
    navController: NavHostController,
    contentPadding: PaddingValues,
    sharedTransitionScope: SharedTransitionScope,
) {
    composable<IconsList>(
        deepLinks = IconsList.deepLinks,
    ) {
        IconsScreen(
            contentPadding = contentPadding,
            sharedTransitionScope = sharedTransitionScope,
            animatedContentScope = this@composable,
            onIconClick = { id, name, isAnimated ->
                navController.navigate(
                    route = IconShowcase(iconId = id, iconName = name, isIconAnimated = isAnimated),
                )
            },
        )
    }

    composable<IconShowcase>(
        deepLinks = IconShowcase.deepLinks,
    ) { navBackStackEntry ->
        val iconShowcase = navBackStackEntry.toRoute<IconShowcase>()
        val iconId = iconShowcase.iconId
        val iconName = iconShowcase.iconName
        val isIconAnimated = iconShowcase.isIconAnimated
        val icon = if (isIconAnimated) {
            SparkIcon.AnimatedDrawableRes(iconId)
        } else {
            SparkIcon.DrawableRes(iconId)
        }
        IconExampleScreen(
            icon = icon,
            name = iconName,
            isAnimated = isIconAnimated,
            sharedTransitionScope = sharedTransitionScope,
            animatedContentScope = this@composable,
        )
    }
}
