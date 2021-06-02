package com.bc0098.agritivity.api

import com.bc0098.agritivity.BuildConfig
import com.bc0098.agritivity.data.source.remote.response.PredictResponse
import com.bc0098.agritivity.ui.panduan.RequestBodyJson
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CloudFunctionApiService {

    companion object{
        const val REQUEST_URL = BuildConfig.CLOUD_FUNCTION
    }

    @POST("predict")
    fun getResult(
        @Body requestBody: RequestBody = RequestBodyJson.createJson()
    ): Call<PredictResponse>
}