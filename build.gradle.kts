// Fichero de build del PROYECTO: declara los plugins (sin aplicarlos)
plugins {
    alias(libs.plugins.android.application) apply false
    // Safe Args: se declara aquí y se aplica en app/build.gradle.kts
    alias(libs.plugins.navigation.safeargs) apply false
}
