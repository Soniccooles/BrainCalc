package com.itandrew.braincalc.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.itandrew.braincalc.data.local.model.LevelEntity

@Database(
    entities = [
        LevelEntity::class
    ],
    version = 1
    )
abstract class LevelsDatabase : RoomDatabase() {
    abstract val levelsDao: LevelsDAO
}