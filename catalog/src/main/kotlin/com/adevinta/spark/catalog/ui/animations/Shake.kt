/*
 * Copyright (c) 2025 Adevinta
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

package com.adevinta.spark.catalog.ui.animations

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.adevinta.spark.catalog.util.PreviewTheme
import com.adevinta.spark.components.buttons.ButtonIntent
import com.adevinta.spark.components.buttons.ButtonOutlined
import com.adevinta.spark.components.buttons.ButtonTinted
import kotlin.math.roundToInt


@Composable
public fun rememberShakeController(): ShakeController {
    return remember { ShakeController() }
}

public class ShakeController {
    public var shakeConfig: ShakeConfig? by mutableStateOf(null)
        private set

    public fun shake(shakeConfig: ShakeConfig) {
        this.shakeConfig = shakeConfig
    }
}

public data class ShakeConfig(
    val iterations: Int,
    val intensity: Float = 100_000f,
    val rotate: Float = 0f,
    val rotateX: Float = 0f,
    val rotateY: Float = 0f,
    val scaleX: Float = 0f,
    val scaleY: Float = 0f,
    val translateX: Float = 0f,
    val translateY: Float = 0f,
    val trigger: Long = System.currentTimeMillis(),
)

public fun Modifier.shake(shakeController: ShakeController): Modifier = composed {
    shakeController.shakeConfig?.let { shakeConfig ->
        val shake = remember { Animatable(0f) }
        LaunchedEffect(shakeController.shakeConfig) {
            for (i in 0..shakeConfig.iterations) {
                when (i % 2) {
                    0 -> shake.animateTo(1f, spring(stiffness = shakeConfig.intensity))
                    else -> shake.animateTo(-1f, spring(stiffness = shakeConfig.intensity))
                }
            }
            shake.animateTo(0f)
        }

        this
            .graphicsLayer {
                rotationX = shake.value * shakeConfig.rotateX
                rotationY = shake.value * shakeConfig.rotateY
                scaleX = 1f + (shake.value * shakeConfig.scaleX)
                scaleY = 1f + (shake.value * shakeConfig.scaleY)
                rotationZ = shake.value * shakeConfig.rotate
            }
            .offset {
                IntOffset(
                    (shake.value * shakeConfig.translateX).roundToInt(),
                    (shake.value * shakeConfig.translateY).roundToInt(),
                )
            }
    } ?: this
}

@Composable
@Preview
private fun Shaker() {
    PreviewTheme {
        var isValid by remember { mutableStateOf(true) }
        val shakeController = rememberShakeController()
        val validShakeConfig = if (isValid) {
            ShakeConfig(
                iterations = 4,
                intensity = 2_000f,
                rotateY = 15f,
                translateX = 40f,
            )
        } else {
            ShakeConfig(
                iterations = 4,
                intensity = 1_000f,
                rotateX = -20f,
                translateY = 20f,
            )
        }

        ButtonTinted(
            modifier = Modifier.shake(shakeController),
            onClick = {
                shakeController.shake(validShakeConfig)
                isValid = !isValid
            },
            intent = if (isValid) ButtonIntent.Success else ButtonIntent.Danger,
            text = "Shake me",
        )
    }
}
