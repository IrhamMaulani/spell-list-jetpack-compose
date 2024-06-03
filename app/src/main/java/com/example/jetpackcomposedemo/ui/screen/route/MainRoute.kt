package com.example.jetpackcomposedemo.ui.screen.route

import kotlinx.serialization.Serializable

//sealed class MainRoute(val route: String) {
//    object HomeScreen : MainRoute("home_screen")
//    object PotionScreen : MainRoute("potion_screen")
//
//    object CatList : MainRoute("cat_list")
//}


@Serializable
object Home

@Serializable
object CatList

