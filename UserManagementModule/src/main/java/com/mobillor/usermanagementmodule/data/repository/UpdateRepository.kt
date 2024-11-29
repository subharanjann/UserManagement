package com.mobillor.usermanagementmodule.data.repository


import com.mobillor.usermanagementmodule.data.models.UpdateInfo

import com.mobillor.usermanagementmodule.util.Resource

interface UpdateRepository {
    suspend fun checkForUpdates(): Resource<UpdateInfo>
}