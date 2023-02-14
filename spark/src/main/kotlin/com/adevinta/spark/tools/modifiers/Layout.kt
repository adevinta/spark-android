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

package com.adevinta.spark.tools.modifiers

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillNode
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.node.LayoutModifierNode
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.platform.LocalAutofill
import androidx.compose.ui.platform.LocalAutofillTree
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp

/**
 * Ignore the parent padding by [horizontalPadding].
 * Be careful since concretely it makes the maxWidth bigger which could make this composable clipped by the parent
 * width if misused
 * @param horizontalPadding The horizontal padding to ignore from the parent
 */
@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.ignoreParentHorizontalPadding(horizontalPadding: Dp) = this then modifierElementOf(
    params = horizontalPadding,
    create = { IgnoreParentHorizontalPaddingModifier(horizontalPadding) },
    update = { it.horizontalPadding = horizontalPadding },
    definitions = {
        name = "ignoredParentPadding"
        properties["horizontalPadding"] = horizontalPadding
    },
)

@OptIn(ExperimentalComposeUiApi::class)
private class IgnoreParentHorizontalPaddingModifier(var horizontalPadding: Dp) : Modifier.Node(), LayoutModifierNode {
    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints,
    ): MeasureResult {

        val placeable = measurable.measure(
            constraints.copy(
                maxWidth = constraints.maxWidth + (horizontalPadding * 2).roundToPx(),
            ),
        )
        return layout(placeable.width, placeable.height) {
            placeable.place(x = 0, y = 0)
        }
    }
}

/**
 * Add a dashed border on a Composable
 */
fun Modifier.dashedBorder(width: Dp, radius: Dp, color: Color) = drawBehind {
    drawIntoCanvas {
        val paint = Paint()
            .apply {
                strokeWidth = width.toPx()
                this.color = color
                style = PaintingStyle.Stroke
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
            }
        it.drawRoundRect(
            left = width.toPx(),
            top = width.toPx(),
            right = size.width - width.toPx(),
            bottom = size.height - width.toPx(),
            radiusX = radius.toPx(),
            radiusY = radius.toPx(),
            paint = paint,
        )
    }
}

/**
 * Add autofill support to a given Composable
 *
 * Taken from [Autofill with Jetpack Compose · Bryan Herbst](https://bryanherbst.com/2021/04/13/compose-autofill/)
 */
// TODO-scott.rayapoulle.ext (03-51-2023): Replace by official implementation on b/176949051
@ExperimentalComposeUiApi
fun Modifier.autofill(
    autofillTypes: List<AutofillType>,
    onFill: ((String) -> Unit),
): Modifier = composed {
    val autofill = LocalAutofill.current
    val autofillNode = AutofillNode(onFill = onFill, autofillTypes = autofillTypes)
    LocalAutofillTree.current += autofillNode

    onGloballyPositioned { coordinates ->
        autofillNode.boundingBox = coordinates.boundsInWindow()
    }.onFocusChanged { focusState ->
        if (autofill == null) return@onFocusChanged
        when (focusState.isFocused) {
            true -> autofill.requestAutofillForNode(autofillNode)
            false -> autofill.cancelAutofillForNode(autofillNode)
        }
    }
}
