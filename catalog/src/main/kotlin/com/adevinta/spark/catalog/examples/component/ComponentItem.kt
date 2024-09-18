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
package com.adevinta.spark.catalog.examples.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.model.Component
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.util.PreviewTheme
import com.adevinta.spark.catalog.util.drawForegroundGradientScrim
import com.adevinta.spark.components.image.Image
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.tags.TagTinted
import com.adevinta.spark.tokens.applyTonalElevation

@Composable
public fun ComponentItem(
    component: Component,
    onClick: (component: Component) -> Unit,
    showExampleCount: Boolean = true,
) {
    Surface(
        onClick = { onClick(component) },
        modifier = Modifier
            .height(ComponentItemHeight)
            .padding(ComponentItemOuterPadding),
        shape = SparkTheme.shapes.medium,
        border = BorderStroke(1.dp, SparkTheme.colors.outline),
    ) {
        Box {
            val tint = ColorFilter.tint(LocalContentColor.current).takeIf { component.tintIcon }
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .drawForegroundGradientScrim(
                        color = SparkTheme.colors.applyTonalElevation(SparkTheme.colors.surface, 1.dp),
                    ),
                model = component.illustration,
                contentDescription = null,
                colorFilter = tint,
            )
            Text(
                text = component.name,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(ComponentItemInnerPadding),
                style = SparkTheme.typography.body2,
            )
            if (showExampleCount) {
                TagTinted(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(ComponentItemInnerPadding),
                    text = component.examples.count().toString(),
                )
            }
        }
    }
}

private val ComponentItemHeight = 180.dp
private val ComponentItemOuterPadding = 4.dp
private val ComponentItemInnerPadding = 16.dp

@PreviewLightDark
@Composable
private fun ComponentItemPreview() {
    PreviewTheme {
        ComponentItem(
            component = Component(
                0,
                name = "Tokens",
                description = R.string.component_tokens_description,
                guidelinesUrl = "https://www.google.com/#q=constituto",
                docsUrl = "https://www.google.com/#q=dictas",
                sourceUrl = "http://www.bing.com/search?q=inani",
                examples = listOf(),
                configurator = Configurator(
                    name = "Ronny Bowman",
                    description = "singulis",
                    sourceUrl = "https://www.google.com/#q=tempor",
                    content = {},
                ),
            ),
            onClick = {},
        )
        ComponentItem(
            component = Component(
                0,
                name = "Tokens",
                description = R.string.component_tokens_description,
                illustration = R.drawable.illu_component_tokens,
                tintIcon = false,
                guidelinesUrl = "https://www.google.com/#q=constituto",
                docsUrl = "https://www.google.com/#q=dictas",
                sourceUrl = "http://www.bing.com/search?q=inani",
                examples = listOf(),
                configurator = Configurator(
                    name = "Ronny Bowman",
                    description = "singulis",
                    sourceUrl = "https://www.google.com/#q=tempor",
                    content = {},
                ),
            ),
            onClick = {},
        )
    }
}
