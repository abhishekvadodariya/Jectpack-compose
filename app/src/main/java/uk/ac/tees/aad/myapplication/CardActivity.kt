package uk.ac.tees.aad.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.ac.tees.aad.myapplication.ui.theme.MyApplicationTheme

class CardActivity : ComponentActivity() {
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
fun DefaultPreview9() {
    MyApplicationTheme {
        Column( modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            SimpleCard()
            MultipleViewWithCard()
            JetpackCompose()
        }
    }
}

@Composable
fun SimpleCard(){
    Card(elevation = 10.dp, modifier = Modifier
        .padding(10.dp)
        .size(130.dp)) {
        Text(text = "Hey Check New Jetpack Compose In Android", modifier = Modifier.padding(19.dp))
    }
}

@Composable
fun MultipleViewWithCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                buildAnnotatedString {
                    append("Hey this is the ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF04a777))
                    ) {
                        append("Jetpack Compose in Android")
                    }
                }
            )
            Text(
                buildAnnotatedString {
                    append("Now you are in the ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                        append("Card")
                    }
                    append(" section")
                }
            )
        }
    }
}

@Composable
fun JetpackCompose(){
    Card(modifier = Modifier
        .padding(15.dp)
        .size(260.dp,360.dp)
        .clickable { },
        elevation = 15.dp,) {
        Column(Modifier.padding(20.dp),verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(R.drawable.jetpack_compose_icon),
                contentDescription = "",
                Modifier.size(150.dp))
            Text(text = "Jetpack Compose", style = MaterialTheme.typography.h2)
        }
    }
}