package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.PillFilter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class PillFilterTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromPillFilter(pillFilter: PillFilter?): String {
        return gson.toJson(pillFilter)
    }

    @TypeConverter
    fun toPillFilter(data: String): PillFilter {
        return gson.fromJson(data, PillFilter::class.java)
    }

    @TypeConverter
    fun fromPillFilterList(pillFilters: List<PillFilter>?): String {
        return gson.toJson(pillFilters)
    }

    @TypeConverter
    fun toPillFilterList(data: String): List<PillFilter> {
        val listType = object : TypeToken<List<PillFilter>>() {}.type
        return gson.fromJson(data, listType)
    }
}
