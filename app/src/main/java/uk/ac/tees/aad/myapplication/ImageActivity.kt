package uk.ac.tees.aad.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.ac.tees.aad.myapplication.ui.theme.MyApplicationTheme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {}
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    MyApplicationTheme {
        Column( modifier = Modifier
            .fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            ImageSample()
            Spacer(modifier = Modifier.height(8.dp))
            CircleImage()
            Spacer(modifier = Modifier.height(8.dp))
            RoundedCornerImage()
        }
    }
}

@Composable
fun ImageSample(){
    Image(painter = painterResource(id = R.drawable.ic_moon),
        contentDescription = "Jeck", modifier = Modifier.fillMaxWidth())
}

@Composable
fun  CircleImage(){
    Image(painter = painterResource(id = R.drawable.ic_moon),
        contentDescription = "Circle Image", contentScale = ContentScale.Crop,
        modifier = Modifier.size(300.dp).clip(CircleShape).border(1.dp, Color.Black, CircleShape))
}

@Composable
fun  RoundedCornerImage(){
    Image(painter = painterResource(id = R.drawable.ic_moon),
        contentDescription = "Circle Image", contentScale = ContentScale.Crop,
        modifier = Modifier.size(300.dp)
            .clip(RoundedCornerShape(15))
            .border(1.dp, Color.Transparent, RoundedCornerShape(15))
            .padding(8.dp))
}