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
package com.adevinta.spark.components.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import androidx.compose.material3.CardDefaults as MaterialCardDefaults
import androidx.compose.material3.OutlinedCard as MaterialOutlinedCard

@Composable
internal fun SparkOutlinedCard(
    modifier: Modifier = Modifier,
    colors: CardColors = CardDefaults.elevatedCardColors(),
    content: @Composable ColumnScope.() -> Unit,
) {
    MaterialOutlinedCard(
        modifier = modifier,
        shape = SparkTheme.shapes.medium,
        colors = colors,
        elevation = MaterialCardDefaults.elevatedCardElevation(),
        content = content,
    )
}

/**
 * <a href="https://m3.material.io/components/cards/overview" class="external" target="_blank">Material Design outlined card</a>.
 *
 * Outlined cards contain content and actions that relate information about a subject.
 * They have a visual boundary around the container.
 * This can provide greater emphasis than the other types.
 *
 * This OutlinedCard does not handle input events - see the other OutlinedCard overloads if you want
 * a clickable or selectable OutlinedCard.
 *
 * ![Outlined card image](https://developer.android.com/images/reference/androidx/compose/material3/outlined-card.png)
 *
 * @param modifier the [Modifier] to be applied to this card
 * @param colors [CardColors] that will be used to resolve the color(s) used for this card in
 * different states. See [CardDefaults.outlinedCardColors].
 * @param border the border to draw around the container of this card
 */
@Composable
public fun OutlinedCard(
    modifier: Modifier = Modifier,
    colors: CardColors = CardDefaults.outlinedCardColors(),
    border: BorderStroke = CardDefaults.outlinedCardBorder(),
    content: @Composable ColumnScope.() -> Unit,
) {
    MaterialOutlinedCard(
        modifier = modifier,
        shape = SparkTheme.shapes.medium,
        colors = colors,
        elevation = MaterialCardDefaults.cardElevation(),
        border = border,
        content = content,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SparkOutlinedCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CardColors = CardDefaults.outlinedCardColors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable ColumnScope.() -> Unit,
) {
    MaterialOutlinedCard(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = SparkTheme.shapes.medium,
        colors = colors,
        elevation = MaterialCardDefaults.elevatedCardElevation(),
        interactionSource = interactionSource,
        content = content,
    )
}

/**
 * <a href="https://m3.material.io/components/cards/overview" class="external" target="_blank">Material Design outlined card</a>.
 *
 * Outlined cards contain content and actions that relate information about a subject.
 * They have a visual boundary around the container.
 * This can provide greater emphasis than the other types.
 *
 * This OutlinedCard handles click events, calling its [onClick] lambda.
 *
 * ![Outlined card image](https://developer.android.com/images/reference/androidx/compose/material3/outlined-card.png)
 *
 * @param onClick called when this card is clicked
 * @param modifier the [Modifier] to be applied to this card
 * @param enabled controls the enabled state of this card. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param colors [CardColors] that will be used to resolve the color(s) used for this card in
 * different states. See [CardDefaults.outlinedCardColors].
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this card. You can create and pass in your own `remember`ed instance to observe
 * Interactions and customize the appearance / behavior of this card in different states.
 */
@ExperimentalMaterial3Api
@Composable
public fun OutlinedCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CardColors = CardDefaults.outlinedCardColors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable ColumnScope.() -> Unit,
) {
    SparkOutlinedCard(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        interactionSource = interactionSource,
        content = content,
    )
}

@Preview(
    group = "Cards",
    name = "OutlinedCard",
)
@Composable
internal fun OutlinedCardPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        OutlinedCard {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Card preview",
            )
        }
    }
}
