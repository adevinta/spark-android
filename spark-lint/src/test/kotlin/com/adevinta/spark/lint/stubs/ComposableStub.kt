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

import com.android.tools.lint.checks.infrastructure.TestFile

// If you need to update these values, check the following docs first:
// https://github.com/androidx/androidx/blob/androidx-main/docs/lint_guide.md#updating-bytecode-and-checksum-in-tests-tips-bytecode

val Composable: TestFile = bytecodeStub(
    filename = "Composable.kt",
    filepath = "androidx/compose/runtime",
    checksum = 0x497e6ba7,
    source = """
        package androidx.compose.runtime
        @MustBeDocumented
        @Retention(AnnotationRetention.BINARY)
        @Target(
            AnnotationTarget.FUNCTION,
            AnnotationTarget.TYPE,
            AnnotationTarget.TYPE_PARAMETER,
            AnnotationTarget.PROPERTY_GETTER
        )
        annotation class Composable
        """.trimIndent(),
    """
        META-INF/main.kotlin_module:
        H4sIAAAAAAAA/2NgYGBmYGBgBGIOBijgUuWSTsxLKcrPTKnQS87PLcgvTtVL
        yy/NS0ksyczPE2ILSS0u8S7h4uViTsvPh3GVGLQYANHGQaFOAAAA
        
    """.trimIndent(),
    """
        androidx/compose/runtime/Composable.class:
        H4sIAAAAAAAA/41SS2/aQBD+1kCgtE2gT0ia5k36kOo06q0nIE5riYdlnEqI
        Q7TBq8jB2BFeaHLjUKn/qYcK9dgfVXUWVKCSpVaWvp2d+WZnvvH8/PXtO4B3
        eM2wxwN3EHrujd4N+9dhJPTBMJBeX+jV6Z1f+CINxpC74iOu+zy41JsXV6Ir
        00gwbC28PAhCyaUXBnp5bqaRYtiv9ULpe8EypT6MZEWchN1hXwRSuO8ZNmNo
        tpAUJoviqRH3h4LhMIa3qLicsVIxG2W7zbAek+LwwaWQxFrlvh9+Fu7MEcX3
        uygwz8ucnjWqjtlsMCSdtmXQS+o4t8p2uW44hs2wZtlNy7Cd9vkHw5l6dmqx
        E/trENvxnGVlpX9QrND3urdqaNVaudVSw41NmIvZjY8bvlBtObfXQs2TZH1s
        npD0qdCzFmnO/xlWXUjucsmJp/VHCVowpiCjAAysR/4bT92OyHLfMhQn40xW
        K2hZLbeR+fFVK0zGx9oRq0zGinDMcFD7j+2kevT8/YXjTU8yZFvhcNAVp55P
        G1O0Z1mfvMgjwuJfRiWqhCTlr6guyX45xRd4RecXpOkjCRS/I5DFXdxTpTpI
        CqxiTUFOQV7BAzwk7qMZ9zGe4KkyO0gIFFBUkFewjg2k8Iz8JjZNPDexhW0y
        sWNiF3sdsAj7OOhAi1CKcPgbSLYGUK0DAAA=
    """.trimIndent(),
)
