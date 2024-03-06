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
package com.adevinta.spark.components.slider

import androidx.compose.runtime.Composable
import com.adevinta.spark.components.IntentColor
import com.adevinta.spark.components.IntentColors

/**
 * SliderIntent is used to define the intent of the sliders.
 */
public enum class SliderIntent {

    /**
     * Main sliders are used for the most important actions.
     */
    Main {
        @Composable
        override fun colors(): IntentColor = IntentColors.Main.colors()
    },

    /**
     * Support sliders are used to highlight/accentuate actions.
     */
    Support {
        @Composable
        override fun colors(): IntentColor = IntentColors.Support.colors()
    },

    /**
     * Used to make slider visually accentuated.
     */
    Accent {
        @Composable
        override fun colors(): IntentColor = IntentColors.Accent.colors()
    },

    /**
     * Used to match default color of such UI controls as toggles, Slider, etc.
     */
    Basic {
        @Composable
        override fun colors(): IntentColor = IntentColors.Basic.colors()
    },

    /**
     * Used for confirmation actions.
     */
    Success {
        @Composable
        override fun colors(): IntentColor = IntentColors.Success.colors()
    },

    /**
     * Used for warning actions.
     */
    Alert {
        @Composable
        override fun colors(): IntentColor = IntentColors.Alert.colors()
    },

    /**
     * Used for risky actions.
     */
    Error {
        @Composable
        override fun colors(): IntentColor = IntentColors.Danger.colors()
    },

    /**
     * Used informational valuable actions.
     */
    Info {
        @Composable
        override fun colors(): IntentColor = IntentColors.Info.colors()
    },

    /**
     * Used for low or irrelevant actions.
     */
    Neutral {
        @Composable
        override fun colors(): IntentColor = IntentColors.Neutral.colors()
    }, ;

    @Composable
    internal abstract fun colors(): IntentColor
}
