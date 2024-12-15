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
@file:Suppress("UnstableApiUsage", "ktlint:standard:max-line-length")

package com.adevinta.spark.lint

import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.Category.Companion.CORRECTNESS
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Incident
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.ResourceXmlDetector
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity.ERROR
import com.android.tools.lint.detector.api.XmlContext
import com.android.utils.forEach
import org.w3c.dom.Element
import org.w3c.dom.Node

public class UnknownStringResourceAnnotationsDetector : ResourceXmlDetector() {

    override fun appliesTo(folderType: ResourceFolderType): Boolean = folderType == ResourceFolderType.VALUES

    override fun getApplicableElements(): Collection<String> = listOf(TAG_ANNOTATION)

    override fun visitElement(context: XmlContext, element: Element) {
        element.attributes.forEach { attribute ->
            when (attribute.nodeName) {
                !in VALID_ANNOTATION_NAMES -> context.reportUnknownAnnotationNameIssue(attribute)
                COLOR_ANNOTATION_NAME -> checkColorAnnotationValue(context, attribute)
                TYPOGRAPHY_ANNOTATION_NAME -> checkTypographyAnnotationValue(context, attribute)
            }
        }
    }

    private fun checkColorAnnotationValue(context: XmlContext, node: Node) {
        if (node.nodeValue !in VALID_COLOR_ANNOTATION_VALUES) {
            Incident(context)
                .issue(UNKNOWN_ANNOTATION_VALUE_ISSUE)
                .at(node)
                .message(
                    "${node.nodeValue} is not a valid value for annotation \"color\"" +
                        "\nPossible values are $VALID_COLOR_ANNOTATION_VALUES",
                )
                .report()
        }
    }

    private fun checkTypographyAnnotationValue(context: XmlContext, node: Node) {
        if (node.nodeValue !in VALID_TYPOGRAPHY_ANNOTATION_VALUES) {
            Incident(context)
                .issue(UNKNOWN_ANNOTATION_VALUE_ISSUE)
                .at(node)
                .message(
                    "${node.nodeValue} is not a valid value for annotation \"typography\"" +
                        "\nPossible values are $VALID_TYPOGRAPHY_ANNOTATION_VALUES",
                )
                .report()
        }
    }

    private fun XmlContext.reportUnknownAnnotationNameIssue(node: Node) =
        Incident(this)
            .issue(UNKNOWN_ANNOTATION_NAME_ISSUE)
            .at(node)
            .message("Unknown annotation name")
            .report()

    internal companion object {
        private const val TAG_ANNOTATION = "annotation"
        private const val COLOR_ANNOTATION_NAME = "color"
        private const val TYPOGRAPHY_ANNOTATION_NAME = "typography"

        private val VALID_ANNOTATION_NAMES = listOf(COLOR_ANNOTATION_NAME, TYPOGRAPHY_ANNOTATION_NAME)
        private val VALID_COLOR_ANNOTATION_VALUES = listOf(
            "main",
            "support",
            "success",
            "alert",
            "error",
            "info",
            "neutral",
            "accent",
        )
        private val VALID_TYPOGRAPHY_ANNOTATION_VALUES = listOf(
            "display1",
            "display2",
            "display3",
            "headline1",
            "headline2",
            "subhead",
            "large",
            "body1",
            "body2",
            "caption",
            "small",
            "callout",
        )

        val UNKNOWN_ANNOTATION_NAME_ISSUE = Issue.create(
            id = "UnknownStringResourceAnnotationsDetector",
            briefDescription = "Unknown annotation name",
            explanation = "This annotation name is not supported and won't be parsed. " +
                "Supported names are $VALID_ANNOTATION_NAMES",
            category = CORRECTNESS,
            priority = 8,
            severity = ERROR,
            implementation = Implementation(
                UnknownStringResourceAnnotationsDetector::class.java,
                Scope.ALL_RESOURCES_SCOPE,
                Scope.RESOURCE_FILE_SCOPE,
            ),
        )

        val UNKNOWN_ANNOTATION_VALUE_ISSUE = Issue.create(
            id = "UnknownStringResourceAnnotationsDetector",
            briefDescription = "Unknown annotation value",
            explanation = "This annotation value is not supported and won't be parsed",
            category = CORRECTNESS,
            priority = 8,
            severity = ERROR,
            implementation = Implementation(
                UnknownStringResourceAnnotationsDetector::class.java,
                Scope.ALL_RESOURCES_SCOPE,
                Scope.RESOURCE_FILE_SCOPE,
            ),
        )
    }
}
