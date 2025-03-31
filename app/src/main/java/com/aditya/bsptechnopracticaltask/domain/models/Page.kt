package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("elements")
    val elements: List<Element>? = listOf(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("pill_filters")
    val pillFilters: List<PillFilter>? = listOf()
)