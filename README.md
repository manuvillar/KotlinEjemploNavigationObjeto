# Ejemplo Navigation con paso de objetos

Ejemplo del módulo PMDM (2º DAM, IES Oretania): navegación entre pantallas con **Navigation Component**.

App con una sola Activity y tres Fragments:

```
Inicio  →  Lista de planetas  →  Detalle del planeta (recibe un objeto Planeta)
  ↑                                     |
  └──────── Volver al inicio (popUpTo) ─┘
```

## Qué se ve en el ejemplo

- Grafo de navegación (`res/navigation/nav_graph.xml`): destinos, acciones y argumentos.
- `NavHostFragment` y `NavController`.
- Paso de un **objeto** (`Planeta`, `Parcelable` con `@Parcelize`) como argumento con **Safe Args** (`ListaFragmentDirections`, `DetalleFragmentArgs`).
- Toolbar conectada con Navigation: título automático y flecha de volver.
- La pila de navegación y `popUpTo`.
- ViewBinding en Activity y Fragments, e insets (cámara y barras del sistema).

## Ficheros principales

| Fichero | Qué hace |
| --- | --- |
| `MainActivity.kt` | Única Activity: Toolbar, insets y NavController |
| `InicioFragment.kt` | Primera pantalla: navega a la lista |
| `Planeta.kt` | Modelo de datos (data class con @Parcelize) |
| `ListaFragment.kt` | Lista de planetas: navega al detalle pasando el objeto Planeta |
| `DetalleFragment.kt` | Muestra los datos del Planeta recibido y vuelve al inicio |
| `res/navigation/nav_graph.xml` | El grafo de navegación |
| `res/layout/activity_main.xml` | Toolbar + NavHostFragment |

## Versiones

AGP 9.4.0 (Kotlin integrado, sin plugin `kotlin-android`) · Kotlin 2.4.10 para `kotlin-parcelize` · Gradle 9.6 · Navigation 2.9.8 · compileSdk 36 · minSdk 24.
