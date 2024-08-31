package com.example.floragogo.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.floragogo.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SliderBanner() {
    val pagerState = rememberPagerState(initialPage = 0)
    val imageSlider = listOf(
        R.drawable.pexels_kasperphotography_1042423,
        R.drawable.pexels_kasperphotography_1042423,
        R.drawable.pexels_kasperphotography_1042423,
        R.drawable.pexels_kasperphotography_1042423,
        R.drawable.pexels_kasperphotography_1042423
    )

    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2600)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        HorizontalPager(count = imageSlider.size, state = pagerState, contentPadding = PaddingValues(10.dp), modifier = Modifier) {
            page ->
            SliderCard()
        }
        HorizontalPagerIndicator(pagerState = pagerState)
    }
}

@Composable
fun SliderCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box() {
            Image(
                painter = painterResource(R.drawable.pexels_kasperphotography_1042423),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "50% OFF",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "SUMMER",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
                Text(
                    text = "SPECIAL",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
                Text(
                    text = "DISCOUNT",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            }
        }
    }
}