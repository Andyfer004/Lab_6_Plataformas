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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import com.example.lab6_andy_fuentes_22944.ui.theme.Lab6_Andy_Fuentes_22944Theme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6_Andy_Fuentes_22944Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.onPrimary) {
                    Greeting2()
                }
            }
        }
    }
}


@Composable
fun Greeting2() {
    val imageResources = listOf(
        R.drawable.img,
        R.drawable.img_1,
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxWidth().height(800.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Imagen actual
        Image(
            painter = painterResource(id = imageResources[currentIndex]),
            contentDescription = null,
            modifier = Modifier
                .size(600.dp) // Ajusta el tamaño de la imagen según tus necesidades
                .padding(0.dp),
        )


        // Botones para navegar entre las imágenes
        Row(
            modifier = Modifier.width(400.dp),
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            Button(
                onClick = {
                    if (currentIndex > 0) {
                        currentIndex -= 1
                    }
                },
                enabled = currentIndex > 0,
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color.White)
                    .padding(16.dp)
                    .height(50.dp)
                    .width(200.dp)
            ) {
                Text("Previous", fontSize = 20.sp)
            }

            Button(
                onClick = {
                    if (currentIndex < imageResources.size - 1) {
                        currentIndex += 1
                    }
                },
                enabled = currentIndex < imageResources.size - 1,
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(Color.White)
                    .padding(16.dp)
                    .height(50.dp)
                    .width(200.dp)

            ) {
                Text("Next", fontSize = 20.sp)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Greeting2Preview() {
    Lab6_Andy_Fuentes_22944Theme {
        Greeting2()
    }
}