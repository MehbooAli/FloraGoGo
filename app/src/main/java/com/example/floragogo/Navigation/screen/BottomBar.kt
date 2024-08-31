package com.example.floragogo.Navigation.screen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomBar(navController: NavController, modifier: Modifier = Modifier) {
    val navigationItems = listOf(
        BottomNavItemScreen.Main,
        BottomNavItemScreen.Search,
        BottomNavItemScreen.Cart,
        BottomNavItemScreen.About,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val bottomBarDestination = navigationItems.any { it.route == currentRoute }

    if (bottomBarDestination) {
        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Color.Black,
            modifier = modifier
        ) {
            navigationItems.forEach { item ->
                BottomNavigationItem(
                    icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                    label = {
                        Text(
                            text = item.title, color = if (currentRoute == item.route) {
                                MaterialTheme.colorScheme.primary
                            } else Color.Black.copy(0.6f)
                        )
                    },
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = Color.Black.copy(0.6f),
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationId.let { screen_rout ->
                                popUpTo(screen_rout) { saveState = true }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}