# Package com.adevinta.spark.components.toggles

## Switch design specs

You can find the design specs
on [spark.adevinta.com](https://spark.adevinta.com/1186e1705/p/58a2c6-switch/b/700a17).

### Switch

Switches can be used in forms on a full page, in modals, or on side panels.
They can be used in a list but we shouldn’t mix them with other components such as [Checkboxes](./CheckBox.md) or
[Radio buttons](./RadioButton.md).

Switches must respect the established color code and not use other colors to emphasize the
activation and deactivation of a functionality or service.

Switch component allows the user to activate or deactivate the state of an element or concept.
It is usually used as an element to add services, activate functionalities or adjust settings.
It is also used to control binary options (On/Off or True/False).

| Light                                                                                                                                                                    | Dark                                                                                                                                                                    |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switch_part_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switch_part_dark.png) |

### SwitchLabelled

|      | Light                                                                                                                                                                            | Dark                                                                                                                                                                            |
|------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Part | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switchlabelled_part_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switchlabelled_part_dark.png) |
| Pro  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switchlabelled_pro_light.png)  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switchlabelled_pro_dark.png)  |

The minimal usage of the component is a standalone checkbox but you can add a label
using [SwitchLabelled](Switch.kt).
Please refer to design specs to find what content is accepted.

- An icon can be added on the left or right of label.
- A caption can be added in different positions of the label in order to to expand the information.

```kotlin
var checked by remember { mutableStateOf(false) }
SwitchLabelled(
    checked = checked,
    onCheckedChange = {
        checked = !checked
    }
) { Text(text = "Switch On") }
```

## Layout
- The Switch respects the minimum touch size.
- Switch labels can be positioned at the Left or the Right, but usually the left position is more often used on small screens and mobile devices.

### SwitchGroup

> 🚀 TODO
> We plan to provide a layout composable to make it easier to follow the design specs.
