package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.Audiobook
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AudiobookTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromAudiobook(audiobook: Audiobook?): String {
        return gson.toJson(audiobook)
    }

    @TypeConverter
    fun toAudiobook(data: String): Audiobook {
        val type = object : TypeToken<Audiobook>() {}.type
        return gson.fromJson(data, type)
    }
}
