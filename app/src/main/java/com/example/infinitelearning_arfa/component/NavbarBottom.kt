package com.example.infinitelearning_arfa.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.infinitelearning_arfa.R
import com.example.infinitelearning_arfa.Routes

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val Poppins = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )
    NavigationBar(
        containerColor = Color(0xFFFCD0A1),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        val items = listOf(
            NavigationItem("Home", R.drawable.homesebelum, R.drawable.homesetelah, Routes.ListActivity),
            NavigationItem("Manage", R.drawable.docsebelum, R.drawable.docsesudah, Routes.ManageActivity),
            NavigationItem("About", R.drawable.aboutsebelum, R.drawable.aboutsetelah, Routes.AboutActivity)
        )

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (currentRoute == item.route) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            }
                        ),
                        contentDescription = item.title,
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontFamily = Poppins,
                        color = Color.Black,
                        fontWeight = if (currentRoute == item.route) {
                            FontWeight.Bold
                        } else {
                            FontWeight.Normal
                        },
                        fontSize = 16.sp
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFFFCD0A1)
                )
            )
        }
    }
}

data class NavigationItem(
    val title: String,
    val unselectedIcon: Int,
    val selectedIcon: Int,
    val route: String
)
