package com.adevinta.spark.sample.themes.themeprovider

import androidx.compose.runtime.Composable
import com.adevinta.spark.tokens.SparkColors
import com.adevinta.spark.tokens.SparkShapes
import com.adevinta.spark.tokens.SparkTypography

public interface ThemeProvider {
    @Composable
    public fun colors(useDarkColors: Boolean, isPro: Boolean, isLegacy: Boolean): SparkColors

    @Composable
    public fun shapes(isLegacy: Boolean): SparkShapes

    @Composable
    public fun typography(isLegacy: Boolean): SparkTypography
}
