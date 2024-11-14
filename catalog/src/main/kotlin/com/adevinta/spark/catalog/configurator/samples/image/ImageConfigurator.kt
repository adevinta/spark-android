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
package com.adevinta.spark.catalog.configurator.samples.image

import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.CornerRounding
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.star
import coil.compose.AsyncImagePainter
import coil.decode.DataSource
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.model.Configurator
import com.adevinta.spark.catalog.ui.ButtonGroup
import com.adevinta.spark.catalog.ui.RoundedPolygonShape
import com.adevinta.spark.catalog.util.PreviewTheme
import com.adevinta.spark.catalog.util.SampleSourceUrl
import com.adevinta.spark.components.image.SparkImage
import com.adevinta.spark.components.menu.DropdownMenuItem
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.components.textfields.Dropdown
import com.adevinta.spark.components.textfields.TextField
import com.adevinta.spark.tokens.LocalWindowSizeClass
import com.google.accompanist.drawablepainter.rememberDrawablePainter

public val ImageConfigurator: Configurator = Configurator(
    name = "Image",
    description = "Image configuration",
    sourceUrl = "$SampleSourceUrl/ImageSample.kt",
) {
    ImageSample()
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ColumnScope.ImageSample() {
    var state by remember { mutableStateOf(ImageState.Loading) }
    var width by remember { mutableStateOf<Int?>(1) }
    var height by remember { mutableStateOf<Int?>(1) }
    var aspectRatio by remember { mutableStateOf(ImageAspectRatio.Custom) }
    var imageShape by remember { mutableStateOf(ImageShape.Wavy) }
    val drawable = getDrawable(LocalContext.current, R.drawable.notifications)!!
    val painter = rememberDrawablePainter(drawable)
    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .crossfade(true)
        .data(state.ordinal)
        .build()

    val transform by rememberUpdatedState { _: AsyncImagePainter.State ->
        state.transformation(
            painter,
            drawable,
            imageRequest,
        )
    }
    val imageMaxWidth = when (LocalWindowSizeClass.current.widthSizeClass) {
        WindowWidthSizeClass.Expanded -> 300.dp
        WindowWidthSizeClass.Medium -> 200.dp
        else -> 100.dp
    }
    SparkImage(
        model = state.ordinal,
        contentDescription = null,
        modifier = Modifier
            .widthIn(max = imageMaxWidth)
            .aspectRatio(
                ratio = if (aspectRatio == ImageAspectRatio.Custom) {
                    (width?.toFloat() ?: 1f) / (height?.toFloat() ?: 1f)
                } else {
                    aspectRatio.ratio
                },
                matchHeightConstraintsFirst = true,
            )
            .align(Alignment.CenterHorizontally)
            .clip(imageShape.shape)
            .animateContentSize(),
        transform = transform,
    )

    ButtonGroup(
        title = "States",
        selectedOption = state,
        onOptionSelect = { state = it },
    )
    var expanded by remember { mutableStateOf(false) }
    Dropdown(
        modifier = Modifier.fillMaxWidth(),
        value = imageShape.name,
        label = "Shapes",
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        onDismissRequest = {
            expanded = false
        },
        dropdownContent = {
            ImageShape.entries.forEach {
                DropdownMenuItem(
                    text = { Text(it.name) },
                    onClick = {
                        imageShape = it
                        expanded = false
                    },
                )
            }
        },
    )

    ButtonGroup(
        title = "Aspect Ratio",
        selectedOption = aspectRatio.label,
        options = ImageAspectRatio.entries.map(ImageAspectRatio::label),
        onOptionSelect = { option ->
            aspectRatio = ImageAspectRatio.entries.firstOrNull {
                option == it.label
            } ?: aspectRatio
        },
    )

    AnimatedVisibility(aspectRatio == ImageAspectRatio.Custom) {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            maxItemsInEachRow = 2,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            TextField(
                value = width?.toString().orEmpty(),
                label = "Width",
                onValueChange = {
                    width = it.toIntOrNull()
                },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            TextField(
                value = height?.toString().orEmpty(),
                label = "Height",
                onValueChange = {
                    height = it.toIntOrNull()
                },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }
    }
}

private enum class ImageState {
    Loading {
        override fun transformation(
            painter: Painter,
            drawable: Drawable,
            imageRequest: ImageRequest,
        ): AsyncImagePainter.State = AsyncImagePainter.State.Loading(painter)
    },
    Empty {
        override fun transformation(
            painter: Painter,
            drawable: Drawable,
            imageRequest: ImageRequest,
        ): AsyncImagePainter.State = AsyncImagePainter.State.Empty
    },
    Error {
        override fun transformation(
            painter: Painter,
            drawable: Drawable,
            imageRequest: ImageRequest,
        ): AsyncImagePainter.State = AsyncImagePainter.State.Error(
            painter,
            ErrorResult(null, imageRequest, Throwable("")),
        )
    },
    Success {
        override fun transformation(
            painter: Painter,
            drawable: Drawable,
            imageRequest: ImageRequest,
        ): AsyncImagePainter.State = AsyncImagePainter.State.Success(
            painter,
            SuccessResult(drawable, imageRequest, DataSource.DISK),
        )
    }, ;

    abstract fun transformation(
        painter: Painter,
        drawable: Drawable,
        imageRequest: ImageRequest,
    ): AsyncImagePainter.State
}

private enum class ImageShape {
    None {
        override val shape: Shape
            @Composable
            get() = SparkTheme.shapes.none
    },
    Small {
        override val shape: Shape
            @Composable
            get() = SparkTheme.shapes.small
    },
    Medium {
        override val shape: Shape
            @Composable
            get() = SparkTheme.shapes.medium
    },
    Large {
        override val shape: Shape
            @Composable
            get() = SparkTheme.shapes.large
    },
    ExtraLarge {
        override val shape: Shape
            @Composable
            get() = SparkTheme.shapes.extraLarge
    },
    Full {
        override val shape: Shape
            @Composable
            get() = SparkTheme.shapes.full
    },
    Hexagon {
        override val shape: Shape
            @Composable
            get() = RoundedPolygonShape(
                polygon = RoundedPolygon(
                    numVertices = 6,
                    rounding = CornerRounding(0.2f),
                ),
            )
    },
    Wavy {
        override val shape: Shape
            @Composable
            get() = RoundedPolygonShape(
                polygon = RoundedPolygon.star(
                    numVerticesPerRadius = 9,
                    innerRadius = 0.65f,
                    rounding = CornerRounding(2f),
                ),
            )
    }, ;

    @get:Composable
    abstract val shape: Shape
}

private enum class ImageAspectRatio(val label: String, val ratio: Float) {
    Custom(
        label = "Custom",
        ratio = 1f,
    ),
    Square(
        label = "1:1",
        ratio = 1f,
    ),
    OldTV(
        label = "4:3",
        ratio = 4 / 3f,
    ),
    Screen(
        label = "16:9",
        ratio = 16 / 9f,
    ),
}

@Preview
@Composable
private fun ImageSamplePreview() {
    PreviewTheme { ImageSample() }
}
