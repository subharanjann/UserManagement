package com.mobillor.usermanagementmodule.data.repository

import android.util.Log
import com.mobillor.usermanagementmodule.data.apiService.NewApiInterface
import com.mobillor.usermanagementmodule.data.models.LoginRequest
import com.mobillor.usermanagementmodule.data.models.LoginResponse
import com.mobillor.usermanagementmodule.util.Resource

import org.json.JSONObject
import retrofit2.HttpException

class LoginRepositoryImpl(private val apiService: NewApiInterface) : LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): Resource<LoginResponse> {
        try {
            val response = apiService.login(loginRequest)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    return Resource.Success(body)
                }else {
                    return Resource.Error(response.body()!!.message)
                }
            } else {
                val errorMessage = response.errorBody()?.string()
                Log.e("tag",errorMessage.toString())
                val jsonObject = JSONObject(errorMessage)
                return Resource.Error(jsonObject.getString("message"))
//                return Resource.Error(response.body()?.message ?: "Failed to fetch update information")
            }
        } catch (e: HttpException) {
            return Resource.Error("HttpException: ${e.code()} ${e.message()}")
        }catch (e: Exception) {
            return Resource.Error(e.message.toString() )
        }
    }
}

