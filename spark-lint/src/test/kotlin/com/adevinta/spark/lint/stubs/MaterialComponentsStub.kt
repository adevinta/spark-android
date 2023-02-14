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

package com.adevinta.spark.lint.stubs

import com.android.tools.lint.checks.infrastructure.TestFiles.kotlin

// Simplified Material.kt stubs
internal val MaterialComponentsStub = kotlin(
    """
    package androidx.compose.material3
    import androidx.compose.runtime.Composable
    
    @Composable
    fun Button() {}
    
    @Composable
    fun OutlinedButton() {}
    
    @Composable
    fun ElevatedButton() {}
    
    @Composable
    fun FilledTonalButton() {}
    
    @Composable
    fun TextButton() {}
    
    @Composable
    fun OutlinedTextField() {}
    
    @Composable
    fun FilledTextField() {}
    
    @Composable
    fun CheckBox() {}
    
    @Composable
    fun TriStateCheckbox() {}
    
    @Composable
    fun RadioButton() {}
    
    @Composable
    fun Switch() {}
    
    @Composable
    fun Snackbar() {}
    
    @Composable
    fun LinearProgressIndicator() {}
    
    @Composable
    fun CircularProgressIndicator() {}
    
    @Composable
    fun MaterialTheme() {}
""".trimIndent()
)
