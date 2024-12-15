/*
 * Copyright (c) 2024 Adevinta
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
package com.adevinta.spark.lint

import com.adevinta.spark.lint.UnknownStringResourceAnnotationsDetector.Companion.UNKNOWN_ANNOTATION_NAME_ISSUE
import com.adevinta.spark.lint.UnknownStringResourceAnnotationsDetector.Companion.UNKNOWN_ANNOTATION_VALUE_ISSUE
import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Issue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
public class UnknownStringResourceAnnotationsDetectorTest : LintDetectorTest() {

    override fun getDetector(): Detector = UnknownStringResourceAnnotationsDetector()
    override fun getIssues(): List<Issue> = listOf(UNKNOWN_ANNOTATION_NAME_ISSUE, UNKNOWN_ANNOTATION_VALUE_ISSUE)

    @Test
    public fun unknownAnnotationName() {
        lint().files(
            xml(
                "res/values/example.xml",
                """
                    <resources>
                        <string name="example"><annotation unknown="neutral">Example</annotation></string>
                    </resources>
            """,
            ),
        )
            .allowMissingSdk()
            .run()
            .expect(
                """
                    res/values/example.xml:3: Error: Unknown annotation name [UnknownStringResourceAnnotationsDetector]
                                            <string name="example"><annotation unknown="neutral">Example</annotation></string>
                                                                               ~~~~~~~~~~~~~~~~~
                    1 errors, 0 warnings
                """.trimIndent(),
            )
    }

    @Test
    public fun unknownAnnotationValue() {
        lint().files(
            xml(
                "res/values/example.xml",
                """
                    <resources>
                        <string name="example"><annotation color="unknown" typography="unknown">Example</annotation></string>
                    </resources>
            """,
            ),
        )
            .allowMissingSdk()
            .run()
            .expect(
                """
                    res/values/example.xml:3: Error: unknown is not a valid value for annotation "color"
                    Possible values are [main, support, success, alert, error, info, neutral, accent] [UnknownStringResourceAnnotationsDetector]
                                            <string name="example"><annotation color="unknown" typography="unknown">Example</annotation></string>
                                                                               ~~~~~~~~~~~~~~~
                    res/values/example.xml:3: Error: unknown is not a valid value for annotation "typography"
                    Possible values are [display1, display2, display3, headline1, headline2, subhead, large, body1, body2, caption, small, callout] [UnknownStringResourceAnnotationsDetector]
                                            <string name="example"><annotation color="unknown" typography="unknown">Example</annotation></string>
                                                                                               ~~~~~~~~~~~~~~~~~~~~
                    2 errors, 0 warnings
                """.trimIndent(),
            )
    }

    @Test
    public fun knownAnnotationNameAndValue() {
        lint().files(
            xml(
                "res/values/example.xml",
                """
                    <resources>
                        <string name="example"><annotation color="neutral" typography="display1">Example</annotation></string>
                    </resources>
            """,
            ),
        )
            .allowMissingSdk()
            .run()
            .expectClean()
    }
}
