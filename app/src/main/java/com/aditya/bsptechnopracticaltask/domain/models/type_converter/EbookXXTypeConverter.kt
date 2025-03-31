package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.EbookXX
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EbookXXTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromEbookXX(ebookXX: EbookXX?): String {
        return gson.toJson(ebookXX)
    }

    @TypeConverter
    fun toEbookXX(data: String): EbookXX {
        return gson.fromJson(data, EbookXX::class.java)
    }
}
