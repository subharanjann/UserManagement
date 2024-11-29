package com.mobillor.usermanagementmodule.data.models


import com.google.gson.annotations.SerializedName

data class ItemIdFilterData(
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
        @SerializedName("itemCode")
        val itemCode: String,
        @SerializedName("itemDescription")
        val itemDescription: String?,
        @SerializedName("itemId")
        val itemId: Int,
        @SerializedName("itemTypeId")
        val itemTypeId: Int?,
        @SerializedName("movementType")
        val movementType: String?,
        @SerializedName("uom")
        val uom: String?
    )
}