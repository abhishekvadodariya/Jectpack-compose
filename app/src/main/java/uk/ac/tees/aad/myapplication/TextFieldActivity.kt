package uk.ac.tees.aad.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
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
                    DefaultPreview6()
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
        Column( modifier = Modifier
            .fillMaxSize().padding(1.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            TextFieldExample()
            Spacer(modifier = Modifier.height(10.dp))
            TextFieldWithPlaceholder()
            Spacer(modifier = Modifier.height(10.dp))
            TextFieldWithIcon()
            Spacer(modifier = Modifier.height(10.dp))
            OutlineTextFieldWithIcon()
        }
    }
}

@Composable
fun TextFieldExample(){
    Column(
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
    Column(
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
    Column(
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
    Column(
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