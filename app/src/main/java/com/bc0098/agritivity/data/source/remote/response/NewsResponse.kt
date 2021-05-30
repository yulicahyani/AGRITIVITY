package com.bc0098.agritivity.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles")
    val berita: List<Berita>
)

data class Berita(
    @SerializedName("author")
    val author: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("publishedAt")
    val waktu: String,

    @SerializedName("source")
    val sumber: SourceResponse,

    @SerializedName("urlToImage")
    val image: String,

    @SerializedName("content")
    val content: String
)
