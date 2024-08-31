package com.example.floragogo.Screens.ItemDetail

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.floragogo.Data.Model.DataModel
import kotlinx.coroutines.flow.MutableStateFlow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDetailScreen(
    navController: NavController,
    name: String,
    price: Double,
    image: Int,
    itemDetailViewModel: ItemDetailViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val _noteList = remember { MutableStateFlow(listOf<String>()) }
    val noteList by remember { _noteList }.collectAsState()
//
    var itemCount by remember { mutableIntStateOf(1) }
    var itemAdd by remember { mutableIntStateOf(0) }
    var itemAdded by remember { mutableStateOf(false) }


    Scaffold(modifier = Modifier, topBar = {
        TopAppBar(title = {}, navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null
                )
            }
        }, actions = {
//            Text(itemAdd.toString())
        }
        )
    }) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            // Background Image
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            bottomEnd = 30.dp,
                            bottomStart = 30.dp
                        )
                    ),
                painter = painterResource(image),
                contentDescription = "Item Image",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.BottomCenter)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),  // Adjust height as needed
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
                    shape = RoundedCornerShape(
                        topEnd = 30.dp,
                        topStart = 30.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = name,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = price.toString(),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.White
                            )
                            Row(
                                modifier = Modifier.clip(shape = RoundedCornerShape(8.dp))
                                    .background(color = Color.White).padding(2.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Button(onClick = {
                                    if (itemCount > 1) {
                                        itemCount -= 1
                                    }
                                }) {
                                    Text("-", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                                }; Text(
                                itemCount.toString(),
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 3.dp, end = 3.dp),
                            ); Button(onClick = {
                                itemCount += 1
                            }) {
                                Icon(
                                    Icons.Default.Add,
                                    contentDescription = "Division Icon",
                                )
                            }
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                itemDetailViewModel.addCart(dataModel = DataModel(title = name, price = price, quantity = itemCount))
                                println("Debug: price value is $price and $name, and $itemCount")
                                itemAdded = true
                                Toast.makeText(context, "Item added to cart. name: $name, price: $price, itemCount: $itemCount", Toast.LENGTH_LONG).show()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = MaterialTheme.colorScheme.primary
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text("Add to Cart");
                            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                            Icon(
                                Icons.Default.ArrowForward,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun ItemDetailScreenPreview() {
//    ItemDetailScreen(
//        navController = rememberNavController(),
//        "Name",
//        "765",
//        viewModel = DataModelViewModel(dio = FakeDataAccessObject())
//
//    )
//}