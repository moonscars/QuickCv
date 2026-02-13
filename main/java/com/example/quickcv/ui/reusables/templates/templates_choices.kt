package com.example.quickcv.ui.reusables.templates

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.R
import androidx.lifecycle.ViewModel
import com.example.quickcv.ui.cvform.cvfromviewmodel


@Composable
fun TemplateChoices(vm: cvfromviewmodel?=null) {

     Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .height(130.dp)
                .width(100.dp)
                .clickable(onClick= { vm?.set_template("template_one") }),


        ) {

            Image(
                painter = painterResource(com.example.quickcv.R.drawable.template_one),
                contentDescription = "templates",
                contentScale = ContentScale.FillBounds
            )

        }

        Spacer(modifier = Modifier.width(10.dp))





    }
}