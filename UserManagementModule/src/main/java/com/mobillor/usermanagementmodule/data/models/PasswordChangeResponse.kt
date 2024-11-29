package com.mobillor.usermanagementmodule.data.models


import com.google.gson.annotations.SerializedName

data class PasswordChangeResponse(
    @SerializedName("data")
    val `data`: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("statusCode")
    val statusCode: Int
)