package com.example.poocompose.ui.poo

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.poocompose.data.models.ShootingGuard
import com.example.poocompose.ui.components.CustomButton
import java.util.Locale

@Composable
fun CreateSGScreen() {

    val context = LocalContext.current

    var name by remember {
        mutableStateOf("Luka")
    }
    var lastName by remember {
        mutableStateOf("Doncic")
    }
    var age by remember {
        mutableStateOf(24)
    }
    var team by remember {
        mutableStateOf("Dallas Maverics")
    }
    var handed by remember {
        mutableStateOf("Right")
    }
    var salary by remember {
        mutableStateOf<Double>(50000000.0)
    }
    var player by remember {
        mutableStateOf<ShootingGuard?>(null)
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                value = name,
                onValueChange = {
                    name = it
                },
                placeholder = {
                    Text(text = "Player Name")
                },
                label = {
                    Text(text = "Player Name")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                value = lastName,
                onValueChange = {
                    lastName = it
                },
                placeholder = {
                    Text(text = "Player Last Name")
                },
                label = {
                    Text(text = "Player Last Name")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                value = age.toString(),
                onValueChange = {
                    if (it.isEmpty() || it.matches(Regex("^\\d+\$"))) {
                        age = it.toInt()
                    }
                },
                placeholder = {
                    Text(text = "Player Age")
                },
                label = {
                    Text(text = "Player Age")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword
                )
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                value = team,
                onValueChange = {
                    team = it
                },
                placeholder = {
                    Text(text = "Player Team")
                },
                label = {
                    Text(text = "Player Team")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                value = handed,
                onValueChange = {
                    handed = it
                },
                placeholder = {
                    Text(text = "Player Hand")
                },
                label = {
                    Text(text = "Player Hand")
                }
            )


            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                value = String.format(Locale.US, "%.2f", salary),
                onValueChange = {
                    salary = it.toDouble()
                },
                placeholder = {
                    Text(text = "Player Salary")
                },
                label = {
                    Text(text = "Player Salary")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.NumberPassword
                )
            )

            CustomButton(text = "Create Player") {
                if (name.isNotEmpty() && lastName.isNotEmpty() && age != 0 && team.isNotEmpty() && handed.isNotEmpty() && salary != 0.0) {
                    player = ShootingGuard(
                        name, lastName, age, team, handed, salary
                    )
                    name = ""
                    lastName = ""
                    age = 0
                    team = ""
                    handed = ""
                    salary = 0.0
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            if (player != null) {

                Text(
                    text = "${player!!.getName()} ${player!!.getLastName()}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    CustomButton(text = "Score") {
                        Toast.makeText(context, player!!.score(), Toast.LENGTH_SHORT).show()
                    }

                    CustomButton(text = "Drink") {
                        Toast.makeText(context, player!!.drinkWater(), Toast.LENGTH_SHORT).show()
                    }

                    CustomButton(text = "Greetings") {
                        Toast.makeText(context, player!!.greet(), Toast.LENGTH_SHORT).show()
                    }

                    CustomButton(text = "Trade") {
                        val teams = listOf("Memphis", "Utah", "Chicago", "Denver", "Washington")
                        Toast.makeText(context, "${player!!.getName()} was traded to ${teams.random()}", Toast.LENGTH_SHORT).show()
                    }

                }

                Spacer(modifier = Modifier.weight(1f))

            }

        }

    }

}