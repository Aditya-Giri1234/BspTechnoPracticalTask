package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class Audiobook(
    @SerializedName("sku")
    val sku: String? = null,
    @SerializedName("url")
    val url: String? = null
)