plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
}

kotlin {
    jvmToolchain(11)
    explicitApi()
}

android {
    namespace = "com.adevinta.spark"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        consumerProguardFile("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    testImplementation(libs.junit)
    testImplementation(libs.kotlin.test)
}