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

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.badge.Badge
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.modifiers.dashedBorder
import com.adevinta.spark.tools.modifiers.ifTrue
import com.adevinta.spark.tools.preview.SparkPreviewProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import com.adevinta.spark.tools.preview.UserType


/**
 * Outlined chip with dashed border.
 * @param intent The [ChipIntent] colors that will be used for the content and background of this chip in
 * different states.
 * @param modifier The [Modifier] to be applied to the component
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 * @param onClick called when this chip is clicked
 * @param content a Composable to set as the chip's custom content.
 * Use [ChipLayout] to set a custom content that respects Spark specs.
 */
@Composable
public fun ChipDashed(
    intent: ChipIntent,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    val colors = ChipStyles.Dashed.colors(intent = intent)
    val chipContent: @Composable () -> Unit = {
        Box(
            Modifier.dashedBorder(
                width = ChipDefaults.BorderStrokeWidth,
                radius = ChipDefaults.DashedBorderRadius,
                color = if (enabled) colors.contentColor else colors.disabledContentColor,
            ),
        ) {
            content()
        }
    }
    BaseSparkChip(
        colors = colors,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        content = chipContent,
    )
}

/**
 * Outlined chip with dashed border
 * @param text The label for this chip
 * @param intent The [ChipIntent] colors that will be used for the content and background of this chip in
 * different states.
 * @param modifier The [Modifier] to be applied to the component
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param leadingIcon The spark icon shown at the start of the tag
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 * @param onClick called when this chip is clicked
 */
@Composable
public fun ChipDashed(
    text: String,
    intent: ChipIntent,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: SparkIcon? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {},
) {
    val colors = ChipStyles.Dashed.colors(intent = intent)
    ChipDashed(
        intent = intent,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        onClick = onClick,
    ) {
        ChipContent(
            colors = colors,
            leadingIcon = leadingIcon,
            text = text,
            enabled = enabled,
        )
    }
}

/**
 * Outlined chip with dashed border.
 * @param icon to draw inside the chip's content
 * @param intent The [ChipIntent] colors that will be used for the content and background of this chip in
 * different states.
 * @param contentDescription text used by accessibility services to describe what this icon
 * represents. This should always be provided unless this icon is used for decorative purposes,
 * and does not represent a meaningful action that a user can take. This text should be
 * localized, such as by using [androidx.compose.ui.res.stringResource] or similar
 * @param modifier The [Modifier] to be applied to the component
 * @param enabled controls the enabled state of this chip. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this chip. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this chip in different states.
 * @param onClick called when this chip is clicked
 */
@Composable
public fun ChipDashed(
    icon: SparkIcon,
    intent: ChipIntent,
    contentDescription: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {},
) {
    val colors = ChipStyles.Dashed.colors(intent = intent)
    ChipDashed(
        intent = intent,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        onClick = onClick,
    ) {
        ChipContent(
            colors = colors,
            leadingIcon = icon,
            text = null,
            contentDescription = contentDescription,
            enabled = enabled,
        )
    }
}


@Preview(
    group = "Chips",
    name = "Chips Dashed",
)
@Composable
internal fun ChipDashedPreview(
    @PreviewParameter(SparkPreviewProvider::class) param: Pair<ThemeVariant, UserType>,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        ChipIntent.values().forEach { intent ->
            listOf(true, false).forEach { enabled ->
                Row(
                    modifier = Modifier
                        .ifTrue(intent == ChipIntent.Surface) {
                            background(SparkTheme.colors.surfaceInverse)
                        },
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    ChipDashed(intent = intent, enabled = enabled) {
                        ChipLayout {
                            Text("Chip")
                            Badge(hasStroke = false, count = 1)
                        }
                    }
                    ChipDashed(intent.name, intent, leadingIcon = SparkIcon.Account.Offers.Outlined, enabled = enabled)
                    ChipDashed(intent.name, intent, enabled = enabled)
                    ChipDashed(
                        contentDescription = intent.name,
                        intent = intent,
                        icon = SparkIcon.Account.Offers.Outlined,
                        enabled = enabled,
                    )
                }
            }
        }
    }
}
