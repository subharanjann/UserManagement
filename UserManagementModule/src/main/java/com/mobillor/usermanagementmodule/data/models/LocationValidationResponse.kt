package com.mobillor.usermanagementmodule.data.models


import com.google.gson.annotations.SerializedName

data class LocationValidationResponse(
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
        @SerializedName("locationCode")
        val locationCode: String,
        @SerializedName("locationId")
        val locationId: Int
    )
}