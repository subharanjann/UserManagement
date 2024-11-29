package com.mobillor.usermanagementmod

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mobillor.usermanagementmod.ui.theme.UserManagementModTheme
import com.mobillor.usermanagementmodule.presentation.home.activity.StartActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val i  = Intent(this,StartActivity::class.java)
        i.putExtra("baseURL", "https://swms.mobillor.net/api/api/api/swms/")
        i.putExtra("Usr-baseURL","https://swms.mobillor.net/usr_api/")
        i.putExtra("userId", "ca5c8f1b-5f19-4fe9-851d-f7950a1f9169")
        i.putExtra("RoleId","cb76be3a-4595-4445-ad24-0e63d9f8e04a") //admin
        i.putExtra("userToken", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7Im5hbWUiOiJNYWRodSAoUGxhbm5lcikiLCJlbWFpbCI6Im1hZGh1c3VkaGFuLmxAbW9iaWxsb3IubmV0Iiwicm9sZUlkIjoiMjNmZDlmNjEtNTRlNS00ZTRmLWI4NWMtMWRhZGZkYzhmOGVlIiwidXVpZCI6Ijc0NTY1NmZiMmNjY2I2YTQifSwiaWF0IjoxNzMwOTc5ODcyLCJleHAiOjE3MzEwMjMwNzJ9.lPmJAz4J451CnGGIat0T72zSxFXhUoTK67L8imHhucA")

        startActivity(i)
        setContent {
            UserManagementModTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UserManagementModTheme {
        Greeting("Android")
    }
}