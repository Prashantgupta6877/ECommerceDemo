import com.pguptafeb.ecommerecedemo.Apps
import com.pguptafeb.ecommerecedemo.Libs

plugins {
    id("com.android.library")
}

android {
    compileSdkVersion(Apps.compileSdk)
    defaultConfig {
        minSdkVersion(Apps.minSdk)
    }
}

dependencies {
    implementation(Libs.appcompat)
}