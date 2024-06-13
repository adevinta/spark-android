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
package com.adevinta.spark.components.image

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.R
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.icons.ProFill
import com.adevinta.spark.icons.ProfileFill
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import com.adevinta.spark.tools.preview.ThemeProvider
import com.adevinta.spark.tools.preview.ThemeVariant

@InternalSparkApi
@Composable
internal fun SparkUserAvatar(
    modifier: Modifier = Modifier,
    // Useful to preview different states
    transform: (AsyncImagePainter.State) -> AsyncImagePainter.State = AsyncImagePainter.DefaultTransform,
    style: UserAvatarStyle = UserAvatarStyle.SMALL,
    fillParentSize: Boolean = false,
    model: Any? = null,
    color: Color = Color.Unspecified,
    isPro: Boolean = false,
    isOnline: Boolean = false,
) {
    val emptyIcon = @Composable {
        ImageIconState(
            sparkIcon = if (isPro) SparkIcons.ProFill else SparkIcons.ProfileFill,
            color = color,
        )
    }
    val indicatorColor = SparkTheme.colors.success
    SparkImage(
        modifier = (
            if (fillParentSize) {
                modifier.fillMaxSize()
            } else {
                modifier.size(style.imageSize)
            }
            )
            .sparkUsageOverlay()
//                .clip(SparkTheme.shapes.full)
            .aspectRatio(1f)
            .graphicsLayer {
                compositingStrategy = CompositingStrategy.Offscreen
            }
            .drawWithCache {
                val path = Path()
                path.addOval(
                    Rect(
                        topLeft = Offset.Zero,
                        bottomRight = Offset(size.width, size.height),
                    ),
                )
                onDrawWithContent {
                    clipPath(path) {
                        this@onDrawWithContent.drawContent()
                    }
                    if (isOnline) {
                        val dotSize = style.badgeSize.toPx() / 2
                        val offset = style.badgeOffset.toPx()
                        // Clip a white border for the content
                        drawCircle(
                            Color.Black,
                            radius = dotSize,
                            center = Offset(
                                x = size.width - dotSize,
                                y = size.height - dotSize + offset,
                            ),
                            blendMode = BlendMode.Clear,
                        )
                        // draw the red circle indication
                        drawCircle(
                            indicatorColor,
                            radius = dotSize - style.borderSize.toPx(),
                            center = Offset(
                                x = size.width - dotSize,
                                y = size.height - dotSize + offset,
                            ),
                        )
                    }
                }
            },
        model = model,
        transform = transform,
        contentDescription = stringResource(id = R.string.spark_user_avatar_content_description),
        contentScale = ContentScale.Fit,
        emptyIcon = emptyIcon,
        errorIcon = emptyIcon,
    )
}

@Composable
private fun ImageIconState(
    sparkIcon: SparkIcon,
    color: Color,
) {
    Surface(
        color = color,
    ) {
        Icon(
            sparkIcon = sparkIcon,
            contentDescription = null, // The SparkImage handle the content description
        )
    }
}

@Composable
public fun UserAvatar(
    modifier: Modifier = Modifier,
    style: UserAvatarStyle = UserAvatarStyle.SMALL,
    fillParentSize: Boolean = false,
    model: Any? = null,
    color: Color = Color.Unspecified,
    isPro: Boolean = false,
    isOnline: Boolean = false,
) {
    SparkUserAvatar(
        modifier = modifier,
        style = style,
        fillParentSize = fillParentSize,
        model = model,
        isPro = isPro,
        color = color,
        isOnline = isOnline,
    )
}

/**
 * @param imageSize size of the image in [Dp]
 * @param badgeSize size of online badge in [Dp]
 * @param badgeOffset size of the offset of the badge in [Dp]
 * @param borderSize The indicator border size in [Dp], it needs to be defined since the border mechanisms is
 * different than figma
 */
public enum class UserAvatarStyle(
    public val imageSize: Dp,
    public val badgeSize: Dp,
    public val badgeOffset: Dp,
    public val borderSize: Dp,
) {
    SMALL(imageSize = 32.dp, badgeSize = 8.dp, badgeOffset = (-4).dp, borderSize = 1.dp),
    MEDIUM(imageSize = 40.dp, badgeSize = 10.dp, badgeOffset = (-5).dp, borderSize = 1.5.dp),
    LARGE(imageSize = 64.dp, badgeSize = 16.dp, badgeOffset = (-12).dp, borderSize = 2.dp),
}

@Preview(
    group = "Images",
    name = "User Avatar",
)
@Composable
internal fun UserAvatarPreview(
    @PreviewParameter(ThemeProvider::class) theme: ThemeVariant,
) {
    PreviewTheme(theme) {
        SparkUserAvatar(
            style = UserAvatarStyle.LARGE,
            model = "",
            isPro = false,
            isOnline = true,
            transform = { AsyncImagePainter.State.Empty },
        )
        SparkUserAvatar(
            style = UserAvatarStyle.MEDIUM,
            model = "",
            isPro = false,
            isOnline = true,
            transform = { AsyncImagePainter.State.Empty },
        )
        SparkUserAvatar(
            style = UserAvatarStyle.SMALL,
            model = "",
            isPro = false,
            isOnline = true,
            transform = { AsyncImagePainter.State.Empty },
        )
        SparkUserAvatar(
            style = UserAvatarStyle.LARGE,
            model = "",
            isPro = true,
            isOnline = true,
            transform = { AsyncImagePainter.State.Empty },
        )
        SparkUserAvatar(
            style = UserAvatarStyle.MEDIUM,
            model = "",
            isPro = true,
            isOnline = true,
            transform = { AsyncImagePainter.State.Empty },
        )
        SparkUserAvatar(
            style = UserAvatarStyle.SMALL,
            model = "",
            isPro = true,
            isOnline = true,
            transform = { AsyncImagePainter.State.Empty },
        )
    }
}
