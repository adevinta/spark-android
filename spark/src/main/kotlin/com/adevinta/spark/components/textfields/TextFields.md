# Package com.adevinta.spark.components.textfields

[Textfields](https://spark.adevinta.com/1186e1705/p/773c60-input/b/0658e2) allow users to enter text into a UI. They typically appear in forms and dialogs.

| Light                                                                                                    | Dark                                                                                                    |
|----------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_textfields_textfield_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_textfields_textfield_dark.png) |

The minimal usage of the component is the value of your textfield and the callback to be called
when the user type a new character but you can configure your textfield much more.

```kotlin

import java.awt.TextField

TextField(
    value = "Input",
    label = { Text("Label") },
    placeholder = { Text("Placeholder") },
    leadingContent = {
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
    leadingContent = {
        // Prefix
        Text("Prefix", modifier = Modifier.padding(start = 16.dp))
    },
    trailingContent = {
        // Suffix
        Text("Suffix", modifier = Modifier.padding(end = 16.dp))
    },
    onValueChange = { newValue -> }
)
```
