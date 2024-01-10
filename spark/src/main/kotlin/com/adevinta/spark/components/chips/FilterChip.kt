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

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.tags.TagDefaults
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.modifiers.dashedBorder
import com.adevinta.spark.tools.modifiers.ifTrue
import com.adevinta.spark.tools.modifiers.minimumTouchTargetSize
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay


/**
 * A chip that is selectable for content filtering.
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
 * @param selected whether or not this component is selected
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
public fun FilterChip(
    text: String?,
    style: ChipStyles,
    intent: ChipIntent,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selected: Boolean = false,
    leadingIcon: SparkIcon? = null,
    contentDescription: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val colors = style.colors(intent = intent)
    val border = style.border(intent = intent, enabled = enabled)

    val (backgroundColor, contentColor) =
        when {
            !enabled -> colors.disabledBackgroundColor to colors.disabledContentColor
            selected -> colors.selectedBackgroundColor to colors.selectedContentColor
            else -> colors.backgroundColor to colors.contentColor
        }

    Surface(
        onClick = onClick,
        modifier = modifier
            .minimumTouchTargetSize()
            .sparkUsageOverlay(),
        enabled = enabled,
        selected = selected,
        shape = SparkTheme.shapes.small,
        color = backgroundColor,
        border = border,
        contentColor = contentColor,
        interactionSource = interactionSource,
    ) {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides SparkTheme.typography.body2,
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
    }
}
