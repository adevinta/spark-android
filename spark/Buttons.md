# Package com.adevinta.spark.components.buttons

# Button components

## Button design specs

You can find the design specs
on [zeroheight.com/25c15666f/](https://zeroheight.com/25c15666f/p/08cff4-button-).

## Usage

### PrimaryButton

| Part Light                                                                                                                                              | Pro Light                                                                                                                                              | Part Dark                                                                                                                                              | Pro Dark                                                                                                                                              |
|---------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_primarybutton_part_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_primarybutton_pro_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_primarybutton_part_dark.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_primarybutton_pro_dark.png) |

```kotlin
@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: (@Composable () -> Unit)? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
    isDanger: Boolean = false,
    content: @Composable RowScope.() -> Unit,
)
```

The primary button should only be used once per view (not including a modal dialog),
these buttons have the most emphasis.

The minimal usage of the component is the text of the button but you can add an icon or indicate a
loading state after a click action for example.

```kotlin
PrimaryButton(onClick = { /*Click event*/ }) {
    Text("Primary")

}
```

| Parameters                               | Descriptions                                                                                                                                               |
|------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `onClick: () -> Unit`                    | The callback to be called when the user click on the button                                                                                                |
| `modifier: Modifier = Modifier`          | Modifier to be applied to the button                                                                                                                       |
| `enabled: Boolean = true`                | True Controls the enabled state of the button. When `false`, this button will not be clickable                                                             |
| `icon: (@Composable () -> Unit)? = null` | The optional icon to be displayed at the start or the end of the button container, you can use [SparkButtonDefaults.IconSize] as a good default icon size. |
| `iconSide: IconSide = IconSide.LEFT`     | If an icon is added, you can configure the side at the start or end of the button                                                                          |
| `isLoading: Boolean = false`             | show or hide a CircularProgressIndicator at the start that push the content to indicate a loading state                                                    |
| `isDanger: Boolean = false`              | The danger button should only be used once per view(screen) (not including a modal dialog), these buttons have the most emphasis.                          |

### All Variants

There are multiple variants of the button with the same parameters:

#### SecondaryButton :

The secondary button is the standard button for most use cases. The outlined styling places less
emphasis on these buttons

| Light                                                                                                                                                | Dark                                                                                                                                                |
|------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_secondarybutton_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_secondarybutton_dark.png) |

#### TextButton:

The text button is the button for non important actions. The mandatory icon help to indicate that
it's a clickable text.

This button has a sub variant that underline the text when no icon is provided.

| Light                                                                                                                                           | Dark                                                                                                                                           |
|-------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_textbutton_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_textbutton_dark.png) |
