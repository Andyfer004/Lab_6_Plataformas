package com.example.lab6_andy_fuentes_22944

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import com.example.lab6_andy_fuentes_22944.ui.theme.Lab6_Andy_Fuentes_22944Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6_Andy_Fuentes_22944Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.secondary) {
                    Greeting("Welcome to Login Page")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)


    ) {
        Text(
            text = "Welcome to login page",
            color = Color.White,
            fontSize = 40.sp,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .align(Alignment.Start)
        ) {
            Icon(
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Person",
                tint = Color.White,
                modifier = modifier
                    .padding(start = 16.dp)
                    //.aspectRatio(2f)
                    .align(Alignment.CenterVertically)
                    .size(400.dp)
            )
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(40.dp))


                TextField(
                    value = text,
                    onValueChange = { newText ->
                        if (newText.length <= 10) {
                            text = newText
                        }
                    },
                    label = { Text("Username") },
                    textStyle = androidx.compose.ui.text.TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .background(Color.White)
                        .width(500.dp)
                        .padding(30.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
                TextField(
                    // ponerle subtitulo al textfield username

                    value = text2,
                    onValueChange = {
                            newText2 ->
                        if (newText2.length <= 8) {
                            text2 = newText2
                        }
                    },
                    label = { Text("Password") },
                    textStyle = androidx.compose.ui.text.TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .background(Color.White)
                        .width(500.dp)
                        .padding(30.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password
                )
                )
            }
        }
        Button(
            onClick = {
                if (ValidUser( text ,text2)) {
                    val intent = Intent(context, MainActivity2::class.java)
                    context.startActivity(intent)
                }
            },
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
            )
        ) {
            Text(
                text = "Login",
                color = Color.Black,
                fontSize = 20.sp,
            )
        }
    }
}
private val usuariosValidos = mapOf(
    "andy" to "1234",
    "usuario2" to "contraseña2",
    "usuario3" to "contraseña3",
)

private fun ValidUser(text: String, text2: String): Boolean {
    return usuariosValidos[text] == text2
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab6_Andy_Fuentes_22944Theme {
        Greeting("Welcome to Login Page")
    }
}