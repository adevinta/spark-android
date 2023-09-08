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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.model.Component
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.util.PreviewTheme
import com.adevinta.spark.catalog.util.drawForegroundGradientScrim
import com.adevinta.spark.components.image.Illustration
import com.adevinta.spark.components.tags.TagIntent
import com.adevinta.spark.components.tags.TagTinted

@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun ComponentItem(
    component: Component,
    onClick: (component: Component) -> Unit,
    showExampleCount: Boolean = true,
) {
    OutlinedCard(
        onClick = { onClick(component) },
        modifier = Modifier
            .height(ComponentItemHeight)
            .padding(ComponentItemOuterPadding),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            val tint = ColorFilter.tint(LocalContentColor.current).takeIf { component.tintIcon }
            Illustration(
                modifier = Modifier
                    .fillMaxSize()
                    .drawForegroundGradientScrim(
                        color = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
                    ),
                drawableRes = component.illustration,
                contentDescription = null,
                colorFilter = tint,
            )
            Text(
                text = component.name,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(ComponentItemInnerPadding),
                style = MaterialTheme.typography.bodySmall,
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

@Preview
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
