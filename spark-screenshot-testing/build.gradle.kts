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

// TODO: Remove once https://youtrack.jetbrains.com/issue/KTIJ-19369 is fixed
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.paparazzi)
}

kotlin {
    jvmToolchain(11)
    explicitApi()
}

ksp {
    arg("skipPrivatePreviews", "true")
}

android {
    namespace = "com.adevinta.spark.screenshots.test"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        allWarningsAsErrors = true
        freeCompilerArgs += listOf(
            "-Xexplicit-api=strict",
            "-opt-in=com.adevinta.spark.InternalSparkApi",
            "-opt-in=com.adevinta.spark.ExperimentalSparkApi",
            "-opt-in=kotlin.RequiresOptIn",
        )
    }

    buildFeatures.compose = true
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compiler.get()
    }
}

dependencies {
    implementation(projects.spark)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.ui)

    implementation(libs.airbnb.showkase)
    ksp(libs.airbnb.showkase.processor)

    testImplementation(libs.junit)
    testImplementation(libs.kotlin.test)
}
