import com.pguptafeb.ecommerecedemo.Apps
import com.pguptafeb.ecommerecedemo.Libs

plugins {
    id("com.android.library")
}
apply {
    plugin("kotlin-android")
    plugin("kotlin-android-extensions")
}

android {
    compileSdkVersion(Apps.compileSdk)
    defaultConfig {
        minSdkVersion(Apps.minSdk)
    }
}

dependencies {
    implementation(Libs.appcompat)
    implementation("com.facebook.stetho:stetho:1.5.1")

}
repositories {
    mavenCentral()
}