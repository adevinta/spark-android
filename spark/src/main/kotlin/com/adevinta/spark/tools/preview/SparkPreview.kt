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

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    locale = "fr-rFR",
    showBackground = true,
    device = "id:pixel_6",
    uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL,
)
public annotation class SparkBasePreview

@Preview(
    name = "small font",
    group = "font scales",
    showBackground = true,
    locale = "fr-rFR",
    fontScale = 0.5f,
)
@Preview(
    name = "large font",
    group = "font scales",
    showBackground = true,
    locale = "fr-rFR",
    fontScale = 1.5f,
)
public annotation class FontScalePreviews

@Preview(
    name = "phone",
    group = "devices",
    showBackground = true,
    showSystemUi = true,
    locale = "fr-rFR",
    device = Devices.PHONE,
)
@Preview(
    name = "foldable",
    group = "devices",
    showBackground = true,
    showSystemUi = true,
    locale = "fr-rFR",
    device = Devices.FOLDABLE,
)
@Preview(
    name = "tablet",
    group = "devices",
    showBackground = true,
    showSystemUi = true,
    locale = "fr-rFR",
    device = Devices.TABLET,
)
@Preview(
    name = "tablet",
    group = "devices",
    showBackground = true,
    showSystemUi = true,
    locale = "fr-rFR",
    device = Devices.DESKTOP,
)
public annotation class DevicePreviews

@Preview(
    name = "light",
    group = "themes",
    locale = "fr-rFR",
    uiMode = UI_MODE_NIGHT_NO,
)
@Preview(
    name = "dark",
    group = "themes",
    locale = "fr-rFR",
    uiMode = UI_MODE_NIGHT_YES,
)
public annotation class ThemesPreviews

@DevicePreviews
@ThemesPreviews
public annotation class SparkPreviews
