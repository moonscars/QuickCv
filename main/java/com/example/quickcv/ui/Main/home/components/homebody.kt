package com.example.quickcv.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quickcv.data.rooms.ResumeEntity
import com.example.quickcv.ui.Main.home.homeviewmodel
import com.example.quickcv.ui.reusables.Logger.Log
import com.example.quickcv.ui.reusables.buttons.PrimaryButton
import com.example.quickcv.ui.reusables.primarycard.PrimaryCard
import com.example.quickcv.ui.reusables.templates.TemplateChoices
import com.example.quickcv.ui.reusables.text.SfBoldText

@Composable
fun HomeBody(
    vm: homeviewmodel,
    ResumeData: List<ResumeEntity>,
    onNewClick: () -> Unit,
    viewResume: MutableState<ResumeEntity?>,
    onViewResume: () -> Unit
) {
    val codex = vm.localdata.collectAsState().value?.code
    val views = vm.localdata.collectAsState().value?.views
    val jobtitle = vm.localdata.collectAsState().value?.jobtitle


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(5.dp, 0.dp),
    ) {



            PrimaryCard(
                title = jobtitle.toString(),
                code = codex.toString(),
                views = views.toString()

            )







        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp, 0.dp, 0.dp),
        ) {
            SfBoldText("Templates", fontsize = 15.sp)
        }
        TemplateChoices()


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp, 0.dp, 0.dp),
            Arrangement.SpaceBetween,
            Alignment.CenterVertically
        ) {
            SfBoldText("My Resume", fontsize = 15.sp)
            PrimaryButton(
                "New", modifier = Modifier
                    .height(30.dp)
                    .width(120.dp),
                onclick = onNewClick
            )

        }


        ResumeData.forEach { ResumeData ->
            ResumaCard(
                title = ResumeData.jobtitle.capitalize(),
                subtitle = ResumeData.email,
                onDelete = { vm.DeleteResume(ResumeData) },
                view = { viewResume.value = ResumeData },
                viewResume = onViewResume,
                onSAP = { vm.SetAsPrimary(ResumeData, codex) }

            )
        }


//        ResumaCard()
//        ResumaCard()


    }
}