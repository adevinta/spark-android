# Package com.adevinta.spark.components.progress

## Spinner design specs

You can find the design specs
on [spark.adevinta.com](https://spark.adevinta.com/1186e1705/p/7651da-spinner/b/387bf3).

## Usage

Spinners provide a visual clue that an action is processing awaiting a course of change or a result.

### Styles

|       | Part                                                                                                                                                                            | Pro                                                                                                                                                                            |
|-------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Light | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnermedium_part_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnermedium_pro_light.png) |
|       | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnersmall_part_light.png)  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnersmall_pro_light.png)  |
| Dark  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnermedium_part_dark.png)  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnermedium_pro_dark.png)  |
|       | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnersmall_part_dark.png)   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnersmall_pro_dark.png)   |

```kotlin
@Composable
fun Spinner(
    intent: SpinnerIntent,
    modifier: Modifier = Modifier,
    size: SpinnerSize = SpinnerDefaults.CircularSize,
    isBackgroundVisible: Boolean = false,
)
```

| Parameters                                         | Descriptions                                                                          |
|----------------------------------------------------|---------------------------------------------------------------------------------------|
| `intent: SpinnerIntent`                            | One of [SpinnerIntent](SpinnerIntent.kt) colors that will be used to draw the spinner |
| `modifier: Modifier = Modifier`                    | Modifier to be applied to this badge                                                  |                                                                                                                     |
| `size: SpinnerSize = SpinnerDefaults.CircularSize` | one of the [SpinnerSize](SpinnerDefaults.kt) that defines the size of the component   |
| `isBackgroundVisible: Boolean = false`             | whether a background should be drawn                                                  |

### Style

A visible background may be added to display a background behind the spinner.

All intents from Spark are available for this component ([SpinnerIntent](SpinnerIntent.kt)).
- Primary
- Secondary
- Surface
- Success
- Alert
- Danger
- Info
- Neutral

The spinner has two sizes ([SpinnerSize](SpinnerDefaults.kt)):
- Small (20.dp)
- Medium (28.dp)
