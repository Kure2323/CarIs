package com.polete.caris.ui.theme.navigation

sealed class Screens {

    object MainScreen : Screens() {
        const val route = "main_screen"
    }
    object CreateCarScreen : Screens() {
        const val route = "create_car_screen"
    }
    object CreateParkingScreen : Screens() {
        const val route = "create_parking_screen"
    }

}