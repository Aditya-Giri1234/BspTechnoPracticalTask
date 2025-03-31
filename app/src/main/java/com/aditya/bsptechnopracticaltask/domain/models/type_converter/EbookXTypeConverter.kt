package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.EbookX
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EbookXTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromEbookX(ebookX: EbookX?): String {
        return gson.toJson(ebookX)
    }

    @TypeConverter
    fun toEbookX(data: String): EbookX {
        val type = object : TypeToken<EbookX>() {}.type
        return gson.fromJson(data, type)
    }
}
