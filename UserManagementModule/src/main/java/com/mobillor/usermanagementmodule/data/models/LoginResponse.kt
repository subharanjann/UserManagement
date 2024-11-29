package com.mobillor.usermanagementmodule.data.models


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("jwt")
    val jwt: String?,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("statusCode")
    val statusCode: Int
) {
    data class Data(
        @SerializedName("cd")
        val cd: String,
        @SerializedName("device_type")
        val deviceType: String?,
        @SerializedName("email")
        val email: String?,
        @SerializedName("firstlogin")
        val firstlogin: Boolean?,
        @SerializedName("id")
        val id: Int,
        @SerializedName("isDashboardLoggedIn")
        val isDashboardLoggedIn: Boolean,
        @SerializedName("isDefaultPrinterSet")
        val isDefaultPrinterSet: Boolean,
        @SerializedName("isDeleted")
        val isDeleted: Boolean,
        @SerializedName("isMobileLoggedIn")
        val isMobileLoggedIn: Boolean,
        @SerializedName("name")
        val name: String?,
        @SerializedName("password")
        val password: String?,
        @SerializedName("printerId")
        val printerId: Any?,
        @SerializedName("roleId")
        val roleId: String?,
        @SerializedName("roleName")
        val roleName: String?,
        @SerializedName("ud")
        val ud: String,
        @SerializedName("userId")
        val userId: String?,
        @SerializedName("userName")
        val userName: String?
    )
}