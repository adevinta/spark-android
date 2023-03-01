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

plugins {
    id("com.adevinta.spark.android-library")
    id("com.adevinta.spark.android-compose")
    id("com.adevinta.spark.android-publishing")
    id("com.adevinta.spark.ksp")
    id("com.adevinta.spark.dokka")
    id("com.adevinta.spark.dependencyGuard")
}

android {
    namespace = "com.adevinta.spark"
    resourcePrefix = "spark_"

    kotlinOptions {
        freeCompilerArgs += listOf(
            "-opt-in=com.adevinta.spark.InternalSparkApi",
            "-opt-in=com.adevinta.spark.ExperimentalSparkApi",
        )
    }
}

dependencies {
    lintPublish(projects.sparkLint)
    lintChecks(libs.slack.lint.compose)

    api(projects.sparkIcons)

    implementation(libs.accompanist.drawablepainter)
    implementation(libs.accompanist.placeholder)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appCompat.resources)

    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling)

    compileOnly(libs.airbnb.showkase)
    ksp(libs.airbnb.showkase.processor)

    testImplementation(libs.junit)
    testImplementation(libs.kotlin.test)
}
