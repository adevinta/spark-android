/*
 * Copyright (c) 2023-2024 Adevinta
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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.tags.TagDefaults
import com.adevinta.spark.components.text.Text
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
    colors: ChipColors,
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
            .sparkUsageOverlay(),
        enabled = enabled,
        shape = SparkTheme.shapes.small,
        color = if (enabled) colors.backgroundColor else colors.disabledBackgroundColor,
        border = border,
        contentColor = if (enabled) colors.contentColor else colors.disabledContentColor,
        interactionSource = interactionSource,
    ) {
        CompositionLocalProvider(
            LocalContentColor provides if (enabled) colors.contentColor else colors.disabledContentColor,
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
 * @param intent The [ChipIntent] colors that will be used for the content and background of this chip in
 * different states.
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
    style: ChipStyles,
    intent: ChipIntent,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    val colors = style.colors(intent = intent)
    val border = style.border(intent = intent, enabled = enabled)
    SparkChip(
        colors = colors,
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
                        radius = ChipDefaults.DashedBorderRadius,
                        color = if (enabled) colors.contentColor else colors.disabledContentColor,
                    )
                }
                .defaultMinSize(minHeight = ChipDefaults.MinHeight)
                .sizeIn(maxWidth = ChipDefaults.MaxWidth)
                .padding(ChipDefaults.ChipPadding),
            horizontalArrangement = Arrangement.spacedBy(
                ChipDefaults.LeadingIconEndSpacing,
                Alignment.CenterHorizontally,
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            content()
        }
    }
}

/**
 * Chips help users quickly recognize an important information that has been entered by them,
 * trigger actions, make selections, or filter content.
 *
 *
 * @param style one of [ChipStyles] that defines chips background and border.
 * @param intent The [ChipIntent] colors that will be used for the content and background of this chip in
 * different states.
 * @param onClick called when this chip is clicked
 * @param text label for this chip, set `null` if no label is needed
 * @param modifier the [Modifier] to be applied to this chip
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
    style: ChipStyles,
    intent: ChipIntent,
    onClick: () -> Unit,
    text: String?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: SparkIcon? = null,
    contentDescription: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Chip(
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
                modifier = Modifier.size(TagDefaults.LeadingIconSize),
                contentDescription = contentDescription,
                tint = LocalContentColor.current,
            )
        }
        if (text != null) {
            Text(text = text)
        }
    }
}

@Preview(
    group = "Chips",
    name = "Chips",
)
@Composable
internal fun ChipPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        val intent = ChipIntent.Main
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChipOutlined("outlined", intent = intent, leadingIcon = SparkIcons.OfferOutline)
            ChipFilled("filled", intent = intent, leadingIcon = SparkIcons.OfferOutline)
            ChipTinted("tinted", intent = intent, leadingIcon = SparkIcons.OfferOutline)
            ChipDashed("dashed", intent = intent, leadingIcon = SparkIcons.OfferOutline)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChipOutlined("outlined", intent = intent, leadingIcon = SparkIcons.OfferOutline, enabled = false)
            ChipFilled("filled", intent = intent, leadingIcon = SparkIcons.OfferOutline, enabled = false)
            ChipTinted("tinted", intent = intent, leadingIcon = SparkIcons.OfferOutline, enabled = false)
            ChipDashed("dashed", intent = intent, leadingIcon = SparkIcons.OfferOutline, enabled = false)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChipOutlined("outlined", intent = intent)
            ChipFilled("filled", intent = intent)
            ChipTinted("tinted", intent = intent)
            ChipDashed("dashed", intent = intent)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ChipOutlined("outlined", intent = intent, enabled = false)
            ChipFilled("filled", intent = intent, enabled = false)
            ChipTinted("tinted", intent = intent, enabled = false)
            ChipDashed("dashed", intent = intent, enabled = false)
        }
    }
}
