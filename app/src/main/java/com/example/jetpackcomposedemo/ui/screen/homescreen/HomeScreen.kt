package com.example.jetpackcomposedemo.ui.screen.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposedemo.R
import com.example.jetpackcomposedemo.ui.screen.route.CatList


@Composable
fun HomeScreen(navController: NavController) {
    Surface() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CardMenu(
                title = "Cat",
                drawableImage = R.drawable.cat,
                Modifier.padding(start = 24.dp),
                onclick = { navToCatPage(navController) }
            )
            CardMenu(
                title = "Dog",
                drawableImage = R.drawable.dog,
                Modifier.padding(end = 24.dp),
                onclick = {}
            )
        }
    }
}

fun navToCatPage(navController: NavController) {
    navController.navigate(CatList)
}


@Preview
@Composable
fun ShowHomeScreen() {
    HomeScreen(rememberNavController())
}