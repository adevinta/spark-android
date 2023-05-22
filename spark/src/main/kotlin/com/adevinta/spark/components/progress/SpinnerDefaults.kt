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

package com.adevinta.spark.components.progress

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

public object SpinnerDefaults {
    public val Size: SpinnerSize = SpinnerSize.Medium
    internal val IndicatorStrokeWidth = 2.dp

    internal const val RotationDurationInMillis = 1000

    // How far the base point moves around the circle
    internal const val BaseRotationAngle = 360f

    // Each rotation we want to offset the start position by this much, so we continue where
    // the previous rotation ended. This is the maximum angle covered during one rotation.
    internal const val RotationAngleOffset = BaseRotationAngle % 360f

    // Start at 12 o'clock
    internal const val StartAngleOffset = 270f
}

public enum class SpinnerSize(public val dp: Dp) {
    Small(20.dp),
    Medium(28.dp)
}
