package com.example.floragogo.Screens.Main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.floragogo.Navigation.graph.Graph
import com.example.floragogo.Component.ItemCard
import com.example.floragogo.Component.SliderBanner
import com.example.floragogo.Navigation.screen.Screen
import com.example.floragogo.R
import com.example.floragogo.Screens.PopularItemScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {

    val items = listOf(
        R.drawable.pexels_unchalee_srirugsar_14114_85773,
        R.drawable.pexels_jmark_250591,
        R.drawable.pexels_mariannaole_757889,
        R.drawable.pexels_philippedonn_1133957,
        R.drawable.pexels_pixabay_68507,
        R.drawable.pexels_pixabay_68507,
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("FloraGoGo") },
                actions = {
                    IconButton(onClick = { navController.navigate(Graph.SEARCH) }) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search Icon"
                        )
                    }
                    IconButton(onClick = {
                        navController.navigate(Screen.CartList.route)
                    }) {
                        Icon(
                            Icons.Default.ShoppingCart,
                            contentDescription = "Cart Icon"
                        )
                    }
                }
            )
        },
    ) {
        Card(
            modifier = Modifier.padding(it).fillMaxSize(),
            shape = RoundedCornerShape(
                topStart = 30.dp,
                topEnd = 30.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp,
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(8.dp),
            ) {
                SliderBanner()
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    items.forEach { item ->
                        ItemCard(item)
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Popular Items", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(
                        "View All",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable(
                            interactionSource = remember {
                                MutableInteractionSource()
                            },
                            indication = null
                        ) {
                            navController.navigate(
                                Graph.DETAILS,
                            )
                        },
                    )
                }
                PopularItemScreen(false, navController)
            }
        }
    }
}
//    }

@Preview(showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}