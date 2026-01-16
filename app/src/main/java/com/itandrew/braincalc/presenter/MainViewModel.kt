package com.itandrew.braincalc.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itandrew.braincalc.data.local.model.LevelEntity
import com.itandrew.braincalc.domain.DownloadLevelsUseCase
import com.itandrew.braincalc.domain.GetAllLevelIdsUseCase
import com.itandrew.braincalc.domain.GetLevelByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val downloadLevelsUseCase: DownloadLevelsUseCase,
    private val getAllLevelIdsUseCase: GetAllLevelIdsUseCase,
    private val getLevelByIdUseCase: GetLevelByIdUseCase,
) : ViewModel() {
    private val _allLevelIdsLiveData = MutableLiveData<List<Int>>()
    val allLevelIdsLiveData: LiveData<List<Int>>
        get() = _allLevelIdsLiveData

    fun loadAllLevelIds(){
        viewModelScope.launch(Dispatchers.IO) {
            _allLevelIdsLiveData.postValue(getAllLevelIdsUseCase())
        }
    }

    private val _levelLiveData = MutableLiveData<LevelEntity?>()
    val levelLiveData: LiveData<LevelEntity?>
        get() = _levelLiveData
    fun loadLevel(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            _levelLiveData.postValue(getLevelByIdUseCase(id))
        }
    }
    fun downloadLevels(){
        viewModelScope.launch(Dispatchers.IO) {
            downloadLevelsUseCase()
        }
    }
}