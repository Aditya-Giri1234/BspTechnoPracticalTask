package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.ComponentItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ComponentItemTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromComponentItem(componentItem: ComponentItem?): String {
        return gson.toJson(componentItem)
    }

    @TypeConverter
    fun toComponentItem(data: String): ComponentItem {
        return gson.fromJson(data, ComponentItem::class.java)
    }

    @TypeConverter
    fun fromComponentItemList(componentItems: List<ComponentItem>?): String {
        return gson.toJson(componentItems)
    }

    @TypeConverter
    fun toComponentItemList(data: String): List<ComponentItem> {
        val type = object : TypeToken<List<ComponentItem>>() {}.type
        return gson.fromJson(data, type)
    }
}

