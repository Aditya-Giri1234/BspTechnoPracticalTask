package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.Page
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PageTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromPage(page: Page?): String {
        return gson.toJson(page)
    }

    @TypeConverter
    fun toPage(data: String): Page {
        val type = object : TypeToken<Page>() {}.type
        return gson.fromJson(data, type)
    }
}