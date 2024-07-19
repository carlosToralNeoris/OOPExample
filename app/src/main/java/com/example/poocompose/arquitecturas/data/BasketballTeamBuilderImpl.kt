package com.example.poocompose.arquitecturas.data

import com.example.poocompose.arquitecturas.domain.BasketballTeamBuilder
import com.example.poocompose.estructuras.presentation.map.Conferences

class BasketballTeamBuilderImpl : BasketballTeamBuilder {

    private var name: String? = null
    private var city: String? = null
    private var conference: Conferences? = null
    private var arena: String? = null
    private var isNBA: Boolean? = null
    private var isGLeague: Boolean? = null
    private var age: Int? = null
    private var championships: Int? = null

    override fun setName(name: String) : BasketballTeamBuilder {
        this.name = name
        return this
    }

    override fun setCity(city: String) : BasketballTeamBuilder {
        this.city = city
        return this
    }

    override fun setConference(conference: Conferences) : BasketballTeamBuilder {
        this.conference = conference
        return this
    }

    override fun setArena(arena: String) : BasketballTeamBuilder {
        this.arena = arena
        return this
    }

    override fun setIsNba(isNba: Boolean) : BasketballTeamBuilder {
        this.isNBA = isNba
        return this
    }

    override fun setIsGLeague(isGLeague: Boolean) : BasketballTeamBuilder {
        this.isGLeague = isGLeague
        return this
    }

    override fun setAge(age: Int) : BasketballTeamBuilder {
        this.age = age
        return this
    }

    override fun setChampionships(champs: Int) : BasketballTeamBuilder {
        this.championships = champs
        return this
    }

    override fun build(): BasketballTeam {
        return BasketballTeam(
            name,
            city,
            conference,
            arena,
            isNBA,
            isGLeague,
            age,
            championships,
        )
    }
}