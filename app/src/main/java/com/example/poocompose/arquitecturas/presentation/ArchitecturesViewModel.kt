package com.example.poocompose.arquitecturas.presentation

import androidx.lifecycle.ViewModel
import com.example.poocompose.arquitecturas.data.BasketballTeamBuilderImpl
import com.example.poocompose.arquitecturas.data.BasketballTeamsManager
import com.example.poocompose.arquitecturas.domain.BasketballTeamBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArchitecturesViewModel @Inject constructor(
    private val basketballTeamsManager: BasketballTeamsManager,
    private val basketballTeamBuilderImpl: BasketballTeamBuilderImpl
) : ViewModel() {

    fun createNBAEasternTeam(
        name : String,
        city : String,
        arena : String,
        age : Int,
        champs : Int
    ){

        val newTeam = basketballTeamsManager.createNBAEasternTeam(
            basketballTeamBuilderImpl = basketballTeamBuilderImpl,
            name = name,
            city = city,
            arena = arena,
            age = age,
            champs = champs
        )

    }

}