# Package com.adevinta.spark.components.tags

[Tags](https://spark.adevinta.com/1186e1705/p/295e88-tag/b/86ead2) are used to label content and help users quickly recognize info about them: Categories, Status… Can be applied with different colors and designs that are associated with a content due to its characteristics: new content, unvisited content, featured content… Users can’t interact with Tags.

|       | Filled                                                                                                    | Outlined                                                                                                    | Tinted                                                                                                   |
|-------|-----------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| Light | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_tags_tagfilledpreview_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_tags_tagoutlinedpreview_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_tags_tagtonalpreview_light.png) |
| Dark  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_tags_tagfilledpreview_dark.png)  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_tags_tagoutlinedpreview_dark.png)  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_tags_tagtonalpreview_dark.png)  |

The minimal usage of the component is the text.

```kotlin
TagFilled(text = "Primary")
```

The tags can also have a decorative start icon to better identify the context of the tag.

### Layout

We don't provide any container for now but we recommend using a [`FlowRow`](https://developer.android.com/jetpack/compose/layouts/flow) to layout it in your screens.

```kotlin
FlowRow(modifier = Modifier.padding(8.dp)) {
    TagFilled("Price: High to Low")
    TagFilled("Avg rating: 4+")
    TagFilled("Free breakfast")
    TagFilled("Free cancellation")
    TagFilled("£50 pn")
}
````
