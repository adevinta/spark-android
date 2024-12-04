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

import androidx.annotation.RestrictTo
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.decode.DataSource
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.NullRequestData
import coil.request.SuccessResult
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.icons.rememberSparkIconPainter
import com.adevinta.spark.components.placeholder.illustrationPlaceholder
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.ErrorPhoto
import com.adevinta.spark.icons.NoPhoto
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.icons.Tattoo
import com.adevinta.spark.tokens.EmphasizeDim2
import com.adevinta.spark.tools.modifiers.ifNotNull
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay

@InternalSparkApi
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP_PREFIX)
@Composable
public fun SparkImage(
    model: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    // Useful to preview different states
    transform: (AsyncImagePainter.State) -> AsyncImagePainter.State = AsyncImagePainter.DefaultTransform,
    onState: ((State) -> Unit)? = null,
    emptyIcon: @Composable (iconSize: Dp) -> Unit = { ImageIconState(SparkIcons.NoPhoto, it) },
    errorIcon: @Composable (iconSize: Dp) -> Unit = {
        ImageIconState(
            sparkIcon = SparkIcons.ErrorPhoto,
            iconSize = it,
            color = SparkTheme.colors.errorContainer,
        )
    },
    loadingPlaceholder: @Composable () -> Unit = ImageDefaults.placeholder,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,
    // Don't yet expose this api as it's still experimental with performance issues
    blurEdges: Boolean = false,
) {
    BoxWithConstraints(
        modifier = modifier
            .sparkUsageOverlay()
            .ifNotNull(contentDescription) { description ->
                clearAndSetSemantics {
                    this.contentDescription = description
                    this.role = Role.Image
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        val iconSize = when {
            maxWidth in 24.dp..63.dp && maxHeight >= 24.dp -> 16.dp
            maxWidth in 64.dp..115.dp && maxHeight >= 64.dp -> 24.dp
            maxWidth in 116.dp..327.dp && maxHeight >= 72.dp -> 40.dp
            maxWidth >= 328.dp && maxHeight >= 80.dp -> 48.dp
            else -> Dp.Unspecified
        }
        val emptyStateIcon = remember(emptyIcon, iconSize) {
            movableContentOf(emptyIcon)
        }
        SubcomposeAsyncImage(
            model = model,
            contentDescription = contentDescription,
            transform = transform,
            onState = { onState?.invoke(it.asImageState()) },
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter,
            filterQuality = filterQuality,
        ) {
            when (painter.state) {
                AsyncImagePainter.State.Empty -> emptyStateIcon(iconSize)
                is AsyncImagePainter.State.Loading -> loadingPlaceholder()

                is AsyncImagePainter.State.Error -> {
                    // since model can be anything transformed in to a ImageRequest OR a ImageRequest we need to
                    // handel both cases
                    val requestData = painter.request.data
                    val showEmptyIcon = when {
                        (requestData is String) -> requestData.isBlank()
                        requestData == NullRequestData -> true
                        model == null -> true
                        else -> false
                    }

                    if (showEmptyIcon) {
                        emptyStateIcon(iconSize)
                    } else {
                        errorIcon(iconSize)
                    }
                }

                is AsyncImagePainter.State.Success -> {
                    if (blurEdges && contentScale != ContentScale.Crop) {
                        SubcomposeAsyncImageContent(
                            modifier = Modifier.blur(
                                10.dp,
                                BlurredEdgeTreatment.Rectangle,
                            ),
                            contentScale = ContentScale.Crop,
                        )
                    }
                    SubcomposeAsyncImageContent()
                }
            }
        }
    }
}

/**
 * A composable that lays out and draws a given Image. This will attempt to
 * size the composable according to the Image's given width and height. However, an
 * optional [Modifier] parameter can be provided to adjust sizing or draw additional content (ex.
 * background). Any unspecified dimension will leverage the Image's size as a minimum
 * constraint.
 *
 * @param model An object representing the image to be displayed.
 * This can be a URL, a file, or any other type of object that can be used to identify the image.
 * @param contentDescription text used by accessibility services to describe what this image
 * represents. This should always be provided unless this image is used for decorative purposes,
 * and does not represent a meaningful action that a user can take. This text should be
 * localized, such as by using [androidx.compose.ui.res.stringResource] or from the backend
 * @param modifier Modifier used to adjust the layout algorithm or draw decoration content (ex.
 * background)
 * @param onState A callback function that is called when the state of the image changes.
 * @param emptyIcon Placeholder used when the image loading has not started yet.
 * @param errorIcon Placeholder used when the image loading failed.
 * @param alignment Optional alignment parameter used to place the image in the given
 * bounds defined by the width and height
 * @param contentScale Optional scale parameter used to determine the aspect ratio scaling to be used
 * if the bounds are a different size from the intrinsic size of the image
 * @param alpha Optional opacity to be applied to the image when it is rendered onscreen. Default to 1f.
 * @param colorFilter Optional ColorFilter to apply for the image when it is rendered
 * onscreen
 * @param filterQuality Sampling algorithm applied to the image when it is scaled and drawn
 * into the destination. The default is [FilterQuality.Low] which scales using a bilinear
 * sampling algorithm
 * @param loadingPlaceholder Placeholder used when the image is loading. You can use a different one in special cases
 * like when the image is displayed in fullscreen for example.
 */
@Composable
public fun Image(
    model: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    onState: ((State) -> Unit)? = null,
    emptyIcon: @Composable (iconSize: Dp) -> Unit = { ImageIconState(SparkIcons.NoPhoto, it) },
    errorIcon: @Composable (iconSize: Dp) -> Unit = {
        ImageIconState(
            sparkIcon = SparkIcons.ErrorPhoto,
            iconSize = it,
            color = SparkTheme.colors.errorContainer,
        )
    },
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,
    loadingPlaceholder: @Composable () -> Unit = ImageDefaults.placeholder,
) {
    SparkImage(
        model = model,
        contentDescription = contentDescription,
        modifier = modifier,
        onState = onState,
        emptyIcon = emptyIcon,
        errorIcon = errorIcon,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        filterQuality = filterQuality,
        loadingPlaceholder = loadingPlaceholder,
    )
}

public object ImageDefaults {
    public val placeholder: @Composable () -> Unit = {
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .illustrationPlaceholder(
                    visible = true,
                    shape = SparkTheme.shapes.none,
                ),
        )
    }
}

@Composable
internal fun ImageIconState(
    sparkIcon: SparkIcon,
    iconSize: Dp,
    color: Color = SparkTheme.colors.neutralContainer,
) {
    Surface(
        color = color,
        modifier = Modifier.fillMaxSize(),
    ) {
        EmphasizeDim2 {
            Icon(
                sparkIcon = sparkIcon,
                contentDescription = null, // The SparkImage handle the content description
                modifier = Modifier.requiredSize(iconSize),
            )
        }
    }
}

/**
 * The current state of the [Image].
 */
public sealed class State {

    /** The current painter being drawn by [Image]. */
    public abstract val painter: Painter?

    /** The request has not been started or the request has no data*/
    public object Empty : State() {
        override val painter: Painter? get() = null
    }

    /** The request is in-progress. */
    public data class Loading(override val painter: Painter?) : State()

    /** The request was successful. */
    public data class Success(override val painter: Painter) : State()

    /** The request failed due to [ErrorResult.throwable]. */
    public data class Error(override val painter: Painter?) : State()
}

private fun AsyncImagePainter.State.asImageState(): State = when (this) {
    AsyncImagePainter.State.Empty -> State.Empty
    is AsyncImagePainter.State.Error -> State.Error(painter)
    is AsyncImagePainter.State.Loading -> State.Loading(painter)
    is AsyncImagePainter.State.Success -> State.Success(painter)
}

@Preview(
    group = "Images",
    name = "Image",
)
@Composable
internal fun ImagePreview() {
    PreviewTheme {
        val painter = rememberSparkIconPainter(sparkIcon = SparkIcons.Tattoo)
        val drawable =
            AppCompatResources.getDrawable(LocalContext.current, SparkIcons.Tattoo.drawableId)!!
        val imageRequest = ImageRequest.Builder(LocalContext.current).data(Unit).build()

        Text("Empty")

        SparkImage(
            model = null,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(SparkTheme.shapes.medium),
            transform = { AsyncImagePainter.State.Empty },
        )

        Text("Loading")

        SparkImage(
            model = Unit,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(SparkTheme.shapes.medium),
            transform = { AsyncImagePainter.State.Loading(painter) },
        )

        Text("Error")

        SparkImage(
            model = Unit,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(SparkTheme.shapes.medium),
            transform = { AsyncImagePainter.State.Error(painter, ErrorResult(null, imageRequest, Throwable(""))) },
        )

        Text("Success")

        SparkImage(
            model = Unit,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(SparkTheme.shapes.medium),
            transform = {
                AsyncImagePainter.State.Success(
                    painter,
                    SuccessResult(drawable, imageRequest, DataSource.DISK),
                )
            },
        )
    }
}
