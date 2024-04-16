package com.example.loginexampleb

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginexampleb.ui.theme.LogInExampleBTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity

class LoginActivity : ComponentActivity() {
    val TAG: String ="LogInActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogInExampleBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen("Android")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Login Activity"," ** !!START")

    }

    override fun onResume() {
        super.onResume()
        Log.i("Login Activity","** !! RESUME")

    }

    override fun onPause() {
        super.onPause()
        Log.i("Login Activity","** !! ON PAUSE")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Login Activity","** !! ON STOP")

    }

}

@Composable
fun LoginScreen(name: String, modifier: Modifier = Modifier) {

    val context = LocalContext.current
    var userName by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(modifier = modifier
        .fillMaxSize()
        .padding(10.dp)
        .background(color = Color.White), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center)
    {

        Image(painter = painterResource(id = R.drawable.captainslogo), contentDescription ="Logo Image",
            modifier= modifier
                .size(100.dp)
                .background(color = Color.White, shape = CircleShape)
                .padding(5.dp))

        Text(
            text = "Hello  $userName!",
            modifier = modifier
        )
        OutlinedTextField(value = userName, onValueChange ={userName=it},modifier= modifier
            .fillMaxWidth(0.75f)
            .padding(5.dp)
            ,
            maxLines = 1
        ,label={Text("User name")})

        OutlinedTextField(value = password,
            onValueChange ={password=it},
            modifier= modifier
            .fillMaxWidth(0.75f)
            .padding(5.dp)
            ,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            ,
            label={Text("Password")})

        Button(onClick = {

                            if(userName.equals("admin") && password.equals("admin"))
                            {
                                userName = ""
                                password=""
                                val  intent = Intent(context,MainBankingMenu::class.java)
                                context.startActivity(intent)
                            }


                         },
            modifier = modifier
                .height(50.dp)
                .fillMaxWidth(0.5f))
        {
            Text("Login", fontSize = 18.sp)
        }


    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LogInExampleBTheme {
        LoginScreen("Android")
    }
}