package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.ProductProperty
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductPropertyTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromProductProperty(productProperty: ProductProperty?): String {
        return gson.toJson(productProperty)
    }

    @TypeConverter
    fun toProductProperty(data: String): ProductProperty {
        return gson.fromJson(data, ProductProperty::class.java)
    }

    @TypeConverter
    fun fromProductPropertyList(productPropertyList: List<ProductProperty>?): String {
        return gson.toJson(productPropertyList)
    }

    @TypeConverter
    fun toProductPropertyList(data: String): List<ProductProperty> {
        val type = object : TypeToken<List<ProductProperty>>() {}.type
        return gson.fromJson(data, type) ?: emptyList()
    }
}
