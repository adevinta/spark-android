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
}

kotlin {
    jvmToolchain(11)
    explicitApi()
}

android {
    namespace = "com.adevinta.spark.icons"
    compileSdk = 33
    resourcePrefix = "spark_icons_"

    defaultConfig {
        minSdk = 24
        aarMetadata {
            minCompileSdk = 24
        }
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

    sourceSets.getByName("main") {
        res.srcDirs(
            "src/main/res-iconography/account",
            "src/main/res-iconography/actions",
            "src/main/res-iconography/arrows",
            "src/main/res-iconography/calendar",
            "src/main/res-iconography/camera",
            "src/main/res-iconography/categories",
            "src/main/res-iconography/check",
            "src/main/res-iconography/clock",
            "src/main/res-iconography/criteria",
            "src/main/res-iconography/contact",
            "src/main/res-iconography/covid",
            "src/main/res-iconography/donation",
            "src/main/res-iconography/eye",
            "src/main/res-iconography/flags",
            "src/main/res-iconography/heart",
            "src/main/res-iconography/icons",
            "src/main/res-iconography/infos",
            "src/main/res-iconography/lightbulb",
            "src/main/res-iconography/key",
            "src/main/res-iconography/lock",
            "src/main/res-iconography/logo",
            "src/main/res-iconography/map",
            "src/main/res-iconography/micro",
            "src/main/res-iconography/notif",
            "src/main/res-iconography/offers",
            "src/main/res-iconography/options",
            "src/main/res-iconography/pen",
            "src/main/res-iconography/picture",
            "src/main/res-iconography/share",
            "src/main/res-iconography/shipping",
            "src/main/res-iconography/toggles",
            "src/main/res-iconography/trash",
            "src/main/res-iconography/user",
            "src/main/res-iconography/value",
            "src/main/res-iconography/wheel",
        )
    }

    lint {
        warningsAsErrors = true
        sarifReport = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.appCompat.resources) // Needed for compat vector drawables
}
