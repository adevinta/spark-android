# Icon components

## Icon design specs

You can find the design specs on [spark.adevinta.com](https://spark.adevinta.com/1186e1705/p/11373f-icon/b/80bf01).

## Usage

This component is the wrapper of the icons that you can find in Spark Foundations.

### Styles

|       | Colors and sizes                                                                                                                                               |
|-------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Light | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icon_icon_light.png) |
| Dark  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icon_icon_dark.png)  |

```kotlin
@Composable
public fun Icon(
    sparkIcon: SparkIcon,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: IconTints = IconDefaults.color,
    size: IconSize = IconDefaults.size,
)
```

| Parameters                             | Descriptions                                                                      |
|----------------------------------------|-----------------------------------------------------------------------------------|
| `sparkIcon: SparkIcon`                 | [SparkIcon] to draw inside this Icon                                              |
| `contentDescription: String?`          | text used by accessibility services to describe what this icon represents         |
| `modifier: Modifier = Modifier`        | optional modifier [Modifier] to be applied to this icon                           |                                                                                                                     |
| `tint: IconTints = IconDefaults.color` | tint to be applied to [sparkIcon]. If no tint is provided, then a default is used |
| `size: IconSize = IconDefaults.size`   | one of [IconSize] to be applied as size of the icon                               |

Icon component that draws [sparkIcon] using [tint], defaulting to [LocalContentColor]. For a
clickable icon, see [IconButton].

Instead of [SparkIcon] you can pass:
- [ImageVector]
- [ImageBitmap]
- [Painter]

```kotlin
@Composable
public fun Icon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: IconTints = IconDefaults.color,
    size: IconSize = IconDefaults.size,
)
```

| Parameters                             | Descriptions                                                                        |
|----------------------------------------|-------------------------------------------------------------------------------------|
| `imageVector: ImageVector`             | [ImageVector] to draw inside this Icon                                              |
| `contentDescription: String?`          | text used by accessibility services to describe what this icon represents           |
| `modifier: Modifier = Modifier`        | optional modifier [Modifier] to be applied to this icon                             |                                                                                                                     |
| `tint: IconTints = IconDefaults.color` | tint to be applied to [imageVector]. If no tint is provided, then a default is used |
| `size: IconSize = IconDefaults.size`   | size one of [IconSize] to be applied as size of the icon                            |

```kotlin
@Composable
public fun Icon(
    bitmap: ImageBitmap,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: IconTints = IconDefaults.color,
    size: IconSize = IconDefaults.size,
)
```

| Parameters                             | Descriptions                                                                   |
|----------------------------------------|--------------------------------------------------------------------------------|
| `bitmap: ImageBitmap`                  | [ImageBitmap] to draw inside this Icon                                         |
| `contentDescription: String?`          | text used by accessibility services to describe what this icon represents      |
| `modifier: Modifier = Modifier`        | optional modifier [Modifier] to be applied to this icon                        |                                                                                                                     |
| `tint: IconTints = IconDefaults.color` | tint to be applied to [bitmap]. If no tint is provided, then a default is used |
| `size: IconSize = IconDefaults.size`   | size one of [IconSize] to be applied as size of the icon                       |

```kotlin
@Composable
public fun Icon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: IconTints = IconDefaults.color,
    size: IconSize = IconDefaults.size,
)
```

| Parameters                             | Descriptions                                                                    |
|----------------------------------------|---------------------------------------------------------------------------------|
| `painter: Painter`                     | [Painter] to draw inside this Icon                                              |
| `contentDescription: String?`          | text used by accessibility services to describe what this icon represents       |
| `modifier: Modifier = Modifier`        | optional modifier [Modifier] to be applied to this icon                         |                                                                                                                     |
| `tint: IconTints = IconDefaults.color` | tint to be applied to [painter]. If no tint is provided, then a default is used |
| `size: IconSize = IconDefaults.size`   | size one of [IconSize] to be applied as size of the icon                        |


### Style

All icons accept 7 intents as tints:
- Primary
- Secondary
- Surface
- Success
- Alert
- Danger
- Neutral

as well as 
- `IconTints.Current` that uses [LocalContentColor] and is a default tint 
- `IconTints.Unspecified` that applies no tint.

All icons can have the following sizes:
- Small (16.dp)
- Medium (24.dp) - default size
- Large (32.dp)
- ExtraLarge (40.dp)
