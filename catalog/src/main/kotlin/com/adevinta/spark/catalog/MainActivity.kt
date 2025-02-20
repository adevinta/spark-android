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

import android.app.assist.AssistContent
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyboardShortcutGroup
import android.view.KeyboardShortcutInfo
import android.view.Menu
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.adevinta.spark.catalog.datastore.theme.ThemePropertiesHandler
import com.adevinta.spark.catalog.datastore.theme.collectAsStateWithDefault
import com.adevinta.spark.catalog.model.Components
import com.adevinta.spark.catalog.ui.navigation.provideAssistContent
import kotlinx.coroutines.launch

public class MainActivity : AppCompatActivity() {

    internal var activeNavController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations, and go edge-to-edge
        // This also sets up the initial system bar style based on the platform theme
        enableEdgeToEdge()
        setContent {
            val coroutineScope = rememberCoroutineScope()
            val propertiesHandler = ThemePropertiesHandler(context = this@MainActivity)
            val theme by propertiesHandler
                .properties
                .collectAsStateWithDefault(this@MainActivity)

            CatalogApp(
                theme = theme,
                components = Components,
                onThemeChange = {
                    coroutineScope.launch {
                        propertiesHandler.updateProperties(it)
                    }
                },
            )
        }
    }

    override fun onProvideKeyboardShortcuts(
        data: MutableList<KeyboardShortcutGroup>?,
        menu: Menu?,
        deviceId: Int,
    ) {
        if (data != null) {
            val shortcutGroup = KeyboardShortcutGroup(
                "Stepper",
                listOf(
                    KeyboardShortcutInfo("Increase", KeyEvent.KEYCODE_DPAD_UP, KeyEvent.META_SHIFT_ON),
                    KeyboardShortcutInfo("Decrease", KeyEvent.KEYCODE_DPAD_DOWN, KeyEvent.META_SHIFT_ON),
                ),
            )
            data.add(shortcutGroup)
        }
    }

    override fun onProvideAssistContent(outContent: AssistContent) {
        super.onProvideAssistContent(outContent)
        activeNavController?.provideAssistContent(outContent = outContent)
    }
}
