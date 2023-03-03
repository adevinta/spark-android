# Snackbar components

## Snackbar design specs

You can find the design specs
on [zeroheight.com/25c15666f/](https://zeroheight.com/25c15666f/p/758346-snackbar-).

## Usage

### Snackbar

| Theme | Default                                                                                                                                                                     | Error                                                                                                                                                                      | Valid                                                                                                                                                                      |
|-------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Light | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[6]_data[bodytitleactionsnackbar]_colors[default]_theme[light].png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[13]_data[bodytitleactionsnackbar]_colors[error]_theme[light].png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[20]_data[bodytitleactionsnackbar]_colors[valid]_theme[light].png) |
| Dark  | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[27]_data[bodytitleactionsnackbar]_colors[default]_theme[dark].png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[34]_data[bodytitleactionsnackbar]_colors[error]_theme[dark].png)  | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[41]_data[bodytitleactionsnackbar]_colors[valid]_theme[dark].png)  |

<details><summary>Default</summary>
<p>

| Theme                        | Light                                                                                                                                                                             | Dark                                                                                                                                                                              |
|------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Body only                    | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[0]_data[bodysnackbar]_colors[default]_theme[light].png)                  | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[21]_data[bodysnackbar]_colors[default]_theme[dark].png)                  |
| Body with action             | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[1]_data[bodyactionsnackbar]_colors[default]_theme[light].png)            | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[22]_data[bodyactionsnackbar]_colors[default]_theme[dark].png)            |
| Body with icon & action      | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[2]_data[bodyiconactionsnackbar]_colors[default]_theme[light].png)        | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[23]_data[bodyiconactionsnackbar]_colors[default]_theme[dark].png)        |
| Body with icon               | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[3]_data[bodyiconsnackbar]_colors[default]_theme[light].png)              | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[24]_data[bodyiconsnackbar]_colors[default]_theme[dark].png)              |
| Body with action on new line | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[4]_data[bodyiconactionnewlinesnackbar]_colors[default]_theme[light].png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[25]_data[bodyiconactionnewlinesnackbar]_colors[default]_theme[dark].png) |
| Body with title              | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[5]_data[bodytitlesnackbar]_colors[default]_theme[light].png)             | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[26]_data[bodytitlesnackbar]_colors[default]_theme[dark].png)             |
| Body with title & action     | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[6]_data[bodytitleactionsnackbar]_colors[default]_theme[light].png)       | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[27]_data[bodytitleactionsnackbar]_colors[default]_theme[dark].png)       |

</p>
</details>

<details><summary>Error</summary>
<p>

| Theme                        | Light                                                                                                                                                                            | Dark                                                                                                                                                                            |
|------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Body only                    | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[7]_data[bodysnackbar]_colors[error]_theme[light].png)                   | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[28]_data[bodysnackbar]_colors[error]_theme[dark].png)                  |
| Body with action             | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[8]_data[bodyactionsnackbar]_colors[error]_theme[light].png)             | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[29]_data[bodyactionsnackbar]_colors[error]_theme[dark].png)            |
| Body with icon & action      | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[9]_data[bodyiconactionsnackbar]_colors[error]_theme[light].png)         | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[30]_data[bodyiconactionsnackbar]_colors[error]_theme[dark].png)        |
| Body with icon               | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[10]_data[bodyiconsnackbar]_colors[error]_theme[light].png)              | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[31]_data[bodyiconsnackbar]_colors[error]_theme[dark].png)              |
| Body with action on new line | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[11]_data[bodyiconactionnewlinesnackbar]_colors[error]_theme[light].png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[32]_data[bodyiconactionnewlinesnackbar]_colors[error]_theme[dark].png) |
| Body with title              | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[12]_data[bodytitlesnackbar]_colors[error]_theme[light].png)             | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[33]_data[bodytitlesnackbar]_colors[error]_theme[dark].png)             |
| Body with title & action     | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[13]_data[bodytitleactionsnackbar]_colors[error]_theme[light].png)       | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[34]_data[bodytitleactionsnackbar]_colors[error]_theme[dark].png)       |

</p>
</details>

<details><summary>Valid</summary>
<p>

| Theme                        | Light                                                                                                                                                                            | Dark                                                                                                                                                                            |
|------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Body only                    | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[14]_data[bodysnackbar]_colors[valid]_theme[light].png)                  | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[35]_data[bodysnackbar]_colors[valid]_theme[dark].png)                  |
| Body with action             | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[15]_data[bodyactionsnackbar]_colors[valid]_theme[light].png)            | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[36]_data[bodyactionsnackbar]_colors[valid]_theme[dark].png)            |
| Body with icon & action      | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[16]_data[bodyiconactionsnackbar]_colors[valid]_theme[light].png)        | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[37]_data[bodyiconactionsnackbar]_colors[valid]_theme[dark].png)        |
| Body with icon               | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[17]_data[bodyiconsnackbar]_colors[valid]_theme[light].png)              | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[38]_data[bodyiconsnackbar]_colors[valid]_theme[dark].png)              |
| Body with action on new line | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[18]_data[bodyiconactionnewlinesnackbar]_colors[valid]_theme[light].png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[39]_data[bodyiconactionnewlinesnackbar]_colors[valid]_theme[dark].png) |
| Body with title              | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[19]_data[bodytitlesnackbar]_colors[valid]_theme[light].png)             | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[40]_data[bodytitlesnackbar]_colors[valid]_theme[dark].png)             |
| Body with title & action     | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[20]_data[bodytitleactionsnackbar]_colors[valid]_theme[light].png)       | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[41]_data[bodytitleactionsnackbar]_colors[valid]_theme[dark].png)       |

</p>
</details>

```kotlin
@ExperimentalSparkApi // It doesn't support the title as we need to redo the Scafold and SnakcbarHost Composable
@Composable
fun Snackbar(
    modifier: Modifier = Modifier,
    actionOnNewLine: Boolean = false,
    colors: SnackbarColors,
    icon: @Composable ((iconModifier: Modifier) -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    actionLabel: String? = null,
    onActionClick: (() -> Unit)? = null,
    content: @Composable (() -> Unit),
)
```

Snackbars inform users of a process that an app has performed or will perform
They appear temporarily, towards the bottom of the screen.
They shouldn’t interrupt the user experience, and they don’t require user input to disappear.

Only one snackbar may be displayed at a time.

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
    scaffoldState = rememberScaffoldState(snackbarHostState),
    snackbarHost = {
        SnackbarHost(it) { data ->
            Snackbar(message = data.message)
        }
    }) { innerPadding ->
    // Content
}

```

| Parameters                                                     | Descriptions                                                                                                       |
|----------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| `modifier: Modifier = Modifier`                                | modifiers for the Snackbar layout                                                                                  |
| `actionOnNewLine: Boolean = false`                             | whether or not action should be put on the separate line. Recommended for action with long action text             |
| `colors: SnackbarColors`                                       | colors used for the background and the content defined in [SnackbarColors], can either be default, error or valid. |
| `icon: @Composable ((iconModifier: Modifier) -> Unit)? = null` | icon to be shown on the start side of the content when there's no title.                                           |
| `title: @Composable (() -> Unit)? = null`                      | title to be shown above the [content], currently the SnackBarHost doesn't handle it so avoid using it              |
| `actionLabel: String? = null`                                  | action to add as an action to the snackbar.                                                                        |
| `onActionClick: (() -> Unit)? = null,`                         | callback when the action is clicked.                                                                               |
| `content: @Composable (() -> Unit)`                            | content to show information about a process that an app has performed or will                                      |

---

### Pre colored Variants 🚀

New composables like SnackbarDefault, SnackbarError, SnackbarValid will be available when you only
show one type of snackbar.
