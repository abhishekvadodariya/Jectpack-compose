package uk.ac.tees.aad.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.ac.tees.aad.myapplication.ui.theme.MyApplicationTheme

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting3("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    SimpleButton()
    //MultipleText()
    //IconWithButton()
    //ButtonWithShape()
    //OutlineBorderButton()
}

@Composable
fun SimpleButton(){
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Button Example")
    }   
}

@Composable
fun MultipleText(){
        Button(onClick = {/*TODO*/}) {
            Text(text = "Click ", color = Color.Black)
            Text(text = "Here", color = Color.White)
        }
}
@Composable
fun IconWithButton(){
    Button(
        onClick = { /* ... */ },
        // Uses ButtonDefaults.ContentPadding by default
        contentPadding = PaddingValues(
            start = 50.dp,
            top = 2.dp,
            end = 50.dp,
            bottom = 2.dp)) {
        // Inner content including an icon and a text label
        Icon(
            Icons.Filled.Call,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Call")
    }
}

@Composable
fun ButtonWithShape(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {}, shape = RoundedCornerShape(10.dp)) {
            Text(text = "Rounded Corner Shape")
        }

        Button(onClick = {}, shape = CutCornerShape(10)) {
            Text(text = "Cut Corner Shape")
        }

        Button(onClick = {}, shape = RectangleShape) {
            Text(text = "Rectangle Shape")
        }

        Button(onClick = {}, shape = CircleShape) {
            Text(text = "Circle Shape")
        }
    }
}

@Composable
fun OutlineBorderButton(){
    Button(onClick = {}, border = BorderStroke(1.dp, Color.Red), shape = RoundedCornerShape(50),
    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)) {
        Text(text = "Save")
    }
}