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
package com.adevinta.spark.catalog.datastore.buttonconfigurator

import androidx.core.content.res.ResourcesCompat
import com.adevinta.spark.catalog.configurator.samples.buttons.ButtonStyle
import com.adevinta.spark.components.buttons.ButtonIntent
import com.adevinta.spark.components.buttons.ButtonSize
import com.adevinta.spark.components.buttons.IconSide
import kotlinx.serialization.Serializable

@Serializable
internal data class ButtonsConfiguratorProperties(
    val isEnabled: Boolean,
    val isLoading: Boolean,
    val iconSide: IconSide,
    val intent: ButtonIntent,
    val size: ButtonSize,
    val style: ButtonStyle,
    val iconId: Int,
) {
    companion object {
        val DEFAULT = ButtonsConfiguratorProperties(
            isEnabled = true,
            isLoading = false,
            size = ButtonSize.Medium,
            iconSide = IconSide.START,
            intent = ButtonIntent.Main,
            style = ButtonStyle.Filled,
            iconId = ResourcesCompat.ID_NULL,
        )
    }
}
