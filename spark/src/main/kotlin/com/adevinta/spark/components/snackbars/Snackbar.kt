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

package com.adevinta.spark.components.snackbars

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.buttons.SparkButton
import com.adevinta.spark.components.buttons.SparkButtonDefaults
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tokens.contentColorFor
import com.adevinta.spark.tools.modifiers.SlotArea
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import androidx.compose.material3.Snackbar as MaterialSnackBar

@Composable
@InternalSparkApi
public fun SparkSnackbar(
    colors: SnackbarColors,
    modifier: Modifier = Modifier,
    actionOnNewLine: Boolean = false,
    icon: @Composable() ((iconModifier: Modifier) -> Unit)? = null,
    title: String? = null,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {

    val contentColor = contentColorFor(backgroundColor = colors.baseColor)

    val actionComposable: (@Composable () -> Unit)? = actionLabel?.let {
        @Composable {
            SparkButton(
                colors = ButtonDefaults.textButtonColors(contentColor = contentColor),
                onClick = { onActionClick?.invoke() },
                elevation = null,
                contentPadding = SparkButtonDefaults.TextButtonContentPadding,
                content = { Text(it) },
            )
        }
    }

    val titleComposable: (@Composable () -> Unit)? = title?.let {
        @Composable {
            Text(
                text = it,
                maxLines = 2,
            )
        }
    }

    MaterialSnackBar(
        modifier = modifier
            .padding(16.dp)
            .sparkUsageOverlay(),
        shape = SparkTheme.shapes.extraSmall,
        actionOnNewLine = actionOnNewLine,
        containerColor = colors.baseColor,
        contentColor = contentColor,
        action = actionComposable,
    ) {
        Column {
            ProvideTextStyle(value = SparkTheme.typography.bodyImportant) {
                titleComposable?.invoke()
                Spacer(Modifier.height(4.dp))
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (title == null) {
                    icon?.let {
                        it(Modifier.size(24.dp))
                        Spacer(Modifier.width(16.dp))
                    }
                }

                content()
            }
        }
    }
}

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
 * @param modifier modifiers for the Snackbar layout
 * @param colors colors used for the background and the content defined in [SnackbarDefaults], can either be
 * default, error or valid.
 * @param actionOnNewLine whether or not action should be put on the separate line. Recommended
 * for action with long action text
 * @param icon icon to be shown on the start side of the content when there's no title.
 * @param title title to be shown above the [content], currently the SnackBarHost doesn't handle it so avoid using it
 * @param actionLabel action to add as an action to the snackbar.
 * @param onActionClick callback when the action is clicked.
 * @param content content to show information about a process that an app has performed or will
 * perform
 */
@Composable
public fun Snackbar(
    modifier: Modifier = Modifier,
    colors: SnackbarColors = SnackbarColors.Default,
    actionOnNewLine: Boolean = false,
    icon: @Composable ((iconModifier: Modifier) -> Unit)? = null,
    title: String? = null,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    content: @Composable (() -> Unit),
) {

    SparkSnackbar(
        colors = colors,
        modifier = modifier,
        actionOnNewLine = actionOnNewLine,
        icon = icon,
        title = title,
        actionLabel = actionLabel,
        onActionClick = onActionClick,
        content = content,
    )
}

@Composable
public fun Snackbar(
    data: SnackbarData,
    modifier: Modifier = Modifier,
    colors: SnackbarColors = SnackbarColors.Default,
    actionOnNewLine: Boolean = false,
) {
    val visuals = data.visuals
    val brikkeVisuals = data.visuals as? SnackbarSparkVisuals

    val iconComposable: (@Composable (iconModifier: Modifier) -> Unit)? = brikkeVisuals?.icon?.let { icon ->
        @Composable {
            Icon(icon, modifier = it, contentDescription = null)
        }
    }

    SparkSnackbar(
        colors = colors,
        modifier = modifier,
        actionOnNewLine = actionOnNewLine,
        icon = iconComposable,
        title = brikkeVisuals?.title,
        actionLabel = visuals.actionLabel,
        onActionClick = { data.performAction() },
    ) { Text(visuals.message) }
}

public class SnackbarSparkVisuals(
    override val message: String,
    public val title: String? = null,
    public val icon: SparkIcon? = null,
    public val colors: SnackbarColors = SnackbarColors.Default,
    override val actionLabel: String? = null,
    override val withDismissAction: Boolean = false,
    override val duration: SnackbarDuration = SnackbarDuration.Short,
) : SnackbarVisuals

private const val StubTitle = "Title"
private const val StubBodyShort = "Lorem ipsum dolor sit amet"
private const val StubBody = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi lacus dolorsnx -d"
private const val StubBodyLong = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi lacus dolor, " +
        "pulvinar eu nulla sit amet, iaculis interdum."
private const val StubAction = "Action"


@Preview(
    group = "Snackbar",
    name = "Snackbar",
)
@Composable
private fun SnackbarPreview() {
    PreviewTheme {
        SparkSnackbar(
            colors = SnackbarColors.Default,
            icon = { iconModifier ->
                SlotArea(
                    color = LocalContentColor.current,
                ) {
                    Icon(SparkIcon.Options.Flash, contentDescription = null, modifier = iconModifier)
                }
            },
            actionLabel = StubAction,
        ) {
            SlotArea(color = LocalContentColor.current) {
                Text(StubBodyShort)
            }
        }
    }
}

@Preview
@Composable
private fun BodySnackbarPreview() {
    PreviewTheme {
        Snackbar(colors = SnackbarColors.Default) {
            Text(StubBodyShort)
        }
    }
}

@Preview
@Composable
private fun BodyLongSnackbarPreview() {
    PreviewTheme {
        Snackbar(colors = SnackbarColors.Default) {
            Text(StubBody, maxLines = 2)
        }
    }
}


@Preview
@Composable
private fun BodyActionSnackbarPreview() {
    PreviewTheme {
        Snackbar(
            colors = SnackbarColors.Default,
            actionLabel = StubAction,
        ) {
            Text(StubBodyShort)
        }
    }
}

@Preview
@Composable
private fun BodyIconActionSnackbarPreview() {
    PreviewTheme {
        Snackbar(
            colors = SnackbarColors.Default,
            icon = { iconModifier ->
                Icon(SparkIcon.Options.Flash, contentDescription = null, modifier = iconModifier)
            },
            actionLabel = StubAction,
        ) {
            Text(StubBodyShort)
        }
    }
}


@Preview
@Composable
private fun BodyIconSnackbarPreview() {
    PreviewTheme {
        Snackbar(
            colors = SnackbarColors.Default,
            icon = { iconModifier ->
                Icon(SparkIcon.Options.Flash, contentDescription = null, modifier = iconModifier)
            },
        ) {
            Text(StubBodyShort)
        }
    }
}


@Preview
@Composable
private fun BodyIconActionNewLineSnackbarPreview() {
    PreviewTheme {
        Snackbar(
            colors = SnackbarColors.Default,
            actionOnNewLine = true,
            icon = { iconModifier ->
                Icon(SparkIcon.Options.Flash, contentDescription = null, modifier = iconModifier)
            },
            actionLabel = StubAction,
        ) {
            Text(StubBody)
        }
    }
}


@Preview
@Composable
private fun BodyTitleSnackbarPreview() {
    PreviewTheme {
        Snackbar(
            colors = SnackbarColors.Default,
            icon = { iconModifier ->
                Icon(SparkIcon.Options.Flash, contentDescription = null, modifier = iconModifier)
            },
            title = StubTitle,
        ) {
            Text(StubBodyShort)
        }
    }
}

@Preview
@Composable
private fun BodyLongTitleSnackbarPreview() {
    PreviewTheme {
        Snackbar(
            colors = SnackbarColors.Default,
            icon = { iconModifier ->
                Icon(SparkIcon.Options.Flash, contentDescription = null, modifier = iconModifier)
            },
            title = StubTitle,
        ) {
            Text(StubBody + StubBody)
        }
    }
}


@Preview
@Composable
private fun BodyTitleActionSnackbarPreview() {
    PreviewTheme {
        Snackbar(
            colors = SnackbarColors.Default,
            actionOnNewLine = true,
            icon = { iconModifier ->
                Icon(SparkIcon.Options.Flash, contentDescription = null, modifier = iconModifier)
            },
            title = StubTitle,
            actionLabel = StubAction,
        ) {
            Text(StubBodyShort)
        }
    }
}

