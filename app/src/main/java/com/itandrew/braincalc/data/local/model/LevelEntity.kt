package com.itandrew.braincalc.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.itandrew.braincalc.data.generals.InputType
import com.itandrew.braincalc.data.local.model.LevelEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class LevelEntity (
    @PrimaryKey
    val id: Int,
    val inputType: InputType,

    ) {

    companion object {
        const val TABLE_NAME = "levels"
    }
}