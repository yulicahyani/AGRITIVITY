package com.bc0098.agritivity.api

import com.bc0098.agritivity.data.source.remote.response.PredictResponse
import com.bc0098.agritivity.ui.panduan.RequestBodyJson
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CloudFunctionApiService {

    companion object{
        const val REQUEST_URL = "https://us-central1-agritivity.cloudfunctions.net/"
    }

    @POST("predict")
    fun getResult(
        @Body requestBody: RequestBody = RequestBodyJson.createJson()
    ): Call<PredictResponse>
}