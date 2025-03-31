package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.Subtitle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SubtitleTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromSubtitle(subtitle: Subtitle?): String {
        return gson.toJson(subtitle)
    }

    @TypeConverter
    fun toSubtitle(data: String): Subtitle {
        return gson.fromJson(data, Subtitle::class.java)
    }

    @TypeConverter
    fun fromSubtitleList(subtitles: List<Subtitle>?): String {
        return gson.toJson(subtitles)
    }

    @TypeConverter
    fun toSubtitleList(data: String): List<Subtitle> {
        val type = object : TypeToken<List<Subtitle>>() {}.type
        return gson.fromJson(data, type)
    }
}
