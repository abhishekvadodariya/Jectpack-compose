package uk.ac.tees.aad.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.ac.tees.aad.myapplication.ui.theme.MyApplicationTheme

class WidthAndHeightActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    WidthAndHeightWithModifier()
}

@Composable
private fun WidthAndHeightWithModifier() {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Fixed Size")
        Spacer(modifier = Modifier.height(4.dp))
        BoxWithConstraints(modifier = Modifier
            .size(100.dp)
            .border(3.dp, Color.Green)) {
            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Red))
        }

        Spacer(modifier=Modifier.height(10.dp))
        BoxWithConstraints(modifier = Modifier
            .size(100.dp)
            .border(3.dp, Color.Green)) {
            Box(modifier = Modifier
                .size(150.dp)
                .background(Color.Red))
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "widthIn(min)")
        Spacer(modifier = Modifier.height(4.dp))

        BoxWithConstraints(modifier = Modifier
            .widthIn(min = 100.dp)
            .border(3.dp, Color.Green)) {
            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Red))
        }

        Spacer(modifier=Modifier.height(10.dp))
        BoxWithConstraints(modifier = Modifier
            .widthIn(min = 100.dp)
            .border(3.dp, Color.Green)) {
            Box(modifier = Modifier
                .size(150.dp)
                .background(Color.Red))
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "widthIn(max)")
        Spacer(modifier = Modifier.height(4.dp))
        BoxWithConstraints(modifier = Modifier
            .widthIn(max = 100.dp)
            .border(3.dp, Color.Green)) {
            Box(modifier = Modifier
                .size(50.dp)
                .background(Color.Red))
        }

        Spacer(modifier=Modifier.height(10.dp))
        BoxWithConstraints(modifier = Modifier
            .widthIn(max = 100.dp)
            .border(3.dp, Color.Green)) {
            Box(modifier = Modifier
                .size(150.dp)
                .background(Color.Red))
        }
        Spacer(modifier=Modifier.height(10.dp))
        Row(modifier = Modifier.padding(all = 4.dp)) {
            Text(
                text = "Width and Height",
                color = Color.Black,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color.Transparent)
                    .width(150.dp)
                    .height(150.dp)
                    .border(3.dp,Color.Green)
            )
        }
    }
}
