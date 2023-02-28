package com.adevinta.spark.components.toggles

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.adevinta.spark.InternalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.icons.SparkIcon
import com.adevinta.spark.tools.modifiers.minimumTouchTargetSize
import com.adevinta.spark.tools.modifiers.sparkUsageOverlay
import com.adevinta.spark.tools.preview.SparkPreviewParam
import com.adevinta.spark.tools.preview.SparkPreviewParamProvider
import androidx.compose.material3.Switch as MaterialSwitch

@Composable
@InternalSparkApi
internal fun SparkSwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    // Icon isn't focusable, no need for content description
    val icon: (@Composable () -> Unit) = {
        Icon(
            sparkIcon = if (checked) SparkIcon.Toggles.Check.Simple else SparkIcon.Arrows.Close,
            contentDescription = null,
            modifier = Modifier.size(12.dp),
        )
    }
    MaterialSwitch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        interactionSource = interactionSource,
        enabled = enabled,
        thumbContent = icon,
        colors = SwitchDefaults.colors(),
        modifier = modifier.sparkUsageOverlay(),
    )
}

/**
 *
 * Switches are the preferred way to adjust settings. They're used to control binary options – think On/Off or True/False.
 *
 *  - Toggle a single item on or off.
 *  - Immediately activate or deactivate something.
 *
 * @see [SparkSwitch] if you require color customization between states. Be aware that this is still an internal composable so if you need such state contact the Spark team
 *
 * @param checked whether or not this component is checked
 * @param onCheckedChange callback to be invoked when Switch is being clicked, therefore the change of checked state is requested. If null, then this is passive and relies entirely on a higher-level component to control the "checked" state.
 * @param modifier Modifier to be applied to the layout of the switch layout
 * @param enabled whether the component is enabled or grayed out
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this Switch. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this Switch in different [Interaction]s.
 */
@Composable
fun Switch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    SparkSwitch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        interactionSource = interactionSource,
        enabled = enabled,
        modifier = modifier,
    )
}

/**
 *
 * Switches are the preferred way to adjust settings. They're used to control binary options – think On/Off or True/False.
 *
 *  - Toggle a single item on or off.
 *  - Immediately activate or deactivate something.
 *
 * @see [SparkSwitch] if you require color customization between states. Be aware that this is still an internal composable so if you need such state contact the Spark team
 *
 * @param checked whether or not this component is checked
 * @param onCheckedChange callback to be invoked when Switch is being clicked, therefore the change of checked state is requested. If null, then this is passive and relies entirely on a higher-level component to control the "checked" state.
 * @param modifier Modifier to be applied to the layout of the switch layout
 * @param enabled whether the component is enabled or grayed out
 * @param interactionSource the [MutableInteractionSource] representing the stream of
 * [Interaction]s for this Switch. You can create and pass in your own remembered
 * [MutableInteractionSource] if you want to observe [Interaction]s and customize the
 * appearance / behavior of this Switch in different [Interaction]s.
 * @param startContent The start content displayed before the checkbox, Usually a Text composable
 */
@Composable
fun SwitchLabelled(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    startContent: @Composable RowScope.() -> Unit,
) {
    SparkToggleLabelledContainer(
        state = ToggleableState(checked),
        toggle = {
            SparkSwitch(
                checked = checked,
                onCheckedChange = null,
                interactionSource = interactionSource,
                enabled = enabled,
                modifier = Modifier.minimumTouchTargetSize(),
            )
        },
        role = Role.Switch,
        onClick = if (onCheckedChange != null) {
            { onCheckedChange(!checked) }
        } else null,
        modifier = modifier.selectableGroup(),
        enabled = enabled,
        startContent = {
            startContent()
        },
    )
}

@Preview(
    group = "Toggles",
    name = "Switch",
)
@Composable
internal fun AllStatesSwitchPreview(
    @PreviewParameter(SparkPreviewParamProvider::class) param: SparkPreviewParam,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        Row {
            Switch(enabled = true, checked = true, onCheckedChange = {})
            Switch(enabled = false, checked = true, onCheckedChange = {})
            Switch(enabled = true, checked = false, onCheckedChange = {})
            Switch(enabled = false, checked = false, onCheckedChange = {})
        }
    }
}


@Preview(
    group = "Toggles",
    name = "SwitchLabelled",
)
@Composable
internal fun AllStatesSwitchLabelledPreview(
    @PreviewParameter(SparkPreviewParamProvider::class) param: SparkPreviewParam,
) {
    val (theme, userType) = param
    PreviewTheme(theme, userType) {
        SwitchLabelled(
            enabled = true,
            checked = true, onCheckedChange = {},
        ) { Text("Switch On") }
        SwitchLabelled(
            enabled = false,
            checked = true, onCheckedChange = {},
        ) { Text("Switch On disabled") }
        SwitchLabelled(
            enabled = true,
            checked = false, onCheckedChange = {},
        ) { Text("Switch Off") }
        SwitchLabelled(
            enabled = false,
            checked = false, onCheckedChange = {},
        ) { Text("Switch Off disabled") }
    }
}
