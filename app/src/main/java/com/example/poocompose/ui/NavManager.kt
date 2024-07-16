package com.example.poocompose.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavManager() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Main.route
    ) {

        composable(
            route = NavRoutes.Main.route
        ){
            MainScreen(
                onPGClick = {
                    navController.navigate(NavRoutes.PG.route)
                },
                onSGClick =  {
                    navController.navigate(NavRoutes.SG.route)
                },
                onSFClick =  {
                    navController.navigate(NavRoutes.SF.route)
                },
                onPFClick =  {
                    navController.navigate(NavRoutes.PF.route)
                },
                onCClick =  {
                    navController.navigate(NavRoutes.Center.route)
                },
            )
        }

        composable(
            route = NavRoutes.PG.route
        ){
            CreatePGScreen()
        }

        composable(
            route = NavRoutes.SG.route
        ){
            CreateSGScreen()
        }

        composable(
            route = NavRoutes.SF.route
        ){
            CreateSFScreen()
        }

        composable(
            route = NavRoutes.PF.route
        ){
            CreatePFScreen()
        }

        composable(
            route = NavRoutes.Center.route
        ){
            CreateCenterScreen()
        }

    }

}

sealed class NavRoutes(val route : String){

    object Main : NavRoutes("Main")
    object PG : NavRoutes("PG")
    object SG : NavRoutes("SG")
    object SF : NavRoutes("SF")
    object PF : NavRoutes("PF")
    object Center : NavRoutes("Center")

}