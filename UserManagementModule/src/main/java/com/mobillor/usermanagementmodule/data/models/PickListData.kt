package com.mobillor.usermanagementmodule.data.models

data class PickListData(
    val `data`: List<ItemData>,
    val msg: String,
    val status: Boolean,
    val statusCode: Int
)