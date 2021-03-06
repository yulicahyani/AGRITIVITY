package com.bc0098.agritivity.ui.panduan

import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

object RequestBodyJson {


    fun createJson(): RequestBody{

        val jsonObject = JSONObject()
        jsonObject.put("image_url", "https://storage.googleapis.com/agritivity.appspot.com/images/photo-predict")

        return jsonObject.toString().toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
    }

}