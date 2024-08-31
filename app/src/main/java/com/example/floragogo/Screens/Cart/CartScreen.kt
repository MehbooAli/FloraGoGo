package com.example.floragogo.Screens.Cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.floragogo.Data.Model.DataModel
import com.example.floragogo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavController, vm: CartViewModel = hiltViewModel()) {
    val productCartList by vm.productCartList.collectAsState()

    Scaffold(topBar = { TopAppBar(title = { Text("My Cart") }) }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(8.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            productCartList.forEach { product ->
                CartItem(dataModel = product)
            }
        }
    }
}

@Composable
fun CartItem(dataModel: DataModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row {
            Image(
                painter = painterResource(R.drawable.pexels_jmark_250591),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .padding(10.dp)
            )
            Column {
                Text(dataModel.title)
                Text(dataModel.price.toString())
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text("Quantity: ")
                    Spacer(modifier = Modifier.width(50.dp))
                    Text(dataModel.quantity.toString())
                }
            }
        }
    }
}

@Preview(showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun CartScreenPreview() {
    // Provide a dummy NavController and sample data for preview
    // CartScreen(navController = rememberNavController())
}
