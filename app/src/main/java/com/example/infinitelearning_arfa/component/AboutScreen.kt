package com.example.infinitelearning_arfa.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.infinitelearning_arfa.R

@Composable
fun AboutSreen(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(24.dp), // Menambahkan sudut melengkung pada Card
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Memberikan efek elevasi
            modifier = Modifier
                .size(190.dp)
                .padding(bottom = 16.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.potokuu),
                contentDescription = "Foto Arfa Aniq Sabila",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = "Arfa Aniq Sabila",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Email: arfaaniq474@gmail.com\nAsal PTN: Politeknik Negeri Batam\nJurusan: Teknik Informatika, Prodi Teknik Informatika",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Selamat datang di profil saya!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Saya adalah mahasiswa dari Politeknik Negeri Batam di jurusan Teknik Informatika, program studi Tekni Informatika. Saya memiliki ketertarikan dalam dunia desain ui/ux maupun grafis",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "© 2024 Arfa Aniq Sabila. All rights reserved.",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}
