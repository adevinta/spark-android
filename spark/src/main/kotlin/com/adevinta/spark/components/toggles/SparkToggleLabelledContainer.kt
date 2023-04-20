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

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.spacer.HorizontalSpacer
import com.adevinta.spark.tools.modifiers.SlotArea
import com.adevinta.spark.tools.modifiers.minimumTouchTargetSize
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay

@Composable
internal fun SparkToggleLabelledContainer(
    state: ToggleableState,
    toggle: @Composable () -> Unit,
    role: Role,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentSide: ContentSide = ContentSide.End,
    content: @Composable() (RowScope.() -> Unit),
) {
    val toggleableModifier = if (onClick != null) {
        Modifier.triStateToggleable(
            state = state,
            onClick = onClick,
            enabled = enabled,
            role = role,
        )
    } else {
        Modifier
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .minimumTouchTargetSize()
            .clip(SparkTheme.shapes.small)
            .then(toggleableModifier)
            .sparkUsageOverlay(),
    ) {

        if (contentSide == ContentSide.Start) {
            HorizontalSpacer(8.dp)
            ProvideTextStyle(value = SparkTheme.typography.body1) {
                content()
            }
        }

        toggle()

        if (contentSide == ContentSide.End) {
            ProvideTextStyle(value = SparkTheme.typography.body1) {
                content()
            }
            HorizontalSpacer(8.dp)
        }
    }
}

public enum class ContentSide { Start, End }

@Preview(
    group = "Toggles",
    name = "LabelledSlot",
)
@Composable
internal fun TogglesLabelledSlotPreview() {
    PreviewTheme {
        SparkToggleLabelledContainer(
            state = ToggleableState(true),
            toggle = {
                RadioButton(
                    modifier = Modifier.minimumTouchTargetSize(),
                    selected = true,
                    onClick = null,
                )
            },
            role = Role.Checkbox,
            onClick = {},
            contentSide = ContentSide.Start,
            content = {
                SlotArea(color = LocalContentColor.current) {
                    Text("CheckBox On")
                }
            },
        )

        SparkToggleLabelledContainer(
            state = ToggleableState(true),
            toggle = {
                RadioButton(
                    modifier = Modifier.minimumTouchTargetSize(),
                    selected = true,
                    onClick = null,
                )
            },
            role = Role.Checkbox,
            onClick = {},
            contentSide = ContentSide.End,
            content = {
                SlotArea(color = LocalContentColor.current) {
                    Text("CheckBox On")
                }
            },
        )

        SparkToggleLabelledContainer(
            state = ToggleableState(true),
            toggle = {
                Checkbox(
                    modifier = Modifier.minimumTouchTargetSize(),
                    state = ToggleableState(true),
                    onClick = null,
                )
            },
            role = Role.Checkbox,
            onClick = {},
            contentSide = ContentSide.End,
            content = {
                SlotArea(color = LocalContentColor.current) {
                    Text("CheckBox On")
                }
            },
        )
    }
}
