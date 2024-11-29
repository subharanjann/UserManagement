package com.mobillor.usermanagementmodule.data.models


import com.google.gson.annotations.SerializedName

data class AccessModuleResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("statusCode")
    val statusCode: Int
) {
    data class Data(
        @SerializedName("moduleId")
        val moduleId: String,
        @SerializedName("moduleName")
        val moduleName: String
    )
}