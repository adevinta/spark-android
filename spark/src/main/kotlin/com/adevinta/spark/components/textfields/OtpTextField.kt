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
package com.adevinta.spark.components.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.spacer.HorizontalSpacer
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.tokens.dim1
import com.adevinta.spark.tools.modifiers.ifTrue
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

@Composable
public fun OtpTextField(
    value: String,
    modifier: Modifier = Modifier,
    pinCount: Int = 6,
    onTextChange: (String, filled: Boolean) -> Unit,
) {
    if (value.length > pinCount) {
        throw IllegalArgumentException("Otp text value must not have more than otpCount: $pinCount characters")
    }

    var fieldFocused by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier.onFocusChanged { fieldFocused = it.isFocused },
        value = TextFieldValue(value, selection = TextRange(value.length)),
        onValueChange = {
            if (it.text.length <= pinCount) {
                onTextChange(it.text, it.text.length == pinCount)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                repeat(pinCount) { index ->
                    val char = when {
                        index >= value.length -> null
                        else -> value[index].digitToIntOrNull()
                    }

                    val filled = value.length == pinCount

                    PinChar(
                        modifier = Modifier.defaultMinSize(minWidth = 40.dp, minHeight = 65.dp),
                        value = char,
                        focused = fieldFocused && (index == value.length) && !filled,
                    )

                    if (index + 1f == pinCount / 2f) {
                        HorizontalSpacer(8.dp)
                    }
                }
            }
        },
    )
}

@Composable
private fun PinChar(
    value: Int?,
    focused: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(SparkTheme.shapes.small)
            .background(SparkTheme.colors.neutralContainer)
            .ifTrue(focused) {
                Modifier.border(
                    2.dp,
                    SparkTheme.colors.outlineHigh,
                    SparkTheme.shapes.small,
                )
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = value?.toString() ?: "0",
            style = SparkTheme.typography.display2,
            color = SparkTheme.colors.onNeutral.apply { if (value == null) dim1 },
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(
    group = "TextFields",
    name = "OtpTextField",
)
@Composable
internal fun OtpTextFieldPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        var value by remember { mutableStateOf("12345") }

        OtpTextField(
            value = value,
            pinCount = 6,
            onTextChange = { text, _ -> value = text },
        )
    }
}
