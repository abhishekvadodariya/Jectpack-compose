package uk.ac.tees.aad.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.launch
import uk.ac.tees.aad.myapplication.ui.theme.MyApplicationTheme

class ScaffoldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultPreview8()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
    MyApplicationTheme {
        ScaffoldSample()
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldSample() {
    val selectedIndex = remember { mutableStateOf(0) }
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = {Text("Scaffold Example")},
            navigationIcon ={ IconButton(onClick = {}) {
                Icon(Icons.Filled.Menu, "MenuIcon")
            }},
            backgroundColor = MaterialTheme.colors.primary)  },

        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {}){
            Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
        } },

        drawerContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // text
                Text(text = "Your UI Here")

                // gap between text and button
                Spacer(modifier = Modifier.height(height = 32.dp))

                // button
                Button(onClick = {
                    // close the drawer
                    val coroutineScope = CoroutineScope(coroutineContext)
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                }) {
                    Text(text = "Close Drawer")
                }
            }
                        },

        content = { Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Content of the page",
                fontSize = 30.sp,
                color = Color.Black) }},

        bottomBar = { BottomNavigation(elevation = 10.dp) {
            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Home,"")
            },
                label = { Text(text = "Home") },
                selected = (selectedIndex.value == 0),
                onClick = {
                    selectedIndex.value = 0
                })

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Person,"")
            },
                label = { Text(text = "Profile") },
                selected = (selectedIndex.value == 1),
                onClick = {
                    selectedIndex.value = 1
                })

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.ShoppingCart,"")
            },
                label = { Text(text = "Cart") },
                selected = (selectedIndex.value == 2),
                onClick = {
                    selectedIndex.value = 2
                })

            BottomNavigationItem(icon = {
                Icon(imageVector = Icons.Default.Settings,"")
            },
                label = { Text(text = "Settings") },
                selected = (selectedIndex.value == 3),
                onClick = {
                    selectedIndex.value = 3
                })

        } }
    )
}