package com.example.poocompose.ui.estructuras

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.poocompose.presentation.list.ListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    viewModel: ListViewModel = hiltViewModel()
) {

    val state = viewModel.state

    var showDialog by remember {
        mutableStateOf(false)
    }
    var indexToEdit by remember {
        mutableStateOf<Int?>(null)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "List")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showDialog = !showDialog
                },
                shape = CircleShape
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            if (showDialog) {
                EditTeamDialog(
                    buttonText = "Editar/Agregar",
                    onDismiss = {
                        showDialog = !showDialog
                        indexToEdit = null
                    },
                    onEdit = { newName ->
                        if (indexToEdit == null) {
                            viewModel.addTeam(newName)
                        } else {
                            viewModel.editTeam(indexToEdit!!, newName)
                        }
                        showDialog = !showDialog
                        indexToEdit = null
                    }
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp),
                contentPadding = PaddingValues(bottom = 60.dp)
            ) {

                itemsIndexed(state.nbaTeams){ index, team ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "${index + 1}: $team",
                            modifier = Modifier
                                .padding(vertical = 6.dp)
                                .clickable {
                                    indexToEdit = index
                                    showDialog = !showDialog
                                }
                        )

                        IconButton(
                            onClick = {
                                viewModel.deleteTeam(index)
                            }
                        )
                        {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = "", tint = Color.Black)
                        }

                    }
                }

            }

        }
    }

}