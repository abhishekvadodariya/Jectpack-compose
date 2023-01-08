package uk.ac.tees.aad.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.ac.tees.aad.myapplication.ui.theme.MyApplicationTheme

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting4("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    MyApplicationTheme {
        TextFieldExample()
        TextFieldWithPlaceholder()
        TextFieldWithIcon()
        OutlineTextFieldWithIcon()
    }
}

@Composable
fun TextFieldExample(){
    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        val text = remember { mutableStateOf(TextFieldValue()) }
        TextField(value = text.value
            , onValueChange = {text.value = it} )
        Text(text.value.text)
    }
}

@Composable
fun TextFieldWithPlaceholder(){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        val text = remember { mutableStateOf(TextFieldValue()) }
        TextField(value = text.value
            , onValueChange = {text.value = it}, label = { Text(text = "Email")},
        placeholder = { Text(text = "Please Enter your Email")})
    }
}

@Composable
fun TextFieldWithIcon(){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        val text = remember { mutableStateOf(TextFieldValue()) }
        TextField(value = text.value,
            onValueChange = {text.value = it},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon") },
            trailingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Person Icon") },
            label = { Text(text = "Email")},
            placeholder = { Text(text = "Please Enter your Email")})
    }
}

@Composable
fun OutlineTextFieldWithIcon(){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        val text = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(value = text.value,
            onValueChange = {text.value = it},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon") },
            trailingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Person Icon") },
            label = { Text(text = "Email")},
            placeholder = { Text(text = "Please Enter your Email")})
    }
}