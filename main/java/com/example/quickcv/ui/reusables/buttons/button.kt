package com.example.quickcv.ui.reusables.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickcv.ui.reusables.loading.Loading
import com.example.quickcv.ui.reusables.text.SfRegText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PrimaryButton(
    label: String = "Click Me",
    modifier: Modifier,
    onclick: () -> Unit = {},
    isloading: Boolean = false

) {


    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(100))
            .background(Color(0xff0066FF))
            .clickable(onClick = onclick),
        contentAlignment = Alignment.Center
    ) {
        if (isloading) {
            Loading()
        } else {
            SfRegText(label, fontsize = 15.sp, color = Color.White)
        }
    }

}

@Composable
fun SecondaryButton(
    label: String = "Click Me",
    modifier: Modifier,
    onclick: () -> Unit = {}

) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(100))
            .background(Color(0xffF9FAFB))
            .clickable(onClick = onclick),
        contentAlignment = Alignment.Center
    ) {
        SfRegText(label, fontsize = 15.sp, color = Color(0xff0066FF))
    }

}

@Composable
fun BasicButton(
    label: String = "Click Me",
    modifier: Modifier,
    onclick: () -> Unit = {}

) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(100))
            .background(Color.White)
            .clickable(onClick = onclick),
        contentAlignment = Alignment.Center
    ) {
        SfRegText(label, fontsize = 15.sp, color = Color(0xff0066FF))
    }

}

@Composable
fun DangerButton(
    label: String = "Click Me",
    modifier: Modifier,
    onclick: () -> Unit = {}

) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(100))
            .background(Color.Red)
            .clickable(onClick = onclick),
        contentAlignment = Alignment.Center
    ) {
        SfRegText(label, fontsize = 15.sp, color = Color.White)
    }

}