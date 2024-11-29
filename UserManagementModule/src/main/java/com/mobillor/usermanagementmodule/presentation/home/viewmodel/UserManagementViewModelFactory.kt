package com.mobillor.usermanagementmodule.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobillor.usermanagementmodule.domain.UserManagementUseCase

class UserManagementViewModelFactory(private val userManagementUseCase: UserManagementUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserManagementViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserManagementViewModel(userManagementUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}