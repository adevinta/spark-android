# Spark Android Design System

<p align="center">
<picture>
    <source media="(prefers-color-scheme: dark)" srcset="art/spark-logo-dark.svg">
    <img alt="Spark Design System logo" src="art/spark-logo-light.svg">
  </picture>
</p>

[![👷 Build → 🧑‍🔬 Test → 🕵️ Lint](https://github.com/adevinta/spark-android/actions/workflows/ci.yml/badge.svg)](https://github.com/adevinta/spark-android/actions/workflows/ci.yml)

Compose Spark Design System is based on Material 3 compose artifact described
on the [official documentation](https://material.io/) and maintained by Google developers
and designers.

But these native components and tokens are overridden to respect Spark's Visual Identity. You'll
find
the design specifications and technical information for supported platforms by Adevinta on
[zeroheight.com/25c15666f/](https://zeroheight.com/25c15666f/).

The demo app is accessible from the `Tools` app at the bottom of the list. It's currently
generated with Showkase but will be

## 🚀 Getting Started

A `SparkTheme` is available from where you can get all
colors, typographies and shapes in your composable hierarchy. Note that this theme is
mandatory if you want to use any composable available.
If you don't use it, an error will be triggered at the runtime.

```kotlin
SparkTheme {
    // Your composable declarations
}
```
