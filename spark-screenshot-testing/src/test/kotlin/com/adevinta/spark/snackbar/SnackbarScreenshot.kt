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
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adevinta.spark.DefaultTestDevices
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.snackbars.Snackbar
import com.adevinta.spark.components.snackbars.SnackbarIntent
import com.adevinta.spark.components.snackbars.SnackbarSparkVisuals
import com.adevinta.spark.icons.AlarmOnOutline
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.paparazziRule
import com.adevinta.spark.sparkSnapshotNightMode
import org.junit.Rule
import org.junit.Test

class SnackbarScreenshot {

    @get:Rule
    val paparazzi = paparazziRule(
        // fixme: fix to make it portrait while #1190 is not released
        deviceConfig = DefaultTestDevices.Tablet.copy(
            screenHeight = 2560,
            screenWidth = 1800,
        ),
    )

    private val stubtitle = "Title"
    private val stubShortBody = "Lorem ipsum dolor sit amet"
    private val stubBody =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi lacus dolor, " +
            "pulvinar eu nulla sit amet, iaculis interdum."
    private val stubAction = "Action"

    private val BodySnackbar = SnackbarSparkVisuals(stubShortBody)
    private val BodyActionSnackbar = SnackbarSparkVisuals(stubShortBody, actionLabel = stubAction)
    private val BodyIconActionSnackbar = SnackbarSparkVisuals(
        stubShortBody,
        actionLabel = stubAction,
        icon = SparkIcons.AlarmOnOutline,
    )
    private val BodyIconSnackbar = SnackbarSparkVisuals(stubShortBody, icon = SparkIcons.AlarmOnOutline)
    private val BodyIconActionNewLineSnackbar = SnackbarSparkVisuals(
        stubBody,
        actionLabel = stubAction,
        icon = SparkIcons.AlarmOnOutline,
    )
    private val BodyTitleSnackbar = SnackbarSparkVisuals(stubBody, title = stubtitle)
    private val BodyTitleActionSnackbar =
        SnackbarSparkVisuals(stubBody, title = stubtitle, actionLabel = stubAction)

    private val data = listOf(
        BodySnackbar,
        BodyActionSnackbar,
        BodyIconActionSnackbar,
        BodyIconSnackbar,
        BodyIconActionNewLineSnackbar,
        BodyTitleSnackbar,
        BodyTitleActionSnackbar,
    )

    @Test
    fun snackBar() {
        paparazzi.sparkSnapshotNightMode {
            Row {
                SnackbarIntent.entries.forEach { color ->
                    Column(
                        modifier = Modifier.weight(1f),
                    ) {
                        data.forEach { visual ->

                            val iconComposable: (@Composable (iconModifier: Modifier) -> Unit)? =
                                visual.icon?.let { icon ->
                                    @Composable { iconModifier ->
                                        Icon(icon, modifier = iconModifier, contentDescription = null)
                                    }
                                }
                            Snackbar(
                                actionOnNewLine = visual.message == stubBody,
                                colors = color,
                                icon = iconComposable,
                                title = visual.title,
                                actionLabel = visual.actionLabel,
                            ) { Text(visual.message) }
                        }
                    }
                }
            }
        }
    }
}
