package com.mobillor.usermanagementmodule.data.models

import com.mobillor.usermanagementmodule.data.models.DataXX

data class PutAwayLocationCarrier(
    val `data`: List<DataXX>,
    val msg: String,
    val status: Boolean,
    val statusCode: Int
)