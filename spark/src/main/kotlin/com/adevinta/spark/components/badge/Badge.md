# Button components

## Button design specs

You can find the design specs
on [spark.adevinta.com](https://spark.adevinta.com/1186e1705/p/8711ec-badge/b/98915d).

## Usage

A badge is a visual indicator for numeric values such as tallies and scores.

### Styles

|       | Danger and Info                                                                                                                                                         | Outlined                                                                                                                                                                           | Tinted                                                                                                                                                                           | Ghost                                                                                                                                                                           | Contrast                                                                                                                                                                           |
|-------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Light | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_badge_badge_light.png)        | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonoutlinedintents_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttontintedintents_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonghostintents_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttoncontrastintents_light.png) |
| Dark  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_badge_badge_dark.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonoutlinedintents_dark.png)  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttontintedintents_dark.png)  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonghostintents_dark.png)  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttoncontrastintents_dark.png)  |

### Sizes

![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonsizes_light.png)

```kotlin
@Composable
fun Badge(
    count: Int,
    modifier: Modifier = Modifier,
    badgeStyle: BadgeStyle = BadgeStyle.MEDIUM,
    intent: BadgeIntent = BadgeIntent.Danger,
    overflowCount: Int = BADGE_MAX_COUNT,
    hasBorder: Boolean = true,
)
```
The default value of overflowCount is 99. When count is larger than 99, a + is displayed.
Basic can be used as a part of `BadgedBox` or as a standalone when it is not attached visually to a 
specific relative element.

Badge content can contain:
- Number
- Numerical character (+)
- Unit letter (k, €, ...)

```kotlin
Badge(
    badgeStyle = BadgeStyle.SMALL, 
    intent = intent, 
    count = 1000, 
    overflowCount = 999, 
    hasBorder = false
)
```

The badges can have a count with and overflow specified. If no overflow count is passed, 
the default of 99 is used.

```kotlin
@Composable
public fun Badge(
    count: Int,
    modifier: Modifier = Modifier,
    badgeStyle: BadgeStyle = BadgeStyle.MEDIUM,
    intent: BadgeIntent = BadgeIntent.Danger,
    overflowCount: Int = BADGE_MAX_COUNT,
    hasBorder: Boolean = true,
)
```

| Parameters                                   | Descriptions                                                           |
|----------------------------------------------|------------------------------------------------------------------------|
| `count: Int`                                 | count to use inside the label                                          |
| `modifier: Modifier = Modifier`              | modifier the Modifier to be applied to this badge                      |                                                                                                                     |
| `badgeStyle: BadgeStyle = BadgeStyle.MEDIUM` | badgeStyle style of the badge which defines its size                   |
| `intent: BadgeIntent = BadgeIntent.Danger`   | The [BadgeIntent] color to use                                         |
| `overflowCount: Int = BADGE_MAX_COUNT`       | overflowCount defines the max count starting from which + is displayed |
| `hasBorder: Boolean = true`                  | hasBorder whether a border should be drawn                             |

Instead of the count badge can accept an optional @Composable content. 
If no content is passed, an empty badge is drawn.

```kotlin
@Composable
public fun Badge(
    modifier: Modifier = Modifier,
    badgeStyle: BadgeStyle = BadgeStyle.MEDIUM,
    intent: BadgeIntent = BadgeIntent.Danger,
    hasBorder: Boolean = true,
    content: (@Composable () -> Unit)? = null,
)
```
| Parameters                                   | Descriptions                                              |
|----------------------------------------------|-----------------------------------------------------------|
| `modifier: Modifier = Modifier`              | modifier the Modifier to be applied to this badge         |                                                                                                                     |
| `badgeStyle: BadgeStyle = BadgeStyle.MEDIUM` | badgeStyle style of the badge which defines its size      |
| `intent: BadgeIntent = BadgeIntent.Danger`   | The [BadgeIntent] color to use                            |
| `hasBorder: Boolean = true`                  | hasBorder whether a border should be drawn                |
| `content: (@Composable () -> Unit)? = null`  | content optional content to be rendered inside this badge |                                                                        |


### Style

A 2px stroke is displayed by default. But it can be removed if needed.
When no count is displayed in the badge, the badge is smaller but still round.

Badge accepts 2 colors defined :
- Danger: First level information
- Info: Give info with no emphasis

Badge has two styles that defines its size and content padding. `BadgeStyle.MEDIUM` is used by default.

#### ButtonFilled

Filled buttons are the standard button for most use cases. The filled styling places the most
emphasis and should be used for important, final actions.

```kotlin
Badge(
    badgeStyle = BadgeStyle.SMALL,
    intent = BadgeIntent.Danger,
    hasBorder = false
)
```

| Light                                                                                                                                                              | Dark                                                                                                                                                                      |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_badge__badge_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_buttons_buttonfilled_dark.png) |

