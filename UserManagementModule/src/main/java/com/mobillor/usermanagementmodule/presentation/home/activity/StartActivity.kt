package com.mobillor.usermanagementmodule.presentation.home.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.mobillor.usermanagementmodule.presentation.commonComposables.ui.theme.SEGMK3Theme
import com.mobillor.usermanagementmodule.presentation.commonComposables.ui.theme.primaryColor
import com.mobillor.usermanagementmodule.presentation.commonComposables.ui.theme.primaryColorLightAccent
import com.mobillor.usermanagementmodule.presentation.commonComposables.ui.theme.white


import com.mobillor.usermanagementmodule.presentation.home.composables.AccountScreen
import com.mobillor.usermanagementmodule.presentation.home.composables.AllModulesSection
import com.mobillor.usermanagementmodule.presentation.home.composables.BinManagmentSection
import com.mobillor.usermanagementmodule.presentation.home.composables.MoreOptionsSection
import com.mobillor.usermanagementmodule.presentation.home.composables.PalletManagmentSection
import com.mobillor.usermanagementmodule.presentation.home.composables.QuarantineSection
import com.mobillor.usermanagementmodule.presentation.home.composables.ScannersSection
import com.mobillor.usermanagementmodule.presentation.home.viewmodel.HomeVM


import com.google.gson.Gson

import com.mobillor.usermanagementmodule.R
import com.mobillor.usermanagementmodule.data.apiClient.NewApiClient
import com.mobillor.usermanagementmodule.data.models.AccessModuleResponse
import com.mobillor.usermanagementmodule.data.models.LoginResponse
import com.mobillor.usermanagementmodule.data.repository.UserManagementRepositoryImpl
import com.mobillor.usermanagementmodule.domain.UserManagementUseCase
import com.mobillor.usermanagementmodule.presentation.commonComposables.HomeNavigationBar
import com.mobillor.usermanagementmodule.presentation.home.viewmodel.UserManagementViewModel
import com.mobillor.usermanagementmodule.presentation.home.viewmodel.UserManagementViewModelFactory
import com.mobillor.usermanagementmodule.util.BaseActivity
import com.mobillor.usermanagementmodule.util.Resource

import retrofit2.Call
import retrofit2.Response


class StartActivity : BaseActivity() {

    private lateinit var viewModel: UserManagementViewModel
    private lateinit var homeVM: HomeVM


    //user info
    var name : String =""
    private var role : String=""
    var email : String=""
    //Home Data bit
    private var baseURL : String =""
    private var userToken : String =""
    private var userIdD : String = ""
    private var usrBaseURL : String = ""
    private var roleId : String = ""

    private var allModulesList : ArrayList<String> = ArrayList()
    private var binManagement : ArrayList<String> = ArrayList()
    private var scanners : ArrayList<String> = ArrayList()
    private var quarintine : ArrayList<String> = ArrayList()
    private var palletManagement : ArrayList<String> = ArrayList()
    private var moreOptions : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       enableEdgeToEdge()
        statusBarColor()
        setUp()

        val apiService = NewApiClient.getBaseService()
        val userManagementRepository = UserManagementRepositoryImpl(apiService)
        val userManagementUseCase = UserManagementUseCase(userManagementRepository)
        val userManagementModelFactory = UserManagementViewModelFactory(userManagementUseCase)
        viewModel = ViewModelProvider(this, userManagementModelFactory).get(UserManagementViewModel::class.java)
        homeVM = ViewModelProvider(this)[HomeVM::class.java]
        observer()
        loadModules()

        setContent { SEGMK3Theme {
            StartActivityGreetings()
        } }

    }
    @Preview
    @Composable
    private fun StartActivityGreetings(){
        Scaffold(
            bottomBar = {
                Column {
                    HomeBottomTab()
                    Spacer(modifier = Modifier.height(4.dp))
                }

            }
        ) {innerPadding ->
            Column(
                modifier= Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {

            }
        }

    }
    @Composable
    fun HomeBottomTab() {
        // State to track the currently selected tab
        var selectedTab by remember { mutableStateOf(Tab.Home) }

        Column(Modifier.padding(bottom = 0.dp)) {

            Box(
                modifier = Modifier
                    .fillMaxHeight(0.90f)
                    .fillMaxWidth()
                    .padding(top = 5.dp)
            ) {
                when (selectedTab) {
                    Tab.Home -> HomeScreen("Home")
                    Tab.Profile -> ProfileScreen("Profile")
                    Tab.Settings -> SettingsScreen("Settings")
                }
            }

            // Bottom Navigation Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(primaryColor),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomNavItem(
                    iconId = R.drawable.user2,
                    contentDescription = "Profile",
                    isSelected = selectedTab == Tab.Profile,
                    onClick = { selectedTab = Tab.Profile }
                )
                BottomNavItem(
                    iconId = R.drawable.homeicon2,
                    contentDescription = "Home",
                    isSelected = selectedTab == Tab.Home,
                    onClick = { selectedTab = Tab.Home }
                )

                BottomNavItem(
                    iconId = R.drawable.settingsicon2,
                    contentDescription = "Settings",
                    isSelected = selectedTab == Tab.Settings,
                    onClick = { selectedTab = Tab.Settings }
                )
            }

        }
    }

    @Composable
    fun BottomNavItem(iconId: Int, contentDescription: String, isSelected: Boolean, onClick: () -> Unit) {
        val iconColor = if (isSelected) primaryColorLightAccent else white

        Image(
            painter = painterResource(id = iconId),
            contentDescription = contentDescription,
            modifier = Modifier
                .size(24.dp)
                .padding(2.dp)
                .clickable { onClick() }
            ,
            colorFilter = ColorFilter.tint(iconColor)

        )
    }

    @Composable
    fun HomeScreen(header: String) {
        Image(
            painter = painterResource(id = R.drawable.doodlebg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop ,
            alpha = .025f
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(4.dp))
            HomeNavigationBar(name = "Home")
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                 item{ AllModulesSection(viewModel, this@StartActivity) }
                 item{ BinManagmentSection(viewModel, this@StartActivity) }
                 item{ ScannersSection(viewModel, this@StartActivity) }
                 item{ QuarantineSection(viewModel, this@StartActivity) }
                item{ PalletManagmentSection(viewModel, this@StartActivity) }
                item{ MoreOptionsSection(viewModel, this@StartActivity) }

            }

        }
    }

    @Composable
    fun ProfileScreen(header: String) {
        Image(
            painter = painterResource(id = R.drawable.doodlebg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop ,
            alpha = .025f
        )
        Column {
            Spacer(modifier = Modifier.height(0.dp))
            HomeNavigationBar(name = "Profile")

            AccountScreen(this@StartActivity,name,role,email)
        }

    }

    fun getLoginDataFromSharedPreferencess(){
        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val loginDetailsString = sharedPrefs.getString("ApiData", "")
        if (loginDetailsString.isNullOrEmpty()) {
            Log.d("UsrResponseFirst", loginDetailsString.toString())
        } else {
            val loginDetails = Gson().fromJson(loginDetailsString, LoginResponse::class.java)
            if (loginDetails != null && loginDetails.data != null) {
                Log.d("UsrResponseSecond", loginDetails.data.roleId?:"")
                name = loginDetails.data.name?:""
                email= loginDetails.data.email?:""
                role=loginDetails.data.roleName?:""

//                viewModel.getAccessModules(roleID) // Move API call here
            } else {
                Log.e("UsrResponseSecond", "Login details or data is null")
            }
        }

    }

    @Composable
    fun SettingsScreen(header: String) {
        Image(
            painter = painterResource(id = R.drawable.doodlebg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop ,
            alpha = .025f
        )
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            HomeNavigationBar(name = "Settings")
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Column {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "Coming Soon...")
                    Spacer(modifier = Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }


    }

    // Enum to define the available tabs
    enum class Tab {
        Home, Profile, Settings
    }


    private fun setUp() {
        usrBaseURL = intent.getStringExtra("Usr-baseURL")?:""
        baseURL = intent.getStringExtra("baseURL")?:""
        userToken = intent.getStringExtra("userToken")?:""
        userIdD =  intent.getStringExtra("userId")?:""
        roleId = intent.getStringExtra("RoleId")?:""
        BASE_URL = baseURL
        USR_BASE_URL = usrBaseURL
        USER_TOKEN = userToken
        USER_ID = userIdD
        getLoginDataFromSharedPreferencess()
        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val loginDetailsString = sharedPrefs.getString("ApiData", "")
//        if (loginDetailsString.isNullOrEmpty()) {
//            Log.d("UsrResponseFirst", loginDetailsString.toString())
//        }
//        else {
//            val loginDetails = Gson().fromJson(loginDetailsString, LoginResponse::class.java)
//            if (loginDetails != null && loginDetails.data != null) {
//                Log.d("UsrResponseSecond", loginDetails.data.roleId?:"")
//                roleID = loginDetails.data.roleId?:""
//                loadModules()
////                viewModel.getAccessModules(roleID) // Move API call here
//            } else {
//                Log.e("UsrResponseSecond", "Login details or data is null")
//            }
//        }
        if(!isInternetAvailable(this)){
            Toast.makeText(this,"Internet Unavailable",Toast.LENGTH_SHORT).show()
        }



    }

    private fun observer() {
        viewModel.moduleResult.observe(this) { resource ->
            when (resource) {
                is Resource.Loading -> showLoading()
                is Resource.Success -> {
                    resource.data?.let { Log.d("ResponseSuccess", it.message) }
                    hideLoading()
                    // Handle success
                    resource.data?.let {
                        Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
                    }
                }

                is Resource.Error -> {
                    hideLoading()
                    resource.data?.let { Log.d("ResponseError", it.message) }
                    // Handle error
                    resource.data?.let {
                        Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
                    }
                }

                else -> {
                    if (resource != null) {
                        resource.data?.let { Log.d("ResponseElse", it.message) }
                    }
                }
            }
        }

    }
    private fun loadModules() {
        //temp
        Log.d("testZ1","initiating M")
        viewModel.addToScanners("Scan Location")
        viewModel.addToScanners("Scan SUID")
        viewModel.addToScanners("Scan Pallet")
        viewModel.addToScanners("Scan Bin")

        NewApiClient.getBaseService().getAccessModule(roleId)
            .enqueue(object : retrofit2.Callback<AccessModuleResponse> {
                override fun onResponse(
                    call: Call<AccessModuleResponse>,
                    response: Response<AccessModuleResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.d("testZ1","Successful module api response")
                        val modulesList = response.body()?.data

                        viewModel.clearAllModules()
                        viewModel.clearBinManagement()
                        viewModel.clearPalletManagement()
                        viewModel.clearMoreOptions()
                        viewModel.clearQuarantine()

                        if (modulesList != null) {
                            val moduleNames = modulesList.map { it.moduleName }.filter { it.contains("HHD") }
                            Log.d("moduleNames",moduleNames.toString())
                            homeVM.getSelectedModuleOptions(moduleNames)
                        }
                        modulesList?.forEach { moduleData ->
                            when (moduleData.moduleName) {
                                "Pickuplist & Putaway - HHD" -> {
                                    viewModel.addToAllModules("Picklist")
                                    Log.d("testZ1","picklist added")
                                }
                                "Bin Management -HHD" -> {
                                    viewModel.addToBinManagement("Bin Mapping")
                                    viewModel.addToBinManagement("Bin Release")
                                    viewModel.addToBinManagement("Bin Transfer")
                                }
                                "Pallet Management -HHD" -> {
                                    viewModel.addToPalletManagement("Pallet Mapping")
                                    viewModel.addToPalletManagement("Pallet Release")
                                    viewModel.addToPalletManagement("Pallet Transfer")
                                }
                                "Goods Inward - HHD" ->{
                                    viewModel.addToMoreOptions("Goods Inward")
                                }
                                "Transfer -HHD" ->{}

                                "Load Shipment - HHD" ->{
                                    viewModel.addToMoreOptions("Load Shipment")
                                }

                                "Kitting - HHD" ->{
                                    viewModel.addToMoreOptions("Kitting")

                                }

                                "Quarantine - HHD" -> {
                                    viewModel.addToQuarantine("Quarantine")
                                }

                                "Rejection - HHD" -> {
                                    viewModel.addToQuarantine("Rejection")
                                }
                                "Location Posting" ->{
                                    viewModel.addToMoreOptions("Loc Posting")
                                }
                                "Cycle Count - HHD" -> {
                                  //  viewModel.addToMoreOptions(AppConstants.CYCLE_COUNT_MODULE_HEADER)
                                }
                            }
                        }
                    } else {
                        Log.d("testZ1","failed module api response")
                        Log.e("API Error", "Failed to load modules: ${response.code()}")
                        // Handle error response
                    }
                }

                override fun onFailure(call: Call<AccessModuleResponse>, t: Throwable) {
                    Log.e("API Error", "Failed to load modules", t)
                    // Handle failure
                }
            })
    }

    private fun showLoading() {

    }

    private fun hideLoading() {

    }

    companion object{
        var USR_BASE_URL = ""
        var BASE_URL = ""
        var USER_TOKEN = ""
        var USER_ID = ""
        var ROLE_ID = ""
    }
}