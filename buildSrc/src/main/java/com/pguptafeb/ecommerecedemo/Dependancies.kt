object Apps{
    const val compileSdk = 29
    const val minSdk = 26
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0.1"
    const val applicationId = "com.pguptafeb.ecommercedemo"
}
object Versions{
    const val gradle = "3.5.3"
    const val kotlin = "1.3.70"
    const val appcompat = "1.1.0"
    const val ktx = "1.2.0"
    const val constraintlayout = "1.1.3"
    const val retrofit = "2.5.0"
    const val moshi = "2.2.0"
    const val retrofitInterceptor = "3.9.1"
    const val rxAndroid = "2.1.0"
    const val rxJava = "2.2.9"
    const val rxJavaAdapter = "2.5.0"
    const val ormlite = "5.1"
    const val recyclerview = "1.2.0-alpha01"
    const val material = "1.2.0-alpha05"
}

object Libs{
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.moshi}"
    const val retrofitInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitInterceptor}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.rxJavaAdapter}"
    const val ormlite = "com.j256.ormlite:ormlite-android:${Versions.ormlite}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val material = "com.google.android.material::${Versions.material}"
}

object ClassPaths{
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}