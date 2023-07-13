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
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.TimePicker as MaterialTimePicker

/**
 *
 * Time pickers help users select and set a specific time.
 *
 * Shows a picker that allows the user to select time.
 * Subscribe to updates through [TimePickerState]
 *
 * [state] state for this timepicker, allows to subscribe to changes to [TimePickerState.hour] and
 * [TimePickerState.minute], and set the initial time for this picker.
 *
 * @param state state for this time input, allows to subscribe to changes to [TimePickerState.hour]
 * and [TimePickerState.minute], and set the initial time for this input.
 * @param modifier the [Modifier] to be applied to this time input
 * @param colors colors [TimePickerColors] that will be used to resolve the colors used for this
 * time picker in different states. See [TimePickerDefaults.colors].
 * @param layoutType, the different [TimePickerLayoutType] supported by this time picker,
 * it will change the position and sizing of different components of the timepicker.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun TimePicker(
    state: TimePickerState,
    modifier: Modifier = Modifier,
    colors: TimePickerColors = TimePickerDefaults.colors(),
    layoutType: TimePickerLayoutType = TimePickerDefaults.layoutType(),
) {
    MaterialTimePicker(
        state = state,
        modifier = modifier,
        colors = colors,
        layoutType = layoutType,
    )
}
