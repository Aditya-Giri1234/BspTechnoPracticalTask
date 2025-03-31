package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.Cover
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CoverTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromCover(cover: Cover?): String {
        return gson.toJson(cover)
    }

    @TypeConverter
    fun toCover(data: String): Cover {
        val type = object : TypeToken<Cover>() {}.type
        return gson.fromJson(data, type)
    }
}
