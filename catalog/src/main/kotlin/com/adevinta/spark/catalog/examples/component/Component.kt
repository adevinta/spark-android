/*
 * Copyright (c) 2023-2024 Adevinta
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

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.examples.example.ExampleItem
import com.adevinta.spark.catalog.model.Component
import com.adevinta.spark.catalog.model.Example
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.tokens.Layout

@OptIn(ExperimentalLayoutApi::class)
@Composable
public fun Component(
    component: Component,
    contentPadding: PaddingValues,
    onExampleClick: (example: Example) -> Unit,
) {
    val ltr = LocalLayoutDirection.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .consumeWindowInsets(contentPadding),
        contentPadding = PaddingValues(
            start = Layout.bodyMargin + contentPadding.calculateLeftPadding(ltr),
            end = Layout.bodyMargin + contentPadding.calculateRightPadding(ltr),
            top = contentPadding.calculateTopPadding(),
            bottom = contentPadding.calculateBottomPadding(),
        ),
    ) {
        item {
            Text(
                text = stringResource(id = R.string.description),
                style = SparkTheme.typography.body1,
            )
            Spacer(modifier = Modifier.height(ComponentPadding))
            Text(
                text = stringResource(id = component.description),
                style = SparkTheme.typography.body2,
            )
            Spacer(modifier = Modifier.height(ComponentDescriptionPadding))
        }
        item {
            Text(
                text = stringResource(id = R.string.examples),
                style = SparkTheme.typography.body1,
            )
            Spacer(modifier = Modifier.height(ComponentPadding))
        }
        if (component.examples.isNotEmpty()) {
            items(component.examples) { example ->
                ExampleItem(
                    example = example,
                    onClick = onExampleClick,
                )
                Spacer(modifier = Modifier.height(ExampleItemPadding))
            }
        } else {
            item {
                Text(
                    text = stringResource(id = R.string.no_examples),
                    style = SparkTheme.typography.body2,
                )
                Spacer(modifier = Modifier.height(ComponentPadding))
            }
        }
    }
}

private val ComponentIconSize = 108.dp
private val ComponentIconVerticalPadding = 42.dp
private val ComponentPadding = 16.dp
private val ComponentDescriptionPadding = 32.dp
private val ExampleItemPadding = 8.dp
