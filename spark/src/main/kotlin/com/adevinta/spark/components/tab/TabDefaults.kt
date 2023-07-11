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

package com.adevinta.spark.components.tab

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.icons.IconSize.Small

public object TabDefaults {
    internal val SelectedContentIntent = TabIntent.Primary
    internal val Size = TabSize.Medium
    internal val HorizontalArrangementSpace = 8.dp
    internal val HorizontalContentPadding = 16.dp
    internal val VerticalContentPadding = 8.dp
    internal val IconSize: Dp = Small.size
    internal val ActiveIndicatorHeight = 2.0.dp
}

public enum class TabIntent {
    /**
     * Used for the most important information.
     */
    Primary {
        @Composable
        override fun color(): Color = SparkTheme.colors.primary
    },
    /**
     * Used to highlight/accentuate.
     */
    Secondary {
        @Composable
        override fun color(): Color = SparkTheme.colors.secondary
    };

    @Composable
    public abstract fun color(): Color
}

public enum class TabSize {
    ExtraSmall {
        @Composable
        override fun typography(): TextStyle = SparkTheme.typography.caption
    },
    Small {
        @Composable
        override fun typography(): TextStyle = SparkTheme.typography.body2
    },
    Medium {
        @Composable
        override fun typography(): TextStyle = SparkTheme.typography.body1
    };

    @Composable
    internal abstract fun typography(): TextStyle
}
