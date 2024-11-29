package com.mobillor.usermanagementmodule.data.repository

import com.mobillor.usermanagementmodule.data.apiService.NewApiInterface

import com.mobillor.usermanagementmodule.data.models.UpdateInfo
import com.mobillor.usermanagementmodule.util.Resource
import retrofit2.HttpException

class UpdateRepositoryImpl(private val apiService: NewApiInterface) : UpdateRepository {
    override suspend fun checkForUpdates(): Resource<UpdateInfo> {
        return try {
            val updateInfoResponse = apiService.getUpdateInfo() // Retrofit call to fetch update info
            if (updateInfoResponse.isSuccessful) {
                val updateInfo = updateInfoResponse.body()
                if (updateInfo != null) {
                    Resource.Success(updateInfo)
                } else {
                    Resource.Error("Update information not available")
                }
            } else {
                val errorMessage = updateInfoResponse.errorBody()?.string()
                Resource.Error(errorMessage ?: "Failed to fetch update information")
            }
        } catch (e: HttpException) {
           return  Resource.Error("HttpException: ${e.code()} ${e.message()}")
        } catch (e: Exception) {
            return Resource.Error(e.message ?: "An error occurred")
        }
    }
}
