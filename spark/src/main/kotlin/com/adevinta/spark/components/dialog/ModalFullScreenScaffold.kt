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
package com.adevinta.spark.components.dialog

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.OutlinedTextFieldDefaults.MinWidth
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.R
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.IntentColors
import com.adevinta.spark.components.appbar.TopAppBar
import com.adevinta.spark.components.buttons.ButtonFilled
import com.adevinta.spark.components.buttons.ButtonOutlined
import com.adevinta.spark.components.iconbuttons.IconButtonDefaults
import com.adevinta.spark.components.iconbuttons.SparkIconButton
import com.adevinta.spark.components.image.Illustration
import com.adevinta.spark.components.scaffold.Scaffold
import com.adevinta.spark.components.surface.Surface
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.BicycleType
import com.adevinta.spark.icons.Close
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tokens.Layout
import com.adevinta.spark.tokens.bodyWidth

/**
 * A composable function that creates a full-screen modal scaffold, adapting its layout based on the device's screen
 * size and orientation.
 *
 * The scaffold provides different layouts for phone portrait, phone landscape, and other
 * devices (e.g., tablets or foldables) where it'll show a modal instead.
 *
 * @param onClose callback that will be invoked when the modal is dismissed
 * @param snackbarHost Component to host Snackbars that are pushed to be shown
 * @param modifier applied to the root Scaffold
 * @param illustration whether the modal display a close icon, and its corresponding action
 * @param mainButton the main actions for this modal (should be a [ButtonFilled])
 * @param supportButton the support or alternative actions for this modal (should any other button than [ButtonFilled])
 * @param reverseButtonOrder inverse the order of the buttons, so the [mainButton] button is shown at the top in
 * portrait mode
 * @param content the center custom Composable for modal content
 */
@OptIn(ExperimentalMaterial3Api::class)
@Deprecated(
    message = "Use ModalFullScreenScaffold instead",
    replaceWith = ReplaceWith(
        expression = "ModalFullScreenScaffold(" +
                "onClose = onClose," +
                "modifier = modifier," +
                "snackbarHost = snackbarHost," +
                "illustration = illustration," +
                "mainButton = mainButton," +
                "supportButton = supportButton," +
                "reverseButtonOrder = reverseButtonOrder," +
                "illustrationContentScale = illustrationContentScale," +
                "content = content," +
                ")",
        imports = ["com.adevinta.spark.components.dialog.ModalFullScreenScaffold"],
    ),
)
@Composable
public fun ModalFullScreenScaffold(
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    snackbarHost: @Composable () -> Unit = {},
    @DrawableRes illustration: Int? = null,
    mainButton: @Composable (Modifier) -> Unit = {},
    supportButton: @Composable (Modifier) -> Unit = {},
    title: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior? = null,
    body: String? = null,
    reverseButtonOrder: Boolean = false,
    illustrationContentScale: ContentScale = ContentScale.Fit,
    content: @Composable (PaddingValues) -> Unit,
) {

}

/**
 * A composable function that creates a full-screen modal scaffold, adapting its layout based on the device's screen
 * size and orientation.
 *
 * The scaffold provides different layouts for phone portrait, phone landscape, and other
 * devices (e.g., tablets or foldables) where it'll show a modal instead.
 *
 * @param onClose callback that will be invoked when the modal is dismissed
 * @param snackbarHost Component to host Snackbars that are pushed to be shown
 * @param modifier applied to the root Scaffold
 * @param illustration whether the modal display a close icon, and its corresponding action
 * @param mainButton the main actions for this modal (should be a [ButtonFilled])
 * @param supportButton the support or alternative actions for this modal (should any other button than [ButtonFilled])
 * @param reverseButtonOrder inverse the order of the buttons, so the [mainButton] button is shown at the top in
 * portrait mode
 * @param content the center custom Composable for modal content
 */
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalSparkApi
@Composable
public fun ModalScaffold(
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    snackbarHost: @Composable () -> Unit = {},
    mainButton: @Composable (Modifier) -> Unit = {},
    supportButton: @Composable (Modifier) -> Unit = {},
    title: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior? = null,
    content: @Composable (PaddingValues) -> Unit,
) {
    val size = Layout.windowSize
    val isPhoneLandscape = size.heightSizeClass == WindowHeightSizeClass.Compact
    val isPhonePortraitOrFoldable =
        (size.widthSizeClass == WindowWidthSizeClass.Compact || size.widthSizeClass == WindowWidthSizeClass.Medium) &&
                size.heightSizeClass == WindowHeightSizeClass.Medium

    val properties = DialogProperties(
        usePlatformDefaultWidth = true,
        decorFitsSystemWindows = false,
    )
    val navigationBarPadding = WindowInsets.navigationBars.asPaddingValues()

    illustration?.let {
        Illustration(
            drawableRes = it,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight(.4f)
                .fillMaxWidth(.8f)
                .align(Alignment.CenterHorizontally)
                .padding(top = innerPadding.calculateTopPadding(), bottom = 24.dp),
            contentScale = illustrationContentScale,
        )
    }

    when {
        isPhonePortraitOrFoldable -> PhonePortraitModalScaffold(
            modifier = modifier,
            properties = properties,
            navigationBarPadding = navigationBarPadding,
            onClose = onClose,
            snackbarHost = snackbarHost,
            mainButton = mainButton,
            supportButton = supportButton,
            title = title,
            actions = actions,
            scrollBehavior = scrollBehavior,
            content = content,
        )

        isPhoneLandscape -> PhoneLandscapeModalScaffold(
            modifier = modifier,
            properties = properties,
            navigationBarPadding = navigationBarPadding,
            onClose = onClose,
            mainButton = mainButton,
            supportButton = supportButton,
            content = content,
        )

        else -> ModalScaffold(
            modifier = modifier,
            properties = properties,
            onClose = onClose,
            mainButton = mainButton,
            supportButton = supportButton,
            content = content,
        )
    }
}

@Composable
private fun ModalScaffold(
    onClose: () -> Unit,
    properties: DialogProperties,
    modifier: Modifier = Modifier,
    snackbarHost: @Composable () -> Unit = {},
    @DrawableRes illustration: Int? = null,
    mainButton: @Composable (Modifier) -> Unit = {},
    supportButton: @Composable (Modifier) -> Unit = {},
    illustrationContentScale: ContentScale = ContentScale.Fit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Dialog(
        onDismissRequest = onClose,
        properties = properties,
    ) {
        Surface(
            modifier = modifier.padding(DialogWindowPadding),
            elevation = 6.dp,
            shape = SparkTheme.shapes.large,
        ) {
            Column(
                modifier = Modifier
                    .widthIn(min = MinWidth, max = MaxWidth)
                    .padding(DialogPadding),
            ) {
                snackbarHost()
                illustration?.let {
                    Illustration(
                        drawableRes = it,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxHeight(.4f)
                            .fillMaxWidth(.8f)
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = 24.dp),
                        contentScale = illustrationContentScale,
                    )
                }
                Box(modifier = Modifier.weight(1f, fill = false)) {
                    content(PaddingValues())
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
                ) {
                    supportButton(Modifier)
                    mainButton(Modifier)
                }
            }
        }
    }
}

@Composable
private fun getDialogWindow(): Window? = (LocalView.current.parent as? DialogWindowProvider)?.window

@Composable
private fun getActivityWindow(): Window? = LocalView.current.context.getActivityWindow()

private tailrec fun Context.getActivityWindow(): Window? =
    when (this) {
        is Activity -> window
        is ContextWrapper -> baseContext.getActivityWindow()
        else -> null
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PhonePortraitModalScaffold(
    onClose: () -> Unit,
    properties: DialogProperties,
    navigationBarPadding: PaddingValues,
    modifier: Modifier = Modifier,
    snackbarHost: @Composable () -> Unit = {},
    title: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior? = null,
    mainButton: @Composable (Modifier) -> Unit = {},
    supportButton: @Composable (Modifier) -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {

    Dialog(
        onDismissRequest = onClose,
        properties = properties,
    ) {
        // Work around for b/246909281 as for now Dialog doesn't pass the drawing insets to its content
        val activityWindow = getActivityWindow()
        val dialogWindow = getDialogWindow()
        val parentView = LocalView.current.parent as View
        SideEffect {
            if (activityWindow != null && dialogWindow != null) {
                val attributes = WindowManager.LayoutParams()
                attributes.copyFrom(activityWindow.attributes)
                attributes.type = dialogWindow.attributes.type
                dialogWindow.attributes = attributes
                parentView.layoutParams =
                    FrameLayout.LayoutParams(activityWindow.decorView.width, activityWindow.decorView.height)
            }
        }

        LaunchedEffect(Unit) {
            dialogWindow?.statusBarColor = Color.Transparent.toArgb()
            dialogWindow?.navigationBarColor = Color.Transparent.toArgb()
        }

        Scaffold(
            modifier = modifier
                .fillMaxSize()
                .imePadding(),
            snackbarHost = snackbarHost,
            contentWindowInsets = WindowInsets(0.dp),
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        CloseIconButton(onClose = onClose)
                    },
                    title = title,
                    actions = actions,
                    scrollBehavior = scrollBehavior,
                )
            },
            bottomBar = {
                Surface {
                    val buttonsLayoutModifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(navigationBarPadding)
                    if (Layout.windowSize.widthSizeClass == WindowWidthSizeClass.Compact) {
                        Column(
                            modifier = buttonsLayoutModifier.padding(vertical = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Bottom),
                        ) {
                            val buttonModifier = Modifier.fillMaxWidth()
                            mainButton(buttonModifier)
                            supportButton(buttonModifier)
                        }
                    } else {
                        Row(
                            modifier = buttonsLayoutModifier.padding(bottom = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.End),
                        ) {
                            supportButton(Modifier)
                            mainButton(Modifier)
                        }
                    }
                }
            },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .bodyWidth()
                    .padding(horizontal = 24.dp),
            ) {
                content(
                    PaddingValues(
                        start = innerPadding.calculateLeftPadding(LocalLayoutDirection.current),
                        end = innerPadding.calculateRightPadding(LocalLayoutDirection.current),
                        top = innerPadding.calculateTopPadding(),
                        bottom = innerPadding.calculateBottomPadding(),
                    ),
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PhoneLandscapeModalScaffold(
    onClose: () -> Unit,
    properties: DialogProperties,
    navigationBarPadding: PaddingValues,
    modifier: Modifier = Modifier,
    snackbarHost: @Composable () -> Unit = {},
    @DrawableRes illustration: Int? = null,
    mainButton: @Composable (Modifier) -> Unit = {},
    supportButton: @Composable (Modifier) -> Unit = {},
    illustrationContentScale: ContentScale = ContentScale.Fit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Dialog(
        onDismissRequest = onClose,
        properties = properties,

        ) {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            snackbarHost = snackbarHost,
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        CloseIconButton(onClose = onClose)
                    },
                    title = { },
                )
            },
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = Layout.bodyMargin),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Layout.gutter),
            ) {
                illustration?.let {
                    Box(
                        modifier = Modifier
                            .weight(.8f),
                        contentAlignment = Alignment.Center,
                    ) {
                        Illustration(
                            drawableRes = it,
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(.8f),
                            contentScale = illustrationContentScale,
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Box(modifier = Modifier.weight(1f, fill = false)) {
                        content(innerPadding)
                    }
                    Row(
                        modifier = Modifier
                            .padding(bottom = 16.dp, top = 8.dp)
                            .padding(navigationBarPadding)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.End),
                    ) {
                        val buttonModifier = Modifier.weight(1f)
                        supportButton(buttonModifier)
                        mainButton(buttonModifier)
                    }
                }
            }
        }
    }
}

@Composable
private fun CloseIconButton(
    onClose: () -> Unit,
) {
    SparkIconButton(
        icon = SparkIcons.Close,
        onClick = onClose,
        contentDescription = stringResource(id = R.string.spark_a11y_modal_fullscreen_close),
        colors = IconButtonDefaults.ghostIconButtonColors(
            IntentColors.Danger.colors(),
            contentColor = LocalContentColor.current,
        ),
    )
}

private val MinWidth = 280.dp
private val MaxWidth = 560.dp

private val DialogPadding = PaddingValues(all = 24.dp)
private val DialogWindowPadding = PaddingValues(all = 32.dp)

//@DevicePreviews
//@Preview(
//    name = "phone",
//    group = "devices",
//    showBackground = true,
//    locale = "fr-rFR",
//    heightDp = 411,
//    widthDp = 891,
//)
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun ModalPreview() {
    PreviewTheme(
        padding = PaddingValues(),
    ) {
        ModalFullScreenScaffold(
            onClose = { /*TODO*/ },
            illustration = SparkIcons.BicycleType.drawableId,
            mainButton = {
                ButtonFilled(modifier = it, onClick = { /*TODO*/ }, text = "Main Action")
            },
            supportButton = {
                ButtonOutlined(modifier = it, onClick = { /*TODO*/ }, text = "Alternative Action")
            },
            reverseButtonOrder = true,
            illustrationContentScale = ContentScale.FillWidth,
            body = "Body with description. An optional accessible description to be announced when the dialog is opened.",
        ) { innerPadding ->
            Text(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState()),
                text = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. " +
                        "Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur " +
                        "ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. " +
                        "\n\nNulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, " +
                        "vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. " +
                        "Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. " +
                        "Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. " +
                        "\n\nAenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante," +
                        " dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius " +
                        "laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. " +
                        "Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. " +
                        "\n\nMaecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet " +
                        "adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, " +
                        "lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis " +
                        "faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. " +
                        "Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. " +
                        "Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,",
            )
        }
    }
}
