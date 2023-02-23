import org.jetbrains.dokka.gradle.DokkaTask
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
    alias(libs.plugins.dependencyGuard)
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.dokka)
    `maven-publish`
}

kotlin {
    jvmToolchain(11)
    explicitApi()
}

ksp {
    arg("skipPrivatePreviews", "true")
}

android {
    namespace = "com.adevinta.spark"
    compileSdk = 33
    resourcePrefix = "spark_"

    defaultConfig {
        minSdk = 24
        consumerProguardFile("consumer-rules.pro")
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

    lint {
        warningsAsErrors = true
        sarifReport = true
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencyGuard {
    configuration("releaseRuntimeClasspath")
}

tasks.dokkaHtml.configure {
    moduleName.set("Spark")
    outputDirectory.set(rootProject.buildDir.resolve("dokka"))
    dokkaSourceSets.configureEach {
        // List of files or directories containing sample code (referenced with @sample tags)
        // samples.from("samples/basic.kt", "samples/advanced.kt")
    }
}

tasks.withType<DokkaTask> {
    notCompatibleWithConfigurationCache("https://github.com/Kotlin/dokka/issues/1217")
}

publishing {
    repositories {
        mavenLocal {
            name = "Local"
            url = uri(rootProject.layout.buildDirectory.dir(".m2/repository"))
        }
    }
    publications {
        register<MavenPublication>("maven") {
            // AGP creates software components during the afterEvaluate callback step...
            afterEvaluate {
                from(components.getByName("release"))
            }
            pom {
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
            }
        }
    }
}

dependencies {
    lintPublish(projects.sparkLint)
    lintChecks(libs.slack.lint)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling)

    compileOnly(libs.airbnb.showkase)
    ksp(libs.airbnb.showkase.processor)

    testImplementation(libs.junit)
    testImplementation(libs.kotlin.test)

    dokkaHtmlPlugin(libs.android.documentation.plugin)
}
