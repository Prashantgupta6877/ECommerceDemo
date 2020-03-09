plugins {
    kotlin("jvm") version "1.3.70"
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.


buildscript {

    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(ClassPaths.gradle)
        classpath(ClassPaths.kotlinGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

/*
tasks.register("clean").configure {
    delete("build")
}*/
