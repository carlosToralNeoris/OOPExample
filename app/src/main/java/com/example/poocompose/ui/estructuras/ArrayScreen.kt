package com.example.poocompose.ui.estructuras

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.poocompose.presentation.array.ArrayViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArrayScreen(
    viewModel: ArrayViewModel = hiltViewModel()
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
                    Text(text = "Array")
                }
            )
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            if (showDialog){
                EditTeamDialog(
                    buttonText = "Editar",
                    onDismiss = {
                        showDialog = !showDialog
                        indexToEdit = null
                    },
                    onEdit = { newName ->
                        viewModel.editArray(indexToEdit!!, newName)
                        showDialog = !showDialog
                        indexToEdit = null
                    }
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                itemsIndexed(state.nbaTeams) { index, team ->

                    Text(
                        text = "${index + 1}: $team",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                            .clickable {
                                indexToEdit = index
                                showDialog = !showDialog
                            },
                        textAlign = TextAlign.Center
                    )

                }

            }

        }
    }
}

@Composable
fun EditTeamDialog(
    modifier: Modifier = Modifier,
    buttonText: String,
    onDismiss: () -> Unit,
    onEdit: (String) -> Unit
) {

    var newName by remember {
        mutableStateOf("")
    }

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Dialog(
            onDismissRequest = {
                onDismiss()
            }
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp),
                    value = newName,
                    onValueChange = {
                        newName = it
                    },
                    placeholder = {
                        Text(text = "Name")
                    },
                    label = {
                        Text(text = "Name")
                    }
                )

                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        onEdit(newName)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    Text(text = buttonText)
                }
                Spacer(modifier = Modifier.height(12.dp))

            }

        }

    }

}