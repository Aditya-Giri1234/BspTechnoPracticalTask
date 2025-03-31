package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class EbookXX(
    @SerializedName("book_id")
    val bookId: Int? = 0,
    @SerializedName("created_at")
    val createdAt: String? = "",
    @SerializedName("media_id")
    val mediaId: Int? = 0,
    @SerializedName("pretty_price")
    val prettyPrice: String? = "",
    @SerializedName("price")
    val price: Double? = 0.0,
    @SerializedName("properties")
    val properties: List<Any?>? = listOf(),
    @SerializedName("release_date")
    val releaseDate: Any? = Any(),
    @SerializedName("sample_available")
    val sampleAvailable: Boolean? = false,
    @SerializedName("scriptures")
    val scriptures: Boolean? = false,
    @SerializedName("sku")
    val sku: String? = "",
    @SerializedName("subscription_plan_ids")
    val subscriptionPlanIds: List<String>? = listOf(),
    @SerializedName("updated_at")
    val updatedAt: String? = "",
    @SerializedName("user_info")
    val userInfo: UserInfo? = UserInfo(),
    @SerializedName("version")
    val version: Int? = 0,
    @SerializedName("view_mode")
    val viewMode: String? = ""
)