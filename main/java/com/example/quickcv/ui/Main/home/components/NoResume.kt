package com.example.quickcv.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.quickcv.ui.reusables.Logger.Log
import com.example.quickcv.ui.reusables.buttons.PrimaryButton
import com.example.quickcv.ui.reusables.text.SfBoldText
import com.example.quickcv.ui.reusables.text.SfRegText

@Composable
fun NoResume(onclick:()->Unit) {
    Log.say("abhi","start no Resume")

    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Bottom

    ) {
        Column(
            modifier = Modifier.padding(25.dp)

        ) {
            SfBoldText(
                "Create Your  Amazing Resume With US",
                fontsize =35.sp,
                lineheight = 40.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            SfRegText(
                "you can search resume by clicking on search button directly ",
                15.sp,
                lineheight = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PrimaryButton("Build  My Resume",
                modifier = Modifier.height(45.dp).fillMaxWidth(),
                onclick =onclick)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}