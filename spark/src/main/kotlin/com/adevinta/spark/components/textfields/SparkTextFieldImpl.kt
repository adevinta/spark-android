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

package com.adevinta.spark.components.textfields

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.layout.IntrinsicMeasurable
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.LayoutIdParentData
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.lerp
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import com.adevinta.spark.SparkTheme

/**
 * Implementation of the [TextField]
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SparkDecorationBox(
    value: String,
    innerTextField: @Composable () -> Unit,
    visualTransformation: VisualTransformation,
    label: @Composable() (() -> Unit)?,
    interactionSource: InteractionSource,
    colors: DefaultSparkTextFieldColors,
    placeholder: @Composable() (() -> Unit)? = null,
    supportingText: @Composable() (() -> Unit)? = null,
    counter: @Composable() (() -> Unit)? = null,
    leadingIcon: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
    singleLine: Boolean = false,
    enabled: Boolean = true,
    isError: Boolean = false,
    border: @Composable() (() -> Unit)? = null,
) {
    val transformedText = remember(value, visualTransformation) {
        visualTransformation.filter(AnnotatedString(value))
    }.text.text

    val contentPadding = TextFieldDefaults.outlinedTextFieldPadding()

    val isFocused = interactionSource.collectIsFocusedAsState().value
    val inputState = when {
        isFocused -> InputPhase.Focused
        transformedText.isEmpty() -> InputPhase.UnfocusedEmpty
        else -> InputPhase.UnfocusedNotEmpty
    }

    val labelColor: @Composable (InputPhase) -> Color = {
        colors.labelColor(enabled, isError, interactionSource).value
    }

    val typography = SparkTheme.typography
    val bodyLarge = typography.body1
    val bodySmall = typography.caption
    val shouldOverrideTextStyleColor =
        (bodyLarge.color == Color.Unspecified && bodySmall.color != Color.Unspecified) ||
                (bodyLarge.color != Color.Unspecified && bodySmall.color == Color.Unspecified)

    TextFieldTransitionScope.Transition(
        inputState = inputState,
        focusedTextStyleColor = with(SparkTheme.typography.caption.color) {
            if (shouldOverrideTextStyleColor) this.takeOrElse { labelColor(inputState) } else this
        },
        unfocusedTextStyleColor = with(SparkTheme.typography.body1.color) {
            if (shouldOverrideTextStyleColor) this.takeOrElse { labelColor(inputState) } else this
        },
        contentColor = labelColor,
        showLabel = label != null,
    ) { labelProgress, labelTextStyleColor, labelContentColor, placeholderAlphaProgress ->

        val decoratedLabel: @Composable (() -> Unit)? = label?.let {
            @Composable {
                val labelTextStyle = lerp(
                    SparkTheme.typography.body1,
                    SparkTheme.typography.caption,
                    labelProgress,
                ).let {
                    if (shouldOverrideTextStyleColor) it.copy(color = labelTextStyleColor) else it
                }
                Decoration(labelContentColor, labelTextStyle, it)
            }
        }

        val decoratedPlaceholder: @Composable ((Modifier) -> Unit)? =
            if (placeholder != null && transformedText.isEmpty()) {
                @Composable { modifier ->
                    Box(modifier.alpha(placeholderAlphaProgress)) {
                        Decoration(
                            contentColor = colors.placeholderColor(enabled).value,
                            typography = SparkTheme.typography.body1,
                            content = placeholder,
                        )
                    }
                }
            } else null


        val decoratedCounter: @Composable (() -> Unit)? = counter?.let {
            @Composable {
                Box {
                    Decoration(
                        contentColor = colors.supportingTextColor(
                            enabled = enabled,
                            isError = isError,
                            interactionSource = interactionSource,
                        ).value,
                        typography = SparkTheme.typography.caption,
                        content = counter,
                    )
                }
            }
        }

        // Developers need to handle invalid input manually. But since we don't provide error
        // message slot API, we can set the default error message in case developers forget about
        // it.
        // TODO-@soulcramer (01-30-2023): We should provide a semantic which tell the user the error state
        val decorationBoxModifier = Modifier

        val leadingIconColor = colors.leadingIconColor(enabled, isError, interactionSource).value
        val decoratedLeading: @Composable (() -> Unit)? = leadingIcon?.let {
            @Composable {
                Decoration(contentColor = leadingIconColor, content = it)
            }
        }

        val trailingIconColor = colors.trailingIconColor(enabled, isError, interactionSource).value
        val decoratedTrailing: @Composable (() -> Unit)? = trailingIcon?.let {
            @Composable {
                Decoration(contentColor = trailingIconColor, content = it)
            }
        }

        // Outlined cutout
        val labelSize = remember { mutableStateOf(Size.Zero) }
        val borderContainerWithId: @Composable () -> Unit = {
            Box(
                Modifier
                    .layoutId(ContainerId)
                    .outlineCutout(labelSize.value, contentPadding),
                propagateMinConstraints = true,
            ) {
                border?.invoke()
            }
        }

        val supportingTextColor =
            colors.supportingTextColor(enabled, isError, interactionSource).value
        val decoratedSupporting: @Composable (() -> Unit)? = supportingText?.let {
            @Composable {
                Decoration(
                    contentColor = supportingTextColor,
                    typography = bodySmall,
                    content = it,
                )
            }
        }

        SparkTextFieldLayout(
            textField = innerTextField,
            placeholder = decoratedPlaceholder,
            label = decoratedLabel,
            counter = decoratedCounter,
            leading = decoratedLeading,
            trailing = decoratedTrailing,
            singleLine = singleLine,
            animationProgress = labelProgress,
            onLabelMeasured = {
                val labelWidth = it.width * labelProgress
                val labelHeight = it.height * labelProgress
                if (labelSize.value.width != labelWidth ||
                    labelSize.value.height != labelHeight
                ) {
                    labelSize.value = Size(labelWidth, labelHeight)
                }
            },
            container = borderContainerWithId,
            supporting = decoratedSupporting,
            paddingValues = contentPadding,
            modifier = decorationBoxModifier,
        )
    }
}

/**
 * Set content color, typography and emphasis for [content] composable
 */
@Composable
@ComposableOpenTarget(index = 0)
internal fun Decoration(
    contentColor: Color,
    typography: TextStyle? = null,
    content: @Composable @ComposableOpenTarget(index = 0) () -> Unit,
) {
    val colorAndEmphasis: @Composable () -> Unit = @Composable {
        CompositionLocalProvider(LocalContentColor provides contentColor, content = content)
    }
    if (typography != null) ProvideTextStyle(typography, colorAndEmphasis) else colorAndEmphasis()
}

/**
 * Layout of the leading and trailing icons and the text field, label and placeholder in
 * [SparkTextFieldLayout].
 * It doesn't use Row to position the icons and middle part because label should not be
 * positioned in the middle part.
 */
@Composable
internal fun SparkTextFieldLayout(
    textField: @Composable () -> Unit,
    placeholder: @Composable() ((Modifier) -> Unit)?,
    label: @Composable() (() -> Unit)?,
    counter: @Composable() (() -> Unit)?,
    leading: @Composable() (() -> Unit)?,
    trailing: @Composable() (() -> Unit)?,
    singleLine: Boolean,
    animationProgress: Float,
    onLabelMeasured: (Size) -> Unit,
    container: @Composable () -> Unit,
    supporting: @Composable() (() -> Unit)?,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    val measurePolicy = remember(onLabelMeasured, singleLine, animationProgress, paddingValues) {
        SparkTextFieldMeasurePolicy(
            onLabelMeasured,
            singleLine,
            animationProgress,
            paddingValues,
        )
    }
    val layoutDirection = LocalLayoutDirection.current
    Layout(
        modifier = modifier,
        content = {
            // We use additional box here to place an outlined cutout border as a sibling after the
            // rest of UI. This allows us to use Modifier.border to draw an outline on top of the
            // text field. We can't use the border modifier directly on the IconsWithTextFieldLayout
            // as we also need to do the clipping (to form the cutout) which should not affect
            // the rest of text field UI
            container()

            if (leading != null) {
                Box(
                    modifier = Modifier
                        .layoutId(LeadingId)
                        .then(IconDefaultSizeModifier),
                    contentAlignment = Alignment.Center,
                ) {
                    leading()
                }
            }
            if (trailing != null) {
                Box(
                    modifier = Modifier
                        .layoutId(TrailingId)
                        .then(IconDefaultSizeModifier),
                    contentAlignment = Alignment.Center,
                ) {
                    trailing()
                }
            }

            val startTextFieldPadding = paddingValues.calculateStartPadding(layoutDirection)
            val endTextFieldPadding = paddingValues.calculateEndPadding(layoutDirection)
            val padding = Modifier.padding(
                start = if (leading != null) {
                    (startTextFieldPadding - HorizontalIconPadding).coerceAtLeast(
                        0.dp,
                    )
                } else {
                    startTextFieldPadding
                },
                end = if (trailing != null) {
                    (endTextFieldPadding - HorizontalIconPadding).coerceAtLeast(0.dp)
                } else {
                    endTextFieldPadding
                },
            )
            if (placeholder != null) {
                placeholder(
                    Modifier
                        .layoutId(PlaceholderId)
                        .then(padding),
                )
            }

            Box(
                modifier = Modifier
                    .layoutId(TextFieldId)
                    .then(padding),
                propagateMinConstraints = true,
            ) {
                textField()
            }

            if (label != null) {
                Box(modifier = Modifier.layoutId(LabelId)) { label() }
            }

            if (supporting != null) {
                val helperModifier = Modifier
                    .layoutId(SupportingId)
                    .paddingFromBaseline(top = 16.dp)
                Box(modifier = helperModifier) {
                    supporting()
                }
            }
            if (counter != null) {
                val helperModifier = Modifier
                    .layoutId(CounterId)
                    .paddingFromBaseline(top = 16.dp)
                Box(modifier = helperModifier) {
                    counter()
                }
            }

        },
        measurePolicy = measurePolicy,
    )
}

internal fun widthOrZero(placeable: Placeable?) = placeable?.width ?: 0
internal fun heightOrZero(placeable: Placeable?) = placeable?.height ?: 0

internal fun Modifier.outlineCutout(labelSize: Size, paddingValues: PaddingValues) =
    this.drawWithContent {
        val labelWidth = labelSize.width
        if (labelWidth > 0f) {
            val innerPadding = OutlinedTextFieldInnerPadding.toPx()
            val leftLtr = paddingValues.calculateLeftPadding(layoutDirection).toPx() - innerPadding
            val rightLtr = leftLtr + labelWidth + 2 * innerPadding
            val left = when (layoutDirection) {
                LayoutDirection.Rtl -> size.width - rightLtr
                else -> leftLtr.coerceAtLeast(0f)
            }
            val right = when (layoutDirection) {
                LayoutDirection.Rtl -> size.width - leftLtr.coerceAtLeast(0f)
                else -> rightLtr
            }
            val labelHeight = labelSize.height
            // using label height as a cutout area to make sure that no hairline artifacts are
            // left when we clip the border
            clipRect(left, -labelHeight / 2, right, labelHeight / 2, ClipOp.Difference) {
                this@drawWithContent.drawContent()
            }
        } else {
            this@drawWithContent.drawContent()
        }
    }

private object TextFieldTransitionScope {
    @Composable
    fun Transition(
        inputState: InputPhase,
        focusedTextStyleColor: Color,
        unfocusedTextStyleColor: Color,
        contentColor: @Composable (InputPhase) -> Color,
        showLabel: Boolean,
        content: @Composable (
            labelProgress: Float,
            labelTextStyleColor: Color,
            labelContentColor: Color,
            placeholderOpacity: Float,
        ) -> Unit,
    ) {
        // Transitions from/to InputPhase.Focused are the most critical in the transition below.
        // UnfocusedEmpty <-> UnfocusedNotEmpty are needed when a single state is used to control
        // multiple text fields.
        val transition = updateTransition(inputState, label = "TextFieldInputState")

        val labelProgress by transition.animateFloat(
            label = "LabelProgress",
            transitionSpec = { tween(durationMillis = AnimationDuration) },
        ) {
            when (it) {
                InputPhase.Focused -> 1f
                InputPhase.UnfocusedEmpty -> 0f
                InputPhase.UnfocusedNotEmpty -> 1f
            }
        }

        val placeholderOpacity by transition.animateFloat(
            label = "PlaceholderOpacity",
            transitionSpec = {
                if (InputPhase.Focused isTransitioningTo InputPhase.UnfocusedEmpty) {
                    tween(
                        durationMillis = PlaceholderAnimationDelayOrDuration,
                        easing = LinearEasing,
                    )
                } else if (InputPhase.UnfocusedEmpty isTransitioningTo InputPhase.Focused ||
                    InputPhase.UnfocusedNotEmpty isTransitioningTo InputPhase.UnfocusedEmpty
                ) {
                    tween(
                        durationMillis = PlaceholderAnimationDuration,
                        delayMillis = PlaceholderAnimationDelayOrDuration,
                        easing = LinearEasing,
                    )
                } else {
                    spring()
                }
            },
        ) {
            when (it) {
                InputPhase.Focused -> 1f
                InputPhase.UnfocusedEmpty -> if (showLabel) 0f else 1f
                InputPhase.UnfocusedNotEmpty -> 0f
            }
        }

        val labelTextStyleColor by transition.animateColor(
            transitionSpec = { tween(durationMillis = AnimationDuration) },
            label = "LabelTextStyleColor",
        ) {
            when (it) {
                InputPhase.Focused -> focusedTextStyleColor
                else -> unfocusedTextStyleColor
            }
        }

        val labelContentColor by transition.animateColor(
            transitionSpec = { tween(durationMillis = AnimationDuration) },
            label = "LabelContentColor",
            targetValueByState = contentColor,
        )

        content(
            labelProgress,
            labelTextStyleColor,
            labelContentColor,
            placeholderOpacity,
        )
    }
}

/**
 * An internal state used to animate a label and an indicator.
 */
private enum class InputPhase {
    // Text field is focused
    Focused,

    // Text field is not focused and input text is empty
    UnfocusedEmpty,

    // Text field is not focused but input text is not empty
    UnfocusedNotEmpty
}

internal val IntrinsicMeasurable.layoutId: Any?
    get() = (parentData as? LayoutIdParentData)?.layoutId

internal const val TextFieldId = "TextField"
internal const val PlaceholderId = "Hint"
internal const val LabelId = "Label"
internal const val LeadingId = "Leading"
internal const val TrailingId = "Trailing"
internal const val SupportingId = "Supporting"
internal const val CounterId = "Counter"

internal val ZeroConstraints = Constraints(0, 0, 0, 0)

internal const val AnimationDuration = 150
private const val PlaceholderAnimationDuration = 83
private const val PlaceholderAnimationDelayOrDuration = 67

internal val TextFieldPadding = 16.dp
internal val CounterPadding = 8.dp
internal val HorizontalIconPadding = 12.dp

internal val IconDefaultSizeModifier = Modifier.defaultMinSize(48.dp, 48.dp)

private val OutlinedTextFieldInnerPadding = 4.dp

internal const val ContainerId = "Container"
