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
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ChipBorder
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ChipElevation
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.material3.AssistChip as MaterialAssistChip
import androidx.compose.material3.ElevatedAssistChip as MaterialElevatedAssistChip

/**
 * <a href="https://m3.material.io/components/chips/overview" class="external" target="_blank">Material Design assist chip</a>.
 *
 * Chips help people enter information, make selections, filter content, or trigger actions. Chips
 * can show multiple interactive elements together in the same area, such as a list of selectable
 * movie times, or a series of email contacts.
 *
 * Assist chips represent smart or automated actions that can span multiple apps, such as opening a
 * calendar event from the home screen. Assist chips function as though the user asked an assistant
 * to complete the action. They should appear dynamically and contextually in a UI.
 *
 * ![Assist chip image](https://developer.android.com/images/reference/androidx/compose/material3/assist-chip.png)
 *
 * This assist chip is applied with a flat style. If you want an elevated style, use the
 * [ElevatedAssistChip].
 *
 * @param onClick called when this chip is clicked
 * @param label text label for this chip
 * @param modifier the [Modifier] to be applied to this chip
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param leadingIcon optional icon at the start of the chip, preceding the [label] text
 * @param trailingIcon optional icon at the end of the chip
 * @param shape defines the shape of this chip's container, border (when [border] is not null), and
 * shadow (when using [elevation])
 * @param colors [ChipColors] that will be used to resolve the colors used for this chip in
 * different states. See [AssistChipDefaults.assistChipColors].
 * @param elevation [ChipElevation] used to resolve the elevation for this chip in different states.
 * This controls the size of the shadow below the chip. Additionally, when the container color is
 * [ColorScheme.surface], this controls the amount of primary color applied as an overlay. See
 * [AssistChipDefaults.assistChipElevation].
 * @param border the border to draw around the container of this chip. Pass `null` for no border.
 * See [AssistChipDefaults.assistChipBorder].
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 */
@Suppress("ktlint:max-line-length")
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
public fun AssistChip(
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = AssistChipDefaults.shape,
    colors: ChipColors = AssistChipDefaults.assistChipColors(),
    elevation: ChipElevation? = AssistChipDefaults.assistChipElevation(),
    border: ChipBorder? = AssistChipDefaults.assistChipBorder(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    MaterialAssistChip(
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
 * <a href="https://m3.material.io/components/chips/overview" class="external" target="_blank">Material Design elevated assist chip</a>.
 *
 * Chips help people enter information, make selections, filter content, or trigger actions. Chips
 * can show multiple interactive elements together in the same area, such as a list of selectable
 * movie times, or a series of email contacts.
 *
 * Assist chips represent smart or automated actions that can span multiple apps, such as opening a
 * calendar event from the home screen. Assist chips function as though the user asked an assistant
 * to complete the action. They should appear dynamically and contextually in a UI.
 *
 * ![Assist chip image](https://developer.android.com/images/reference/androidx/compose/material3/elevated-assist-chip.png)
 *
 * This assist chip is applied with an elevated style. If you want a flat style, use the
 * [AssistChip].
 *
 * @param onClick called when this chip is clicked
 * @param label text label for this chip
 * @param modifier the [Modifier] to be applied to this chip
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param leadingIcon optional icon at the start of the chip, preceding the [label] text
 * @param trailingIcon optional icon at the end of the chip
 * @param shape defines the shape of this chip's container, border (when [border] is not null), and
 * shadow (when using [elevation])
 * @param colors [ChipColors] that will be used to resolve the colors used for this chip in
 * different states. See [AssistChipDefaults.elevatedAssistChipColors].
 * @param elevation [ChipElevation] used to resolve the elevation for this chip in different states.
 * This controls the size of the shadow below the chip. Additionally, when the container color is
 * [ColorScheme.surface], this controls the amount of primary color applied as an overlay. See
 * [AssistChipDefaults.elevatedAssistChipElevation].
 * @param border the border to draw around the container of this chip
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 */
@Suppress("ktlint:max-line-length")
@Deprecated(
    message = "Use one of the options: ChipOutlined, ChipFilled, ChipTinted, ChipDashed",
    replaceWith = ReplaceWith(
        expression = "ChipFilled(text: String, intent: ChipIntent, modifier, enabled, leadingIcon, interactionSource, onClick)",
        imports = ["com.adevinta.spark.components.chips.ChipFilled"],
    ),
    level = DeprecationLevel.WARNING,
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun ElevatedAssistChip(
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    shape: Shape = AssistChipDefaults.shape,
    colors: ChipColors = AssistChipDefaults.elevatedAssistChipColors(),
    elevation: ChipElevation? = AssistChipDefaults.elevatedAssistChipElevation(),
    border: ChipBorder? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    MaterialElevatedAssistChip(
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
