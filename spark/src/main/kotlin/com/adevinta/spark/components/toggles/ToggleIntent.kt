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
package com.adevinta.spark.components.toggles

import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.SwitchColors
import androidx.compose.runtime.Composable
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.IntentColor
import com.adevinta.spark.components.IntentColors
import com.adevinta.spark.tokens.dim3

public enum class ToggleIntent {
    /**
     * The default color of such UI controls as toggles, Slider, etc.
     */
    Basic {
        @Composable
        override fun colors(): IntentColor = IntentColors.Basic.colors()
    },

    /**
     * Used to make components visually accentuated.
     */
    Accent {
        @Composable
        override fun colors(): IntentColor = IntentColors.Accent.colors()
    },

    /**
     * Used for the most important information.
     */
    Main {
        @Composable
        override fun colors(): IntentColor = IntentColors.Main.colors()
    },

    /**
     * Used to highlight information.
     */
    Support {
        @Composable
        override fun colors(): IntentColor = IntentColors.Support.colors()
    },

    /**
     * Used for feedbacks that are positive.
     */
    Success {
        @Composable
        override fun colors(): IntentColor = IntentColors.Success.colors()
    },

    /**
     * Used for feedbacks that are negative.
     */
    Alert {
        @Composable
        override fun colors(): IntentColor = IntentColors.Alert.colors()
    },

    /**
     * Used for feedbacks that are negative and dangerous.
     */
    Danger {
        @Composable
        override fun colors(): IntentColor = IntentColors.Danger.colors()
    },

    /**
     * Used for feedbacks that are informative.
     */
    Info {
        @Composable
        override fun colors(): IntentColor = IntentColors.Info.colors()
    },

    /**
     * Used for feedbacks that are neutral.
     */
    Neutral {
        @Composable
        override fun colors(): IntentColor = IntentColors.Neutral.colors()
    },
    ;

    @Composable
    internal abstract fun colors(): IntentColor
}

@Composable
internal fun ToggleIntent.toCheckboxDefaultsColors(): CheckboxColors = CheckboxDefaults.colors(
    checkedColor = this.colors().color,
)

@Composable
internal fun ToggleIntent.toSwitchDefaultsColors(): SwitchColors = SwitchDefaults.colors(
    checkedTrackColor = this.colors().color,
    disabledCheckedTrackColor = this.colors().containerColor,
)

@Composable
internal fun ToggleIntent.toRadioButtonDefaultsColors(): RadioButtonColors = RadioButtonDefaults.colors(
    selectedColor = this.colors().color,
    unselectedColor = SparkTheme.colors.outline,
    disabledSelectedColor = this.colors().containerColor,
    disabledUnselectedColor = SparkTheme.colors.outline.dim3,
)
