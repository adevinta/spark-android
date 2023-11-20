# Package com.adevinta.spark.components.textfields

[SelectTextFields](https://spark.adevinta.com/1186e1705/p/773c60-input--text-field/b/0658e2) allow users to select an
option from a dropdown and optionally enter text to filter the options available in the dropdown.

They typically appear in forms and dialogs.

| Light                                                                                                          | Dark                                                                                                          |
|----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_textfields_selecttextfield_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_textfields_selecttextfield_dark.png) |

The minimal usage of the component is :

- The value of your textfield
- The callback to be called when the user type a new character but you can configure your textfield
  much more.
- The callback when the user exit the dismiss the dropdown without selecting a value.
- A value to indicate if the dropdown should be shown or not.
- A value

```kotlin
val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
var expanded by remember { mutableStateOf(false) }
var selectedOptionText by remember { mutableStateOf(options[0]) }
SelectTextField(
    value = selectedOptionText,
    label = "label",
    onValueChange = {},
    onDismissRequest = {
        expanded = false
    },
    expanded = expanded,
    onExpandedChange = {
        expanded = !expanded
    },
) {
    options.forEach { selectionOption ->
        DropdownMenuItem(
            onClick = {
                selectedOptionText = selectionOption
                expanded = false
            },
        ) {
            Text(text = selectionOption)
        }
    }
}
```

#### Prefix/Suffix

```kotlin
SelectTextField(
    value = "Input",
    label = { Text("Label") },
    placeholder = { Text("Placeholder") },
    leadingIcon = {
        // Prefix
        Text("Prefix", modifier = Modifier.padding(start = 16.dp))
    },
    leadingIcon = {
        // Suffix
        Text("Suffix", modifier = Modifier.padding(end = 16.dp))
    },
    onValueChange = { newValue -> },
    onDismissRequest = {
        expanded = false
    },
    expanded = expanded,
    onExpandedChange = {
        expanded = !expanded
    },
) {
    // ...
}
```
