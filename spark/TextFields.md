# TextField components

## TextField design specs

You can find the design specs
on [zeroheight.com/25c15666f/](https://zeroheight.com/25c15666f/p/29d201-textfield-).

## Usage

### TextField

| Light                                                                                                                                             | Dark                                                                                                                                             |
|---------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_textfields_textfield_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_textfields_textfield_dark.png) |

```kotlin
@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    helper: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    error: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)
```

Textfields allow users to enter text into a UI. They typically appear in forms and dialogs.

The minimal usage of the component is the value of your textfield and the callback to be called
when the user type a new character but you can configure your textfield much more.

```kotlin
TextField(
    value = "Input",
    label = { Text("Label") },
    placeholder = { Text("Placeholder") },
    leadingIcon = {
        Icon(
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = null
        )
    },
    onValueChange = { newValue -> }
)
```

#### Prefix/Suffix

```kotlin
TextField(
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
    onValueChange = { newValue -> }
)
```

| Parameters                                                                                              | Descriptions                                                                                                                                                                                                                                                                                        |
|---------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `value: String`                                                                                         | The input text to be shown in the text field                                                                                                                                                                                                                                                        |
| `onValueChange: (String) -> Unit`                                                                       | The callback that is triggered when the input service updates the text. An updated text comes as a parameter of the callback                                                                                                                                                                        |
| `modifier: Modifier = Modifier`                                                                         | A Modifier for this text field                                                                                                                                                                                                                                                                      |
| `enabled: Boolean = true`                                                                               | Modifier to be applied to the button                                                                                                                                                                                                                                                                |
| `readOnly: Boolean = false`                                                                             | Controls the editable state of the [TextField]. When `true`, the text field can not be modified, however, a user can focus it and copy text from it. Read-only text fields are usually used to display pre-filled forms that user can not edit                                                      |
| `label: String? = null`                                                                                 | The optional label to be displayed inside the text field container. The default  text style for internal [Text] is [Typography.small] when the text field is in focus and [Typography.large] when the text field is not in focus                                                                    |
| `placeholder: String? = null`                                                                           | The optional placeholder to be displayed when the text field is in focus and the input text is empty. The default text style for internal [Text] is [Typography.large]                                                                                                                              |
| `helper: String? = null`                                                                                | The optional helper text to be displayed at the bottom outside the text input container that give some informations about expected text                                                                                                                                                             |
| `leadingIcon: @Composable (() -> Unit)? = null`                                                         | The optional leading icon to be displayed at the beginning of the text field container                                                                                                                                                                                                              |
| `trailingIcon: @Composable (() -> Unit)? = null`                                                        | The optional trailing icon to be displayed at the end of the text field container                                                                                                                                                                                                                   |
| `isError: Boolean = false`                                                                              | Indicates if the text field's current value is in error. If set to true, the label, bottom indicator and trailing icon by default will be displayed in error color                                                                                                                                  |
| `error: String? = null`                                                                                 | The optional error text to be displayed at the helper position that give more informations about the error, it's displayed only when **isError** is true                                                                                                                                            |
| `visualTransformation: VisualTransformation = VisualTransformation.None`                                | transforms the visual representation of the input [value] For example, you can use [PasswordVisualTransformation][androidx.compose.ui.text.input.PasswordVisualTransformation] to create a password text field. By default no visual transformation is applied                                      |
| `keyboardOptions: KeyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)` | software keyboard options that contains configuration such as [KeyboardType] and [ImeAction]                                                                                                                                                                                                        |
| `keyboardActions: KeyboardActions = KeyboardActions.Default`                                            | when the input service emits an IME action, the corresponding callback is called. Note that this IME action may be different from what you specified in [KeyboardOptions.imeAction]                                                                                                                 |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }`                 | the [MutableInteractionSource] representing the stream of [Interaction]s for this TextField. You can create and pass in your own remembered [MutableInteractionSource] if you want to observe [Interaction]s and customize the appearance / behavior of this TextField in different [Interaction]s. |

### MultilineTextField 🚀 To be done

### SelectTextField

| Light                                                                                                                                                   | Dark                                                                                                                                                   |
|---------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_textfields_selecttextfield_light.png) | ![](../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_textfields_selecttextfield_dark.png) |

```kotlin
@Composable
fun SelectTextField(
    value: String,
    onValueChange: (String) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(capitalization = KeyboardCapitalization.Sentences),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    dropdownContent: @Composable ColumnScope.() -> Unit,
)
```

SelectTextFields allow users to select an option from a dropdown and optionally enter text to filter
the options available in the dropdown.
They typically appear in forms and dialogs.

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

| Parameters                                                                                              | Descriptions                                                                                                                                                                                                                                                                                        |
|---------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `value: String`                                                                                         | The input text to be shown in the text field                                                                                                                                                                                                                                                        |
| `onValueChange: (String) -> Unit`                                                                       | The callback that is triggered when the input service updates the text. An updated text comes as a parameter of the callback                                                                                                                                                                        |
| `expanded: Boolean,`                                                                                    | Whether Dropdown Menu should be expanded or not                                                                                                                                                                                                                                                     |
| `onExpandedChange: (Boolean) -> Unit,`                                                                  | Executes when the user clicks on the ExposedDropdownMenuBox                                                                                                                                                                                                                                         |
| `onDismissRequest: () -> Unit,`                                                                         | Called when the user requests to dismiss the menu, such as by tapping outside the menu's bounds                                                                                                                                                                                                     |
| `modifier: Modifier = Modifier`                                                                         | A Modifier for this text field                                                                                                                                                                                                                                                                      |
| `enabled: Boolean = true`                                                                               | Modifier to be applied to the button                                                                                                                                                                                                                                                                |
| `readOnly: Boolean = false`                                                                             | Controls the editable state of the [TextField]. When `true`, the text field can not be modified, however, a user can focus it and copy text from it. Read-only text fields are usually used to display pre-filled forms that user can not edit                                                      |
| `label: String? = null`                                                                                 | The optional label to be displayed inside the text field container. The default  text style for internal [Text] is [Typography.small] when the text field is in focus and [Typography.large] when the text field is not in focus                                                                    |
| `placeholder: String? = null`                                                                           | The optional placeholder to be displayed when the text field is in focus and the input text is empty. The default text style for internal [Text] is [Typography.large]                                                                                                                              |
| `helper: String? = null`                                                                                | The optional helper text to be displayed at the bottom outside the text input container that give some informations about expected text                                                                                                                                                             |
| `leadingIcon: @Composable (() -> Unit)? = null`                                                         | The optional leading icon to be displayed at the beginning of the text field container                                                                                                                                                                                                              |
| `trailingIcon: @Composable (() -> Unit)? = null`                                                        | The optional trailing icon to be displayed at the end of the text field container                                                                                                                                                                                                                   |
| `isError: Boolean = false`                                                                              | Indicates if the text field's current value is in error. If set to true, the label, bottom indicator and trailing icon by default will be displayed in error color                                                                                                                                  |
| `error: String? = null`                                                                                 | The optional error text to be displayed at the helper position that give more informations about the error, it's displayed only when **isError** is true                                                                                                                                            |
| `visualTransformation: VisualTransformation = VisualTransformation.None`                                | transforms the visual representation of the input [value] For example, you can use [PasswordVisualTransformation][androidx.compose.ui.text.input.PasswordVisualTransformation] to create a password text field. By default no visual transformation is applied                                      |
| `keyboardOptions: KeyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences)` | software keyboard options that contains configuration such as [KeyboardType] and [ImeAction]                                                                                                                                                                                                        |
| `keyboardActions: KeyboardActions = KeyboardActions.Default`                                            | when the input service emits an IME action, the corresponding callback is called. Note that this IME action may be different from what you specified in [KeyboardOptions.imeAction]                                                                                                                 |
| `properties: PopupProperties = PopupProperties(focusable = readOnly, dismissOnClickOutside = readOnly)` | [PopupProperties] for further customization of this popup's behavior.                                                                                                                                                                                                                               |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }`                 | the [MutableInteractionSource] representing the stream of [Interaction]s for this TextField. You can create and pass in your own remembered [MutableInteractionSource] if you want to observe [Interaction]s and customize the appearance / behavior of this TextField in different [Interaction]s. |
| `dropdownContent: @Composable ColumnScope.() -> Unit`                                                   | The content to be displayed inside ExposedDropdownMenuBox.                                                                                                                                                                                                                                          |
