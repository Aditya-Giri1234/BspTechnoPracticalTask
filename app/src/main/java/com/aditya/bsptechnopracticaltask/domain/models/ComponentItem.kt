package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class ComponentItem(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("image_url")
    val imageUrl: String? = "",
    @SerializedName("media_data")
    val mediaData: MediaData? = MediaData(),
    @SerializedName("sku")
    val sku: String? = "",
    @SerializedName("variant_type")
    val variantType: String? = ""
)