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

package com.adevinta.spark.components.badge

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.tokens.contentColorFor
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

@OptIn(ExperimentalMaterial3Api::class)
@InternalSparkApi
@Composable
internal fun SparkBadge(
    modifier: Modifier = Modifier,
    containerColor: Color = BadgeDefaults.containerColor,
    contentColor: Color = contentColorFor(containerColor),
    content: (@Composable RowScope.() -> Unit)? = null,
) {
    Badge(
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        content = content,
    )
}

/**
 * Spark Badge.
 *
 * A badge represents dynamic information such as a number of pending requests in a navigation bar.
 *
 * ![Badge image](https://developer.android.com/images/reference/androidx/compose/material3/badge.png)
 *
 * @param modifier the Modifier to be applied to this badge
 * @param containerColor the color used for the background of this badge
 * @param contentColor the preferred color for content inside this badge. Defaults to either the matching content color for containerColor, or to the current LocalContentColor if containerColor is not a color from the theme.
 * @param content optional content to be rendered inside this badge
 **/
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalSparkApi
@Composable
public fun Badge(
    modifier: Modifier = Modifier,
    containerColor: Color = BadgeDefaults.containerColor,
    contentColor: Color = contentColorFor(containerColor),
    content: (@Composable RowScope.() -> Unit)? = null,
) {
    SparkBadge(
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        content = content,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    group = "Badge",
    name = "Badge",
)
@Composable
internal fun BadgePreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        Badge()
        Badge {
            Text("n°1")
        }
        Badge {
            Text("1")
        }
        Badge {
            Text("5")
        }
        Badge {
            Text("59")
        }
        Badge {
            Text("5999999")
        }
    }
}
