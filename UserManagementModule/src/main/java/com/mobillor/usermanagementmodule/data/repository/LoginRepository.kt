package com.mobillor.usermanagementmodule.data.repository

import com.mobillor.usermanagementmodule.data.models.LoginRequest
import com.mobillor.usermanagementmodule.data.models.LoginResponse
import com.mobillor.usermanagementmodule.util.Resource


interface LoginRepository {
        suspend fun login(loginRequest: LoginRequest): Resource<LoginResponse>
    }

