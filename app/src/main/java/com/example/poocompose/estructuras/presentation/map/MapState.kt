package com.example.poocompose.estructuras.presentation.map

/**
 * Los Map son un "Estilo" de array el cual se caracteriza porque es un clave-valor, es decir, es como un arreglo
 * pero te permite agregar el identificador de manera manual y puede ser tanto la clave como el valor de cualquier tipo de dato
 * mientras las claves se mantengan unicas
 */

data class MapState(
    val nbaChampsByConference : Map<Conferences, String> = mapOf(
        Conferences.EAST to "Boston Celtics",
        Conferences.WEST to "Dallas Mavericks",
    ),
    val champSelected : List<String> = emptyList()
)

enum class Conferences{
    EAST, WEST
}