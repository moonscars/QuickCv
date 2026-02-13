package com.example.quickcv.ui.reusables.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.quickcv.R
import com.example.quickcv.navigation.Main_Navigation
import com.example.quickcv.navigation.screens
import com.example.quickcv.ui.reusables.Logger.Log
import com.example.quickcv.ui.reusables.logo.Logo


@Composable
fun Header(back: Boolean = false,main_NavController: NavController) {
    Log.say("abhi","start header")

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        Arrangement.SpaceBetween
    ) {
        Logo()
        Row {
            if (!back) {
                IconButton(onClick = { main_NavController.navigate(screens.SEARCH.route)}) {
                    Image(
                        painter = painterResource(R.drawable.search),
                        contentDescription = "search image"
                    )
                }
                IconButton(onClick = {}) {
                    Image(
                        painter = painterResource(R.drawable.setting),
                        contentDescription = "setting image"
                    )
                }


            } else {
                IconButton(onClick = {main_NavController.popBackStack()}) {
                    Image(
                        painter = painterResource(R.drawable.back),
                        contentDescription = "back image"
                    )
                }
            }
        }
    }
}