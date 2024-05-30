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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButtonDefaults
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
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.buttons.BaseSparkButton
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.icons.IconButton
import com.adevinta.spark.components.icons.IconSize
import com.adevinta.spark.icons.Close
import com.adevinta.spark.icons.FlashlightFill
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tokens.contentColorFor
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import androidx.compose.material3.Snackbar as MaterialSnackBar

public val SnackbarDefaults.style: SnackbarStyle
    get() = SnackbarStyle.Tinted

public val SnackbarDefaults.intent: SnackbarIntent
    get() = SnackbarIntent.Neutral

@Composable
internal fun SparkSnackbar(
    intent: SnackbarIntent,
    style: SnackbarStyle,
    isActionOnNewLine: Boolean,
    isDismissIconEnabled: Boolean,
    modifier: Modifier = Modifier,
    icon: SparkIcon? = null,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    onDismissIconClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val backgroundColor = when (style) {
        SnackbarStyle.Filled -> intent.filledColor
        SnackbarStyle.Tinted -> intent.tintedColor
    }
    val contentColor = contentColorFor(backgroundColor = backgroundColor)

    MaterialSnackBar(
        modifier = modifier
            .padding(16.dp)
            .sparkUsageOverlay(),
        shape = SparkTheme.shapes.medium,
        actionOnNewLine = isActionOnNewLine,
        containerColor = backgroundColor,
        contentColor = contentColor,
        dismissAction = getDismissIconComposable(
            intent = intent,
            style = style,
            onClick = { onDismissIconClick?.invoke() },
            isDismissIconEnabled = isDismissIconEnabled,
        ),
        action = getActionComposable(
            intent = intent,
            onClick = { onActionClick?.invoke() },
            actionLabel = actionLabel,
            style = style,
            isActionOnNewLine = isActionOnNewLine,
        ),
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

@Composable
private fun getDismissIconComposable(
    intent: SnackbarIntent,
    style: SnackbarStyle,
    onClick: () -> Unit,
    isDismissIconEnabled: Boolean,
): @Composable() (() -> Unit)? {
    val dismissIconComposable: (@Composable () -> Unit)? = isDismissIconEnabled.takeIf { it }?.let {
        {
            val colors = IconButtonDefaults.iconButtonColors(
                contentColor = when (style) {
                    SnackbarStyle.Filled -> contentColorFor(backgroundColor = intent.filledColor)
                    SnackbarStyle.Tinted -> contentColorFor(backgroundColor = intent.tintedColor)
                },
            )
            IconButton(
                colors = colors,
                modifier = Modifier.padding(end = 8.dp),
                onClick = { onClick.invoke() },
            ) {
                Icon(
                    size = IconSize.Small,
                    sparkIcon = SparkIcons.Close,
                    contentDescription = null, // this is a decorative icon)
                )
            }
        }
    }
    return dismissIconComposable
}

@Composable
private fun getActionComposable(
    intent: SnackbarIntent,
    onClick: () -> Unit,
    style: SnackbarStyle,
    actionLabel: String? = null,
    isActionOnNewLine: Boolean = false,
): @Composable() (() -> Unit)? {
    val actionComposable: (@Composable () -> Unit)? = actionLabel?.let {
        {
            val colors = ButtonDefaults.textButtonColors(
                contentColor = when (style) {
                    SnackbarStyle.Filled -> contentColorFor(backgroundColor = intent.filledColor)
                    SnackbarStyle.Tinted -> contentColorFor(backgroundColor = intent.tintedColor)
                },
            )

            val buttonModifier = when {
                isActionOnNewLine -> Modifier
                    .fillMaxWidth(0.8f)
                    .wrapContentWidth(Alignment.End)

                else -> Modifier
            }

            BaseSparkButton(
                modifier = buttonModifier,
                colors = colors,
                onClick = { onClick.invoke() },
                elevation = null,
                content = { Text(actionLabel) },
            )
        }
    }

    return actionComposable
}

/**
 * Snackbar component with support for various styles and intents.
 *
 * @param intent The intent of the Snackbar.
 * @param style The style of the Snackbar.
 * @param isActionOnNewLine Whether the action is displayed on a new line.
 * @param isDismissIconEnabled Whether the dismiss icon is enabled.
 * @param modifier Modifier to apply to the Snackbar.
 * @param icon Optional icon to display in the Snackbar.
 * @param actionLabel Label for the action button.
 * @param onActionClick Callback for action button click.
 * @param onDismissIconClick Callback for dismiss icon click.
 * @param content Content to display inside the Snackbar.
 */
@Composable
public fun Snackbar(
    modifier: Modifier = Modifier,
    intent: SnackbarIntent = SnackbarDefaults.intent,
    style: SnackbarStyle = SnackbarDefaults.style,
    isActionOnNewLine: Boolean = false,
    isDismissIconEnabled: Boolean = false,
    icon: SparkIcon? = null,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    onDismissIconClick: (() -> Unit)? = null,
    content: @Composable (() -> Unit),
) {
    SparkSnackbar(
        intent = intent,
        style = style,
        modifier = modifier,
        isActionOnNewLine = isActionOnNewLine,
        isDismissIconEnabled = isDismissIconEnabled,
        icon = icon,
        actionLabel = actionLabel,
        onActionClick = onActionClick,
        onDismissIconClick = onDismissIconClick,
        content = content,
    )
}

/**
 * Snackbar component with support for various styles and intents.
 *
 * @param data The SnackbarData to display.
 * @param modifier Modifier to apply to the Snackbar.
 */
@Composable
public fun Snackbar(
    data: SnackbarData,
    modifier: Modifier = Modifier,
) {
    val visuals = data.visuals
    val sparkVisuals = data.visuals as? SnackbarSparkVisuals

    SparkSnackbar(
        intent = sparkVisuals?.intent ?: SnackbarDefaults.intent,
        style = sparkVisuals?.style ?: SnackbarDefaults.style,
        modifier = modifier,
        isActionOnNewLine = sparkVisuals?.isActionOnNewLine ?: false,
        isDismissIconEnabled = sparkVisuals?.isDismissIconEnabled ?: false,
        icon = sparkVisuals?.icon,
        actionLabel = visuals.actionLabel,
        onActionClick = { data.performAction() },
        onDismissIconClick = { data.dismiss() },
    ) { Text(visuals.message) }
}

/**
 * SnackBARVisuals interface that defines the visuals for a Snackbar.
 *
 * This is a convenience function for creating a Snackbar with a message and an action.
 * @param message The message to display in the Snackbar.
 * @param icon Optional icon to display in the Snackbar.
 * @param intent The intent of the Snackbar.
 * @param style The style of the Snackbar.
 * @param actionLabel Label for the action button.
 * @param isDismissIconEnabled Whether the dismiss icon is enabled.
 * @param duration The duration of the Snackbar.
 */
public class SnackbarSparkVisuals(
    override val message: String,
    public val icon: SparkIcon? = null,
    public val intent: SnackbarIntent = SnackbarDefaults.intent,
    public val style: SnackbarStyle = SnackbarDefaults.style,
    override val actionLabel: String? = null,
    public val isDismissIconEnabled: Boolean = false,
    public val isActionOnNewLine: Boolean = false,
    override val duration: SnackbarDuration = SnackbarDuration.Short,
) : SnackbarVisuals {
    override val withDismissAction: Boolean
        get() = isDismissIconEnabled
}

/***
 * Preview
 */
internal const val StubBodyShort = "Lorem ipsum dolor sit amet"
internal const val StubBody = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
internal const val StubBodyLong = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi lacus dolor, "
internal const val StubAction = "Action"

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
            style = SnackbarStyle.Filled,
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
            style = SnackbarStyle.Filled,
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
            intent = SnackbarIntent.Error,
            isDismissIconEnabled = true,
            icon = SparkIcons.FlashlightFill,
        ) {
            Text(StubBodyShort)
        }
    }
}

@Preview
@Composable
private fun BodyIconActionNewLineLongSnackbarPreview() {
    PreviewTheme {
        Snackbar(
            intent = SnackbarIntent.SurfaceInverse,
            isDismissIconEnabled = true,
            isActionOnNewLine = true,
            style = SnackbarStyle.Tinted,
            icon = SparkIcons.FlashlightFill,
            actionLabel = StubBodyLong,
        ) {
            Text(StubBody)
        }
    }
}
