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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
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
import com.adevinta.spark.components.tags.TagDefaults
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.modifiers.ifTrue
import com.adevinta.spark.tools.modifiers.minimumTouchTargetSize
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import com.adevinta.spark.tools.preview.SparkPreviewProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import com.adevinta.spark.tools.preview.UserType

/**
 * Chips help users quickly recognize an important information that has been entered by them,
 * trigger actions, make selections, or filter content.
 *
 * @param colors one of [ChipColors] that will be used to resolve the colors used for this chip in
 * different states, as well as the border to draw around the container of this chip.
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
 * Use [ChipLayout] to set a custom content that respects Spark specs.
 */
@OptIn(ExperimentalMaterial3Api::class)
@InternalSparkApi
@Composable
internal fun BaseSparkChip(
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
        modifier = modifier.minimumTouchTargetSize().sparkUsageOverlay(),
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
 * @param colors one of [ChipColors] that will be used to resolve the colors used for this chip in
 * different states, as well as the border to draw around the container of this chip.
 * @param onClick called when this chip is clicked
 * @param text label for this chip
 * @param modifier the [Modifier] to be applied to this chip
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param leadingIcon optional icon at the start of the chip, preceding the [text]
 * @param border [BorderStroke] the border to draw around the container of this chip. Pass `null` for no border.
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 */
@InternalSparkApi
@Composable
internal fun SparkChip(
    colors: ChipColors,
    onClick: () -> Unit,
    text: String?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: SparkIcon? = null,
    border: BorderStroke? = null,
    contentDescription: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    BaseSparkChip(
        colors = colors,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        border = border,
        interactionSource = interactionSource,
    ) {
        ChipContent(
            colors = colors,
            leadingIcon = leadingIcon,
            text = text,
            contentDescription = contentDescription,
            enabled = enabled,
        )
    }
}

/**
 * Layout to arrange the chips content. Set's expected padding, size, arrangement and alignment.
 * It could be used to set a custom content for the chip.
 *
 * @param modifier the [Modifier] to be applied to this layout.
 * @param content a Composable to set as the chip's content.
 */
@InternalSparkApi
@Composable
public fun ChipLayout(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier
            .defaultMinSize(minHeight = ChipDefaults.MinHeight)
            .sizeIn(maxWidth = ChipDefaults.MaxWidth)
            .padding(horizontal = ChipDefaults.HorizontalElementsPadding),
        horizontalArrangement = Arrangement.spacedBy(
            ChipDefaults.LeadingIconEndSpacing,
            Alignment.CenterHorizontally,
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        content()
    }
}

@InternalSparkApi
@Composable
internal fun ChipContent(
    colors: ChipColors,
    leadingIcon: SparkIcon?,
    text: String?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    enabled: Boolean = true,
) {
    ChipLayout(modifier = modifier) {
        this.ChipContent(leadingIcon, colors, contentDescription, text, enabled)
    }
}

@InternalSparkApi
@Composable
internal fun RowScope.ChipContent(
    leadingIcon: SparkIcon?,
    colors: ChipColors,
    contentDescription: String?,
    text: String?,
    enabled: Boolean = true,
) {
    if (leadingIcon != null) {
        CompositionLocalProvider(
            LocalContentColor provides if (enabled) colors.contentColor else colors.disabledContentColor,
        ) {
            Icon(
                sparkIcon = leadingIcon,
                modifier = Modifier.size(TagDefaults.LeadingIconSize),
                contentDescription = contentDescription,
                tint = LocalContentColor.current,
            )
        }
    }
    if (text != null) {
        Text(text = text)
    }
}

@Preview(
    group = "Chips",
)
@Composable
internal fun ChipPreview(
    @PreviewParameter(SparkPreviewProvider::class) param: Pair<ThemeVariant, UserType>,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        val intent = ChipIntent.Primary
        Row(
            modifier = Modifier
                .ifTrue(intent == ChipIntent.Surface) {
                    background(SparkTheme.colors.surfaceInverse)
                }
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ChipOutlined("outlined", intent, leadingIcon = SparkIcon.Account.Offers.Outlined)
            ChipFilled("filled", intent, leadingIcon = SparkIcon.Account.Offers.Outlined)
            ChipTinted("tinted", intent, leadingIcon = SparkIcon.Account.Offers.Outlined)
            ChipDashed("dashed", intent, leadingIcon = SparkIcon.Account.Offers.Outlined)
        }
        Row(
            modifier = Modifier
                .ifTrue(intent == ChipIntent.Surface) {
                    background(SparkTheme.colors.surfaceInverse)
                }
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ChipOutlined("outlined", intent, leadingIcon = SparkIcon.Account.Offers.Outlined, enabled = false)
            ChipFilled("filled", intent, leadingIcon = SparkIcon.Account.Offers.Outlined, enabled = false)
            ChipTinted("tinted", intent, leadingIcon = SparkIcon.Account.Offers.Outlined, enabled = false)
            ChipDashed("dashed", intent, leadingIcon = SparkIcon.Account.Offers.Outlined, enabled = false)
        }
        Row(
            modifier = Modifier
                .ifTrue(intent == ChipIntent.Surface) {
                    background(SparkTheme.colors.surfaceInverse)
                }
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ChipOutlined("outlined", intent)
            ChipFilled("filled", intent)
            ChipTinted("tinted", intent)
            ChipDashed("dashed", intent)
        }
        Row(
            modifier = Modifier
                .ifTrue(intent == ChipIntent.Surface) {
                    background(SparkTheme.colors.surfaceInverse)
                }
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ChipOutlined("outlined", intent, enabled = false)
            ChipFilled("filled", intent, enabled = false)
            ChipTinted("tinted", intent, enabled = false)
            ChipDashed("dashed", intent, enabled = false)
        }
    }
}

