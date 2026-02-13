package com.example.quickcv.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickcv.R
import com.example.quickcv.data.rooms.ResumeEntity
import com.example.quickcv.ui.reusables.buttons.BasicButton
import com.example.quickcv.ui.reusables.buttons.PrimaryButton
import com.example.quickcv.ui.reusables.text.SfBoldText
//import quickcv.composeapp.generated.resources.R


@Composable
fun ResumaCard(
    title: String = "BackendDeveloper",
    subtitle: String = "Django",
    onDelete :()-> Unit,
    view:()->Unit,
    viewResume:()->Unit,
    onSAP:()->Unit

) {
    view()
    Spacer(modifier  = Modifier.height(20.dp))
    Column(modifier = Modifier
        .clip(shape = RoundedCornerShape(10))
        .background(Color(0xffefefef))
        .padding(10.dp)
        .height(150.dp)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween



        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                SfBoldText(title, fontsize = 20.sp)
                SfBoldText(subtitle, fontsize = 15.sp, color = Color.DarkGray)
            }
            IconButton(onClick = onDelete) {
                Image(
                    painter = painterResource(R.drawable.delete),
                    contentDescription = "Delete button"
                )
            }
        }
        Row(
            modifier  = Modifier
                .fillMaxWidth(),
            Arrangement.SpaceBetween
        ) {
            BasicButton("View", modifier = Modifier
                .height(35.dp).width(150.dp),onclick =viewResume
        )
            PrimaryButton("Set as Primary", modifier = Modifier
                .height(35.dp).width(150.dp),
                onclick = onSAP)
        }
    }
}