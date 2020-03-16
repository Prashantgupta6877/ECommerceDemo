import com.pguptafeb.ecommerecedemo.Apps
import com.pguptafeb.ecommerecedemo.Libs

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.compileSdk)
    defaultConfig {
        applicationId = Apps.applicationId
        targetSdkVersion(Apps.targetSdk)
        minSdkVersion(Apps.minSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lintOptions {
        isAbortOnError = false
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
    implementation(Libs.appcompat)
    implementation(Libs.ktx)
    implementation(Libs.constraintlayout)
    implementation(Libs.retrofit)
    implementation(Libs.moshi)
    implementation(Libs.retrofitInterceptor)
    implementation(Libs.rxAndroid)
    implementation(Libs.rxJava)
    implementation(Libs.rxJavaAdapter)
    implementation(Libs.ormlite)
    implementation(Libs.recyclerview)
    implementation(Libs.material)
    implementation(project(":montserrat"))

    if (project.findProperty("buildOption") == "debug") {
        implementation(project(":debugLibraries"))
    }
}

