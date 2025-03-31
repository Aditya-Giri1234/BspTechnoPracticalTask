package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("archived")
    val archived: Boolean? = null,
    @SerializedName("can_buy_now")
    val canBuyNow: Boolean? = null,
    @SerializedName("completed")
    val completed: Boolean? = null,
    @SerializedName("expires_at")
    val expiresAt: String? = null,
    @SerializedName("favorite")
    val favorite: Boolean? = null,
    @SerializedName("in_library")
    val inLibrary: Boolean? = null,
    @SerializedName("last_position")
    val lastPosition: String? = null,
    @SerializedName("purchased")
    val purchased: Boolean? = null,
    @SerializedName("sample")
    val sample: Boolean? = null,
    @SerializedName("subscribable")
    val subscribable: Boolean? = null,
    @SerializedName("subscribed")
    val subscribed: Boolean? = null
)