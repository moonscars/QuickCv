package com.example.quickcv.ui.Main.Resume

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.quickcv.data.rooms.ResumeEntity
import com.example.quickcv.ui.reusables.template.TemplateOne

@Composable
fun ResumeScreen(Resume: MutableState<ResumeEntity?>){

    TemplateOne(Resume)

}