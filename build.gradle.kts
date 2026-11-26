// Fichero de build del PROYECTO: declara los plugins (sin aplicarlos)
plugins {
    alias(libs.plugins.android.application) apply false
    // Safe Args: se declara aquí y se aplica en app/build.gradle.kts
    alias(libs.plugins.navigation.safeargs) apply false
    // Parcelize: fija la versión de Kotlin (debe ser igual o mayor que la que trae AGP 9)
    alias(libs.plugins.kotlin.parcelize) apply false
}
