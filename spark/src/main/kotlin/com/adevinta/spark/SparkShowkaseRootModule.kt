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
package com.adevinta.spark

import com.airbnb.android.showkase.annotation.ShowkaseRoot
import com.airbnb.android.showkase.annotation.ShowkaseRootModule

<<<<<<<< HEAD:spark/src/main/kotlin/com/adevinta/spark/SparkShowkaseRootModule.kt
/**
 * This class is needed by Showkase to find all composable components.
 * Be careful if you rename it, because it has to be modified in the intent used to display the demo app
 */
@ShowkaseRoot
internal class SparkShowkaseRootModule : ShowkaseRootModule
========
package com.adevinta.spark.catalog.examples.model

import androidx.compose.runtime.Composable
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.samples.components.ButtonSample

public data class Example(
    val name: String,
    val description: String,
    val sourceUrl: String,
    val content: @Composable () -> Unit,
)

private const val ButtonsExampleDescription = "Button examples"
private const val ButtonsExampleSourceUrl = "$SampleSourceUrl/ButtonSamples.kt"
public val ButtonsExamples: List<Example> = listOf(
    Example(
        name = ::ButtonSample.name,
        description = ButtonsExampleDescription,
        sourceUrl = ButtonsExampleSourceUrl,
    ) { ButtonSample() },
)
>>>>>>>> 4875638 (Update the ui to make it simpler to change the theming and test components):catalog/src/main/kotlin/com/adevinta/spark/catalog/examples/model/Example.kt
