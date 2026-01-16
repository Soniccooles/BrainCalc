package com.itandrew.braincalc.domain

import com.itandrew.braincalc.data.local.model.LevelEntity
import com.itandrew.braincalc.data.local.repository.LevelsRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

interface GetLevelByIdUseCase {
    suspend operator fun invoke(id: Int): LevelEntity?
}

class GetLevelByIdUseCaseImpl @Inject constructor(
    val repository: LevelsRepository
) : GetLevelByIdUseCase {
    override suspend fun invoke(id: Int): LevelEntity? {
        val test = repository.levelsFlow.first()
        test.size

        val level = repository.levelsFlow.first().firstOrNull {
            it.id == id
        }
        return level
    }

}
