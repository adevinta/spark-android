package com.adevinta.spark.components.drawer

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
public object SparkDrawerDefaults {
    public val ModalDrawerElevation: Dp = 1.0.dp

    public val windowInsets: WindowInsets
        @Composable
        get() = DrawerDefaults.windowInsets
}
