# Package com.adevinta.spark.components.snackbar

[Snackbars](https://spark.adevinta.com/1186e1705/p/36d4af-snack-bar--toast/b/380770) 
inform users of a process that an app has performed or will perform
They appear temporarily, towards the bottom of the screen.
They shouldn’t interrupt the user experience, and they don’t require user input to disappear.

Only one snackbar may be displayed at a time.

## Usage

### Snackbar

| Light | Dark                                                                                                 |
|-------|------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.snackbar_SnackbarDocScreenshot_snackbarColorsShowcase__light.png) | ![](../../images/com.adevinta.spark.snackbar_SnackbarDocScreenshot_snackbarColorsShowcase__dark.png) |


```kotlin
val snackbarHostState = remember { SnackbarHostState() }
LaunchedEffect(conversationsState) {
    if (shouldShowSnackbar) {
        snackbarHostState.showSnackbar(
            message = "Message",
            duration = SnackbarDuration.Short,
        )
    }
}
Scaffold(
    snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    },
) { innerPadding ->
    // Content
}

```
