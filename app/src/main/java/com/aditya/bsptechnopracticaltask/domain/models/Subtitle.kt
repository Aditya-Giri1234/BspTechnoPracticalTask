package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class Subtitle(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("value")
    val value: String? = null
)