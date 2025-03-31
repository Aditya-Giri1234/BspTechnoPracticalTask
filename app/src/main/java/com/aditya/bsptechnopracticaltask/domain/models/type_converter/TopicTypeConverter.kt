package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.Topic
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TopicTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromTopic(topic: Topic?): String {
        return gson.toJson(topic)
    }

    @TypeConverter
    fun toTopic(data: String): Topic {
        return gson.fromJson(data, Topic::class.java)
    }

    @TypeConverter
    fun fromTopicList(topics: List<Topic>?): String {
        return gson.toJson(topics)
    }

    @TypeConverter
    fun toTopicList(data: String): List<Topic> {
        val type = object : TypeToken<List<Topic>>() {}.type
        return gson.fromJson(data, type)
    }
}
