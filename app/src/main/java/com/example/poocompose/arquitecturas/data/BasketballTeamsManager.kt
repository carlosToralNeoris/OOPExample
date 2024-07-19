package com.example.poocompose.arquitecturas.data

import com.example.poocompose.arquitecturas.domain.BasketballTeamBuilder
import com.example.poocompose.estructuras.presentation.map.Conferences
import javax.inject.Inject

class BasketballTeamsManager {

    fun createGLeagueWesternTeam(
        basketballTeamBuilderImpl: BasketballTeamBuilderImpl,
        name : String,
        city : String,
        arena : String,
        age : Int,
        champs : Int
    ):BasketballTeam{
        return basketballTeamBuilderImpl
            .setName(name)
            .setCity(city)
            .setConference(Conferences.WEST)
            .setArena(arena)
            .setIsGLeague(true)
            .setAge(age)
            .setChampionships(champs)
            .build()
    }


    fun createGLeagueEasternTeam(
        basketballTeamBuilderImpl: BasketballTeamBuilderImpl,
        name : String,
        city : String,
        arena : String,
        age : Int,
        champs : Int
    ):BasketballTeam{
        return basketballTeamBuilderImpl
            .setName(name)
            .setCity(city)
            .setConference(Conferences.EAST)
            .setArena(arena)
            .setIsGLeague(true)
            .setAge(age)
            .setChampionships(champs)
            .build()
    }

    fun createNBAWesternTeam(
        basketballTeamBuilderImpl: BasketballTeamBuilderImpl,
        name : String,
        city : String,
        arena : String,
        age : Int,
        champs : Int
    ):BasketballTeam{
        return basketballTeamBuilderImpl
            .setName(name)
            .setCity(city)
            .setConference(Conferences.WEST)
            .setArena(arena)
            .setIsNba(true)
            .setAge(age)
            .setChampionships(champs)
            .build()
    }

    fun createNBAEasternTeam(
        basketballTeamBuilderImpl: BasketballTeamBuilderImpl,
        name : String,
        city : String,
        arena : String,
        age : Int,
        champs : Int
    ):BasketballTeam{
        return basketballTeamBuilderImpl
            .setName(name)
            .setCity(city)
            .setConference(Conferences.EAST)
            .setArena(arena)
            .setIsNba(true)
            .setAge(age)
            .setChampionships(champs)
            .build()
    }

}
