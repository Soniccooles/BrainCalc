package com.itandrew.braincalc.data.remote

import com.itandrew.braincalc.data.remote.model.LevelsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/levels")
    fun getAllLevels() : Response<List<LevelsDTO>?>

    @GET("/level/{id}")
    fun getLevel(@Path("id") id : Int ) : Response<LevelsDTO?>

}