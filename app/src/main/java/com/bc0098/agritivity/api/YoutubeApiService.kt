package com.bc0098.agritivity.api

import com.bc0098.agritivity.data.source.remote.response.NewsResponse
import com.bc0098.agritivity.data.source.remote.response.YoutubeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApiService {

    companion object{
        const val BASE_URL = "https://www.googleapis.com/youtube/v3/"
        const val API_KEY = "AIzaSyDRbZidoeUUIMQyqNddNCT0cSyLKYExGl4"
    }

    @GET("search")
    fun geVideoResult(
        @Query("part") part: String = "snippet",
        @Query("maxResults") maxResults: Int = 30,
        @Query("q") q: String,
        @Query("type") type: String = "video",
        @Query("key") key: String = API_KEY
    ): Call<YoutubeResponse>
}
