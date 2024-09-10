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
package com.adevinta.spark.catalog.examples.samples.icons

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFirst
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.model.Example
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.AccountToFill
import com.adevinta.spark.icons.AccountToFillAlt
import com.adevinta.spark.icons.AddToFill
import com.adevinta.spark.icons.LikeToFill
import com.adevinta.spark.icons.MessageToOutline
import com.adevinta.spark.icons.SearchToOutline
import com.adevinta.spark.icons.SparkAnimatedIcons
import com.adevinta.spark.tokens.disabled
import com.adevinta.spark.tokens.highlight
import kotlin.math.roundToInt

private const val IconsExampleSourceUrl = "$SampleSourceUrl/IconsSamples.kt"

public val IconsExamples: List<Example> = listOf(
    Example(
        name = "Animated Navigation bar",
        description = "Show how a lbc animated nav bar could look like",
        sourceUrl = IconsExampleSourceUrl,
    ) {
        var selected by remember { mutableStateOf(SparkAnimatedIcons.SearchToOutline.drawableId) }
        var icons by remember {
            mutableStateOf(
                listOf(
                    SparkAnimatedIcons.SearchToOutline,
                    SparkAnimatedIcons.LikeToFill,
                    SparkAnimatedIcons.AddToFill,
                    SparkAnimatedIcons.MessageToOutline,
                    SparkAnimatedIcons.AccountToFillAlt,
                ),
            )
        }
        Surface(
            elevation = NavigationBarDefaults.Elevation,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
                    .windowInsetsPadding(NavigationBarDefaults.windowInsets)
                    .defaultMinSize(NavigationBarHeight)
                    .selectableGroup(),
            ) {
                NavigationBarItem(
                    selected = selected == SparkAnimatedIcons.SearchToOutline.drawableId,
                    onClick = {
                        selected = SparkAnimatedIcons.SearchToOutline.drawableId
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            sparkIcon = SparkAnimatedIcons.SearchToOutline,
                            contentDescription = null,
                            atEnd = selected != SparkAnimatedIcons.SearchToOutline.drawableId,
                        )
                    },
                    label = {
                        Text(
                            text = "Rechercher",
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                        )
                    },
                )
                NavigationBarItem(
                    selected = selected == SparkAnimatedIcons.LikeToFill.drawableId,
                    onClick = {
                        selected = SparkAnimatedIcons.LikeToFill.drawableId
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            sparkIcon = SparkAnimatedIcons.LikeToFill,
                            contentDescription = null,
                            atEnd = selected == SparkAnimatedIcons.LikeToFill.drawableId,
                        )
                    },
                    label = {
                        Text(
                            text = "Favoris",
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                        )
                    },
                )
                NavigationBarItem(
                    selected = selected == SparkAnimatedIcons.AddToFill.drawableId,
                    onClick = {
                        selected = SparkAnimatedIcons.AddToFill.drawableId
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            sparkIcon = SparkAnimatedIcons.AddToFill,
                            contentDescription = null,
                            atEnd = selected == SparkAnimatedIcons.AddToFill.drawableId,
                        )
                    },
                    label = {
                        Text(
                            text = "Publier",
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                        )
                    },
                )
                NavigationBarItem(
                    selected = selected == SparkAnimatedIcons.MessageToOutline.drawableId,
                    onClick = {
                        selected = SparkAnimatedIcons.MessageToOutline.drawableId
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            sparkIcon = SparkAnimatedIcons.MessageToOutline,
                            contentDescription = null,
                            atEnd = selected != SparkAnimatedIcons.MessageToOutline.drawableId,
                        )
                    },
                    label = {
                        Text(
                            text = "Messages",
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                        )
                    },
                )
                NavigationBarItem(
                    selected = selected == SparkAnimatedIcons.AccountToFill.drawableId,
                    onClick = {
                        selected = SparkAnimatedIcons.AccountToFill.drawableId
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            sparkIcon = SparkAnimatedIcons.AccountToFill,
                            contentDescription = null,
                            atEnd = selected == SparkAnimatedIcons.AccountToFill.drawableId,
                        )
                    },
                    label = {
                        Text(
                            text = "Compte",
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                        )
                    },
                )
            }
        }
    },
)

@Composable
public fun RowScope.NavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val targetValue = when {
        !enabled -> SparkTheme.colors.onSurface.disabled
        else -> SparkTheme.colors.onSurface
    }
    val contentColor by animateColorAsState(
        targetValue = targetValue,
        animationSpec = tween(ItemAnimationDurationMillis),
    )
    val styledIcon = @Composable {
        // If there's a label, don't have a11y services repeat the icon description.
        val clearSemantics = label != null
        Box(modifier = if (clearSemantics) Modifier.clearAndSetSemantics {} else Modifier) {
            CompositionLocalProvider(LocalContentColor provides contentColor, content = icon)
        }
    }

    val styledLabel: @Composable (() -> Unit)? = label?.let {
        @Composable {
            val style = SparkTheme.typography.caption.highlight
            val mergedStyle = LocalTextStyle.current.merge(style)
            CompositionLocalProvider(
                LocalContentColor provides contentColor,
                LocalTextStyle provides mergedStyle,
                content = label,
            )
        }
    }

    // The color of the Ripple should always the selected color, as we want to show the color
    // before the item is considered selected, and hence before the new contentColor is
    // provided by BottomNavigationTransition.
    val ripple = rememberRipple(bounded = false, color = SparkTheme.colors.neutral)

    Box(
        modifier
            .selectable(
                selected = selected,
                onClick = onClick,
                enabled = enabled,
                role = Role.Tab,
                interactionSource = interactionSource,
                indication = ripple,
            )
            .defaultMinSize(NavigationBarHeight)
            .weight(1f),
        contentAlignment = Alignment.Center,
        propagateMinConstraints = true,
    ) {
        NavigationBarItemLayout(
            icon = styledIcon,
            label = styledLabel,
        )
    }
}

/**
 * Base layout for a [NavigationBarItem].
 *
 * @param icon icon for this item
 * @param label text label for this item
 */
@Composable
internal fun NavigationBarItemLayout(
    icon: @Composable () -> Unit,
    label: @Composable (() -> Unit)?,
) {
    Layout(
        content = {
            Box(Modifier.layoutId(IconLayoutIdTag)) { icon() }

            if (label != null) {
                Box(
                    Modifier
                        .layoutId(LabelLayoutIdTag)
                        .padding(horizontal = NavigationBarItemHorizontalPadding / 2),
                ) { label() }
            }
        },
    ) { measurables, constraints ->
        @Suppress("NAME_SHADOWING")
        val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)
        val iconPlaceable =
            measurables.fastFirst { it.layoutId == IconLayoutIdTag }.measure(looseConstraints)

        val labelPlaceable =
            label?.let {
                measurables
                    .fastFirst { it.layoutId == LabelLayoutIdTag }
                    .measure(looseConstraints)
            }

        placeLabelAndIcon(
            labelPlaceable!!,
            iconPlaceable,
            constraints,
        )
    }
}

/**
 * Places the provided [Placeable]s in the correct position.
 *
 * @param labelPlaceable text label placeable inside this item
 * @param iconPlaceable icon placeable inside this item
 * @param constraints constraints of the item
 */
private fun MeasureScope.placeLabelAndIcon(
    labelPlaceable: Placeable,
    iconPlaceable: Placeable,
    constraints: Constraints,
): MeasureResult {
    val contentHeight =
        iconPlaceable.height + IndicatorVerticalPadding.toPx() * 2 + labelPlaceable.height + 2.0.dp.toPx()

    // Icon (when selected) should be `contentVerticalPadding` from top
    val selectedIconY = IndicatorVerticalPadding.toPx()

    // Label should be fixed padding below icon
    val labelY = selectedIconY + iconPlaceable.height + 2.0.dp.toPx()

    val containerWidth = constraints.maxWidth

    val labelX = (containerWidth - labelPlaceable.width) / 2
    val iconX = (containerWidth - iconPlaceable.width) / 2

    return layout(containerWidth, contentHeight.roundToInt()) {
        labelPlaceable.placeRelative(labelX, (labelY).roundToInt())
        iconPlaceable.placeRelative(iconX, (selectedIconY).roundToInt())
    }
}

private const val IconLayoutIdTag: String = "icon"

private const val LabelLayoutIdTag: String = "label"

internal val NavigationBarHeight: Dp = 58.dp

internal const val ItemAnimationDurationMillis: Int = 100

/*@VisibleForTesting*/
private val NavigationBarItemHorizontalPadding: Dp = 4.dp

/*@VisibleForTesting*/
private val IndicatorVerticalPadding: Dp = 8.dp
