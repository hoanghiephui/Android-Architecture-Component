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
        buildConfigField(
            "String",
            "GOOGLE_LICENCE",
            "\"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhjL76635QjAxyYAcD+IOKAcehxlY+ZOrHyQH+G4vNJJE96NdwRA+NDhQGMls6xMC/2Ut+0D69kPMU3Iti0QyQs3zsxSqgXSLdYxRc5uTUYIt6Olm4XsLr+bMEXYfWQFx8yBJZr3Q3EFCL+12xO4A7siAbnVwygpLmmj7D5VBq43BNrukuJ2rr8EoA5jdDuFaSU83WZ+182NIhE8e9a3fj/YeObv5gv+qbDKiWdQgWLZa/TVqUysHgt4mFHuqcy8zb8t07OdcQY4/cy0A8O3YhXDQgni4p6NE/YZyA/11iEuzjI6jM171WGb8yNK/Th/3SlE/F0RPbDJU+iHK920dQQIDAQAB\""
        )
        buildConfigField("String", "SUB_ONE", "\"com.blockchain.android.month\"")
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
    implementation(project(":billing"))
}
