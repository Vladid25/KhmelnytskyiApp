package com.example.khmelnytskyi


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.khmelnytskyi.database.Database.cafes
import com.example.khmelnytskyi.database.Database.parks
import com.example.khmelnytskyi.database.Database.restaurants
import com.example.khmelnytskyi.database.Database.types
import com.example.khmelnytskyi.ui.DisplayCafe
import com.example.khmelnytskyi.ui.DisplayPark
import com.example.khmelnytskyi.ui.DisplayRestaurant
import com.example.khmelnytskyi.ui.PointTypes
import com.example.khmelnytskyi.ui.PointViewModel
import com.example.khmelnytskyi.ui.SelectPointScreen
import com.example.khmelnytskyi.ui.TypePointScreen

enum class KhmelnytskyiAppScreen {
    TypePoint,
    Example,
    Point
}

//@Preview
@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KhmelnytskyiApp(
    viewModel:PointViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = KhmelnytskyiAppScreen.valueOf(
        backStackEntry?.destination?.route ?: KhmelnytskyiAppScreen.TypePoint.name
    )



    Scaffold {
        innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = KhmelnytskyiAppScreen.TypePoint.name,
             modifier = Modifier.padding(innerPadding)
        ){
            composable(route = KhmelnytskyiAppScreen.TypePoint.name){
                TypePointScreen(
                    options = types,
                    onTypeClicked = {
                        navController.navigate(KhmelnytskyiAppScreen.Example.name)
                        viewModel.setType(it)
                    }
                )
            }
            composable(route = KhmelnytskyiAppScreen.Example.name){
               SelectPointScreen(options = viewModel.currentList)
            }

            composable(route = KhmelnytskyiAppScreen.Point.name){
                if(uiState.currentPoint?.type == PointTypes.Restaurant){
                    restaurants.forEach {
                        item->
                        if(item.name == uiState.currentPoint!!.name){
                            DisplayRestaurant(item)
                        }
                    }
                }
                if(uiState.currentPoint?.type == PointTypes.Cafe){
                    cafes.forEach {
                            item->
                        if(item.name == uiState.currentPoint!!.name){
                            DisplayCafe(item)
                        }
                    }
                }
                if(uiState.currentPoint?.type == PointTypes.Park){
                    parks.forEach {
                            item->
                        if(item.name == uiState.currentPoint!!.name){
                            DisplayPark(item)
                        }
                    }
                }
            }
        }
    }
}