package com.mobillor.usermanagementmodule.data.repository

import com.mobillor.usermanagementmodule.data.models.AccessModuleResponse
import com.mobillor.usermanagementmodule.util.Resource

interface UserManagementRepository {
    suspend fun getAccessModules(roleId: String): Resource<AccessModuleResponse>

}