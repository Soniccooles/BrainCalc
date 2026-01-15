package com.itandrew.braincalc.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.itandrew.braincalc.data.local.model.LevelEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LevelsDAO {

    @Upsert
    suspend fun upsertLevel(level: LevelEntity)

    @Delete
    suspend fun deleteLevel(level: LevelEntity)

    @Query("SELECT * FROM ${LevelEntity.TABLE_NAME} ORDER BY id ASC")
    fun getAllLevels(): Flow<List<LevelEntity>>
}