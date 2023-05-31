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
package com.adevinta.spark.components.tags

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.LocalLegacyStyle
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.tags.TagDefaults.LeadingIconSize
import com.adevinta.spark.components.tags.TagDefaults.MinHeight
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tokens.contentColorFor
import com.adevinta.spark.tools.modifiers.SlotArea
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay

@InternalSparkApi
@Composable
internal fun BaseSparkTag(
    colors: TagColors,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    leadingIcon: SparkIcon? = null,
    tint: Color? = null,
    content: @Composable RowScope.() -> Unit,
) {
    Surface(
        modifier = modifier.sparkUsageOverlay(),
        shape = if (LocalLegacyStyle.current) SparkTheme.shapes.extraSmall else SparkTheme.shapes.full,
        color = colors.backgroundColor,
        contentColor = colors.contentColor.copy(1.0f),
        border = border,
    ) {
        ProvideTextStyle(
            value = SparkTheme.typography.caption.copy(fontWeight = FontWeight.Bold),
        ) {
            Row(
                Modifier
                    .defaultMinSize(minHeight = MinHeight)
                    .padding(vertical = VerticalPadding, horizontal = HorizontalPadding),
                horizontalArrangement = Arrangement.spacedBy(LeadingIconEndSpacing, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (leadingIcon != null) {
                    CompositionLocalProvider(
                        LocalContentColor provides colors.contentColor,
                    ) {
                        Icon(
                            sparkIcon = leadingIcon,
                            modifier = Modifier.size(LeadingIconSize),
                            contentDescription = null, // The tag is associated with a mandatory label so it's okay
                            tint = tint ?: LocalContentColor.current,
                        )
                    }
                }
                ProvideTextStyle(value = SparkTheme.typography.caption.copy(fontWeight = FontWeight.Bold)) {
                    content()
                }
            }
        }
    }
}

@InternalSparkApi
@Composable
internal fun SparkTag(
    colors: TagColors,
    text: String,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    leadingIcon: SparkIcon? = null,
    tint: Color? = null,
) {
    BaseSparkTag(
        colors = colors,
        modifier = modifier,
        border = border,
        leadingIcon = leadingIcon,
        tint = tint,
    ) {
        Text(text = text)
    }
}

@InternalSparkApi
@Composable
internal fun SparkTag(
    colors: TagColors,
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    leadingIcon: SparkIcon? = null,
    tint: Color? = null,
) {
    BaseSparkTag(
        colors = colors,
        modifier = modifier,
        border = border,
        leadingIcon = leadingIcon,
        tint = tint,
    ) {
        Text(text = text)
    }
}

@Immutable
public data class TagColors(
    val backgroundColor: Color,
    val contentColor: Color,
)

public object TagDefaults {
    internal val MinHeight = 20.dp

    /**
     * The outlined tag's border size
     */
    internal val OutlinedBorderSize = 1.dp

    /**
     * The size of a tag's leading icon
     */
    internal val LeadingIconSize = 12.dp

    @Composable
    @InternalSparkApi
    public fun tintedColors(
        intent: TagIntent = TagIntent.Neutral,
    ): TagColors {
        val backgroundColor = intent.colors().containerColor
        return TagColors(
            backgroundColor = backgroundColor,
            contentColor = contentColorFor(backgroundColor = backgroundColor),
        )
    }

    @Composable
    internal fun filledColors(
        intent: TagIntent = TagIntent.Primary,
    ): TagColors {
        val backgroundColor = intent.colors().color
        return TagColors(
            backgroundColor = backgroundColor,
            contentColor = contentColorFor(backgroundColor = backgroundColor),
        )
    }

    @Composable
    internal fun outlinedColors(
        intent: TagIntent = TagIntent.Neutral,
    ): TagColors {
        val contentColor = intent.colors().color
        return TagColors(
            backgroundColor = Color.Transparent,
            contentColor = contentColor,
        )
    }
}

/**
 * The content padding used by a tag.
 * Used as start padding when there's leading icon, used as eng padding when there's no
 * trailing icon.
 */
private val LeadingIconEndSpacing = 4.dp

private val HorizontalPadding = 8.dp
private val VerticalPadding = 2.dp

@Preview(
    group = "Tags",
    name = "Tag",
)
@Composable
private fun SparkTagPreview() {
    PreviewTheme {
        val colors = TagDefaults.filledColors()
        BaseSparkTag(colors = colors) {
            SlotArea(color = LocalContentColor.current) {
                Text("À la une")
            }
        }
        BaseSparkTag(leadingIcon = SparkIcon.Options.Booster, colors = colors) {
            SlotArea(color = LocalContentColor.current) {
                Text("À la une")
            }
        }
    }
}
