# Package com.adevinta.spark.components.popover

[TextLink](https://spark.adevinta.com/1186e1705/p/75ed11-textlink/b/403107)
A textlink is a reference to a resource.

It can be external (e.g. a different web page) or internal (e.g. a specific element in the current
page).

#### TextLink

```kotlin
fun TextLink(
    textFull: String,
    textLink: String,
    colorText: Color = Color.Unspecified,
    colorLink: Color = colorText,
    onClick: () -> Unit,

    )
```

| Light                                                                                                                                        | 
|----------------------------------------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.text_TextLinkScreenshot_test_link_learn_kotl_color_linkcolor(1.0,_1.0,_0.0,_1.0,_srgb_iec61966-2.1).png) |
