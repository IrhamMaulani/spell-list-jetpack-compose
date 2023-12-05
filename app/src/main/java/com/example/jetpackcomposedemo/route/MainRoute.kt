package com.example.jetpackcomposedemo.route

sealed class MainRoute(val route: String) {
    object HomeScreen : MainRoute("home_screen")
    object PotionScreen : MainRoute("potion_screen")
}
