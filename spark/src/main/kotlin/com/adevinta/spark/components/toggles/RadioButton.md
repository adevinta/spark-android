# Package com.adevinta.spark.components.toggles

## RadioButton design specs

You can find the design specs
on [spark.adevinta.com](https://spark.adevinta.com/1186e1705/p/98058f-radio-button/b/700a17).

## Usage

### RadioButton

| Light                                                                                                                                                                         | Dark                                                                                                                                                                         |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_radiobutton_part_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_radiobutton_part_dark.png) |

```kotlin
@Composable
fun RadioButton(
    selected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)
```

The primary radio button allow users to select one option from a set.

- Use radio buttons to select a single option from a list
- It should be visible at a glance if a radio button has been selected, and selected items should be
  more visually prominent than unselected items.
- Present a list showing all available options. If available options can be collapsed, consider
  using a dropdown menu because it uses less space.

The minimal usage of the component is the radio button in standalone but you can add a content at
the end of the radio or customize it.

```kotlin
var selected by remember { mutableStateOf(true) }
RadioButton(
    selected = selected,
    onClick = {
        selected = !selected
    }
)
```

| Parameters                                                                              | Descriptions                                                                                                                                                                                                                                                                                            |
|-----------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `selected: Boolean`                                                                     | whether this radio button is selected or not                                                                                                                                                                                                                                                            |
| `onClick: (() -> Unit)?`                                                                | callback to be invoked when the RadioButton is clicked. If null, then this RadioButton will not handle input events, and only act as a visual indicator of selected state                                                                                                                               |
| `modifier: Modifier = Modifier`                                                         | A Modifier for this RadioButton                                                                                                                                                                                                                                                                         |
| `enabled: Boolean = true`                                                               | whether the component is enabled or grayed out                                                                                                                                                                                                                                                          |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | the [MutableInteractionSource] representing the stream of [Interaction]s for this RadioButton. You can create and pass in your own remembered [MutableInteractionSource] if you want to observe [Interaction]s and customize the appearance / behavior of this RadioButton in different [Interaction]s. |

---

### CheckBoxLabelled

| Light                                                                                                                                                                                 | Dark                                                                                                                                                                                 |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_radiobuttonlabelled_part_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_toggles_radiobuttonlabelled_part_dark.png) |

```kotlin
@Composable
public fun RadioButtonLabelled(
    selected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    contentSide: ContentSide = ContentSide.End,
    content: @Composable RowScope.() -> Unit,
)
```

The primary radio button allow users to select one option from a set.

- Use radio buttons to select a single option from a list
- It should be visible at a glance if a radio button has been selected, and selected items should be
  more visually prominent than unselected items.
- Present a list showing all available options. If available options can be collapsed, consider
  using a dropdown menu because it uses less space.

The minimal usage of the component is the radiobutton in standalone but you can add a content at the
end of the box or customize it.

```kotlin
var selected by remember { mutableStateOf(true) }
RadioButtonLabelled(
    selected = selected,
    onClick = {
        selected = !selected
    }
) { Text("RadioButton On") }
```

| Parameters                                                                              | Descriptions                                                                                                                                                                                                                                                                                            |
|-----------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `selected: Boolean`                                                                     | whether this radio button is selected or not                                                                                                                                                                                                                                                            |
| `onClick: (() -> Unit)?`                                                                | callback to be invoked when the RadioButton is clicked. If null, then this RadioButton will not handle input events, and only act as a visual indicator of selected state                                                                                                                               |
| `modifier: Modifier = Modifier`                                                         | A Modifier for this text field                                                                                                                                                                                                                                                                          |
| `enabled: Boolean = true`                                                               | whether the component is enabled or grayed out                                                                                                                                                                                                                                                          |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | the [MutableInteractionSource] representing the stream of [Interaction]s for this RadioButton. You can create and pass in your own remembered [MutableInteractionSource] if you want to observe [Interaction]s and customize the appearance / behavior of this RadioButton in different [Interaction]s. |
| `contentSide: ContentSide = ContentSide.End`                                            | The side where we want to show the label, default to [ContentSide.End].                                                                                                                                                                                                                                 |
| `content: @Composable RowScope.() -> Unit`                                              | The content displayed after the radio button, usually a Text composable shown at the end.                                                                                                                                                                                                               |                                                                                                                                                                                                                                                                                                    |

## Layout

### RadioGroup

> 🚀 TODO
> We plan to provide a layout composable to make it easier to follow the design specs.

```kotlin
@Composable
fun RadioGroupSample() {
    val radioOptions = listOf("Calls", "Missed", "Friends")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(Modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            RadioButtonLabelled(
                selected = text == selectedOption,
                onClick = { selectedOption(text) },
            ) { Text(text) }
        }
    }
}
```

## Form states 🚀 TODO
