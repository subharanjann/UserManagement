package com.mobillor.usermanagementmodule.data.models

import com.mobillor.usermanagementmodule.data.models.Data

data class Picklist(
    val `data`: List<Data>,
    val msg: String,
    val status: Boolean,
    val statusCode: Int
)