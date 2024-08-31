package com.example.floragogo.Navigation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItemScreen(val route: String, val icon: ImageVector, val title: String) {

    data object Main : BottomNavItemScreen("main_screen", Icons.Default.Home, "Shop")
    data object Search : BottomNavItemScreen("search_screen", Icons.Default.Search, "Search")
    data object Cart : BottomNavItemScreen("cart_screen", Icons.Default.ShoppingCart, "Cart")
    data object About : BottomNavItemScreen("about_screen", Icons.Default.Person, "About")
}