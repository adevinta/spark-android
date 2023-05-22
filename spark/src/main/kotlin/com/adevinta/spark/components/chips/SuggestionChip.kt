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

@file:OptIn(ExperimentalMaterial3Api::class)

package com.adevinta.spark.components.chips

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ChipBorder
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ChipElevation
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.material3.SuggestionChip as MaterialSuggestionChip


/**
 * <a href="https://m3.material.io/components/chips/overview" class="external" target="_blank">Material Design suggestion chip</a>.
 *
 * Chips help people enter information, make selections, filter content, or trigger actions. Chips
 * can show multiple interactive elements together in the same area, such as a list of selectable
 * movie times, or a series of email contacts.
 *
 * Suggestion chips help narrow a user's intent by presenting dynamically generated suggestions,
 * such as possible responses or search filters.
 *
 * ![Suggestion chip image](https://developer.android.com/images/reference/androidx/compose/material3/suggestion-chip.png)
 *
 * This suggestion chip is applied with a flat style. If you want an elevated style, use the
 * [ElevatedSuggestionChip].
 *
 * Example of a flat SuggestionChip with a trailing icon:
 * @sample androidx.compose.material3.samples.SuggestionChipSample
 *
 * @param onClick called when this chip is clicked
 * @param label text label for this chip
 * @param modifier the [Modifier] to be applied to this chip
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param icon optional icon at the start of the chip, preceding the [label] text
 * @param shape defines the shape of this chip's container, border (when [border] is not null), and
 * shadow (when using [elevation])
 * @param colors [ChipColors] that will be used to resolve the colors used for this chip in
 * different states. See [SuggestionChipDefaults.suggestionChipColors].
 * @param elevation [ChipElevation] used to resolve the elevation for this chip in different states.
 * This controls the size of the shadow below the chip. Additionally, when the container color is
 * [ColorScheme.surface], this controls the amount of primary color applied as an overlay. See
 * [SuggestionChipDefaults.suggestionChipElevation].
 * @param border the border to draw around the container of this chip. Pass `null` for no border.
 * See [SuggestionChipDefaults.suggestionChipBorder].
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 */
@Deprecated(
    message = "Use one of the options: ChipOutlined, ChipFilled, ChipTinted, ChipDashed",
    replaceWith = ReplaceWith(
        expression = "ChipFilled(text: String, intent: ChipIntent, modifier, enabled, leadingIcon, interactionSource, onClick)",
        imports = ["com.adevinta.spark.components.chips.ChipFilled"],
    ),
    level = DeprecationLevel.WARNING,
)
@ExperimentalMaterial3Api
@Composable
public fun SuggestionChip(
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: @Composable (() -> Unit)? = null,
    shape: Shape = SuggestionChipDefaults.shape,
    colors: ChipColors = SuggestionChipDefaults.suggestionChipColors(),
    elevation: ChipElevation? = SuggestionChipDefaults.suggestionChipElevation(),
    border: ChipBorder? = SuggestionChipDefaults.suggestionChipBorder(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    MaterialSuggestionChip(
        onClick = onClick,
        label = label,
        modifier = modifier,
        enabled = enabled,
        icon = icon,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        interactionSource = interactionSource,
    )
}
