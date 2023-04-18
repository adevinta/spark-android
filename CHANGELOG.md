# Changelog

<!-- Don't forget to update links at the end of this page! -->

## [Unreleased]

## [0.1.0]

_2023-04-18_

### What's new since 0.0.3

* 🆕 Migrate `Button` to the new spark spec with multiple sizes, styles and intents.
* 🆕 Migrate `Tags` to the new spark spec with multiple styles and intents.
* 🆕 Migrate `RadioButton` to the new spark spec with the ability to have content on both side now.
* 🆕 Migrate `Checkbox` to the new spark spec with the ability to have content on both side now.
* 🆕 Add the ability for `PreviewWrapper` to specify a different background color
  than `SparkTheme.colors.background` which is useful to test custom surfaces for example.
* 💄Fix `callout` Typo having a size of `14.sp` instead of `16.sp`

#### Dependency Updates

| Dependency                | Previous version | New version    |
|---------------------------|------------------|----------------|
| androidx-compose-compiler | 1.4.3            | 1.4.5          |
| kotlin                    | 1.8.10           | 1.8.20         |
| ksp                       | 1.5.31-1.0.0     | 1.8.20-1.0.11  |
| lint                      | 31.1.0-alpha10   | 31.1.0-alpha11 |

## [0.0.3]

_2023-04-05_

* Modify the `Image` fallback states background and icon colors #306
* Integrate the new typography tokens #298
* Add Legacy option to use previous DS style #310

## [0.0.2]

_2023-03-30_

## [0.0.1]

_2023-03-29_

<!-- Links -->

[Unreleased]: https://github.com/adevinta/spark-android/compare/0.1.0...HEAD

[0.1.0]: https://github.com/adevinta/spark-android/releases/tag/0.1.0

[0.0.3]: https://github.com/adevinta/spark-android/releases/tag/0.0.3

[0.0.2]: https://github.com/adevinta/spark-android/releases/tag/0.0.2

[0.0.1]: https://github.com/adevinta/spark-android/releases/tag/0.0.1
