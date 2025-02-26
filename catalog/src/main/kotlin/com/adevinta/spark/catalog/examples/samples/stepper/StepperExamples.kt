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
package com.adevinta.spark.catalog.examples.samples.stepper

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.adevinta.spark.catalog.model.Example
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.stepper.Stepper
import com.adevinta.spark.components.stepper.StepperForm
import com.adevinta.spark.components.textfields.FormFieldStatus

public val StepperExamples: List<Example> = listOf(
    Example(
        id = "default",
        name = "Base Stepper Example",
        description = "Base interactions on stepper.",
        sourceUrl = "$SampleSourceUrl/RatingDisplaySample.kt",
    ) {
        var value by rememberSaveable { mutableIntStateOf(0) }
        Stepper(
            value = value,
            onValueChange = {
                value = it
            },
        )
        StepperForm(
            value = value,
            onValueChange = {
                value = it
            },
            label = "Label",
            required = true,
            helper = "Exemple de message d'aide",
        )
    },
    Example(
        id = "states",
        name = "Stepper States",
        description = "Disabled and all regular states available for the TestField.",
        sourceUrl = "$SampleSourceUrl/RatingDisplaySample.kt",
    ) {
        StepperForm(
            value = 1,
            onValueChange = {},
            status = FormFieldStatus.Error,
            label = "Label",
            helper = "helper message",
            enabled = false,
        )
        StepperForm(
            value = 1,
            onValueChange = {},
            status = FormFieldStatus.Error,
            label = "Label",
            helper = "helper message",
        )
        StepperForm(
            value = -1,
            onValueChange = {},
            status = FormFieldStatus.Alert,
            label = "Label",
            helper = "helper message",
        )
        StepperForm(
            value = -1234,
            onValueChange = {},
            status = FormFieldStatus.Success,
            label = "Label",
            helper = "helper message",
        )
    },
    // Example(
    //       name = "Stepper formats",
    //       description = "Stepper can show a suffix like `%`, `€` or `person•s`.",
    //       sourceUrl = "$SampleSourceUrl/RatingInputSample.kt",
    //   ) {
    //       WipIllustration()
    //  },
    //  Example(
    //     name = "Stepper Custom Buttons",
    //     description = "Custom implementation allow used defined button for de-increment.",
    //     sourceUrl = "$SampleSourceUrl/RatingFullSample.kt",
    // ) {
    //     WipIllustration()
    // },
)
