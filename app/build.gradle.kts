import extensions.addDependenciesBase

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.NAVIGATION_SAFE_ARGS)
}

android {
    compileSdkVersion(BuildDefaultConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = BuildDefaultConfig.APPLICATION_ID
        minSdkVersion(BuildDefaultConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildDefaultConfig.TARGET_SDK_VERSION)
        buildToolsVersion(BuildDefaultConfig.BUILD_TOOLS_VERSION)

        versionCode = BuildDefaultConfig.VERSION_CODE
        versionName = BuildDefaultConfig.VERSION_NAME

        vectorDrawables.useSupportLibrary = BuildDefaultConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled

            lintOptions {
                isCheckReleaseBuilds = false
                isAbortOnError = false
            }
        }

        getByName(BuildType.DEBUG) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    androidExtensions {
        isExperimental = true
    }

    sourceSets {
        getByName("main") {
            jniLibs.srcDirs("src/main/libs")
        }
    }

    dexOptions {
        jumboMode = true
        javaMaxHeapSize = "4g"
    }
    flavorDimensions(BuildProductDimensions.ENVIRONMENT)
    productFlavors {
        ProductFlavorAlpha.appCreate(this)
        ProductFlavorStaging.appCreate(this)
        ProductFlavorProduction.appCreate(this)
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    addDependenciesBase()
    implementation(project(BuildModules.BASE))

}
