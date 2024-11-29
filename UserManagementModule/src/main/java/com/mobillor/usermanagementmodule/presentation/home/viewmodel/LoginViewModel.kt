package com.mobillor.usermanagementmodule.presentation.home.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobillor.usermanagementmodule.data.models.LoginRequest
import com.mobillor.usermanagementmodule.data.models.LoginResponse

import com.mobillor.usermanagementmodule.data.models.UpdateInfo
import com.mobillor.usermanagementmodule.domain.CheckForUpdatesUseCase
import com.mobillor.usermanagementmodule.domain.LoginUseCase
import com.mobillor.usermanagementmodule.util.Resource
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val checkForUpdatesUseCase: CheckForUpdatesUseCase
) : ViewModel() {

    private val _loginResult = MutableLiveData<Resource<LoginResponse>?>()
    val loginResult: LiveData<Resource<LoginResponse>?> = _loginResult

    private val _updateInfo = MutableLiveData<UpdateInfo?>()
    val updateInfo: LiveData<UpdateInfo?> = _updateInfo

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            _loginResult.value = Resource.Loading()
            _loginResult.value = loginUseCase(loginRequest)
        }
    }

    fun checkForUpdates() {
        viewModelScope.launch {
            val updateInfoResource = checkForUpdatesUseCase()
            if (updateInfoResource is Resource.Success) {
                _updateInfo.value = updateInfoResource.data
            } else if (updateInfoResource is Resource.Error) {
                // Handle error case if needed
            }
        }
    }
}
