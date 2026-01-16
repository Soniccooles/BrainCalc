package com.itandrew.braincalc.data.local.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LevelConverters {
    private val gson = Gson()

    @TypeConverter
    fun fromCardList(value: List<Card>?): String?{
        return gson.toJson(value)
    }
    @TypeConverter
    fun toCardList(value: String?): List<Card>?{
        value ?: return null
        val type = object : TypeToken<List<Card>>(){}.type
        return gson.fromJson(value, type)
    }


    @TypeConverter
    fun fromHintList(value: List<Hint>): String {
        return gson.toJson(value)
    }
    @TypeConverter
    fun toHintList(value: String): List<Hint> {
        val type = object : TypeToken<List<Hint>>() {}.type
        return gson.fromJson(value, type)
    }


    @TypeConverter
    fun fromSolutionList(value: List<Replacement>): String {
        return gson.toJson(value)
    }
    @TypeConverter
    fun toSolutionList(value: String): List<Replacement> {
        val type = object : TypeToken<List<Replacement>>() {}.type
        return gson.fromJson(value, type)
    }

}