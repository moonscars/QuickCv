package com.example.quickcv.ui.reusables.logo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quickcv.R


@Composable
@Preview(showBackground = true)
fun Logo() {

    Image(
        painter = painterResource(R.drawable.applogo),
        contentDescription = "app logo",
        modifier = Modifier
            .height(40.dp)
            .width(120.dp)
    )

}