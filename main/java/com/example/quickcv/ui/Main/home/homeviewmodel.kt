package com.example.quickcv.ui.Main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quickcv.data.PrimaryRequest
import com.example.quickcv.data.ktor.SetPrimaryData
//import com.example.quickcv.data.ktor.RemoteApi
import com.example.quickcv.data.localRepository.LocalRepository
//import com.example.quickcv.data.localRepository.LocalRepositoryPrimary
import com.example.quickcv.data.rooms.PrimaryCardEntity
import com.example.quickcv.data.rooms.PrimaryDoa
import com.example.quickcv.data.rooms.ResumeEntity
import com.example.quickcv.ui.reusables.Logger.Log
import com.example.quickcv.ui.reusables.logo.Logo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import okhttp3.Response

class homeviewmodel(
    private val localDataRepository: LocalRepository,
    private val primarydataRepository: PrimaryDoa,
) : ViewModel() {

    val AllResumes: StateFlow<List<ResumeEntity>> = localDataRepository.AllResume.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    val localdata  = primarydataRepository.GetPrimaryData().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = null
    )


    fun DeleteResume(resume: ResumeEntity) {
        viewModelScope.launch {
            localDataRepository.PopResume(resume)
        }
    }

    fun SetAsPrimary(resume: ResumeEntity,code:String?){


        Log.say("codxx","${code}")
        val data = PrimaryRequest(resume = resume,code =code)
        Log.say("codxx","${data.code.toString()}")

        val remoteapi = viewModelScope.launch {
            try {
                val response = SetPrimaryData(data)
                val data  = PrimaryCardEntity(code = response.code, views =response.views, jobtitle = response.jobtitle)
                primarydataRepository.UpsertPrimaryData(data)



            }catch (e: Exception){
                Log.say("codx","${e.toString()}")

            }
        }
//            remoteapi.SetPrimaryData(data)
//        }
    }


}


