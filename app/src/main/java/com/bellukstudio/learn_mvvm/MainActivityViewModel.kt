package com.bellukstudio.learn_mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bellukstudio.learn_mvvm.network.DataGithub
import com.bellukstudio.learn_mvvm.network.RecycleList
import com.bellukstudio.learn_mvvm.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RetroRepository) : ViewModel(){
    private var liveDataList : MutableLiveData<List<DataGithub>> = MutableLiveData()
    fun getLiveDataObserver() : MutableLiveData<List<DataGithub>>{
        return liveDataList
    }
    fun loadListOfData(){
        repository.makeApi(query = "ny",liveDataList)
    }
}