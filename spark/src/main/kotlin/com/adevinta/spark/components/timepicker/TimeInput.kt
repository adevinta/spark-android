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
package com.adevinta.spark.components.timepicker

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.TimeInput as MaterialTimeInput

/**
 * Time pickers help users select and set a specific time.
 *
 * Shows a time input that allows the user to enter the time via
 * two text fields, one for minutes and one for hours
 * Subscribe to updates through [TimePickerState]
 *
 * @sample androidx.compose.material3.samples.TimeInputSample
 *
 * @param state state for this timepicker, allows to subscribe to changes to [TimePickerState.hour]
 * and [TimePickerState.minute], and set the initial time for this picker.
 * @param modifier the [Modifier] to be applied to this time input
 * @param colors colors [TimePickerColors] that will be used to resolve the colors used for this
 * time input in different states. See [TimePickerDefaults.colors].
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun TimeInput(
    state: TimePickerState,
    modifier: Modifier = Modifier,
    colors: TimePickerColors = TimePickerDefaults.colors(),
) {
    MaterialTimeInput(
        state = state,
        modifier = modifier,
        colors = colors,
    )
}
