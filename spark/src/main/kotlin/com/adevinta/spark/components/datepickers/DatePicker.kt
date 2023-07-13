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
package com.adevinta.spark.components.datepickers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import androidx.compose.material3.DatePicker as MaterialDatePicker

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalSparkApi
@Composable
internal fun SparkDatePicker(
    state: DatePickerState,
    modifier: Modifier = Modifier,
    dateFormatter: DatePickerFormatter = remember { DatePickerFormatter() },
    dateValidator: (Long) -> Boolean = { true },
    title: (@Composable () -> Unit)? = {
        DatePickerDefaults.DatePickerTitle(
            state,
            modifier = Modifier.padding(DatePickerTitlePadding),
        )
    },
    headline: (@Composable () -> Unit)? = {
        DatePickerDefaults.DatePickerHeadline(
            state,
            dateFormatter,
            modifier = Modifier.padding(DatePickerHeadlinePadding),
        )
    },
    showModeToggle: Boolean = true,
    colors: DatePickerColors = DatePickerDefaults.colors(),
) {
    MaterialDatePicker(
        state = state,
        modifier = modifier,
        dateFormatter = dateFormatter,
        dateValidator = dateValidator,
        title = title,
        headline = headline,
        showModeToggle = showModeToggle,
        colors = colors,
    )
}

/**
 *
 * Date pickers let people select a date and preferably should be embedded into Dialogs.
 * See [DatePickerDialog].
 *
 * By default, a date picker lets you pick a date via a calendar UI. However, it also allows
 * switching into a date input mode for a manual entry of dates using the numbers on a keyboard.
 *
 * ![Date picker image](https://developer.android.com/images/reference/androidx/compose/material3/date-picker.png)
 *
 * @param state state of the date picker. See [rememberDatePickerState].
 * @param modifier the [Modifier] to be applied to this date picker
 * @param dateFormatter a [DatePickerFormatter] that provides formatting skeletons for dates display
 * @param dateValidator a lambda that takes a date timestamp and return true if the date is a valid
 * one for selection. Invalid dates will appear disabled in the UI.
 * @param title the title to be displayed in the date picker
 * @param headline the headline to be displayed in the date picker
 * @param showModeToggle indicates if this DatePicker should show a mode toggle action that
 * transforms it into a date input
 * @param colors [DatePickerColors] that will be used to resolve the colors used for this date
 * picker in different states. See [DatePickerDefaults.colors].
 */
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalSparkApi
@Composable
public fun DatePicker(
    state: DatePickerState,
    modifier: Modifier = Modifier,
    dateFormatter: DatePickerFormatter = remember { DatePickerFormatter() },
    dateValidator: (Long) -> Boolean = { true },
    title: (@Composable () -> Unit)? = {
        DatePickerDefaults.DatePickerTitle(
            state,
            modifier = Modifier.padding(DatePickerTitlePadding),
        )
    },
    headline: (@Composable () -> Unit)? = {
        DatePickerDefaults.DatePickerHeadline(
            state,
            dateFormatter,
            modifier = Modifier.padding(DatePickerHeadlinePadding),
        )
    },
    showModeToggle: Boolean = true,
    colors: DatePickerColors = DatePickerDefaults.colors(),
) {
    SparkDatePicker(
        state = state,
        modifier = modifier,
        dateFormatter = dateFormatter,
        dateValidator = dateValidator,
        title = title,
        headline = headline,
        showModeToggle = showModeToggle,
        colors = colors,
    )
}

private val DatePickerTitlePadding = PaddingValues(start = 24.dp, end = 12.dp, top = 16.dp)
private val DatePickerHeadlinePadding = PaddingValues(start = 24.dp, end = 12.dp, bottom = 12.dp)

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    group = "DatePicker",
    name = "Simple",
)
@Composable
internal fun SimpleDatePickerPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(
        theme,
        padding = PaddingValues(0.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // Pre-select a date for January 4, 2020
            val datePickerState = rememberDatePickerState(initialSelectedDateMillis = 1578096000000)
            DatePicker(state = datePickerState, modifier = Modifier.padding(16.dp))

            Text("Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    group = "DatePicker",
    name = "Initial",
)
@Composable
internal fun InitialDatePickerPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(
        theme,
        padding = PaddingValues(0.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
            DatePicker(state = state, modifier = Modifier.padding(16.dp))

            Text("Entered date timestamp: ${state.selectedDateMillis ?: "no input"}")
        }
    }
}
