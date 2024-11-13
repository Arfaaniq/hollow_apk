package com.example.infinitelearning_arfa.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.infinitelearning_arfa.R
import com.example.infinitelearning_arfa.Routes
import com.example.infinitelearning_arfa.items.Item
import com.example.infinitelearning_arfa.items.itemList

val Poppins = FontFamily(
    Font(R.font.bold, FontWeight.Bold)
)

@Composable
fun MainScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    // Add state for search query
    var searchQuery by remember { mutableStateOf("") }

    // Add state for filtered items
    val filteredItems by remember(searchQuery) {
        derivedStateOf {
            if (searchQuery.isBlank()) {
                itemList
            } else {
                itemList.filter {
                    it.name.contains(searchQuery, ignoreCase = true)
                }
            }
        }
    }

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                placeholder = { Text("Search character name...") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                singleLine = true
            )
        }

        // Popular Now section
        item {
            Column {
                Text(
                    text = "Popular now",
                    fontFamily = Poppins,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 28.dp, top = 16.dp)
                )
                LazyRow(
                    contentPadding = PaddingValues(16.dp)
                ) {
                    itemsIndexed(filteredItems) { index, item ->
                        ItemCard(
                            navController = navController,
                            painterId = item.imageId,
                            title = item.name,
                            index = index,
                            infodetail = item.infodetail
                        )
                    }
                }
            }
        }

        // Hot News section header
        item {
            Text(
                text = "Hot News - Lord Baron",
                fontFamily = Poppins,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp, top = 24.dp)
            )
        }

        // Items in vertical list
        itemsIndexed(filteredItems) { index, item ->
            ItemCard(
                navController = navController,
                painterId = item.imageId,
                title = item.name,
                index = index,
                infodetail = item.infodetail,
                isHorizontal = false
            )
        }
    }
}
@Composable
fun ItemCard(
    navController: NavController,
    painterId: Int,
    title: String,
    index: Int,
    infodetail: String,
    isHorizontal: Boolean = true
) {
    val cardModifier = if (isHorizontal) {
        Modifier
            .padding(start = 12.dp)
            .width(200.dp)
    } else {
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    }

    // Cari index asli dari item berdasarkan nama
    val originalIndex = itemList.indexOfFirst { it.name == title }

    Column(
        modifier = cardModifier
    ) {
        Card(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .clickable {
                    navController.navigate(Routes.createDetailRoute(originalIndex))
                },
        ) {
            Image(
                painter = painterResource(id = painterId),
                contentDescription = title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(bottom = 8.dp)
                .clickable {
                    navController.navigate(Routes.createDetailRoute(originalIndex))
                },
            shape = RectangleShape,
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Poppins,
                    modifier = Modifier.padding(bottom = 4.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = infodetail,
                    fontSize = 16.sp,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}