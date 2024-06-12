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
package com.adevinta.spark.components.divider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DividerDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.spacer.HorizontalSpacer
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.tokens.dim3
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import androidx.compose.material3.HorizontalDivider as MaterialHorizontalDivider
import androidx.compose.material3.VerticalDivider as MaterialVerticalDivider

public enum class LabelHorizontalAlignment {
    Start,
    Center,
    End,
}

public enum class LabelVerticalAlignment {
    Top,
    Center,
    Bottom,
}

@Deprecated(
    "Divider is deprecated",
    ReplaceWith("HorizontalDivider()"),
)
@Composable
public fun Divider(
    modifier: Modifier = Modifier,
    color: Color = SparkTheme.colors.onSurface.dim3,
) {
    MaterialHorizontalDivider(
        modifier = modifier,
        thickness = DividerDefaults.Thickness,
        color = color,
    )
}

@Composable
public fun HorizontalDivider(
    modifier: Modifier = Modifier,
    intent: DividerIntent = DividerIntent.Outline,
    label: String? = null,
    labelHorizontalAlignment: LabelHorizontalAlignment = LabelHorizontalAlignment.Center,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val leftModifier = when (labelHorizontalAlignment) {
            LabelHorizontalAlignment.Start -> Modifier.width(40.dp)
            LabelHorizontalAlignment.Center, LabelHorizontalAlignment.End -> Modifier.weight(1f)
        }

        val rightModifier = when (labelHorizontalAlignment) {
            LabelHorizontalAlignment.End -> Modifier.width(40.dp)
            LabelHorizontalAlignment.Center, LabelHorizontalAlignment.Start -> Modifier.weight(1f)
        }

        MaterialHorizontalDivider(
            modifier = leftModifier,
            color = intent.color(),
        )

        if (label != null) {
            Text(
                style = SparkTheme.typography.body1,
                text = label,
                modifier = Modifier.padding(horizontal = 16.dp),
            )
        }

        MaterialHorizontalDivider(
            modifier = rightModifier,
            color = intent.color(),
        )
    }
}

@Composable
public fun VerticalDivider(
    modifier: Modifier = Modifier,
    intent: DividerIntent = DividerIntent.Outline,
    label: String? = null,
    labelVerticalAlignment: LabelVerticalAlignment = LabelVerticalAlignment.Center,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val topModifier = when (labelVerticalAlignment) {
            LabelVerticalAlignment.Top -> Modifier.height(40.dp)
            LabelVerticalAlignment.Center, LabelVerticalAlignment.Bottom -> Modifier.weight(1f)
        }

        val bottomModifier = when (labelVerticalAlignment) {
            LabelVerticalAlignment.Bottom -> Modifier.height(40.dp)
            LabelVerticalAlignment.Center, LabelVerticalAlignment.Top -> Modifier.weight(1f)
        }

        MaterialVerticalDivider(
            modifier = topModifier,
            color = intent.color(),
        )

        if (label != null) {
            Text(
                style = SparkTheme.typography.body1,
                text = label,
                modifier = Modifier.padding(vertical = 16.dp),
            )
        }

        MaterialVerticalDivider(
            modifier = bottomModifier,
            color = intent.color(),
        )
    }
}

@Preview(
    group = "Dividers",
    name = "Divider",
)
@Composable
internal fun DividerPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        HorizontalDivider(intent = DividerIntent.Outline)
        HorizontalDivider(intent = DividerIntent.OutlineHigh)
        HorizontalDivider(intent = DividerIntent.OutlineHigh, label = "Label")
        HorizontalDivider(
            intent = DividerIntent.Outline,
            label = "Label",
            labelHorizontalAlignment = LabelHorizontalAlignment.Start,
        )
        HorizontalDivider(
            intent = DividerIntent.OutlineHigh,
            label = "Label",
            labelHorizontalAlignment = LabelHorizontalAlignment.End,
        )
        Row {
            VerticalDivider(
                intent = DividerIntent.OutlineHigh,
                label = "Label",
                labelVerticalAlignment = LabelVerticalAlignment.Top,
            )
            VerticalDivider(
                intent = DividerIntent.OutlineHigh,
                label = "Label",
                labelVerticalAlignment = LabelVerticalAlignment.Center,
            )
            VerticalDivider(
                intent = DividerIntent.OutlineHigh,
                label = "Label",
                labelVerticalAlignment = LabelVerticalAlignment.Bottom,
            )
            HorizontalSpacer(space = 16.dp)
            VerticalDivider(
                labelVerticalAlignment = LabelVerticalAlignment.Bottom,
            )
            HorizontalSpacer(space = 16.dp)

            VerticalDivider(
                intent = DividerIntent.OutlineHigh,
                labelVerticalAlignment = LabelVerticalAlignment.Bottom,
            )
            HorizontalSpacer(space = 16.dp)

            VerticalDivider(
                label = "Label",
                labelVerticalAlignment = LabelVerticalAlignment.Top,
            )
            VerticalDivider(
                label = "Label",
                labelVerticalAlignment = LabelVerticalAlignment.Center,
            )
            VerticalDivider(
                label = "Label",
                labelVerticalAlignment = LabelVerticalAlignment.Bottom,
            )
        }
    }
}
