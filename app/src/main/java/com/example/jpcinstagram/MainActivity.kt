package com.example.jpcinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jpcinstagram.ui.theme.JpcInstagramTheme
import com.example.jpcinstagram.Login.LoginScreen
import com.example.jpcinstagram.Login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint //esta clase esta preparada
class MainActivity : ComponentActivity() {

    private val loginViewModel:LoginViewModel by viewModels()//solo con esta notacion preparamos el viewmodel e inyectarlo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpcInstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(loginViewModel) //aca podemos pasar varias screen
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
    JpcInstagramTheme {
        Greeting("Android")
    }
}