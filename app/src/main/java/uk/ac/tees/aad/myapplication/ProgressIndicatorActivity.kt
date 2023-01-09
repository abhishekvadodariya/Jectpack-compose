package uk.ac.tees.aad.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.ac.tees.aad.myapplication.ui.theme.MyApplicationTheme

class ProgressIndicatorActivity : ComponentActivity() {
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    MyApplicationTheme {
        Column( modifier = Modifier
            .fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicatorExample()
            Spacer(modifier = Modifier.height(25.dp))
            LinearProgressIndicator()
        }
    }
}

@Composable
fun CircularProgressIndicatorExample() {
    CircularProgressIndicator(
        progress = 0.6f,
        modifier = Modifier
            .size(size = 64.dp)
            .rotate(degrees = 45f),
        color = Color.Blue,
        strokeWidth = 4.dp
    )
}

@Composable
private fun LinearProgressIndicator(){
    Column(modifier = Modifier.fillMaxWidth()) {
        LinearProgressIndicator(progress =0.6f,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            backgroundColor = Color.LightGray,
            color = Color.Blue //progress color
        )
    }
}