package com.example.poocompose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.poocompose.ui.components.CustomButton

@Composable
fun MainScreen(
    onPGClick : () -> Unit,
    onSGClick : () -> Unit,
    onSFClick : () -> Unit,
    onPFClick : () -> Unit,
    onCClick : () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomButton(text = "Create a PG") {
            onPGClick()
        }

        CustomButton(text = "Create a SG") {
            onSGClick()
        }

        CustomButton(text = "Create a SF") {
            onSFClick()
        }

        CustomButton(text = "Create a PF") {
            onPFClick()
        }

        CustomButton(text = "Create a C") {
            onCClick()
        }

    }

}
