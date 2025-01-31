/*
 * Copyright (c) 2024 Adevinta
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

package com.adevinta.spark.res

import android.telephony.PhoneNumberUtils
import android.text.Annotation
import com.adevinta.spark.res.SparkStringAnnotations.toAccessibilitySpan
import java.text.DecimalFormatSymbols
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

public enum class SparkAccessibilitySpan(public val annotation: String) {
    CARDINAL("cardinal"),
    DATE("date"),
    DECIMAL("decimal"),
    DIGITS("digits"),
    ELECTRONIC("electronic"),
    FRACTION("fraction"),
    MEASURE("measure"),
    MONEY("money"),
    ORDINAL("ordinal"),
    TELEPHONE("telephone"),
    TEXT("text"),
    TIME("time"),
    VERBATIM("verbatim"),
}

/**
 * Update the [String] format from `start` to `end` with the provided [SparkAccessibilitySpan].
 */
internal fun CharSequence.buildWithAccessibilitySpan(
    it: Any,
    start: Int,
    end: Int,
): String {
    if (it !is Annotation) return this.toString()
    val baseSubstring = substring(start, end)
    return this.toString().replaceRange(
        startIndex = start,
        endIndex = end,
        replacement = when (it.value.toAccessibilitySpan()) {
            SparkAccessibilitySpan.CARDINAL -> baseSubstring
            SparkAccessibilitySpan.DATE -> baseSubstring.applyDateSpan()
            SparkAccessibilitySpan.DECIMAL -> baseSubstring.applyDecimalSpan()
            SparkAccessibilitySpan.DIGITS -> baseSubstring.applyDigitsSpan()
            SparkAccessibilitySpan.ELECTRONIC -> baseSubstring.applyElectronicSpan()
            SparkAccessibilitySpan.FRACTION -> baseSubstring.applyFractionSpan()
            SparkAccessibilitySpan.MEASURE -> baseSubstring.applyMeasureSpan()
            SparkAccessibilitySpan.MONEY -> baseSubstring.applyMoneySpan()
            SparkAccessibilitySpan.ORDINAL -> baseSubstring
            SparkAccessibilitySpan.TELEPHONE -> baseSubstring.applyTelephoneSpan()
            SparkAccessibilitySpan.TEXT -> baseSubstring
            SparkAccessibilitySpan.TIME -> baseSubstring.applyTimeSpan()
            SparkAccessibilitySpan.VERBATIM -> baseSubstring.applyVerbatimSpan()
        },
    )
}

private fun String.applyElectronicSpan() = replace(":", " deux points ")
    .replace(".", " point ")
    .replace("/", " slash ")
    .replace("@", " at ")

private fun String.applyDateSpan() = replace(" ", "/")
    .replace("-", "/")
    .let { date ->
        runCatching {
            val inputDate = LocalDate.parse(
                date,
                DateTimeFormatter.ofPattern("d/M/y", Locale.getDefault()),
            )
            DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.getDefault()).format(inputDate)
        }.getOrDefault(date)
    }

private fun String.applyDecimalSpan() = replace(
    DecimalFormatSymbols(Locale.getDefault()).decimalSeparator.toString(),
    " virgule ",
)

private fun String.applyDigitsSpan() = applyVerbatimSpan()
private fun String.applyFractionSpan() = replace("/", " sur ")
private fun String.applyMeasureSpan() = replace("l", "litres", ignoreCase = true)
    .replace("k", "kilo")
    .replace("m", "mètres", ignoreCase = true)
    .replace("g", "gramme")
    .replace("c", "centi")
    .replace("h", "heure")
    .replace("/", " par ")

private fun String.applyMoneySpan() = this.replace(" ", "").replace(" ", "")

private fun String.applyTelephoneSpan() =
    PhoneNumberUtils.formatNumber(this, Locale.getDefault().country)

private fun String.applyTimeSpan() = this.replace(" ", ":")
    .replace("-", ":")
    .let { date ->
        runCatching {
            val inputDate = DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault()).parse(date)
            DateTimeFormatter.ofPattern("HH' heures 'mm' minutes'", Locale.getDefault())
                .format(inputDate)
        }.getOrDefault(date)
    }

private fun String.applyVerbatimSpan() = map { char -> "$char " }.joinToString("")