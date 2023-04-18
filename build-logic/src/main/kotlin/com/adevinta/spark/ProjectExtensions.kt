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

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.dsl.TestExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinTopLevelExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal val Project.isAndroidApplication: Boolean get() = pluginManager.hasPlugin("com.android.application")
internal val Project.isAndroidLibrary: Boolean get() = pluginManager.hasPlugin("com.android.library")
internal val Project.isAndroidTest: Boolean get() = pluginManager.hasPlugin("com.android.test")
internal val Project.isAndroid: Boolean get() = pluginManager.hasPlugin("com.android.base")
internal val Project.isJavaPlatform: Boolean get() = pluginManager.hasPlugin("org.gradle.java-platform")

internal fun Project.configureAndroidExtension(
    configure: CommonExtension<*, *, *, *, *>.() -> Unit,
) = when {
    isAndroidApplication -> configure<ApplicationExtension>(configure)
    isAndroidLibrary -> configure<LibraryExtension>(configure)
    isAndroidTest -> configure<TestExtension>(configure)
    else -> TODO("Unsupported project $this (isAndroid=$isAndroid)")
}

internal fun Project.getVersionsCatalog(): VersionCatalog = runCatching {
    project.extensions.getByType<VersionCatalogsExtension>().named("libs")
}.recoverCatching {
    throw IllegalStateException("No versions catalog found!", it)
}.getOrThrow()

internal fun Project.configureKotlinCompiler(
    allWarningsAsErrors: Boolean = true,
    configure: KotlinJvmCompilerOptions.() -> Unit = {},
) = tasks.withType<KotlinCompile> {
    compilerOptions {
        this.allWarningsAsErrors.set(allWarningsAsErrors)
        freeCompilerArgs.add("-Xexplicit-api=strict")
        configure()
    }
}

internal inline fun <reified T : KotlinTopLevelExtension> Project.configureKotlin(
    crossinline configure: T.() -> Unit = {},
): Unit = configure<T> {
    jvmToolchain(11)
    explicitApi()
    configure()
}

internal fun <T> Project.getOrCreateExtra(
    key: String,
    create: (Project) -> T,
): T = extensions.extraProperties.run {
    @Suppress("UNCHECKED_CAST")
    (if (has(key)) get(key) as? T else null) ?: create(project).also { set(key, it) }
}

internal fun Project.addKotlinBom() = dependencies {
    add("implementation", platform(spark().libraries.`kotlin-bom`))
}
