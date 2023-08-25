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

import androidx.annotation.StringRes
import com.adevinta.spark.catalog.R
import com.adevinta.spark.catalog.configurator.samples.buttons.ButtonsConfigurator
import com.adevinta.spark.catalog.configurator.samples.buttons.IconButtonsConfigurator
import com.adevinta.spark.catalog.configurator.samples.buttons.IconToggleButtonsConfigurator
import com.adevinta.spark.catalog.configurator.samples.textfields.TextFieldsConfigurator
import com.adevinta.spark.catalog.configurator.samples.toggles.CheckboxConfigurator
import com.adevinta.spark.catalog.configurator.samples.toggles.RadioButtonConfigurator
import com.adevinta.spark.catalog.configurator.samples.toggles.SwitchConfigurator
import com.adevinta.spark.catalog.examples.samples.buttons.ButtonsExamples
import com.adevinta.spark.catalog.examples.samples.buttons.IconButtonsExamples
import com.adevinta.spark.catalog.examples.samples.toggles.CheckboxExamples
import com.adevinta.spark.catalog.examples.samples.toggles.IconToggleButtonsExamples
import com.adevinta.spark.catalog.examples.samples.toggles.RadioButtonExamples
import com.adevinta.spark.catalog.examples.samples.toggles.SwitchExamples
import com.adevinta.spark.catalog.util.ComponentGuidelinesUrl
import com.adevinta.spark.catalog.util.PackageSummaryUrl
import com.adevinta.spark.catalog.util.SparkSourceUrl

public data class Component(
    val id: Int,
    val name: String,
    @StringRes
    val description: Int,
    val tintIcon: Boolean = true,
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
    description = R.string.component_button_description,
    // No buttons icon
    guidelinesUrl = "$ComponentGuidelinesUrl/p/34b742-button/b/32e1a2",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.buttons/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/buttons/Button.kt",
    examples = ButtonsExamples,
    configurator = ButtonsConfigurator,
)

private val Checkboxes = Component(
    id = nextId(),
    name = "Checkboxes",
    description = R.string.component_checkbox_description,
    // No buttons icon
    guidelinesUrl = "$ComponentGuidelinesUrl/p/76f5a8-checkbox/b/98915d",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.toggles/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/toggles/CheckBox.kt",
    examples = CheckboxExamples,
    configurator = CheckboxConfigurator,
)

private val IconButtons = Component(
    id = nextId(),
    name = "IconButtons",
    description = R.string.component_iconbutton_description,
    // No buttons icon
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
    // No buttons icon
    guidelinesUrl = "$ComponentGuidelinesUrl/p/2352e9-icon-button/b/32e1a2",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.iconbuttons/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/iconTogglebuttons/IconToggleButton.kt",
    examples = IconToggleButtonsExamples,
    configurator = IconToggleButtonsConfigurator,
)

private val RadioButtons = Component(
    id = nextId(),
    name = "Radio buttons",
    description = R.string.component_radiobutton_description,
    // No buttons icon
    guidelinesUrl = "$ComponentGuidelinesUrl/p/98058f-radio-button/b/700a17",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.toggles/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/toggles/RadioButton.kt",
    examples = RadioButtonExamples,
    configurator = RadioButtonConfigurator,
)

private val Switches = Component(
    id = nextId(),
    name = "Switches",
    description = R.string.component_switch_description,
    // No buttons icon
    guidelinesUrl = "$ComponentGuidelinesUrl/p/58a2c6-switch/b/700a17",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.toggles/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/spark/components/toggles/Switch.kt",
    examples = SwitchExamples,
    configurator = SwitchConfigurator,
)

private val TextFields = Component(
    id = nextId(),
    name = "TextFields",
    description = R.string.component_textfield_description,
    // No buttons icon
    guidelinesUrl = "$ComponentGuidelinesUrl/p/773c60-input--text-field/b/0658e2",
    docsUrl = "$PackageSummaryUrl/com.adevinta.spark.components.textfields/index.html",
    sourceUrl = "$SparkSourceUrl/kotlin/com/adevinta/components/textfields/TextField.kt",
    examples = emptyList(),
    configurator = TextFieldsConfigurator,
)

/** Components for the catalog, ordered alphabetically by name. */
public val Components: List<Component> = listOf(
    Buttons,
    Checkboxes,
    IconButtons,
    IconToggleButtons,
    RadioButtons,
    Switches,
    TextFields,
)
