# Package com.adevinta.spark.components.iconbuttons.toggle

[Popover](https://spark.adevinta.com/1186e1705/p/88a08c-popover/b/904ceb)
Popover is kinda similar to Plain tooltip from Compose UI
Provides a descriptive message or Info for an Anchor. 
Popover that is invoked when the anchor is pressed/long pressed:

#### Popover

```kotlin
fun Popover(
    popoverContent: @Composable () -> Unit,
    isDismissButtonEnabled: Boolean = false,
    popoverState: TooltipState = rememberTooltipState(isPersistent = true),
    actionContent: @Composable () -> Unit,
)
```

| Light                                                                                                                  | Dark                                                                                                                  |
|------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_popoverbutton_popoverbuttonfilledsmall_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_popoverbutton_popoverbuttonfilledsmall_dark.png) |
