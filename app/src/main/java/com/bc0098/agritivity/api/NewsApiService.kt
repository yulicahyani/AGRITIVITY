package com.bc0098.agritivity.api

import com.bc0098.agritivity.data.source.remote.response.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    companion object{
        const val BASE_URL = "https://newsapi.org/"
        const val API_KEY = "df0c20ad63ee44afa5d8aafefbc0fa76"
    }

    @GET("v2/everything")
    fun getBerita(
        @Query("q") q: String = "pertanian",
        @Query("apiKey") apiKey: String = API_KEY
    ): Call<NewsResponse>
}