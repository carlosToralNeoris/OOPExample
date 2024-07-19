package com.example.poocompose.arquitecturas.data

import com.example.poocompose.estructuras.presentation.map.Conferences

data class BasketballTeam(
    val name : String?,
    val city : String?,
    val conference : Conferences?,
    val arena : String?,
    val isNBA : Boolean?,
    val isGLeague : Boolean?,
    val age : Int?,
    val championships : Int?
)