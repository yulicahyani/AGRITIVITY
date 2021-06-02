package com.bc0098.agritivity.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class YoutubeResponse(
    @SerializedName("items")
    val video: List<VideoYoutube>
)

data class VideoYoutube(
    @SerializedName("id")
    val id: Id,

    @SerializedName("snippet")
    val snippet: Snippet
)

data class Snippet(
    @SerializedName("publishedAt")
    val publishedAt: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("thumbnails")
    val thumbnails: ThumbnailsVideo,

    @SerializedName("channelTitle")
    val channelTitle: String
)

data class ThumbnailsVideo(
    @SerializedName("default")
    val default: ThumbnailsDes,

    @SerializedName("medium")
    val medium: ThumbnailsDes,

    @SerializedName("high")
    val high: ThumbnailsDes
)

data class ThumbnailsDes(
    @SerializedName("url")
    val url: String,

    @SerializedName("width")
    val width: Int,

    @SerializedName("height")
    val height: Int
)

data class Id(
    @SerializedName("kind")
    val kind: String,

    @SerializedName("videoId")
    val videoId: String
)
