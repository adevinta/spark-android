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
package com.adevinta.spark.catalog.configurator.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BugReport
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.model.Component
import com.adevinta.spark.catalog.model.Components
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.util.IssueUrl
import com.adevinta.spark.catalog.util.openUrl
import com.adevinta.spark.components.divider.Divider
import com.adevinta.spark.components.iconbuttons.IconButtonGhost
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.menu.DropdownMenu
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.Computer
import com.adevinta.spark.icons.Link
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tokens.Layout

@Composable
public fun ConfiguratorComponentScreen(
    component: Component,
    configurator: Configurator,
    contentPadding: PaddingValues,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .consumeWindowInsets(WindowInsets.safeDrawing)
            .padding(contentPadding)
            .padding(horizontal = Layout.bodyMargin),
    ) {
        Box(
            modifier = Modifier.align(Alignment.End),
        ) {
            var expanded by remember { mutableStateOf(false) }
            IconButtonGhost(
                icon = SparkIcons.Link,
                onClick = { expanded = true },
                contentDescription = "Localized description",
            )

            ConfiguratorComponentMenu(
                component = component,
                expanded = expanded,
                onDismissRequest = { expanded = false },
            )
        }

        configurator.content()
    }
}

@Composable
private fun ConfiguratorComponentMenu(
    component: Component,
    expanded: Boolean,
    onDismissRequest: () -> Unit,
) {
    val context = LocalContext.current

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
    ) {
        DropdownMenuItem(
            text = { Text(stringResource(R.string.component_menu_guidlines)) },
            onClick = { context.openUrl(component.guidelinesUrl) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Palette,
                    contentDescription = null,
                )
            },
        )
        DropdownMenuItem(
            text = { Text(stringResource(R.string.component_menu_dev_docs)) },
            onClick = { context.openUrl(component.docsUrl) },
            leadingIcon = {
                Icon(
                    sparkIcon = SparkIcons.Computer,
                    contentDescription = null,
                )
            },
        )
        DropdownMenuItem(
            text = { Text(stringResource(R.string.component_menu_source)) },
            onClick = { context.openUrl(component.sourceUrl) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Code,
                    contentDescription = null,
                )
            },
        )
        Divider()
        DropdownMenuItem(
            text = { Text(stringResource(R.string.component_menu_issue)) },
            onClick = { context.openUrl(IssueUrl) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.BugReport,
                    contentDescription = null,
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ConfiguratorComponentMenuPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
    ) {
        ConfiguratorComponentMenu(
            component = Components.first(),
            expanded = true,
        ) {}
    }
}
