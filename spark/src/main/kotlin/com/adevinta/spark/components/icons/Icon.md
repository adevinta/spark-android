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


Icon component that draws `sparkIcon` using `tint`, defaulting to `LocalContentColor`. For a
clickable icon, see [IconButton](IconButton.kt).

Instead of [SparkIcon](../../../../../../../../../spark-icons/src/main/kotlin/com/adevinta/spark/icons/SparkIcon.kt) you can pass:
- [ImageVector]
- [ImageBitmap]
- [Painter]
-

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
- `IconTints.Current` that uses `LocalContentColor` and is a default tint 
- `IconTints.Unspecified` that applies no tint.

All icons can have the following sizes ([IconSize](IconDefaults.kt)):
- Small (16.dp)
- Medium (24.dp) - default size
- Large (32.dp)
- ExtraLarge (40.dp)
