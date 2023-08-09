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

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException

internal class TextFieldsConfiguratorPropertiesHandler(context: Context) {

    private val datastore = context.datastore

    val properties: Flow<TextFieldsConfiguratorProperties> = datastore.data.catch { exception ->
        when (exception) {
            is IOException -> emit(TextFieldsConfiguratorProperties.DEFAULT)
            else -> throw exception
        }
    }

    suspend fun updateProperties(properties: TextFieldsConfiguratorProperties) {
        datastore.updateData { properties }
    }

    companion object {
        private val Context.datastore: DataStore<TextFieldsConfiguratorProperties> by dataStore(
            fileName = "text_fields_configurator_properties.pb",
            serializer = TextFieldsConfiguratorPropertiesSerializer,
        )
    }
}
