package com.example.floragogo.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.floragogo.Navigation.graph.Graph
import com.example.floragogo.Navigation.screen.Screen
import com.example.floragogo.Component.ContantItemCard
import com.example.floragogo.R

val items = listOf(
    Triple(R.drawable.pexels_unchalee_srirugsar_14114_85773, "Flower First", 100),
    Triple(R.drawable.pexels_jmark_250591, "Flower Second", 100),
    Triple(R.drawable.pexels_kasperphotography_1042423, "Flower Third", 100),
    Triple(R.drawable.pexels_mariannaole_757889, "Flower Fourth", 100),
    Triple(R.drawable.pexels_philippedonn_1133957, "Flower Fifth", 100),
    Triple(R.drawable.pexels_minan1398_906150, "Flower Six", 100),
    Triple(R.drawable.pexels_pixabay_68507, "Flower Seven", 100),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularItemScreen(topBarAllow: Boolean, navController: NavController) {

    Scaffold(
        topBar = {
            if (topBarAllow)
                TopAppBar(
                    title = { Text("Popular Items") },
                    actions = { Icon(Icons.Default.Search, contentDescription = "Icon") },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                )
        }
    )
    {
        Card(
            modifier = Modifier.padding(it),
            shape = RoundedCornerShape(
                topEnd = 0.dp,
                topStart = 0.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            )
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(items.size) { index ->
                    val item = items[index]
                    ContantItemCard(
                        imageResId = item.first,
                        title = item.second,
                        price = item.third,
                        onClick =  {
                            val name = item.second
                            val price = item.third
                            val image = item.first
                            navController.navigate(Screen.ItemDetail.createRoute(name,price,image)) }
                    )
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PopularItemScreenPreview() {
    PopularItemScreen(true, navController = rememberNavController())
}