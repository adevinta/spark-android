# Changelog

<!-- Don't forget to update links at the end of this page! -->

## [Unreleased]

## [1.2.0]

_2025-03-19_

### Spark
* ✨ New `Stepper` Component
* 🗑️ `includeFontPadding`  on Spark typographies is not removed since it's no longer needed since Compose 1.6

### Catalog

* 🔗 The catalog app now supports **deeplinks** to any pages! This allows us to redirect our user quickly to a component that has been introduced or changed.
* ✨ Now when a component is being worked on you will see a Work in Progress illustration.
* ✨ A new Catalog component has been created to simplify the uses & selection of enum for configuration.
* ✨ A component can now have more than 1 Configurator. This is to avoid configurators that are too complex and won't fit easily into one screen.
* 🚀 Material transitions can now be tested in the catalog app to showcase & test their behaviour.
* 🕶️ The screen reader navigation has been improved and we'll continue to improve it globally to meet the same standard as lbc

## [1.1.4]

_2025-02-19_

### Spark
- 🛠️ Modal `inEdgeToEdge` parameter was applied even when set to false.
- 🐛 Conditional modifiers were reapplying the chain instead of doing nothing when the predicate was false.

## [1.1.3]

_2025-01-29_

### Spark
- 🛠 Use latest and simpler workaround to display a Dialog in fullscreen with support to edge-to-edge. 
- 🛠️ Modal `inEdgeToEdge` parameter now default to false.

## [1.1.2]

_2025-01-29_

### Spark
- 🐛 Conditional modifiers were not working as expected since they returned an empty modifier instead of modifier chain if the condition was not met.


## [1.1.1] 

_2025-01-28_

### Spark
- 🐛 Conditional modifiers were not working as expected since they returned an empty.
- 🐛 `Image` no longer use a `BoxWithConstraint`as its root component which forbid intrinsic sizes
- 🐛 Revert `Image` behavior on sizing with empty/loading/error states.


## [1.1.0]

_2025-01-06_

### Animated Icons
> [!CAUTION]
> The api for `Icon`, `IconButton`, `IconToggleButton` , `Button`, `Tag` & `Chip` has their api modified to support animated vector icons

Animated Icons can now be used with spark components!

### Image
> [!IMPORTANT]
> Image component now has it's specs updated to the design ones! with new colors to its error state!

### TextField
> [!CAUTION]
> The position of the TextField status icon has been moved from the trailing addon to the support message which might impact your screens!

Now all textfields (not only the multi line one) can display a character count and their min width has been reduced to allow for side to side Textfield layout to be possible (previously it was too big to allow it)!

### Spark
- ✨ New icons available.
- 🥳 Showkase is no longer used in the catalog app which means it'll also no longer bleed in your code!
- 🎨 A new api allow you to convert a **Material Theme** to a **Spark theme** which could be used to support dynamic theming for ex.
- 🐛 `UserAvatar` badge position is now correctly positioned.
- ⬆️ The Compose BOM version has been upgraded from `2024.10.01` to `2024.12.01`.
- ⬆️  Bump compileSdk & targetSdk to API level 35 (Android 15).
- ⬆️  Bump kotlin from 2.0.21 to 2.1.0.
- ✨ A lint rule to detect wrong string annotation usages has been added by @EliottLujan!
- 🎨 Theme color has been updated.

### Catalog App

- 🥳 Showkase is no longer used to preview some of our caspule components.
- ✨ A `Modal` configurator as been added.
- 💄 IconScreen no longer has clipping with the search bar.
- 🛠️ Migrated from uri to the new Typesafe routes for navigation.
- ✨ New examples for the shape tokens has benn added by @EliottLujan!

## [1.0.2]

_2024-12-11_

### Spark

- ⬆️ Upgrade Compose BOM to `2024.11.00` since it only contains bugfixes changes.
- 
- ## [1.0.1]

_2024-11-07_

### Spark

- 🐛 User Avatar presence badge was incorrectly placed, especially in big sizes.

## [1.0.0]

_2024-10-07_

### Spark
> [!CAUTION]
> All the code that was legacy, coming from brikke and was deprecated has been removed from Spark.
> This mean you build with break with this change

> [!CAUTION]
> Material 3 compose & Compose has been upgraded to version 1.3 and 1.7 which introduce compiling & visual breaking changes.
> Be sure to verify your UIs when upgrading.

- 🐛 Add statusBar size on the content padding on BottomSheet content.
- 🐛 One of TextLinkButton overloads was using intent Danger instead of Surface.
- 🐛 Dividers no longer have a minimum width/height of 40.dp.
- 💄 ModalScaffold now has a padding between its buttons when they overflow and stack each others.
- 🔧 Chips now have a leading/trailing icon slots to ensure these content are not hidden when the chip content is too big for the required width.
- 🔧 Components were missing `sparkUsageOverlay` so it has been added to them and remove on Icons to reduce the confusions with the huge amount of icons used in apps and our components.
- 🔧 `SparkTheme` now take a `SparkFeatureFlag` for the activation of the debug features.
- 📝 Documentation for `annotatedStringResource` has been improved with usage examples

### Catalog App

- ♿ A colorbliness filter has been added to improve testing of components for this disability.
- 💄 New examples for the elevation tokens have been added.

### CI
 - Icons screenshot are not bound to the theme colors anymore to reduce invalidation not related to the icons themselves.

## 0.11.0

_2024-08-13_

### Spark

#### 🆕 Divider
> [!WARNING]
> The Divider Component has been deprecated to use the `HorizontalDivider`

The divider component now has 2 fixed colors, `outline` and `outlineHigh`. I now accept a slot has a label indicator if you need to place a decorative text when separating your sections.

#### 🆕 New Dropdown specs
> [!WARNING]
> The previous SelectTextField Api has been deprecated but should still be used in Combobox usecases.

The Dropdown replace the existing SelectTextfield in readonly mode. It adds new api to handle item groupings with a proper title and remove the necessity to provide the `onValueChange` callback.

#### 🆕 Snackbar
> [!CAUTION]
> `SnackbarColors` & every colored Snackbar override have been deprecated as error as their api is not compatible with the new one. You'll need to migrate them to use this version.

The new Snackbar loses its title and icon slot to accept only a `SparkIcon`.
It has 2 styles, intents and the new dismiss action that are also available on the `showSnackbar` function.


- ⬆️ Spark now use Kotlin 2.0
- ⬆️ Compose BOM has been increased from 2024.05.00 to 2024.06.00
- 🐛 The Avatar component was using the color icon without tinting it rendering them incompatible with the dark mode
- 🐛 Chip doesn't have a max width anymore.
- 🐛 Textfield doesn't have a max width anymore.
- 🐛 Progress Tracker Indicator size now follow the font scaling
- 🐛 Textfield now correctly show the required indicator when the label fold in multiples lines

### Catalog App

- 🎨 KA theme colors for outline has been changed in light mode and in dark mode it's the background + variants color
- 🆕 Examples on how to make a Button Toggle has been added

## [0.10.1]

_2024-06-18_

### Spark
- 🐛 `ModalScaffold` can now take no actions and will hide the Bottom app Bar.
- 🐛 `ModalScaffold` in dialog layout was not respecting the correct min and max width.

### Catalog App
- `ModalScaffold` Added an example that will show the modal with no actions.
 
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

[Unreleased]: https://github.com/leboncoin/spark-android/compare/1.2.0...HEAD

[1.2.0]: https://github.com/leboncoin/spark-android/releases/tag/1.2.0

[1.1.4]: https://github.com/leboncoin/spark-android/releases/tag/1.1.4

[1.1.3]: https://github.com/adevinta/spark-android/releases/tag/1.1.3

[1.1.2]: https://github.com/adevinta/spark-android/releases/tag/1.1.2

[1.1.1]: https://github.com/adevinta/spark-android/releases/tag/1.1.1

[1.1.0]: https://github.com/leboncoin/spark-android/releases/tag/1.1.0

[1.0.2]: https://github.com/adevinta/spark-android/releases/tag/1.0.2

[1.0.1]: https://github.com/adevinta/spark-android/releases/tag/1.0.1

[1.0.0]: https://github.com/adevinta/spark-android/releases/tag/1.0.0

[0.11.0]: https://github.com/adevinta/spark-android/releases/tag/0.11.0

[0.10.1]: https://github.com/adevinta/spark-android/releases/tag/0.10.1

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
