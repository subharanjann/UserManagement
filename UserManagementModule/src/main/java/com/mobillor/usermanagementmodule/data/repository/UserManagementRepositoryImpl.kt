package com.mobillor.usermanagementmodule.data.repository

import android.util.Log
import com.mobillor.usermanagementmodule.data.apiService.NewApiInterface
import com.mobillor.usermanagementmodule.data.models.AccessModuleResponse
import com.mobillor.usermanagementmodule.util.Resource

class UserManagementRepositoryImpl(private val apiService: NewApiInterface):
    UserManagementRepository {
    override suspend fun getAccessModules(roleId: String): Resource<AccessModuleResponse> {
        try {
            val response = apiService.getAccessModules(roleId)
            Log.d("StartResponse",response.toString())
            if (response.isSuccessful) {

                val body = response.body()
                if (body != null) {
                    return Resource.Success(body)
                }
            }
            return Resource.Error("Error occurred during login")
        } catch (e: Exception) {
            Log.d("Error",e.toString())
            return Resource.Error(e.message ?: "An error occurred")
        }
    }
}