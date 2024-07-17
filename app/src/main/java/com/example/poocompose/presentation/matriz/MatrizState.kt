package com.example.poocompose.presentation.matriz

/**
 * Las Matrices son Arreglos o listas bidimencionales en los que podemos tener un grupo de un prupo de datos
 * y son hasta cierto punto similares como funcionan las tablas en una BBDD ya que se maneja a través de filas y columnas.
 * Se pueden usar para almacenar Grupos de información mas detallados que solamente un indice y su elemento, aqui cada indice
 * corresponde a un grupo de elementos
 */

data class MatrizState(
    val matriz: List<List<String>> = listOf(
        listOf("Memphis Grizzlies", "FedEx Forum", "West"),
        listOf("Detroit Pistons", "Little Ceasars Arena", "East"),
        listOf("Los Angeles Lakers", "Crypto.com Arena", "West"),
        listOf("Boston Celtics", "TD Garden", "East"),
        listOf("Portland Trail Blazers", "Moda Center", "West"),
        listOf("New York Knicks", "Madison Square Garden", "East")
    ),
    val actualInfo: List<List<String>> = listOf()
)