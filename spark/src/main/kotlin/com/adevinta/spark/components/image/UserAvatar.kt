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

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.adevinta.spark.icons.SparkIcon
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
    isPro: Boolean = false,
    isOnline: Boolean = false,
) {
    val emptyIcon = @Composable {
        ImageIconState(
            sparkIcon = if (isPro) SparkIcon.User.Store else SparkIcon.User.Avatar,
        )
    }
    Box(
        modifier = (if (fillParentSize) modifier.fillMaxSize() else modifier.size(
            style.imageSize,
        )).sparkUsageOverlay(),
    ) {
        SparkImage(
            modifier = Modifier
                .align(Alignment.Center)
                .clip(SparkTheme.shapes.full)
                .aspectRatio(1f),
            model = model,
            transform = transform,
            contentDescription = stringResource(id = R.string.spark_user_avatar_content_description),
            contentScale = ContentScale.Crop,
            emptyIcon = emptyIcon,
            errorIcon = emptyIcon,
        )

        if (isOnline) {
            PresenceIndicator(
                modifier = Modifier
                    .size(style.badgeSize)
                    .align(Alignment.BottomEnd)
                    .offset(x = 0.dp, y = style.badgeOffset),
            )
        }
    }
}

@Composable
private fun ImageIconState(sparkIcon: SparkIcon) {
    Surface(
        color = SparkTheme.colors.neutralContainer,
    ) {
        Illustration(
            sparkIcon = sparkIcon,
            contentDescription = null, // The SparkImage handle the content description
        )
    }
}

@Composable
private fun PresenceIndicator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .border(1.dp, SparkTheme.colors.onSurfaceInverse, CircleShape)
            .padding(1.dp)
            .clip(CircleShape)
            .background(SparkTheme.colors.success),
    )
}

@Composable
public fun UserAvatar(
    modifier: Modifier = Modifier,
    style: UserAvatarStyle = UserAvatarStyle.SMALL,
    fillParentSize: Boolean = false,
    model: Any? = null,
    isPro: Boolean = false,
    isOnline: Boolean = false,
) {
    SparkUserAvatar(
        modifier = modifier,
        style = style,
        fillParentSize = fillParentSize,
        model = model,
        isPro = isPro,
        isOnline = isOnline,
    )
}

/**
 * @param imageSize size of the image in [Dp]
 * @param badgeSize size of online badge in [Dp]
 * @param badgeOffset size of the offset of the badge in [Dp]
 */
public enum class UserAvatarStyle(public val imageSize: Dp, public val badgeSize: Dp, public val badgeOffset: Dp) {
    SMALL(imageSize = 32.dp, badgeSize = 9.dp, badgeOffset = (-1).dp),
    MEDIUM(imageSize = 40.dp, badgeSize = 9.dp, badgeOffset = (-1).dp),
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
            style = UserAvatarStyle.MEDIUM,
            model = "",
            isPro = true,
            isOnline = false,
            transform = { AsyncImagePainter.State.Empty },
        )
        SparkUserAvatar(
            style = UserAvatarStyle.SMALL,
            model = "",
            isPro = true,
            isOnline = false,
            transform = { AsyncImagePainter.State.Empty },
        )
    }
}
