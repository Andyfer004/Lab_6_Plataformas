package com.example.lab6_andy_fuentes_22944


import android.content.Intent
import android.os.Bundle
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab6_andy_fuentes_22944.ui.theme.Lab6_Andy_Fuentes_22944Theme


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6_Andy_Fuentes_22944Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.DarkGray) {
                    Greeting2()
                }
            }
        }
    }

override fun onBackPressed() {
    finishAffinity()
}
}
@Composable
fun Greeting2() {

    val imageResources = listOf(
        R.drawable.img,
        R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4,
        R.drawable.img_5,
        R.drawable.img_6,
        R.drawable.img_7,
        R.drawable.img_8,
        R.drawable.img_9,
    )
    val imageDescriptions = listOf(
        "Camaro Bummblebee",
        "R8",
        "Mitsubishi Lancer Evolution",
        "Porche 911 GTS",
        "Ferrari 488 GTB",
        "Lamborghini Aventador",
        "Mustang Shelby GT500CR",
        "Mazda RX-Vision GT3",
        "Toyota Supra",
        "BMW M3"

    )
    val imageDescriptions2 = listOf(
        "Chevrolet producidos desde 1966 hasta el presente. ",
        "Audi R8 es un automóvil superdeportivo. ",
        "Mitsubishi Lancer Evolution es un automóvil de turismo. ",
        "Porsche 911 es un automóvil deportivo. ",
        "Ferrari 488 GTB es un automóvil superdeportivo. ",
        "Lamborghini Aventador es un automóvil superdeportivo. ",
        "Mustang Shelby GT500CR es un automóvil deportivo. ",
        "Mazda RX-Vision GT3 es un automóvil deportivo. ",
        "Toyota Supra es un automóvil deportivo. ",
        "BMW M3 es un automóvil deportivo. "
    )

    var currentIndex by remember { mutableStateOf(0) }
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.width(1000.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                )
            ) {
                Text(
                    text = "Log Out",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
        // Imagen actual
        Surface(
            modifier = Modifier
                .width(550.dp)
                .height(400.dp)
                .padding(20.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp),
                ),
            shape = RoundedCornerShape(20.dp),
            color = Color.Gray,
            content = {
                Image(
                    painter = painterResource(id = imageResources[currentIndex]),
                    contentDescription = null,
                    modifier = Modifier
                        .size(350.dp) // Ajusta el tamaño de la imagen según tus necesidades
                        .padding(0.dp),

                )

            })
        Surface(
            modifier = Modifier
                .width(700.dp)
                .height(120.dp)
                .padding(20.dp)
                .align(Alignment.CenterHorizontally)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp),
                ),
            shape = RoundedCornerShape(20.dp),
            color = Color.LightGray,
            content = {
                Column(){
                Text(
                    imageDescriptions[currentIndex], // Usar la descripción correspondiente
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(2.dp),

                )
                Text(
                    imageDescriptions2[currentIndex], // Usar la descripción correspondiente
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(0.dp),
                )

            }
            })

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
                    .clip(RoundedCornerShape(100))
                    .background(Color.White)
                    .padding(10.dp)
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
                    .padding(10.dp)
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