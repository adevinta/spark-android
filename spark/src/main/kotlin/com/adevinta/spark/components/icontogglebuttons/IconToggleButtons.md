# Package com.adevinta.spark.components.icontogglebuttons

[IconToggleButtons](https://spark.adevinta.com/1186e1705/p/2352e9-icon-button/b/32e1a2) take supplementary
actions with a single tap. They’re used when a compact button is required, such as in a toolbar or
image list.

### Styles

Icon toggle buttons come in various styles:

- Filled
- Tinted
- Outlined
- Contrast
- Ghost

|       | Filled                                                                                                                           | Outlined                                                                                                                           | Tinted                                                                                                                           | Ghost                                                                                                                           | Contrast                                                                                                                           |
|-------|----------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| Light | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttonfilledsmall_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttonoutlinedsmall_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttontintedsmall_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttonghostsmall_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttoncontrastsmall_light.png) |
| Dark  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttonfilledsmall_dark.png)  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttonoutlinedsmall_dark.png)  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttontintedsmall_dark.png)  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttonghostsmall_dark.png)  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttoncontrastsmall_dark.png)  |

### Sizes

Icon toggle buttons come in 3 sizes [IconToggleButtonSize](IconToggleButtonSize.kt):

- small - 32.dp (however, the minimum touch size is applied and is 44.dp)
- medium - 44.dp (default)
- large - 56.dp

The content icon is 16.dp for `IconToggleButtonSize.Small` and `IconToggleButtonSize.Medium`, and 24.dp
for `IconToggleButtonSize.Large`
![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebuttons_icontogglebuttons_light.png)

### Intents

Icon Toggle Buttons support all intents:
- Basic (default)
- Accent
- Main
- Support
- Success
- Alert
- Danger
- Info
- Neutral
- Surface

#### IconToggleButtonFilled

Filled icon toggle buttons are the standard for most use cases. The filled styling places the most
emphasis and should be used for important actions.

```kotlin
fun IconToggleButtonFilled(
    icon: SparkIcon,
    onClick: () -> Unit,
)
```

| Light                                                                                                                  | Dark                                                                                                                  |
|------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttonfilledsmall_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttonfilledsmall_dark.png) |

#### IconToggleButtonOutlined

Outlined icon toggle buttons are used for support actions. The outlined styling places less emphasis on these
actions that are important but not the main ones.

Be aware that it's not advised to use it on top of images since it will be hard to see.

```kotlin
fun IconToggleButtonOutlined(
    icon: SparkIcon,
    onClick: () -> Unit,
)
```

| Light                                                                                                                    | Dark                                                                                                                    |
|--------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttonoutlinedsmall_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttonoutlinedsmall_dark.png) |

#### IconToggleButtonTinted

Tinted icon toggle buttons are medium-emphasis buttons that is an alternative middle ground between
default filled icon toggl buttons and outlined icon toggl buttons. They can be used in contexts where lower-priority
icon button requires slightly more emphasis than an outline would give.

```kotlin
fun IconToggleButtonTinted(
    icon: SparkIcon,
    onClick: () -> Unit,
)
```

| Light                                                                                                                  | Dark                                                                                                                  |
|------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttontintedsmall_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttontintedsmall_dark.png) |

#### IconToggleButtonGhost

Ghost icon toggl buttons are used for the lowest priority actions, especially when presenting multiple options.

Ghost icon toggl buttons can be placed on a variety of backgrounds. Until the button is interacted with, its
container isn’t visible.
This button style is often used inside other components like snackbars, dialogs, and cards.

```kotlin
fun IconToggleButtonGhost(
    icon: SparkIcon,
    onClick: () -> Unit,
)
```

| Light                                                                                                                 | Dark                                                                                                                 |
|-----------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttonghostsmall_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttonghostsmall_dark.png) |

#### IconToggleButtonContrast

Contrast icon toggle buttons are used for the high to mid priority actions when the background is dark like on
an image or a video.

```kotlin
fun IconToggleButtonContrast(
    icon: SparkIcon,
    onClick: () -> Unit,
)
```

| Light                                                                                                                    | Dark                                                                                                                    |
|--------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttoncontrastsmall_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_icontogglebutton_icontogglebuttoncontrastsmall_dark.png) |
