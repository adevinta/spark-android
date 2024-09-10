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
package com.adevinta.spark.catalog.icons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adevinta.spark.icons.SparkIcon

@Composable
public fun IconDemoScreen(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues,
) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = IconsList,
        builder = {
            composable(route = IconsList) {
                IconsScreen(
                    navController = navController,
                    contentPadding = contentPadding,
                )
            }
            composable(
                route = "$IconDemoRoute/{$IconIdArgName}/{$IconNameArgName}/{$IconAnimatedArgName}",
                arguments = listOf(
                    navArgument(IconIdArgName) { type = NavType.IntType },
                    navArgument(IconNameArgName) { type = NavType.StringType },
                    navArgument(IconAnimatedArgName) { type = NavType.BoolType },
                ),
            ) { navBackStackEntry ->
                val arguments = requireNotNull(navBackStackEntry.arguments) { "No arguments" }
                val isAnimated = arguments.getBoolean(IconAnimatedArgName)
                val icon = if (isAnimated) {
                    SparkIcon.AnimatedDrawableRes(arguments.getInt(IconIdArgName))
                } else {
                    SparkIcon.DrawableRes(arguments.getInt(IconIdArgName))
                }
                IconExampleScreen(
                    icon = icon,
                    name = requireNotNull(arguments.getString(IconNameArgName)) { "No name provided for the Icon" },
                    isAnimated = isAnimated,
                )
            }
        },
    )
}

internal const val IconsList = "icons"
internal const val IconDemoRoute = "iconDemo"
internal const val IconIdArgName = "iconId"
internal const val IconNameArgName = "iconName"
internal const val IconAnimatedArgName = "iconAnimated"
