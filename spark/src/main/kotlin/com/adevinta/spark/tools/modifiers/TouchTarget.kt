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

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.node.LayoutModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

/**
 * Ensure that the composable has a minimum touch target size
 *
 * Duplicate of Material minimumTouchTargetSize() since it's internal on their side
 */
public fun Modifier.minimumTouchTargetSize(): Modifier = this then MinimumTouchTargetModifier()

private class MinimumTouchTargetModifier : ModifierNodeElement<MinimumTouchTargetModifierNode>() {

    override fun create() = MinimumTouchTargetModifierNode()
    override fun equals(other: Any?): Boolean = true

    override fun hashCode(): Int = 0

    override fun update(node: MinimumTouchTargetModifierNode) = Unit

    override fun InspectorInfo.inspectableProperties() {
        name = "minimumTouchTargetSize"
        properties["README"] = "Adds outer padding to measure at least 48.dp (default) in " +
            "size to disambiguate touch interactions if the element would measure smaller"
    }
}

private class MinimumTouchTargetModifierNode : Modifier.Node(), LayoutModifierNode {

    private val minimumTouchTargetSize = DpSize(44.dp, 44.dp)
    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints,
    ): MeasureResult {
        val placeable = measurable.measure(constraints)

        // Be at least as big as the minimum dimension in both dimensions
        val width = maxOf(placeable.width, minimumTouchTargetSize.width.roundToPx())
        val height = maxOf(placeable.height, minimumTouchTargetSize.height.roundToPx())

        return layout(width, height) {
            val centerX = ((width - placeable.width) / 2f).roundToInt()
            val centerY = ((height - placeable.height) / 2f).roundToInt()
            placeable.place(centerX, centerY)
        }
    }
}
