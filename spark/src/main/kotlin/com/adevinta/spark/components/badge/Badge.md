# Package com.adevinta.spark.components.badge

[Badges](https://spark.adevinta.com/1186e1705/p/8711ec-badge/b/98915dー convey dynamic information, 
such as counts or status. A badge can include labels or numbers.

|       | Danger and Info                                                                                 |
|-------|-------------------------------------------------------------------------------------------------|
| Light | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_badge_badge_light.png) |
| Dark  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_badge_badge_dark.png)  |

The default value of overflowCount is 99. When count is larger than 99, a `+` is displayed.
A badge can be used as a part of [`BadgedBox`](#layout) or as a standalone when it is not attached visually to
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

Instead of the count badge can accept an optional `@Composable` content.
If no content is passed, an empty badge is drawn.


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

| Light                                                                                               | Dark                                                                                               |
|-----------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_badge_badgedbox_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_badge_badgedbox_dark.png) |

## Layout

BadgedBox can be used to position the badge at the top right corner of another component.
