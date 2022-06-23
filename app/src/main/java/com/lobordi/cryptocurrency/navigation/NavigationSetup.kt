package com.lobordi.cryptocurrency.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lobordi.cryptocurrency.presentation.coin_detail.CoinDetailScreen
import com.lobordi.cryptocurrency.presentation.coin_list.CoinListScreen

sealed class Screen(val route : String){
    object CoinListScreen : Screen("coin_list_screen")
    object CoinDetailScreen : Screen("coin_detail_detail")
}

@Composable
fun NavigationScreens(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(
            route = Screen.CoinListScreen.route
        ) {
            CoinListScreen(navController)
        }
        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ) {
            CoinDetailScreen(navController = navController)
        }
    }
}
