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
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tools.preview.SparkPreviewProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import com.adevinta.spark.tools.preview.UserType

@InternalSparkApi
@Composable
internal fun TagOutlined(
    colors: TagColors,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    SparkTag(
        colors = colors,
        modifier = modifier,
        border = BorderStroke(
            TagDefaults.OutlinedBorderSize,
            colors.contentColor,
        ),
        leadingIcon = null,
        content = content,
    )
}

@Composable
fun TagPromote(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    TagOutlined(
        modifier = modifier,
        colors = TagDefaults.outlineColors(),
        content = content,
    )
}

@Composable
fun TagUrgent(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    TagOutlined(
        modifier = modifier,
        colors = TagDefaults.outlineColors(
            contentColor = SparkTheme.colors.primary,
        ),
        content = content,
    )
}

@Composable
fun TagPro(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    TagOutlined(
        modifier = modifier,
        colors = TagDefaults.outlineColors(
            contentColor = SparkTheme.colors.secondary,
        ),
        content = content,
    )
}

@Preview(
    group = "Tags",
)
@Composable
internal fun TagOutlinedPreview(
    @PreviewParameter(SparkPreviewProvider::class) param: Pair<ThemeVariant, UserType>,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        TagPromote {
            Text(text = "Sponsorisé")
        }

        TagUrgent {
            Text(text = "Nouveau")
        }

        TagPro {
            Text(text = "Pro")
        }
    }
}
