package com.adevinta.spark.components.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.adevinta.spark.tools.modifiers.brikkeUsageOverlay

@Suppress("ModifierMissing") // We consider it not needed for spacers
@Composable
fun VerticalSpace(space: Dp) = Spacer(
    modifier = Modifier
        .height(space)
        .brikkeUsageOverlay(Color.Green),
)

@Suppress("ModifierMissing")
@Composable
fun HorizontalSpace(space: Dp) = Spacer(
    modifier = Modifier
        .width(space)
        .brikkeUsageOverlay(Color.Green),
)
