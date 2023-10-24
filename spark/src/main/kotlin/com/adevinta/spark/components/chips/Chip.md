# Package com.adevinta.spark.components.chips

[Chips](https://spark.adevinta.com/1186e1705/p/17568d-chip/b/98915d) help users quickly recognize an important information that has been entered by them, 
trigger actions, make selections, or filter content.

|       | Part                                                                                            |
|-------|-------------------------------------------------------------------------------------------------|
| Light | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chips_light.png) |
| Dark  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chips_dark.png)  |

Most commonly chip contains an optional `leadingIcon` and the text.

### Styles

The chip can have one of the [ChipStyles](ChipStyles.kt):
- [Outlined](ChipOutlined.kt) - using a solid border stroke and no background
- [Filled](ChipFilled.kt) - using a solid color for the background
- [Tinted](ChipTinted.kt) - using one of the "containers" colors
- [Dashed](ChipDashed.kt) - using a dashed border and no background

The color is set using one of the [ChipIntent](ChipIntent.kt)s:
- Basic (default color)
- Accent
- Main
- Support
- Success
- Alert
- Danger
- Info
- Neutral
- Surface

| Style    | Light                                                                                                        | Dark                                                                                                        |
|----------|--------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| Outlined | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsoutlined_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsoutlined_dark.png) |
| Filled   | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsfilled_light.png)   | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsfilled_dark.png)   |
| Tinted   | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipstinted_light.png)   | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipstinted_dark.png)   |
| Dashed   | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsdashed_light.png)   | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsdashed_dark.png)   |


To draw a chip with an optional leading icon and text.
```kotlin
fun ChipOutlined(
    text: String,
    modifier: Modifier = Modifier,
    intent: ChipIntent = ChipIntent.Basic,
    enabled: Boolean = true,
    leadingIcon: SparkIcon? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {},
)
```

To draw a chip that only contains an icon:

```kotlin
fun ChipOutlined(
    icon: SparkIcon,
    intent: ChipIntent = ChipIntent.Basic,
    contentDescription: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {},
)
```

To pass a custom content:

```kotlin
fun ChipOutlined(
    intent: ChipIntent = ChipIntent.Basic,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
)
```

### Handling selection
Chips in Spark don’t control the selected style when grouped.
However, you can use a simple if-else to handle the selected state style:

```kotlin
var selected by rememberSaveable {
    mutableStateOf(false)
}
// 1st option
if (selected.not())
    ChipOutlined("Chip", intent) {
        selected = !selected
    }
else
    ChipFilled("Chip", intent, leadingIcon = SparkIcons.Check) {
        selected = !selected
    }
// 2nd option
Chip(
    style = if (selected) ChipStyles.Filled else ChipStyles.Tinted,
    intent = if (selected) ChipIntent.Success else ChipIntent.Danger,
    onClick = { selected = !selected },
    text = "Chip",
    leadingIcon = if (selected) SparkIcons.Check else null
)
```

To correctly handle selectable state, pass the following modifier to components 
 ```kotlin
fun Modifier.semantics {
    this.selected = selected
    this.role = Role.Tab // TODO: choose a correct role relevant for your use case
}
```
