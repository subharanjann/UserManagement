package com.mobillor.usermanagementmodule.data.models

import java.io.Serializable

data class Item(
    val itemId: Int,
    val qty: Int
) : Serializable