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
package com.adevinta.spark.components.menu

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.components.divider.Divider
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.icons.IconButton
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.preview.SparkPreviewProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import com.adevinta.spark.tools.preview.UserType
import androidx.compose.material3.DropdownMenu as MaterialDropdownMenu
import androidx.compose.material3.DropdownMenuItem as MaterialDropdownMenuItem

/**
 * <a href="https://m3.material.io/components/menus/overview" class="external" target="_blank">Material Design dropdown menu</a>.
 *
 * Menus display a list of choices on a temporary surface. They appear when users interact with a
 * button, action, or other control.
 *
 * ![Dropdown menu image](https://developer.android.com/images/reference/androidx/compose/material3/menu.png)
 *
 * A [DropdownMenu] behaves similarly to a [Popup], and will use the position of the parent layout
 * to position itself on screen. Commonly a [DropdownMenu] will be placed in a [Box] with a sibling
 * that will be used as the 'anchor'. Note that a [DropdownMenu] by itself will not take up any
 * space in a layout, as the menu is displayed in a separate window, on top of other content.
 *
 * The [content] of a [DropdownMenu] will typically be [DropdownMenuItem]s, as well as custom
 * content. Using [DropdownMenuItem]s will result in a menu that matches the Material
 * specification for menus. Also note that the [content] is placed inside a scrollable [Column],
 * so using a [LazyColumn] as the root layout inside [content] is unsupported.
 *
 * [onDismissRequest] will be called when the menu should close for example when there is a
 * tap outside the menu, or when the back key is pressed.
 *
 * [DropdownMenu] changes its positioning depending on the available space, always trying to be
 * fully visible. It will try to expand horizontally, depending on layout direction, to the end of
 * its parent, then to the start of its parent, and then screen end-aligned. Vertically, it will
 * try to expand to the bottom of its parent, then from the top of its parent, and then screen
 * top-aligned. An [offset] can be provided to adjust the positioning of the menu for cases when
 * the layout bounds of its parent do not coincide with its visual bounds. Note the offset will
 * be applied in the direction in which the menu will decide to expand.
 *
 * Example usage:
 * @sample androidx.compose.material3.samples.MenuSample
 *
 * @param expanded whether the menu is expanded or not
 * @param onDismissRequest called when the user requests to dismiss the menu, such as by tapping
 * outside the menu's bounds
 * @param offset [DpOffset] to be added to the position of the menu
 */
@Composable
public fun DropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    offset: DpOffset = DpOffset(0.dp, 0.dp),
    properties: PopupProperties = PopupProperties(focusable = true),
    content: @Composable ColumnScope.() -> Unit,
) {
    MaterialDropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        offset = offset,
        properties = properties,
        content = content,
    )
}

/**
 * <a href="https://m3.material.io/components/menus/overview" class="external" target="_blank">Material Design dropdown menu</a> item.
 *
 * Menus display a list of choices on a temporary surface. They appear when users interact with a
 * button, action, or other control.
 *
 * ![Dropdown menu image](https://developer.android.com/images/reference/androidx/compose/material3/menu.png)
 *
 * Example usage:
 * @sample androidx.compose.material3.samples.MenuSample
 *
 * @param text text of the menu item
 * @param onClick called when this menu item is clicked
 * @param modifier the [Modifier] to be applied to this menu item
 * @param leadingIcon optional leading icon to be displayed at the beginning of the item's text
 * @param trailingIcon optional trailing icon to be displayed at the end of the item's text. This
 * trailing icon slot can also accept [Text] to indicate a keyboard shortcut.
 * @param enabled controls the enabled state of this menu item. When `false`, this component will
 * not respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param colors [MenuItemColors] that will be used to resolve the colors used for this menu item in
 * different states. See [MenuDefaults.itemColors].
 * @param contentPadding the padding applied to the content of this menu item
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this menu item. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this menu item in different states.
 */
@Composable
public fun DropdownMenuItem(
    text: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    colors: MenuItemColors = MenuDefaults.itemColors(),
    contentPadding: PaddingValues = MenuDefaults.DropdownMenuItemContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    MaterialDropdownMenuItem(
        text = text,
        onClick = onClick,
        modifier = modifier,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
    )
}

@Preview(
    group = "Menu",
    name = "DropdownMenu",
)
@Composable
internal fun DropdownMenuPreview(
    @PreviewParameter(SparkPreviewProvider::class) param: Pair<ThemeVariant, UserType>,
) {
    val (theme, userType) = param
    PreviewTheme(
        themeVariant = theme,
        userType = userType,
    ) {
        var expanded by remember { mutableStateOf(true) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
        ) {
            IconButton(onClick = { expanded = true }) {
                Icon(SparkIcon.Actions.More, contentDescription = "Localized description")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                DropdownMenuItem(
                    text = { Text("Edit") },
                    onClick = { /* Handle edit! */ },
                    leadingIcon = {
                        Icon(
                            SparkIcon.Actions.Pen.Default,
                            contentDescription = null,
                        )
                    },
                )
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = { /* Handle settings! */ },
                    leadingIcon = {
                        Icon(
                            SparkIcon.Actions.Wheel.Outlined,
                            contentDescription = null,
                        )
                    },
                )
                Divider()
                DropdownMenuItem(
                    text = { Text("Send Feedback") },
                    onClick = { /* Handle send feedback! */ },
                    leadingIcon = {
                        Icon(
                            SparkIcon.Contact.Mail.Outlined,
                            contentDescription = null,
                        )
                    },
                    trailingIcon = { Text("F11", textAlign = TextAlign.Center) },
                )
            }
        }
    }
}
