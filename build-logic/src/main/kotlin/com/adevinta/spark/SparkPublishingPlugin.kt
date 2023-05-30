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

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.the
import org.gradle.plugins.signing.SigningExtension

internal class SparkPublishingPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "org.gradle.maven-publish")
            apply(plugin = "org.gradle.signing")

            configureRepository()
            registerPublication()
            configureSigning()
        }
    }

    private fun Project.configureRepository() = configure<PublishingExtension> {
        repositories {
            mavenLocal {
                name = "Local"
                url = uri(rootProject.layout.buildDirectory.dir(".m2/repository"))
            }
            maven {
                name = "OSSRH"
                url = when (version.toString().endsWith("-SNAPSHOT")) {
                    true -> "https://s01.oss.sonatype.org/content/repositories/snapshots/"
                    false -> "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
                }.let(::uri)
                credentials {
                    username = System.getenv("OSSRH_USERNAME")
                    password = System.getenv("OSSRH_TOKEN")
                }
            }
        }
    }

    private fun Project.registerPublication() = configure<PublishingExtension> {
        publications {
            register<MavenPublication>("maven") {
                when {
                    isAndroidLibrary -> configureAndroidPublication(this)
                    isJavaPlatform -> from(components["javaPlatform"])
                    else -> TODO("Unsupported project type $this")
                }
                configurePom()
            }
        }
    }

    private fun Project.configureAndroidPublication(publication: MavenPublication) {
        configure<LibraryExtension> {
            publishing {
                singleVariant("release") {
                    withSourcesJar()
                    withJavadocJar()
                }
            }
        }
        // AGP creates software components during the afterEvaluate callback step...
        afterEvaluate {
            publication.from(components.getByName("release"))
        }
    }

    private fun MavenPublication.configurePom() = pom {
        name.set("Spark")
        description.set("Spark Design System")
        url.set("https://github.com/adevinta/spark-android")
        licenses {
            license {
                name.set("MIT License")
                url.set("https://opensource.org/licenses/MIT")
            }
        }
        scm {
            url.set("https://github.com/adevinta/spark-android")
        }
        developers {
            developer {
                name.set("Adevinta Engineers")
                email.set("engineers@adevinta.com")
            }
        }
    }

    private fun Project.configureSigning() = configure<SigningExtension> signing@{
        val signingKey: String? by project
        val signingPassword: String? by project
        if (signingKey == null || signingPassword == null) return@signing
        useInMemoryPgpKeys(signingKey, signingPassword)
        sign(the<PublishingExtension>().publications)
    }
}
