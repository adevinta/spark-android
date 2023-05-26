# Package com.adevinta.spark.components.badge

## Badge design specs

You can find the design specs
on [spark.adevinta.com](https://spark.adevinta.com/1186e1705/p/8711ec-badge/b/98915d).

## Usage

A badge is a visual indicator for numeric values such as tallies and scores.

### Styles

|       | Danger and Info                                                                                                                                                  |
|-------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Light | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_badge_badge_light.png) |
| Dark  | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_badge_badge_dark.png)  |

```kotlin
@Composable
fun Badge(
    count: Int,
    modifier: Modifier = Modifier,
    badgeStyle: BadgeStyle = BadgeStyle.Medium,
    intent: BadgeIntent = BadgeIntent.Danger,
    overflowCount: Int = BADGE_MAX_COUNT,
    hasBorder: Boolean = true,
)
```

The default value of overflowCount is 99. When count is larger than 99, a `+` is displayed.
A badge can be used as a part of `BadgedBox` or as a standalone when it is not attached visually to
a specific relative element.

Badge content can contain:

- Number
- Numerical character (+)
- Unit letter (k, €, ...)

```kotlin
Badge(
    badgeStyle = BadgeStyle.Small,
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
    badgeStyle: BadgeStyle = BadgeStyle.Medium,
    intent: BadgeIntent = BadgeIntent.Danger,
    overflowCount: Int = BADGE_MAX_COUNT,
    hasBorder: Boolean = true,
)
```

| Parameters                                   | Descriptions                                             |
|----------------------------------------------|----------------------------------------------------------|
| `count: Int`                                 | The count to use inside the label                        |
| `modifier: Modifier = Modifier`              | The Modifier to be applied to this badge                 |                                                                                                                     |
| `badgeStyle: BadgeStyle = BadgeStyle.Medium` | The style of the badge which defines its size            |
| `intent: BadgeIntent = BadgeIntent.Danger`   | The [BadgeIntent](BadgeIntent.kt) color to use           |
| `overflowCount: Int = BADGE_MAX_COUNT`       | Defines the max count starting from which + is displayed |
| `hasBorder: Boolean = true`                  | hWhether a border should be drawn                        |

Instead of the count badge can accept an optional `@Composable` content.
If no content is passed, an empty badge is drawn.

```kotlin
@Composable
public fun Badge(
    modifier: Modifier = Modifier,
    badgeStyle: BadgeStyle = BadgeStyle.MEDIUM,
    intent: BadgeIntent = BadgeIntent.Danger,
    hasStroke: Boolean = true,
    contentDescription: String? = null,
    content: (@Composable () -> Unit)? = null,
)
```

| Parameters                                   | Descriptions                                         |
|----------------------------------------------|------------------------------------------------------|
| `modifier: Modifier = Modifier`              | The `Modifier` to be applied to this badge           |                                                                                                                     |
| `badgeStyle: BadgeStyle = BadgeStyle.Medium` | Style of the badge which defines its size            |
| `intent: BadgeIntent = BadgeIntent.Danger`   | the [BadgeIntent](BadgeIntent.kt) color to use       |
| `hasStroke: Boolean = true`                  | Whether a border should be drawn                     |
| `contentDescription: String? = null`         | A content description to use instead of default      |
| `content: (@Composable () -> Unit)? = null`  | An optional content to be rendered inside this badge |                                                                        |

### Style

A 2px stroke is displayed by default. But it can be removed if needed.
When no count is displayed in the badge, the badge is smaller but still round.

Badge accepts 2 colors defined :

- Danger: First level information
- Info: Give info with no emphasis

Badge has two styles that defines its size and content padding. `BadgeStyle.MEDIUM` is used by
default.

```kotlin
Badge(
    badgeStyle = BadgeStyle.SMALL,
    intent = BadgeIntent.Danger,
    hasStroke = false
)
```

| Light                                                                                                                                                                 | Dark                                                                                                                                                                 |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_badge_badgedbox_light.png) | ![](../../../../../../../../../spark-screenshot-testing/src/test/snapshots/images//com.adevinta.spark_PreviewScreenshotTests_preview_tests_badge_badgedbox_dark.png) |

## Layout

BadgedBox can be used to position the badge at the top right corner of another component.

```kotlin
@Composable
public fun BadgedBox(
    badge: @Composable BoxScope.() -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
)
```

| Parameters                                 | Descriptions                                              |
|--------------------------------------------|-----------------------------------------------------------|
| `badge: @Composable BoxScope.() -> Unit`   | The badge to be displayed - typically a [Badge](Badge.kt) |
| `modifier: Modifier = Modifier`            | The `Modifier` to be applied to this BadgedBox            |
| `content: @Composable RowScope.() -> Unit` | The anchor to which this badge will be positioned         |
