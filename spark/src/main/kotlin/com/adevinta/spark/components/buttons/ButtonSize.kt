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
package com.adevinta.spark.components.buttons

import androidx.annotation.Discouraged
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * ButtonSize is used to define the height of the buttons.
 */
@Suppress("ktlint:max-line-length", "ktlint:trailing-comma-on-call-site")
public enum class ButtonSize {
    /**
     * Alternative small button size when is needed a low spacing/emphasis to the action.
     *
     * Try to use Ghost Medium Button instead size small when it's possible to avoid accessibility issues
     *
     * Note : The button takes 44dp of height for a11y but is drown with 32dp of height.
     */
    @Discouraged(
        "The button small is not meant to be used on native apps, consider reviewing this usage with your designer to use more accessible size like Medium."
    )
    Small {
        override val height = 32.dp
        override val verticalPadding = 12.dp
        override val contentVerticalPadding = 4.dp
    },

    /**
     * Medium button is the default button size (recommended).
     */
    Medium {
        override val height = 44.dp
        override val verticalPadding = 0.dp
        override val contentVerticalPadding = 10.dp
    },

    /**
     * Alternative large button size to give more emphasis to the action
     */
    Large {
        override val height = 56.dp
        override val verticalPadding = 0.dp
        override val contentVerticalPadding = 16.dp
    },
    ;

    internal abstract val height: Dp
    internal abstract val verticalPadding: Dp
    internal abstract val contentVerticalPadding: Dp
}
