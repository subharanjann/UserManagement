package com.mobillor.usermanagementmodule.data.models

import java.io.Serializable

data class ItemData(
    val destination: String,
    val documentCode: String,
    val documentNumber: String,
    val items: List<Item>,
    val picklistCode: String,
    val mvtId: Int,
    val picklistId: Int,
    val source: String,
    var latestClick: Int=0
):Serializable