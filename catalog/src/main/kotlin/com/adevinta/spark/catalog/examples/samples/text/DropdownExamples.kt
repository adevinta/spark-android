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
package com.adevinta.spark.catalog.examples.samples.text

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.adevinta.spark.catalog.model.Example
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.menu.DropdownMenuGroupItem
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.Dropdown
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

private const val DropdownsExampleSourceUrl = "$SampleSourceUrl/DropdownExamples.kt"

private data class DropdownExampleGroup(val name: String, val books: ImmutableList<String>)

private val DropdownStubData = persistentListOf(
    DropdownExampleGroup("Best Sellers", persistentListOf("To Kill a Mockingbird", "War and Peace", "The Idiot")),
    DropdownExampleGroup("Novelties", persistentListOf("A Picture of Dorian Gray", "1984", "Pride and Prejudice")),
)

public val DropdownsExamples: List<Example> = listOf(
    Example(
        name = "Single selection",
        description = "Link inside title no icon",
        sourceUrl = DropdownsExampleSourceUrl,
    ) {
        val singleSelectionFilter by remember {
            mutableStateOf(DropdownStubData)
        }

        var singleSelected by remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        Dropdown(
            modifier = Modifier.fillMaxWidth(),
            value = singleSelected,
            label = "Book",
            placeholder = "Pick a Book",
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
            onDismissRequest = {
                expanded = false
            },
            dropdownContent = {
                singleSelectionFilter.forEach { group ->
                    DropdownMenuGroupItem(
                        title = {
                            Text(group.name)
                        }
                    ) {
                        group.books.forEach { book ->
                            DropdownMenuItem(
                                text = { Text(book) },
                                onClick = {
                                    singleSelected = book
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            },
        )
    },
)
