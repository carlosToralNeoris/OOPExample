package com.example.poocompose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.poocompose.ui.estructuras.ArrayScreen
import com.example.poocompose.ui.estructuras.EstructurasScreen
import com.example.poocompose.ui.estructuras.ListScreen
import com.example.poocompose.ui.estructuras.MapScreen
import com.example.poocompose.ui.estructuras.MatrizScreen
import com.example.poocompose.ui.poo.CreateCenterScreen
import com.example.poocompose.ui.poo.CreatePFScreen
import com.example.poocompose.ui.poo.CreatePGScreen
import com.example.poocompose.ui.poo.CreateSFScreen
import com.example.poocompose.ui.poo.CreateSGScreen
import com.example.poocompose.ui.poo.MainScreen

@Composable
fun NavManager() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Estructuras.route
    ) {

        //region POO
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
        //endregion

        //region Estructuras
        composable(
            route = NavRoutes.Estructuras.route
        ){
            EstructurasScreen (
                goToArray = {
                    navController.navigate(NavRoutes.Array.route)
                },
                goToList = {
                    navController.navigate(NavRoutes.List.route)
                },
                goToMap = {
                    navController.navigate(NavRoutes.Map.route)
                },
                gotToMatriz = {
                    navController.navigate(NavRoutes.Matriz.route)
                }
            )
        }
        composable(
            route = NavRoutes.Array.route
        ){
            ArrayScreen()
        }
        composable(
            route = NavRoutes.List.route
        ){
            ListScreen()
        }
        composable(
            route = NavRoutes.Map.route
        ){
            MapScreen()
        }
        composable(
            route = NavRoutes.Matriz.route
        ){
            MatrizScreen()
        }
        //endregion

    }

}

sealed class NavRoutes(val route : String){

    //region POO
    object Main : NavRoutes("Main")
    object PG : NavRoutes("PG")
    object SG : NavRoutes("SG")
    object SF : NavRoutes("SF")
    object PF : NavRoutes("PF")
    object Center : NavRoutes("Center")
    //endregion

    //region EstructurasDeDatos
    object Estructuras : NavRoutes("Estructuras")
    object Array : NavRoutes("Array")
    object List : NavRoutes("List")
    object Map : NavRoutes("Map")
    object Matriz : NavRoutes("Matriz")
    //endregion

}