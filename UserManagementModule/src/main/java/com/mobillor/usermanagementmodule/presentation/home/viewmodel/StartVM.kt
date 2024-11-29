package com.mobillor.usermanagementmodule.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobillor.usermanagementmodule.domain.home.repository.StartRepository

class StartVM : ViewModel() {
    private val repository = StartRepository()

    private val _usernameLiveData = MutableLiveData<String>()
    val usernameLiveData: LiveData<String> = _usernameLiveData

    init {
       //fetchDataFromSharedPrefs()
    }

}