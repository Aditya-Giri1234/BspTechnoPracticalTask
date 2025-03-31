package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class Element(
    @SerializedName("component_items")
    val componentItems: List<ComponentItem>? = listOf(),
    @SerializedName("element_type")
    val elementType: String? = "",
    @SerializedName("header")
    val header: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("media_data")
    val mediaData: MediaDataX? = MediaDataX(),
    @SerializedName("mobile_image_url")
    val mobileImageUrl: String? = "",
    @SerializedName("sku")
    val sku: String? = "",
    @SerializedName("style")
    val style: String? = "",
    @SerializedName("subheader")
    val subheader: String? = "",
    @SerializedName("tablet_image_url")
    val tabletImageUrl: String? = "",
    @SerializedName("variant_types")
    val variantTypes: List<String>? = listOf()
)