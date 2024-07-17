package com.example.poocompose.presentation.matriz

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatrizViewModel @Inject constructor(

): ViewModel() {

    var state by mutableStateOf(MatrizState())

    fun getDataByConference(conf : String) {

        val lista : MutableList<List<String>> = mutableListOf()

        state.matriz.map { info ->

            if (info[2]==conf){
                lista.add(info)
            }

        }

        state = state.copy(
            actualInfo = lista
        )

    }

}