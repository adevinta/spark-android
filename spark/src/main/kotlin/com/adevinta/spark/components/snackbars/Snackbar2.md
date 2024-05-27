package com.adevinta.spark.components.snackbars

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
  ) {
  // Implementation details...
  }

/**
* Snackbar component with support for various styles and intents.
*
* @param data The SnackbarData to display.
* @param modifier Modifier to apply to the Snackbar.
* @param isActionOnNewLine Whether the action is displayed on a new line.
* @param isDismissIconEnabled Whether the dismiss icon is enabled.
  */
  @Composable
  public fun Snackbar(
  data: SnackbarData,
  modifier: Modifier = Modifier,
  isActionOnNewLine: Boolean = false,
  isDismissIconEnabled: Boolean = false,
  ) {
  // Implementation details...
  }

/**
* SnackbarSparkVisuals is a class that implements SnackbarVisuals and adds additional properties for the SparkSnackbar.
*
* @param message The message to display in the Snackbar.
* @param icon Optional icon to display in the Snackbar.
* @param intent The intent of the Snackbar.
* @param style The style of the Snackbar.
* @param actionLabel Label for the action button.
* @param withDismissAction Whether the dismiss action is enabled.
* @param duration The duration for which the Snackbar is displayed.
  */
  public class SnackbarSparkVisuals(
  override val message: String,
  public val icon: SparkIcon? = null,
  public val intent: SnackbarIntent = SnackbarDefaults.intent,
  public val style: SnackbarStyle = SnackbarDefaults.style,
  override val actionLabel: String? = null,
  override val withDismissAction: Boolean = false,
  override val duration: SnackbarDuration = SnackbarDuration.Short,
  ) : SnackbarVisuals
