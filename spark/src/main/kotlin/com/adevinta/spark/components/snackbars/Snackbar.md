# Package com.adevinta.spark.components.snackbars

[Snackbars](https://spark.adevinta.com/1186e1705/p/36d4af-snack-bar--toast/b/380770)

/**
* SparkSnackbar is a custom Snackbar component that supports various styles and intents.
*
* @param intent The intent of the Snackbar.
* @param style The style of the Snackbar.
* @param isActionOnNewLine Whether the action is displayed on a new line.
* @param isDismissIconEnabled Whether the dismiss icon is enabled.
* @param modifier Modifier to apply to the Snackbar.
* @param icon Optional icon to display in the Snackbar.
* @param actionLabel Label for the action button.
* @param onActionClick Callback for action button click.
* @param onDismissIconClick Callback for dismiss icon click.
* @param content Content to display inside the Snackbar.
  */

```kotlin
  @Composable
  @InternalSparkApi
  public fun SparkSnackbar(
  intent: SnackbarIntent,
  style: SnackbarStyle,
  isActionOnNewLine: Boolean,
  isDismissIconEnabled: Boolean,
  modifier: Modifier = Modifier,
  icon: SparkIcon? = null,
  actionLabel: String? = null,
  onActionClick: (() -> Unit)? = null,
  onDismissIconClick: (() -> Unit)? = null,
  content: @Composable () -> Unit,
  ) {}
```
/**
* Snackbar component with support for various styles and intents.
*
* @param data The SnackbarData to display.
* @param modifier Modifier to apply to the Snackbar.
* @param isActionOnNewLine Whether the action is displayed on a new line.
* @param isDismissIconEnabled Whether the dismiss icon is enabled.
  */

```kotlin
  @Composable
  public fun Snackbar(
  data: SnackbarData,
  modifier: Modifier = Modifier,
  isActionOnNewLine: Boolean = false,
  isDismissIconEnabled: Boolean = false,
  ) {
  content {}
  }
```


| Light                                                                                                      | Dark                                                                                                       |
|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.snackbar_SnackbarIntentsScreenshot_snackbarIntentsShowcase__light.png) | ![](../../images/com.adevinta.spark.snackbar_SnackbarIntentsScreenshot_snackbarIntentsShowcase__light.png) |
