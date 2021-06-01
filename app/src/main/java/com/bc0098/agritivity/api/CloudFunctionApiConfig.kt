package com.bc0098.agritivity.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CloudFunctionApiConfig {

    companion object{
        fun getApiService(): CloudFunctionApiService{

            val retrofit = Retrofit.Builder()
                .baseUrl(CloudFunctionApiService.REQUEST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(CloudFunctionApiService::class.java)
        }
    }
}