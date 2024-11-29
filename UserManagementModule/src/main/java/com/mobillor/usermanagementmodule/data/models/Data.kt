package com.mobillor.usermanagementmodule.data.models

import java.io.Serializable

data class Data(
    val destination: String,
    val documentNumber: String,
    val documentCode : String,
    val itemId: Int,
    val picklistCode: String,
    val picklistId: Int,
    val qty: Int,
    val source: String,
    val status: Int

): Serializable