# Switch components

## Switch design specs

You can find the design specs
on [zeroheight.com/25c15666f/](https://zeroheight.com/25c15666f/p/54faa9-radio-button-/b/057def).

## Usage

### Switch

| Part Light                                                                                                                                       | Pro Light                                                                                                                                       | Part Dark                                                                                                                                       | Pro Dark                                                                                                                                       |
|--------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switch_part_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switch_pro_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switch_part_dark.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switch_pro_dark.png) |

```kotlin
@Composable
fun Switch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)
```

Switches are the preferred way to adjust settings. They're used to control binary options – think
On/Off or True/False.

- Toggle a single item on or off.
- Immediately activate or deactivate something.

The minimal usage of the component is the radio button in standalone but you can add a content at
the end of the radio or customize it.

```kotlin
var checked by remember { mutableStateOf(true) }
Switch(
    checked = checked,
    onCheckedChange = {
        checked = it
    }
)
```

| Parameters                                                                              | Descriptions                                                                                                                                                                                                                                                                                       |
|-----------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `selected: Boolean`                                                                     | whether or not this component is checked                                                                                                                                                                                                                                                           |
| `onCheckedChange: (() -> Unit)?`                                                        | callback to be invoked when Switch is being clicked, therefore the change of checked state is requested. If null, then this is passive and relies entirely on a higher-level component to control the "checked" state.                                                                             |
| `modifier: Modifier = Modifier`                                                         | A Modifier for this text field                                                                                                                                                                                                                                                                     |
| `enabled: Boolean = true`                                                               | whether the component is enabled or grayed out                                                                                                                                                                                                                                                     |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | the [MutableInteractionSource] representing the stream of [Interaction]s for this Checkbox. You can create and pass in your own remembered [MutableInteractionSource] if you want to observe [Interaction]s and customize the appearance / behavior of this TextField in different [Interaction]s. |

### SwitchLabelled

| Part Light                                                                                                                                               | Pro Light                                                                                                                                               | Part Dark                                                                                                                                               | Pro Dark                                                                                                                                               |
|----------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switchlabelled_part_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switchlabelled_pro_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switchlabelled_part_dark.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_switchlabelled_pro_dark.png) |

```kotlin
@Composable
fun SwitchLabelled(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    startContent: @Composable RowScope.() -> Unit,
)
```

Switches are the preferred way to adjust settings. They're used to control binary options – think
On/Off or True/False.

- Toggle a single item on or off.
- Immediately activate or deactivate something.

The minimal usage of the component is the radio button in standalone but you can add a content at
the end of the radio or customize it.

```kotlin
var checked by remember { mutableStateOf(true) }
SwitchLabelled(
    checked = checked,
    onCheckedChange = {
        checked = it
    }
) {
    Text("Switch On")
}
```

| Parameters                                                                              | Descriptions                                                                                                                                                                                                                                                                                       |
|-----------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `selected: Boolean`                                                                     | whether or not this component is checked                                                                                                                                                                                                                                                           |
| `onCheckedChange: (() -> Unit)?`                                                        | callback to be invoked when Switch is being clicked, therefore the change of checked state is requested. If null, then this is passive and relies entirely on a higher-level component to control the "checked" state.                                                                             |
| `modifier: Modifier = Modifier`                                                         | A Modifier for this text field                                                                                                                                                                                                                                                                     |
| `enabled: Boolean = true`                                                               | whether the component is enabled or grayed out                                                                                                                                                                                                                                                     |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | the [MutableInteractionSource] representing the stream of [Interaction]s for this Checkbox. You can create and pass in your own remembered [MutableInteractionSource] if you want to observe [Interaction]s and customize the appearance / behavior of this TextField in different [Interaction]s. |
| `startContent: @Composable RowScope.() -> Unit,`                                        | The start content displayed before the switch, Usually a Text composable                                                                                                                                                                                                                           |                                                                                                                                                                                                                                                                                                    |

