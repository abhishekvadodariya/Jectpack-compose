package uk.ac.tees.aad.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                MessageCard(Message("Android", "Jetpack Compose"))
            }
        }
    }

    data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    //Add padding to row
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.jetpack_compose_icon),
            contentDescription = "profile picture",
            modifier = Modifier
                //set image size in dp
                .size(40.dp)
                // set shaped as a circle using clip
                .clip(CircleShape))
            //Add space horizontal between image and column
            Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author)
            // add vertical space between the author ans body
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = msg.body)
        }
    }
}

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(
            msg = Message("Colleague", "Hey, check out Jetpack Compose; it's awesome!")
        )
    }

@Composable
fun TextSize(label : String, size : TextUnit) {
    Text(label, fontSize = size)
}

