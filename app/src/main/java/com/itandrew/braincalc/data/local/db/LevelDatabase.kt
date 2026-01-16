package com.itandrew.braincalc.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.itandrew.braincalc.data.local.model.LevelConverters
import com.itandrew.braincalc.data.local.model.LevelEntity

@Database(
    entities = [
        LevelEntity::class
    ],
    version = 1,
    exportSchema = false
    )
@TypeConverters(LevelConverters::class)
abstract class LevelsDatabase : RoomDatabase() {
    abstract val levelsDao: LevelsDAO
}