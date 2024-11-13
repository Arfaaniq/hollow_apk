package com.example.infinitelearning_arfa.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.aboutsebelum),
                contentDescription = "about",
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = "ABOUT US",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Text(
            text = "Welcome to Anime Biodata and Personality!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "We are passionate about bringing you curated lists of the most handsome anime characters from across different series. Our team of dedicated anime enthusiasts carefully selects and ranks characters based on design, personality, and overall appeal.",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Our Mission",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "To provide anime fans with engaging content and showcase the exceptional character designs in the anime industry. We regularly update our rankings to include new and memorable characters that capture the hearts of viewers worldwide.",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Why Top 10 Rankings?",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Our top 10 lists are carefully curated to highlight characters who exemplify outstanding design, memorable personalities, and significant impact on their respective series. Each ranking comes with detailed explanations and character insights.",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "© 2024 Anime Handsome Rankings. All rights reserved.\nAll character images and names are property of their respective owners.",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}