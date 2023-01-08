package uk.ac.tees.aad.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
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
        //CircularImage()
    //FillWidthModifier()
    WeightModifier()
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

@Composable
fun FillWidthModifier() {
    Text(
        text = "Match Parent Width",
        color = Color.White,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(Color.DarkGray)
            .padding(Dp(10f))
            //100% Width fill
            .fillMaxWidth(1f))
}

@Composable
fun FillHeightModifier() {
    Text(
        text = " Text with 75% Height ",
        color = Color.White,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(Color.Green)
            //75% Height fill
            .fillMaxHeight(0.75f)
    )
}

@Composable
fun WeightModifier(){
    Row(modifier = Modifier.padding(all = 10.dp)) {
        Column(
            Modifier.weight(1f).background(Color.Green).padding(12.dp)){
            Text(text = "Weight = 1", color = Color.White,fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
        }
        Column(
            Modifier.weight(2f).background(Color.DarkGray).padding(12.dp)){
            Text(text = "Weight = 2", color = Color.White,fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
        }
        Column(
            Modifier.weight(1f).background(Color.Red).padding(12.dp),) {
            Text(text = "Weight = 1",color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
        }

    }
}



