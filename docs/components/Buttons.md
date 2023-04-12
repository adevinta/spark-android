# Button components

## Button design specs

You can find the design specs
on [spark.adevinta.com](https://spark.adevinta.com/1186e1705/p/34b742-button/b/32e1a2).

## Usage

### Styles

|       | Filled                                                                                                                                                      | Outlined                                                                                                                                                      | Tinted                                                                                                                                                      | Ghost                                                                                                                                                      | Contrast                                                                                                                                                      |
|-------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Light | ![](../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonfilledintents_light.png) | ![](../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonoutlinedintents_light.png) | ![](../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttontintedintents_light.png) | ![](../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonghostintents_light.png) | ![](../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttoncontrastintents_light.png) |
| Dark  | ![](../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonfilledintents_dark.png)  | ![](../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonoutlinedintents_dark.png)  | ![](../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttontintedintents_dark.png)  | ![](../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonghostintents_dark.png)  | ![](../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttoncontrastintents_dark.png)  |

### Sizes

![](../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonsizes_light.png)

```kotlin
@Composable
fun ButtonFilled(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.Medium,
    intent: ButtonIntent = ButtonIntent.Primary,
    enabled: Boolean = true,
    icon: SparkIcon? = null,
    iconSide: IconSide = IconSide.START,
    isLoading: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)
```

The minimal usage of the component is the text and the click action.

```kotlin
ButtonFilled(
    text = "Primary",
    onClick = { /*Click event*/ },
)
```

The buttons have an loading state that can be used to indicate that the button is loading some
data and show/hide an indeterminate circular progress indicator on the start of the button.

![](../../art/components/button/loading-button.gif)

| Parameters                                                                              | Descriptions                                                                                                                                                                                                                                                    |
|-----------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `onClick: () -> Unit`                                                                   | The callback to be called when the user click on the button                                                                                                                                                                                                     |
| `text: String or AnnotatedString`                                                       | The text to be displayed in the button                                                                                                                                                                                                                          | Modifier to be applied to the button                                                                                                                       |
| `size: ButtonSize = ButtonSize.Medium`                                                  | The size of the button                                                                                                                                                                                                                                          |
| `intent: ButtonIntent = ButtonIntent.Primary`                                           | The intent color for the button.                                                                                                                                                                                                                                |
| `enabled: Boolean = true`                                                               | True Controls the enabled state of the button. When `false`, this button will not be clickable                                                                                                                                                                  |
| `icon: (@Composable () -> Unit)? = null`                                                | The optional icon to be displayed at the start or the end of the button container.                                                                                                                                                                              |
| `iconSide: IconSide = IconSide.LEFT`                                                    | If an icon is added, you can configure the side at the start or end of the button                                                                                                                                                                               |
| `isLoading: Boolean = false`                                                            | show or hide a CircularProgressIndicator at the start that push the content to indicate a loading state                                                                                                                                                         |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | the **MutableInteractionSource** representing the stream of **Interaction**s for this button. You can create and pass in your own `remember`ed instance to observe **Interaction**s and customize the appearance / behavior of this button in different states. |

### All Styles

There are multiple style variants for the button with the same parameters:

#### ButtonFilled

Filled buttons are the standard button for most use cases. The filled styling places the most
emphasis and should be used for important, final actions.

```kotlin
ButtonFilled(
    text = "Primary",
    onClick = { /*Click event*/ },
)
```

| Light                                                                                                                                                 | Dark                                                                                                                                                 |
|-------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonfilled_light.png) | ![](../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonfilled_dark.png) |

#### ButtonOutlined

Outlined buttons are used for secondary actions. The outlined styling places less emphasis on these
actions that are important but not the primary ones.
It is recommended to pair it with a button wit more emphasis like the filled button or the tinted
button.

Be aware that it's not advised to use it on top of images since it will be hard to see.

```kotlin
ButtonOutlined(
    text = "Primary",
    onClick = { /*Click event*/ },
)
```

| Light                                                                                                                                                   | Dark                                                                                                                                                   |
|---------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonoutlined_light.png) | ![](../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonoutlined_dark.png) |

#### ButtonTinted

Tinted buttons are medium-emphasis buttons that is an alternative middle ground between
default Buttons (filled) and Outlined buttons. They can be used in contexts where lower-priority
button requires slightly more emphasis than an outline would give, such as "Next" in an onboarding
flow.

It's best paired with either a filled button or a outlined button.

```kotlin
ButtonTinted(
    text = "Primary",
    onClick = { /*Click event*/ },
)
```

| Light                                                                                                                                                 | Dark                                                                                                                                                 |
|-------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttontinted_light.png) | ![](../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttontinted_dark.png) |

#### ButtonGhost

Ghost buttons are used for the lowest priority actions, especially when presenting multiple options.

Ghost buttons can be placed on a variety of backgrounds. Until the button is interacted with, its
container isn’t visible.
This button style is often used inside other components like snackbars, dialogs, and cards.

```kotlin
ButtonGhost(
    text = "Primary",
    onClick = { /*Click event*/ },
)
```

| Light                                                                                                                                                | Dark                                                                                                                                                |
|------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonghost_light.png) | ![](../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonghost_dark.png) |

#### ButtonContrast

Contrast buttons are used for the high to mid priority actions when the background is dark like on
an image or a video.

```kotlin
ButtonContrast(
    text = "Primary",
    onClick = { /*Click event*/ },
)
```

| Light                                                                                                                                                   | Dark                                                                                                                                                   |
|---------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttoncontrast_light.png) | ![](../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttoncontrast_dark.png) |
