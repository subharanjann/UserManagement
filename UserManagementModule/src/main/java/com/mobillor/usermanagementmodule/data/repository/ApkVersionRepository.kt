package com.mobillor.usermanagementmodule.data.repository

import com.mobillor.usermanagementmodule.data.models.ApkVersionResponseModel


interface ApkVersionRepository {

    suspend fun checkApkVersion(): ApkVersionResponseModel.Data
}

interface ApkVersionCallback{
    fun onSuccess(apkVersionData: ApkVersionResponseModel.Data)
    fun onFailure(error: String)
}