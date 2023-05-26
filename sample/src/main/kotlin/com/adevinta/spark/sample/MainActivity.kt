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
package com.adevinta.spark.sample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.core.view.WindowCompat
import com.adevinta.spark.sample.themes.Theme
import com.adevinta.spark.sample.themes.ThemeSaver
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.airbnb.android.showkase.models.ShowkaseProvider

public class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val groupedComponentsList = getShowkaseProviderElements()
            val showkaseBrowserScreenMetadata = remember { mutableStateOf(ShowkaseBrowserScreenMetadata()) }
            var theme by rememberSaveable(stateSaver = ThemeSaver) { mutableStateOf(Theme()) }

            if (groupedComponentsList.isNotEmpty()) {
                ShowkaseBrowserApp(
                    theme = theme,
                    groupedComponentMap = groupedComponentsList.groupBy { it.group },
                    showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
                    onThemeChange = { theme = it },
                )
            }
        }
    }

    private fun getShowkaseProviderElements(): List<ShowkaseBrowserComponent> = try {
        val showkaseComponentProvider =
            Class.forName("com.adevinta.spark.SparkShowkaseRootModuleCodegen").newInstance()

        val showkaseMetadata = (showkaseComponentProvider as ShowkaseProvider).metadata()

        showkaseMetadata.componentList
    } catch (exception: ClassNotFoundException) {
        emptyList()
    }
}
