# Package com.adevinta.spark.components.popover

[TextLink](https://spark.adevinta.com/1186e1705/p/75ed11-textlink/b/403107)
A textlink is a reference to a resource.

It can be external (e.g. a different web page) or internal (e.g. a specific element in the current
page).

#### TextLink

```kotlin
fun TextLink(
    text: Int,
    onClickLabel: String,
    onClick: () -> Unit,
)
```

| TextLink                                                                               | 
|----------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.text_TextLinkScreenshot_testTextLink_textlink.png) |

#### TextLinkButton

```kotlin
fun TextLinkButton(
    text: String,
    onClick: () -> Unit,
    intent: ButtonIntent,
    enabled: Boolean = true,
    isLoading: Boolean = false,
)
```

| accent                                                                                                    | 
|-----------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.text_TextLinkScreenshot_testTextLinkButton_textlinkbutton_accent.png) |

| alert                                                                                                    | 
|----------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.text_TextLinkScreenshot_testTextLinkButton_textlinkbutton_alert.png) |

| basic                                                                                                    | 
|----------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.text_TextLinkScreenshot_testTextLinkButton_textlinkbutton_basic.png) |

| danger                                                                                                    | 
|-----------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.text_TextLinkScreenshot_testTextLinkButton_textlinkbutton_danger.png) |

| info                                                                                                      | 
|-----------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.text_TextLinkScreenshot_testTextLinkButton_textlinkbutton_accent.png) |

| main                                                                                                    | 
|---------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.text_TextLinkScreenshot_testTextLinkButton_textlinkbutton_main.png) |

| neutral                                                                                                    | 
|------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.text_TextLinkScreenshot_testTextLinkButton_textlinkbutton_neutral.png) |

| success                                                                                                    | 
|------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.text_TextLinkScreenshot_testTextLinkButton_textlinkbutton_success.png) |

| support                                                                                                    | 
|------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.text_TextLinkScreenshot_testTextLinkButton_textlinkbutton_support.png) |

| surface                                                                                                    | 
|------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark.text_TextLinkScreenshot_testTextLinkButton_textlinkbutton_surface.png) |