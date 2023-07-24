# Package com.adevinta.spark.components.textfields

[OtpTextField](https://spark.adevinta.com/1186e1705/p/365c2e-text-viewarea/b/0658e2) allow users to
enter One Time Password (OTP). They typically appear in phone number validation.

| Light                                                                                                       | Dark                                                                                                       |
|-------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_textfields_otptextfield_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_textfields_otptextfield_dark.png) |

The minimal usage of the component is the value of your textfield and the callback to be called
when the user type a new character. You can also configure the pinCount that is set to 6 by default.

```kotlin
OtpTextField(
    value = "123456",
    pinCount = 6,
    onTextChange = { text, filled -> },
)
```
