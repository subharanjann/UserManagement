package com.mobillor.usermanagementmodule.data.models

data class DataX(
    val itemId: Int,
    val locationCode: String,
    val locationName: String,
    val picklistId: Int,
    val sourceLocId: Int,
    val suid: String,
    val suidId: Int,
    val qty : Int,
    var scanned : Int = 0
)