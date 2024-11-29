package com.mobillor.usermanagementmodule.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobillor.usermanagementmodule.data.repository.RetrofitApkVersionRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: RetrofitApkVersionRepository) : ViewModel() {

    fun checkApkVersion(callback: (downloadLink: String, version: String) -> Unit, errorCallback: (error: String) -> Unit) {
        viewModelScope.launch {
            try {
                val apkVersionData = repository.checkApkVersion()
                val version = apkVersionData.version
                val downloadLink = apkVersionData.link
                callback(downloadLink, version)
            } catch (e: Exception) {
                errorCallback(e.message ?: "Unknown error")
            }
        }
    }

    fun updateApkVersion(callback: (downloadLink: String, version: String) -> Unit, errorCallback: (error: String) -> Unit) {
        viewModelScope.launch {
            try {
                val apkVersionData = repository.checkApkVersion()
                val version = apkVersionData.version
                val downloadLink = apkVersionData.link
                callback(downloadLink, version)
            } catch (e: Exception) {
                errorCallback(e.message ?: "Unknown error")
            }
        }
    }
}
