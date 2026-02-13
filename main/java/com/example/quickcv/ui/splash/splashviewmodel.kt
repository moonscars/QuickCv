package com.example.quickcv.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class splashviewmodel: ViewModel() {
    val _isVisible = MutableStateFlow(false)
    var isVisible = _isVisible.asStateFlow()

    init {
        viewModelScope.launch {
            delay(4000)
            switch_isVisible()
        }
    }

   private fun switch_isVisible(){
        _isVisible.value = !_isVisible.value
    }

}