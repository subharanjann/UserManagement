package com.mobillor.usermanagementmodule.data.models


import com.google.gson.annotations.SerializedName

data class PasswordChangeInput(
    @SerializedName("email")
    val email: String,
    @SerializedName("newPassword")
    val newPassword: String,
    @SerializedName("oldPassword")
    val oldPassword: String
)