package com.gimble.segmk3.presentation.home.composables

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.mobillor.usermanagementmodule.presentation.commonComposables.TextStyles
import com.mobillor.usermanagementmodule.presentation.commonComposables.ui.theme.primaryColor
import com.mobillor.usermanagementmodule.presentation.commonComposables.ui.theme.primaryColorLightAccent
import com.mobillor.usermanagementmodule.R

@Preview
@Composable
private fun parento(){
    shower()
}
@Composable
fun shower(){
    Column(
        Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(1f)) {
        Row {
            Column {
               // PicklistComposableButton{}
                BinMappingComposableButton{}
                BinReleaseComposableButton{}
                BinTransferComposableButton{}
                PicklistComposableButton("Scan Bin", R.drawable.binss){}
                PicklistComposableButtonB("Scan Bin",R.drawable.binss){}
            }
            Column {
                ScanLocationComposableButton{}
                ScanSuidComposableButton{}
                ScanPalletComposableButton{}
                ScanBinComposableButton{}
                QuarantineComposableButton{}
                RejectionComposableButton{}


            }
            Column {
                PalletMappingComposableButton{}
                PalletReleaseComposableButton{}
                PalletTransferComposableButton{}
                GoodsInwardComposableButton{}
                LocationPostingComposableButton{}
                LoadShipmentComposableButton{}
                KittingComposableButton{}




            }
        }

    }

}

@Composable
fun PicklistComposableButtonB(name: String, image: Int, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(4.dp)
            .width(100.dp)
            .heightIn(100.dp, 120.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick() }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            // Circle with the image
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier.size(28.dp)
                )
            }


            Text(
                text = name,
                textAlign = TextAlign.Center,
                style = TextStyles.smallNormalDarkGreyTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 4.dp)
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PicklistComposableButton(name: String, image: Int, onClick: () -> Unit){
    Card(
        onClick = {onClick()},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(4.dp)
            .width(100.dp)
            .heightIn(100.dp, 120.dp)

    ) {
        Column(modifier = Modifier.fillMaxSize()
     ) {
            Column(modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(.75f)
                .background(primaryColorLightAccent)
                .alpha(.3f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier

                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = null,
                        alignment = Alignment.Center,
                        colorFilter = ColorFilter.tint(Color.Black),
                        modifier = Modifier.size(28.dp)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(1f)) {
                Text(
                    text = name,
                    textAlign = TextAlign.Center,
                    style = TextStyles.extraSmallNormalDarkGreyTextStyle,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(6.dp, 6.dp, 4.dp, 6.dp)
                )
            }

        }
        
    }
}

@Composable
fun BinMappingComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium),

        ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.binss),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Bin Mapping",
                textAlign = TextAlign.Center,
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
                    .fillMaxWidth(1f)
            )

        }

    }
}

@Composable
fun BinReleaseComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium),

        ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.binee),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Bin Release",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun BinTransferComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium),

        ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.binetransfer),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Bin Transfer",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun ScanLocationComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium),

        ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.scanlocation),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Scan Location",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun ScanSuidComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }

        ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.scansku),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Scan SUID",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun ScanPalletComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.pallet),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Scan Pallet",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun ScanBinComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.boxx),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Scan Bin",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun QuarantineComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.quarantine_image_2),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Quarantine",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun RejectionComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.rejection),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Rejection",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun PalletMappingComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.palletmapping),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Pallet Mapping",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun PalletReleaseComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.palletrelease),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Pallet Release",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun PalletTransferComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.palletpickup),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Pallet Transfer",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun GoodsInwardComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.ic_goods_inward),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Goods Inward",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun LocationPostingComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.putawaystore),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Loc Posting",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun LoadShipmentComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.ic_load_shipement),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Load Shipment",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}

@Composable
fun KittingComposableButton(onClick : ()->Unit){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
        modifier = Modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }

    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Row{
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.separate),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    colorFilter = ColorFilter.tint(primaryColor),
                    modifier = Modifier
                        .size(64.dp)
                        .weight(2f)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(
                text = "Kitting",
                style = TextStyles.smallMediumNormalTextStyle,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(6.dp, 4.dp, 6.dp, 8.dp)
            )

        }

    }
}







