package com.mobillor.usermanagementmodule.presentation.commonComposables


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobillor.usermanagementmodule.presentation.commonComposables.ui.theme.SEGMK3Theme
import com.mobillor.usermanagementmodule.presentation.commonComposables.ui.theme.primaryColor


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












