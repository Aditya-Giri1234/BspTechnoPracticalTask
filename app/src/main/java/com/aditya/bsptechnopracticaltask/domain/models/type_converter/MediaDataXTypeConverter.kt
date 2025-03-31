package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.MediaDataX
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MediaDataXTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromMediaDataX(mediaDataX: MediaDataX?): String {
        return gson.toJson(mediaDataX)
    }

    @TypeConverter
    fun toMediaDataX(data: String): MediaDataX {
        return gson.fromJson(data, MediaDataX::class.java)
    }
}
