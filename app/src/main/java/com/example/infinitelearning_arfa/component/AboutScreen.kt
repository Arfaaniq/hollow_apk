package com.example.infinitelearning_arfa.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AboutSreen(navController: NavController){
    Column(
        modifier = Modifier.padding(40.dp)
    ) {
        Text("TNTANG KAMI")
    }
}