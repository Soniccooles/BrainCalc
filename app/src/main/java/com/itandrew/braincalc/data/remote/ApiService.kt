package com.itandrew.braincalc.data.remote

import com.itandrew.braincalc.data.remote.model.LevelDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("levels")
    suspend fun getAllLevels() : Response<List<LevelDTO>?>

    @GET("level/{id}")
    suspend fun getLevel(@Path("id") id : Int ) : Response<LevelDTO?>

}