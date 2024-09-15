package com.example.loginapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginapp.ui.theme.LoginAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                Sayfa()
            }
        }
    }
}

@Composable
fun Sayfa() {

    var userName by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold (
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.padding(it)
                .fillMaxSize()
                .background(color = colorResource(id = R.color.background)),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.banka),
                contentDescription = "",
                modifier = Modifier.background(color = colorResource(id = R.color.background))
                    .size(200.dp)
            )

            TextField(
                value = userName ,
                onValueChange = { userName = it },
                label = { Text(text = "User Name" )},
                modifier = Modifier.fillMaxWidth(0.8f)
                    .padding(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Red,
                    focusedTextColor = Color.Black
                )
            )

            TextField(
                value = userPassword ,
                onValueChange = { userPassword = it },
                label = { Text(text = "User Password")},
                modifier = Modifier.fillMaxWidth(0.8f)
                    .padding(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    focusedIndicatorColor = Color.Red
                )
            )


            Button({
                Toast.makeText(context,"User Name : $userName , User Password : $userPassword",
                    Toast.LENGTH_SHORT).show()
            },
               colors = ButtonDefaults.buttonColors(
                   containerColor = Color.Red,
                   contentColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth(0.6f),
                shape = RoundedCornerShape(0.dp)

            ) {
                Text(
                    text = "Giriş Yap"
                )
            }


        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginAppTheme {
        Sayfa()
    }
}