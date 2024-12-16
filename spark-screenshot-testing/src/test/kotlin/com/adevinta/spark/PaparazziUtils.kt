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
package com.adevinta.spark

import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalInspectionMode
import app.cash.paparazzi.Paparazzi
import com.adevinta.spark.tokens.darkSparkColors
import com.adevinta.spark.tokens.lightSparkColors

internal fun Paparazzi.sparkSnapshot(
    name: String? = null,
    drawBackground: Boolean = true,
    isDark: Boolean = false,
    composable: @Composable () -> Unit,
): Unit = snapshot(name) {
    // Behave like in Android Studio Preview renderer
    CompositionLocalProvider(LocalInspectionMode provides true) {
        SparkTheme(
            colors = if (isDark) darkSparkColors() else lightSparkColors(),
        ) {
            // The first box acts as a shield from ComposeView which forces the first layout node
            // to match it's size. This allows the content below to wrap as needed.
            Box {
                // The second box adds a border and background so we can easily see layout bounds in screenshots
                Box(
                    Modifier.background(if (drawBackground) SparkTheme.colors.surface else Color.Transparent),
                ) {
                    composable()
                }
            }
        }
    }
}

internal fun Paparazzi.gifView(
    drawBackground: Boolean = true,
    isDark: Boolean = false,
    composable: @Composable () -> Unit,
): View {
    val view = ComposeView(context)
    view.setContent {
        // Behave like in Android Studio Preview renderer
        CompositionLocalProvider(LocalInspectionMode provides true) {
            SparkTheme(
                colors = if (isDark) darkSparkColors() else lightSparkColors(),
            ) {
                // The first box acts as a shield from ComposeView which forces the first layout node
                // to match it's size. This allows the content below to wrap as needed.
                Box {
                    // The second box adds a border and background so we can easily see layout bounds in screenshots
                    Box(
                        Modifier.background(if (drawBackground) SparkTheme.colors.surface else Color.Transparent),
                    ) {
                        composable()
                    }
                }
            }
        }
    }
    return view
}

/**
 * Generate 3 screenshots for each device: phone, tablet and foldable
 */
internal fun Paparazzi.sparkSnapshotDevices(
    name: String? = null,
    drawBackground: Boolean = true,
    isDark: Boolean = false,
    composable: @Composable () -> Unit,
) {
    DefaultTestDevices.devices.forEach { deviceConfig ->
        unsafeUpdateConfig(
            deviceConfig = deviceConfig,
        )
        sparkSnapshot(name.orEmpty() + "_${deviceConfig.screenWidth}", drawBackground, isDark, composable)
    }
}

/**
 * Generate 2 screenshots for each theme: light and dark
 */
internal fun Paparazzi.sparkSnapshotNightMode(
    name: String? = null,
    drawBackground: Boolean = true,
    composable: @Composable () -> Unit,
) {
    var lightTextThrowable: Throwable? = null
    ThemeVariant.entries.forEach {
        try {
            sparkSnapshot(
                name = name.orEmpty() + "_${it.name}",
                drawBackground = drawBackground,
                isDark = it == ThemeVariant.Dark,
                composable = composable,
            )
        } catch (e: Throwable) {
            // Prioritize the light exception over the dark one since we will still get the paparazzi delta image
            // for the dark one
            if (it == ThemeVariant.Dark) throw lightTextThrowable ?: e

            // Skip light exception otherwise we loose the information that also the dark one has failed.
            lightTextThrowable = e
        }
    }
}

enum class ThemeVariant { Light, Dark }
