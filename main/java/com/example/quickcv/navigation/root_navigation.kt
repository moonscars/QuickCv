package com.example.quickcv.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.quickcv.ui.Main.home.HomeScreen
import com.example.quickcv.ui.splash.SplashScreen
import com.example.quickcv.ui.welcome.WelcomeScreen


@Composable
fun RootNavigation() {
    val nav_controller = rememberNavController()
    NavHost(
        navController = nav_controller,
        startDestination = screens.SPLASH.route,
    ) {

        composable(screens.SPLASH.route) { SplashScreen(navController = nav_controller) }
        composable(screens.WELCOME.route) {
            WelcomeScreen(ChangeScreen = {
                nav_controller.popBackStack()
                nav_controller.navigate(
                    screens.MAIN.route
                )
            })
        }

        composable(screens.MAIN.route) { Main_Navigation(Root_NavController = nav_controller) }

    }
}


