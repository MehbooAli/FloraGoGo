package com.example.floragogo.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.floragogo.R


@Composable
fun ItemCard(image : Int) {
    Card(
        modifier = Modifier.size(height = 70.dp, width = 70.dp),
        colors = CardDefaults.cardColors(Color.White),
        ) {
        Image(
            modifier = Modifier.padding(8.dp).clip(shape = RoundedCornerShape(8.dp)),
            painter = painterResource(image),
            contentDescription = "Images",
            contentScale = ContentScale.Crop,
            )
    }
}

@Composable
fun ContantItemCard(
    modifier: Modifier = Modifier,
    imageResId: Int,
    title: String,
    price: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .size(height = 180.dp, width = 120.dp)
            .padding(8.dp)
            .clickable { onClick() }
        ,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                textAlign = TextAlign.Center
            )
            Text(
                text = price.toString(),
                textAlign = TextAlign.Center
            )
        }
    }
}

