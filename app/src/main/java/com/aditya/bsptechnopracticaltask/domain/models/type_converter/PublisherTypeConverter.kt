package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.Publisher
import com.google.gson.Gson

class PublisherTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromPublisher(publisher: Publisher?): String {
        return gson.toJson(publisher)
    }

    @TypeConverter
    fun toPublisher(data: String): Publisher {
        return gson.fromJson(data, Publisher::class.java)
    }
}
