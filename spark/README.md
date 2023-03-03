<p align="center">
  <img
    width="300px"
    src="art/brikke-logo.webp"
    alt="Spark Design System logo" />
</p>

# Spark Design System

Compose Spark Design System is based on Material 3 compose artifact described
on the [official documentation](https://material.io/) and maintained by Google developers
and designers.

But these native components are overridden to respect Spark's Visual Identity. You'll find
the design specifications and technical information for supported platforms by Adevinta on
[zeroheight.com/25c15666f/](https://zeroheight.com/25c15666f/).

The demo app is accessible from the `Tools` app at the bottom of the list. It's currently
generated with ShowKase but will be

## 🚀 Getting Started

A `SparkTheme` is available from where you can get all
colors, typographies and shapes in your composable hierarchy. Note that this theme is
mandatory if you want to use any composable available.
If you don't use it, an error will be triggered at the runtime.

```kotlin
SparkTheme {
    // Your composable declarations
}
```

## [Tokens](./Tokens.md)

## Composables

### [Buttons](./Buttons.md)

Buttons guides the user to the actions he can do in the app

[![](../spark-screenshot-testing/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_primarybutton_part_light.png)
](./Buttons.md)

### [TextFields](./TextFields.md)

Buttons guides the user to the actions he can do in the app

<img height="400" src="../spark-screenshot-testing/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_textfields_textfield_light.png"/>

### Toggles

Buttons guides the user to the actions he can do in the app

| [CheckBox](./CheckBox.md)                                                                                                                                               | [RadioButton](./RadioButton.md)                                                                                                                                               | [Switch](./Switch.md)                                                                                                                                               |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [![](../spark-screenshot-testing/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkboxlabelled_part_light.png)](./CheckBox.md) | [![](../spark-screenshot-testing/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_radiobuttonlabelled_part_light.png)](./RadioButton.md) | [![](../spark-screenshot-testing/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switchlabelled_part_light.png)](./Switch.md) |
| Allows user to choose between some options and one or several can be checked                                                                                            | Allows user to choose between some options and only one can be selected                                                                                                       | Allows user to activate or deactivate an option immediately                                                                                                         |

### [Snackbar](./Snackbar.md)

Snackbars inform users of a process that an app has performed or will perform.

[![](../spark-screenshot-testing/test/snapshots/images/com.adevinta.spark_SnackbarScreenshot_SnackBar[1]_data[bodyactionsnackbar]_colors[default]_theme[light].png)
](./Snackbar.md)

### [ProgressIndicators](./ProgressIndicators.md)

Progress indicators displays the length of a process.

[![](../spark-screenshot-testing/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_progressindicator_linearprogressindicator_part_light.png)
](./ProgressIndicators.md)

### [Ratings](./Ratings.md)

The rating element is essentially used to evaluate a product, service, or experience.

[![](../spark-screenshot-testing/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_ratings_ratingsmall_part_light.png)
](./Ratings.md)

## 🛠 Tooling

### Detekt rules

1. Add the Detekt [Intelij Plugin](https://plugins.jetbrains.com/plugin/10761-detekt)
2. Download the latest [Compose rules](https://github.com/twitter/compose-rules/releases/latest)
   from Twitter
3. In `Settings` -> `Tools` -> `Detekt`

    - Add in `Plugin Jar's` the previously downloaded Compose rule detekt plugin
    - Add in `Configuration Files` the config located in `android-app/detekt/detekt-config.yml`
    - Uncheck everything except `Enable Detekt` and `Enalble formatting (ktlin) rules`
