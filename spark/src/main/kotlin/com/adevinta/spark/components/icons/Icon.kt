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

package com.adevinta.spark.components.icon // keep a separate package for deprecated APIs

import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.components.icons.IconButton
import com.adevinta.spark.components.icons.rememberSparkIconPainter
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import androidx.compose.material3.Icon as MaterialIcon


/**
 * Icon component that draws [imageVector] using [tint], defaulting to [LocalContentColor]. For a
 * clickable icon, see [IconButton].
 *
 * To learn more about icons, see [Material Design icons](https://m3.material.io/styles/icons/overview)
 *
 * @param imageVector [ImageVector] to draw inside this icon
 * @param contentDescription text used by accessibility services to describe what this icon
 * represents. This should always be provided unless this icon is used for decorative purposes, and
 * does not represent a meaningful action that a user can take. This text should be localized, such
 * as by using [androidx.compose.ui.res.stringResource] or similar
 * @param modifier the [Modifier] to be applied to this icon
 * @param tint tint to be applied to [imageVector]. If [Color.Unspecified] is provided, then no tint
 * is applied.
 */
@Deprecated(
    "This component is no longer compliant with Spark specs",
    replaceWith = ReplaceWith(
        "Icon(imageVector, contentDescription, modifier, tint, iconSize",
        imports = ["com.adevinta.spark.components.icons"],
    ),
)
@Composable
public fun Icon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
) {
    MaterialIcon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier.sparkUsageOverlay(),
        tint = tint,
    )
}

/**
 * Icon component that draws [bitmap] using [tint], defaulting to [LocalContentColor]. For a
 * clickable icon, see [IconButton].
 *
 * To learn more about icons, see [Material Design icons](https://m3.material.io/styles/icons/overview)
 *
 * @param bitmap [ImageBitmap] to draw inside this icon
 * @param contentDescription text used by accessibility services to describe what this icon
 * represents. This should always be provided unless this icon is used for decorative purposes, and
 * does not represent a meaningful action that a user can take. This text should be localized, such
 * as by using [androidx.compose.ui.res.stringResource] or similar
 * @param modifier the [Modifier] to be applied to this icon
 * @param tint tint to be applied to [bitmap]. If [Color.Unspecified] is provided, then no tint is
 * applied.
 */
@Deprecated(
    "This component is no longer comppliant with Spark specs",
    replaceWith = ReplaceWith(
        "Icon(bitmap, contentDescription, modifier, tint, iconSize",
        imports = ["com.adevinta.spark.components.icons"],
    ),
)
@Composable
public fun Icon(
    bitmap: ImageBitmap,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
) {
    MaterialIcon(
        bitmap = bitmap,
        contentDescription = contentDescription,
        modifier = modifier.sparkUsageOverlay(),
        tint = tint,
    )
}

/**
 * Icon component that draws a [painter] using [tint], defaulting to [LocalContentColor]. For a
 * clickable icon, see [IconButton].
 *
 * To learn more about icons, see [Material Design icons](https://m3.material.io/styles/icons/overview)
 *
 * @param painter [Painter] to draw inside this icon
 * @param contentDescription text used by accessibility services to describe what this icon
 * represents. This should always be provided unless this icon is used for decorative purposes, and
 * does not represent a meaningful action that a user can take. This text should be localized, such
 * as by using [androidx.compose.ui.res.stringResource] or similar
 * @param modifier the [Modifier] to be applied to this icon
 * @param tint tint to be applied to [painter]. If [Color.Unspecified] is provided, then no tint is
 * applied.
 */
@Deprecated(
    "This component is no longer compliant with Spark specs",
    replaceWith = ReplaceWith(
        "Icon(painter, contentDescription, modifier, tint, iconSize",
        imports = ["com.adevinta.spark.components.icons"],
    ),
)
@Composable
public fun Icon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
) {
    MaterialIcon(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier.sparkUsageOverlay(),
        tint = tint,
    )
}

/**
 * Icon component that draws [sparkIcon] using [tint], defaulting to [LocalContentColor].
 * An internal function used for other Spark components internally.
 *
 * @param sparkIcon [SparkIcon] to draw inside this Icon
 * @param contentDescription text used by accessibility services to describe what this icon
 * represents. This should always be provided unless this icon is used for decorative purposes,
 * and does not represent a meaningful action that a user can take. This text should be
 * localized, such as by using [androidx.compose.ui.res.stringResource] or similar
 * @param modifier optional [Modifier] for this Icon
 * @param tint tint to be applied to [sparkIcon]. If [Color.Unspecified] is provided, then no
 *  tint is applied
 */
@InternalSparkApi
@Composable
public fun Icon(
    sparkIcon: SparkIcon,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
) {
    MaterialIcon(
        painter = rememberSparkIconPainter(sparkIcon),
        contentDescription = contentDescription,
        modifier = modifier.sparkUsageOverlay(),
        tint = tint,
    )
}

