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

package com.adevinta.spark.catalog.tabbar

import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.CatalogHomeScreen
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.util.PreviewTheme
import com.adevinta.spark.components.image.Illustration
import com.adevinta.spark.components.text.Text
import com.airbnb.android.showkase.ui.SemanticsUtils.lineCountVal
import com.google.accompanist.drawablepainter.rememberDrawablePainter

@Composable
public fun CatalogTabBar(
    modifier: Modifier = Modifier,
    children: @Composable (Modifier) -> Unit,
) {
    Row(
        modifier = modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val drawable = AppCompatResources.getDrawable(LocalContext.current, R.mipmap.ic_launcher)
        val painter = rememberDrawablePainter(drawable)
        Illustration(
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp),
            painter = painter, // spark logo
            contentDescription = null,
        )
        children(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
        )
    }
}

@Composable
internal fun CatalogTabs(
    modifier: Modifier = Modifier,
    titles: List<String>,
    tabSelected: CatalogHomeScreen,
    onTabSelected: (CatalogHomeScreen) -> Unit,
) {
    ScrollableTabRow(
        selectedTabIndex = tabSelected.ordinal,
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = LocalContentColor.current,
        indicator = { tabPositions: List<TabPosition> ->
            Box(
                Modifier
                    .tabIndicatorOffset(tabPositions[tabSelected.ordinal])
                    .fillMaxSize()
                    .padding(horizontal = 4.dp)
                    .border(BorderStroke(2.dp, LocalContentColor.current), SparkTheme.shapes.full),
            )
        },
        divider = { },
    ) {
        titles.forEachIndexed { index, title ->
            val selected = index == tabSelected.ordinal

            Tab(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .clip(SparkTheme.shapes.full),
                selected = selected,
                onClick = {
                    onTabSelected(CatalogHomeScreen.values()[index])
                },
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                    text = title.capitalize(Locale.current),
                    style = SparkTheme.typography.body2,
                )
            }
        }
    }
}

@Composable
public fun ToolbarTitle(
    string: String,
    modifier: Modifier,
) {
    val lineCount = remember { mutableStateOf(0) }

    Text(
        text = string,
        modifier = modifier.semantics {
            lineCountVal = lineCount.value
        },
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        onTextLayout = {
            lineCount.value = it.lineCount
        },
    )
}

@Preview
@Composable
private fun CatalogTabBarPreview() {
    PreviewTheme(
        padding = PaddingValues(0.dp),
    ) {

        CatalogTabBar(
            modifier = Modifier
                .wrapContentWidth()
                .sizeIn(maxWidth = 500.dp),
        ) { tabBarModifier ->
            CatalogTabs(
                modifier = tabBarModifier,
                titles = CatalogHomeScreen.values().map { it.name },
                tabSelected = CatalogHomeScreen.Showkase,
                onTabSelected = { },
            )
        }
    }
}
