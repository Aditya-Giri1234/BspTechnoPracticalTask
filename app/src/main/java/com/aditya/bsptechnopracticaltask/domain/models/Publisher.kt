package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class Publisher(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)