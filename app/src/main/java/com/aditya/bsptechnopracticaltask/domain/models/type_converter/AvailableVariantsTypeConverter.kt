package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.AvailableVariants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AvailableVariantsTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromAvailableVariants(availableVariants: AvailableVariants?): String {
        return gson.toJson(availableVariants)
    }

    @TypeConverter
    fun toAvailableVariants(data: String): AvailableVariants {
        val type = object : TypeToken<AvailableVariants>() {}.type
        return gson.fromJson(data, type)
    }
}
