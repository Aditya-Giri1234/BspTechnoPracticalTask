package com.aditya.bsptechnopracticaltask.domain.models.type_converter

import androidx.room.TypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.UserInfo
import com.google.gson.Gson

class UserInfoTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromUserInfo(userInfo: UserInfo?): String {
        return gson.toJson(userInfo)
    }

    @TypeConverter
    fun toUserInfo(data: String): UserInfo {
        return gson.fromJson(data, UserInfo::class.java)
    }
}
