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

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.adevinta.spark.ExperimentalSparkApi
import com.adevinta.spark.PreviewTheme
import com.adevinta.spark.R
import com.adevinta.spark.SparkTheme
import com.adevinta.spark.components.appbar.TopAppBar
import com.adevinta.spark.components.buttons.ButtonFilled
import com.adevinta.spark.components.buttons.ButtonOutlined
import com.adevinta.spark.components.icons.Icon
import com.adevinta.spark.components.icons.IconButton
import com.adevinta.spark.components.image.Illustration
import com.adevinta.spark.components.scaffold.Scaffold
import com.adevinta.spark.components.text.Text
import com.adevinta.spark.icons.BicycleType
import com.adevinta.spark.icons.Close
import com.adevinta.spark.icons.SparkIcons
import com.adevinta.spark.tokens.Layout
import com.adevinta.spark.tokens.bodyWidth
import com.adevinta.spark.tokens.dim2
import com.adevinta.spark.tools.preview.DevicePreviews

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
 * @param reverseButtonOrder inverse the order of the buttons, so the [mainButton] button is shown at the top in portrait mode
 * @param content the center custom Composable for modal content
 */
@ExperimentalSparkApi
@Composable
public fun ModalFullScreenScaffold(
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    snackbarHost: @Composable () -> Unit = {},
    @DrawableRes illustration: Int? = null,
    mainButton: @Composable (Modifier) -> Unit = {},
    supportButton: @Composable (Modifier) -> Unit = {},
    reverseButtonOrder: Boolean = false,
    illustrationContentScale: ContentScale = ContentScale.Fit,
    content: @Composable (PaddingValues) -> Unit,
) {
    val size = Layout.windowSize
    val isPhoneLandscape = size.heightSizeClass == WindowHeightSizeClass.Compact
    val isPhonePortraitOrFoldable =
        (size.widthSizeClass == WindowWidthSizeClass.Compact || size.widthSizeClass == WindowWidthSizeClass.Medium) &&
                size.heightSizeClass == WindowHeightSizeClass.Medium

    when {
        isPhonePortraitOrFoldable -> {
            PhonePortraitModalScaffold(
                modifier = modifier,
                onClose = onClose,
                snackbarHost = snackbarHost,
                illustration = illustration,
                mainButton = mainButton,
                supportButton = supportButton,
                reverseButtonOrder = reverseButtonOrder,
                illustrationContentScale = illustrationContentScale,
                content = content,
            )
        }

        isPhoneLandscape -> {
            PhoneLandscapeModalScaffold(
                modifier = modifier,
                onClose = onClose,
                illustration = illustration,
                mainButton = mainButton,
                supportButton = supportButton,
                illustrationContentScale = illustrationContentScale,
                content = content,
            )
        }

        else -> ModalScaffold(
            modifier = modifier,
            onClose = onClose,
            illustration = illustration,
            mainButton = mainButton,
            supportButton = supportButton,
            illustrationContentScale = illustrationContentScale,
            content = content,
        )
    }
}

@Composable
private fun ModalScaffold(
    onClose: () -> Unit,
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
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
        ),
    ) {
        Surface(
            modifier = modifier.padding(DialogWindowPadding),
            shadowElevation = 6.dp,
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PhonePortraitModalScaffold(
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    snackbarHost: @Composable () -> Unit = {},
    @DrawableRes illustration: Int? = null,
    mainButton: @Composable (Modifier) -> Unit = {},
    supportButton: @Composable (Modifier) -> Unit = {},
    reverseButtonOrder: Boolean = false,
    illustrationContentScale: ContentScale = ContentScale.Fit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = snackbarHost,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClose) {
                        Icon(
                            sparkIcon = SparkIcons.Close,
                            tint = SparkTheme.colors.onSurface.dim2,
                            contentDescription = stringResource(id = R.string.spark_a11y_modal_fullscreen_close),
                        )
                    }
                },
                title = { },
            )
        },
        bottomBar = {
            Surface {
                if (Layout.windowSize.widthSizeClass == WindowWidthSizeClass.Compact) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Layout.bodyMargin)
                            .padding(bottom = 16.dp, top = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom),
                    ) {
                        val buttonModifier = Modifier.fillMaxWidth()
                        if (reverseButtonOrder) mainButton(buttonModifier)
                        supportButton(buttonModifier)
                        if (!reverseButtonOrder) mainButton(buttonModifier)
                    }
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Layout.bodyMargin)
                            .padding(bottom = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End),
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
                .padding(horizontal = Layout.bodyMargin),
        ) {
            illustration?.let {
                Illustration(
                    drawableRes = it,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight(.4f)
                        .fillMaxWidth(.8f)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = innerPadding.calculateTopPadding()),
                    contentScale = illustrationContentScale,
                )
            }
            content(
                PaddingValues(
                    start = innerPadding.calculateLeftPadding(LocalLayoutDirection.current),
                    end = innerPadding.calculateRightPadding(LocalLayoutDirection.current),
                    top = 24.dp,
                    bottom = innerPadding.calculateBottomPadding(),
                ),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PhoneLandscapeModalScaffold(
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    snackbarHost: @Composable () -> Unit = {},
    @DrawableRes illustration: Int? = null,
    mainButton: @Composable (Modifier) -> Unit = {},
    supportButton: @Composable (Modifier) -> Unit = {},
    illustrationContentScale: ContentScale = ContentScale.Fit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = snackbarHost,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClose) {
                        Icon(
                            sparkIcon = SparkIcons.Close,
                            tint = SparkTheme.colors.onSurface.dim2,
                            contentDescription = stringResource(id = R.string.spark_a11y_modal_fullscreen_close),
                        )
                    }
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

private val MinWidth = 280.dp
private val MaxWidth = 560.dp

private val DialogPadding = PaddingValues(all = 24.dp)
private val DialogWindowPadding = PaddingValues(all = 32.dp)

@DevicePreviews
@Preview(
    name = "phone",
    group = "devices",
    showBackground = true,
    locale = "fr-rFR",
    heightDp = 411,
    widthDp = 891,
)
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
