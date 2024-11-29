package com.mobillor.usermanagementmodule.data.models

data class ItemListInputItem(
    val itemId: Int,
    val picklistId: Int,
    val qty: Double,
    val status: Int,
    val mvtId : Int
)