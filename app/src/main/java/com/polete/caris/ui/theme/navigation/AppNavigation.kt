package com.polete.caris.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.polete.caris.ui.theme.screens.MainScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route
    ) {

        composable(route = Screens.MainScreen.route) {
            MainScreen(navController = navController)
        }

    }


}