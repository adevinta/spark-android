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
package com.adevinta.spark.catalog.datastore.textfieldsconfigurator

import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

internal object TextFieldsConfiguratorPropertiesSerializer : Serializer<TextFieldsConfiguratorProperties> {

    override val defaultValue: TextFieldsConfiguratorProperties
        get() = TextFieldsConfiguratorProperties.DEFAULT

    override suspend fun readFrom(
        input: InputStream,
    ): TextFieldsConfiguratorProperties = try {
        Json.decodeFromString(
            deserializer = TextFieldsConfiguratorProperties.serializer(),
            string = input.readBytes().decodeToString(),
        )
    } catch (e: SerializationException) {
        defaultValue
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun writeTo(
        t: TextFieldsConfiguratorProperties,
        output: OutputStream,
    ): Unit = output.write(
        Json.encodeToString(serializer = TextFieldsConfiguratorProperties.serializer(), value = t).encodeToByteArray(),
    )
}
