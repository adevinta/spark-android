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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.model.Component
import com.adevinta.spark.catalog.util.PreviewTheme
import com.adevinta.spark.catalog.util.drawForegroundGradientScrim
import com.adevinta.spark.components.badge.Badge
import com.adevinta.spark.components.badge.BadgeIntent
import com.adevinta.spark.components.badge.BadgeStyle
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.image.Image
import com.adevinta.spark.components.menu.DropdownMenu
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.icons.WheelOutline
import com.adevinta.spark.tokens.applyTonalElevation

@Composable
public fun ComponentItem(
    component: Component,
    onClick: (component: Component, configuratorId: String) -> Unit,
    countIndicator: Int = 0,
    configuratorCount: Int = -1,
) {
    var expanded by remember { mutableStateOf(false) }
    val singleContent = countIndicator == 1

    Surface(
        onClick = {
            if (singleContent || configuratorCount != countIndicator) {
                val firstConfiguratorId = component.configurators.first().id
                return@Surface onClick(component, firstConfiguratorId)
            } else {
                // Show a menu for all other options
                expanded = true
            }
        },
        modifier = Modifier
            .height(ComponentItemHeight)
            .padding(ComponentItemOuterPadding),
        shape = SparkTheme.shapes.medium,
        elevation = 2.dp,
    ) {
        Box(
            modifier = Modifier.wrapContentSize(Alignment.TopStart),
        ) {
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
            if (countIndicator > 1) {
                Badge(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(ComponentItemInnerPadding),
                    count = countIndicator,
                    intent = BadgeIntent.Basic,
                    badgeStyle = BadgeStyle.Small,
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                component.configurators.fastForEachIndexed { i, configurator ->
                    DropdownMenuItem(
                        text = { Text(configurator.name) },
                        onClick = {
                            onClick(component, configurator.id)
                            expanded = false
                        },
                        leadingIcon = { Icon(SparkIcons.WheelOutline, contentDescription = null) },
                    )
                }
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
                id = "colors",
                name = "Tokens",
                description = R.string.component_tokens_description,
                guidelinesUrl = "https://www.google.com/#q=constituto",
                docsUrl = "https://www.google.com/#q=dictas",
                sourceUrl = "http://www.bing.com/search?q=inani",
                examples = listOf(),
                configurators = emptyList(),
            ),
            countIndicator = 3,
            onClick = { _, _ -> },
        )
        ComponentItem(
            component = Component(
                id = "colors",
                name = "Tokens",
                description = R.string.component_tokens_description,
                illustration = R.drawable.illu_component_tokens,
                tintIcon = false,
                guidelinesUrl = "https://www.google.com/#q=constituto",
                docsUrl = "https://www.google.com/#q=dictas",
                sourceUrl = "http://www.bing.com/search?q=inani",
                examples = listOf(),
                configurators = emptyList(),
            ),
            onClick = { _, _ -> },
        )
    }
}
