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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.SelectableChipElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.material3.ElevatedFilterChip as MaterialElevatedFilterChip
import androidx.compose.material3.FilterChip as MaterialFilterChip

/**
 * <a href="https://m3.material.io/components/chips/overview" class="external" target="_blank">Material Design filter chip</a>.
 *
 * Chips help people enter information, make selections, filter content, or trigger actions. Chips
 * can show multiple interactive elements together in the same area, such as a list of selectable
 * movie times, or a series of email contacts.
 *
 * Filter chips use tags or descriptive words to filter content. They can be a good alternative to
 * toggle buttons or checkboxes.
 *
 * ![Filter chip image](https://developer.android.com/images/reference/androidx/compose/material3/filter-chip.png)
 *
 * This filter chip is applied with a flat style. If you want an elevated style, use the
 * [ElevatedFilterChip].
 *
 * Tapping on a filter chip toggles its selection state. A selection state [leadingIcon] can be
 * provided (e.g. a checkmark) to be appended at the starting edge of the chip's label.
 *
 * @param selected whether this chip is selected or not
 * @param onClick called when this chip is clicked
 * @param label text label for this chip
 * @param modifier the [Modifier] to be applied to this chip
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param leadingIcon optional icon at the start of the chip, preceding the [label] text. When
 * [selected] is true, this icon may visually indicate that the chip is selected (for example, via a
 * checkmark icon).
 * @param trailingIcon optional icon at the end of the chip
 * @param shape defines the shape of this chip's container, border (when [border] is not null), and
 * shadow (when using [elevation])
 * @param colors [SelectableChipColors] that will be used to resolve the colors used for this chip
 * in different states. See [FilterChipDefaults.filterChipColors].
 * @param elevation [SelectableChipElevation] used to resolve the elevation for this chip in
 * different states. This controls the size of the shadow below the chip. Additionally, when the
 * container color is [ColorScheme.surface], this controls the amount of main color applied as an
 * overlay. See [FilterChipDefaults.filterChipElevation].
 * @param border the border to draw around the container of this chip. Pass `null` for no border.
 * See [FilterChipDefaults.filterChipBorder].
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 */
@Suppress("ktlint:standard:max-line-length", "ktlint:standard:trailing-comma-on-call-site")
@Deprecated(
    "Use one of the options: ChipOutlined, ChipFilled, ChipTinted, ChipDashed",
    ReplaceWith(
        "ChipFilled(text: String, intent: ChipIntent, modifier, enabled, leadingIcon, interactionSource, onClick)",
    ),
)
@ExperimentalMaterial3Api
@Composable
public fun FilterChip(
    selected: Boolean,
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = FilterChipDefaults.shape,
    colors: SelectableChipColors = FilterChipDefaults.filterChipColors(),
    elevation: SelectableChipElevation? = FilterChipDefaults.filterChipElevation(),
    border: BorderStroke? = FilterChipDefaults.filterChipBorder(enabled, selected),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    MaterialFilterChip(
        selected = selected,
        onClick = onClick,
        label = label,
        modifier = modifier,
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        interactionSource = interactionSource,
    )
}

/**
 * <a href="https://m3.material.io/components/chips/overview" class="external" target="_blank">Material Design elevated filter chip</a>.
 *
 * Chips help people enter information, make selections, filter content, or trigger actions. Chips
 * can show multiple interactive elements together in the same area, such as a list of selectable
 * movie times, or a series of email contacts.
 *
 * Filter chips use tags or descriptive words to filter content. They can be a good alternative to
 * toggle buttons or checkboxes.
 *
 * ![Filter chip image](https://developer.android.com/images/reference/androidx/compose/material3/elevated-filter-chip.png)
 *
 * This filter chip is applied with an elevated style. If you want a flat style, use the
 * [FilterChip].
 *
 * Tapping on a filter chip toggles its selection state. A selection state [leadingIcon] can be
 * provided (e.g. a checkmark) to be appended at the starting edge of the chip's label.
 *
 * @param selected whether this chip is selected or not
 * @param onClick called when this chip is clicked
 * @param label text label for this chip
 * @param modifier the [Modifier] to be applied to this chip
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param leadingIcon optional icon at the start of the chip, preceding the [label] text. When
 * [selected] is true, this icon may visually indicate that the chip is selected (for example, via a
 * checkmark icon).
 * @param trailingIcon optional icon at the end of the chip
 * @param shape defines the shape of this chip's container, border (when [border] is not null), and
 * shadow (when using [elevation])
 * @param colors [SelectableChipColors] that will be used to resolve the colors used for this chip
 * in different states. See [FilterChipDefaults.elevatedFilterChipColors].
 * @param elevation [SelectableChipElevation] used to resolve the elevation for this chip in
 * different states. This controls the size of the shadow below the chip. Additionally, when the
 * container color is [ColorScheme.surface], this controls the amount of main color applied as an
 * overlay. See [FilterChipDefaults.filterChipElevation].
 * @param border the border to draw around the container of this chip. Pass `null` for no border.
 * See [FilterChipDefaults.filterChipBorder].
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 */
@Suppress("ktlint:standard:max-line-length")
@Deprecated(
    message = "Use one of the options: ChipOutlined, ChipFilled, ChipTinted, ChipDashed",
    replaceWith = ReplaceWith(
        expression = "ChipFilled(text: String, intent: ChipIntent, modifier, enabled, leadingIcon, interactionSource, onClick)",
        imports = ["com.adevinta.spark.components.chips.ChipFilled"],
    ),
    level = DeprecationLevel.WARNING,
)
@Composable
public fun ElevatedFilterChip(
    selected: Boolean,
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = FilterChipDefaults.shape,
    colors: SelectableChipColors = FilterChipDefaults.elevatedFilterChipColors(),
    elevation: SelectableChipElevation? = FilterChipDefaults.elevatedFilterChipElevation(),
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    MaterialElevatedFilterChip(
        selected = selected,
        onClick = onClick,
        label = label,
        modifier = modifier,
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        interactionSource = interactionSource,
    )
}
