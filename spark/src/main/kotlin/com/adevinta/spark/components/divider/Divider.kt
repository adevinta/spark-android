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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DividerDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.atLeast
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.spacer.HorizontalSpacer
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.tokens.dim3
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import androidx.compose.material3.HorizontalDivider as MaterialHorizontalDivider
import androidx.compose.material3.VerticalDivider as MaterialVerticalDivider

/**
 * LabelHorizontalAlignment is used to define the horizontal alignment of the label in the divider.
 * Alignment can be visible when Label is activated
 */
public enum class LabelHorizontalAlignment {
    Start,
    Center,
    End,
}

/**
 * LabelVerticalAlignment is used to define the vertical alignment of the label in the divider.
 * Alignment can be visible when Label is activated
 */
public enum class LabelVerticalAlignment {
    Top,
    Center,
    Bottom,
}

/**
 * A deprecated Divider Component.
 *
 * @param modifier The modifier to be applied to the divider.
 * @param color The color of the divider.
 */
@Deprecated(
    "Divider is deprecated and HorizontalDivider is its new alternative",
    ReplaceWith("HorizontalDivider(modifier = modifier)"),
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

/**
 * HorizontalDivider Component.
 * A divider is a thin line that groups content in lists and layouts.
 *
 * @param modifier The modifier to be applied to the divider.
 * @param intent The intent defining the color of the divider.
 * @param label The optional label to be displayed on the divider.
 * @param labelHorizontalAlignment The horizontal alignment of the label.
 */
@Composable
public fun HorizontalDivider(
    modifier: Modifier = Modifier,
    intent: DividerIntent = DividerIntent.Outline,
    labelHorizontalAlignment: LabelHorizontalAlignment = LabelHorizontalAlignment.Center,
    label: @Composable (BoxScope.() -> Unit)? = null,
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth(),
    ) {
        val (lineLeft, labelBox, lineRight) = createRefs()

        createHorizontalChain(lineLeft, labelBox, lineRight, chainStyle = ChainStyle.SpreadInside)

        MaterialHorizontalDivider(
            color = intent.color(),
            modifier = Modifier.constrainAs(lineLeft) {
                start.linkTo(parent.start)
                end.linkTo(labelBox.start)
                centerVerticallyTo(parent)
                width = if (labelHorizontalAlignment == LabelHorizontalAlignment.Start) {
                    Dimension.value(40.dp)
                } else {
                    Dimension.fillToConstraints.atLeast(40.dp)
                }
            },

        )

        if (label != null) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .constrainAs(labelBox) {
                        start.linkTo(lineLeft.end)
                        end.linkTo(lineRight.start)
                        centerVerticallyTo(parent)
                        width = Dimension.preferredWrapContent
                    },
            ) { label() }
        }

        MaterialHorizontalDivider(
            color = intent.color(),
            modifier = Modifier.constrainAs(lineRight) {
                start.linkTo(labelBox.end)
                end.linkTo(parent.end)
                centerVerticallyTo(parent) // Align vertically to the center of the parent
                width = if (labelHorizontalAlignment == LabelHorizontalAlignment.End) {
                    Dimension.value(40.dp)
                } else {
                    Dimension.fillToConstraints.atLeast(40.dp)
                }
            },

        )
    }
}

/**
 * VerticalDivider Component.
 * A divider is a thin line that groups content in lists and layouts.
 *
 * @param modifier The modifier to be applied to the divider.
 * @param intent The intent defining the color of the divider.
 * @param label The optional label to be displayed on the divider.
 * @param labelVerticalAlignment The vertical alignment of the label.
 */
@Composable
public fun VerticalDivider(
    modifier: Modifier = Modifier,
    intent: DividerIntent = DividerIntent.Outline,
    labelVerticalAlignment: LabelVerticalAlignment = LabelVerticalAlignment.Center,
    label: @Composable (BoxScope.() -> Unit)? = null,
) {
    ConstraintLayout(
        modifier = modifier.fillMaxHeight(),
    ) {
        val (lineTop, labelBox, lineBottom) = createRefs()

        createVerticalChain(lineTop, labelBox, lineBottom, chainStyle = ChainStyle.SpreadInside)

        MaterialVerticalDivider(
            color = intent.color(),
            modifier = Modifier.constrainAs(lineTop) {
                top.linkTo(parent.top)
                bottom.linkTo(labelBox.top)
                centerHorizontallyTo(parent) // Align horizontally to the center of the parent
                height = if (labelVerticalAlignment == LabelVerticalAlignment.Top) {
                    Dimension.value(40.dp)
                } else {
                    Dimension.fillToConstraints.atLeast(40.dp)
                }
            },
        )

        if (label != null) {
            Box(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .constrainAs(labelBox) {
                        top.linkTo(lineTop.bottom)
                        bottom.linkTo(lineBottom.top)
                        centerHorizontallyTo(parent)
                        height = Dimension.preferredWrapContent
                    },
            ) { label() }
        }

        // Bottom Divider
        androidx.compose.material3.VerticalDivider(
            color = intent.color(),
            modifier = Modifier.constrainAs(lineBottom) {
                top.linkTo(labelBox.bottom)
                bottom.linkTo(parent.bottom)
                centerHorizontallyTo(parent)
                height = if (labelVerticalAlignment == LabelVerticalAlignment.Bottom) {
                    Dimension.value(40.dp)
                } else {
                    Dimension.fillToConstraints.atLeast(40.dp)
                }
            },
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
        HorizontalDivider(
            intent = DividerIntent.OutlineHigh,
            label = { TextComposable() },
        )
        HorizontalDivider(
            intent = DividerIntent.Outline,
            labelHorizontalAlignment = LabelHorizontalAlignment.Start,
        )
        HorizontalDivider(
            intent = DividerIntent.OutlineHigh,
            label = { TextComposable() },
            labelHorizontalAlignment = LabelHorizontalAlignment.End,
        )
        HorizontalDivider(
            intent = DividerIntent.OutlineHigh,
            label = { TextComposable() },
            labelHorizontalAlignment = LabelHorizontalAlignment.Start,
        )

        Row {
            VerticalDivider(
                intent = DividerIntent.OutlineHigh,
                label = { TextComposable() },
                labelVerticalAlignment = LabelVerticalAlignment.Top,
            )
            VerticalDivider(
                intent = DividerIntent.OutlineHigh,
                label = { TextComposable() },
                labelVerticalAlignment = LabelVerticalAlignment.Center,
            )
            VerticalDivider(
                intent = DividerIntent.OutlineHigh,
                label = { TextComposable() },
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
                label = { TextComposable() },
                labelVerticalAlignment = LabelVerticalAlignment.Top,
            )
            VerticalDivider(
                label = { TextComposable() },
                labelVerticalAlignment = LabelVerticalAlignment.Center,
            )
            VerticalDivider(
                label = { TextComposable() },
                labelVerticalAlignment = LabelVerticalAlignment.Bottom,
            )
        }
    }
}

@Composable
private fun TextComposable(textOverflow: TextOverflow = TextOverflow.Ellipsis) {
    Text(
        textAlign = TextAlign.Center,
        overflow = textOverflow,
        style = SparkTheme.typography.body1,
        //  text = "jdkdkskjdkkklnljxcljcxlcjvxxcljljxcsdksj\n\ndljjjcdljcjdljcljdsljfdld\nlkjkjisd\nsdsksjddsk\njdksdjslds",
        text = "label",
    )
}
