package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromCategory(category: Category?): String {
        return gson.toJson(category)
    }

    @TypeConverter
    fun toCategory(data: String): Category {
        return gson.fromJson(data, Category::class.java)
    }

    @TypeConverter
    fun fromCategoryList(categories: List<Category>?): String {
        return gson.toJson(categories)
    }

    @TypeConverter
    fun toCategoryList(data: String): List<Category> {
        val type = object : TypeToken<List<Category>>() {}.type
        return gson.fromJson(data, type)
    }
}

