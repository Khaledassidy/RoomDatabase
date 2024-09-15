import com.android.build.api.dsl.DataBinding

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.roomdatabase"
    compileSdk = 34



    viewBinding{
        enable=true
    }


    defaultConfig {
        applicationId = "com.example.roomdatabase"
        minSdk = 21
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.common.java8)
    implementation (libs.room.runtime)
    implementation(libs.room.paging)
    implementation(libs.room.guava)
    annotationProcessor (libs.room.compiler)
    androidTestImplementation (libs.room.testing)
    implementation(libs.materialdatetimepicker)
    implementation(libs.recyclerview.swipedecorator)
    implementation(libs.paging.runtime)




}