package com.bc0098.agritivity.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SourceResponse(
//    @SerializedName("source")
//    val source: List<Source>

    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
)

//data class Source(
//    @SerializedName("id")
//    val id: String,
//    @SerializedName("name")
//    val name: String,
//)
