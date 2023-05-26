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
package com.adevinta.spark.components.icons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tokens.contentColorFor
import com.adevinta.spark.tools.preview.SparkPreviewProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import com.adevinta.spark.tools.preview.UserType
import androidx.compose.material3.FilledIconToggleButton as MaterialFilledIconToggleButton
import androidx.compose.material3.FilledTonalIconToggleButton as MaterialFilledTonalIconToggleButton
import androidx.compose.material3.IconToggleButton as MaterialIconToggleButton
import androidx.compose.material3.OutlinedIconToggleButton as MaterialOutlinedIconToggleButton

/**
 * <a href="https://m3.material.io/components/icon-button/overview" class="external" target="_blank">Material Design standard icon toggle button</a>.
 *
 * Icon buttons help people take supplementary actions with a single tap. They’re used when a
 * compact button is required, such as in a toolbar or image list.
 *
 * ![Standard icon toggle button image](https://developer.android.com/images/reference/androidx/compose/material3/standard-icon-toggle-button.png)
 *
 * [content] should typically be an [Icon] (see [androidx.compose.material.icons.Icons]). If using a
 * custom icon, note that the typical size for the internal icon is 24 x 24 dp.
 * This icon button has an overall minimum touch target size of 48 x 48dp, to meet accessibility
 * guidelines.
 *
 * @sample androidx.compose.material3.samples.IconToggleButtonSample
 *
 * @param checked whether this icon button is toggled on or off
 * @param onCheckedChange called when this icon button is clicked
 * @param modifier the [Modifier] to be applied to this icon button
 * @param enabled controls the enabled state of this icon button. When `false`, this component will
 * not respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param colors [IconToggleButtonColors] that will be used to resolve the colors used for this icon
 * button in different states. See [IconButtonDefaults.iconToggleButtonColors].
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this icon button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this icon button in different states.
 * @param content the content of this icon button, typically an [Icon]
 */
@Composable
public fun IconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: IconToggleButtonColors = IconButtonDefaults.iconToggleButtonColors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit,
) {
    MaterialIconToggleButton(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        interactionSource = interactionSource,
        content = content,
    )
}

/**
 * <a href="https://m3.material.io/components/icon-button/overview" class="external" target="_blank">Material Design filled icon toggle button</a>.
 *
 * Icon buttons help people take supplementary actions with a single tap. They’re used when a
 * compact button is required, such as in a toolbar or image list.
 *
 * ![Filled icon toggle button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-icon-toggle-button.png)
 *
 * [content] should typically be an [Icon] (see [androidx.compose.material.icons.Icons]). If using a
 * custom icon, note that the typical size for the internal icon is 24 x 24 dp.
 * This icon button has an overall minimum touch target size of 48 x 48dp, to meet accessibility
 * guidelines.
 *
 * Toggleable filled icon button sample:
 * @sample androidx.compose.material3.samples.FilledIconToggleButtonSample
 *
 * @param checked whether this icon button is toggled on or off
 * @param onCheckedChange called when this icon button is clicked
 * @param modifier the [Modifier] to be applied to this icon button
 * @param enabled controls the enabled state of this icon button. When `false`, this component will
 * not respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param shape defines the shape of this icon button's container
 * @param colors [IconToggleButtonColors] that will be used to resolve the colors used for this icon
 * button in different states. See [IconButtonDefaults.filledIconToggleButtonColors].
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this icon button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this icon button in different states.
 * @param content the content of this icon button, typically an [Icon]
 */
@ExperimentalSparkApi
@Composable
public fun FilledIconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = SparkTheme.shapes.full,
    colors: IconToggleButtonColors = IconButtonDefaults.filledIconToggleButtonColors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit,
) {
    MaterialFilledIconToggleButton(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        interactionSource = interactionSource,
        content = content,
    )
}

/**
 * <a href="https://m3.material.io/components/icon-button/overview" class="external" target="_blank">Material Design filled tonal icon toggle button</a>.
 *
 * Icon buttons help people take supplementary actions with a single tap. They’re used when a
 * compact button is required, such as in a toolbar or image list.
 *
 * ![Filled tonal icon toggle button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-icon-toggle-button.png)
 *
 * A filled tonal toggle icon button is a medium-emphasis icon button that is an alternative
 * middle ground between the default [FilledIconToggleButton] and [OutlinedIconToggleButton].
 * They can be used in contexts where the lower-priority icon button requires slightly more emphasis
 * than an outline would give.
 *
 * [content] should typically be an [Icon] (see [androidx.compose.material.icons.Icons]). If using a
 * custom icon, note that the typical size for the internal icon is 24 x 24 dp.
 * This icon button has an overall minimum touch target size of 48 x 48dp, to meet accessibility
 * guidelines.
 *
 * Toggleable filled tonal icon button sample:
 * @sample androidx.compose.material3.samples.FilledTonalIconToggleButtonSample
 *
 * @param checked whether this icon button is toggled on or off
 * @param onCheckedChange called when this icon button is clicked
 * @param modifier the [Modifier] to be applied to this icon button
 * @param enabled controls the enabled state of this icon button. When `false`, this component will
 * not respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param shape defines the shape of this icon button's container
 * @param colors [IconToggleButtonColors] that will be used to resolve the colors used for this icon
 * button in different states. See [IconButtonDefaults.filledIconToggleButtonColors].
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this icon button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this icon button in different states.
 * @param content the content of this icon button, typically an [Icon]
 */
@ExperimentalSparkApi
@Composable
public fun FilledTonalIconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = SparkTheme.shapes.full,
    colors: IconToggleButtonColors = IconButtonDefaults.filledTonalIconToggleButtonColors(
        checkedContainerColor = SparkTheme.colors.primaryContainer,
        checkedContentColor = contentColorFor(backgroundColor = SparkTheme.colors.primaryContainer),
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit,
) {
    MaterialFilledTonalIconToggleButton(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        interactionSource = interactionSource,
        content = content,
    )
}

/**
 * <a href="https://m3.material.io/components/icon-button/overview" class="external" target="_blank">Material Design outlined icon toggle button</a>.
 *
 * Icon buttons help people take supplementary actions with a single tap. They’re used when a
 * compact button is required, such as in a toolbar or image list.
 *
 * ![Outlined icon toggle button image](https://developer.android.com/images/reference/androidx/compose/material3/outlined-icon-toggle-button.png)
 *
 * [content] should typically be an [Icon] (see [androidx.compose.material.icons.Icons]). If using a
 * custom icon, note that the typical size for the internal icon is 24 x 24 dp.
 * This icon button has an overall minimum touch target size of 48 x 48dp, to meet accessibility
 * guidelines.
 *
 * @sample androidx.compose.material3.samples.OutlinedIconToggleButtonSample
 *
 * @param checked whether this icon button is toggled on or off
 * @param onCheckedChange called when this icon button is clicked
 * @param modifier the [Modifier] to be applied to this icon button
 * @param enabled controls the enabled state of this icon button. When `false`, this component will
 * not respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param shape defines the shape of this icon button's container and border (when [border] is not
 * null)
 * @param colors [IconToggleButtonColors] that will be used to resolve the colors used for this icon
 * button in different states. See [IconButtonDefaults.outlinedIconToggleButtonColors].
 * @param border the border to draw around the container of this icon button. Pass `null` for no
 * border. See [IconButtonDefaults.outlinedIconToggleButtonBorder].
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this icon button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this icon button in different states.
 * @param content the content of this icon button, typically an [Icon]
 */
@ExperimentalSparkApi
@Composable
public fun OutlinedIconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = SparkTheme.shapes.full,
    colors: IconToggleButtonColors = IconButtonDefaults.outlinedIconToggleButtonColors(),
    border: BorderStroke? = IconButtonDefaults.outlinedIconToggleButtonBorder(enabled, checked),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit,
) {
    MaterialOutlinedIconToggleButton(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        border = border,
        interactionSource = interactionSource,
        content = content,
    )
}

@Preview(
    group = "Icons",
    name = "IconToggleButtons",
)
@Composable
internal fun IconToggleButtonPreview(
    @PreviewParameter(SparkPreviewProvider::class) param: Pair<ThemeVariant, UserType>,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        Text("IconButton")
        Row {
            IconToggleButton(checked = false, onCheckedChange = { }) {
                ToggledIcon(false)
            }
            IconToggleButton(checked = true, onCheckedChange = { }) {
                ToggledIcon(true)
            }
        }

        Text("FilledIconButton")
        Row {
            FilledIconToggleButton(checked = false, onCheckedChange = { }) {
                ToggledIcon(false)
            }
            FilledIconToggleButton(checked = true, onCheckedChange = { }) {
                ToggledIcon(true)
            }
        }

        Text("FilledTonalIconButton")
        Row {
            FilledTonalIconToggleButton(checked = false, onCheckedChange = { }) {
                ToggledIcon(false)
            }
            FilledTonalIconToggleButton(checked = true, onCheckedChange = { }) {
                ToggledIcon(true)
            }
        }

        Text("OutlinedIconButton")
        Row {
            OutlinedIconToggleButton(checked = false, onCheckedChange = { }) {
                ToggledIcon(false)
            }
            OutlinedIconToggleButton(checked = true, onCheckedChange = { }) {
                ToggledIcon(true)
            }
        }
    }
}

@Composable
private fun ToggledIcon(checked: Boolean) {
    val icon = SparkIcon.Actions.Wheel.Outlined
    val selectedIcon = SparkIcon.Actions.Wheel.Default
    val contentDescription = "Localized description"
    if (checked) {
        Icon(selectedIcon, contentDescription = contentDescription)
    } else {
        Icon(icon, contentDescription = contentDescription)
    }
}
