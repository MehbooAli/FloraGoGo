package com.example.floragogo.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CartItemListScreen(
//    navController: NavController, name: String, price: String, image: Int,
    navController: NavController,
//    viewModel: DataModelViewModel = viewModel()
) {
//    val cartItems by viewModel.cartItems.collectAsState(initial = emptyList())


    Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
//        CartItem(name,price,image)
        Text("Cart Item list Screen")
//        if (cartItems.isEmpty()) {
//            Text("No items in cart")
//        } else {
//            cartItems.forEach { item ->
//                CartItem(item)
//            }
//        }
    }
}

//@Composable
//fun CartItem(item: DataBaseTable) {
//    Log.d("CartItem", "Displaying item: $item")
//    Card(modifier = Modifier
//        .fillMaxWidth()
//        .padding(10.dp), shape = RoundedCornerShape(10.dp)) {
//        Row {
//            Image(
//                painter = painterResource(R.drawable.pexels_jmark_250591),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .size(50.dp)
//                    .padding(10.dp)
//            )
//            Column {
//                Text(item.title)
//                Text(item.price.toString())
//                Row(modifier = Modifier.fillMaxWidth()) {
//                    Text("Quantity: ${item.quantity}")
//                    Spacer(modifier = Modifier.width(50.dp))
//                    Text(item.quantity.toString())
//                }
//            }
//        }
//    }
//}
