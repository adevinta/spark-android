/*
 * Copyright (c) 2023 Adevinta
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.adevinta.spark.catalog.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.configurator.samples.bottomsheet.BottomSheetConfigurator
import com.adevinta.spark.catalog.configurator.samples.buttons.ButtonsConfigurator
import com.adevinta.spark.catalog.configurator.samples.buttons.IconButtonsConfigurator
import com.adevinta.spark.catalog.configurator.samples.buttons.IconToggleButtonsConfigurator
import com.adevinta.spark.catalog.configurator.samples.chips.ChipsConfigurator
import com.adevinta.spark.catalog.configurator.samples.divider.DividerConfigurator
import com.adevinta.spark.catalog.configurator.samples.popover.PopoverConfigurator
import com.adevinta.spark.catalog.configurator.samples.progressbar.ProgressbarConfigurator
import com.adevinta.spark.catalog.configurator.samples.progresstracker.ProgressTrackerConfigurator
import com.adevinta.spark.catalog.configurator.samples.rating.RatingsConfigurator
import com.adevinta.spark.catalog.configurator.samples.slider.SlidersConfigurator
import com.adevinta.spark.catalog.configurator.samples.snackbar.SnackbarConfigurator
import com.adevinta.spark.catalog.configurator.samples.tabs.TabsConfigurator
import com.adevinta.spark.catalog.configurator.samples.tags.TagsConfigurator
import com.adevinta.spark.catalog.configurator.samples.text.TextLinksConfigurator
import com.adevinta.spark.catalog.configurator.samples.textfields.DropdownsConfigurator
import com.adevinta.spark.catalog.configurator.samples.textfields.TextFieldsConfigurator
import com.adevinta.spark.catalog.configurator.samples.toggles.CheckboxConfigurator
import com.adevinta.spark.catalog.configurator.samples.toggles.RadioButtonConfigurator
import com.adevinta.spark.catalog.configurator.samples.toggles.SwitchConfigurator
import com.adevinta.spark.catalog.examples.divider.DividerExamples
import com.adevinta.spark.catalog.examples.samples.bottomsheet.BottomSheetExamples
import com.adevinta.spark.catalog.examples.samples.buttons.ButtonsExamples
import com.adevinta.spark.catalog.examples.samples.buttons.IconButtonsExamples
import com.adevinta.spark.catalog.examples.samples.chips.ChipsExamples
import com.adevinta.spark.catalog.examples.samples.dialog.DialogsExamples
import com.adevinta.spark.catalog.examples.samples.icons.IconsExamples
import com.adevinta.spark.catalog.examples.samples.popover.PopoverExamples
import com.adevinta.spark.catalog.examples.samples.progressbar.ProgressbarExamples
import com.adevinta.spark.catalog.examples.samples.progresstracker.ProgressTrackerExamples
import com.adevinta.spark.catalog.examples.samples.rating.RatingExamples
import com.adevinta.spark.catalog.examples.samples.slider.SlidersExamples
import com.adevinta.spark.catalog.examples.samples.snackbar.SnackbarExamples
import com.adevinta.spark.catalog.examples.samples.tabs.TabsExamples
import com.adevinta.spark.catalog.examples.samples.tags.TagsExamples
import com.adevinta.spark.catalog.examples.samples.text.DropdownsExamples
import com.adevinta.spark.catalog.examples.samples.text.TextLinksExamples
import com.adevinta.spark.catalog.examples.samples.textfields.TextFieldsExamples
import com.adevinta.spark.catalog.examples.samples.toggles.CheckboxExamples
import com.adevinta.spark.catalog.examples.samples.toggles.IconToggleButtonsExamples
import com.adevinta.spark.catalog.examples.samples.toggles.RadioButtonExamples
import com.adevinta.spark.catalog.examples.samples.toggles.SwitchExamples
import com.adevinta.spark.catalog.examples.samples.tokens.TokensExamples
import com.adevinta.spark.catalog.util.ComponentGuidelinesUrl
import com.adevinta.spark.catalog.util.PackageSummaryUrl
import com.adevinta.spark.catalog.util.SparkSourceUrl

public data class Component(
    val id: Int,
    val name: String,
    @StringRes val description: Int,
    val tintIcon: Boolean = true,
    @DrawableRes val illustration: Int = R.drawable.illu_component_placeholder,
    val guidelinesUrl: String,
    val docsUrl: String,
    val sourceUrl: String,
    val examples: List<Example>,
    val configurator: Configurator? = null,
)

private var nextId: Int = 1
private fun nextId(): Int = nextId.also { nextId += 1 }

private val Buttons = Component(
    id = nextId(),
    name = "Buttons",
    illustration = R.drawable.illu_component_button,
    tintIcon = false,
    description = R.string.component_button_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/34b742-button/b/32e1a2",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.buttons/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/buttons/Button.kt",
    examples = ButtonsExamples,
    configurator = ButtonsConfigurator,
)

private val Checkboxes = Component(
    id = nextId(),
    name = "Checkboxes",
    illustration = R.drawable.illu_component_checkbox,
    tintIcon = false,
    description = R.string.component_checkbox_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/76f5a8-checkbox/b/98915d",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.toggles/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/toggles/CheckBox.kt",
    examples = CheckboxExamples,
    configurator = CheckboxConfigurator,
)

private val Chips = Component(
    id = nextId(),
    name = "Chips",
    tintIcon = true,
    description = R.string.component_chips_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/17568d-chip",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.chips/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/chips/Chips.kt",
    examples = ChipsExamples,
    configurator = ChipsConfigurator,
)

private val Dialogs = Component(
    id = nextId(),
    name = "Dialogs",
    description = R.string.component_dialog_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/2427e1-modaldialog/b/02a6bc",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.dialog/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/dialog/ModalScaffold.kt",
    examples = DialogsExamples,
    configurator = null,
)

private val Dropdowns = Component(
    id = nextId(),
    name = "Dropdowns",
    description = R.string.component_dropdowns_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/1186e1705/p/323b83-dropdown",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.dropdown/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/textfields/Dropdown.kt",
    examples = DropdownsExamples,
    configurator = DropdownsConfigurator,
)

private val Icons = Component(
    id = nextId(),
    name = "Icons",
    illustration = R.drawable.illu_component_iconbutton,
    tintIcon = false,
    description = R.string.component_iconbutton_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/2352e9-icon-button/b/32e1a2",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.iconbuttons/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/iconbuttons/IconButton.kt",
    examples = IconsExamples,
    configurator = null,
)

private val IconButtons = Component(
    id = nextId(),
    name = "IconButtons",
    illustration = R.drawable.illu_component_iconbutton,
    tintIcon = false,
    description = R.string.component_iconbutton_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/2352e9-icon-button/b/32e1a2",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.iconbuttons/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/iconbuttons/IconButton.kt",
    examples = IconButtonsExamples,
    configurator = IconButtonsConfigurator,
)

private val IconToggleButtons = Component(
    id = nextId(),
    name = "IconToggleButtons",
    description = R.string.component_icontogglebutton_description,
    illustration = R.drawable.illu_component_icontogglebutton,
    tintIcon = false,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/2352e9-icon-button/b/32e1a2",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.iconbuttons/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/iconTogglebuttons/IconToggleButton.kt",
    examples = IconToggleButtonsExamples,
    configurator = IconToggleButtonsConfigurator,
)

private val Popovers = Component(
    id = nextId(),
    name = "Popovers",
    illustration = R.drawable.illustration_popover,
    tintIcon = false,
    description = R.string.component_popovers_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/88a08c-popover/b/904ceb",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.popover/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/popover/Popover.kt",
    examples = PopoverExamples,
    configurator = PopoverConfigurator,
)

private val BottomSheets = Component(
    id = nextId(),
    name = "BottomSheets",
    illustration = R.drawable.bottomsheet,
    tintIcon = false,
    description = R.string.component_bottomsheets_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/67d41e-bottom-sheet/b/02056b",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.bottom-sheet/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/bottomsheet/modal/ModalBottomSheet.kt",
    examples = BottomSheetExamples,
    configurator = BottomSheetConfigurator,
)

private val RadioButtons = Component(
    id = nextId(),
    name = "Radio buttons",
    illustration = R.drawable.illu_component_radiobutton,
    tintIcon = false,
    description = R.string.component_radiobutton_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/98058f-radio-button/b/700a17",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.toggles/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/toggles/RadioButton.kt",
    examples = RadioButtonExamples,
    configurator = RadioButtonConfigurator,
)

private val Rating = Component(
    id = nextId(),
    name = "Ratings",
    illustration = R.drawable.illu_component_rating,
    tintIcon = false,
    description = R.string.component_ratingdisplay_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/63e136-rating/b/51f5d8",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.rating/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/rating/RatingDisplay.kt",
    examples = RatingExamples,
    configurator = RatingsConfigurator,
)

private val Switches = Component(
    id = nextId(),
    name = "Switches",
    illustration = R.drawable.illu_component_switch,
    tintIcon = false,
    description = R.string.component_switch_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/58a2c6-switch/b/700a17",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.toggles/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/toggles/Switch.kt",
    examples = SwitchExamples,
    configurator = SwitchConfigurator,
)

private val Snackbars = Component(
    id = nextId(),
    name = "Snackbars",
    illustration = R.drawable.illu_component_placeholder,
    tintIcon = false,
    description = R.string.component_snackbar_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/36d4af-snackbar",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.snackbars/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/snackbars/Snackbar.kt",
    examples = SnackbarExamples,
    configurator = SnackbarConfigurator,
)

private val Tabs = Component(
    id = nextId(),
    name = "Tabs",
    description = R.string.component_tab_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/7461a4-tabs/b/98915d",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.tab/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/tab/Tab.kt",
    examples = TabsExamples,
    configurator = TabsConfigurator,
)

private val Tags = Component(
    id = nextId(),
    name = "Tags",
    description = R.string.component_tag_description,
    illustration = R.drawable.illu_component_tags,
    tintIcon = false,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/295e88-tag/b/86ead2",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.tags/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/tags/Tag.kt",
    examples = TagsExamples,
    configurator = TagsConfigurator,
)

private val Progressbars = Component(
    id = nextId(),
    name = "Progressbars",
    description = R.string.component_progressbar_description,
    illustration = R.drawable.ic_progressbar,
    tintIcon = false,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/89544a-progress-bar/b/2873c8",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.progressbar/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/progressbar/Progressbar.kt",
    examples = ProgressbarExamples,
    configurator = ProgressbarConfigurator,
)

private val Dividers = Component(
    id = nextId(),
    name = "Dividers",
    description = R.string.component_divider_description,
    illustration = R.drawable.illu_component_placeholder,
    tintIcon = false,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/867b47-divider",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.divider/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/divider/Divider.kt",
    examples = DividerExamples,
    configurator = DividerConfigurator,
)

private val ProgressTracker = Component(
    id = nextId(),
    name = "Progress Tracker",
    description = R.string.component_progresstracker_description,
    illustration = R.drawable.illu_component_progresstracker,
    tintIcon = false,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/549af2-progress-tracker/b/207b6b",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.progress.tracker/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/progress/tracker/ProgressbarTracker.kt",
    examples = ProgressTrackerExamples,
    configurator = ProgressTrackerConfigurator,
)

private val TextLinks = Component(
    id = nextId(),
    name = "TextLinks",
    description = R.string.component_textlink_description,
    illustration = R.drawable.icon_textlink,
    tintIcon = false,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/75ed11-textlink/b/403107",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.text/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/text/TextLink.kt",
    examples = TextLinksExamples,
    configurator = TextLinksConfigurator,
)

private val Sliders = Component(
    id = nextId(),
    name = "Slider",
    description = R.string.component_slider_description,
    illustration = R.drawable.illu_component_placeholder,
    tintIcon = false,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/25cceb-slider/b/",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.slider/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/slider/Slider.kt",
    examples = SlidersExamples,
    configurator = SlidersConfigurator,
)

private val TextFields = Component(
    id = nextId(),
    name = "TextFields",
    description = R.string.component_textfield_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/773c60-input--text-field/b/0658e2",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.textfields/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/textfields/TextField.kt",
    examples = TextFieldsExamples,
    configurator = TextFieldsConfigurator,
)

private val Tokens = Component(
    id = nextId(),
    name = "Tokens",
    illustration = R.drawable.illu_component_tokens,
    tintIcon = false,
    description = R.string.component_tokens_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/3075e9-foundations",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.tokens/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/tokens/Color.kt",
    examples = TokensExamples,
    configurator = null,
)

/** Components for the catalog, ordered alphabetically by name. */
public val Components: List<Component> = listOf(
    Tokens,
    BottomSheets,
    Buttons,
    Checkboxes,
    Chips,
    Dialogs,
    Dividers,
    Dropdowns,
    Icons,
    IconButtons,
    IconToggleButtons,
    Popovers,
    Progressbars,
    ProgressTracker,
    RadioButtons,
    Rating,
    Switches,
    Tabs,
    Tags,
    TextFields,
    TextLinks,
    Sliders,
    Snackbars,
)
