package com.example.poocompose.ui.estructuras

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.poocompose.presentation.matriz.MatrizViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatrizScreen(
    viewModel: MatrizViewModel = hiltViewModel()
) {

    val state = viewModel.state
    var switchChange by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.getDataByConference("West")
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Matriz") }
            )
        }
    ) { paddingValues ->

    LazyColumn(modifier = Modifier.padding(paddingValues)) {

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "West", color = if (switchChange) Color.Transparent else Color.Black)

                Switch(
                    checked = switchChange,
                    onCheckedChange = {
                        switchChange = !switchChange
                        viewModel.getDataByConference(
                            conf = if (switchChange) "East" else "West"
                        )
                    }
                )

                Text(text = "East", color = if (switchChange) Color.Black else Color.Transparent)
            }
        }

        items(state.actualInfo) {

            InfoRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                team = it[0],
                arena = it[1],
                conf = it[2]
            )
        }
    }

    }
}

@Preview
@Composable
fun InfoRow(
    modifier: Modifier = Modifier,
    team: String = "NA",
    arena: String = "NA",
    conf: String = "NA"
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(24.dp)
            .border(border = BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(12.dp))
            .clip(shape = RoundedCornerShape(bottomStart = 12.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = team,
                textAlign = TextAlign.Center
            )
        }

        VerticalDivider()

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = arena,
                textAlign = TextAlign.Center
            )
        }

        VerticalDivider()

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = conf,
                textAlign = TextAlign.Center
            )
        }

    }

}

