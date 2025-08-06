package com.example.gametips.ui.components

sealed class Screen(val route: String) {

    // This is the route for the Get Good category screen
    object GetGood : Screen("Get good")

    // This is the route for the list of games under a selected category
    object GameList : Screen("game_list/{category}") {
        // This builds a specific route like "game_list/RACING"
        fun createRoute(category: String) = "game_list/$category"
    }
}
