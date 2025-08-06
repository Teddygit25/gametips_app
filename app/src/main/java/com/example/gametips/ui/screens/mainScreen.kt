package com.example.gametips.ui.screens

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gametips.R
import com.example.gametips.ui.components.CustomBottomNavBar
import com.example.gametips.ui.components.Screen
import com.example.gametips.ui.data.models.BottomNavBar


@Composable
fun MainScreen(){
    val navController = rememberNavController()

    val bottomNavItems = listOf(
        BottomNavBar("home" , Icons.Default.Home ) ,
        BottomNavBar(Screen.GetGood.route , iconCustom = painterResource(R.drawable.category) ) ,
        BottomNavBar("News" , Icons.Default.Place ) ,
    )

    Scaffold( modifier = Modifier.fillMaxSize()
        ,
        bottomBar = {
            CustomBottomNavBar(navController, bottomNavItems , modifier = Modifier.navigationBarsPadding())
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") { HomePage(innerPadding = paddingValues) }
            composable(Screen.GetGood.route) { CategoriesPage(navController) }
            composable("News") { CoachesPage() }

            // NEW: GameList screen with category argument
            composable(
                  Screen.GameList.route,
                arguments = listOf(navArgument("category") { type = NavType.StringType })
            ) { backStackEntry ->
                val category = backStackEntry.arguments?.getString("category") ?: ""
                GameListPage(category = category , navController)
            }

        }
    }


}