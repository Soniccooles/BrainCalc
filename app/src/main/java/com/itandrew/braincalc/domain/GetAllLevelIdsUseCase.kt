package com.itandrew.braincalc.domain

import com.itandrew.braincalc.data.local.repository.LevelsRepository
import javax.inject.Inject

interface GetAllLevelIdsUseCase {
    suspend operator fun invoke(): List<Int>
}

class  GetAllLevelIdsUseCaseImpl @Inject constructor(
    val repository: LevelsRepository,
    ) : GetAllLevelIdsUseCase {
    override suspend fun invoke(): List<Int> {
        return repository.getAllIds()
    }
}