# Package com.adevinta.spark.components.chips

## Chip design specs

You can find the design specs
on [spark.adevinta.com](https://spark.adevinta.com/1186e1705/p/17568d-chip/b/98915d).

## Usage

Chips help users quickly recognize an important information that has been entered by them, 
trigger actions, make selections, or filter content.

### Styles

|       | Part                                                                                                                                                                  | Pro                                                                                                                                                                  |
|-------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Light | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chips_part_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chips_pro_light.png) |
| Dark  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chips_part_dark.png)  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chips_pro_dark.png)  |

```kotlin
@Composable
fun Chip(
    style: ChipStyles,
    intent: ChipIntent,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
)
```

| Parameters                                                                              | Descriptions                                                                                                             |
|-----------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| `style: ChipStyles`                                                                     | One of [ChipStyles](ChipStyles.kt) that defines chips background and border color                                        |
| `intent: ChipIntent`                                                                    | The [ChipIntent](ChipIntent.kt) colors that will be used for the content and background of this chip in different states |
| `onClick: () -> Unit`                                                                   | Called when this chip is clicked                                                                                         |
| `modifier: Modifier = Modifier`                                                         | The `Modifier` to be applied to this badge                                                                               |                                                                                                                     |
| `enabled: Boolean = true`                                                               | Controls the enabled state of this chip                                                                                  |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s                                                 |
| `content: @Composable RowScope.() -> Unit`                                              | Composable to set as the chip's custom content                                                                           |

Most commonly chip contains an optional `leadingIcon` and the text:

```kotlin
fun Chip(
    style: ChipStyles,
    intent: ChipIntent,
    onClick: () -> Unit,
    text: String?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: SparkIcon? = null,
    contentDescription: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)
```

| Parameters                                                                              | Descriptions                                                                                                             |
|-----------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| `style: ChipStyles`                                                                     | One of [ChipStyles](ChipStyles.kt) that defines chips background and border                                              |
| `intent: ChipIntent`                                                                    | The [ChipIntent](ChipIntent.kt) colors that will be used for the content and background of this chip in different states |
| `onClick: () -> Unit`                                                                   | Called when this chip is clicked                                                                                         |
| `text: String?`                                                                         | Label for this chip, set `null` if no label is needed                                                                    |
| `modifier: Modifier = Modifier`                                                         | The `Modifier` to be applied to this badge                                                                               |                                                                                                                     |
| `enabled: Boolean = true`                                                               | Controls the enabled state of this chip                                                                                  |
| `leadingIcon: SparkIcon? = null`                                                        | Optional icon at the start of the chip, preceding the `text`                                                             |
| `contentDescription: String? = null`                                                    | Text used by accessibility services to describe what this icon represents                                                |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | The `MutableInteractionSource` representing the stream of `Interaction`s                                                 |

### Style

The chip can have one of the [ChipStyles](ChipStyles.kt):
- Outlined - using a solid border stroke and no background
- Filled - using a solid color for the background
- Tinted - using one of the "containers" colors
- Dashed - using a dashed border and no background

The color is set using one of the [ChipIntent](ChipIntent.kt)s:
- Primary
- Secondary
- Success
- Alert
- Danger
- Info
- Neutral
- Surface

Instead of manually passing [ChipStyles](ChipStyles.kt)`, you can use one of the following options:
- [ChipOutlined](ChipOutlined.kt)
- [ChipFilled](ChipFilled.kt)
- [ChipDashed](ChipDashed.kt)
- [ChipTinted](ChipTinted.kt)

Part:
| Style    | Light                                                                                                                                                                         | Dark                                                                                                                                                                         |
|----------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Outlined | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsoutlined_part_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsoutlined_part_dark.png) |
| Filled   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsfilled_part_light.png)   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsfilled_part_dark.png)   |
| Tinted   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipstinted_part_light.png)   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipstinted_part_dark.png)   |
| Dashed   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsdashed_part_light.png)   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsdashed_part_dark.png)   |

Pro:
| Style    | Light                                                                                                                                                                         | Dark                                                                                                                                                                         |
|----------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Outlined | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsoutlined_pro_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsoutlined_pro_dark.png) |
| Filled   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsfilled_pro_light.png)   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsfilled_pro_dark.png)   |
| Tinted   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipstinted_pro_light.png)   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipstinted_pro_dark.png)   |
| Dashed   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsdashed_pro_light.png)   | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_chips_chipsdashed_pro_dark.png)   |

To draw a chip with an optional leading icon and text:
```kotlin
fun ChipOutlined(
    text: String,
    intent: ChipIntent,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: SparkIcon? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {},
)
```

| Parameters                                                                              | Descriptions                                                                                                             |
|-----------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| `intent: ChipIntent`                                                                    | The [ChipIntent](ChipIntent.kt) colors that will be used for the content and background of this chip in different states |
| `onClick: () -> Unit`                                                                   | Called when this chip is clicked                                                                                         |
| `text: String?`                                                                         | Label for this chip, set `null` if no label is needed                                                                    |
| `modifier: Modifier = Modifier`                                                         | The `Modifier` to be applied to this badge                                                                               |                                                                                                                     |
| `enabled: Boolean = true`                                                               | Controls the enabled state of this chip                                                                                  |
| `leadingIcon: SparkIcon? = null`                                                        | Optional icon at the start of the chip, preceding the `text`                                                             |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | The `MutableInteractionSource` representing the stream of `Interaction`s                                                 |

To draw a chip that only contains an icon:

```kotlin
fun ChipOutlined(
    icon: SparkIcon,
    intent: ChipIntent,
    contentDescription: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {},
)
```

| Parameters                                                                              | Descriptions                                                                                                             |
|-----------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| `icon: SparkIcon`                                                                       | icon to draw inside the chip's content                                                                                   |
| `intent: ChipIntent`                                                                    | The [ChipIntent](ChipIntent.kt) colors that will be used for the content and background of this chip in different states |
| `onClick: () -> Unit`                                                                   | Called when this chip is clicked                                                                                         |
| `modifier: Modifier = Modifier`                                                         | The `Modifier` to be applied to this badge                                                                               |                                                                                                                     |
| `enabled: Boolean = true`                                                               | Controls the enabled state of this chip                                                                                  |
| `leadingIcon: SparkIcon? = null`                                                        | Optional icon at the start of the chip, preceding the `text`                                                             |
| `contentDescription: String? = null`                                                    | Text used by accessibility services to describe what this icon represents                                                |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | The `MutableInteractionSource` representing the stream of `Interaction`s                                                 |

To pass a custom content:

```kotlin
fun ChipOutlined(
    intent: ChipIntent,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
)
```

| Parameters                                                                              | Descriptions                                                                                                             |
|-----------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| `intent: ChipIntent`                                                                    | The [ChipIntent](ChipIntent.kt) colors that will be used for the content and background of this chip in different states |
| `modifier: Modifier = Modifier`                                                         | The `Modifier` to be applied to this badge                                                                               |
| `enabled: Boolean = true`                                                               | Controls the enabled state of this chip                                                                                  |
| `interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | The `MutableInteractionSource` representing the stream of `Interaction`s                                                 |
| `onClick: () -> Unit`                                                                   | Called when this chip is clicked                                                                                         |
| `content: @Composable RowScope.() -> Unit`                                              | A Composable to set as the chip's custom content                                                                         |


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
    ChipFilled("Chip", intent, leadingIcon = SparkIcon.Toggles.Check.Simple) {
        selected = !selected
    }
// 2nd option
Chip(
    style = if (selected) ChipStyles.Filled else ChipStyles.Tinted,
    intent = if (selected) ChipIntent.Success else ChipIntent.Danger,
    onClick = { selected = !selected },
    text = "Chip",
    leadingIcon = if (selected) SparkIcon.Toggles.Check.Simple else null
)
```

To correctly handle selectable state, pass the following modifier to components 
 ```kotlin
fun Modifier.semantics {
    this.selected = selected
    this.role = Role.Tab // TODO: choose a correct role relevant for your use case
}
```
