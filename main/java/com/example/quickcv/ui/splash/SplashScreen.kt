package com.example.quickcv.ui.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.quickcv.navigation.screens
import com.example.quickcv.ui.reusables.logo.Logo
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel


@Composable
fun SplashScreen(
    viewmodel: splashviewmodel = koinViewModel(),
    navController: NavController
) {
    LaunchedEffect(true) {
        delay(4200)
        navController.popBackStack()
        navController.navigate(screens.WELCOME.route)
    }

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(!viewmodel.isVisible.collectAsState().value, exit = fadeOut()) {
            Logo()
        }


    }

}

