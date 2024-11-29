package com.mobillor.usermanagementmodule.domain.home.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobillor.usermanagementmodule.data.apiClient.NewApiClient
import com.mobillor.usermanagementmodule.data.models.PasswordChangeInput
import com.mobillor.usermanagementmodule.data.models.PasswordChangeResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChangePasswordRepository(application: Application) {
    val changepasswordresponseLiveData = MutableLiveData<PasswordChangeResponse?>()
    private val apiService = NewApiClient.getBaseService()

     fun changePassword(changePasswordInput: PasswordChangeInput) {
        val call =apiService.changePassword(changePasswordInput)
        call.enqueue(object : Callback<PasswordChangeResponse>{
                override fun onResponse(call: Call<PasswordChangeResponse>, response: Response<PasswordChangeResponse>) {
                if (response.isSuccessful) {
                    val picklistResponse: PasswordChangeResponse? = response.body()
                    changepasswordresponseLiveData.value = picklistResponse
                } else {
                    Log.e("API Error", "Failed to Successfully change password: ${response.code()}")
                    changepasswordresponseLiveData.value = null
                }
            }

            override fun onFailure(p0: Call<PasswordChangeResponse>, p1: Throwable) {
                Log.e("API Error", "Failed to Successfully change password: ${p1.message}")
            }

        })

    }
}