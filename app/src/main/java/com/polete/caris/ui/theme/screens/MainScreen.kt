package com.polete.caris.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.polete.caris.ui.theme.components.DefaultView
import com.polete.caris.ui.theme.navigation.Screens

@Composable
fun MainScreen(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier,
    // ViewModel para listar
) {

    DefaultView(
        navController = navController
    ) {

        Box(
            Modifier.background(Color.Red)
        )

    }

}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}