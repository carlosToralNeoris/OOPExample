package com.example.poocompose.estructuras.presentation.array

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArrayViewModel @Inject constructor(
) : ViewModel() {

    var state by mutableStateOf(ArrayState())

    fun editArray(index : Int, name : String){

        val array = state.nbaTeams
        array.set(index, name)

        state.copy(
            nbaTeams = array
        )

    }

}