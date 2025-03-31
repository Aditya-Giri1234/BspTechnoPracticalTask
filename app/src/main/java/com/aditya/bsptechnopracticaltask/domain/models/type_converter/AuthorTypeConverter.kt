package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.Author
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AuthorTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromAuthor(author: Author?): String {
        return gson.toJson(author)
    }

    @TypeConverter
    fun toAuthor(data: String): Author {
        return gson.fromJson(data, Author::class.java)
    }

    @TypeConverter
    fun fromAuthorList(authors: List<Author>?): String {
        return gson.toJson(authors)
    }

    @TypeConverter
    fun toAuthorList(data: String): List<Author> {
        val type = object : TypeToken<List<Author>>() {}.type
        return gson.fromJson(data, type)
    }
}

