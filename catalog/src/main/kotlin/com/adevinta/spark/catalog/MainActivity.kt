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
package com.adevinta.spark.catalog

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.core.view.WindowCompat
import com.adevinta.spark.catalog.datastore.theme.ThemePropertiesHandler
import com.adevinta.spark.catalog.datastore.theme.collectAsStateWithDefault
import com.adevinta.spark.catalog.model.Components
import com.adevinta.spark.catalog.showkase.ShowkaseBrowserScreenMetadata
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.airbnb.android.showkase.models.ShowkaseProvider
import kotlinx.coroutines.launch

public class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val coroutineScope = rememberCoroutineScope()
            val groupedComponentsList = getShowkaseProviderElements()
            val showkaseBrowserScreenMetadata = remember { mutableStateOf(ShowkaseBrowserScreenMetadata()) }
            val propertiesHandler = ThemePropertiesHandler(context = this@MainActivity)
            val theme by propertiesHandler
                .properties
                .collectAsStateWithDefault()

            if (groupedComponentsList.isNotEmpty()) {
                CatalogApp(
                    theme = theme,
                    components = Components,
                    groupedComponentMap = groupedComponentsList.groupBy { it.group },
                    showkaseBrowserScreenMetadata = showkaseBrowserScreenMetadata,
                    onThemeChange = {
                        coroutineScope.launch { propertiesHandler.updateProperties(it) }
                    },
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
