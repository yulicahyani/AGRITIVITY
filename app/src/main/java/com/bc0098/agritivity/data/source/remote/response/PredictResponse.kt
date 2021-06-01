package com.bc0098.agritivity.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class PredictResponse(
    @SerializedName("prediction")
    val prediction: String
)
