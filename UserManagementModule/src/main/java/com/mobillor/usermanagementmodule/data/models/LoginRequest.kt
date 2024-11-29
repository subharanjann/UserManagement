package com.mobillor.usermanagementmodule.data.models


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("device_type")
    val deviceType: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("isMobile")
    val isMobile: Boolean,
    @SerializedName("password")
    val password: String,
    @SerializedName("uuid")
    val uuid_value: String
)