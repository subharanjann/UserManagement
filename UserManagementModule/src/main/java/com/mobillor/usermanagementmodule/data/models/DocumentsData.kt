package com.mobillor.usermanagementmodule.data.models


import com.google.gson.annotations.SerializedName

data class DocumentsData(
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
        @SerializedName("cdBy")
        val cdBy: String,
        @SerializedName("documentCode")
        val documentCode: String,
        @SerializedName("documentId")
        val documentId: Int?,
        @SerializedName("documentName")
        val documentName: String?,
        @SerializedName("ud")
        val ud: String,
        @SerializedName("udBy")
        val udBy: String
    )
}