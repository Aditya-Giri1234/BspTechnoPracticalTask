package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class ProductProperty(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("property_id")
    val propertyId: Int? = null,
    @SerializedName("property_name")
    val propertyName: String? = null,
    @SerializedName("value")
    val value: String? = null
)