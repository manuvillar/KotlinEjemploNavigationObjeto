// Fichero de build del MÓDULO app
plugins {
    // AGP 9 ya trae Kotlin integrado: no hace falta el plugin kotlin-android
    alias(libs.plugins.android.application)
    // Safe Args: siempre DESPUÉS del plugin de Android
    alias(libs.plugins.navigation.safeargs)
    // Parcelize: permite usar @Parcelize para pasar objetos entre destinos
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "es.iesoretania.ejemplonavigation"
    compileSdk = 36

    defaultConfig {
        applicationId = "es.iesoretania.ejemplonavigation"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    // Activamos ViewBinding: genera una clase Binding por cada layout
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Navigation Component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
}
