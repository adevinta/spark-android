# Changelog

<!-- Don't forget to update links at the end of this page! -->

## [Unreleased]


## [0.5.0]

_2023-09-26_

### Spark

* 🆕 Add `IconButtons` with all intents, shapes and sizes
* 🆕 Add loading state to the `IconButton` component
* 🆕 Add `IconToggleButton`
* 💄 Use M2 elevation system instead of the M3 one
* ⬆️ Bump `compileSdk` and `targetSdk` to 34
* 🎨 Change colors from LBC & KA
* 🐛 Make the readonly `Textfields` not take the focus look when focused
* 📝 Replace oneliner with two distinct commands
* 🐛 `ModalFullScreenScaffold` top padding issue when no illustration


### Catalog App

* 🆕 Add Icons demo to CatalogApp
* 🆕 Add examples for tab component
* 💄 Add Kleinanzeigen theme
* 🎨 Add illustrations for components item
* 🚀 Fetch icon resources in coroutines
* 🐛 Shorten catalog app name
* 🐛 Add proguard rules to keep the names of spark icons resources
* 🐛 Component Illustrations are too big
* 🐛 Minor fixes in CatalogApp
* 💄 Modify Segmented color to be more visible and make switch take full width
* 💄 Update catalog app to show `ExtraLarge` icons

## [0.4.2]

_2023-08-24_

* 🐛 Some color tokens were not updated on theme change

## [0.4.1]

_2023-08-17_

### Spark
* 🆕 Implement `Spark Tab` and `Tab Group`
* 💄 `Checkbox`, `Switch`, `RadioButton` now has intents support
* 💄 Disabled components now have use `dim3`
* 💄 `Button Outline` border size is now **1dp** instead of **2dp**
* 💄 Update `TextField` background color
* 💄 `TextField` leading content padding is adjusted
* 💄 `TextField` addons content color is always `onSurface` even when unfocused
* 💄 `ButtonContrast` in Surface intent is now readable
* 💄 `ModalFullScreenScaffold` spaces and layout has been adjusted
* 🗑️ Small size for `Button` has been removed
* 🐛 Replace `Modifier.autofill` by `Autofill` Composable


### Catalog App
* 🆕 Now have examples and a configurator for `Button`, `Checkbox`, `Switch`, `RadioButton` `TextField`
* 💄 The launcher icon now has a light and dark variant depending on the theme mode
* 🐛 The app state is saved on configuration change
* 🐛 Fix the link to component documentation

## [0.3.1]

_2023-07-31_

* 🆕 Added `Basic` and `Accent` intents to all released components.
* 💄Updated the default color intents to `Basic` for `Tag`, `Chip`, `Spinner`. 
* 🗑️ Deprecated `Primary` and `Secondary` intents, `Main` and `Support`should be used instead.

## [0.3.0]

_2023-07-11_

* 🆕 Migrate `TextField` to the new spark spec with multiple sizes, styles and intents.
* 🔧 Add extensions to make usage of dims and highlights simpler.
* 💄 `Buttons` now have the correct color in disabled state.
* 💄 `Badges` now have all intents instead of `error` and `info`.
* 💄 `Snackbars` now have a bigger shape in new ui.
* 🐛 `Tags` now correctly expose its children with semantics.
* 🗑️ Deprecated `SparkIcons` are now removed.
* Update icon resources

## [0.2.0]

_2023-06-23_

* 🆕 Migrate `Badges` to the new spark spec with multiple sizes, styles and intents.
* 🆕 Migrate `Icons` to the new spark spec with multiple sizes, styles and intents.
* 🆕 Migrate `Chips` to the new spark spec with multiple sizes, styles and intents.
* 🆕 Migrate `Toggles` to the new spark spec with multiple sizes, styles and intents.
* 🆕 Add fullscreen modal component as experimental
* Update icon resources

## [0.1.1]

_2023-05-23_

* Add missing Categories/Family icon #388

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

[Unreleased]: https://github.com/adevinta/spark-android/compare/0.5.0...HEAD

[0.5.0]: https://github.com/adevinta/spark-android/releases/tag/0.5.0

[0.4.2]: https://github.com/adevinta/spark-android/releases/tag/0.4.2

[0.4.1]: https://github.com/adevinta/spark-android/releases/tag/0.4.1

[0.3.1]: https://github.com/adevinta/spark-android/releases/tag/0.3.1

[0.3.0]: https://github.com/adevinta/spark-android/releases/tag/0.3.0

[0.2.0]: https://github.com/adevinta/spark-android/releases/tag/0.2.0

[0.1.1]: https://github.com/adevinta/spark-android/releases/tag/0.1.1

[0.1.0]: https://github.com/adevinta/spark-android/releases/tag/0.1.0

[0.0.3]: https://github.com/adevinta/spark-android/releases/tag/0.0.3

[0.0.2]: https://github.com/adevinta/spark-android/releases/tag/0.0.2

[0.0.1]: https://github.com/adevinta/spark-android/releases/tag/0.0.1
