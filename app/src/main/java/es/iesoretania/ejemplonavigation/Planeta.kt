package es.iesoretania.ejemplonavigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Modelo de datos: un planeta.
 *
 * Para pasar un OBJETO como argumento de navegación, su clase tiene que poder
 * guardarse dentro de un Bundle: para eso implementa Parcelable.
 * @Parcelize (plugin kotlin-parcelize) genera automáticamente todo el código
 * de Parcelable: no hay que escribir writeToParcel(), CREATOR...
 *
 * Es una "data class": Kotlin genera solo toString(), equals(), copy()...
 */
@Parcelize
data class Planeta(
    val nombre: String,
    val descripcion: String,
    val distanciaSol: Double   // en millones de km
) : Parcelable
