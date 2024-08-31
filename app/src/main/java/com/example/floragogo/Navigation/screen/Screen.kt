package com.example.floragogo.Navigation.screen

sealed class Screen(val route: String) {
    data object Splash : Screen("splash_screen")
    data object Main : Screen("main_screen")
    data object PopularItem : Screen("popularitem_screen")
    data object Search : Screen("search_screen")
    data object Cart : Screen("cart_screen")
    data object CartList : Screen("cartList_screen/{name}/{price}/{image}") {
        fun createRoute(name: String, price: String, image: Int) = "cartList_screen/$name/$price/$image"
    }

    data object ItemDetail : Screen("itemdetails_screen/{name}/{price}/{image}"){
        fun createRoute(name: String, price: Int, image: Int ) = "itemdetails_screen/$name/$price/$image"
    }
}