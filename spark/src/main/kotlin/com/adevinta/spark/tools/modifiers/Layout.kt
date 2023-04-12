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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.node.LayoutModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.InspectorInfo
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
public fun Modifier.ignoreParentHorizontalPadding(horizontalPadding: Dp): Modifier =
    this then IgnoreParentHorizontalPaddingModifier(horizontalPadding)

@OptIn(ExperimentalComposeUiApi::class)
private data class IgnoreParentHorizontalPaddingModifier(
    private val horizontalPadding: Dp,
) : ModifierNodeElement<IgnoreParentHorizontalPaddingModifierNode>() {

    override fun create(): IgnoreParentHorizontalPaddingModifierNode {
        return IgnoreParentHorizontalPaddingModifierNode(horizontalPadding)
    }

    override fun update(node: IgnoreParentHorizontalPaddingModifierNode): IgnoreParentHorizontalPaddingModifierNode {
        return node.apply {
        }
    }

    override fun InspectorInfo.inspectableProperties() {
        name = "ignoredParentPadding"
        properties["horizontalPadding"] = horizontalPadding
    }
}

@OptIn(ExperimentalComposeUiApi::class)
private class IgnoreParentHorizontalPaddingModifierNode(var horizontalPadding: Dp) : Modifier.Node(),
    LayoutModifierNode {
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
 * Add autofill support to a given Composable
 *
 * Taken from [Autofill with Jetpack Compose · Bryan Herbst](https://bryanherbst.com/2021/04/13/compose-autofill/)
 */
// TODO-@Soulcramer (03-51-2023): Replace by official implementation on b/176949051
@ExperimentalComposeUiApi
public fun Modifier.autofill(
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
