import dependencies.Dependencies
import dependencies.KaptDependencies
import extensions.addDependenciesBase
import extensions.implementation

plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdkVersion(BuildDefaultConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(BuildDefaultConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildDefaultConfig.TARGET_SDK_VERSION)
        buildToolsVersion(BuildDefaultConfig.BUILD_TOOLS_VERSION)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    addDependenciesBase()
}
