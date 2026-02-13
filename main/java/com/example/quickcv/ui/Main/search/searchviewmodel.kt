package com.example.quickcv.ui.Main.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickcv.data.SearchRequest
import com.example.quickcv.data.ktor.GetResumeData
import com.example.quickcv.ui.reusables.Logger.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class searchviewmodel(): ViewModel() {
    private val _serach = MutableStateFlow("")
    var search = _serach.asStateFlow()

    fun set_search(value:String){

        _serach.value = value

    }

    fun onSearch(){
        viewModelScope.launch {
            try{

            val response = GetResumeData(SearchRequest(_serach.value.uppercase()))
            }catch (e: Exception){
                Log.say("bbbb",e.toString())
            }

        }
    }

}