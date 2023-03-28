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

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    alias(libs.plugins.spotless)
}

kotlin {
    jvmToolchain(17)
    explicitApi()
}

tasks.withType<KotlinCompile> {
    compilerOptions.allWarningsAsErrors.set(true)
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(libs.gradlePlugins.android)
    compileOnly(libs.gradlePlugins.kotlin)
    compileOnly(libs.gradlePlugins.ksp)
    compileOnly(libs.gradlePlugins.dependencyGuard)
    compileOnly(libs.gradlePlugins.dokka)
    compileOnly(libs.gradlePlugins.spotless)
}

gradlePlugin {
    plugins {
        create("com.adevinta.spark.SparkAndroidPlugin", id = "com.adevinta.spark.android")
        create("com.adevinta.spark.SparkAndroidApplicationPlugin", id = "com.adevinta.spark.android-application")
        create("com.adevinta.spark.SparkAndroidLibraryPlugin", id = "com.adevinta.spark.android-library")
        create("com.adevinta.spark.SparkAndroidComposePlugin", id = "com.adevinta.spark.android-compose")
        create("com.adevinta.spark.SparkAndroidLintPlugin", id = "com.adevinta.spark.android-lint")
        create("com.adevinta.spark.SparkPublishingPlugin", id = "com.adevinta.spark.publishing")
        create("com.adevinta.spark.SparkKotlinJvmPlugin", id = "com.adevinta.spark.kotlin-jvm")
        create("com.adevinta.spark.SparkKspPlugin", id = "com.adevinta.spark.ksp")
        create("com.adevinta.spark.SparkDokkaPlugin", id = "com.adevinta.spark.dokka")
        create("com.adevinta.spark.SparkDependencyGuardPlugin", id = "com.adevinta.spark.dependencyGuard")
        create("com.adevinta.spark.SparkSpotlessPlugin", id = "com.adevinta.spark.spotless")
    }
}

fun NamedDomainObjectContainer<PluginDeclaration>.create(
    implementationClass: String,
    id: String,
    name: String = implementationClass.removeSuffix("Plugin"),
) = create(name) {
    this.id = id
    this.implementationClass = implementationClass
}

// This block is a copy of SparkSpotlessPlugin since this included build can't use it's own plugins...
spotless {
    val licenseHeader = rootProject.file("./../spotless/spotless.kt")
    format("misc") {
        target("**/*.md", "**/.gitignore")
        endWithNewline()
    }
    kotlin {
        target("src/**/*.kt")
        ktlint(libs.versions.ktlint.get())
        trimTrailingWhitespace()
        endWithNewline()
        licenseHeaderFile(licenseHeader)
    }
    kotlinGradle {
        ktlint(libs.versions.ktlint.get())
        trimTrailingWhitespace()
        endWithNewline()
        licenseHeaderFile(
            licenseHeader,
            "(import |plugins|pluginManagement|rootProject|dependencyResolutionManagement|//)",
        )
    }
}
