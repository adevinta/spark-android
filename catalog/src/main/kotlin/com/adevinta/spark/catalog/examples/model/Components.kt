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
package com.adevinta.spark.catalog.examples.model

import com.adevinta.spark.catalog.examples.samples.buttons.ButtonsExamples
import com.adevinta.spark.catalog.util.ComponentGuidelinesUrl
import com.adevinta.spark.catalog.util.PackageSummaryUrl
import com.adevinta.spark.catalog.util.SparkSourceUrl

public data class Component(
    val id: Int,
    val name: String,
    val description: String,
    val tintIcon: Boolean = true,
    val guidelinesUrl: String,
    val docsUrl: String,
    val sourceUrl: String,
    val examples: List<Example>,
)

private var nextId: Int = 1
private fun nextId(): Int = nextId.also { nextId += 1 }

private val Buttons = Component(
    id = nextId(),
    name = "Buttons",
    description = "Buttons help people initiate actions, from sending an email, to sharing a " +
        "document, to liking a post.",
    // No buttons icon
    guidelinesUrl = "$ComponentGuidelinesUrl/buttons",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.buttons/-button-filled.html",
    sourceUrl = "$SparkSourceUrl/Button.kt",
    examples = ButtonsExamples,
)

/** Components for the catalog, ordered alphabetically by name. */
public val Components: List<Component> = listOf(
    Buttons,
)
