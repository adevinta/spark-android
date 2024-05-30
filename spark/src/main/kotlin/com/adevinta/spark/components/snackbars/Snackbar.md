# Package com.adevinta.spark.components.snackbars

[Snackbars](https://spark.adevinta.com/1186e1705/p/36d4af-snack-bar--toast/b/380770)
inform users of a process that an app has performed or will perform
They appear temporarily, towards the bottom of the screen.
They should not interrupt the user experience, and they don’t require user input to disappear.
Only one snackbar may be displayed at a time.

```kotlin
@Composable
public fun Snackbar(
    data: SnackbarData,
    modifier: Modifier = Modifier,
    isActionOnNewLine: Boolean = false,
    isDismissIconEnabled: Boolean = false,
    ){}
```

```kotlin
@Composable
public fun Snackbar(
    modifier: Modifier = Modifier,
    intent: SnackbarIntent = SnackbarDefaults.intent,
    style: SnackbarStyle = SnackbarDefaults.style,
    isActionOnNewLine: Boolean = false,
    isDismissIconEnabled: Boolean = false,
    icon: SparkIcon? = null,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    onDismissIconClick: (() -> Unit)? = null,
    content: @Composable (() -> Unit),
    ){}
```

```kotlin
private val snackbarHostState = remember { SnackbarHostState() }

LaunchedEffect(conversationsState) { 
    if (shouldShowSnackbar) { 
        snackbarHostState.showSnackbar(
            message = "Message", 
            duration = SnackbarDuration.Short) 
    }
}
Scaffold (
    snackbarHost = { 
        SnackbarHost(hostState = snackbarHostState) }) {}
```

| Light                                                                                                      | Dark                                                                                                       |
|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.snackbar_SnackbarIntentsScreenshot_snackbarIntentsShowcase__light.png) | ![](../../images/com.adevinta.spark.snackbar_SnackbarIntentsScreenshot_snackbarIntentsShowcase__light.png) |
