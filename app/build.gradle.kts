plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "app.aec.myappmvvmcleanarchitecturesample"
    compileSdk = 33

    defaultConfig {
        applicationId = "app.aec.myappmvvmcleanarchitecturesample"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "API_KEY", project.properties["MY_KEY"].toString())
        buildConfigField("String", "BASE_URL", project.properties["MY_URL"].toString())
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
//            isShrinkResources = true
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
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    testImplementation ("com.google.truth:truth:1.1.4")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.work:work-runtime-ktx:2.8.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")


    // Architecture Components
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$archLifecycleVersion")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$archLifecycleVersion")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.0")
    implementation("androidx.room:room-runtime:2.1.0")
    implementation("androidx.room:room-ktx:2.1.0")
    kapt("androidx.room:room-compiler:2.1.0")

    // Dagger - hilt
    // implementation("com.google.dagger:dagger-android:2.48.1")
    // implementation("com.google.dagger:dagger-android-support:2.48.1")
    // annotationProcessor("com.google.dagger:dagger-android-processor:2.48.1")
    // kapt("com.google.dagger:dagger-compiler:2.48.1")
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")

}