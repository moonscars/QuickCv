package com.example.quickcv.ui.Main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quickcv.data.rooms.ResumeEntity
import com.example.quickcv.navigation.screens
import com.example.quickcv.ui.home.components.HomeBody
import com.example.quickcv.ui.home.components.NoResume
import com.example.quickcv.ui.reusables.Logger.Log
import com.example.quickcv.ui.reusables.safe_area.SafeArea
import kotlinx.coroutines.flow.MutableStateFlow
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    main_navController: NavController,
    viewmodel: homeviewmodel = koinViewModel(),
    viewResume: MutableState<ResumeEntity?>

    ) {


    val data = viewmodel.AllResumes.collectAsState().value
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(5.dp, 0.dp)
    ) {

        if (data.isNullOrEmpty())
            NoResume(
                onclick = {
                    main_navController.navigate(screens.CVFORM.route)
                })
        else
            HomeBody(
                vm = viewmodel,
                ResumeData = data, onNewClick = {
                    main_navController.navigate(screens.CVFORM.route)
                },
                viewResume = viewResume,
                onViewResume = {
                    main_navController.navigate(screens.RESUME.route)
                }
            )
    }


}