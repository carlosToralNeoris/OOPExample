package com.example.poocompose.presentation.list

import androidx.compose.runtime.mutableStateOf

/**
 * Las List, son muy similares a como funcionan los Array, sin embargo estas son inmutables en su totalidad
 * es decir, no se pueden modificar ni de su longitud ni de la informacion que contienen, por lo que una vez declarados
 * no van a cambiar sus valores por lo que se debe usar solo para grupos de informacion que son estaticos, como los
 * dias de la semana o los meses del año
 *
 * Las MutableList, tambien funcionan similar a un ArrayList, ya que estas tambien nos permiten modificar
 * toda la informacion que contiene, actualizarla, agregar o eliminar
 */

data class ListState(
    val nbaTeams: MutableList<String> = mutableListOf(
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
        "Minnesota Timberwolves",
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
