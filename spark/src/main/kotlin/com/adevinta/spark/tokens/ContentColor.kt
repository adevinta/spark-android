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

package com.adevinta.spark.tokens

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

/**
 * This function is used to set the current value of [LocalContentColor] to onSurface. Any [Text], Icons, other
 * components included.
 *
 * This is the default emphasis applied in the whole theme.
 * This component's [content] will be styled with this a content color alpha that apply a medium emphasis which
 * is close to Black.
 */
@Composable
fun EmphasizeHigh(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalContentColor provides SparkTheme.colors.onSurface, content = content)
}

/**
 * This function is used to set the current value of [LocalContentColor] to onSurfaceVariant. Any [Text], Icons, other
 * components included in this component's [content] will be styled with this a content color alpha that apply a
 * medium emphasis which is close to Dark Gray.
 */
@Composable
fun EmphasizeMedium(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalContentColor provides SparkTheme.colors.onSurface.copy(alpha = .72f),
        content = content,
    )
}

/**
 * This function is used to set the current value of [LocalContentColor] to onSurface with a disabled apha.
 * Any [Text], Icons, other  components included in this component's [content] will be styled with this a content
 * color alpha that apply a disabled emphasis which is close to Gray or Light Gray.
 */
@Composable
fun EmphasizeDisable(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalContentColor provides SparkTheme.colors.onSurface.copy(alpha = DisabledAlpha),
        content = content,
    )
}

const val DisabledAlpha: Float = 0.38f

@Composable
@Preview(
    group = "Tokens",
    name = "Emphasis",
)
internal fun EmphasePreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        Text("Uses MaterialTheme's provided alpha")
        EmphasizeHigh {
            Text("This Text uses the high value")
        }
        EmphasizeMedium {
            Text("Medium value provided for LocalContentAlpha")
            Text("This Text also uses the medium value")
            EmphasizeDisable {
                Text("This Text uses the disabled alpha now")
            }
        }
    }
}
