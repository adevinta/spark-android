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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.stepper.StepperDefaults
import com.adevinta.spark.components.stepper.stepperSemantics
import com.adevinta.spark.components.textfields.FormFieldStatus
import com.adevinta.spark.icons.Minus
import com.adevinta.spark.icons.Plus
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.modifiers.ifTrue
import com.adevinta.spark.tools.modifiers.invisibleSemantic

@Composable
internal fun SparkStepper(
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    range: IntRange = 0..10,
    suffix: String = "",
    enabled: Boolean = true,
    status: FormFieldStatus? = null,
    flexible: Boolean = false,
    testTag: String? = null,
    allowSemantics: Boolean = true,
) {
    val colors = StepperDefaults.stepperColors()
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
                .generateStepperTestTag(testTag, "Decrement"),
            sparkIcon = SparkIcons.Minus,
            contentDescription = "", // handled by semantics modifier
            enabled = enabled && coerced > range.first,
            colors = colors,
            status = status,
            shape = SparkTheme.shapes.large.copy(
                topEnd = CornerSize(0.dp),
                bottomEnd = CornerSize(0.dp),
            ),
            onClick = { setValue(coerced - 1) },
        )

        MiddleText(
            modifier = Modifier
                .then(
                    if (flexible) {
                        modifier.weight(1.0f)
                    } else {
                        modifier.widthIn(min = 56.dp)
                    },
                )
                .fillMaxHeight()
                .invisibleSemantic(),
            value = coerced,
            suffix = suffix,
            status = status,
            enabled = enabled,
            colors = colors,
        )

        IconButton(
            modifier = Modifier
                .fillMaxHeight()
                .generateStepperTestTag(testTag, "Increment"),
            sparkIcon = SparkIcons.Plus,
            contentDescription = "", // handled by semantics modifier
            enabled = enabled && coerced < range.last,
            colors = colors,
            status = status,
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

@OptIn(ExperimentalComposeUiApi::class)
private fun Modifier.generateStepperTestTag(testTag: String?, action: String): Modifier = testTag?.let {
    semantics {
        contentDescription = "" // handled by semantics modifier
        stateDescription = "" // handled by semantics modifier
        testTagsAsResourceId = true
    }.testTag("${testTag}$action")
} ?: this

@Preview
@Composable
private fun PreviewSparkStepper() {
    PreviewTheme {
        SparkStepper(
            value = 1234,
            onValueChange = {},
        )
        SparkStepper(
            value = 1234,
            onValueChange = {},
            status = FormFieldStatus.Error,
        )
    }
}
