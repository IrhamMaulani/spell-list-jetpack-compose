package com.example.jetpackcomposedemo.ui.screen.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.R

@Composable
fun CardMenu(
    title: String,
    drawableImage: Int,
    modifier: Modifier = Modifier,
    onclick: () -> Unit
) {
    ElevatedCard(modifier.clickable { onclick.invoke() }) {
        Column {
            Text(
                textAlign = TextAlign.Center,
                text = title,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 14.dp)
            )
            Image(
                painter = painterResource(id = drawableImage),
                contentDescription = "potion",
                modifier = Modifier
                    .size(150.dp)
                    .padding(all = 24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowCardMenu() {
    CardMenu("Potion", R.drawable.potion, Modifier.padding(all = 16.dp), onclick = {})
}