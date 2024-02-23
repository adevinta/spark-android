# package com.adevinta.spark.components.slider

[Sliders](https://spark.adevinta.com/1186e1705/p/25cceb-slider/b/03f6fc)
A slider is an interactive component that allows users to set values by moving a handle within a
defined range.

|       | Slider                                                                                            | Range Slider                                                                                                |
|-------|---------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| Light | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_slider_slider_light.png) | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_rangeslider_rangeslider_light.png) |
| Dark  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_slider_slider_dark.png)  | ![](../../images/com.adevinta.spark_PreviewScreenshotTests_preview_tests_rangeslider_rangeslider_dark.png)  |

### Variants

2 Variants:

#### Slider

Provides the slider with a minimum and maximum value.

```kotlin
Slider(
    value = 0.5f,
    intent = SliderIntent.Success,
    onValueChange = {},
)
```

|          | Slider                                                                         |
|----------|--------------------------------------------------------------------------------|
| Enabled  | ![](../../images/com.adevinta.spark.slider_SliderScreenshot_sliderRounded.png) |
| Disabled | ![](../../images/com.adevinta.spark.slider_SliderScreenshot_sliderRounded.png) |

#### Range Slider

Provides the slider with a set of two values (range).

```kotlin
RangeSlider(
    value = 0.1f..0.5f,
    intent = SliderIntent.Success,
    onValueChange = {},
)
```

|          | Range Slider                                                                                |
|----------|---------------------------------------------------------------------------------------------|
| Enabled  | ![](../../images/com.adevinta.spark.slider_SliderScreenshot_rangeSliderRounded.png)         |
| Disabled | ![](../../images/com.adevinta.spark.slider_SliderScreenshot_rangeSliderRoundedDisabled.png) |
