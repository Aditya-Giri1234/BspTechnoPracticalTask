package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.Language
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LanguageTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromLanguage(language: Language?): String {
        return gson.toJson(language)
    }

    @TypeConverter
    fun toLanguage(data: String): Language {
        return gson.fromJson(data, Language::class.java)
    }

    @TypeConverter
    fun fromLanguageList(languageList: List<Language>?): String {
        return gson.toJson(languageList)
    }

    @TypeConverter
    fun toLanguageList(data: String): List<Language> {
        val type = object : TypeToken<List<Language>>() {}.type
        return gson.fromJson(data, type) ?: emptyList()
    }
}
