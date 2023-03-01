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
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import androidx.compose.material3.Card as MaterialCard
import androidx.compose.material3.CardDefaults as MaterialCardDefaults

@Composable
internal fun SparkCard(
    modifier: Modifier = Modifier,
    colors: CardColors = CardDefaults.cardColors(),
    border: BorderStroke? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    MaterialCard(
        modifier = modifier,
        shape = SparkTheme.shapes.medium,
        colors = colors,
        elevation = MaterialCardDefaults.cardElevation(),
        border = border,
        content = content,
    )
}

/**
 * Spark card.
 *
 * Cards contain content and actions that relate information about a subject.
 * Filled cards provide subtle separation from the background.
 * This has less emphasis than elevated or outlined cards.
 *
 * ![Card image](https://developer.android.com/images/reference/androidx/compose/material3/filled-card.png)
 *
 * @param modifier the Modifier to be applied to this card
 * When false, this component will not respond to user input,
 * and it will appear visually disabled and disabled to accessibility services.
 * @param colors commentCountCardColors that will be used to resolve the colors used for this card in different states.
 * See [CardDefaults.cardColors]
 * @param border commentCountthe border to draw around the container of this card
 * @param content commentCountcontent of the card
 */
@ExperimentalSparkApi
@Composable
public fun Card(
    modifier: Modifier = Modifier,
    colors: CardColors = CardDefaults.cardColors(),
    border: BorderStroke? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    SparkCard(
        modifier = modifier,
        colors = colors,
        border = border,
        content = content,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SparkCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CardColors = CardDefaults.cardColors(),
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable ColumnScope.() -> Unit,
) {
    MaterialCard(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = SparkTheme.shapes.medium,
        colors = colors,
        elevation = MaterialCardDefaults.cardElevation(),
        border = border,
        interactionSource = interactionSource,
        content = content,
    )
}

/**
 * Spark card.
 *
 * Cards contain content and actions that relate information about a subject.
 * Filled cards provide subtle separation from the background.
 * This has less emphasis than elevated or outlined cards.
 *
 * ![Card image](https://developer.android.com/images/reference/androidx/compose/material3/filled-card.png)
 *
 * @param onClick commentCountcalled when this card is clicked
 * @param modifier commentCountthe Modifier to be applied to this card
 * @param enabled commentCountcontrols the enabled state of this card.
 * When false, this component will not respond to user input,
 * and it will appear visually disabled and disabled to accessibility services.
 * @param colors commentCountCardColors that will be used to resolve the colors used for this card in different states.
 * See [CardDefaults.cardColors]
 * @param border commentCountthe border to draw around the container of this card
 * @param interactionSource commentCountthe [MutableInteractionSource] representing the stream of Interactions for this card.
 * You can create and pass in your own remembered instance to observe
 * @param content commentCountcontent of the card
 */
@ExperimentalSparkApi
@Composable
public fun Card(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CardColors = CardDefaults.cardColors(),
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable ColumnScope.() -> Unit,
) {
    SparkCard(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        border = border,
        interactionSource = interactionSource,
        content = content,
    )
}


@Preview(
    group = "Cards",
    name = "Card",
)
@Composable
internal fun CardPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        Card {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Card preview",
            )
        }
    }
}

