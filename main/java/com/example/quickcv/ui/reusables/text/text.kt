package com.example.quickcv.ui.reusables.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quickcv.ui.theme.sf
import com.example.quickcv.ui.theme.sfreg
import com.example.quickcv.ui.theme.space


@Composable
fun SfBoldText(
    value: String,
    fontsize: TextUnit = 40.sp,
    lineheight: TextUnit = fontsize,
    color:Color  = Color.Black,
    space:TextUnit = 0.sp,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        value,
        fontSize = fontsize,
        lineHeight = lineheight,
        textAlign =textAlign,
        fontFamily = sf,
        color  = color
        ,
        letterSpacing = space
    )
}
@Composable
fun SfRegText(
    value: String,
    fontsize: TextUnit = 40.sp,
    lineheight :TextUnit = fontsize,
    color: Color  = Color.Gray,
    textAlign: TextAlign = TextAlign.Center

) {
    Text(
        value,
        fontSize = fontsize,
        lineHeight = lineheight,
        textAlign =textAlign,
        color = color,
        fontFamily = sfreg
    )
}
@Composable
fun SpaceText(
    value: String,
    fontsize: TextUnit = 40.sp,
    lineheight :TextUnit = fontsize,
    color: Color  = Color.Gray,
    textAlign: TextAlign = TextAlign.Center

) {
    Text(
        value,
        fontSize = fontsize,
        lineHeight = lineheight,
        textAlign =textAlign,
        color = color,
        fontFamily = space
    )
}


@Composable
fun RoundText(value: Int=0){

    Box(modifier=Modifier
        .clip(RoundedCornerShape(100))
        .size(20.dp)
        .background(Color.Black),
        contentAlignment = Alignment.Center
    ){
        SfBoldText(value.toString(), fontsize = 10.sp,color=Color.White)

    }

}