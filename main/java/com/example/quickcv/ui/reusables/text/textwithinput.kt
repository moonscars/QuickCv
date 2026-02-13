package com.example.quickcv.ui.reusables.text

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextNInput(label: String = "Label", value: String = "", onChange: (String) -> Unit={} ) {

    SfRegText(label, fontsize = 20.sp, color = Color.Black)
    Spacer(Modifier.height(5.dp))
    BasicTextField(
        value = value,
        onValueChange =  onChange  ,
        modifier = Modifier
            .border(
                2.dp,
                Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
            .height(40.dp)
            .padding(10.dp)
            .fillMaxWidth(),
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 15.sp,
            textMotion = TextMotion.Animated
        ),
    )
    Spacer(Modifier.height(5.dp))

}