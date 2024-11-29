package com.mobillor.usermanagementmodule.presentation.home.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobillor.usermanagementmodule.domain.home.repository.RawData

class HomeVM(application: Application) : AndroidViewModel(application) {
    private val rawData = RawData()

    // Initialize _accessModules with an empty list
    private val _accessModules = MutableLiveData<MutableList<Pair<String, Int>>>(mutableListOf())

    // Expose accessModulesResult as LiveData
    val accessModulesResult: LiveData<MutableList<Pair<String, Int>>> = _accessModules

    fun getModuleOptions(): MutableList<Pair<String, Int>> {
        return rawData.moduleAllOptions
    }

    fun getSelectedModuleOptions(selectedModuleNames: List<String>) {
        Log.d("moduleReq",selectedModuleNames.toString())
        val filteredModules = rawData.moduleAllOptions.filter { selectedModuleNames.contains(it.first) }.toMutableList()
        Log.d("moduleRes",filteredModules.toString())
        _accessModules.value = filteredModules
    }
}
