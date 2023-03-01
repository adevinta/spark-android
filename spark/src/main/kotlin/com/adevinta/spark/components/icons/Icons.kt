package com.adevinta.spark.components.icons

import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import com.adevinta.spark.icons.IconDrawableRes
import com.adevinta.spark.icons.IconVector
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import androidx.compose.material3.Icon as MaterialIcon

/**
 * Icon component that draws [sparkIcon] using [tint], defaulting to [LocalContentColor]. For a
 * clickable icon, see [IconButton].
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

@Composable
public fun rememberSparkIconPainter(sparkIcon: SparkIcon): Painter {
    @Suppress("USELESS_IS_CHECK") // Currently all icons are IconDrawableRes but that might not be true in the future
    return when (sparkIcon) {
        is IconVector -> rememberVectorPainter(sparkIcon.imageVector)

        is IconDrawableRes -> {
            val drawable = AppCompatResources.getDrawable(LocalContext.current, sparkIcon.drawableId)
            rememberDrawablePainter(drawable)
        }

        else -> error("Can't found Painter for sparkIcon $sparkIcon")
    }
}
