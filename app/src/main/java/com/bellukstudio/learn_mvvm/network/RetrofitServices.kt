package com.bellukstudio.learn_mvvm.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {
    @GET("repositories")
    fun getData(@Query("q") query : String) : Call<RecycleList>
}