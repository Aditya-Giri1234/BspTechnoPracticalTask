package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.Property
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PropertyTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromProperty(property: Property?): String {
        return gson.toJson(property)
    }

    @TypeConverter
    fun toProperty(data: String): Property {
        val type = object : TypeToken<Property>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun fromPropertyList(properties: List<Property>?): String {
        return gson.toJson(properties)
    }

    @TypeConverter
    fun toPropertyList(data: String): List<Property> {
        val type = object : TypeToken<List<Property>>() {}.type
        return gson.fromJson(data, type)
    }
}
