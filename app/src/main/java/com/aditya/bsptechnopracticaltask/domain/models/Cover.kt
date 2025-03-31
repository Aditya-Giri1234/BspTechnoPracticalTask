package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class Cover(
    @SerializedName("detail_url")
    val detailUrl: String? = null,
    @SerializedName("full_url")
    val fullUrl: String? = null,
    @SerializedName("listing_url")
    val listingUrl: String? = null,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String? = null
)