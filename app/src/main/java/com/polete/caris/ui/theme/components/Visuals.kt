package com.polete.caris.ui.theme.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.polete.caris.data.local.entities.Car
import com.polete.caris.data.local.entities.Parking
import com.polete.caris.ui.theme.CarIsTheme
import com.polete.caris.ui.theme.navigation.Screens
import kotlinx.coroutines.launch

@Composable
fun InfoViewer(
    modifier: Modifier = Modifier,
    car: Car,
    parking: Parking?
    ) {

    Card(
        modifier = modifier.fillMaxWidth().height(100.dp),
        shape = CardDefaults.outlinedShape,
        colors = CardDefaults.cardColors()
    ) {

        Row(
            modifier = modifier.fillMaxSize().padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                modifier = modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(imageVector = Icons.Outlined.Info, contentDescription = "Info")
                Text("El ${car.name} está en: ")

                parking?.let {
                    Text(parking.name)
                }?: Text("Ningún lado")
            }
        }

    }


}

@Composable
fun DefaultView(
    modifier: Modifier = Modifier,
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit
) {

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Drawer()
        }
    ) {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = {
                TopBar(onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                })
            },
            bottomBar = { BottomBar(navController) }
        ) { paddingValues ->
            content(paddingValues)
        }
    }

}

@Composable
fun Drawer() {
    ModalDrawerSheet {
        Text("Hola")
        Text("Hola")
        Text("Hola")
    }
}

@Composable
fun Menu(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        Modifier.size(48.dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.Menu,
            contentDescription = "Menu"
        )
    }
}

@Composable
fun BottomBar(
    navController: NavController
) {

    val currentLocation = navController.currentDestination?.route

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.navigationBars)
            .height(54.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = {
                    if (currentLocation != Screens.MainScreen.route) {
                        navController.navigate(Screens.MainScreen.route)
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home"
                )
            }

            IconButton(
                modifier = Modifier.size(48.dp),
                onClick = {
                    if (currentLocation != Screens.CreateCarScreen.route) {
                        navController.navigate(Screens.CreateCarScreen.route)
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "Home"
                )
            }

        }
    }

}

@Composable
fun TopBar(title: String = "CarIs", onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.statusBars)
            .height(56.dp)
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Menu(onClick)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultViewPreview() {
    CarIsTheme {
        DefaultView(
            navController = rememberNavController(),
            content = {}
        )
    }
}
@Preview
@Composable
fun InfoPreview() {
    CarIsTheme {
        InfoViewer(
            car = Car(name = "Bólido", licensePlate = ""),
            parking = Parking(name = "La que sube", carId = null)
        )
    }
}