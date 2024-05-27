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
package com.adevinta.spark.components.snackbars

import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalAccessibilityManager
import com.adevinta.spark.icons.SparkIcon
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.delay
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.coroutines.resume

/**
 * A composable function that displays a SnackbarHost with the current SnackbarData.
 * @param hostState The state of the SnackbarHost.
 * @param modifier The Modifier to apply to this layout.
 * @param snackbar The composable function to display the Snackbar.
 */
@Composable
public fun SnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    snackbar: @Composable (SnackbarData) -> Unit = { Snackbar(it) },
) {
    val currentSnackbarData = hostState.currentSnackbarData
    val accessibilityManager = LocalAccessibilityManager.current
    LaunchedEffect(currentSnackbarData) {
        if (currentSnackbarData != null) {
            val duration = currentSnackbarData.visuals.duration.toMillis(
                currentSnackbarData.visuals.actionLabel != null,
                accessibilityManager,
            )
            delay(duration)
            currentSnackbarData.dismiss()
        }
    }
    FadeInFadeOutWithScale(
        current = hostState.currentSnackbarData,
        modifier = modifier,
        content = snackbar,
    )
}

/**
 * A class that represents the state of a SnackbarHost.
 */
@Stable
public class SnackbarHostState {
    private val mutex = Mutex()

    public var currentSnackbarData: SnackbarData? by mutableStateOf(null)
        private set

    /**
     * Shows a Snackbar with the given parameters.
     * @param message The message to display in the Snackbar.
     * @param actionLabel The label for the action in the Snackbar.
     * @param icon The icon to display in the Snackbar.
     * @param intent The intent of the Snackbar.
     * @param style The style of the Snackbar.
     * @param isDismissIconEnabled Indicates whether the dismiss icon should be enabled.
     * @param duration The duration of the Snackbar.
     * @return The result of the Snackbar.
     */
    public suspend fun showSnackbar(
        message: String,
        actionLabel: String? = null,
        icon: SparkIcon? = null,
        intent: SnackbarIntent = SnackbarDefaults.intent,
        style: SnackbarStyle = SnackbarDefaults.style,
        isDismissIconEnabled: Boolean = false,
        duration: SnackbarDuration = if (actionLabel == null) {
            SnackbarDuration.Short
        } else {
            SnackbarDuration.Indefinite
        },
    ): SnackbarResult = showSnackbar(
        SnackbarSparkVisuals(
            message = message,
            icon = icon,
            style = style,
            intent = intent,
            actionLabel = actionLabel,
            isDismissIconEnabled = isDismissIconEnabled,
            duration = duration,
        ),
    )

    /**
     * Shows a Snackbar with the given visuals.
     * @param visuals The visuals of the Snackbar.
     * @return The result of the Snackbar.
     */
    public suspend fun showSnackbar(visuals: SnackbarSparkVisuals): SnackbarResult = mutex.withLock {
        try {
            return suspendCancellableCoroutine { continuation ->
                currentSnackbarData = SnackbarDataImpl(visuals, continuation)
            }
        } finally {
            currentSnackbarData = null
        }
    }

    /**
     * An internal class that represents the data of a Snackbar.
     * @param visuals The visuals of the Snackbar.
     * @param continuation The continuation of the Snackbar.
     */
    internal class SnackbarDataImpl(
        override val visuals: SnackbarSparkVisuals,
        private val continuation: CancellableContinuation<SnackbarResult>,
    ) : SnackbarData {

        /**
         * Performs the action of the Snackbar.
         */
        override fun performAction() {
            if (continuation.isActive) continuation.resume(SnackbarResult.ActionPerformed)
        }

        /**
         * Dismisses the Snackbar.
         */
        override fun dismiss() {
            if (continuation.isActive) continuation.resume(SnackbarResult.Dismissed)
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as SnackbarDataImpl

            if (visuals != other.visuals) return false
            if (continuation != other.continuation) return false

            return true
        }

        override fun hashCode(): Int {
            var result = visuals.hashCode()
            result = 31 * result + continuation.hashCode()
            return result
        }
    }
}
