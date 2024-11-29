package com.mobillor.usermanagementmodule.data.repository


import com.mobillor.usermanagementmodule.data.apiService.NewApiInterface
import com.mobillor.usermanagementmodule.data.models.ApkVersionResponseModel
import retrofit2.HttpException

class RetrofitApkVersionRepository(private val apiService: NewApiInterface) : ApkVersionRepository {
    override suspend fun checkApkVersion(): ApkVersionResponseModel.Data {

        try {
            val response = apiService.getApkVersion("Dev").execute() // or use await() if you have configured Retrofit with coroutines
            if (response.isSuccessful) {
                val apkversionResponse = response.body()
                val apkVersionData = apkversionResponse?.data?.firstOrNull()
                if (apkVersionData != null) {
                    return apkVersionData
                } else {
                    throw IllegalStateException("No Data Received")
                }
            } else {
                throw HttpException(response)
            }
        } catch (e: Exception) {
            throw e
        }
    }


}