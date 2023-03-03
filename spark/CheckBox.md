# CheckBox components

## CheckBox design specs

You can find the design specs
on [zeroheight.com/25c15666f/](https://zeroheight.com/25c15666f/p/72b9ad-checkbox-/b/057def).

## Usage

### CheckBox

| Part Light                                                                                                                                         | Pro Light                                                                                                                                         | Part Dark                                                                                                                                         | Pro Dark                                                                                                                                         |
|----------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkbox_part_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkbox_pro_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkbox_part_dark.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkbox_pro_dark.png) |

```kotlin
@Composable
fun Checkbox(
    state: Boolean,
    onCheckedChange: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)
```

Checkboxes allows users to select one or more items from a set. Checkboxes can turn an option on or
off.

- Toggle a single item on or off.
- Require another action to activate or deactivate something.

The minimal usage of the component is the checkbox in standalone but you can add a content at the
end of the box or customize it.

```kotlin
var checkedState by remember { mutableStateOf(ToggleableState.On) }
Checkbox(
    state = checkedState,
    onCheckedChange = {
        isChecked = !isChecked
    }
)
```

| Parameters                                                                              | Descriptions                                                                                                                                                                                                                                                                                       |
|-----------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `checked: Boolean`                                                                      | whether Checkbox is checked or unchecked                                                                                                                                                                                                                                                           |
| `onCheckedChange: (() -> Unit)?`                                                        | callback to be invoked when checkbox is being clicked, therefore the change of checked state in requested. If null, then this is passive and relies entirely on a higher-level component to control the "checked" state.                                                                           |
| `modifier: Modifier = Modifier`                                                         | A Modifier for this text field                                                                                                                                                                                                                                                                     |
| `enabled: Boolean = true`                                                               | whether the component is enabled or grayed out                                                                                                                                                                                                                                                     |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | the [MutableInteractionSource] representing the stream of [Interaction]s for this Checkbox. You can create and pass in your own remembered [MutableInteractionSource] if you want to observe [Interaction]s and customize the appearance / behavior of this TextField in different [Interaction]s. |

---

### CheckBoxLabelled

| Part Light                                                                                                                                                 | Pro Light                                                                                                                                                 | Part Dark                                                                                                                                                 | Pro Dark                                                                                                                                                 |
|------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkboxlabelled_part_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkboxlabelled_pro_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkboxlabelled_part_dark.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkboxlabelled_pro_dark.png) |

```kotlin
@Composable
fun CheckboxLabelled(
    state: Boolean,
    onCheckedChange: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    endContent: @Composable RowScope.() -> Unit,
)
```

The Checkbox allows users to select one or more items from a set. Checkboxes can turn an option on
or off.

The minimal usage of the component is the checkbox in standalone but you can add a content at the
end of the box or customize it.

```kotlin
var checkedState by remember { mutableStateOf(ToggleableState.On) }
CheckboxLabelled(
    state = checkedState,
    onCheckedChange = {},
) { Text("CheckBox On") }
```

| Parameters                                                                              | Descriptions                                                                                                                                                                                                                                                                                       |
|-----------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `checked: Boolean`                                                                      | whether Checkbox is checked or unchecked                                                                                                                                                                                                                                                           |
| `onCheckedChange: (() -> Unit)?`                                                        | callback to be invoked when checkbox is being clicked, therefore the change of checked state in requested. If null, then this is passive and relies entirely on a higher-level component to control the "checked" state.                                                                           |
| `modifier: Modifier = Modifier`                                                         | A Modifier for this text field                                                                                                                                                                                                                                                                     |
| `enabled: Boolean = true`                                                               | whether the component is enabled or grayed out                                                                                                                                                                                                                                                     |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | the [MutableInteractionSource] representing the stream of [Interaction]s for this Checkbox. You can create and pass in your own remembered [MutableInteractionSource] if you want to observe [Interaction]s and customize the appearance / behavior of this TextField in different [Interaction]s. |
| `endContent: @Composable RowScope.() -> Unit,`                                          | The end content displayed after the checkbox, Usually a Text composable                                                                                                                                                                                                                            |                                                                                                                                                                                                                                                                                                    |

### CheckBoxGroup

```kotlin
@Composable
fun CheckboxSample() {
    Column {
        // define dependent checkboxes states
        val (state, onStateChange) = remember { mutableStateOf(ToggleableState.On) }
        val (state2, onStateChange2) = remember { mutableStateOf(ToggleableState.On) }

        // TriStateCheckbox state reflects state of dependent checkboxes
        val parentState = remember(state, state2) {
            if (state && state2) ToggleableState.On
            else if (!state && !state2) ToggleableState.Off
            else ToggleableState.Indeterminate
        }
        // click on TriStateCheckbox can set state for dependent checkboxes
        val onParentClick = {
            val s = parentState != ToggleableState.On
            onStateChange(s)
            onStateChange2(s)
        }

        Option(
            state = parentState,
            onClick = onParentClick,
        )
        Column(modifier = Modifier.selectableGroup()) {
            Option(state, onStateChange)
            Option(state2, onStateChange2)
        }
    }
}

@Composable
fun Option(
    option: String,
    onCheckedChange: (() -> Unit)
) {
    CheckboxLabelled(
        state = checkedState,
        onCheckedChange = onCheckedChange,
    ) { Text(option) }
}
```
