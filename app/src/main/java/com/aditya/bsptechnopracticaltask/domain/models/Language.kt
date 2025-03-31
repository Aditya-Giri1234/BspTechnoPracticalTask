package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class Language(
    @SerializedName("iso")
    val iso: String? = null,
    @SerializedName("name")
    val name: String? = null
)