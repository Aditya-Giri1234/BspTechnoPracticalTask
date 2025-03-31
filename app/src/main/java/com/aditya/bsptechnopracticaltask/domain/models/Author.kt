package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("first_name")
    val firstName: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("last_name")
    val lastName: String? = null
)