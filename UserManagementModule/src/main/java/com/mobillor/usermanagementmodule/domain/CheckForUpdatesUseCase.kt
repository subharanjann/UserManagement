package com.mobillor.usermanagementmodule.domain


import com.mobillor.usermanagementmodule.data.models.UpdateInfo
import com.mobillor.usermanagementmodule.data.repository.UpdateRepository
import com.mobillor.usermanagementmodule.util.Resource

class CheckForUpdatesUseCase(private val updateRepository: UpdateRepository) {
    suspend operator fun invoke(): Resource<UpdateInfo> {
        return try {
            updateRepository.checkForUpdates()
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}