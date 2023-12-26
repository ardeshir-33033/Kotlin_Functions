package com.example.kotlinfirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinfirst.ui.theme.KotlinFirstTheme
import com.example.kotlinfirst.ui.theme.Purple80

fun main() {
    val nam:String;
    var nam2 = 10;
//    String name = "df";
    sayShit()
    println(sayShit2())

    sum(1 , 2)
}



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContent {
            KotlinFirstTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val buttonState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(), color = Color.White) {
        Card(modifier = Modifier.padding(15.dp), shape = RoundedCornerShape(15.dp), elevation = CardDefaults.cardElevation(5.dp)) {
            Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Top) {
                ImageProfile()
                Divider()
                CreateInfo()
                Button(onClick = {
                    buttonState.value = !buttonState.value
                }) {
                    Text(text = "Portfolio")
                }
//                if(buttonState.value){
                    content()
//                }
            }

        }
    }
}

@Composable
private fun CreateInfo(){
    Column(Modifier.padding(5.dp)) {
       Text(text = "Haj Ardeshir", style = MaterialTheme.typography.headlineMedium, color = Purple80)
        Text(text = "Kotlin Developer", modifier = Modifier.padding(3.dp))
        Text(text = "@Darkko", modifier = Modifier.padding(3.dp), style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
private fun ImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.padding(10.dp),
        shape = CircleShape,
        border = BorderStroke(5.dp, color = Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Portfolio(data: List<String>){
    LazyColumn{
        items(data){ item ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(), shape = RectangleShape, border = BorderStroke(3.dp, color = Color.LightGray) , elevation = CardDefaults.cardElevation(4.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(10.dp)
                ) {
                    ImageProfile(modifier = Modifier.size(100.dp))
                    Column {
                        Text(text = item)
                        Text(text = "A good portfolio")
                    }

                }
            } }
    }
}

@Composable
fun content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight(), border = BorderStroke(3.dp, color = Color.LightGray), shape = RoundedCornerShape(corner = CornerSize(3.dp))) {
            Portfolio(data = listOf("Portfolio 1", "Portfolio 2","Portfolio 3","Portfolio 4","Portfolio 5"))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CreateBizCard()
}