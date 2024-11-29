package com.mobillor.usermanagementmodule.data.models


import com.google.gson.annotations.SerializedName

data class GroupedForMobileResponse(
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
        @SerializedName("destination")
        val destination: String?,
        @SerializedName("documentCode")
        val documentCode: String,
        @SerializedName("documentNumber")
        val documentNumber: String,
        @SerializedName("items")
        val items: List<Item>,
        @SerializedName("mvtId")
        val mvtId: Int,
        @SerializedName("picklistCode")
        val picklistCode: String,
        @SerializedName("picklistId")
        val picklistId: Int,
        @SerializedName("source")
        val source: String?,
        var isSelected: Boolean = false
    ) {
        data class Item(
            @SerializedName("itemCode")
            val itemCode: String?,
            @SerializedName("itemDescription")
            val itemDescription: String?,
            @SerializedName("itemId")
            val itemId: Int,
            @SerializedName("qty")
            val qty: Double?,
            @SerializedName("kittingQty")
            var kittingQty: Double?,
            @SerializedName("totalSuidsQty")
            var totalSuidsQty: Double?,
            @SerializedName("picklistQty")
            var picklistQty: Double?,
            @SerializedName("uom")
            var uom : String?,
            var tempQty : Double? = 0.0
        )
    }
}