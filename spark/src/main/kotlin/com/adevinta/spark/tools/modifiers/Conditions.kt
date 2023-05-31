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
package com.adevinta.spark.tools.modifiers

import androidx.compose.ui.Modifier

/**
 * Modifier to make it easy to conditionally add a modifier based on [predicate]
 * ```kotlin
 * Box(
 *  modifier = Modifier.fillMaxWidth()
 *    .ifTrue(isError) { background(SparkTheme.colors.error) }
 *    .padding(16.dp)
 *  ) {...}
 * ```
 * @param predicate condition to decide if the [builder] is added or not to the modifier chain
 * @param builder the modifier(s) to apply when [predicate] is true
 */
public inline fun Modifier.ifTrue(predicate: Boolean, builder: Modifier.() -> Modifier): Modifier =
    then(if (predicate) this.builder() else Modifier)

/**
 * Modifier to make it easy to conditionally add a modifier based on [predicate]
 * ```kotlin
 * Box(
 *  modifier = Modifier.fillMaxWidth()
 *    .ifFalse(isError) { background(SparkTheme.colors.valid) }
 *    .padding(16.dp)
 *  ) {...}
 * ```
 * @param predicate condition to decide if the [builder] is added or not to the modifier chain
 * @param builder the modifier(s) to apply when [predicate] is false
 */
public inline fun Modifier.ifFalse(predicate: Boolean, builder: Modifier.() -> Modifier): Modifier =
    then(if (!predicate) this.builder() else Modifier)

/**
 * Modifier to make it easy to conditionally add a modifier based on [value] nullability
 * ```kotlin
 * Box(
 *  modifier = Modifier.fillMaxWidth()
 *    .ifNotNull(errorMetadata) { errorData -> background(errorData.color) }
 *    .padding(16.dp)
 *  ) {...}
 * ```
 * @param value decide if the [builder] is added or not to the modifier chain
 * @param builder the modifier(s) to apply when [value] is not null
 */
public inline fun <T : Any> Modifier.ifNotNull(value: T?, builder: Modifier.(T) -> Modifier): Modifier =
    then(if (value != null) this.builder(value) else Modifier)

/**
 * Modifier to make it easy to conditionally add a modifier based on [value] nullability
 * ```kotlin
 * Box(
 *  modifier = Modifier.fillMaxWidth()
 *    .ifNull(errorMetadata) { errorData -> background(errorData.valid) }
 *    .padding(16.dp)
 *  ) {...}
 * ```
 * @param value decide if the [builder] is added or not to the modifier chain
 * @param builder the modifier(s) to apply when [value] is null
 */
public inline fun <T : Any> Modifier.ifNull(value: T?, builder: Modifier.() -> Modifier): Modifier =
    then(if (value == null) this.builder() else Modifier)
