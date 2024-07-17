package com.example.poocompose.presentation.array

/**
 * Los Arrays son una manera de almacenar un conjunto de datos de un mismo tipo
 * son mutables en cuanto a los datos que guardan dentro de él, sin embargo son inmutables en su tamaño
 * por lo que solo se deben usar para almacenar una cantidad limitada/fija de informacion
 *
 * Existen los ArrayList los cuales funcionan similar a una MutableList, ya que a estos arrays
 * si es posible editarlos, agregar elementos o quitar del Array sin ningun problema por lo que son utiles
 * para listas dinámicas
 */

data class ArrayState(
    val nbaTeams: Array<String> = arrayOf(
        "Boston Celtics",
        "Brooklyn Nets",
        "New York Knicks",
        "Philadelphia 76ers",
        "Toronto Raptors",
        "Chicago Bulls",
        "Cleveland Cavaliers",
        "Detroit Pistons",
        "Indiana Pacers",
        "Milwaukee Bucks",
        "Atlanta Hawks",
        "Charlotte Hornets",
        "Miami Heat",
        "Orlando Magic",
        "Washington Wizards",
        "Denver Nuggets",
        "Minesota Timberwolves",
        "Seattle Supersonics",
        "Portland Trail Blazers",
        "Utah Jazz",
        "Golden State Warriors",
        "Los Angeles Lakers",
        "Los Angeles Clippers",
        "Phoenix Suns",
        "Sacramento Kings",
        "Dallas Mavericks",
        "Houston Rockets",
        "Vancouver Grizzlies",
        "New Orleans Pelicans",
        "San Antonio Spurs"
    )
)