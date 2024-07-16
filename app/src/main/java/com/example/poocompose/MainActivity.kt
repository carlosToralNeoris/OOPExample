package com.example.poocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.poocompose.data.models.Center
import com.example.poocompose.ui.NavManager
import com.example.poocompose.ui.theme.PooComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var player : Center = Center(
            name = "Marc",
            lastName = "Gasol",
            age = 38,
            team = "Memphis Grizzlies",
            handed = "Right",
            salary = 3000.0
        )

        player.getName()

        super.onCreate(savedInstanceState)
        setContent {
            PooComposeTheme {
                NavManager()
            }
        }
    }
}