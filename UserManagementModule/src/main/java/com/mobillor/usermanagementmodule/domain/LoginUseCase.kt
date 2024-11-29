package com.mobillor.usermanagementmodule.domain


import com.mobillor.usermanagementmodule.data.repository.LoginRepository
import com.mobillor.usermanagementmodule.data.models.LoginRequest
import com.mobillor.usermanagementmodule.data.models.LoginResponse
import com.mobillor.usermanagementmodule.util.Resource

class LoginUseCase(private val repository: LoginRepository) {
    suspend operator fun invoke(loginRequest: LoginRequest): Resource<LoginResponse> {
        return repository.login(loginRequest)
    }
}
