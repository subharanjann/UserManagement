package com.mobillor.usermanagementmodule.presentation.commonComposables


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mobillor.usermanagementmodule.presentation.commonComposables.ui.theme.SEGMK3Theme
import com.mobillor.usermanagementmodule.presentation.commonComposables.ui.theme.primaryColor
import com.mobillor.usermanagementmodule.R


class BasicElements : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SEGMK3Theme {

                    Greeting2()
                }
            }
        }
    }


@Composable
fun Greeting2() {
    Column(
        Modifier.fillMaxSize()
    ) {
        ScanHintCard("Scan Your Bin")
        BasicScanButton(){}

        SearchView(
            query = "",
            hint = "Search Suid...",
            onQueryChanged = { query ->
                // Handle the query change here
                println("Query changed: $query")
            },
            onClearQuery = {
                // Handle the clear action here
                println("Query cleared")
            }
        )
        BottomTabs("Picking","Picked")

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SEGMK3Theme {
        Greeting2()
    }
}




@Composable
fun HintLocationRow(locationCode:String) {

    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White)
            .border(width = 0.5.dp, color = Color.LightGray, shape = RoundedCornerShape(5.dp))
            .clip(RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.End
    ) {
        Image(
            painter = painterResource(id = R.drawable.locationlogo),
            contentDescription = null,
            modifier = Modifier
                .size(26.dp)
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)

        )
        Text(
            text = locationCode,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
fun CardView2(itemcode:String,suid:String,sku:String,qty:String,description:String,status:String,uom:String) {

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .width(390.dp)
            .padding(8.dp, 0.dp)
            .clip(MaterialTheme.shapes.medium)

    ) {
        Column(
            modifier = Modifier
                .padding(0.dp,12.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Item Code",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $itemcode",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "SUID",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $suid",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "SKU",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $sku",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Qty",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $qty $uom",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Status",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
//                Text(
//                    text = " $status",
//                    style = TextStyles.smallMediumNormalTextStyle
//                )
                Text(
                    text = when (status.toIntOrNull()) {
                        0 -> " Inactive"
                        1 -> " Active"
                        2 -> " Quarantine Pending"
                        3 -> " Quarantined"
                        4 -> " Rejection Pending"
                        5 -> " Rejected"
                        6 -> " Consumed"
                        else -> " Unknown"
                    },
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }


            Row(
                modifier = Modifier
                    .padding(16.dp,8.dp)
            ){
                DashedLine()
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Desc",
                    style = TextStyles.smallLightColoredNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallLightColoredNormalTextStyle,
                )
                Text(
                    text = " $description",
                    style = TextStyles.smallLightColoredNormalTextStyle,
                    modifier = Modifier
                        .width(200.dp)
                )
            }


//
//                Row(
//                    modifier = Modifier
//                        .padding(16.dp,0.dp)
//                        .height(24.dp)
//                ){
//                BasicText(
//                    text = "Suid:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = suid,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "SKU:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = sku,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Qty:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = qty + " NOS",
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Status:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = when (status.toIntOrNull()) {
//                        0 -> "Inactive SUID"
//                        1 -> "Active SUID"
//                        2 -> "Quarantined"
//                        3 -> "Rejected"
//                        4 -> "Consumed"
//                        else -> "Unknown"
//                    },
//                    style = TextStyle(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                DashedLine()
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                Text(
//                    text = description,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 5.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(color = Color.Red, fontSize = 14.sp),
//                    textAlign = TextAlign.Left
//                )
//            }

        }
    }
}

@Composable
fun CardView3(itemcode:String,suid:String,sku:String,qty:String,description:String,uom:String,isChecked: Boolean,
              onCheckedChange: (Boolean) -> Unit) {

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .width(390.dp)
            .padding(8.dp, 0.dp)
            .clip(MaterialTheme.shapes.medium)

    ) {
        Column(
            modifier = Modifier
                .padding(0.dp,12.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
                    .fillMaxWidth()
            ){
                Text(
                    text = "Item Code",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $itemcode",
                    style = TextStyles.smallMediumNormalTextStyle
                )

                Spacer(modifier = Modifier.weight(1f)) // Takes up the remaining space

                Checkbox(
                    checked = isChecked,
                    onCheckedChange = onCheckedChange
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "SUID",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $suid",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "SKU",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $sku",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Qty",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $qty $uom",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

//            Row(
//                modifier = Modifier
//                    .padding(16.dp,0.dp)
//                    .height(24.dp)
//            ){
//                Text(
//                    text = "Status",
//                    style = TextStyles.smallMediumNormalTextStyle,
//                    modifier = Modifier
//                        .width(100.dp)
//                )
//                Text(
//                    text = ":",
//                    style = TextStyles.smallMediumNormalTextStyle
//                )
////                Text(
////                    text = " $status",
////                    style = TextStyles.smallMediumNormalTextStyle
////                )
//                Text(
//                    text = when (status.toIntOrNull()) {
//                        0 -> " Inactive"
//                        1 -> " Active"
//                        2 -> " Quarantine Pending"
//                        3 -> " Quarantined"
//                        4 -> " Rejection Pending"
//                        5 -> " Rejected"
//                        6 -> " Consumed"
//                        else -> " Unknown"
//                    },
//                    style = TextStyles.smallMediumNormalTextStyle
//                )
//            }


            Row(
                modifier = Modifier
                    .padding(16.dp,8.dp)
            ){
                DashedLine()
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Desc",
                    style = TextStyles.smallLightColoredNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallLightColoredNormalTextStyle,
                )
                Text(
                    text = " $description",
                    style = TextStyles.smallLightColoredNormalTextStyle,
                    modifier = Modifier
                        .width(200.dp)
                )
            }


//
//                Row(
//                    modifier = Modifier
//                        .padding(16.dp,0.dp)
//                        .height(24.dp)
//                ){
//                BasicText(
//                    text = "Suid:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = suid,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "SKU:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = sku,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Qty:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = qty + " NOS",
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Status:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = when (status.toIntOrNull()) {
//                        0 -> "Inactive SUID"
//                        1 -> "Active SUID"
//                        2 -> "Quarantined"
//                        3 -> "Rejected"
//                        4 -> "Consumed"
//                        else -> "Unknown"
//                    },
//                    style = TextStyle(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                DashedLine()
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                Text(
//                    text = description,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 5.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(color = Color.Red, fontSize = 14.sp),
//                    textAlign = TextAlign.Left
//                )
//            }

        }
    }
}


//@Composable
//fun CardViewQuarantine(itemcode:String,suid:String,sku:String,qty:String,description:String,status:String) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 8.dp, vertical = 6.dp),
//        shape = MaterialTheme.shapes.medium,
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        elevation = CardDefaults.cardElevation(5.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(8.dp)
//                .fillMaxWidth()
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Item Code:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = itemcode,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Suid:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = suid,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "SKU:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = sku,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Qty:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = qty + " NOS",
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }
//
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Status:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = when (status.toIntOrNull()) {
//                        0 -> "Inactive SUID"
//                        1 -> "Active SUID"
//                        2 -> "Quarantined"
//                        3 -> "Rejected"
//                        4 -> "Consumed"
//                        else -> "Unknown"
//                    },
//                    style = TextStyle(fontSize = 14.sp)
//                )
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                DashedLine()
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                Text(
//                    text = description,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 5.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(color = Color.Red, fontSize = 14.sp),
//                    textAlign = TextAlign.Left
//                )
//            }
//
//        }
//    }
//}



@Composable
fun CardView4(itemcode:String,suid:String,sku:String,qty:String,description:String,uom:String) {

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .width(390.dp)
            .padding(8.dp, 0.dp)
            .clip(MaterialTheme.shapes.medium)

    ) {
        Column(
            modifier = Modifier
                .padding(0.dp,12.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Item Code",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $itemcode",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "SUID",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $suid",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "SKU",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $sku",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

//            Row(
//                modifier = Modifier
//                    .padding(16.dp,0.dp)
//                    .height(24.dp)
//            ){
//                Text(
//                    text = "Location",
//                    style = TextStyles.smallMediumNormalTextStyle,
//                    modifier = Modifier
//                        .width(100.dp)
//                )
//                Text(
//                    text = ":",
//                    style = TextStyles.smallMediumNormalTextStyle
//                )
//                Text(
//                    text = " $location",
//                    style = TextStyles.smallMediumNormalTextStyle
//                )
//            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Qty",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $qty $uom",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp,8.dp)
            ){
                DashedLine()
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Desc",
                    style = TextStyles.smallLightColoredNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallLightColoredNormalTextStyle,
                )
                Text(
                    text = " $description",
                    style = TextStyles.smallLightColoredNormalTextStyle,
                    modifier = Modifier
                        .width(200.dp)
                )
            }


//
//                Row(
//                    modifier = Modifier
//                        .padding(16.dp,0.dp)
//                        .height(24.dp)
//                ){
//                BasicText(
//                    text = "Suid:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = suid,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "SKU:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = sku,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Qty:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = qty + " NOS",
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Status:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = when (status.toIntOrNull()) {
//                        0 -> "Inactive SUID"
//                        1 -> "Active SUID"
//                        2 -> "Quarantined"
//                        3 -> "Rejected"
//                        4 -> "Consumed"
//                        else -> "Unknown"
//                    },
//                    style = TextStyle(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                DashedLine()
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                Text(
//                    text = description,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 5.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(color = Color.Red, fontSize = 14.sp),
//                    textAlign = TextAlign.Left
//                )
//            }

        }
    }
}

@Composable
fun CardView5(itemcode:String,suid:String,sku:String,qty:String,description:String,location:String,uom:String) {

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .width(390.dp)
            .padding(8.dp, 0.dp)
            .clip(MaterialTheme.shapes.medium)

    ) {
        Column(
            modifier = Modifier
                .padding(0.dp,12.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Item Code",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $itemcode",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "SUID",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $suid",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "SKU",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $sku",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Location",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $location",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Qty",
                    style = TextStyles.smallMediumNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallMediumNormalTextStyle
                )
                Text(
                    text = " $qty $uom",
                    style = TextStyles.smallMediumNormalTextStyle
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp,8.dp)
            ){
                DashedLine()
            }

            Row(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .height(24.dp)
            ){
                Text(
                    text = "Desc",
                    style = TextStyles.smallLightColoredNormalTextStyle,
                    modifier = Modifier
                        .width(100.dp)
                )
                Text(
                    text = ":",
                    style = TextStyles.smallLightColoredNormalTextStyle,
                )
                Text(
                    text = " $description",
                    style = TextStyles.smallLightColoredNormalTextStyle,
                    modifier = Modifier
                        .width(200.dp)
                )
            }


//
//                Row(
//                    modifier = Modifier
//                        .padding(16.dp,0.dp)
//                        .height(24.dp)
//                ){
//                BasicText(
//                    text = "Suid:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = suid,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "SKU:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = sku,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Qty:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = qty + " NOS",
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Status:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = when (status.toIntOrNull()) {
//                        0 -> "Inactive SUID"
//                        1 -> "Active SUID"
//                        2 -> "Quarantined"
//                        3 -> "Rejected"
//                        4 -> "Consumed"
//                        else -> "Unknown"
//                    },
//                    style = TextStyle(fontSize = 14.sp)
//                )
//            }

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                DashedLine()
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                Text(
//                    text = description,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 5.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(color = Color.Red, fontSize = 14.sp),
//                    textAlign = TextAlign.Left
//                )
//            }

        }
    }
}


//@Composable
//fun CardView4(itemcode:String,suid:String,sku:String,qty:String,Location:String,description:String) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 8.dp, vertical = 6.dp),
//        shape = MaterialTheme.shapes.medium,
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        elevation = CardDefaults.cardElevation(5.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .padding(8.dp)
//                .fillMaxWidth()
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Item Code:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = itemcode,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Suid:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = suid,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "SKU:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = sku,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Qty:",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = qty + " NOS",
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                BasicText(
//                    text = "Location",
//                    modifier = Modifier.width(80.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//                BasicText(
//                    text = Location,
//                    style = TextStyles.smallMediumNormalTextStyle.copy(fontSize = 14.sp)
//                )
//            }
//
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                DashedLine()
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                Text(
//                    text = description,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 5.dp),
//                    style = TextStyles.smallMediumNormalTextStyle.copy(color = Color.Red, fontSize = 14.sp),
//                    textAlign = TextAlign.Left
//                )
//            }
//
//        }
//    }
//}

@Composable
fun HintPalletRow(palletCode:String) {

    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White)
            .border(width = 0.5.dp, color = Color.LightGray, shape = RoundedCornerShape(5.dp))
            .clip(RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.End
    ) {
        Image(
            painter = painterResource(id = R.drawable.pallet),
            contentDescription = null,
            modifier = Modifier
                .size(26.dp)
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)

        )
        Text(
            text = palletCode,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}



@Composable
fun HintBinRow(scanned_info:String) {

    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White)
            .border(width = 0.5.dp, color = Color.LightGray, shape = RoundedCornerShape(5.dp))
            .clip(RoundedCornerShape(10.dp))
            .wrapContentWidth(Alignment.End),
    ) {
        Image(
            painter = painterResource(id = R.drawable.binss),
            contentDescription = null,
            modifier = Modifier
                .size(26.dp)
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        )
        Text(
            text = scanned_info,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}




@Composable
fun HomeNavigationBar(name : String) {

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


            Spacer(modifier = Modifier
                .height(20.dp)
                .weight(1f))

            Text(
                text = name,
                style = TextStyles.whiteTitleTextStyle
            )

            Spacer(modifier = Modifier
                .height(20.dp)
                .weight(1f))

        }

    }

}
//buttons

@Composable
fun BasicScanButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

}

//cards
@Composable
fun ScanHintCard(hint : String){
    CurvedBoxWithDottedBorder(280.dp,20.dp) {
        Column(Modifier.padding(0.dp,0.dp,0.dp,0.dp)) {
            AnimatedPreloader()
            Text(
                text = hint,
                style = TextStyles.wildcardTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
            )
        }

    }
}


//containers


//lottie
@Composable
fun AnimatedPreloader(modifier: Modifier = Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.scani))

    val preloaderProgress by animateLottieCompositionAsState(preloaderLottieComposition, iterations = LottieConstants.IterateForever, isPlaying = true)


    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier
            .height(192.dp)
            .width(240.dp)
    )
}



//searchview
@Composable
fun SearchView(
    query: String,
    hint: String,
    onQueryChanged: (String) -> Unit,
    onClearQuery: () -> Unit
) {
    var isTyping by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(7.dp),
        color = Color.White,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(8.dp))
                BasicTextField(
                    value = query,
                    onValueChange = {
                        onQueryChanged(it)
                        isTyping = it.isNotEmpty()
                    },
                    modifier = Modifier
                        .weight(1f)
                        .background(Color.Transparent),
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        if (query.isEmpty()) {
                            Text(
                                text = hint,
                                style = TextStyles.smallNormalGreyTextStyle,
                                modifier = Modifier
                                    .size(20.dp)
                                    .padding(top = 3.dp)
                                    .align(alignment = Alignment.CenterVertically),
                                color = Color.Gray
                            )
                        }
                        innerTextField()
                    }
                )
                if (isTyping) {
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = {
                        onClearQuery()
                        onQueryChanged("") // Clears the text
                        isTyping = false
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Clear",
                            tint = Color.Gray
                        )
                    }
                }
            }
        }
    }
}
//buttom multibutton
@Composable
fun BottomTabs(firstTab: String, secondTab: String) {

    var isFirstTAB by remember{ mutableStateOf(true) }
    var isSecondTAB by remember{ mutableStateOf(false) }

    var isFirstTABOnceClicked by remember{ mutableStateOf(false) }
    var isSecondTABOnceClicked by remember{ mutableStateOf(false) }

    var context = LocalContext.current


    Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp))
    {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.5F, fill = false),
        contentAlignment = Alignment.Center
        )
        {

            if (isFirstTAB)
            {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 10.dp, top = 5.dp, end = 2.dp, bottom = 5.dp)
                        .clickable
                            (enabled = false, onClick = ({})),
                    onClick = { if(isFirstTAB)
                        { isFirstTABOnceClicked = !isFirstTABOnceClicked }
// if(isFirstTABOnceClicked){
// isFirstTABOnceClickedClickable = !isFirstTABOnceClickedClickable
// }
                    }
                    ,
// enabled = isFirstTABOnceClicked ,
                    content = { Text(text = firstTab) }
                    ,
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                )
            }else{
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 10.dp, top = 5.dp, end = 2.dp, bottom = 5.dp)
                        .clickable(enabled = true, onClick = ({})),
                    onClick = {
                        isFirstTAB = !isFirstTAB
                        isSecondTAB =!isSecondTAB
                    }
                    ,
                    content = { Text(text = firstTab) },
                    shape =
                    RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.
                    buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black
                    ),
                )
            }

        }

        Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(0.5F, fill = false),
        contentAlignment = Alignment.Center // Center the content
        )
        {

            if (isSecondTAB)
            {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 2.dp, top = 5.dp, end = 10.dp, bottom = 5.dp)
                        .clickable(enabled = false, onClick = ({})),
                    onClick =
                    {
                        if(isSecondTAB) {
                            isSecondTABOnceClicked = !isSecondTABOnceClicked
                        }
// if(isSecondTABOnceClicked){
// isSecondTABOnceClickedClickable = !isSecondTABOnceClickedClickable
// }
                    }
                    ,
// enabled = isSecondTABOnceClicked ,
                    content = {
                        Text(text = secondTab)
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.
                    buttonColors
                        (
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                )
            }else{
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 2.dp, top = 5.dp, end = 10.dp, bottom = 5.dp)
                        .clickable(enabled = true, onClick = ({})),
                    onClick =
                    {
                        isFirstTAB = !isFirstTAB
                        isSecondTAB =!isSecondTAB
                    }
                    ,
                    content = { Text(text = secondTab) },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.
                    buttonColors
                        (
                        containerColor = Color.LightGray,
                        contentColor = Color.Black
                    ),
                )
            }

        }

    }

}


@Composable
fun CustomDialogBox(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: Int,
) {
    AlertDialog(
        icon = {
            Icon(painterResource(id = icon),contentDescription = "Example Icon",Modifier.size(48.dp))
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}



