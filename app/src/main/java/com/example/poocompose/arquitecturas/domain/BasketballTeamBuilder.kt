package com.example.poocompose.arquitecturas.domain

import com.example.poocompose.arquitecturas.data.BasketballTeam
import com.example.poocompose.estructuras.presentation.map.Conferences

interface BasketballTeamBuilder {

    fun setName(name : String) : BasketballTeamBuilder
    fun setCity(city : String) : BasketballTeamBuilder
    fun setConference(conference : Conferences) : BasketballTeamBuilder
    fun setArena(arena : String) : BasketballTeamBuilder
    fun setIsNba(isNba : Boolean) : BasketballTeamBuilder
    fun setIsGLeague(isGLeague : Boolean) : BasketballTeamBuilder
    fun setAge(age : Int) : BasketballTeamBuilder
    fun setChampionships(champs : Int) : BasketballTeamBuilder
    fun build():BasketballTeam

}