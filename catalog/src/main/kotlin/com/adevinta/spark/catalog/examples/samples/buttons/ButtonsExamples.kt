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
package com.adevinta.spark.catalog.examples.samples.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.adevinta.spark.catalog.model.Example
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.buttons.ButtonContrast
import com.adevinta.spark.components.buttons.ButtonFilled
import com.adevinta.spark.components.buttons.ButtonGhost
import com.adevinta.spark.components.buttons.ButtonOutlined
import com.adevinta.spark.components.buttons.ButtonTinted
import com.adevinta.spark.components.buttons.IconSide
import com.adevinta.spark.icons.LikeFill
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons

private const val ButtonsExampleDescription = "Button examples"
private const val ButtonsExampleSourceUrl = "$SampleSourceUrl/ButtonSamples.kt"
public val ButtonsExamples: List<Example> = listOf(
    Example(
        name = "Filled Button",
        description = ButtonsExampleDescription,
        sourceUrl = ButtonsExampleSourceUrl,
    ) {
        ButtonSample(
            button = { onClick, text, enabled, icon, iconSide, isLoading ->
                ButtonFilled(
                    onClick = onClick,
                    text = text,
                    enabled = enabled,
                    icon = icon,
                    iconSide = iconSide,
                    isLoading = isLoading,
                )
            },
        )
    },
    Example(
        name = "Tinted Button",
        description = ButtonsExampleDescription,
        sourceUrl = ButtonsExampleSourceUrl,
    ) {
        ButtonSample(
            button = { onClick, text, enabled, icon, iconSide, isLoading ->
                ButtonTinted(
                    onClick = onClick,
                    text = text,
                    enabled = enabled,
                    icon = icon,
                    iconSide = iconSide,
                    isLoading = isLoading,
                )
            },
        )
    },
    Example(
        name = "Outlined Button",
        description = ButtonsExampleDescription,
        sourceUrl = ButtonsExampleSourceUrl,
    ) {
        ButtonSample(
            button = { onClick, text, enabled, icon, iconSide, isLoading ->
                ButtonOutlined(
                    onClick = onClick,
                    text = text,
                    enabled = enabled,
                    icon = icon,
                    iconSide = iconSide,
                    isLoading = isLoading,
                )
            },
        )
    },
    Example(
        name = "Ghost Button",
        description = ButtonsExampleDescription,
        sourceUrl = ButtonsExampleSourceUrl,
    ) {
        ButtonSample(
            button = { onClick, text, enabled, icon, iconSide, isLoading ->
                ButtonGhost(
                    onClick = onClick,
                    text = text,
                    enabled = enabled,
                    icon = icon,
                    iconSide = iconSide,
                    isLoading = isLoading,
                )
            },
        )
    },
    Example(
        name = "Contrast Button",
        description = ButtonsExampleDescription,
        sourceUrl = ButtonsExampleSourceUrl,
    ) {
        ButtonSample(
            button = { onClick, text, enabled, icon, iconSide, isLoading ->
                ButtonContrast(
                    onClick = onClick,
                    text = text,
                    enabled = enabled,
                    icon = icon,
                    iconSide = iconSide,
                    isLoading = isLoading,
                )
            },
        )
    },
)

@Composable
private fun ButtonSample(
    button: @Composable (
        onClick: () -> Unit,
        text: String,
        enabled: Boolean,
        icon: SparkIcon?,
        iconSide: IconSide,
        isLoading: Boolean,
    ) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        val icon = SparkIcons.LikeFill
        var isLoading by remember { mutableStateOf(false) }
        val buttonText = "Filled Button"

        button(
            /* onClick = */ { isLoading = !isLoading },
            /* text = */ buttonText,
            /* enabled = */true,
            /* icon = */ null,
            /* iconSide = */ IconSide.START,
            /* isLoading = */ isLoading,
        )
        button(
            /* onClick = */ { isLoading = !isLoading },
            /* text = */ buttonText,
            /* enabled = */true,
            /* icon = */ icon,
            /* iconSide = */ IconSide.START,
            /* isLoading = */ isLoading,
        )
        button(
            /* onClick = */ { isLoading = !isLoading },
            /* text = */ buttonText,
            /* enabled = */true,
            /* icon = */ icon,
            /* iconSide = */ IconSide.END,
            /* isLoading = */ isLoading,
        )
        button(
            /* onClick = */ { isLoading = !isLoading },
            /* text = */ buttonText,
            /* enabled = */false,
            /* icon = */ icon,
            /* iconSide = */ IconSide.START,
            /* isLoading = */ isLoading,
        )
    }
}
