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
import com.adevinta.spark.catalog.configurator.samples.buttons.ButtonsConfigurator
import com.adevinta.spark.catalog.configurator.samples.buttons.IconButtonsConfigurator
import com.adevinta.spark.catalog.configurator.samples.buttons.IconToggleButtonsConfigurator
import com.adevinta.spark.catalog.configurator.samples.tabs.TabsConfigurator
import com.adevinta.spark.catalog.configurator.samples.tags.TagsConfigurator
import com.adevinta.spark.catalog.configurator.samples.textfields.TextFieldsConfigurator
import com.adevinta.spark.catalog.configurator.samples.toggles.CheckboxConfigurator
import com.adevinta.spark.catalog.configurator.samples.toggles.RadioButtonConfigurator
import com.adevinta.spark.catalog.configurator.samples.toggles.SwitchConfigurator
import com.adevinta.spark.catalog.examples.samples.buttons.ButtonsExamples
import com.adevinta.spark.catalog.examples.samples.buttons.IconButtonsExamples
import com.adevinta.spark.catalog.examples.samples.dialog.DialogsExamples
import com.adevinta.spark.catalog.examples.samples.popover.PopoverExamples
import com.adevinta.spark.catalog.examples.samples.tabs.TabsExamples
import com.adevinta.spark.catalog.examples.samples.tags.TagsExamples
import com.adevinta.spark.catalog.examples.samples.text.TextLinksExamples
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

private val TextLinks = Component(
    id = nextId(),
    name = "TextLinks",
    description = R.string.component_textlink_description,
    illustration = R.drawable.text_link,
    tintIcon = false,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/75ed11-textlink/b/403107",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.text/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/tetx/TextLink.kt",
    examples = TextLinksExamples,
    configurator = TagsConfigurator, // TODO
)

private val TextFields = Component(
    id = nextId(),
    name = "TextFields",
    description = R.string.component_textfield_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/773c60-input--text-field/b/0658e2",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.textfields/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/textfields/TextField.kt",
    examples = emptyList(),
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

private val Popovers = Component(
    id = nextId(),
    name = "Popovers",
    illustration = R.drawable.illu_component_tokens,
    tintIcon = false,
    description = R.string.component_popovers_description,
    guidelinesUrl = "$ComponentGuidelinesUrl/p/88a08c-popover/b/904ceb",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.popover/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/popover/Color.kt",
    examples = PopoverExamples,
    configurator = null,
)

/** Components for the catalog, ordered alphabetically by name. */
public val Components: List<Component> = listOf(
    Tokens,
    Buttons,
    Checkboxes,
    Dialogs,
    IconButtons,
    IconToggleButtons,
    RadioButtons,
    Switches,
    Tabs,
    Tags,
    TextLinks,
    TextFields,
    Popovers,
)
