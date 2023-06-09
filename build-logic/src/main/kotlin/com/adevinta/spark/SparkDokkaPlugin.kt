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
package com.adevinta.spark

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.withType
import org.jetbrains.dokka.gradle.DokkaMultiModuleTask
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.gradle.DokkaTaskPartial
import java.net.URL

internal class SparkDokkaPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "org.jetbrains.dokka")

            when {
                this === rootProject -> configureRootProject()
                else -> configureSubProject()
            }

            tasks.withType<DokkaTask> {
                notCompatibleWithConfigurationCache("https://github.com/Kotlin/dokka/issues/1217")
            }

            dependencies {
                add("dokkaHtmlPlugin", spark().libraries.`dokka-android-documentation-plugin`)
            }
        }
    }

    private fun Project.configureRootProject() = tasks.named<DokkaMultiModuleTask>("dokkaHtmlMultiModule") {
        moduleName.set("✨ Spark")
        outputDirectory.set(buildDir.resolve("dokka"))
    }

    private fun Project.configureSubProject() = tasks.withType<DokkaTaskPartial> {
        dokkaSourceSets.configureEach {
            // Parse Module and Package docs
            // https://kotlinlang.org/docs/dokka-module-and-package-docs.html
            projectDir.resolve("src").walk()
                .filter { it.isFile && it.extension == "md" }.toList()
                .let { includes.from(project.files(), it) }

            // List of files or directories containing sample code (referenced with @sample tags)
            projectDir.resolve("samples").walk()
                .filter { it.isFile && it.extension == "kt" }.toList()
                .let { samples.from(it) }

            // https://kotlinlang.org/docs/dokka-gradle.html#source-link-configuration
            // FIXME(android): https://github.com/Kotlin/dokka/issues/2876
            @Suppress("ktlint:max-line-length", "ktlint:trailing-comma-on-call-site")
            sourceLink {
                val url = "https://github.com/Adevinta/spark-android/tree/main/${project.name}/src/main/kotlin"
                localDirectory.set(projectDir.resolve("src"))
                remoteUrl.set(URL(url))
                remoteLineSuffix.set("#L")
            }
        }
    }
}
