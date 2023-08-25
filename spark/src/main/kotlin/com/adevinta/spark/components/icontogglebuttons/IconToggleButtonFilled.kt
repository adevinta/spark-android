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
package com.adevinta.spark.components.icontogglebuttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.components.iconbuttons.IconButtonDefaults
import com.adevinta.spark.components.iconbuttons.IconButtonIntent
import com.adevinta.spark.components.iconbuttons.IconButtonPreview
import com.adevinta.spark.components.iconbuttons.IconButtonShape
import com.adevinta.spark.components.iconbuttons.IconButtonSize
import com.adevinta.spark.icons.FavoriteFill
import com.adevinta.spark.icons.FavoriteOutline
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

@ExperimentalSparkApi
@Composable
public fun IconToggleButtonFilled(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    icons: IconToggleButtonIcons,
    modifier: Modifier = Modifier,
    intent: IconButtonIntent = IconButtonDefaults.DefaultIntent,
    enabled: Boolean = true,
    shape: IconButtonShape = IconButtonDefaults.DefaultShape,
    size: IconButtonSize = IconButtonDefaults.DefaultSize,
    contentDescription: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val colors = IconButtonDefaults.filledIconButtonColors(intent.colors())
    SparkIconToggleButton(
        icons = icons,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        colors = colors,
        checked = checked,
        enabled = enabled,
        shape = shape,
        size = size,
        contentDescription = contentDescription,
        interactionSource = interactionSource,
    )
}

@Preview(
    group = "IconToggleButton",
    name = "IconToggleButtonFilled Small",
)
@Composable
internal fun IconToggleButtonFilledPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        var isChecked by remember { mutableStateOf(false) }

        IconButtonPreview { intent, shape ->
            IconToggleButtonFilled(
                intent = intent,
                checked = isChecked,
                icons = IconToggleButtonIcons(SparkIcons.FavoriteOutline, SparkIcons.FavoriteFill),
                onCheckedChange = { isChecked = !isChecked },
                size = IconButtonSize.Small,
                shape = shape,
            )
        }
    }
}
