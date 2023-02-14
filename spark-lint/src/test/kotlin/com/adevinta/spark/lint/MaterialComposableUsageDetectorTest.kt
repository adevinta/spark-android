package com.adevinta.spark.lint

import com.adevinta.spark.lint.MaterialComposableUsageDetector.Companion.ISSUE
import com.adevinta.spark.lint.stubs.CoilComponentsStub
import com.adevinta.spark.lint.stubs.Composable
import com.adevinta.spark.lint.stubs.FoundationStub
import com.adevinta.spark.lint.stubs.MaterialComponentsStub
import com.adevinta.spark.lint.stubs.SparkComponentsStub
import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Issue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MaterialComposableUsageDetectorTest : LintDetectorTest() {

    override fun getDetector(): Detector = MaterialComposableUsageDetector()
    override fun getIssues() = listOf(ISSUE)

    private fun Issue.explanation(replacement: Pair<String, String>) =
        "${defaultSeverity.description}: Composable ${replacement.first} has a Spark replacement that should be used instead: ${replacement.second} [$id]"

    @Test
    fun materialUsages(): Unit = with(ISSUE) {
        lint().files(
            kotlin(
                """
                package foo
                import androidx.compose.material3.*
                import androidx.compose.runtime.*
                import androidx.compose.ui.*
                
                @Composable
                fun Test() {
                    Button()
                    ElevatedButton()
                    FilledTonalButton()
                    OutlinedButton()
                    TextButton()
                    OutlinedTextField()
                    FilledTextField()
                    CheckBox()
                    TriStateCheckbox()
                    RadioButton()
                    Switch()
                    Snackbar()
                    LinearProgressIndicator()
                    CircularProgressIndicator()
                    MaterialTheme()
                }
            """.trimIndent()
            ),
            MaterialComponentsStub,
            Composable,
        )
            .allowMissingSdk()
            .run()
            .expect(
                """
                src/foo/test.kt:8: ${explanation("Button" to "PrimaryButton")}
                    Button()
                    ~~~~~~~~
                src/foo/test.kt:9: ${explanation("ElevatedButton" to "PrimaryButton")}
                    ElevatedButton()
                    ~~~~~~~~~~~~~~~~
                src/foo/test.kt:10: ${explanation("FilledTonalButton" to "PrimaryButton")}
                    FilledTonalButton()
                    ~~~~~~~~~~~~~~~~~~~
                src/foo/test.kt:11: ${explanation("OutlinedButton" to "SecondaryButton")}
                    OutlinedButton()
                    ~~~~~~~~~~~~~~~~
                src/foo/test.kt:12: ${explanation("TextButton" to "TextButton")}
                    TextButton()
                    ~~~~~~~~~~~~
                src/foo/test.kt:13: ${explanation("OutlinedTextField" to "TextField")}
                    OutlinedTextField()
                    ~~~~~~~~~~~~~~~~~~~
                src/foo/test.kt:14: ${explanation("FilledTextField" to "TextField")}
                    FilledTextField()
                    ~~~~~~~~~~~~~~~~~
                src/foo/test.kt:15: ${explanation("CheckBox" to "CheckBox")}
                    CheckBox()
                    ~~~~~~~~~~
                src/foo/test.kt:16: ${explanation("TriStateCheckbox" to "CheckBox")}
                    TriStateCheckbox()
                    ~~~~~~~~~~~~~~~~~~
                src/foo/test.kt:17: ${explanation("RadioButton" to "RadioButton")}
                    RadioButton()
                    ~~~~~~~~~~~~~
                src/foo/test.kt:18: ${explanation("Switch" to "Switch")}
                    Switch()
                    ~~~~~~~~
                src/foo/test.kt:19: ${explanation("Snackbar" to "Snackbar")}
                    Snackbar()
                    ~~~~~~~~~~
                src/foo/test.kt:20: ${explanation("LinearProgressIndicator" to "LinearProgressIndicator")}
                    LinearProgressIndicator()
                    ~~~~~~~~~~~~~~~~~~~~~~~~~
                src/foo/test.kt:21: ${explanation("CircularProgressIndicator" to "CircularProgressIndicator")}
                    CircularProgressIndicator()
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~
                src/foo/test.kt:22: ${explanation("MaterialTheme" to "SparkTheme")}
                    MaterialTheme()
                    ~~~~~~~~~~~~~~~
                15 errors, 0 warnings
            """.trimIndent()
            )
            .expectFixDiffs(
                """
                Fix for src/foo/test.kt line 8: Replace Button with Spark's PrimaryButton:
                @@ -2 +2
                + import com.adevinta.spark.components.buttons.PrimaryButton
                @@ -8 +9
                -     Button()
                +     PrimaryButton()
                Fix for src/foo/test.kt line 9: Replace ElevatedButton with Spark's PrimaryButton:
                @@ -2 +2
                + import com.adevinta.spark.components.buttons.PrimaryButton
                @@ -9 +10
                -     ElevatedButton()
                +     PrimaryButton()
                Fix for src/foo/test.kt line 10: Replace FilledTonalButton with Spark's PrimaryButton:
                @@ -2 +2
                + import com.adevinta.spark.components.buttons.PrimaryButton
                @@ -10 +11
                -     FilledTonalButton()
                +     PrimaryButton()
                Fix for src/foo/test.kt line 11: Replace OutlinedButton with Spark's SecondaryButton:
                @@ -2 +2
                + import com.adevinta.spark.components.buttons.SecondaryButton
                @@ -11 +12
                -     OutlinedButton()
                +     SecondaryButton()
                Fix for src/foo/test.kt line 12: Replace TextButton with Spark's TextButton:
                @@ -2 +2
                + import com.adevinta.spark.components.buttons.TextButton
                Fix for src/foo/test.kt line 13: Replace OutlinedTextField with Spark's TextField:
                @@ -2 +2
                + import com.adevinta.spark.components.textfields.TextField
                @@ -13 +14
                -     OutlinedTextField()
                +     TextField()
                Fix for src/foo/test.kt line 14: Replace FilledTextField with Spark's TextField:
                @@ -2 +2
                + import com.adevinta.spark.components.textfields.TextField
                @@ -14 +15
                -     FilledTextField()
                +     TextField()
                Fix for src/foo/test.kt line 15: Replace CheckBox with Spark's CheckBox:
                @@ -2 +2
                + import com.adevinta.spark.components.toggles.CheckBox
                Fix for src/foo/test.kt line 16: Replace TriStateCheckbox with Spark's CheckBox:
                @@ -2 +2
                + import com.adevinta.spark.components.toggles.CheckBox
                @@ -16 +17
                -     TriStateCheckbox()
                +     CheckBox()
                Fix for src/foo/test.kt line 17: Replace RadioButton with Spark's RadioButton:
                @@ -2 +2
                + import com.adevinta.spark.components.toggles.RadioButton
                Fix for src/foo/test.kt line 18: Replace Switch with Spark's Switch:
                @@ -2 +2
                + import com.adevinta.spark.components.toggles.Switch
                Fix for src/foo/test.kt line 19: Replace Snackbar with Spark's Snackbar:
                @@ -2 +2
                + import com.adevinta.spark.components.snackbars.Snackbar
                Fix for src/foo/test.kt line 20: Replace LinearProgressIndicator with Spark's LinearProgressIndicator:
                @@ -2 +2
                + import com.adevinta.spark.components.progress.LinearProgressIndicator
                Fix for src/foo/test.kt line 21: Replace CircularProgressIndicator with Spark's CircularProgressIndicator:
                @@ -2 +2
                + import com.adevinta.spark.components.progress.CircularProgressIndicator
                Fix for src/foo/test.kt line 22: Replace MaterialTheme with Spark's SparkTheme:
                @@ -2 +2
                + import com.adevinta.spark.SparkTheme
                @@ -22 +23
                -     MaterialTheme()
                +     SparkTheme()
            """.trimIndent()
            )
    }

    @Test
    fun foundationUsages(): Unit = with(ISSUE) {
        lint().files(
            kotlin(
                """
                package foo
                import androidx.compose.foundation.*
                import androidx.compose.runtime.*
                
                @Composable
                fun Test() {
                    Image()
                }
            """.trimIndent()
            ),
            Composable,
            FoundationStub,
        )
            .allowMissingSdk()
            .run()
            .expect(
                """
                src/foo/test.kt:7: ${explanation("Image" to "Illustration")}
                    Image()
                    ~~~~~~~
                1 errors, 0 warnings
            """.trimIndent()
            )
            .expectFixDiffs(
                """
                Fix for src/foo/test.kt line 7: Replace Image with Spark's Illustration:
                @@ -2 +2
                + import com.adevinta.spark.components.image.Illustration
                @@ -7 +8
                -     Image()
                +     Illustration()
            """.trimIndent()
            )
    }

    @Test
    fun coilUsages(): Unit = with(ISSUE) {
        lint().files(
            kotlin(
                """
                package foo
                import coil.compose.AsyncImage
                import coil.compose.SubcomposeAsyncImage
                import androidx.compose.runtime.Composable
                
                @Composable
                fun Test() {
                    AsyncImage()
                    SubcomposeAsyncImage()
                }
            """.trimIndent()
            ),
            Composable,
            CoilComponentsStub,
        )
            .allowMissingSdk()
            .run()
            .expect(
                """
                src/foo/test.kt:8: ${explanation("AsyncImage" to "Image")}
                    AsyncImage()
                    ~~~~~~~~~~~~
                src/foo/test.kt:9: ${explanation("SubcomposeAsyncImage" to "Image")}
                    SubcomposeAsyncImage()
                    ~~~~~~~~~~~~~~~~~~~~~~
                2 errors, 0 warnings
            """.trimIndent()
            )
            .expectFixDiffs(
                """
                Fix for src/foo/test.kt line 8: Replace AsyncImage with Spark's Image:
                @@ -2 +2
                + import com.adevinta.spark.components.image.Image
                @@ -8 +9
                -     AsyncImage()
                +     Image()
                Fix for src/foo/test.kt line 9: Replace SubcomposeAsyncImage with Spark's Image:
                @@ -2 +2
                + import com.adevinta.spark.components.image.Image
                @@ -9 +10
                -     SubcomposeAsyncImage()
                +     Image()
            """.trimIndent()
            )
    }

    @Test
    fun noErrors() {
        lint().files(
            kotlin(
                """
                package foo
                import androidx.compose.runtime.*
                import com.adevinta.spark.*
                
                @Composable
                fun Test() {
                    PrimaryButton()
                    SecondaryButton()
                    TextButton()
                    TextField()
                    MultilineTextField()
                    SelectTextField()
                    CheckBox()
                    RadioButton()
                    Switch()
                    SparkTheme()
                    LinearProgressIndicator()
                    Snackbar()
                }
            """.trimIndent()
            ),
            SparkComponentsStub,
            Composable,
        )
            .allowMissingSdk()
            .run()
            .expectClean()
    }

}
