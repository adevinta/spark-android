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

import androidx.compose.runtime.Composable
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
import com.android.internal.R.attr.theme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
internal class TextFieldScreenshot(
//    private val theme: ThemeVariant,
    private val leadingIcon: SparkIcon?,
    private val trailingIcon: SparkIcon?,
    private val value: String?,
    private val state: TextFieldState?,
    private val enabled: Boolean,
    private val readOnly: Boolean,
    private val required: Boolean,
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
    fun TextFieldTest() {
        paparazzi.sparkSnapshot(
            name = "_leadingIcon[${leadingIcon != null}]" +
                "_trailingIcon[${trailingIcon != null}]" +
                "_value[${value?.count()}]" +
                "_state[${state?.name ?: "basic"}]" +
                "_required[$required]" +
                "_enabled[$enabled]" +
                "_readOnly[$readOnly]" +
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
            TextField(
                value = value.orEmpty(),
                onValueChange = {},
                label = "Label",
                leadingContent = leadingContent,
                trailingContent = trailingContent,
                state = state,
                required = required,
                enabled = enabled,
                readOnly = readOnly,
                stateMessage = "short state message for textfield",
                helper = helper,
            )
        }
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        internal fun params() = parameterizedParams()/*.combineWithParameters(
            ThemeVariant.Light,
            ThemeVariant.Dark,
        )*/.combineWithParameters(
            SparkIcons.Check,
            null,
        ).combineWithParameters(

            SparkIcons.EyeOffFill,
            null,
        ).combineWithParameters(
            // Value
            "",
            stubShortBody,
            stubBody,
        ).combineWithParameters(
            // State
            null,
            TextFieldState.Success,
            TextFieldState.Alert,
            TextFieldState.Error,
        ).combineWithParameters(
            // Enabled
            false,
            true,
        ).combineWithParameters(
            // ReadOnly
            false,
            true,
        ).combineWithParameters(
            // Required
            false,
            true,
        ).combineWithParameters(
            // Value
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
