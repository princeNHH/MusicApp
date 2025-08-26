plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.hilt.android)
    kotlin("kapt")
}

android {
    namespace = "com.example.musicapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.musicapp"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlin.get()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kotlin {
        jvmToolchain(21) // hoặc 17 tùy máy bạn đang cài
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation(platform(libs.compose.bom))

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
//    implementation(libs.compose.material3)
    implementation("androidx.compose.material3:material3:1.3.2")

    implementation(libs.compose.runtime)
    implementation(libs.compose.foundation)
    implementation(libs.compose.activity)

    // Hilt
    implementation(libs.hilt.android)
    implementation(libs.navigation.compose)
    implementation(libs.appcompat.resources)
    kapt(libs.hilt.compiler)

    // Debug tools
    debugImplementation(libs.compose.ui.tooling)

    //icon
    implementation("androidx.compose.material:material-icons-extended-android:1.7.8")

    //background palette
    implementation("androidx.palette:palette:1.0.0")

}