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
package com.adevinta.spark.components.stepper.internal

import android.R.attr.end
import android.R.attr.endX
import android.R.attr.strokeWidth
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButtonDefaults.borderStroke
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.AnimationDuration
import com.adevinta.spark.components.textfields.DefaultSparkTextFieldColors
import com.adevinta.spark.components.textfields.FormFieldStatus
import com.adevinta.spark.components.textfields.OutlinedBorderContainerBox
import com.adevinta.spark.components.textfields.animateBorderStrokeAsState
import com.adevinta.spark.components.textfields.sparkOutlinedTextFieldColors
import com.adevinta.spark.components.textfields.textFieldBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MiddleText(
    value: Int,
    enabled: Boolean,
    colors: DefaultSparkTextFieldColors,
    status: FormFieldStatus?,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    CompositionLocalProvider(LocalTextSelectionColors provides colors.selectionColors) {
        Box(
            modifier = modifier.widthIn(min = 56.dp),
            propagateMinConstraints = true,
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier = Modifier.padding(
                    vertical = 12.dp,
                    horizontal = 8.dp,
                ),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = numberFormat.format(value),
                    textAlign = TextAlign.Center,
                    style = SparkTheme.typography.body1,
                    maxLines = 1,
                    color = colors.textColor(enabled).value,
                )
            }
            val borderStroke by animateBorderStrokeAsState(
                enabled,
                false,
                status,
                interactionSource,
                colors,
            )
            val containerColor by animateColorAsState(
                targetValue = colors.containerColor(enabled).value,
                animationSpec = tween(durationMillis = AnimationDuration),
            )
            Box(
                Modifier
                    .matchParentSize()
                    .drawBehind {
                        val strokeWidth = borderStroke.width.toPx()
                        val startX = 0f - 1f // Make sure that we don't get a 1px space band du to aliasing
                        val endX = size.width + 1f
                        drawLine(
                            brush = borderStroke.brush,
                            strokeWidth = strokeWidth,
                            start = Offset(startX, strokeWidth / 2),
                            end = Offset(endX, strokeWidth / 2),
                        )
                        drawLine(
                            brush = borderStroke.brush,
                            strokeWidth = strokeWidth,
                            start = Offset(startX, size.height - strokeWidth / 2),
                            end = Offset(endX, size.height - strokeWidth / 2),
                        )
                    }
                    .textFieldBackground({ containerColor }, SparkTheme.shapes.none),
            )
        }
    }
}

@Preview
@Composable
private fun MiddleTextFieldPreview() {
    PreviewTheme {
        MiddleText(
            value = 1,
            status = null,
            enabled = true,
            colors = sparkOutlinedTextFieldColors(),
        )
    }
}
