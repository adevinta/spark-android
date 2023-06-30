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
package com.adevinta.spark.catalog.util

import android.content.Context
import android.content.Intent
import android.net.Uri

public fun Context.openUrl(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}

public const val GuidelinesUrl: String = "https://spark.adevinta.com"
public const val ComponentGuidelinesUrl: String = "https://spark.adevinta.com/1186e1705/p/590121-components"
public const val StyleGuidelinesUrl: String = "https://m3.material.io/styles"
public const val ReleasesUrl: String = "https://github.com/adevinta/spark-android/releases"
public const val DocsUrl: String = "https://adevinta.github.io/spark-android/"
public const val SourceUrl: String = "https://github.com/adevinta/spark-android"
public const val SparkSourceUrl: String = "https://github.com/adevinta/spark-android/"
// Use the real sample url from spark once we have our first ones
/* ktlint-disable max-line-length */
public const val SampleSourceUrl: String = "https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:compose/material3/material3/samples/src/main/java/androidx/compose/material3/samples"
public const val PackageSummaryUrl: String = "https://https://adevinta.github.io/spark-android/spark/"
/* ktlint-disable max-line-length */
public const val IssueUrl: String = "https://github.com/adevinta/spark-android/issues?q=is%3Aissue+is%3Aopen+sort%3Aupdated-desc"
public const val LicensesUrl: String = "https://github.com/adevinta/spark-android/blob/main/LICENSE"
