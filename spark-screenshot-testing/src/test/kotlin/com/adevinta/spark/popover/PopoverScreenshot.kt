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
package com.adevinta.spark.popover

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.MaxPercentDifference
import com.adevinta.spark.PaparazziTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.buttons.ButtonFilled
import com.adevinta.spark.components.popover.Popover
import com.adevinta.spark.components.popover.newapi.rememberTooltipState
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.patchedEnvironment
import com.adevinta.spark.sparkSnapshot
import com.android.ide.common.rendering.api.SessionParams
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalMaterial3Api::class, ExperimentalSparkApi::class)
@RunWith(TestParameterInjector::class)
internal class PopoverScreenshot {

    private val enableList: List<Boolean> = listOf(true, false)

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = MaxPercentDifference,
        theme = PaparazziTheme,
        renderingMode = SessionParams.RenderingMode.SHRINK,
        showSystemUi = true,
        environment = patchedEnvironment(),
        deviceConfig = DeviceConfig.PIXEL_C.copy(
            softButtons = false,
            locale = "fr-rFR",
        ),
    )

    @SuppressLint("CoroutineCreationDuringComposition")
    @OptIn(ExperimentalComposeApi::class)
    @Test
    fun test() = runBlocking {
        val state = rememberTooltipState(isPersistent = true)
        val scope = rememberCoroutineScope()
        val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }

        val press = PressInteraction.Press(Offset.Zero)
        interactionSource.emit(press)
        state.show()
        delay(300)
        interactionSource.emit(PressInteraction.Release(press))

        enableList.forEach { isEnabled ->
            paparazzi.sparkSnapshot(name = "Popover_isDismissEnabled_$isEnabled", true) {


                Column {
                    Popover(
                        popoverContent = {
                            Column {
                                Text(
                                    text = "Title",
                                    modifier = Modifier.padding(bottom = 16.dp),
                                    style = SparkTheme.typography.headline1.copy(fontWeight = FontWeight.Bold),
                                )
                                Text(
                                    text = "Do you want to have this cookie now?",
                                    modifier = Modifier.padding(bottom = 16.dp),
                                    style = SparkTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
                                )
                                Text(
                                    text = "Text Link",
                                    textDecoration = TextDecoration.Underline,
                                    style = SparkTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
                                        .copy(color = SparkTheme.colors.accent),
                                )
                            }
                        },
                        isDismissButtonEnabled = isEnabled,
                        popoverState = state.apply {
                            scope.launch {
                                show()
                            }
                        },
                    ) {
                        scope.launch { state.show() }
                        ButtonFilled(
                            text = "Display Popover",
                            onClick = { scope.launch { state.show() } },
                            interactionSource = interactionSource,
                        )
                    }
                }
            }
        }
    }
}
