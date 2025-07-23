plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.ecorise.ecorise"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.ecorise.ecorise"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.places)
    implementation(libs.protolite.well.known.types)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.core)
    implementation (platform(libs.androidx.compose.bom.v20240400))
    implementation (libs.material3)
    implementation (libs.androidx.material.icons.extended)
    implementation (libs.ui.tooling.preview)
    debugImplementation (libs.ui.tooling)
//    implementation platform("androidx.compose:compose-bom:2024.04.00")
    implementation (libs.androidx.compose.material3.material3)
    implementation (libs.material.icons.extended)
    implementation (libs.androidx.compose.ui.ui.tooling.preview)
    debugImplementation (libs.androidx.compose.ui.ui.tooling)
    implementation(libs.ui)
    implementation(libs.androidx.compose.material3.material32)
    implementation(libs.androidx.compose.material.material.icons.extended)
    implementation(libs.androidx.compose.ui.ui.tooling.preview2)



}