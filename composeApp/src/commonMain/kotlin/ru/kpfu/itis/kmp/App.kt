package ru.kpfu.itis.kmp

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import ru.kpfu.itis.kmp.core.designsystem.component.BottomBar
import ru.kpfu.itis.kmp.core.designsystem.theme.AppTheme
import ru.kpfu.itis.kmp.core.navigation.NavigationHost
import ru.kpfu.itis.kmp.core.navigation.Route
import ru.kpfu.itis.kmp.core.navigation.rememberNavController

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
