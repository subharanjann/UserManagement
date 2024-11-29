package com.mobillor.usermanagementmodule.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobillor.usermanagementmodule.domain.CheckForUpdatesUseCase
import com.mobillor.usermanagementmodule.domain.LoginUseCase

class LoginViewModelFactory(private val loginUseCase: LoginUseCase, private val updatesUseCase: CheckForUpdatesUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(loginUseCase, updatesUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}