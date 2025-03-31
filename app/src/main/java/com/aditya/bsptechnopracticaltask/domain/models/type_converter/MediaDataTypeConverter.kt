package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.MediaData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MediaDataTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromMediaData(mediaData: MediaData?): String {
        return gson.toJson(mediaData)
    }

    @TypeConverter
    fun toMediaData(data: String): MediaData {
        val type = object : TypeToken<MediaData>() {}.type
        return gson.fromJson(data, type)
    }
}
