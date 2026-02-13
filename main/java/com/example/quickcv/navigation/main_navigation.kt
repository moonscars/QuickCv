package com.example.quickcv.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.quickcv.data.rooms.ResumeEntity
import com.example.quickcv.ui.Main.Resume.ResumeScreen
import com.example.quickcv.ui.Main.home.HomeScreen
import com.example.quickcv.ui.Main.search.Search
import com.example.quickcv.ui.cvform.CvFormScreen
import com.example.quickcv.ui.reusables.Logger.Log
import com.example.quickcv.ui.reusables.header.Header
import com.example.quickcv.ui.reusables.safe_area.SafeArea
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.collections.emptyList

@Composable
fun Main_Navigation(Root_NavController: NavController) {


    val main_navController = rememberNavController()

    var currentDestination = main_navController.currentBackStackEntryAsState()

    var ViewResume = remember{mutableStateOf<ResumeEntity?>(null)}

    Scaffold(
        contentWindowInsets = WindowInsets.safeDrawing,
    ) { it ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it)
        ) {
            Header(
                back = currentDestination.value?.destination?.route.toString() != screens.HOME.route,
                main_NavController = main_navController
            )
            NavHost(navController = main_navController, startDestination = screens.HOME.route) {
                composable(screens.HOME.route) {
                    HomeScreen(
                        main_navController = main_navController,
                        viewResume =ViewResume
                    )

                }
                composable(screens.CVFORM.route) {
                    CvFormScreen(
                        main_navController = main_navController,


                    )

                }
                composable (screens.RESUME.route){ ResumeScreen(Resume = ViewResume) }
                composable (screens.SEARCH.route){ Search() }
            }
        }
    }

}
