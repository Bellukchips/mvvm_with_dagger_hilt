package com.bellukstudio.learn_mvvm.di

import com.bellukstudio.learn_mvvm.network.RetrofitServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val baseURL = "https://api.github.com/search/"

    @Singleton
    @Provides
    fun getRetrofitInterface(retrofit: Retrofit) : RetrofitServices{
        return  retrofit.create(RetrofitServices::class.java)
    }
    @Singleton
    @Provides
    fun getRetrofitInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}