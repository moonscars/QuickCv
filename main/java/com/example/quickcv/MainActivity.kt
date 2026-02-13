package com.example.quickcv

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import com.example.quickcv.navigation.RootNavigation
import com.example.quickcv.ui.splash.SplashScreen

import com.example.quickcv.ui.theme.QuickCVTheme
import com.example.quickcv.ui.welcome.WelcomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            QuickCVTheme {
                RootNavigation()
//                    SplashScreen()

//                WelcomeScreen()


            }
        }

    }
}
