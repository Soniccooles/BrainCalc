package com.itandrew.braincalc.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.itandrew.braincalc.data.generals.InputType
import com.itandrew.braincalc.data.generals.Type
import com.itandrew.braincalc.data.local.model.LevelEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class LevelEntity (
    @PrimaryKey
    val id: Int,
    val isCompleted: Boolean,
    val inputType: InputType,
    val type: Type,
    val riddle: String,
    val cards: List<Card>?,
    val hints: List<Hint>,
    val solution: List<Replacement>,
    val reward: Int,
    ) {

    companion object {
        const val TABLE_NAME = "levels"
    }
}

data class Card(
    val key: String,
    val limit: Int,
)

data class Hint(
    val text: String,
    val cost: Int,
    val priority: Int,
)

data class Replacement(
   val gap: String,
   val value: String,
)