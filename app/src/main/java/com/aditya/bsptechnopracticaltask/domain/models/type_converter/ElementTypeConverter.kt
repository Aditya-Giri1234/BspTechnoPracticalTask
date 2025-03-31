package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.Element
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ElementTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromElement(element: Element?): String {
        return gson.toJson(element)
    }

    @TypeConverter
    fun toElement(data: String): Element {
        return gson.fromJson(data, Element::class.java)
    }

    @TypeConverter
    fun fromElementList(elements: List<Element>?): String {
        return gson.toJson(elements)
    }

    @TypeConverter
    fun toElementList(data: String): List<Element> {
        val type = object : TypeToken<List<Element>>() {}.type
        return gson.fromJson(data, type)
    }
}
