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
package com.adevinta.spark.catalog.icons

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.getSystemService
import androidx.navigation.NavController
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.util.splitCamelWithSpaces
import com.adevinta.spark.components.chips.ChipSelectable
import com.adevinta.spark.components.chips.ChipStyles
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.icons.IconSize
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.icons.Check
import com.adevinta.spark.icons.DeleteFill
import com.adevinta.spark.icons.Search
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.withContext
import java.util.Locale
import com.adevinta.spark.icons.R as IconR

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
public fun IconsScreen(
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    var icons: List<NamedAsset> by remember {
        mutableStateOf(emptyList())
    }
    LaunchedEffect(Unit) {
        icons = getAllIconsRes(context)
    }
    var query: String by rememberSaveable { mutableStateOf("") }
    var showIcons by rememberSaveable { mutableStateOf(true) }
    var showAnimatedIcons by rememberSaveable { mutableStateOf(true) }

    val filteredIcons by remember(query, showIcons, showAnimatedIcons) {
        derivedStateOf {
            if (query.isEmpty()) {
                icons
            } else {
                icons.filter { it.name.contains(query, ignoreCase = true) }
            }.filterNot {
                !showIcons && it is NamedAsset.Icon
            }.filterNot {
                !showAnimatedIcons && it is NamedAsset.AnimatedIcon
            }
        }
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        TextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp),
            placeholder = stringResource(id = R.string.icons_screen_search_helper),
            leadingContent = {
                Icon(sparkIcon = SparkIcons.Search, contentDescription = null)
            },
            trailingContent = {
                Icon(
                    modifier = Modifier.clickable { query = "" },
                    sparkIcon = SparkIcons.DeleteFill,
                    contentDescription = "Clear",
                )
            },
        )
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ChipSelectable(
                selected = showIcons,
                text = "Icon",
                onClick = { showIcons = !showIcons },
                style = ChipStyles.Tinted,
                leadingIcon = if (showIcons) SparkIcons.Check else null,
            )
            ChipSelectable(
                selected = showAnimatedIcons,
                text = "Animated Icon",
                onClick = { showAnimatedIcons = !showAnimatedIcons },
                style = ChipStyles.Tinted,
                leadingIcon = if (showAnimatedIcons) SparkIcons.Check else null,
            )
        }
        LazyVerticalGrid(
            modifier = modifier
                .consumeWindowInsets(contentPadding)
                .fillMaxSize()
                .clickable(
                    // no ripple effect is needed as this onClick is just to clear the focus of the search field
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ) {
                    focusManager.clearFocus()
                },
            contentPadding = contentPadding,
            columns = GridCells.Adaptive(minSize = 60.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(
                items = filteredIcons,
                key = { it.name },
                contentType = { it is NamedAsset.Icon },
            ) { asset ->
                val drawableRes = asset.drawableRes
                val iconName = asset.name
                val isAnimated = asset is NamedAsset.AnimatedIcon
                Column(
                    modifier = Modifier
                        .clip(SparkTheme.shapes.small)
                        .combinedClickable(
                            onLongClick = { copyToClipboard(context, iconName) },
                            onClick = {
                                navController.navigate(
                                    route = "$IconDemoRoute/$drawableRes/$iconName/$isAnimated",
                                )
                            },
                        )
                        .padding(8.dp)
                        .animateItemPlacement(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Icon(
                        sparkIcon = SparkIcon.DrawableRes(drawableRes),
                        contentDescription = null,
                        size = IconSize.ExtraLarge,
                    )
                    Text(
                        text = iconName.splitCamelWithSpaces(),
                        style = SparkTheme.typography.caption,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Stable
private sealed class NamedAsset(open val name: String, @DrawableRes open val drawableRes: Int) {
    data class Icon(override val name: String, @DrawableRes override val drawableRes: Int) :
        NamedAsset(name, drawableRes)

    data class AnimatedIcon(override val name: String, @DrawableRes override val drawableRes: Int) :
        NamedAsset(name, drawableRes)
}

private suspend fun getAllIconsRes(context: Context) = withContext(Default) {
    IconR.drawable::class.java.declaredFields.mapNotNull { field ->
        val prefix = "spark_icons_"
        val icon = field.getInt(null)
        val name = context.resources.getResourceEntryName(icon)
        if (!name.startsWith(prefix)) return@mapNotNull null
        when {
            name.contains("animated") -> {
                val animatedName = name.removePrefix(prefix).removeSuffix("_animated").toPascalCase()
                NamedAsset.AnimatedIcon(animatedName, icon)
            }

            else -> NamedAsset.Icon(name.removePrefix(prefix).toPascalCase(), icon)
        }
    }
}

private fun String.toPascalCase(): String = split("_").joinToString(separator = "") { str ->
    str.replaceFirstChar {
        if (it.isLowerCase()) {
            it.titlecase(Locale.ROOT)
        } else {
            it.toString()
        }
    }
}

private fun copyToClipboard(context: Context, text: String) {
    val clipboardManager = context.getSystemService<ClipboardManager>() ?: return
    val clip = ClipData.newPlainText("spark_icon_name", text)
    clipboardManager.setPrimaryClip(clip)
}
