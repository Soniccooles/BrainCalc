package com.itandrew.braincalc.data.remote.model

import com.google.gson.annotations.SerializedName
import com.itandrew.braincalc.data.generals.InputType
import com.itandrew.braincalc.data.generals.Type

data class LevelDTO (
    @SerializedName("id") val id: Int,
    @SerializedName("input_type") val inputType: InputType,
    @SerializedName("type") val type: Type,
    @SerializedName("riddle") val riddle: String,
    @SerializedName("cards") val cards: List<Card>?,
    @SerializedName("hints") val hints: List<Hint>,
    @SerializedName("solution") val solution: List<Replacement>,
    @SerializedName("reward") val reward: Int,
    )

data class Card(
    val key: String,
    @SerializedName("limit") val limit: Int,
)

data class Hint(
    @SerializedName("text") val text: String,
    @SerializedName("cost") val cost: Int,
    @SerializedName("priority") val priority: Int,
)

data class Replacement(
    @SerializedName("gap") val gap: String,
    @SerializedName("value") val value: String,
)



