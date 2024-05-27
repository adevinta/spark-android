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
package com.adevinta.spark.snackbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.adevinta.spark.DefaultTestDevices
import com.adevinta.spark.components.snackbars.Snackbar
import com.adevinta.spark.components.snackbars.SnackbarIntent
import com.adevinta.spark.icons.LikeFill
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.paparazziRule
import com.adevinta.spark.sparkSnapshotNightMode
import com.android.ide.common.rendering.api.SessionParams
import org.junit.Rule
import org.junit.Test

internal class SnackbarScreenshot {

    @get:Rule
    val paparazzi = paparazziRule(
        renderingMode = SessionParams.RenderingMode.SHRINK,
        deviceConfig = DefaultTestDevices.Tablet,
    )

    @OptIn(ExperimentalLayoutApi::class)
    @Test
    fun snackbarScreenshot() {
        paparazzi.sparkSnapshotNightMode {
            FlowColumn {
                data.forEach { visual ->
                    Row(modifier = Modifier.wrapContentSize()) {
                        Snackbar(
                            modifier = Modifier.wrapContentSize(),
                            intent = visual.intent,
                            style = visual.style,
                            isActionOnNewLine = visual.message == stubBody,
                            isDismissIconEnabled = visual.isDismissIconEnabled,
                            icon = visual.icon,
                            actionLabel = visual.actionLabel,
                        ) { Text(visual.message) }
                    }
                }
            }
        }
    }
}

internal class SnackbarIntentsScreenshot {

    @get:Rule
    val paparazzi = paparazziRule()

    @Test
    fun snackbarIntentsShowcase() {
        paparazzi.sparkSnapshotNightMode {
            Column {
                SnackbarIntent.entries.forEach {
                    Snackbar(
                        intent = it,
                        isDismissIconEnabled = true,
                        icon = SparkIcons.LikeFill,
                        actionLabel = "Action",
                    ) {
                        Text("Lorem ipsum dolor sit amet")
                    }
                }
            }
        }
    }
}
