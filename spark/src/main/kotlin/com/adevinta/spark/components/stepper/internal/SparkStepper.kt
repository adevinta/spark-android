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

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.setProgress
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.textfields.FormFieldStatus
import com.adevinta.spark.components.textfields.sparkOutlinedTextFieldColors
import com.adevinta.spark.icons.Minus
import com.adevinta.spark.icons.Plus
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.modifiers.ifTrue
import com.adevinta.spark.tools.modifiers.invisibleSemantic
import kotlin.math.roundToInt

@Composable
internal fun SparkStepper(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    range: IntRange = 0..10,
    enabled: Boolean = true,
    status: FormFieldStatus? = null,
    isFlexible: Boolean = false,
    testTag: String? = null,
    allowSemantics: Boolean = true,
) {
    val colors = sparkOutlinedTextFieldColors(
        unfocusedBorderColor = SparkTheme.colors.outline,
    )
    val coerced = value.coerceIn(range)
    fun setValue(value: Int) =
        onValueChange(value.coerceIn(range))

    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .ifTrue(allowSemantics) {
                stepperSemantics(
                    value = value,
                    onValueChange = ::setValue,
                    range = range,
                    enabled = enabled,
                )
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = Modifier
                .fillMaxHeight()
                .offset(x = 1.dp) // overlap with the MiddleTextField to have a 1.dp border
                .zIndex(1f)
                .generateStepperTestTag(testTag, "Decrement"),
            sparkIcon = SparkIcons.Minus,
            contentDescription = "", // handled by semantics modifier
            enabled = enabled && coerced > range.first,
            colors = colors,
            shape = SparkTheme.shapes.large.copy(
                topEnd = CornerSize(0.dp),
                bottomEnd = CornerSize(0.dp),
            ),
            onClick = { setValue(coerced - 1) },
        )

        MiddleTextField(
            modifier = Modifier
                .then(
                    if (isFlexible) {
                        modifier.weight(1.0f)
                    } else {
                        modifier.width(56.dp)
                    },
                )
                .zIndex(2f) // Draw above the buttons otherwise the end border will be on top
                .invisibleSemantic(),
            value = coerced,
            status = status,
            enabled = enabled,
            colors = colors,
        )

        IconButton(
            modifier = Modifier
                .fillMaxHeight()
                .offset(x = (-1).dp) // overlap with the MiddleTextField to have a 1.dp border
                .zIndex(1f)
                .generateStepperTestTag(testTag, "Increment"),
            sparkIcon = SparkIcons.Plus,
            contentDescription = "", // handled by semantics modifier
            enabled = enabled && coerced < range.last,
            colors = colors,
            shape = SparkTheme.shapes.large.copy(
                topStart = CornerSize(0.dp),
                bottomStart = CornerSize(0.dp),
            ),
            onClick = {
                setValue(coerced + 1)
            },
        )
    }
}

internal fun Modifier.stepperSemantics(
    value: Int,
    onValueChange: (Int) -> Unit,
    range: IntRange,
    enabled: Boolean,
): Modifier =
    semantics(mergeDescendants = true) {
        // this is needed to use volume keys
        setProgress { targetValue ->
            // without this rounding the values will only decrease
            val newValue = targetValue
                .roundToInt()
                .coerceIn(range)
            if (newValue != value) {
                onValueChange(newValue)
                true
            } else {
                false
            }
        }

        // override describing percents
        stateDescription = value.toString()

        if (!enabled) disabled()
    }
        .progressSemantics(
            // this is needed to use volume keys
            value = value.toFloat(),
            valueRange = range.first.toFloat()..range.last.toFloat(),
            steps = range.last - range.first,
        )

@OptIn(ExperimentalComposeUiApi::class)
private fun Modifier.generateStepperTestTag(testTag: String?, action: String): Modifier = testTag?.let {
    semantics {
        contentDescription = "" // handled by semantics modifier
        stateDescription = "" // handled by semantics modifier
        testTagsAsResourceId = true
    }.testTag("${testTag}$action")
} ?: this
