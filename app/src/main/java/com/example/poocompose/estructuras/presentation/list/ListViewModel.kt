package com.example.poocompose.estructuras.presentation.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
) : ViewModel() {

    var state by mutableStateOf(ListState())

    fun editTeam(index: Int?, newName: String) {

        if (index != null) {

            val list = state.nbaTeams

            list[index] = newName

            state = state.copy(
                nbaTeams = list
            )

        }
    }

    fun addTeam(newTeam: String){

        val list = state.nbaTeams

        list.add(newTeam)

        state = state.copy(
            nbaTeams = list
        )

    }

    fun deleteTeam(index : Int){

        val list = state.nbaTeams.filterIndexed { i, s -> i != index }.toMutableList()

        state = state.copy(
            nbaTeams = list
        )

    }
}