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
package com.adevinta.spark.components.bottomsheet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme

/**
 * Possible values of [SheetState].
 */
@ExperimentalMaterial3Api
public enum class SheetValue {
    /**
     * The sheet is not visible.
     */
    Hidden,

    /**
     * The sheet is visible at full height.
     */
    Expanded,

    /**
     * The sheet is partially visible.
     */
    PartiallyExpanded,
}

/**
 * Contains the default values used by [ModalBottomSheet] and [BottomSheetScaffold].
 */
@Stable
@ExperimentalMaterial3Api
public object BottomSheetDefaults {

    /** The default container color for a bottom sheet. */
    public val ContainerColor: Color
        @Composable get() = SparkTheme.colors.surface

    /** The default top padding for the content of a bottom sheet. */
    public val ContentTopPadding: Dp = 28.dp
    public val ContentTopPaddingNoHandle: Dp = 0.dp

    /** The default color of the scrim overlay for background content. */
    public val ScrimColor: Color
        @Composable get() = SparkTheme.colors.scrim

    /**
     * The optional visual marker placed on top of a bottom sheet to indicate it may be dragged.
     */
    @Composable
    public fun DragHandle(modifier: Modifier = Modifier) {
        com.adevinta.spark.components.bottomsheet.handle.DragHandle(modifier)
    }
}

public val DragHandleVerticalPadding: Dp = 8.dp
