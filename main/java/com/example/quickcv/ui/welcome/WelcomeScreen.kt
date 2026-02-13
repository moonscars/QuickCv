package com.example.quickcv.ui.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quickcv.ui.reusables.buttons.PrimaryButton
import com.example.quickcv.ui.reusables.logo.Logo
import com.example.quickcv.ui.reusables.safe_area.SafeArea
import com.example.quickcv.ui.reusables.text.SfBoldText
import com.example.quickcv.ui.reusables.text.SfRegText
import com.example.quickcv.ui.reusables.text.SpaceText
import kotlinx.coroutines.delay
import com.example.quickcv.R
import org.koin.androidx.compose.koinViewModel


@Composable
fun WelcomeScreen(
    viewmodel: welcomeviewmodel = koinViewModel(),
    ChangeScreen: ()-> Unit = {}
) {
    SafeArea {
        Column(Modifier.padding(10.dp,0.dp)) {
            Column { Logo() }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) { AutoImageSlider() }
            Column(
                modifier = Modifier.padding(25.dp)
            ) {
                SfBoldText(
                    "Build and Share Your Professional  Resume",
                    fontsize = 35.sp,
                    lineheight = 40.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                SfRegText(
                    "With Quickcv you can share your resume inside app only",
                    15.sp,
                    lineheight = 20.sp
                )
                Spacer(modifier = Modifier.height(10.dp))

            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                PrimaryButton(
                    "Get Started",
                    modifier = Modifier
                        .height(45.dp)
                        .fillMaxWidth(),
                    onclick=ChangeScreen
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {

                    SpaceText("By clicking on you agree", fontsize = 13.sp, color = Color.Black)
                    SpaceText(" T&D", fontsize = 13.sp, color = Color(0xff0066FF))
                }
            }


        }

    }
}


@Composable
fun AutoImageSlider() {


    var count = remember { mutableStateOf(1) }
    LaunchedEffect(true) {

        while (true) {
            if (count.value == 3) {
                delay(4000)
                count.value = 1
            }
            delay(4000)
            count.value += 1
        }
    }
    Box(
        modifier = Modifier
    ) {

        AnimatedVisibility(
            visible = if (count.value == 1) true else false,
            enter = fadeIn()+slideInHorizontally(),
            exit = fadeOut() + slideOutHorizontally()
        ) {
            Image(
                painter = painterResource(R.drawable.welcome_one),
                contentDescription = "welcome screen image ",
                modifier = Modifier
                    .height(300.dp)
                    .width(330.dp)
                    .clip(shape = RoundedCornerShape(15.dp)),
            )
        }
        AnimatedVisibility(
            visible = if (count.value == 2) true else false,
            enter = fadeIn(),
            exit = fadeOut() + slideOutHorizontally()
        ) {
            Image(
                painter = painterResource(R.drawable.welcome_two),
                contentDescription = "welcome screen image ",
                modifier = Modifier
                    .height(300.dp)
                    .width(330.dp)
                    .clip(shape = RoundedCornerShape(15.dp)),
            )
        }
        AnimatedVisibility(
            visible = if (count.value == 3) true else false,
            enter = fadeIn() + slideInHorizontally(),
            exit = fadeOut() + slideOutHorizontally()
        ) {
            Image(
                painter = painterResource(R.drawable.welcome_three),
                contentDescription = "welcome screen image ",
                modifier = Modifier
                    .height(300.dp)
                    .width(330.dp)
                    .clip(shape = RoundedCornerShape(15.dp)),
            )
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {


        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(shape = RoundedCornerShape(100))
                .background(if (count.value == 1) Color.Black else Color.Gray)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(shape = RoundedCornerShape(100))
                .background(if (count.value == 2) Color.Black else Color.Gray)
        )
        Spacer(modifier = Modifier.width(10.dp))

        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(shape = RoundedCornerShape(100))
                .background(if (count.value == 3) Color.Black else Color.Gray)
        )

    }


}
