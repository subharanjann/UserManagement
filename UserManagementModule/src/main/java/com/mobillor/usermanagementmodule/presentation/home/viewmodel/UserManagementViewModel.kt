package com.mobillor.usermanagementmodule.presentation.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobillor.usermanagementmodule.data.models.AccessModuleResponse
import com.mobillor.usermanagementmodule.domain.UserManagementUseCase
import com.mobillor.usermanagementmodule.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserManagementViewModel(private val userManagementUseCase: UserManagementUseCase) : ViewModel() {

    private val _modulesRes = MutableLiveData<Resource<AccessModuleResponse>?>()
    val moduleResult: MutableLiveData<Resource<AccessModuleResponse>?> = _modulesRes

    // MutableStateList for observable data
    // StateFlow for observable data
    private val _allModulesList = MutableStateFlow<List<String>>(emptyList())
    val allModulesList: StateFlow<List<String>> = _allModulesList

    private val _binManagement = MutableStateFlow<List<String>>(emptyList())
    val binManagement: StateFlow<List<String>> = _binManagement

    private val _scanners = MutableStateFlow<List<String>>(emptyList())
    val scanners: StateFlow<List<String>> = _scanners

    private val _quarantine = MutableStateFlow<List<String>>(emptyList())
    val quarantine: StateFlow<List<String>> = _quarantine

    private val _palletManagement = MutableStateFlow<List<String>>(emptyList())
    val palletManagement: StateFlow<List<String>> = _palletManagement

    private val _moreOptions = MutableStateFlow<List<String>>(emptyList())
    val moreOptions: StateFlow<List<String>> = _moreOptions

    fun getAccessModules(roleId: String) {
        viewModelScope.launch {
            _modulesRes.value = Resource.Loading()
            _modulesRes.value = userManagementUseCase(roleId)
        }
    }

    // Methods to add items to the lists
    fun addToAllModules(item: String) {
        _allModulesList.value = _allModulesList.value + item
    }

    fun addToBinManagement(item: String) {
        _binManagement.value = _binManagement.value + item
    }

    fun addToScanners(item: String) {
        _scanners.value = _scanners.value + item
    }

    fun addToQuarantine(item: String) {
        _quarantine.value = _quarantine.value + item
    }

    fun addToPalletManagement(item: String) {
        _palletManagement.value = _palletManagement.value + item
    }

    fun addToMoreOptions(item: String) {
        _moreOptions.value = _moreOptions.value + item
    }

    // Methods to clear the lists
    fun clearAllModules() {
        _allModulesList.value = emptyList()
    }

    fun clearBinManagement() {
        _binManagement.value = emptyList()
    }

    fun clearScanners() {
        _scanners.value = emptyList()
    }

    fun clearQuarantine() {
        _quarantine.value = emptyList()
    }

    fun clearPalletManagement() {
        _palletManagement.value = emptyList()
    }

    fun clearMoreOptions() {
        _moreOptions.value = emptyList()
    }
}
