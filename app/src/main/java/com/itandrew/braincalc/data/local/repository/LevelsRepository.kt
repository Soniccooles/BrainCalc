package com.itandrew.braincalc.data.local.repository

import com.itandrew.braincalc.data.local.db.LevelsDAO
import com.itandrew.braincalc.data.local.model.LevelEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LevelsRepository {
    val levelsFlow: Flow<List<LevelEntity>>
    suspend fun createNewLevel(level: LevelEntity)
    suspend fun getAllIds(): List<Int>

    suspend fun insertLevels(levels: List<LevelEntity>)
}

class LevelsRepositoryImpl @Inject constructor(
    private val dao: LevelsDAO
) : LevelsRepository {

    override val levelsFlow: Flow<List<LevelEntity>>
        get() = dao.getAllLevels()

    override suspend fun createNewLevel(level: LevelEntity) {
        dao.upsertLevel(level)
    }

    override suspend fun getAllIds(): List<Int> {
        return dao.getAllIds()
    }

    override suspend fun insertLevels(levels: List<LevelEntity>) {
        dao.insertAll(levels)
    }
}