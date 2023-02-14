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

package com.adevinta.spark.tools.modifiers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adevinta.spark.LocalHighlightComponents

/**
 * A [Modifier.Element] that adds a draw layer to identify brikke components easily.
 */
@Stable
internal fun Modifier.brikkeUsageOverlay(overlayColor: Color = Color.Red): Modifier = composed {
    this then if (LocalHighlightComponents.current) {
        Modifier.drawWithContent {
            drawContent()
            drawRect(color = overlayColor, alpha = 0.5f)
        }
    } else {
        Modifier
    }
}


/**
 * A Composable that hide its content and adds a draw dashed border to identify slot areas.
 */
@Composable
internal fun SlotArea(
    radius: Dp = 2.dp,
    color: Color = Color.Red,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .dashedBorder(1.dp, radius, color)
            .drawWithContent { /* hide the content */ },
        content = content,
    )
}
