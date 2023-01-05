package uk.ac.tees.aad.myapplication.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.ac.tees.aad.myapplication.ui.theme.ui.theme.MyApplicationTheme

class TextElement : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {

                }
            }
        }
    }
}

@Composable
fun SizeModifier(label: String, size: TextUnit) {
    Text(label, fontSize = size )
}
@Composable
fun ColorText() {
    Text("Color Text", color = Color.Blue)
}
@Composable
fun BoldText() {
    Text("Bold text", fontWeight = FontWeight.Bold)
}

@Composable
fun ItalicText() {
    Text("Italic Text", fontStyle = FontStyle.Italic)
}
@Composable
fun MaxLines() {
    Text("JetPack Compose ".repeat(10), maxLines = 2)
}
@Composable
fun OverflowedText() {
    Text("Overflow text  ".repeat(10), maxLines = 1, overflow = TextOverflow.Ellipsis)
}
@Composable
fun SelectableText() {
    SelectionContainer {
        Text("This text is selectable")
    }
}
@Composable
fun Space(){
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun TextContainer() {
    Column {
        SizeModifier("Big text", 40.sp)
        Space()
        ColorText()
        Space()
        BoldText()
        Space()
        ItalicText()
        Space()
        OverflowedText()
        Space()
        SelectableText()
        Space()
        MaxLines()
    }
}

//val  redTextStyle = TextStyle(color = Color.Red,fontSize = 30.sp)
@Preview( showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Row {
        TextContainer()
    }
    }
