package com.mobillor.usermanagementmodule.data.models


import com.google.gson.annotations.SerializedName

data class WareHouseLocationCodes(
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
        @SerializedName("isActive")
        val isActive: Int,
        @SerializedName("plantId")
        val plantId: Int?,
        @SerializedName("warehouseCode")
        val warehouseCode: String,
        @SerializedName("warehouseId")
        val warehouseId: Int?,
        @SerializedName("warehouseName")
        val warehouseName: String?
    )
}