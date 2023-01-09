package uk.ac.tees.aad.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.ac.tees.aad.myapplication.ui.theme.MyApplicationTheme

class LazyColumnAndRowActivity : ComponentActivity() {
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
fun DefaultPreview7() {
    MyApplicationTheme {
        //ListListScopeSample()
        //CityListView()
        PrepareList()
    }
}

@Composable
fun ListListScopeSample(){
    LazyColumn {
        // Add a single item
        item {
            Text(text = "Items in Lazy Column")
        }

        // Add 2 items
        items(2) { index ->
            Text(text = "First items in Lazy Column List: $index")
        }

        // Add 4 items
        items(4) { index ->
            Text(text = "Second Items in Lazy Column List: $index")
        }

        // Add single item
        item {
            Text(text = "Items in Lazy Column")
        }
    }
}

// we take another example Using arraylist, we can create a list of cities

private val cityList =
    mutableListOf("London", "Mexico", "New York", "Georgetown", "Washington")

private val listModifier = Modifier
    .fillMaxSize()
    .background(Color.LightGray)
    .padding(10.dp)


@Composable
fun CityListView() {
    LazyColumn(modifier = listModifier,) {
        items(cityList) { city ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .wrapContentHeight(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,) {
                Text(text = city, style = MaterialTheme.typography.h5)
            }
        }
    }
}

// we can now include an image in this list. for that we need to create data class
data class CountryModel(val name:String, val image : Int)
private val countryList = mutableListOf<CountryModel>()

@Composable
fun PrepareList(){
    countryList.add(CountryModel("Switzerland", R.drawable.switzerland))
    countryList.add(CountryModel("Germany", R.drawable.germany))
    countryList.add(CountryModel("Canada", R.drawable.canada))
    countryList.add(CountryModel("United States", R.drawable.united_states))
    countryList.add(CountryModel("India", R.drawable.india))
    countryList.add(CountryModel("Australia", R.drawable.australia))
    countryList.add(CountryModel("United Kingdom", R.drawable.united_kingdom))

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(countryList) { model ->
            CountryRowList(model = model)
            Column {
                Divider(thickness = 0.8.dp, color = Color.LightGray)
            }
        }
    }
}

@Composable
fun CountryRowList(model: CountryModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }
}