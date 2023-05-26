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

import androidx.annotation.FloatRange
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import com.adevinta.spark.tools.preview.SparkPreviewProvider
import com.adevinta.spark.tools.preview.ThemeVariant
import com.adevinta.spark.tools.preview.UserType
import androidx.compose.material3.LinearProgressIndicator as MaterialLinearProgressIndicator

@InternalSparkApi
@Composable
internal fun SparkLinearProgressIndicator(
    @FloatRange(from = 0.0, to = 1.0)
    progress: Float,
    isIndeterminate: Boolean,
    modifier: Modifier = Modifier,
) {
    val color = ProgressIndicatorDefaults.linearColor // Primary
    val trackColor = SparkTheme.colors.neutralContainer
    if (isIndeterminate) {
        MaterialLinearProgressIndicator(
            modifier = modifier.sparkUsageOverlay(),
            color = color,
            trackColor = trackColor,
        )
    } else {
        MaterialLinearProgressIndicator(
            modifier = modifier.sparkUsageOverlay(),
            progress = progress,
            color = color,
            trackColor = trackColor,
        )
    }
}

/**
 * Progress indicators express an unspecified wait time or display the duration of a process.
 *
 * By default there is no animation between [progress] values. You can use
 * [ProgressIndicatorDefaults.ProgressAnimationSpec] as the default recommended [AnimationSpec] when
 * animating progress
 *
 * @param progress the progress of this progress indicator, where 0.0 represents no progress and 1.0
 * represents full progress. Values outside of this range are coerced into the range.
 * @param modifier the [Modifier] to be applied to this progress indicator
 */
@Composable
public fun LinearProgressIndicator(
    @FloatRange(from = 0.0, to = 1.0)
    progress: Float,
    modifier: Modifier = Modifier,
) {
    SparkLinearProgressIndicator(
        progress = progress.coerceIn(0.0f, 1.0f),
        isIndeterminate = false,
        modifier = modifier,
    )
}

/**
 * Progress indicators express an unspecified wait time or display the duration of a process.
 *
 * @param modifier the [Modifier] to be applied to this progress indicator
 */
@Composable
public fun LinearProgressIndicatorIndeterminate(
    modifier: Modifier = Modifier,
) {
    SparkLinearProgressIndicator(
        progress = 0f,
        isIndeterminate = true,
        modifier = modifier,
    )
}

@Preview(
    group = "ProgressIndicator",
    name = "LinearProgressIndicator",
)
@Composable
internal fun PreviewLinearProgressIndicator(
    @PreviewParameter(SparkPreviewProvider::class) param: Pair<ThemeVariant, UserType>,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            progress = 0f,
        )
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            progress = 0.5f,
        )
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            progress = 1f,
        )
    }
}

@Preview(
    group = "ProgressIndicator",
    name = "LinearProgressIndicatorIndeterminate",
)
@Composable
internal fun PreviewLinearProgressIndicatorIndeterminate(
    @PreviewParameter(SparkPreviewProvider::class) param: Pair<ThemeVariant, UserType>,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        LinearProgressIndicatorIndeterminate(modifier = Modifier.fillMaxWidth())
    }
}
