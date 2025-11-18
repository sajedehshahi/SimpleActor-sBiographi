package com.example.fortesting.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue

import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun MainScreen(
    imageId: Array<Int>,
    names: Array<String>,
    ingredients: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column(modifier.fillMaxSize()) {
        val textState = remember { mutableStateOf(TextFieldValue("")) }
        SearchView(state = textState, placeHolder = "Search...", modifier = modifier)

        val searchedText = textState.value.text

        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            val itemCount = imageId.size
            val filteredIndexes = names.indices.filter { index ->
                names[index].contains(searchedText, ignoreCase = true)
            }
            items(filteredIndexes.size) { i ->
                val index = filteredIndexes[i]

                ColumnItem(
                    modifier,
                    painter = imageId,
                    title = names,
                    ingredients = ingredients,
                    itemIndex = index,
                    navController = navController
                )
            }
        }
    }


}

@Composable
fun ColumnItem(
    modifier: Modifier,
    painter: Array<Int>,
    title: Array<String>,
    ingredients: Array<String>,
    itemIndex: Int,
    navController: NavController,
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route = "DetailScreen/$itemIndex")
            },
        colors = CardDefaults.cardColors(
            Color.Gray
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                modifier.size(140.dp), alignment = Alignment.TopStart
            )
            Column(
                modifier.padding(10.dp),


                ) {
                Text(text = title[itemIndex], fontSize = 23.sp, fontWeight = FontWeight.ExtraBold)
                Text(
                    text = ingredients[itemIndex], fontSize = 15.sp, maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

            }
        }
    }
}

@Composable
fun SearchView(
    state: MutableState<TextFieldValue>,
    placeHolder: String,
    modifier: Modifier,
) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            .clip(RoundedCornerShape(30.dp))
            .border(2.dp, Color.Black, RoundedCornerShape(30.dp)),
        placeholder = {
            Text(text = placeHolder)
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
            ),
        maxLines = 1,
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 20.sp
        )

    )
}