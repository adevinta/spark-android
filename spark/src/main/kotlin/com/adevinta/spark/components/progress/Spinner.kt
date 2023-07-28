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
package com.adevinta.spark.components.progress

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.components.IntentColor
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

/**
 * Spinners provide a visual clue that an action is processing awaiting a course of change or a result.
 * @param intentColor The [IntentColor] to use to draw the spinner
 * @param modifier the [Modifier] to be applied to this component
 * @param size one of the [SpinnerSize]s that defines the size of the component
 * @param isBackgroundVisible whether a background should be added
 */
@InternalSparkApi
@Composable
internal fun SparkSpinner(
    intentColor: IntentColor,
    modifier: Modifier = Modifier,
    size: SpinnerSize = SpinnerDefaults.Size,
    isBackgroundVisible: Boolean = false,
) {
    val stroke = with(LocalDensity.current) {
        Stroke(width = SpinnerDefaults.IndicatorStrokeWidth.toPx(), cap = StrokeCap.Square)
    }
    val transition = rememberInfiniteTransition(label = "Spinner transition")
    val rotation = transition.animateFloat(
        0f,
        SpinnerDefaults.BaseRotationAngle,
        infiniteRepeatable(
            animation = tween(
                durationMillis = SpinnerDefaults.RotationDurationInMillis,
                easing = LinearEasing,
            ),
        ),
        label = "Spinner Base Rotation",
    )
    Canvas(
        modifier
            .progressSemantics()
            .size(size.dp),
    ) {
        val sweep = 180f
        val offset = SpinnerDefaults.StartAngleOffset + rotation.value
        if (isBackgroundVisible) {
            drawCircularIndicator(
                startAngle = 0f,
                sweep = 360f,
                color = intentColor.containerColor,
                stroke = stroke,
            )
        }
        drawCircularIndicator(
            startAngle = offset,
            sweep = sweep,
            color = intentColor.color,
            stroke = stroke,
        )
    }
}

private fun DrawScope.drawCircularIndicator(
    startAngle: Float,
    sweep: Float,
    color: Color,
    stroke: Stroke,
) {
    // To draw this circle we need a rect with edges that line up with the midpoint of the stroke.
    // To do this we need to remove half the stroke width from the total diameter for both sides.
    val diameterOffset = stroke.width / 2
    val arcDimen = size.width - 2 * diameterOffset
    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = sweep,
        useCenter = false,
        topLeft = Offset(diameterOffset, diameterOffset),
        size = Size(arcDimen, arcDimen),
        style = stroke,
    )
}

/**
 * Spinners provide a visual clue that an action is processing awaiting a course of change or a result.
 * @param intent The [SpinnerIntent] colors that will be used to draw the spinner
 * @param modifier the [Modifier] to be applied to this component
 * @param size one of the [SpinnerSize]s that defines the size of the component
 * @param isBackgroundVisible whether a background should be drawn
 */
@Composable
public fun Spinner(
    modifier: Modifier = Modifier,
    intent: SpinnerIntent = SpinnerIntent.Basic,
    size: SpinnerSize = SpinnerDefaults.Size,
    isBackgroundVisible: Boolean = false,
) {
    SparkSpinner(
        intentColor = intent.colors(),
        modifier = modifier.sparkUsageOverlay(),
        size = size,
        isBackgroundVisible = isBackgroundVisible,
    )
}

@Preview(
    group = "Spinner",
    name = "Spinner Medium",
)
@Composable
internal fun PreviewSpinnerMedium(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        SpinnerPreview(size = SpinnerSize.Medium)
    }
}

@Preview(
    group = "Spinner",
    name = "Spinner Small",
)
@Composable
internal fun PreviewSpinnerSmall(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        SpinnerPreview(size = SpinnerSize.Small)
    }
}

@Composable
private fun SpinnerPreview(size: SpinnerSize) {
    SpinnerIntent.values().forEach { intent ->
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(false, true).forEach { isBackgroundVisible ->
                Spinner(intent = intent, size = size, isBackgroundVisible = isBackgroundVisible)
            }
        }
    }
}
