package uk.ac.tees.aad.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.ac.tees.aad.myapplication.ui.theme.MyApplicationTheme
import uk.ac.tees.aad.myapplication.ui.theme.Shapes

class ModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
        CircularImage()
}

@Composable
fun CircularImage() {
    //use modifier for padding
    Row(modifier = Modifier.padding(all = 4.dp)) {
        Image(
            painter = painterResource(id = R.drawable.jetpack_compose_icon),
            contentDescription = "profile picture",
            modifier = Modifier
                //set image size in dp
                .size(35.dp)
                // set shaped as a circle using clip
                .clip(CircleShape)
                .border(1.dp, color = Color.Black, shape = CircleShape)
                .padding(2.dp)
                .clip(CircleShape)
        )
        //Add space horizontal between image and column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = "Colleague", fontSize = 10.sp)
            // add vertical space between the author ans body
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Hey, check out Jetpack Compose; it's awesome!", fontSize = 8.sp)
        }
    }
}
