package com.example.floragogo.Navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.floragogo.Navigation.screen.BottomNavItemScreen
import com.example.floragogo.Navigation.screen.Screen
import com.example.floragogo.Screens.About.AboutScreen
import com.example.floragogo.Screens.Cart.CartScreen
import com.example.floragogo.Screens.ItemDetail.ItemDetailScreen
import com.example.floragogo.Screens.Main.MainScreen
import com.example.floragogo.Screens.PopularItemScreen
import com.example.floragogo.Screens.Search.SearchScreen
import com.example.floragogo.R
import com.example.floragogo.Screens.CartItemListScreen

@Composable
fun MainNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = BottomNavItemScreen.Main.route
    ) {
        composable(route = BottomNavItemScreen.Main.route) { MainScreen(navController) }
        composable(route = BottomNavItemScreen.Search.route) { SearchScreen(navController) }
        composable(route = BottomNavItemScreen.Cart.route) { CartScreen(navController) }
        composable(route = BottomNavItemScreen.About.route) { AboutScreen(navController) }
        detailsNavGraph(navController)
        searchNavGraph(navController)
        itemDetailGraph(navController)
//        cartItemListNavGraph(navController)
        cartListNavGraph(navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = Screen.PopularItem.route,
    ) {
        composable(route = Screen.PopularItem.route) {
            PopularItemScreen(true, navController)
        }
    }
}

fun NavGraphBuilder.searchNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.SEARCH,
        startDestination = Screen.Search.route,
    ) {
        composable(route = Screen.Search.route) { SearchScreen(navController) }
    }
}


fun NavGraphBuilder.itemDetailGraph(navController: NavHostController) {
    navigation(
        route = Graph.ITEMDETAIL,
        startDestination = Screen.ItemDetail.route,
    ) {
        composable(
            route = Screen.ItemDetail.route,
            arguments = listOf(
                navArgument("name") { defaultValue = "" },
                navArgument("price") {
                    type = NavType.FloatType
                    defaultValue = 0.0f  },
                navArgument("image") {
                    type = NavType.IntType;
                    defaultValue = 0.0 }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val price = backStackEntry.arguments?.getFloat("price")?.toDouble()
            val image = backStackEntry.arguments?.getInt("image")
            ItemDetailScreen(navController, name ?: "No name", price ?: 0.0 ,image ?: R.drawable.pexels_pixabay_68507) }
    }
}



fun NavGraphBuilder.cartListNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CartList,
        startDestination = Screen.CartList.route,
    ) {
        composable(route = Screen.CartList.route) {
//            PopularItemScreen(true, navController)
            CartItemListScreen(navController)
        }
    }
}