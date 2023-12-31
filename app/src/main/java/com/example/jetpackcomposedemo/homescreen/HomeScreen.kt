package com.example.jetpackcomposedemo.homescreen

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


@Composable
fun HomeScreen(navController: NavController) {
    Surface() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CardMenu(
                title = "Potion",
                drawableImage = R.drawable.potion,
                Modifier.padding(start = 24.dp),
                onclick = {}
            )
            CardMenu(
                title = "Spell",
                drawableImage = R.drawable.spell,
                Modifier.padding(end = 24.dp),
                onclick = {}
            )
        }
    }
}


@Preview
@Composable
fun ShowHomeScreen() {
    HomeScreen(rememberNavController())
}