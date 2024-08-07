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
package com.adevinta.spark.divider

import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.DeviceConfig
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.divider.DividerIntent
import com.adevinta.spark.components.divider.HorizontalDivider
import com.adevinta.spark.components.divider.LabelHorizontalAlignment
import com.adevinta.spark.components.divider.LabelVerticalAlignment
import com.adevinta.spark.components.divider.VerticalDivider
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.paparazziRule
import com.adevinta.spark.sparkSnapshotNightMode
import com.android.ide.common.rendering.api.SessionParams.RenderingMode.SHRINK
import org.junit.Rule
import org.junit.Test

internal class DividerScreenshot {

    private val intents = DividerIntent.entries
    private val labelHorizontalAlignments = LabelHorizontalAlignment.entries
    private val labelVerticalAlignments = LabelVerticalAlignment.entries
    private val hLabelsList = listOf(
        "Spark Label",
        "SparkSparkSparkSparkSparkSparkSparkSparkSparkSparkSpark",
    )
    private val vLabelsList = listOf(
        "Spark Label",
        "Spark\nSpark\nSpark\nSpark\nSpark\nSpark\nSpark\nSpark\nSpark\nSpark\nSpark",
    )

    @get:Rule
    val paparazzi = paparazziRule(
        renderingMode = SHRINK,
        deviceConfig = DeviceConfig.PIXEL_C,
    )

    @Test
    fun horizontal() {
        hLabelsList.forEachIndexed { index, label ->
            paparazzi.sparkSnapshotNightMode(name = index.toString()) { HorizontalDividers(label) }
        }
    }

    @Test
    fun vertical() {
        vLabelsList.forEachIndexed { index, label ->
            paparazzi.sparkSnapshotNightMode(name = index.toString()) { VerticalDividers(label) }
        }
    }

    @Composable
    private fun HorizontalDividers(label: String) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = spacedBy(16.dp),
        ) {
            // Without label
            HorizontalDivider(intent = DividerIntent.Outline)
            HorizontalDivider(intent = DividerIntent.OutlineHigh)

            // With label
            labelHorizontalAlignments.forEach { alignment ->
                intents.forEach {
                    HorizontalDivider(
                        labelHorizontalAlignment = alignment,
                        intent = it,
                        label = {
                            Text(
                                textAlign = TextAlign.Center,
                                style = SparkTheme.typography.body1,
                                text = label,
                                modifier = Modifier.padding(horizontal = 16.dp),
                            )
                        },
                    )
                }
            }
        }
    }

    @Composable
    private fun VerticalDividers(label: String) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = spacedBy(16.dp),
        ) {
            // Without label
            VerticalDivider(intent = DividerIntent.Outline)
            VerticalDivider(intent = DividerIntent.OutlineHigh)

            // With label
            labelVerticalAlignments.forEach { alignment ->
                intents.forEach {
                    VerticalDivider(
                        labelVerticalAlignment = alignment,
                        intent = it,
                        label = {
                            Text(
                                textAlign = TextAlign.Center,
                                style = SparkTheme.typography.body1,
                                text = label,
                                modifier = Modifier.padding(horizontal = 16.dp),
                            )
                        },
                    )
                }
            }
        }
    }
}
