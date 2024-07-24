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
package com.adevinta.spark.components.snackbars

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 *
 * Snackbars provide brief messages about app processes at the bottom of the screen.
 *
 * Snackbars inform users of a process that an app has performed or will perform. They appear
 * temporarily, towards the bottom of the screen. They shouldn’t interrupt the user experience,
 * and they don’t require user input to disappear.
 *
 * A Snackbar can contain a single action. Because Snackbar disappears automatically, the action
 * shouldn't be "Dismiss" or "Cancel".
 *
 * If you want to customize appearance of the [Snackbar], you can pass your own version as a child
 * of the [SnackbarHost] to the [Scaffold]
 *
 * If you want to change dynamically the snackbar color look at [Snackbar].
 *
 * @param modifier modifiers for the Snackbar layout
 * @param actionOnNewLine whether or not action should be put on the separate line. Recommended
 * for action with long action text
 * @param icon icon to be shown on the start side of the content when there's no title.
 * @param title title to be shown above the [content], currently the SnackBarHost doesn't handle it so avoid using it
 * @param actionLabel action to add as an action to the snackbar.
 * @param onActionClick callback when the action is clicked.
 * @param content content to show information about a process that an app has performed or will
 * perform
 */
@Deprecated(
    message = "Use Snackbar instead as we now support intents and changed the api for the icon for new specs",
    replaceWith = ReplaceWith(
        "Snackbar(intent = SnackbarIntent.Success, modifier = modifier, " +
            "actionOnNewLine = actionOnNewLine, actionLabel = actionLabel," +
            " onActionClick = onActionClick, content = content)",
        "com.adevinta.spark.components.snackbars.Snackbar",
    ),
    level = DeprecationLevel.ERROR,
)
@Composable
public fun SnackbarValid(
    modifier: Modifier = Modifier,
    actionOnNewLine: Boolean = false,
    icon: @Composable ((iconModifier: Modifier) -> Unit)? = null,
    title: String? = null,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    content: @Composable (() -> Unit),
) {
    Snackbar(
        intent = SnackbarIntent.Success,
        modifier = modifier,
        actionOnNewLine = actionOnNewLine,
//        icon = icon,
        actionLabel = actionLabel,
        onActionClick = onActionClick,
        content = content,
    )
}
