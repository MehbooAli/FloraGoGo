package com.example.floragogo.Screens.Search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {
    var textFieldValue by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Find Product") }) }
    )
    {
        Column(
            modifier = Modifier.padding(it).fillMaxSize().padding(8.dp),
        ) {
            TextField(
                value = textFieldValue,
                onValueChange = {textFieldValue = it},
                modifier = Modifier.fillMaxWidth(),
                )
        }
    }
}