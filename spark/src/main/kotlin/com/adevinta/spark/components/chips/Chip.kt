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
package com.adevinta.spark.components.chips

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.R
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.SparkTheme.colors
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.DeleteOutline
import com.adevinta.spark.icons.OfferOutline
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.modifiers.dashedBorder
import com.adevinta.spark.tools.modifiers.ifTrue
import com.adevinta.spark.tools.modifiers.minimumTouchTargetSize
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

/**
 * Chips help users quickly recognize an important information that has been entered by them,
 * trigger actions, make selections, or filter content.
 *
 * @param colors one of [ChipColors] that will be used to resolve the colors used for this chip in
 * different states, as well as the color of the border to draw around the container of this chip.
 * @param onClick called when this chip is clicked
 * @param modifier the [Modifier] to be applied to this chip
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param border [BorderStroke] the border to draw around the container of this chip. Pass `null` for no border.
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 * @param content a Composable to set as the chip's content,
 */
@InternalSparkApi
@Composable
private fun SparkChip(
    onClick: () -> Unit,
    containerColor: Color,
    contentColor: Color,
    enabled: Boolean,
    interactionSource: MutableInteractionSource?,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    content: @Composable () -> Unit,
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    Surface(
        onClick = onClick,
        modifier = modifier
            .minimumTouchTargetSize()
            .sparkUsageOverlay()
            .semantics(mergeDescendants = true) { role = Role.Button },
        enabled = enabled,
        shape = SparkTheme.shapes.small,
        color = containerColor,
        border = border,
        contentColor = contentColor,
        interactionSource = interactionSource,
    ) {
        CompositionLocalProvider(
            LocalTextStyle provides SparkTheme.typography.body2,
        ) {
            content()
        }
    }
}

/**
 * Chips help users quickly recognize an important information that has been entered by them,
 * trigger actions, make selections, or filter content.
 *
 * @param containerColor the color used asa background for this chip.
 * @param onClick called when this chip is clicked
 * @param modifier the [Modifier] to be applied to this chip
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param border [BorderStroke] the border to draw around the container of this chip. Pass `null` for no border.
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 * @param content a Composable to set as the chip's content,
 */
@InternalSparkApi
@Composable
private fun SparkChipSelectable(
    selected: Boolean,
    containerColor: Color,
    contentColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit,
) {
    Surface(
        onClick = onClick,
        modifier = modifier
            .minimumTouchTargetSize()
            .sparkUsageOverlay()
            .semantics(mergeDescendants = true) { role = Role.Checkbox },
        enabled = enabled,
        selected = selected,
        shape = SparkTheme.shapes.small,
        color = containerColor,
        border = border,
        contentColor = contentColor,
        interactionSource = interactionSource,
    ) {
        CompositionLocalProvider(
            LocalTextStyle provides SparkTheme.typography.body2,
        ) {
            content()
        }
    }
}

/**
 * Chips help users quickly recognize an important information that has been entered by them,
 * trigger actions, make selections, or filter content.
 *
 * @param style one of [ChipStyles] that defines chips background and border colors.
 * @param onClose when provided will add the closing indicator and make it clickable. note that adding it will require
 * [onCloseLabel] to be provided as well.
 * @param onCloseLabel semantic / accessibility label for the onClose action. It should describe to the user what
 * will happen if [onClose] is tapped.
 * @param intent The [ChipIntent] colors that will be used for the content and background of this chip in
 * different states.
 * @param style one of [ChipStyles] that defines chips background and border.
 * @param onClick called when this chip is clicked
 * @param modifier the [Modifier] to be applied to this chip
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 * @param content a Composable to set as the chip's custom content.
 */
@Composable
public fun Chip(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    onClose: (() -> Unit)? = null,
    onCloseLabel: String? = null,
    intent: ChipIntent = ChipIntent.Basic,
    style: ChipStyles = ChipStyles.Outlined,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    val containerColor by containerColor(intent, style, enabled, selected = false)
    val contentColor by contentColor(intent, style, enabled, selected = false)

    val border = style.takeIf { it == ChipStyles.Outlined }?.let {
        BorderStroke(width = ChipDefaults.BorderStrokeWidth, color = contentColor)
    }
    SparkChip(
        containerColor = containerColor,
        contentColor = contentColor,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        border = border,
        interactionSource = interactionSource,
    ) {
        Row(
            Modifier
                .ifTrue(style == ChipStyles.Dashed) {
                    dashedBorder(
                        width = ChipDefaults.BorderStrokeWidth,
                        shape = SparkTheme.shapes.small,
                        color = contentColor,
                    )
                }
                // Fix to prevent chip from having a width of zero when used
//                // in a scroll container
                .widthIn(max = 9000.dp)
                .defaultMinSize(minHeight = ChipDefaults.MinHeight)
                .padding(ChipDefaults.ChipPadding),
            horizontalArrangement = Arrangement.spacedBy(
                ChipDefaults.LeadingIconEndSpacing,
                Alignment.CenterHorizontally,
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            content()
            AnimatedVisibility(visible = onClose != null) {
                Icon(
                    sparkIcon = SparkIcons.DeleteOutline,
                    modifier = Modifier
                        .size(ChipDefaults.LeadingIconSize)
                        .clickable(
                            onClick = onClose ?: {},
                            enabled = enabled,
                            onClickLabel = onCloseLabel,
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(
                                bounded = false,
                                radius = 24.dp / 2,
                            ),
                        ),
                    contentDescription = null,
                    tint = LocalContentColor.current,
                )
            }
        }
    }
}

/**
 * Chips help users quickly recognize an important information that has been entered by them,
 * trigger actions, make selections, or filter content.
 * @param selected - whether this chip is selected or not * @param style one of [ChipStyles] that defines chips background and border colors.
 * @param onClose when provided will add the closing indicator and make it clickable. note that adding it will require
 * [onCloseLabel] to be provided as well.
 * @param onCloseLabel semantic / accessibility label for the onClose action. It should describe to the user what
 * will happen if [onClose] is tapped.
 * @param intent The [ChipIntent] colors that will be used for the content and background of this chip in
 * different states.
 * @param style one of [ChipStyles] that defines chips background and border.
 * @param onClick called when this chip is clicked
 * @param modifier the [Modifier] to be applied to this chip
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 * @param content a Composable to set as the chip's custom content.
 */
@Composable
public fun ChipSelectable(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    onClose: (() -> Unit)? = null,
    onCloseLabel: String? = null,
    intent: ChipIntent = ChipIntent.Basic,
    style: ChipStyles = ChipStyles.Outlined,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    val containerColor by containerColor(intent, style, enabled, selected)
    val contentColor by contentColor(intent, style, enabled, selected)

    val border = style.takeIf { it == ChipStyles.Outlined }?.let {
        BorderStroke(width = ChipDefaults.BorderStrokeWidth, color = contentColor)
    }
    SparkChipSelectable(
        selected = selected,
        containerColor = containerColor,
        contentColor = contentColor,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        border = border,
        interactionSource = interactionSource,
    ) {
        Row(
            Modifier
                .ifTrue(style == ChipStyles.Dashed) {
                    dashedBorder(
                        width = ChipDefaults.BorderStrokeWidth,
                        shape = SparkTheme.shapes.small,
                        color = contentColor,
                    )
                }
//                // Fix to prevent chip from having a width of zero when used
//                // in a scroll container
                .widthIn(max = 9000.dp)
                .defaultMinSize(minHeight = ChipDefaults.MinHeight)
                .animateContentSize()
                .padding(ChipDefaults.ChipPadding),
            horizontalArrangement = Arrangement.spacedBy(
                ChipDefaults.LeadingIconEndSpacing,
                Alignment.CenterHorizontally,
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            content()
            AnimatedVisibility(visible = onClose != null) {
                Icon(
                    sparkIcon = SparkIcons.DeleteOutline,
                    modifier = Modifier
                        .size(ChipDefaults.LeadingIconSize)
                        .clickable(
                            onClick = onClose ?: {},
                            enabled = enabled,
                            onClickLabel = onCloseLabel,
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(
                                bounded = false,
                                radius = 24.dp / 2,
                            ),
                        ),
                    contentDescription = null,
                    tint = LocalContentColor.current,
                )
            }
        }
    }
}

/**
 * Chips help users quickly recognize an important information that has been entered by them,
 * trigger actions, make selections, or filter content.
 *
 *
 * @param onClick called when this chip is clicked
 * @param text label for this chip, set `null` if no label is needed
 * @param modifier the [Modifier] to be applied to this chip
 * @param onClose when provided will add the closing indicator and make it clickable. note that adding it will require
 * [onCloseLabel] to be provided as well.
 * @param onCloseLabel semantic / accessibility label for the onClose action. It should describe to the user what
 * will happen if [onClose] is tapped.
 * @param intent The [ChipIntent] colors that will be used for the content and background of this chip in
 * different states.
 * @param style one of [ChipStyles] that defines chips background and border.
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param leadingIcon optional icon at the start of the chip, preceding the [text]
 * @param contentDescription text used by accessibility services to describe what this icon
 * represents. This should always be provided unless this icon is used for decorative purposes,
 * and does not represent a meaningful action that a user can take. This text should be
 * localized, such as by using [androidx.compose.ui.res.stringResource] or similar.
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 */
@Composable
public fun Chip(
    onClick: () -> Unit,
    text: String?,
    modifier: Modifier = Modifier,
    onClose: (() -> Unit)? = null,
    onCloseLabel: String? = null,
    intent: ChipIntent = ChipIntent.Basic,
    style: ChipStyles = ChipStyles.Outlined,
    enabled: Boolean = true,
    leadingIcon: SparkIcon? = null,
    contentDescription: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    require(onClose == null || onCloseLabel != null) {
        "onCloseLabel must be provided when onClose is not null to unsure that the action is correctly " +
            "described to the user"
    }
    Chip(
        style = style,
        intent = intent,
        onClose = onClose,
        onCloseLabel = onCloseLabel,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
    ) {
        if (leadingIcon != null) {
            Icon(
                sparkIcon = leadingIcon,
                modifier = Modifier.size(ChipDefaults.LeadingIconSize),
                contentDescription = contentDescription,
                tint = LocalContentColor.current,
            )
        }

        if (text != null) {
            Text(text = text)
        }
    }
}

/**
 * Chips help users quickly recognize an important information that has been entered by them,
 * trigger actions, make selections, or filter content.
 *
 * @param style one of [ChipStyles] that defines chips background and border colors.
 * @param onClose when provided will add the closing indicator and make it clickable. note that adding it will require
 * [onCloseLabel] to be provided as well.
 * @param onCloseLabel semantic / accessibility label for the onClose action. It should describe to the user what
 * will happen if [onClose] is tapped.
 * @param intent The [ChipIntent] colors that will be used for the content and background of this chip in
 * different states.
 * @param style one of [ChipStyles] that defines chips background and border.
 * @param onClick called when this chip is clicked
 * @param modifier the [Modifier] to be applied to this chip
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 */
@Composable
public fun ChipSelectable(
    selected: Boolean,
    onClick: () -> Unit,
    text: String?,
    modifier: Modifier = Modifier,
    onClose: (() -> Unit)? = null,
    onCloseLabel: String? = null,
    intent: ChipIntent = ChipIntent.Basic,
    style: ChipStyles = ChipStyles.Outlined,
    enabled: Boolean = true,
    leadingIcon: SparkIcon? = null,
    contentDescription: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    ChipSelectable(
        selected = selected,
        onClose = onClose,
        onCloseLabel = onCloseLabel,
        style = style,
        intent = intent,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
    ) {
        if (leadingIcon != null) {
            Icon(
                sparkIcon = leadingIcon,
                modifier = Modifier.size(ChipDefaults.LeadingIconSize),
                contentDescription = contentDescription,
                tint = LocalContentColor.current,
            )
        }
        if (text != null) {
            Text(text = text)
        }
    }
}

@Composable
private fun containerColor(
    intent: ChipIntent,
    style: ChipStyles,
    enabled: Boolean,
    selected: Boolean,
): State<Color> {
    val colors = style.colors(intent = intent)
    val target = when {
        !enabled -> if (selected) colors.disabledSelectedBackgroundColor else colors.disabledBackgroundColor
        !selected -> colors.backgroundColor
        else -> colors.selectedBackgroundColor
    }
    return animateColorAsState(target, label = "chip content color")
}

@Composable
private fun contentColor(
    intent: ChipIntent,
    style: ChipStyles,
    enabled: Boolean,
    selected: Boolean,
): State<Color> {
    val colors = style.colors(intent = intent)
    val target = when {
        !enabled -> if (selected) colors.disabledSelectedContentColor else colors.disabledContentColor
        !selected -> colors.contentColor
        else -> colors.selectedContentColor
    }
    return animateColorAsState(target, label = "chip content color")
}

@Preview
@Composable
private fun ChipPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        val leadingIcon = SparkIcons.OfferOutline
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChipOutlined("outlined", leadingIcon = leadingIcon)
            ChipTinted("tinted", leadingIcon = leadingIcon)
            ChipDashed("dashed", leadingIcon = leadingIcon)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChipOutlined("outlined", leadingIcon = leadingIcon, enabled = false)
            ChipTinted("tinted", leadingIcon = leadingIcon, enabled = false)
            ChipDashed("dashed", leadingIcon = leadingIcon, enabled = false)
        }
    }
}

@Preview
@Composable
private fun SelectableChipPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        var selected by remember { mutableStateOf(false) }
        val leadingIcon = SparkIcons.OfferOutline
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChipSelectable(
                selected,
                onClick = { selected = !selected },
                style = ChipStyles.Outlined,
                text = "outlined",
                leadingIcon = leadingIcon,
            )
            ChipSelectable(
                selected,
                onClick = { selected = !selected },
                style = ChipStyles.Tinted,
                text = "tinted",
                leadingIcon = leadingIcon,
            )
            ChipSelectable(
                selected,
                onClick = { selected = !selected },
                style = ChipStyles.Dashed,
                text = "dashed",
                leadingIcon = leadingIcon,
            )
        }
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ChipSelectable(
                selected,
                onClick = { selected = !selected },
                style = ChipStyles.Outlined,
                text = "outlined",
                leadingIcon = leadingIcon,
                enabled = false,
            )
            ChipSelectable(
                selected,
                onClick = { selected = !selected },
                style = ChipStyles.Tinted,
                text = "tinted",
                leadingIcon = leadingIcon,
                enabled = false,
            )
            ChipSelectable(
                selected,
                onClick = { selected = !selected },
                style = ChipStyles.Dashed,
                text = "dashed",
                leadingIcon = leadingIcon,
                enabled = false,
            )

            ChipSelectable(
                content = {
                    ChipContent(stringResource(R.string.spark_textfield_content_description))
                },
                onClick = { },
                enabled = true,
                selected = true,
            )
        }
    }
}

@Composable
private fun RowScope.ChipContent(
    label: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    leadingIcon?.let { leadingIcon() }
    Text(
        text = label,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.weight(weight = 1f, fill = false),
    )
    trailingIcon?.let {
        trailingIcon()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
private fun SingleSelectableChipPreview() {
    PreviewTheme {
        val chips by remember { mutableStateOf(chipsData) }
        var selectedIndex by remember { mutableStateOf<Int?>(null) }
        val leadingIcon = SparkIcons.OfferOutline
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.selectableGroup(),
        ) {
            chips.forEachIndexed { index, chip ->
                ChipSelectable(
                    selectedIndex == index,
                    modifier = Modifier.semantics {
                        role = Role.RadioButton
                    },
                    onClick = { selectedIndex = index },
                    style = ChipStyles.Tinted,
                    text = chip,
                    leadingIcon = leadingIcon,
                )
            }
        }
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            chips.forEachIndexed { index, chip ->
                ChipSelectable(
                    selectedIndex == index,
                    onClick = { },
                    style = ChipStyles.Tinted,
                    text = chip,
                    leadingIcon = leadingIcon,
                    enabled = false,
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
private fun MultiSelectableChipPreview() {
    PreviewTheme {
        val chips by remember { mutableStateOf(chipsData) }
        var selectedIndices by remember { mutableStateOf(setOf<Int>()) }
        val leadingIcon = SparkIcons.OfferOutline
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            chips.forEachIndexed { index, chip ->
                ChipSelectable(
                    index in selectedIndices,
                    onClick = {
                        selectedIndices = if (index in selectedIndices) {
                            selectedIndices - index
                        } else {
                            selectedIndices + index
                        }
                    },
                    style = ChipStyles.Tinted,
                    text = chip,
                    leadingIcon = leadingIcon,
                )
            }
        }
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            chips.forEachIndexed { index, chip ->
                ChipSelectable(
                    index in selectedIndices,
                    onClick = { },
                    style = ChipStyles.Tinted,
                    text = chip,
                    leadingIcon = leadingIcon,
                    enabled = false,
                )
            }
        }
    }
}

private val chipsData = listOf(
    "Ramen",
    "Xiaolongbao",
    "RouJiaMou",
    "BanhMi",
    "Tacos",
    "Cacio e pepe",
    "Curry",
    "Okonomiyaki",
    "Bœuf Bourguignon",
    "Blanquette de veau",
)
