package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.Ebook
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EbookTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromEbook(ebook: Ebook?): String {
        return gson.toJson(ebook)
    }

    @TypeConverter
    fun toEbook(data: String): Ebook {
        val type = object : TypeToken<Ebook>() {}.type
        return gson.fromJson(data, type)
    }
}
