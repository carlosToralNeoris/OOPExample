package com.example.poocompose.ui.estructuras

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.poocompose.ui.components.CustomButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EstructurasScreen(
    goToArray : () -> Unit,
    goToList : () -> Unit,
    goToMap : () -> Unit,
    gotToMatriz : () -> Unit
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Estructuras")
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            CustomButton(text = "Array") {
                goToArray()
            }

            CustomButton(text = "List") {
                goToList()
            }

            CustomButton(text = "Matriz") {
                gotToMatriz()
            }

            CustomButton(text = "Map") {
                goToMap()
            }

        }

    }

}

@Preview
@Composable
private fun PES() {
    EstructurasScreen({}, {}, {}){}
}