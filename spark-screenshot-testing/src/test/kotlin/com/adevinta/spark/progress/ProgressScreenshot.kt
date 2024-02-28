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
package com.adevinta.spark.progress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adevinta.spark.DefaultTestDevices
import com.adevinta.spark.components.progressbar.Progressbar
import com.adevinta.spark.components.progressbar.ProgressbarIntent
import com.adevinta.spark.paparazziRule
import com.adevinta.spark.sparkSnapshot
import com.android.ide.common.rendering.api.SessionParams.RenderingMode.SHRINK
import org.junit.Rule
import org.junit.Test

internal class ProgressScreenshot {

    private val intents = ProgressbarIntent.entries

    @get:Rule
    val paparazzi = paparazziRule(
        renderingMode = SHRINK,
        deviceConfig = DefaultTestDevices.Tablet,
    )

    @Test
    fun normal() {
        paparazzi.sparkSnapshot {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = spacedBy(16.dp),
            ) {
                intents.forEach { intent ->
                    ProgressBars(
                        intent = intent,
                        isRounded = false,
                    )
                }
            }
        }
    }

    @Test
    fun rounded() {
        paparazzi.sparkSnapshot {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = spacedBy(16.dp),
            ) {
                intents.forEach { intent ->
                    ProgressBars(
                        intent = intent,
                        isRounded = true,
                    )
                }
            }
        }
    }

    @Composable
    private fun ProgressBars(
        intent: ProgressbarIntent,
        isRounded: Boolean,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Progressbar(
                progress = { 0.001f },
                intent = intent,
                isRounded = isRounded,
            )
            Progressbar(
                progress = { 0.25f },
                intent = intent,
                isRounded = isRounded,
            )
            Progressbar(
                progress = { 0.9f },
                intent = intent,
                isRounded = isRounded,
            )
            Progressbar(
                progress = { 1f },
                intent = intent,
                isRounded = isRounded,
            )
        }
    }
}
