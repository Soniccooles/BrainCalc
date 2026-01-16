package com.itandrew.braincalc.data.remote.model

import androidx.room.Entity
import com.itandrew.braincalc.data.local.model.LevelEntity
import com.itandrew.braincalc.data.remote.model.Card as DtoCard
import com.itandrew.braincalc.data.remote.model.Hint as DtoHint
import com.itandrew.braincalc.data.remote.model.Replacement as DtoReplacement
import com.itandrew.braincalc.data.local.model.Card as EntityCard
import com.itandrew.braincalc.data.local.model.Hint as EntityHint
import com.itandrew.braincalc.data.local.model.Replacement as EntityReplacement

fun LevelDTO.toEntity(): LevelEntity{
    return LevelEntity(
        id = this.id,
        isCompleted = false,
        inputType = this.inputType,
        type = this.type,
        riddle = this.riddle,
        cards = this.cards?.map { it.toEntity()},
        hints = this.hints.map { it.toEntity()},
        solution = this.solution.map { it.toEntity()},
        reward = this.reward,
    )
}

fun DtoCard.toEntity() = EntityCard(
    key = this.key,
    limit = this.limit,
)

fun DtoHint.toEntity() = EntityHint(
    text = this.text,
    cost = this.cost,
    priority = this.priority,
)

fun DtoReplacement.toEntity() = EntityReplacement(
    gap = this.gap,
    value = this.value
)