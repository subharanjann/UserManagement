package com.mobillor.usermanagementmodule.data.models


import com.google.gson.annotations.SerializedName

data class ApkVersionResponseModel(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("statusCode")
    val statusCode: Int
) {
    data class Data(
        @SerializedName("cd")
        val cd: String,
        @SerializedName("environment")
        val environment: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("link")
        val link: String,
        @SerializedName("version")
        val version: String
    )
}