package com.aditya.bsptechnopracticaltask.domain.models


import com.google.gson.annotations.SerializedName

data class MediaDataX(
    @SerializedName("authors")
    val authors: List<Author>? = listOf(),
    @SerializedName("book_id")
    val bookId: Int? = 0,
    @SerializedName("categories")
    val categories: List<Category>? = listOf(),
    @SerializedName("cover")
    val cover: Cover? = Cover(),
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("ebook")
    val ebook: EbookXX? = EbookXX(),
    @SerializedName("genres")
    val genres: List<Any?>? = listOf(),
    @SerializedName("languages")
    val languages: List<Language>? = listOf(),
    @SerializedName("media_id")
    val mediaId: Int? = 0,
    @SerializedName("product_properties")
    val productProperties: List<ProductProperty>? = listOf(),
    @SerializedName("publisher")
    val publisher: Publisher? = Publisher(),
    @SerializedName("subtitles")
    val subtitles: List<Subtitle>? = listOf(),
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("topics")
    val topics: List<Any?>? = listOf()
)