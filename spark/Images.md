# Image components

## Image design specs

You can find the design specs
on [zeroheight.com/25c15666f/](https://zeroheight.com/25c15666f/p/54faa9-radio-button-/b/057def).

## Usage

The `Image` function uses the `SubcomposeAsyncImage` from the Coil library internally to
asynchronously load and display the image.

- If the image is not yet available or we tried to load it without data, an empty icon is displayed.
- If the image could not be loaded, an error icon is displayed.
- If we're waiting for the image a loading placeholder with a shimmer effect is displayed.

### Image

[//]: # (Add an exemple images with the different states)

```kotlin
@Composable
fun Image(
    model: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    onState: ((State) -> Unit)? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,
)
```

The minimal usage of the component is model (either url/uri or Coil Request Builder) with a
content description. That describe the content of this image.

```kotlin
Image(
    model = "https://example.com/image.jpg",
    contentDescription = "An image of a cat",
    modifier = Modifier.size(200.dp),
    onState = { state ->
        when (state) {
            is State.Loading -> { /* Show a loading text*/
            }
            is State.Error -> { /* Show an error message*/
            }
            is State.Success -> { /* do nothing*/
            }
        }
    },
    alignment = Alignment.Center,
    contentScale = ContentScale.Crop,
    alpha = 0.8f,
    colorFilter = ColorFilter.tint(Color.Red),
    filterQuality = FilterQuality.Low,
)
```

| Parameters                                                       | Descriptions                                                                                                                                                                                                                                                                                                                                |
|------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `model: Any?,`                                                   | An object representing the image to be displayed. This can be a URL, a file, or any other type of object that can be used to identify the image                                                                                                                                                                                             |
| `contentDescription: String?,`                                   | text used by accessibility services to describe what this image represents. This should always be provided unless this image is used for decorative purposes, and does not represent a meaningful action that a user can take. This text should be localized, such as by using [androidx.compose.ui.res.stringResource] or from the backend |
| `modifier: Modifier = Modifier,`                                 | Modifier used to adjust the layout algorithm or draw decoration content (ex.background)                                                                                                                                                                                                                                                     |
| `onState: ((State) -> Unit)? = null,`                            | A callback function that is called when the state of the image changes                                                                                                                                                                                                                                                                      |
| `alignment: Alignment = Alignment.Center,`                       | Optional alignment parameter used to place the image in the given bounds defined by the width and height                                                                                                                                                                                                                                    |
| `contentScale: ContentScale = ContentScale.Fit,`                 | Optional scale parameter used to determine the aspect ratio scaling to be used if the bounds are a different size from the intrinsic size of the image                                                                                                                                                                                      |
| `alpha: Float = DefaultAlpha,`                                   | Optional opacity to be applied to the image when it is rendered onscreen. Default to 1f.                                                                                                                                                                                                                                                    |
| `colorFilter: ColorFilter? = null,`                              | Optional ColorFilter to apply for the image when it is rendered onscreen                                                                                                                                                                                                                                                                    |
| `filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,` | Sampling algorithm applied to the image when it is scaled and drawn  into the destination. The default is [FilterQuality.Low] which scales using a bilinear sampling algorithm                                                                                                                                                              |