plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.plugin)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization.plugin)
    id("kotlin-parcelize")
}

android {
    namespace = "com.aditya.bsptechnopracticaltask"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.aditya.bsptechnopracticaltask"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunner = "com.aditya.bsptechnopracticaltask.CustomTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.hilt.testing)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //For runner
    androidTestImplementation(libs.test.runner)
    androidTestImplementation(libs.test.rule)

    //Mockito testing
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    androidTestImplementation(libs.mockito.android)

    //Room
    implementation(libs.room)
    implementation(libs.room.ktx)
    ksp(libs.room.annotation)
    annotationProcessor(libs.room.annotation)

    //datastore
    implementation(libs.datastore)


    //Hilt
    implementation(libs.hilt)
    implementation(libs.hilt.navigation.compse)
    ksp(libs.hilt.ksp)
    annotationProcessor(libs.room.annotation)
    androidTestImplementation(libs.hilt.testing)
    kspAndroidTest(libs.hilt.android.compiler)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    //Jetpack Compose recompose debugger by log
    // Solution of this dependency available to all module :- https://stackoverflow.com/a/48443958/17464278
    implementation(libs.rebugger)
    implementation(libs.androidx.material.icons.extended)

    //Google gson
    implementation(libs.gson)

    //Navigation
    implementation(libs.androidx.navigation.compose)

    //Coil
    implementation(libs.coil.compose)

    //For Compose Runtime Lifecycle support (collectAsStateWithLifeCycle())
    implementation(libs.androidx.lifecycle.runtime.compose)

    //Kotlin - Serialization
    implementation(libs.kotlin.serialization)

    //Kotlin - reflection
    implementation(libs.kotlin.reflect)


    //For Adaptive Layout
    implementation(libs.androidx.material3.windowSizeClass)

}