package com.example.floragogo.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.floragogo.Navigation.graph.MainNavGraph
import com.example.floragogo.Navigation.graph.RootNavigationGraph
import com.example.floragogo.Navigation.screen.BottomBar

@Composable
fun  MainDestenationScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        Column(modifier = Modifier.padding(it)) {
            MainNavGraph(navController = navController)
        }
    }
}