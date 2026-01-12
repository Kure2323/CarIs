package com.polete.caris.ui.theme.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.polete.caris.ui.theme.CarIsTheme
import com.polete.caris.ui.theme.components.DefaultView
import com.polete.caris.ui.theme.components.InfoViewer
import com.polete.caris.viewmodel.CarParkingViewModel

@Composable
fun MainScreen(
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier,
    viewModel: CarParkingViewModel = hiltViewModel()
) {

    val cars by viewModel.allCars.collectAsState()
    val parkings by viewModel.allParkings.collectAsState()

    DefaultView(
        navController = navController,
        content = { paddingValues ->
            LazyColumn(modifier = modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {

                items(cars) { car ->


                    //InfoViewer(car = car, parking = parking)

                }

            }
        }
    )

}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun MainScreenPreview() {
    CarIsTheme {
        MainScreen()
    }
}