package com.mobillor.usermanagementmodule.domain

import com.mobillor.usermanagementmodule.data.models.AccessModuleResponse
import com.mobillor.usermanagementmodule.data.repository.UserManagementRepository
import com.mobillor.usermanagementmodule.util.Resource


class UserManagementUseCase(private val repository: UserManagementRepository) {
    suspend operator fun invoke(roleID:String): Resource<AccessModuleResponse> {
        return repository.getAccessModules(roleID)
    }
}
