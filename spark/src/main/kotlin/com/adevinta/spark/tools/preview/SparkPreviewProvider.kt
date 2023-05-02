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

package com.adevinta.spark.tools.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import kotlin.reflect.KClass

public class SparkPreviewProvider : PreviewParameterProvider<Pair<ThemeVariant, UserType>> by compositeProvider(
    ThemeProvider::class,
    UserProProvider::class,
)

public class SparkPreviewParamProvider : CollectionPreviewParameterProvider<SparkPreviewParam>(
    listOf(
        SparkPreviewParam(ThemeVariant.Light, UserType.Part, isLegacy = false),
        SparkPreviewParam(ThemeVariant.Light, UserType.Pro, isLegacy = false),
        SparkPreviewParam(ThemeVariant.Dark, UserType.Part, isLegacy = false),
        SparkPreviewParam(ThemeVariant.Dark, UserType.Pro, isLegacy = false),
        SparkPreviewParam(ThemeVariant.Light, UserType.Part, isLegacy = true),
        SparkPreviewParam(ThemeVariant.Light, UserType.Pro, isLegacy = true),
        SparkPreviewParam(ThemeVariant.Dark, UserType.Part, isLegacy = true),
        SparkPreviewParam(ThemeVariant.Dark, UserType.Pro, isLegacy = true),
    ),
)

public data class SparkPreviewParam(
    val theme: ThemeVariant,
    val userType: UserType,
    val isLegacy: Boolean,
)

/**
 * Creates a [PreviewParameterProvider] based on the classes of two existing providers.
 *
 * You can create your own easily with Kotlin delegation:
 * ```kotlin
 * class ExampleProvider : PreviewParameterProvider<Pair<Type1, Type2>>
 *    by compositeProvider(Type1ParameterProvider::class, Type2ParameterProvider::class)
 * ```
 */
public fun <T1 : Any, T2 : Any> compositeProvider(
    kClass1: KClass<out PreviewParameterProvider<T1>>,
    kClass2: KClass<out PreviewParameterProvider<T2>>,
): PreviewParameterProvider<Pair<T1, T2>> = CompositeParameterProvider(kClass1, kClass2)

private class CompositeParameterProvider<T1 : Any, T2 : Any>(
    kClass1: KClass<out PreviewParameterProvider<T1>>,
    kClass2: KClass<out PreviewParameterProvider<T2>>,
) : PreviewParameterProvider<Pair<T1, T2>> {

    private val provider1 = kClass1.java.newInstance()
    private val provider2 = kClass2.java.newInstance()

    override val values: Sequence<Pair<T1, T2>>
        get() = provider1.values union provider2.values
}

private infix fun <T1 : Any, T2 : Any> Sequence<T1>.union(
    sequence: Sequence<T2>,
): Sequence<Pair<T1, T2>> = flatMap { original -> sequence.map { original to it } }

public class ThemeProvider : PreviewParameterProvider<ThemeVariant> {
    override val values: Sequence<ThemeVariant> = sequenceOf(
        ThemeVariant.Light,
        ThemeVariant.Dark,
    )
}

public class UserProProvider : PreviewParameterProvider<UserType> {
    override val values: Sequence<UserType> = sequenceOf(
        UserType.Part,
        UserType.Pro,
    )
}

public enum class ThemeVariant {
    Light, Dark;
}

public enum class UserType {
    Part, Pro;
}
