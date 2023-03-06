# Illustration components

## Illustration design specs

[//]: # (Add the link to the design specs here)

## Usage

`Illustration` helps describe abstract concepts and assists with comprehension and helps convey a
clear message.

### Illustration

<img src="../art/images/illu-exemple.png" title="A person with a cart full of items" width="500" />

```kotlin
@Composable
fun Illustration(
    imageBitmap: ImageBitmap,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,
)
```

The minimal usage of the component is the data to show that can be of the types bellow with a
content description to describe the content of this illustration like "A person with a cart full
of items" if it has a meaningful purpose.

| Parameters                                                       | Descriptions                                                                                                       |
|------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| `contentDescription: String?,`                                   | A string describing the image, which is used for accessibility purposes                                            |
| `modifier: Modifier = Modifier,`                                 | applied to this image                                                                                              |
| `onState: ((State) -> Unit)? = null,`                            | A callback function that is called when the state of the image changes                                             |
| `alignment: Alignment = Alignment.Center,`                       | The alignment of the image within its parent layout                                                                |
| `contentScale: ContentScale = ContentScale.Fit,`                 | The scaling mode to use when rendering the image. Default to Fit                                                   |
| `alpha: Float = DefaultAlpha,`                                   | The alpha value to apply to the image. Defualt to 1f                                                               |
| `colorFilter: ColorFilter? = null,`                              | A [ColorFilter] to apply to the image                                                                              |
| `filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,` | The quality level to use when applying the color filter. This will impact the quality of the scaling of this image |

ImageBitmap

```kotlin
@Composable
fun ImageSample() {
    val ImageBitmap = createTestImage()
    // Lays out and draws an image sized to the dimensions of the ImageBitmap
    Illustration(bitmap = ImageBitmap, contentDescription = "Localized description")
}
```

ImageVector

```kotlin
@Composable
fun ImageSample() {
    val ImageVector = Icons.Default.Close
    // Lays out and draws an image sized to the dimensions of the ImageVector
    Illustration(imageVector = ImageVector, contentDescription = "Localized description")
}
```

Painter

```kotlin
@Composable
fun ImageSample() {
    val painter = remeberVectorPainter(Icons.Default.Close)
    // Lays out and draws an image sized to the dimensions of the ImageVector
    Illustration(painter = painter, contentDescription = "Localized description")
}
```

Drawable resource

```kotlin
@Composable
fun ImageSample() {
    val drawableRes = remeberVectorPainter(R.drawable.illustration)
    // Lays out and draws an image sized to the dimensions of the ImageVector
    Illustration(drawableRes = drawableRes, contentDescription = "Localized description")
}
```

SparkIcon

```kotlin
@Composable
fun ImageSample() {
    val icon = SparkIcon.Categories.Car
    // Lays out and draws an image sized to the dimensions of the ImageVector
    Illustration(sparkIcon = icon, contentDescription = "Localized description")
}
```