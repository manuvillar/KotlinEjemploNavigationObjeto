// Configuración general del proyecto: de dónde se descargan plugins y librerías
// y qué módulos forman el proyecto.

// Repositorios de los que Gradle descarga los PLUGINS (AGP, Safe Args...)
pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

// Repositorios de los que se descargan las LIBRERÍAS (dependencies)
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KotlinEjemploNavigationObjeto"
// El proyecto tiene un único módulo: la app
include(":app")
