package com.example.poocompose.presentation.map

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(MapState())

    fun getConferenceChamp(conference : Conferences){

        val teamsList : MutableList<String> = mutableListOf()

        state.nbaChampsByConference.mapValues {
            if (it.key == conference){
                teamsList.add(it.value)
            }
        }

        state = state.copy(
            champSelected = teamsList
        )

    }

}