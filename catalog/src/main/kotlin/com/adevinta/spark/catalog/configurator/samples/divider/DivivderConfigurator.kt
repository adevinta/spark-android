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
package com.adevinta.spark.catalog.configurator.samples.divider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.themes.SegmentedButton
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.divider.DividerIntent
import com.adevinta.spark.components.divider.HorizontalDivider
import com.adevinta.spark.components.divider.LabelHorizontalAlignment
import com.adevinta.spark.components.divider.LabelVerticalAlignment
import com.adevinta.spark.components.divider.VerticalDivider
import com.adevinta.spark.components.spacer.VerticalSpacer
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.tokens.highlight

public val DividerConfigurator: Configurator = Configurator(
    name = "Divider",
    description = "Divider configuration",
    sourceUrl = "$SampleSourceUrl/DividerSamples.kt",
) {
    DividerSample()
}

@Preview(
    showBackground = true,
)
@Composable
private fun DividerSample() {
    Column {
        var intent by remember { mutableStateOf(DividerIntent.Outline) }
        var hLabelAlignments by remember { mutableStateOf(LabelHorizontalAlignment.Center) }
        var vLabelAlignments by remember { mutableStateOf(LabelVerticalAlignment.Center) }
        var labelText by remember { mutableStateOf("label") }

        Column {
            Text(
                text = "Divider Intent",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.highlight,
            )
            val dividerIntents = DividerIntent.entries.map(DividerIntent::name)
            SegmentedButton(
                options = dividerIntents,
                selectedOption = intent.name,
                onOptionSelect = { intent = DividerIntent.valueOf(it) },
                modifier = Modifier.fillMaxWidth(),
            )
        }
        VerticalSpacer(8.dp)

        Text(
            text = "HorizontalDivider",
            style = SparkTheme.typography.headline2,
        )

        HorizontalDivider(
            intent = intent,
            label = {
                Text(
                    textAlign = TextAlign.Center,
                    style = SparkTheme.typography.body1,
                    text = labelText,
                    modifier = Modifier.padding(horizontal = 16.dp),
                )
            },
            labelHorizontalAlignment = hLabelAlignments,
        )
        VerticalSpacer(8.dp)

        Text(
            text = "VerticalDivider",
            style = SparkTheme.typography.headline2,
        )

        VerticalDivider(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            intent = intent,
            label = {
                Text(
                    textAlign = TextAlign.Center,
                    style = SparkTheme.typography.body1,
                    text = labelText,
                    modifier = Modifier.padding(horizontal = 16.dp),
                )
            },
            labelVerticalAlignment = vLabelAlignments,
        )

        Column {
            Text(
                text = "HorizontalDivider Label Alignment",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.highlight,
            )
            val labelAlignments = LabelHorizontalAlignment.entries.map(LabelHorizontalAlignment::name)
            SegmentedButton(
                options = labelAlignments,
                selectedOption = hLabelAlignments.name,
                onOptionSelect = { hLabelAlignments = LabelHorizontalAlignment.valueOf(it) },
                modifier = Modifier.fillMaxWidth(),
            )
        }
        VerticalSpacer(8.dp)

        Column {
            Text(
                text = "VerticalDivider Label Alignment",
                modifier = Modifier.padding(bottom = 8.dp),
                style = SparkTheme.typography.body2.highlight,
            )
            val labelAlignments = LabelVerticalAlignment.entries.map(LabelVerticalAlignment::name)
            SegmentedButton(
                options = labelAlignments,
                selectedOption = vLabelAlignments.name,
                onOptionSelect = { vLabelAlignments = LabelVerticalAlignment.valueOf(it) },
                modifier = Modifier.fillMaxWidth(),
            )
        }

        VerticalSpacer(8.dp)

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = labelText,
            onValueChange = { labelText = it },
            label = "Change label",
            helper = "Divider label",
        )
    }
}
