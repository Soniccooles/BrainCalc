package com.itandrew.braincalc.data.remote

import com.itandrew.braincalc.data.remote.model.LevelDTO
import com.itandrew.braincalc.data.remote.ApiUtils.Companion.safeApiCall
import javax.inject.Inject

interface ApiRepository{

    suspend fun getAllLevels(): Result<List<LevelDTO>?>
    suspend fun getLevel(id: Int): Result<LevelDTO?>
}

class ApiRepositoryImpl @Inject constructor(
    val service: ApiService
) : ApiRepository {

    override suspend fun getAllLevels(): Result<List<LevelDTO>?> {
        return safeApiCall{
            service.getAllLevels()
        }
    }

    override suspend fun getLevel(id: Int): Result<LevelDTO?> {
        return safeApiCall{
            service.getLevel(id)
        }
    }
}