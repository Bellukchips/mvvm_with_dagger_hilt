package com.bellukstudio.learn_mvvm.network

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retrofitServices: RetrofitServices) {
    fun makeApi(query : String,  liveDataList : MutableLiveData<List<DataGithub>>){
       val call : Call<RecycleList> =  retrofitServices.getData(query)
        call.enqueue(object : Callback<RecycleList>{
            override fun onResponse(call: Call<RecycleList>, response: Response<RecycleList>) {
                liveDataList.postValue(response.body()?.items!!)
            }

            override fun onFailure(call: Call<RecycleList>, t: Throwable) {
                liveDataList.postValue(null)

            }

        })
    }
}