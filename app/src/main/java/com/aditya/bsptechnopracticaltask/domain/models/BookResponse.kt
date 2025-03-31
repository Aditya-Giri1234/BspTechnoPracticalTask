package com.aditya.bsptechnopracticaltask.domain.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class BookResponse(
    @PrimaryKey(autoGenerate = true)
    val bookResponseId : Int =0,
    @SerializedName("api_log_id")
    val apiLogId: Int? = 0,
    @SerializedName("generated")
    val generated: String? = "",
    @SerializedName("page")
    val page: Page? = Page(),
    @SerializedName("request_uuid")
    val requestUuid: String? = "",
    @SerializedName("success")
    val success: Boolean? = false
)