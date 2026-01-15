package com.itandrew.braincalc.data.remote

import com.itandrew.braincalc.data.remote.model.LevelsDTO
import com.itandrew.braincalc.data.remote.ApiUtils.Companion.safeApiCall
import javax.inject.Inject

interface LevelRepository{

    suspend fun getAllLevels(): Result<List<LevelsDTO>?>
    suspend fun getLevel(id: Int): Result<LevelsDTO?>
}

class LevelRepositoryImpl @Inject constructor(
    val service: ApiService
) : LevelRepository {

    override suspend fun getAllLevels(): Result<List<LevelsDTO>?> {
        return safeApiCall{
            service.getAllLevels()
        }
    }

    override suspend fun getLevel(id: Int): Result<LevelsDTO?> {
        return safeApiCall{
            service.getLevel(id)
        }
    }
}