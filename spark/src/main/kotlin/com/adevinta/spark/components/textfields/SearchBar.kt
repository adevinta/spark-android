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
package com.adevinta.spark.components.textfields

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.isContainer
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.list.ListItem
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.FavoriteFill
import com.adevinta.spark.icons.MoreMenuVertical
import com.adevinta.spark.icons.Search
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import androidx.compose.material3.DockedSearchBar as MaterialDockedSearchBar
import androidx.compose.material3.SearchBar as MaterialSearchBar

/**
 *
 * A search bar represents a floating search field that allows users to enter a keyword or phrase
 * and get relevant information. It can be used as a way to navigate through an app via search
 * queries.
 *
 * An active search bar expands into a search "view" and can be used to display dynamic suggestions.
 *
 * A [SearchBar] expands to occupy the entirety of its allowed size when active. For full-screen
 * behavior as specified by Material guidelines, parent layouts of the [SearchBar] must not pass
 * any [Constraints] that limit its size, and the host activity should set
 * `WindowCompat.setDecorFitsSystemWindows(window, false)`.
 *
 * If this expansion behavior is undesirable, for example on large tablet screens, [DockedSearchBar]
 * can be used instead.
 *
 *
 * @param query the query text to be shown in the search bar's input field
 * @param onQueryChange the callback to be invoked when the input service updates the query. An
 * updated text comes as a parameter of the callback.
 * @param onSearch the callback to be invoked when the input service triggers the [ImeAction.Search]
 * action. The current [query] comes as a parameter of the callback.
 * @param active whether this search bar is active
 * @param onActiveChange the callback to be invoked when this search bar's active state is changed
 * @param modifier the [Modifier] to be applied to this search bar
 * @param enabled controls the enabled state of this search bar. When `false`, this component will
 * not respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param placeholder the placeholder to be displayed when the search bar's [query] is empty.
 * @param leadingIcon the leading icon to be displayed at the beginning of the search bar container
 * @param trailingIcon the trailing icon to be displayed at the end of the search bar container
 * @param shape the shape of this search bar when it is not [active]. When [active], the shape will
 * always be [SearchBarDefaults.fullScreenShape].
 * @param colors [SearchBarColors] that will be used to resolve the colors used for this search bar
 * in different states. See [SearchBarDefaults.colors].
 * @param tonalElevation when [SearchBarColors.containerColor] is [ColorScheme.surface], a
 * translucent primary color overlay is applied on top of the container. A higher tonal elevation
 * value will result in a darker color in light theme and lighter color in dark theme. See also:
 * [Surface].
 * @param windowInsets the window insets that the search bar will respect
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this search bar. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this search bar in different states.
 * @param content the content of this search bar that will be displayed below the input field
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@NonRestartableComposable
public fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = SearchBarDefaults.inputFieldShape,
    colors: SearchBarColors = SearchBarDefaults.colors(),
    tonalElevation: Dp = SearchBarDefaults.Elevation,
    windowInsets: WindowInsets = SearchBarDefaults.windowInsets,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable ColumnScope.() -> Unit,
) {
    MaterialSearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = onSearch,
        active = active,
        onActiveChange = onActiveChange,
        modifier = modifier,
        enabled = enabled,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = shape,
        colors = colors,
        tonalElevation = tonalElevation,
        windowInsets = windowInsets,
        interactionSource = interactionSource,
        content = content,
    )
}

/**
 *
 * A search bar represents a floating search field that allows users to enter a keyword or phrase
 * and get relevant information. It can be used as a way to navigate through an app via search
 * queries.
 *
 * An active search bar expands into a search "view" and can be used to display dynamic suggestions.
 *
 * A [SearchBar] expands to occupy the entirety of its allowed size when active. For full-screen
 * behavior as specified by Material guidelines, parent layouts of the [SearchBar] must not pass
 * any [Constraints] that limit its size, and the host activity should set
 * `WindowCompat.setDecorFitsSystemWindows(window, false)`.
 *
 * If this expansion behavior is undesirable, for example on large tablet screens, [DockedSearchBar]
 * can be used instead.
 *
 *
 * @param query the query text to be shown in the search bar's input field
 * @param onQueryChange the callback to be invoked when the input service updates the query. An
 * updated text comes as a parameter of the callback.
 * @param onSearch the callback to be invoked when the input service triggers the [ImeAction.Search]
 * action. The current [query] comes as a parameter of the callback.
 * @param active whether this search bar is active
 * @param onActiveChange the callback to be invoked when this search bar's active state is changed
 * @param modifier the [Modifier] to be applied to this search bar
 * @param enabled controls the enabled state of this search bar. When `false`, this component will
 * not respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param placeholder the placeholder to be displayed when the search bar's [query] is empty.
 * @param leadingIcon the leading icon to be displayed at the beginning of the search bar container
 * @param trailingIcon the trailing icon to be displayed at the end of the search bar container
 * @param shape the shape of this search bar when it is not [active]. When [active], the shape will
 * always be [SearchBarDefaults.fullScreenShape].
 * @param colors [SearchBarColors] that will be used to resolve the colors used for this search bar
 * in different states. See [SearchBarDefaults.colors].
 * @param tonalElevation when [SearchBarColors.containerColor] is [ColorScheme.surface], a
 * translucent primary color overlay is applied on top of the container. A higher tonal elevation
 * value will result in a darker color in light theme and lighter color in dark theme. See also:
 * [Surface].
 * @param windowInsets the window insets that the search bar will respect
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this search bar. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this search bar in different states.
 * @param content the content of this search bar that will be displayed below the input field
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@NonRestartableComposable
public fun DockedSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    active: Boolean,
    onActiveChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = SearchBarDefaults.dockedShape,
    colors: SearchBarColors = SearchBarDefaults.colors(),
    tonalElevation: Dp = SearchBarDefaults.Elevation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable ColumnScope.() -> Unit,
) {
    MaterialDockedSearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = onSearch,
        active = active,
        onActiveChange = onActiveChange,
        modifier = modifier,
        enabled = enabled,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = shape,
        colors = colors,
        tonalElevation = tonalElevation,
        interactionSource = interactionSource,
        content = content,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    group = "SearchBar",
    name = "SearchBar",
)
@Composable
internal fun SearchBarPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(
        theme,
        padding = PaddingValues(0.dp),
    ) {
        var text by rememberSaveable { mutableStateOf("") }
        var active by rememberSaveable { mutableStateOf(false) }

        Box(Modifier.fillMaxSize()) {
            // Talkback focus order sorts based on x and y position before considering z-index. The
            // extra Box with semantics and fillMaxWidth is a workaround to get the search bar to focus
            // before the content.
            Box(
                Modifier
                    .semantics {
                        isContainer = true
                    }
                    .zIndex(1f)
                    .fillMaxWidth(),
            ) {
                SearchBar(
                    modifier = Modifier.align(Alignment.TopCenter),
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = { active = false },
                    active = active,
                    onActiveChange = {
                        active = it
                    },
                    placeholder = { Text("Hinted search text") },
                    leadingIcon = { Icon(SparkIcons.Search, contentDescription = null) },
                    trailingIcon = { Icon(SparkIcons.MoreMenuVertical, contentDescription = null) },
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        items(4) { idx ->
                            val resultText = "Suggestion $idx"
                            ListItem(
                                headlineContent = { Text(resultText) },
                                supportingContent = { Text("Additional info") },
                                leadingContent = { Icon(SparkIcons.FavoriteFill, contentDescription = null) },
                                modifier = Modifier.clickable {
                                    text = resultText
                                    active = false
                                },
                            )
                        }
                    }
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(start = 16.dp, top = 72.dp, end = 16.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                val list = List(100) { "Text $it" }
                items(count = list.size) {
                    Text(
                        list[it],
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    group = "SearchBar",
    name = "DockedSearchBar",
)
@Composable
internal fun DockedSearchBarPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(
        theme,
        padding = PaddingValues(0.dp),
    ) {
        var text by rememberSaveable { mutableStateOf("") }
        var active by rememberSaveable { mutableStateOf(false) }

        Box(Modifier.fillMaxSize()) {
            // Talkback focus order sorts based on x and y position before considering z-index. The
            // extra Box with semantics and fillMaxWidth is a workaround to get the search bar to focus
            // before the content.
            Box(
                Modifier
                    .semantics {
                        @Suppress("DEPRECATION")
                        isContainer = true
                    }
                    .zIndex(1f)
                    .fillMaxWidth(),
            ) {
                DockedSearchBar(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 8.dp),
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = { active = false },
                    active = active,
                    onActiveChange = { active = it },
                    placeholder = { Text("Hinted search text") },
                    leadingIcon = { Icon(SparkIcons.Search, contentDescription = null) },
                    trailingIcon = { Icon(SparkIcons.MoreMenuVertical, contentDescription = null) },
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        items(4) { idx ->
                            val resultText = "Suggestion $idx"
                            ListItem(
                                headlineContent = { Text(resultText) },
                                supportingContent = { Text("Additional info") },
                                leadingContent = { Icon(SparkIcons.FavoriteFill, contentDescription = null) },
                                modifier = Modifier.clickable {
                                    text = resultText
                                    active = false
                                },
                            )
                        }
                    }
                }
            }

            LazyColumn(
                contentPadding = PaddingValues(start = 16.dp, top = 72.dp, end = 16.dp, bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                val list = List(100) { "Text $it" }
                items(count = list.size) {
                    Text(
                        list[it],
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}
