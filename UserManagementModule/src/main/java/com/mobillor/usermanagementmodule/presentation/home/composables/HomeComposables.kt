package com.mobillor.usermanagementmodule.presentation.home.composables

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobillor.usermanagementmodule.domain.home.util.SessionManager
import com.mobillor.usermanagementmodule.presentation.commonComposables.TextStyles
import com.mobillor.usermanagementmodule.presentation.commonComposables.ui.theme.primaryColor
import com.mobillor.usermanagementmodule.presentation.commonComposables.ui.theme.white
import com.gimble.segmk3.presentation.home.composables.PicklistComposableButton
import com.mobillor.locpostingmodule.presentation.activity.LocPostingStarterActivity
import com.mobillor.usermanagementmodule.R
import com.mobillor.usermanagementmodule.presentation.home.viewmodel.UserManagementViewModel
import com.mobillor.usermanagementmodule.util.AppConstants


@Preview
@Composable
private fun showerr(){
Column(
    Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(white)){
    HomeTopNavigationBar("Home")
}
}

@Composable
fun HomeTopNavigationBar(name : String) {

    Card(
        colors = CardDefaults.cardColors(containerColor = primaryColor),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth()
            .height(60.dp)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        )
        {


            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = name,
                style = TextStyles.whiteTitleTextStyle
            )

            Spacer(modifier = Modifier.padding(20.dp))

        }

    }

}

@Composable
fun AllModulesSection(viewModel : UserManagementViewModel, context: Context){
    val allModulesList by viewModel.allModulesList.collectAsState(emptyList())
    val listOfMods =  allModulesList.toList()
    Log.d("testZ1","$listOfMods")

    Column(Modifier
        .padding(horizontal = 12.dp, vertical = 2.dp)
        .then(if (listOfMods.size == 0) { Modifier.height(1.dp) } else { Modifier }
    )
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "   All Modules",
            style = TextStyles.mediumBoldTextStyle)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.heightIn(100.dp,500.dp)
        ) {
            items(listOfMods){name ->
                if(name == "Picklist"){
                    PicklistComposableButton("Pickup & Putaway", R.drawable.pickuplist){
                      //  val i = Intent(context,PickUpAndPutawayFilterActivity::class.java)
                        //context.startActivity(i)
                    }
                }
            }
        }
    }
}

@Composable
fun BinManagmentSection(viewModel : UserManagementViewModel,context: Context){
    val allModulesList by viewModel.binManagement.collectAsState(emptyList())
    val listOfMods =  allModulesList.toList()
    Log.d("testZ1","$listOfMods")

    Column(Modifier.padding(horizontal = 12.dp, vertical = 2.dp).then(if (listOfMods.size == 0) { Modifier.height(1.dp) } else { Modifier })) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "   Bin Management",
            style = TextStyles.mediumBoldTextStyle)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.heightIn(100.dp,500.dp)
        ) {
            items(listOfMods){name ->
                when {
                        name == "Bin Mapping" -> {
                            PicklistComposableButton("Bin Mapping", R.drawable.binss){
//                                val i = Intent(context, FirstBinMappingJetpackComposeActivity::class.java)
//                                context.startActivity(i)
                            }
                        }
                        name == "Bin Release" -> {
                            PicklistComposableButton("Bin Release", R.drawable.binee){
//                                val i = Intent(context,ScanBinActivity::class.java)
//                                context.startActivity(i)
                            }
                        }
                        name == "Bin Transfer" -> {
                            PicklistComposableButton("Bin Transfer", R.drawable.binetransfer){
//                                val i = Intent(context, BinTransferJetPackComposeActivity::class.java)
//                                context.startActivity(i)
                            }
                        }
                }
            }
        }
    }
}

@Composable
fun ScannersSection(viewModel: UserManagementViewModel, context: Context) {
    val binManagementList by viewModel.scanners.collectAsState(emptyList())
    val listOfMods = binManagementList.toList()
    Log.d("testZ1", "$listOfMods")

    Column(Modifier
        .padding(horizontal = 12.dp, vertical = 2.dp)
        .then(if (listOfMods.size == 0) { Modifier.height(1.dp) } else { Modifier })
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "   Scanners", style = TextStyles.mediumBoldTextStyle)

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.heightIn(100.dp,500.dp)
        ) {
            items(listOfMods) { name ->
                when (name) {
                    "Scan Location" -> PicklistComposableButton("Scan Location", R.drawable.scanlocation) {
//                        val intent = Intent(context, ScanLocationJetComposeActivity::class.java)
//                        context.startActivity(intent)
                    }
                    "Scan SUID" -> PicklistComposableButton("Scan SUID", R.drawable.scansku) {
//                        val intent = Intent(context, ScanSUIDJetComposeActivity::class.java)
//                        context.startActivity(intent)
                    }
                    "Scan Pallet" -> PicklistComposableButton("Scan Pallet", R.drawable.pallet) {
//                        val intent = Intent(context, ScanPalletJetComposeActivity::class.java)
//                        context.startActivity(intent)
                    }
                    "Scan Bin" -> PicklistComposableButton("Scan Bin", R.drawable.boxx) {
//                        val intent = Intent(context, ScanBinJetComposeActivity::class.java)
//                        context.startActivity(intent)
                    }
                }
            }
        }
    }
}

@Composable
fun QuarantineSection(viewModel : UserManagementViewModel,context: Context){
    val allModulesList by viewModel.quarantine.collectAsState(emptyList())
    val listOfMods =  allModulesList.toList()
    Log.d("testZ1","$listOfMods")

    Column(
        Modifier
            .padding(horizontal = 12.dp, vertical = 2.dp)
            .then(if (listOfMods.size == 0) { Modifier.height(1.dp) } else { Modifier })
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "   Quarantine",
            style = TextStyles.mediumBoldTextStyle)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.heightIn(100.dp,500.dp)
        ) {
            items(listOfMods){name ->
                if(name == "Quarantine"){
                    PicklistComposableButton("Quarantine", R.drawable.quarantine_image_2){
//                        val i = Intent(context, QuarantineJetPackComposeActivity::class.java)
//                        context.startActivity(i)
                    }
                }
                else if(name == "Rejection"){
                    PicklistComposableButton("Rejection",  R.drawable.rejection){
//                        val i = Intent(context, RejectionScanListJetComposeActivity::class.java)
//                        context.startActivity(i)
                    }
                }
            }
        }
    }
}
@Composable
fun PalletManagmentSection(viewModel : UserManagementViewModel,context: Context){
    val allModulesList by viewModel.palletManagement.collectAsState(emptyList())
    val listOfMods =  allModulesList.toList()
    Log.d("testZ1","$listOfMods")

    Column(
        Modifier
            .padding(horizontal = 12.dp, vertical = 2.dp)
            .then(if (listOfMods.size == 0) { Modifier.height(1.dp) } else { Modifier })
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "   Pallet Management",
            style = TextStyles.mediumBoldTextStyle)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.heightIn(100.dp,500.dp)
        ) {
            items(listOfMods){name ->
                when {
                        name == "Pallet Mapping" -> {
                            PicklistComposableButton("Pallet Mapping", R.drawable.palletmapping){
//                                val i = Intent(context, FirstPalletizationJetpackComposeActivity::class.java)
//                                context.startActivity(i)
                            }
                        }
                        name == "Pallet Release" -> {
                            PicklistComposableButton("Pallet Release", R.drawable.palletrelease){
//                                val i = Intent(context, FirstEmptyPalletJetpackComposeActivity::class.java)
//                                context.startActivity(i)
                            }
                        }
                        name == "Pallet Transfer" -> {
                            PicklistComposableButton("Pallet Transfer", R.drawable.palletpickup){
//                                val i = Intent(context, FirstPalletTransferActivity::class.java)
//                                context.startActivity(i)
                            }
                        }
                }
            }
        }
    }
}

@Composable
fun MoreOptionsSection(viewModel : UserManagementViewModel,context: Context){
    val allModulesList by viewModel.moreOptions.collectAsState(emptyList())
    val listOfMods =  allModulesList.toList()
    Log.d("testZ1","$listOfMods")

    Column(
        Modifier
            .padding(horizontal = 12.dp, vertical = 2.dp)
            .then(if (listOfMods.size == 0) { Modifier.height(1.dp) } else { Modifier })
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "   More Options",
            style = TextStyles.mediumBoldTextStyle)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.heightIn(100.dp,500.dp)
        ) {
            items(listOfMods){name ->
                when {
                        name == "Goods Inward" -> {
                            PicklistComposableButton("Goods Inward", R.drawable.ic_goods_inward){
//                                val i = Intent(context,FirstGoodsInwardActivity::class.java)
//                                context.startActivity(i)
                            }
                        }
                        name == "Loc Posting" -> {
                            PicklistComposableButton("Loc Posting", R.drawable.putawaystore){
                               val i = Intent(context,LocPostingStarterActivity::class.java)
                                i.putExtra("baseURL", "https://swms.mobillor.net/api/api/api/swms/")
                                i.putExtra("userId", "ca5c8f1b-5f19-4fe9-851d-f7950a1f9169")
                                i.putExtra("userToken", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7Im5hbWUiOiJNYWRodSAoUGxhbm5lcikiLCJlbWFpbCI6Im1hZGh1c3VkaGFuLmxAbW9iaWxsb3IubmV0Iiwicm9sZUlkIjoiMjNmZDlmNjEtNTRlNS00ZTRmLWI4NWMtMWRhZGZkYzhmOGVlIiwidXVpZCI6Ijc0NTY1NmZiMmNjY2I2YTQifSwiaWF0IjoxNzMwOTc5ODcyLCJleHAiOjE3MzEwMjMwNzJ9.lPmJAz4J451CnGGIat0T72zSxFXhUoTK67L8imHhucA")

                                context.startActivity(i)
                            }
                        }
                        name == "Load Shipment" -> {
                            PicklistComposableButton("Load Shipment", R.drawable.ic_load_shipement){
//                                val i = Intent(context,LoadShipmentListActivity::class.java)
//                                context.startActivity(i)
                            }
                        }
                        name == "Kitting" -> {
                            PicklistComposableButton("Kitting", R.drawable.separate){
//                                val i = Intent(context,KittingFilterActivity::class.java)
//                                context.startActivity(i)
                            }
                        }
                    name == AppConstants.CYCLE_COUNT_MODULE_HEADER -> {
                        PicklistComposableButton(AppConstants.CYCLE_COUNT_MODULE_HEADER, R.drawable.cycle_counting){
//                            val i = Intent(context,FirstCycleCountActivity::class.java)
//                            context.startActivity(i)
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun AccountScreen(context: Activity, name: String, role: String, email: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // User Info Card
        UserInfoCard(name,role,email)

        // Buttons
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            ResetPasswordButton(context)
            Spacer(modifier = Modifier.height(8.dp))
            LogoutButton(context)
        }
    }
}

@Composable
fun UserInfoCard( name: String, role: String, email: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(top = 32.dp, bottom = 24.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Name: ", // Replace with your string resource
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(56.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = name, // Replace with your dynamic data
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "E-mail: ", // Replace with your string resource
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(56.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = email, // Replace with your dynamic data
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Role: ", // Replace with your string resource
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.width(56.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = role, // Replace with your dynamic data
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Composable
fun ResetPasswordButton(context:Activity) {
    Button(
        onClick = {
//            val i = Intent(context, ResetPasswordActivity::class.java)
//            context.startActivity(i)
                  },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor  = primaryColor,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = "Reset Password", textAlign = TextAlign.Center, fontSize = 12.sp)
    }
}

@Composable
fun LogoutButton(context: Activity) {
    Button(
        onClick = {
            val sm = SessionManager(context)
            sm.clearSession()
//            val i = Intent(context, LoginActivity::class.java)
//            context.startActivity(i)
            context.finish() // Correct usage of finish() method
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor  = primaryColor,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = "Log Out",
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

