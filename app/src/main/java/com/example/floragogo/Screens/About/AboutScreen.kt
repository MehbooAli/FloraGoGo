package com.example.floragogo.Screens.About

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.floragogo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {
    val data = listOf(
        Triple(Icons.Default.Favorite, "Orders", Icons.Default.ArrowForward),
        Triple(Icons.Default.FavoriteBorder, "My Details", Icons.Default.ArrowForward),
        Triple(Icons.Default.LocationOn, "Delivery Address", Icons.Default.ArrowForward),
        Triple(Icons.Default.LocationOn, "Payment", Icons.Default.ArrowForward),
        Triple(Icons.Default.Notifications, "Notification", Icons.Default.ArrowForward),
    )

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text("Name", fontSize = 14.sp)
                    Text("mehboob@gmail.com", fontSize = 12.sp)
                }
            },
            navigationIcon = {
                Image(
                    painter = painterResource(R.drawable.pexels_kasperphotography_1042423),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(shape = RoundedCornerShape(100.dp))
                        .size(50.dp)
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.White)
        )
    }) { it ->
        Column(modifier = Modifier.padding(it).padding(8.dp)) {
            data.forEach {
                ShowListData(it.first, it.second, it.third)
            }
            Spacer(modifier = Modifier.height(50.dp))
            CenteredIconButton(
                icon = Icons.Default.MailOutline,
                text = "Logout",
                onClick = {}
            )
        }
    }
}

@Composable
fun ShowListData(icon: ImageVector, name: String, iconArrow: ImageVector) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row {
                Icon(icon, contentDescription = null)
                Spacer(modifier = Modifier.width(18.dp))
                Text(name)
            }
            Icon(iconArrow, contentDescription = null)
        }
        HorizontalDivider(thickness = 1.dp, color = Color.Black.copy(alpha = 0.2f))
    }

}

@Composable
fun CenteredIconButton(icon: ImageVector, text: String, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier
                .alignByBaseline()
        )
        Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
        Text(
            text,
            modifier = Modifier
                .weight(1f)
                .alignByBaseline(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun AboutScreenPreview() {
    AboutScreen(navController = rememberNavController())
}