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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DateRangePickerDefaults
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.components.buttons.ButtonGhost
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.icons.IconButton
import com.adevinta.spark.components.snackbars.SnackbarHost
import com.adevinta.spark.components.snackbars.SnackbarHostState
import com.adevinta.spark.icons.Close
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import kotlinx.coroutines.launch
import androidx.compose.material3.DateRangePicker as MaterialDateRangePicker

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalSparkApi
@Composable
internal fun SparkDateRangePicker(
    state: DateRangePickerState,
    modifier: Modifier = Modifier,
    dateFormatter: DatePickerFormatter = remember { DatePickerFormatter() },
    dateValidator: (Long) -> Boolean = { true },
    title: (@Composable () -> Unit)? = {
        DateRangePickerDefaults.DateRangePickerTitle(
            state = state,
            modifier = Modifier.padding(DateRangePickerTitlePadding),
        )
    },
    headline: (@Composable () -> Unit)? = {
        DateRangePickerDefaults.DateRangePickerHeadline(
            state,
            dateFormatter,
            modifier = Modifier.padding(DateRangePickerHeadlinePadding),
        )
    },
    showModeToggle: Boolean = true,
    colors: DatePickerColors = DatePickerDefaults.colors(),
) {
    MaterialDateRangePicker(
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
 * Date range pickers let people select a range of dates and can be embedded into Dialogs.
 *
 * @param state state of the date range picker. See [rememberDateRangePickerState].
 * @param modifier the [Modifier] to be applied to this date range picker
 * @param dateFormatter a [DatePickerFormatter] that provides formatting skeletons for dates display
 * @param dateValidator a lambda that takes a date timestamp and return true if the date is a valid
 * one for selection. Invalid dates will appear disabled in the UI.
 * @param title the title to be displayed in the date range picker
 * @param headline the headline to be displayed in the date range picker
 * @param showModeToggle indicates if this DateRangePicker should show a mode toggle action that
 * transforms it into a date range input
 * @param colors [DatePickerColors] that will be used to resolve the colors used for this date
 * range picker in different states. See [DatePickerDefaults.colors].
 */
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalSparkApi
@Composable
public fun DateRangePicker(
    state: DateRangePickerState,
    modifier: Modifier = Modifier,
    dateFormatter: DatePickerFormatter = remember { DatePickerFormatter() },
    dateValidator: (Long) -> Boolean = { true },
    title: (@Composable () -> Unit)? = {
        DateRangePickerDefaults.DateRangePickerTitle(
            state = state,
            modifier = Modifier.padding(DateRangePickerTitlePadding),
        )
    },
    headline: (@Composable () -> Unit)? = {
        DateRangePickerDefaults.DateRangePickerHeadline(
            state,
            dateFormatter,
            modifier = Modifier.padding(DateRangePickerHeadlinePadding),
        )
    },
    showModeToggle: Boolean = true,
    colors: DatePickerColors = DatePickerDefaults.colors(),
) {
    SparkDateRangePicker(
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

private val DateRangePickerTitlePadding = PaddingValues(start = 64.dp, end = 12.dp)
private val DateRangePickerHeadlinePadding =
    PaddingValues(start = 64.dp, end = 12.dp, bottom = 12.dp)

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    group = "DatePicker",
    name = "Range",
)
@Composable
internal fun DateRangePickerPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(
        theme,
        padding = PaddingValues(0.dp),
    ) {
        // Decoupled snackbar host state from scaffold state for demo purposes.
        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()
        SnackbarHost(hostState = snackState, Modifier.zIndex(1f))

        val state = rememberDateRangePickerState()
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
            // Add a row with "Save" and dismiss actions.
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                IconButton(onClick = { /* dismiss the UI */ }) {
                    Icon(sparkIcon = SparkIcons.Close, contentDescription = "Localized description")
                }
                ButtonGhost(
                    onClick = {
                        snackScope.launch {
                            snackState.showSnackbar(
                                "Saved range (timestamps): " +
                                    "${state.selectedStartDateMillis!!..state.selectedEndDateMillis!!}",
                            )
                        }
                    },
                    enabled = state.selectedEndDateMillis != null,
                    text = "Save",
                )
            }

            DateRangePicker(state = state, modifier = Modifier.weight(1f))
        }
    }
}
