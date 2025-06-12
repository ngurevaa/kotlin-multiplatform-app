package ru.kpfu.itis.kmp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import ru.kpfu.itis.kmp.core.designsystem.theme.AppTheme
import ru.kpfu.itis.kmp.core.navigation.NavigationHost
import ru.kpfu.itis.kmp.core.navigation.rememberNavController
import ru.kpfu.itis.kmp.core.designsystem.component.BottomBar
import ru.kpfu.itis.kmp.core.navigation.Route

@Composable
fun App() {
    AppTheme {
        val navController = rememberNavController(Route.Home)

        Scaffold(
            bottomBar = {
                BottomBar(navController)
            }
        ) { innerPadding ->
            NavigationHost(startDestination = Route.Home, navController = navController)
        }
    }
}
