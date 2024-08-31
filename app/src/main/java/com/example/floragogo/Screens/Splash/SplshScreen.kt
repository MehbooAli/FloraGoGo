package com.example.floragogo.Screens.Splash

import android.view.animation.OvershootInterpolator
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.floragogo.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Devices
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import com.example.floragogo.Navigation.graph.Graph


@Composable
fun SplashScreen(navController: NavController, ) {
    LaunchedEffect(key1 = true) {
        scaleIn(
            initialScale = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))
//         Customize the delay time
        delay(3000)
        navController.navigate(Graph.MAIN)    }

    Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.pexels_kasperphotography_1042423),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                "Flora Go Go",
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.align(Alignment.Center)
            )
    }
}



@Preview(showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun SplashScreenPreview() {
    val controller = rememberNavController()
    SplashScreen(controller)
}
