package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class AvailableVariants(
    @SerializedName("audiobook")
    val audiobook: Audiobook? = null,
    @SerializedName("ebook")
    val ebook: Ebook? = null
)