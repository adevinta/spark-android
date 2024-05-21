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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.R
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.buttons.BaseSparkButton
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.scaffold.Scaffold
import com.adevinta.spark.icons.Close
import com.adevinta.spark.icons.FlashlightFill
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tokens.contentColorFor
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import androidx.compose.material3.Snackbar as MaterialSnackBar

@Composable
@InternalSparkApi
public fun SparkSnackbar(
    colors: SnackbarIntent,
    style: SnackbarStyle,
    modifier: Modifier = Modifier,
    actionOnNewLine: Boolean = false,
    icon: SparkIcon? = null,
    actionLabel: String? = null,
    withDismissAction: Boolean = false,
    onActionClick: (() -> Unit)? = null,
    onDismissClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val color = if (style == SnackbarStyle.Filled) colors.filledColor else colors.outlinedColor
    val contentColor = contentColorFor(backgroundColor = color)

    val actionComposable: (@Composable () -> Unit)? = actionLabel?.let {
        @Composable {
            BaseSparkButton(
                colors = ButtonDefaults.textButtonColors(contentColor = contentColor),
                onClick = { onActionClick?.invoke() },
                elevation = null,
                content = { Text(it) },
            )
        }
    }

    val dismissActionComposable: (@Composable () -> Unit)? =
        if (withDismissAction) {
            @Composable {
                IconButton(
                    onClick = { onDismissClick?.invoke() },
                    content = {
                        Icon(
                            sparkIcon = SparkIcons.Close,
                            contentDescription = stringResource(R.string.spark_snackbar_dismiss_a11y),
                        )
                    },
                )
            }
        } else {
            null
        }

    MaterialSnackBar(
        modifier = modifier
            .padding(16.dp)
            .sparkUsageOverlay(),
        shape = SparkTheme.shapes.small,
        dismissAction = dismissActionComposable,
        actionOnNewLine = actionOnNewLine,
        containerColor = color,
        contentColor = contentColor,
        action = actionComposable,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            icon?.let {
                Icon(
                    sparkIcon = it,
                    contentDescription = null, // this is a decorative icon
                    modifier = Modifier.size(24.dp),
                )
            }
            content()
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
 * @param intent colors used for the background and the content defined in [SnackbarDefaults].
 * @param style style of the Snackbar defined in [SnackbarDefaults].
 * @param actionOnNewLine whether or not action should be put on the separate line. Recommended
 * for action with long action text
 * @param icon icon to be shown on the start side of the content when there's no title.
 * @param actionLabel action to add as an action to the snackbar.
 * @param onActionClick callback when the action is clicked.
 * @param onDismissClick action to add as an additional close affordance action
 * when a snackbar is non self-dismissive.
 * @param content content to show information about a process that an app has performed or will
 * perform
 */
@Composable
public fun Snackbar(
    modifier: Modifier = Modifier,
    intent: SnackbarIntent = SnackbarDefaults.intent,
    style: SnackbarStyle = SnackbarDefaults.style,
    actionOnNewLine: Boolean = false,
    icon: SparkIcon? = null,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    onDismissClick: (() -> Unit)? = null,
    content: @Composable (() -> Unit),
) {
    SparkSnackbar(
        colors = intent,
        style = style,
        modifier = modifier,
        actionOnNewLine = actionOnNewLine,
        icon = icon,
        actionLabel = actionLabel,
        onActionClick = onActionClick,
        onDismissClick = onDismissClick,
        content = content,
    )
}

/**
 * Snackbars provide brief messages about app processes at the bottom of the screen.
 *
 * Snackbars inform users of a process that an app has performed or will perform. They appear
 * temporarily, towards the bottom of the screen. They shouldn’t interrupt the user experience,
 * and they don’t require user input to disappear.
 *
 * A Snackbar can contain a single action. "Dismiss" or "cancel" actions are optional.
 *
 * Snackbars with an action should not timeout or self-dismiss until the user performs another
 * action. Here, moving the keyboard focus indicator to navigate through interactive elements in a
 * page is not considered an action.
 *
 * This version of snackbar is designed to work with [SnackbarData] provided by the
 * [SnackbarHost], which is usually used inside of the [Scaffold].
 *
 * This components provides only the visuals of the Snackbar. If you need to show a Snackbar
 * with defaults on the screen, use [SnackbarHostState.showSnackbar]:
 *
 * When a [SnackbarData.visuals] sets the Snackbar's duration as [SnackbarDuration.Indefinite], it's
 * recommended to display an additional close affordance action.
 * See [SnackbarVisuals.withDismissAction].
 *
 * @param data data about the current snackbar showing via [SnackbarHostState]
 * @param modifier the [Modifier] to be applied to this snackbar
 * @param actionOnNewLine whether or not action should be put on a separate line. Recommended for
 * action with long action text.
 */
@Composable
public fun Snackbar(
    data: SnackbarData,
    modifier: Modifier = Modifier,
    actionOnNewLine: Boolean = false,
) {
    val visuals = data.visuals
    val sparkVisuals = data.visuals as? SnackbarSparkVisuals

    SparkSnackbar(
        colors = sparkVisuals?.colors ?: SnackbarDefaults.intent,
        style = sparkVisuals?.style ?: SnackbarDefaults.style,
        modifier = modifier,
        actionOnNewLine = actionOnNewLine,
        icon = sparkVisuals?.icon,
        actionLabel = visuals.actionLabel,
        onActionClick = { data.performAction() },
        onDismissClick = { data.dismiss() },
    ) { Text(visuals.message) }
}

@Suppress("UnusedReceiverParameter") // Used as namespace
public val SnackbarDefaults.intent: SnackbarIntent
    get() = SnackbarIntent.Neutral

@Suppress("UnusedReceiverParameter") // Used as namespace
public val SnackbarDefaults.style: SnackbarStyle
    get() = SnackbarStyle.Filled

public class SnackbarSparkVisuals(
    override val message: String,
    public val icon: SparkIcon? = null,
    public val colors: SnackbarIntent = SnackbarDefaults.intent,
    public val style: SnackbarStyle = SnackbarDefaults.style,
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

@Preview
@Composable
private fun BodySnackbarPreview() {
    PreviewTheme {
        Snackbar {
            Text(StubBodyShort)
        }
    }
}

@Preview
@Composable
private fun BodyLongSnackbarPreview() {
    PreviewTheme {
        Snackbar {
            Text(StubBody, maxLines = 2)
        }
    }
}

@Preview
@Composable
private fun BodyActionSnackbarPreview() {
    PreviewTheme {
        Snackbar(
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
            icon = SparkIcons.FlashlightFill,
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
            icon = SparkIcons.FlashlightFill,
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
            actionOnNewLine = true,
            icon = SparkIcons.FlashlightFill,
            actionLabel = StubAction,
        ) {
            Text(StubBody)
        }
    }
}

@Preview
@Composable
private fun BodyIconActionNewLineLongSnackbarPreview() {
    PreviewTheme {
        Snackbar(
            actionOnNewLine = true,
            icon = SparkIcons.FlashlightFill,
            actionLabel = StubBodyLong,
        ) {
            Text(StubBody)
        }
    }
}
