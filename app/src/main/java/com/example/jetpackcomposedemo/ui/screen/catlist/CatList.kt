package com.example.jetpackcomposedemo.ui.screen.catlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.jetpackcomposedemo.domain.model.Cat
import com.example.jetpackcomposedemo.domain.model.catList
import com.example.jetpackcomposedemo.ui.component.ShimmerListItem


@Composable
fun CatList(navController: NavController, catListViewModel: CatListViewModel = viewModel()) {
    catListViewModel.fetchCat(10, 0)
    val catListState by catListViewModel.catListStateFlow.collectAsState()
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(catListState.listData) { cat ->
            ShimmerListItem(
                isLoading = catListState.dataState == Loading,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAfterLoading = { CatItem(cat = cat) }
            )
        }
    }
}


@Composable
fun CatItem(cat: Cat) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        shape = RoundedCornerShape(20.dp),
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            ElevatedCard(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                AsyncImage(
                    model = cat.image,
                    contentDescription = cat.name,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(150.dp),
                    placeholder = BrushPainter(
                        Brush.linearGradient(
                            listOf(
                                Color(color = 0xFF7D5260),
                                Color(color = 0xFF7D5260),
                            )
                        )
                    )
                )
            }
            Column(modifier = Modifier.padding(all = 24.dp)) {
                Text(text = cat.name)
                Text("Origin : ${cat.origin}")
                Text("temperament : ${cat.temperament}")
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun ShowCatItem() {
    val catList = catList
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(catList) { cat ->
            CatItem(cat = cat)
        }
    }
}