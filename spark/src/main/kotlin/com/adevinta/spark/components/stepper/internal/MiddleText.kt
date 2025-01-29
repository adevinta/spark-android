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

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.stepper.StepperDefaults
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.AnimationDuration
import com.adevinta.spark.components.textfields.DefaultSparkTextFieldColors
import com.adevinta.spark.components.textfields.FormFieldStatus
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
            modifier = modifier
                .widthIn(min = 56.dp)
                .clipToBounds(), // clip the text animation otherwise it'll show above the border
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
                AnimatedContent(
                    targetState = value,
                    contentAlignment = Alignment.Center,
                    transitionSpec = {
                        // Compare the incoming number with the previous number.
                        if (targetState > initialState) {
                            // If the target number is larger, it slides up and fades in
                            // while the initial (smaller) number slides up and fades out.
                            slideInVertically(
                                StepperDefaults.textAnimationSpec,
                            ) { height -> height } + fadeIn() togetherWith slideOutVertically(
                                StepperDefaults.textAnimationSpec,
                            ) { height -> -height } + fadeOut()
                        } else {
                            // If the target number is smaller, it slides down and fades in
                            // while the initial number slides down and fades out.
                            slideInVertically(
                                StepperDefaults.textAnimationSpec,
                            ) { height -> -height } + fadeIn() togetherWith slideOutVertically(
                                StepperDefaults.textAnimationSpec,
                            ) { height -> height } + fadeOut()
                        }.using(
                            // Disable clipping since the faded slide-in/out should
                            // be displayed out of bounds.
                            SizeTransform(clip = false),
                        )
                    },
                ) { count ->
                    Text(
                        text = numberFormat.format(count),
                        textAlign = TextAlign.Center,
                        style = SparkTheme.typography.body1,
                        maxLines = 1,
                        color = colors.textColor(enabled).value,
                    )
                }
            }
            DecorationBox(enabled, status, interactionSource, colors)
        }
    }
}

@Composable
private fun BoxScope.DecorationBox(
    enabled: Boolean,
    status: FormFieldStatus?,
    interactionSource: MutableInteractionSource,
    colors: DefaultSparkTextFieldColors,
) {
    val borderStroke by animateBorderStrokeAsState(
        enabled = enabled,
        readOnly = false,
        state = status,
        interactionSource = interactionSource,
        colors = colors,
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
