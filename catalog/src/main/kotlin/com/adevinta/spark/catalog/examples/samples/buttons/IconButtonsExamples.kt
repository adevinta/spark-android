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
import androidx.compose.ui.unit.dp
import com.adevinta.spark.catalog.model.Example
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.iconbuttons.IconButtonContrast
import com.adevinta.spark.components.iconbuttons.IconButtonFilled
import com.adevinta.spark.components.iconbuttons.IconButtonGhost
import com.adevinta.spark.components.iconbuttons.IconButtonOutlined
import com.adevinta.spark.components.iconbuttons.IconButtonTinted
import com.adevinta.spark.icons.LikeFill
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons

private const val IconButtonsExampleDescription = "Icon Button examples"
private const val IconButtonsExampleSourceUrl = "$SampleSourceUrl/IconButtonSamples.kt"
public val IconButtonsExamples: List<Example> = listOf(
    Example(
        name = "Filled Icon Button",
        description = IconButtonsExampleDescription,
        sourceUrl = IconButtonsExampleSourceUrl,
    ) {
        IconButtonSample(
            button = { onClick, enabled, icon, contentDescription ->
                IconButtonFilled(
                    onClick = onClick,
                    enabled = enabled,
                    icon = icon,
                    contentDescription = contentDescription,
                )
            },
        )
    },
    Example(
        name = "Tinted Icon Button",
        description = IconButtonsExampleDescription,
        sourceUrl = IconButtonsExampleSourceUrl,
    ) {
        IconButtonSample(
            button = { onClick, enabled, icon, contentDescription ->
                IconButtonTinted(
                    onClick = onClick,
                    enabled = enabled,
                    icon = icon,
                    contentDescription = contentDescription,
                )
            },
        )
    },
    Example(
        name = "Outlined Icon Button",
        description = IconButtonsExampleDescription,
        sourceUrl = IconButtonsExampleSourceUrl,
    ) {
        IconButtonSample(
            button = { onClick, enabled, icon, contentDescription ->
                IconButtonOutlined(
                    onClick = onClick,
                    enabled = enabled,
                    icon = icon,
                    contentDescription = contentDescription,
                )
            },
        )
    },
    Example(
        name = "Ghost Icon Button",
        description = IconButtonsExampleDescription,
        sourceUrl = IconButtonsExampleSourceUrl,
    ) {
        IconButtonSample(
            button = { onClick, enabled, icon, contentDescription ->
                IconButtonGhost(
                    onClick = onClick,
                    enabled = enabled,
                    icon = icon,
                    contentDescription = contentDescription,
                )
            },
        )
    },
    Example(
        name = "Contrast Icon Button",
        description = IconButtonsExampleDescription,
        sourceUrl = IconButtonsExampleSourceUrl,
    ) {
        IconButtonSample(
            button = { onClick, enabled, icon, contentDescription ->
                IconButtonContrast(
                    onClick = onClick,
                    enabled = enabled,
                    icon = icon,
                    contentDescription = contentDescription,
                )
            },
        )
    },
)

@Composable
private fun IconButtonSample(
    button: @Composable (
        onClick: () -> Unit,
        enabled: Boolean,
        icon: SparkIcon,
        contentDescription: String?,
    ) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        val icon = SparkIcons.LikeFill
        val contentDescription = "Localized Content Description"
        button(
            onClick = { },
            enabled = true,
            icon = icon,
            contentDescription = contentDescription,
        )
        button(
            onClick = { },
            enabled = false,
            icon = icon,
            contentDescription = contentDescription,
        )
    }
}
