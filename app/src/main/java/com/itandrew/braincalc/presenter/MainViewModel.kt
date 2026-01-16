package com.itandrew.braincalc.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itandrew.braincalc.data.remote.ApiRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: ApiRepository
) : ViewModel() {
    fun test(){
        viewModelScope.launch {
            val levels = repository.getAllLevels()
        }
    }
}