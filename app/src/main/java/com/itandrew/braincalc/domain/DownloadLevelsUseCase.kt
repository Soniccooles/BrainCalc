package com.itandrew.braincalc.domain

import com.itandrew.braincalc.data.local.repository.LevelsRepository
import com.itandrew.braincalc.data.remote.ApiRepository
import com.itandrew.braincalc.data.remote.model.toEntity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

interface DownloadLevelsUseCase {
    suspend operator fun invoke()
}

class DownloadLevelsUseCaseImpl @Inject constructor(
    val apiRepository: ApiRepository,
    val levelsRepository: LevelsRepository,
) : DownloadLevelsUseCase{
    override suspend fun invoke() {

        val response = apiRepository.getAllLevels()
        if (!response.isSuccess)
            return

        val result = response.getOrNull()
        result ?: return
        val existingIds = levelsRepository.getAllIds()
        val newLevels = result.filter { level ->
            !existingIds.contains(level.id)
            }
            .map {
                dto ->
                dto.toEntity()
            }
        levelsRepository.insertLevels(newLevels)
    }

}