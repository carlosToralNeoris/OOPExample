package com.example.poocompose.estructuras.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.poocompose.estructuras.presentation.map.Conferences
import com.example.poocompose.estructuras.presentation.map.MapViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    viewModel: MapViewModel = hiltViewModel()
) {

    val state = viewModel.state
    
    LaunchedEffect(key1 = Unit) {
        viewModel.getConferenceChamp(Conferences.WEST)
    }

    var switchChange by remember {
        mutableStateOf(false)
    }
    
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Maps")
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Switch(
                checked = switchChange,
                onCheckedChange = {
                    switchChange = !switchChange
                    viewModel.getConferenceChamp(
                        conference = if (switchChange) Conferences.EAST else Conferences.WEST
                    )
                }
            )
            
            AnimatedContent(targetState = switchChange, label = "") {
                when(it){
                    true -> Text(text = "East Champs", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                    false -> Text(text = "West Champs", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                }
                
            }

            LazyColumn {
                itemsIndexed(state.champSelected){ index, team ->
                    Text(text = team.uppercase(), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                }
            }

        }
        
    }



}