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

package com.adevinta.spark.components.buttons

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.buttons.SparkButton.TAG_PROGRESS_INDICATOR
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.modifiers.SlotArea
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay

@InternalSparkApi
@Composable
fun SparkButton(
    onClick: () -> Unit,
    colors: ButtonColors,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    icon: SparkIcon? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.sparkUsageOverlay(),
        enabled = enabled,
        elevation = elevation,
        shape = SparkTheme.shapes.extraSmall,
        border = border,
        colors = colors,
        contentPadding = contentPadding,
    ) {
        AnimatedVisibility(visible = isLoading) {
            Row {
                Box(Modifier.size(SparkButtonDefaults.IconSize)) {
                    CircularProgressIndicator(
                        Modifier.testTag(TAG_PROGRESS_INDICATOR),
                        color = LocalContentColor.current,
                        strokeWidth = 2.dp,
                    )
                }
                Spacer(Modifier.width(8.dp))
            }
        }
        if (icon != null && iconSide == IconSide.START) {
            Icon(
                sparkIcon = icon,
                modifier = Modifier
                    .size(SparkButtonDefaults.IconSize)
                    .testTag("buttonIcon"),
                contentDescription = null, // button text should be enough for context
            )
            Spacer(Modifier.width(SparkButtonDefaults.IconSpacing))
        }
        content()
        if (icon != null && iconSide == IconSide.END) {
            Spacer(Modifier.width(SparkButtonDefaults.IconSpacing))
            Icon(
                sparkIcon = icon,
                modifier = Modifier
                    .size(SparkButtonDefaults.IconSize)
                    .testTag("buttonIcon"),
                contentDescription = null, // button text should be enough for context
            )
        }
    }
}

object SparkButton {
    const val TAG_PROGRESS_INDICATOR = "progress_indicator"
}

enum class IconSide { START, END }

object SparkButtonDefaults {

    /**
     * The default size of the icon when used inside a [SparkButton].
     */
    val IconSize = 14.dp

    /**
     * The default size of the spacing between an icon and a text when they used inside a [SparkButton].
     */
    val IconSpacing = ButtonDefaults.IconSpacing

    /**
     * The default content padding used by [TextButton]
     */
    val ButtonContentPadding = PaddingValues(
        horizontal = 16.dp,
        vertical = 10.dp,
    )

    /**
     * The default content padding used by [TextButton]
     */
    val TextButtonContentPadding = ButtonDefaults.TextButtonContentPadding

    /**
     * The default border of [SecondaryButton]s
     */
    @Composable
    fun outlinedBorder(isDanger: Boolean): BorderStroke = BorderStroke(
        width = OutlinedBorderSize,
        color = if (isDanger) SparkTheme.colors.error else SparkTheme.colors.onSurface,
    )

    private val OutlinedBorderSize = 1.0.dp
}

@Preview(
    group = "Buttons",
    name = "Button Slots",
)
@Composable
internal fun SparkButtonPreview() {
    PreviewTheme {
        val icon = SparkIcon.Account.Identity
        val buttonText = "Primary Button"
        PrimaryButton(
            onClick = {},
        ) {
            SlotArea(color = LocalContentColor.current) {
                Text(buttonText)
            }
        }
        PrimaryButton(
            onClick = {},
            icon = icon,
        ) {
            SlotArea(color = LocalContentColor.current) {
                Text(buttonText)
            }
        }
        PrimaryButton(
            onClick = {},
            icon = icon,
            iconSide = IconSide.END,
        ) {
            SlotArea(color = LocalContentColor.current) {
                Text(buttonText)
            }
        }
    }
}
