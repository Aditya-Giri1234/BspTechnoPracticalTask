package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class EbookX(
    @SerializedName("book_id")
    val bookId: Int? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("media_id")
    val mediaId: Int? = null,
    @SerializedName("pretty_price")
    val prettyPrice: String? = null,
    @SerializedName("price")
    val price: Double? = null,
    @SerializedName("properties")
    val properties: List<Property?>? = null,
    @SerializedName("release_date")
    val releaseDate: Any? = null,
    @SerializedName("sample_available")
    val sampleAvailable: Boolean? = null,
    @SerializedName("scriptures")
    val scriptures: Boolean? = null,
    @SerializedName("sku")
    val sku: String? = null,
    @SerializedName("subscription_plan_ids")
    val subscriptionPlanIds: List<String?>? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    @SerializedName("user_info")
    val userInfo: UserInfo? = null,
    @SerializedName("version")
    val version: Int? = null,
    @SerializedName("view_mode")
    val viewMode: String? = null
)