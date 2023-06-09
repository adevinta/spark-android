# Package com.adevinta.spark.components.progress

## Spinner design specs

You can find the design specs
on [spark.adevinta.com](https://spark.adevinta.com/1186e1705/p/7651da-spinner/b/387bf3).

### Spinner

Spinners express an unspecified amount of wait time. They should be used when progress isn’t detectable, or if it’s not necessary to indicate how long an activity will take.

|       | Part                                                                                                                                                                            | Pro                                                                                                                                                                            |
|-------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Light | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnermedium_part_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnermedium_pro_light.png) |
|       | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnersmall_part_light.png)  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnersmall_pro_light.png)  |
| Dark  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnermedium_part_dark.png)  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnermedium_pro_dark.png)  |
|       | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnersmall_part_dark.png)   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_spinner_spinnersmall_pro_dark.png)   |


### Intents

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
