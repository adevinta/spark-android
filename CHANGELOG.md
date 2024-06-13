# Changelog

<!-- Don't forget to update links at the end of this page! -->

## [Unreleased]

### Spark

- 🎨 The Avatar component was using the color icon without tinting it rendering them incompatible with the dark mode

### Catalog App

- 🎨 KA theme colors for outline has been changed in light mode and in dark mode it's the background + variants color.

### CI


## [0.10.0]

_2024-05-16_

### Spark
- 🆕 `BottomSheetScaffold` now has a new sheetPeekHeight parameter
- 💄 `Chip` Change chip icon default size to be bigger
- 💄 `TextField` Change TextField Icon color from onSurface to neutral
- 💄 `Icons` Update some icons
- 🐛 `ProgressTracker` Fix clipped ProgressTracker indicator

### Catalog App
- 🐛 `Checkbox` Fix intents in CheckboxConfigurator

## [0.9.0]

_2024-04-23_

### Spark

#### 🆕 Chips can now be selectable and closed
> [!CAUTION]
> The `Filled` style has been removed and may break your build if used. You need to see with your ui to know which styles to use instead of this one

> [!WARNING]
> The styles for chips have been deprecated you now need to use either the `Chip` or the `ChipSelectable` components for your need and provide the style in argument

If you want to make your Chip closable then you will need to add a callback action in the new `onClose` parameter.

---

#### 🆕 BottomSheet now use the spark specs
> [!CAUTION]
> This change will most likely break your build since most of the api has changed.
> We now use the M3 `BottomSheet` instead of a fork from a alpha version of it we did when it was only available in M2.

> [!WARNING]
> The `BottomSheet` currently only accept M3 snackbars, you won't be able to display a SparkSnackbar

--- 

- 🆕 ProgressTracker is now available! it still has a few minor visual bugs but it can be tested by squads on their scope don't hesitate to give us feedbacks!
- 🆕 `TextLinkButton` will now use `LocalContentColor` when using the Surface intent. This will allow you to have a `onSurface` `TextLink` when needed
- 🆕 `Popover` can now take an intent for its surface color
- 🆕 `Image` has its `emptyIcon` and `errorIcon` parameters open now for special cases
- 💬 A11y have been translated to german
- 💄 `Rating` will now have a lisible color when disabled
- 💄 Badge now use surface instead of onColor for its border color
- 🐛 Filled and Contrast `Button` now have a clear disabled state when their content color is dark
- 💄 New icons have been added

### Catalog App

- 🎨 Brand colors has been updated to their latest values
- 🔧 All Configurators are now scrollable

### CI

- 🔧 Decorrelated spotless and ktlint
- 🆕 Added Paparazzi as a manual workflow
- 🆕 Ran Lava Vulnerability Scanner on CI workflow
- 🔧 Moved code formatting tasks first in the contributing list

## [0.8.0]

_2024-02-28_

### Spark

* 🆕 Create the base custom layout for horizontal progress tracker
* 🆕 Add `Slider` component
* 🐛 Fix the `Button` end icon being squished when content is too long

### Catalog App

* 🎨 Update `TextLink` configurator colors
* 🎨 Add Configurator for `Progressbar`
* 🚀 Replace deprecated actionsdesk/lfs-warning with composite action

## [0.7.0]

_2024-02-15_

### Spark

* 🆕 Add slots api to `Buttons` and `Tags`
* 🆕 Add new `TextLink` Component
* 🆕 Add Large `UserAvatarStyle` Component
* 🐛 Add `Info` as `IconButton` intent color
* 🐛 Fix `ConstraintLayout` Constraint not being applied to `IconButtons` & `IconToggleButton`
* 🐛 Fix `annotatedStringResource` with args don't render annotation style
* 🐛 Remove unexpected Compose tooling dependency on runtime classpath
* 🐛 Attempt to reduce letter spacing on callout typo
* 🚀 Update modifiers impl to use Node api


### Catalog App

* 💄 Theme settings are now saved between sessions
* 🎨 Add Configurator for `Popover`
* 🎨 Add Configurator for `Progressbar`
* 📝 We can now specify a group to whom the app is distributed
* 📝 A message can be specified when publishing the app


## [0.6.1]

_2023-12-21_

### Fix Modal reported issues
*  Fix the content padding not being passed to it's children.
* Invert the position of buttons.
* Inset for non edge to edge app was broken and displaying the content bellow the system bars.
*  Add the support for WindowHeightSizeClass.Expanded to show the fullscreen modal in portrait

## [0.6.0]

_2023-12-19_

### Spark

* 🆕 Add `TextField addons` api with premade addons
* 🆕 Add `Popover` component
* 🆕 Add new `Modal` Component
* 🆕 Add `Progressbar` Component
* 🆕 Update rating specs
* 🆕 Add `Rating` Input
* 💄 Add `Button Shapes` and unify the api for all button types
* 🐛 `Checkbox` checkmark was using `onPrimary` instead of `onColor` from intent
* 🎨 Screenshot tests for all `SparkIcon`s


### Catalog App

* 💄 Add `Subito` theme to catalog app
* 💄 Add `Milanuncios` theme to catalog app
* 🎨 Add examples ad configurator for `Rating`
* 🎨 Add a configurator for the `Tab`
* 🎨 Add missing test, examples, configurator for `Tag` component
* 🐛 Fix typos in `TabsExamples` and replace one icon to fit the style
* 📝 Replace `zeroheight` links with `spark.adevinta.com`

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

[Unreleased]: https://github.com/adevinta/spark-android/compare/0.10.0...HEAD

[0.10.0]: https://github.com/adevinta/spark-android/releases/tag/0.10.0

[0.9.0]: https://github.com/adevinta/spark-android/releases/tag/0.9.0

[0.8.0]: https://github.com/adevinta/spark-android/releases/tag/0.8.0

[0.7.0]: https://github.com/adevinta/spark-android/releases/tag/0.7.0

[0.6.1]: https://github.com/adevinta/spark-android/releases/tag/0.6.1

[0.6.0]: https://github.com/adevinta/spark-android/releases/tag/0.6.0

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
