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
package com.adevinta.spark.textfields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import app.cash.paparazzi.Paparazzi
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.components.textfields.TextFieldState
import com.adevinta.spark.icons.Check
import com.adevinta.spark.icons.EyeOffFill
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.sparkSnapshot
import com.android.ide.common.rendering.api.SessionParams
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
internal class TextFieldScreenshot(
    private val value: String?,
    private val trailingIcon: SparkIcon?,
    private val leadingIcon: SparkIcon?,
    private val enabled: Boolean,
    private val helper: String?,
) {

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = .01, // We can have in some cases 2/3 pixels being different for no apparent reasons :(
        theme = "android:Theme.MaterialComponent.Light.NoActionBar",
        renderingMode = SessionParams.RenderingMode.SHRINK,
        showSystemUi = false,
    )

    @Test
    fun test() {
        paparazzi.sparkSnapshot(
            name = "_value[${value?.count()}]" +
                "_leadingIcon[${leadingIcon != null}]" +
                "_trailingIcon[${trailingIcon != null}]" +
                "_enabled[$enabled]" +
                "_helper[${helper?.count()}]",
        ) {
            val leadingContent: (@Composable () -> Unit)? = leadingIcon?.let {
                @Composable {
                    Icon(it, contentDescription = null)
                }
            }
            val trailingContent: (@Composable () -> Unit)? = trailingIcon?.let {
                @Composable {
                    Icon(it, contentDescription = null)
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                TextField(
                    value = value.orEmpty(),
                    onValueChange = {},
                    label = "Label",
                    leadingContent = leadingContent,
                    trailingContent = trailingContent,
                    required = true,
                    enabled = enabled,
                    stateMessage = "short state message for textfield",
                    helper = helper,
                )
                TextField(
                    value = value.orEmpty(),
                    onValueChange = {},
                    label = "Label",
                    leadingContent = leadingContent,
                    trailingContent = trailingContent,
                    state = TextFieldState.Error,
                    required = true,
                    enabled = enabled,
                    stateMessage = "short state message for textfield",
                    helper = helper,
                )
                TextField(
                    value = value.orEmpty(),
                    onValueChange = {},
                    label = "Label",
                    leadingContent = leadingContent,
                    trailingContent = trailingContent,
                    state = TextFieldState.Alert,
                    required = true,
                    enabled = enabled,
                    stateMessage = "short state message for textfield",
                    helper = helper,
                )
                TextField(
                    value = value.orEmpty(),
                    onValueChange = {},
                    label = "Label",
                    leadingContent = leadingContent,
                    trailingContent = trailingContent,
                    state = TextFieldState.Success,
                    required = true,
                    enabled = enabled,
                    stateMessage = "short state message for textfield",
                    helper = helper,
                )
            }
        }
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        internal fun params() = parameterizedParams().combineWithParameters(
            // Value
            "",
            stubShortBody,
            stubBody,
        ).combineWithParameters(
            SparkIcons.Check,
            null,
        ).combineWithParameters(
            SparkIcons.EyeOffFill,
            null,
        ).combineWithParameters(
            // Enabled
            false,
            true,
        ).combineWithParameters(
            // Helper
            null,
            stubBody,
        )

        private const val stubShortBody = "Lorem ipsum"
        private const val stubBody = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi lacus dolor, " +
            "pulvinar eu nulla sit amet, iaculis interdum."
    }
}

internal fun parameterizedParams(): List<Array<Any?>> = emptyList()

internal inline fun <reified T : Any?> List<Array<T>>.combineWithParameters(
    vararg values: T,
): List<Array<T>> {
    if (isEmpty()) {
        return values.map { arrayOf(it) }
    }

    return fold(emptyList()) { acc, args ->
        val result = acc.toMutableList()
        values.forEach { v ->
            result += ArrayList<T>().apply {
                addAll(args)
                add(v)
            }.toTypedArray()
        }
        result.toList()
    }
}
