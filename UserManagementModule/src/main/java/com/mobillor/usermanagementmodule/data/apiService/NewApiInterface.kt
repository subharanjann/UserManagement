package com.mobillor.usermanagementmodule.data.apiService



import com.google.gson.JsonObject
import com.mobillor.usermanagementmodule.data.models.AccessModuleResponse
import com.mobillor.usermanagementmodule.data.models.ApkVersionResponseModel
import com.mobillor.usermanagementmodule.data.models.DocumentsData
import com.mobillor.usermanagementmodule.data.models.GroupedForMobileResponse
import com.mobillor.usermanagementmodule.data.models.ItemIdFilterData
import com.mobillor.usermanagementmodule.data.models.ItemListInput
import com.mobillor.usermanagementmodule.data.models.LocationValidationResponse
import com.mobillor.usermanagementmodule.data.models.LoginRequest
import com.mobillor.usermanagementmodule.data.models.LoginResponse
import com.mobillor.usermanagementmodule.data.models.PasswordChangeInput
import com.mobillor.usermanagementmodule.data.models.PasswordChangeResponse
import com.mobillor.usermanagementmodule.data.models.PickListData
import com.mobillor.usermanagementmodule.data.models.UpdateInfo
import com.mobillor.usermanagementmodule.data.models.WareHouseLocationCodes
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface NewApiInterface {





    //application
    @GET("user/login/get_apk_version")
    fun getApkVersion(@Query("app_env") appEnv: String): Call<ApkVersionResponseModel>

    @GET("user/get_access_modules")
    fun getAccessModules(
        @Query("roleId") roleID: String
    ): Response<AccessModuleResponse>

    @GET("user/get_access_modules")
    fun getAccessModule(
        @Query("roleId") roleID: String
    ): Call<AccessModuleResponse>

    @POST("user/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @GET("get_apk_version?app_env=dev")
    suspend fun getUpdateInfo(): Response<UpdateInfo>

    @GET("picklist/grouped")
    fun getPicklist(): Call<PickListData>

    @GET("picklist/grouped_for_mobile")
    fun getPicklists(
        @Query("itemId") itemId: String?,
        @Query("documentCode") documentCode: String?,
        @Query("source") source: String?,
        @Query("destination") destination: String?
    ): Call<GroupedForMobileResponse>

    @GET("document")
    fun getDocuments(): Call<DocumentsData>

    @GET("item")
    fun getItemIdList(): Call<ItemIdFilterData>

    @GET("warehouse")
    fun getWareHouse(): Call<WareHouseLocationCodes>

    @PUT("user/change_password")
    fun changePassword(
        @Body requestBody: PasswordChangeInput
    ): Call<PasswordChangeResponse>


    @GET("picklist/location_validation")
    fun validateLocationForPickup(
        @Query("location_code") locationCode: String,
        @Query("item_id") itemId: Int,
        @Query("mvt_id") mvtId: Int,
        @Query("status") status: Int
    ): Call<LocationValidationResponse>

    @GET("picklist/location_validation")
    fun validateLocationForPutaway(
        @Query("location_code") locationCode: String,
        @Query("item_id") itemId: Int,
        @Query("mvt_id") mvtId: Int,

        ): Call<LocationValidationResponse>


}


