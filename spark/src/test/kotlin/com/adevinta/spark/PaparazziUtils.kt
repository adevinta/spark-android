package com.adevinta.spark

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.Dp
import app.cash.paparazzi.Paparazzi

internal fun Paparazzi.snapshotPlus(
    name: String? = null,
    drawBackground: Boolean = true,
    composable: @Composable () -> Unit,
): Unit = snapshot(name) {
    // Behave like in Android Studio Preview renderer
    CompositionLocalProvider(LocalInspectionMode provides true) {
        SparkTheme {
            // The first box acts as a shield from ComposeView which forces the first layout node
            // to match it's size. This allows the content below to wrap as needed.
            Box {
                // The second box adds a border and background so we can easily see layout bounds in screenshots
                Box(
                    Modifier
                        .border(Dp.Hairline, Color.Magenta)
                        .background(if (drawBackground) SparkTheme.colors.surface else Color.Transparent),
                ) {
                    composable()
                }
            }
        }
    }
}
