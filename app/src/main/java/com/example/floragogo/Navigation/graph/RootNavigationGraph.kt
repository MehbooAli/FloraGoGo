package com.example.floragogo.Navigation.graph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.floragogo.Navigation.screen.Screen
import com.example.floragogo.Screens.ItemDetail.ItemDetailScreen
import com.example.floragogo.Screens.MainDestenationScreen
import com.example.floragogo.Screens.Main.MainScreen
import com.example.floragogo.Screens.PopularItemScreen
import com.example.floragogo.Screens.Search.SearchScreen
import com.example.floragogo.Screens.Splash.SplashScreen
import com.example.floragogo.R
import com.example.floragogo.Screens.CartItemListScreen


@Composable
fun RootNavigationGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) { SplashScreen(navController) }
        composable(route = Screen.Main.route) { MainScreen(navController) }
        composable(route = Screen.PopularItem.route) { PopularItemScreen(true, navController) }
        composable(route = Screen.Search.route) { SearchScreen(navController) }
        composable(route = Screen.CartList.route) { CartItemListScreen(navController) }


        composable(
            route = Screen.ItemDetail.route,
            arguments = listOf(
                navArgument("name") { defaultValue = "" },
                navArgument("price") {
                    type = NavType.FloatType
                    defaultValue = 0.0f  },
                navArgument("image") {
                    type = NavType.IntType;
                    defaultValue = 0.0
                },
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val price = backStackEntry.arguments?.getFloat("price")?.toDouble()
            val image = backStackEntry.arguments?.getInt("image")
            ItemDetailScreen(
                navController,
                name ?: "No message",
                price ?: 0.0,
                image ?: R.drawable.pexels_pixabay_68507,
            )
        }

        //        composable(
//            route = Screen.CartList.route,
//            arguments = listOf(
//                navArgument("name") { defaultValue = "" },
//                navArgument("price") { defaultValue = "" },
//                navArgument("image") { type = NavType.IntType; defaultValue = 0 },
//            )
//        ) { navBackStackEntry ->
//            val name = navBackStackEntry.arguments?.getString("name")
//            val price = navBackStackEntry.arguments?.getString("price")
//            val image = navBackStackEntry.arguments?.getInt("image") ?: 0
//            CartItemListScreen(navController, name ?: "No name", price ?: "No price", image)
//        }

        // hint: bottom bar destination
        composable(route = Graph.MAIN) { MainDestenationScreen() }
        //
    }


}