# CheckBox components

## CheckBox design specs

You can find the design specs
on [zeroheight.com/25c15666f/](https://zeroheight.com/25c15666f/p/72b9ad-checkbox-/b/057def).

## Usage

### CheckBox

| Light                                                                                                                                                                      | Dark                                                                                                                                                                      |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkbox_part_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkbox_part_dark.png) |

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
| `onClick: (() -> Unit)?`                                                                | callback to be invoked when checkbox is being clicked, therefore the change of checked state in requested. If null, then this is passive and relies entirely on a higher-level component to control the "checked" state.                                                                           |
| `modifier: Modifier = Modifier`                                                         | A Modifier for this Checkbox                                                                                                                                                                                                                                                                       |
| `enabled: Boolean = true`                                                               | whether the component is enabled or grayed out                                                                                                                                                                                                                                                     |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | the [MutableInteractionSource] representing the stream of [Interaction]s for this Checkbox. You can create and pass in your own remembered [MutableInteractionSource] if you want to observe [Interaction]s and customize the appearance / behavior of this TextField in different [Interaction]s. |

---

### CheckBoxLabelled

| Light                                                                                                                                                                              | Dark                                                                                                                                                                              |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkboxlabelled_part_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_checkboxlabelled_part_dark.png) |

```kotlin
@Composable
fun CheckboxLabelled(
    state: ToggleableState,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    contentSide: ContentSide = ContentSide.End,
    content: @Composable RowScope.() -> Unit,
)
```

The Checkbox allows users to select one or more items from a set. Checkboxes can turn an option on
or off.

The minimal usage of the component is the checkbox in standalone but you can add a content at the
end of the box or customize it.

```kotlin

import jdk.javadoc.internal.doclets.formats.html.markup.Text

var checkedState by remember { mutableStateOf(ToggleableState.On) }
CheckboxLabelled(
    state = checkedState,
    onClick = {},
) { Text("CheckBox On") }
```

| Parameters                                                                              | Descriptions                                                                                                                                                                                                                                                                                       |
|-----------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `checked: Boolean`                                                                      | whether Checkbox is checked or unchecked                                                                                                                                                                                                                                                           |
| `onClick: (() -> Unit)?`                                                                | callback to be invoked when checkbox is being clicked, therefore the change of checked state in requested. If null, then this is passive and relies entirely on a higher-level component to control the "checked" state.                                                                           |
| `modifier: Modifier = Modifier`                                                         | A Modifier for this text field                                                                                                                                                                                                                                                                     |
| `enabled: Boolean = true`                                                               | whether the component is enabled or grayed out                                                                                                                                                                                                                                                     |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | the [MutableInteractionSource] representing the stream of [Interaction]s for this Checkbox. You can create and pass in your own remembered [MutableInteractionSource] if you want to observe [Interaction]s and customize the appearance / behavior of this TextField in different [Interaction]s. |
| `contentSide: ContentSide = ContentSide.End`                                            | The side where we want to show the label, default to [ContentSide.End].                                                                                                                                                                                                                            |
| `content: @Composable RowScope.() -> Unit`                                              | The content displayed after the checkbox, usually a Text composable shown at the end.                                                                                                                                                                                                              |                                                                                                                                                                                                                                                                                                    |

## Layout

### CheckBoxGroup

> 🚀 TODO
> We plan to provide a layout composable to make it easier to follow the design specs.

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
    onClick: (() -> Unit)
) {
    CheckboxLabelled(
        state = checkedState,
        onClick = onClick,
    ) { Text(option) }
}
```

## Form states 🚀 TODO
