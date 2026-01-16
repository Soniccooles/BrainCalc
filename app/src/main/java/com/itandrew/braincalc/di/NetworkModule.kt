package com.itandrew.braincalc.di

import com.itandrew.braincalc.data.remote.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
object NetworkModule {

    @Provides
    fun provideApiService() : ApiService =
        Retrofit.Builder()
            .baseUrl("http://193.23.219.232:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
}