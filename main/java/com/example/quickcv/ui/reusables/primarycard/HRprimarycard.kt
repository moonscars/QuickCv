package com.example.quickcv.ui.reusables.primarycard


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.quickcv.ui.reusables.buttons.PrimaryButton
import com.example.quickcv.ui.reusables.text.SfBoldText
import com.example.quickcv.ui.reusables.text.SfRegText
import com.example.quickcv.ui.reusables.text.SpaceText

@Composable
fun HRPrimaryCard(title:String="Job Title",code:String="C0D1",name:String="Defalut Name",onclick: () -> Unit={}) {
    Spacer(Modifier.height(10.dp))
    Box(
        modifier = Modifier
            .zIndex(1f)
            .padding(30.dp, 0.dp)
            .clip(
                shape = RoundedCornerShape(
                    20.dp, 20.dp,
                    0.dp, 0.dp
                )
            )
//                Color(0xff7358FF)
            .background(brush = linearGradient(
                colors = listOf(Color(0xff7358FF),Color(0xffA695FF),Color(0xff7358FF))
            ))
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Row(
            modifier  = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            Arrangement.SpaceBetween,
            Alignment.CenterVertically

        ){
            SfBoldText(title, fontsize = 16.sp, color = Color(0xff170576))
            SfBoldText(code, fontsize = 20.sp,color = Color(0xff170576), space = 5.sp
            )
        }
    }
    Column(
        modifier = Modifier
            .offset(0.dp, -35.dp)
            .clip(shape = RoundedCornerShape(40.dp))
            .background(Color(0xffA695FF))
            .fillMaxWidth()
            .height(170.dp),
        Arrangement.Bottom
    ) {


        Box(
            modifier = Modifier
                .padding(15.dp, 0.dp, 15.dp, 15.dp)
                .clip(
                    shape = RoundedCornerShape(
                        10.dp, 10.dp,
                        30.dp, 30.dp
                    )
                )
                .background(Color(0xff170576))
                .fillMaxWidth()
                .height(120.dp)
        ){
            Column  (modifier =Modifier.fillMaxSize().padding(15.dp),
                Arrangement.SpaceBetween
            ){
                SfBoldText(name,color=Color.White, fontsize = 20.sp)
                Row(
                    modifier  = Modifier.fillMaxWidth( ), Arrangement.SpaceBetween
                ) {

                    PrimaryButton("Hook",modifier= Modifier.height(30.dp).width(130.dp),onclick)
                    PrimaryButton("View",modifier= Modifier.height(30.dp).width(130.dp),onclick)

                }
            }
        }

    }

}




