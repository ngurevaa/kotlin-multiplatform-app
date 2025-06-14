package ru.kpfu.itis.kmp

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.currentBackStackEntryAsState
import org.koin.compose.koinInject
import ru.kpfu.itis.kmp.core.designsystem.component.BottomBar
import ru.kpfu.itis.kmp.core.designsystem.theme.AppTheme
import ru.kpfu.itis.kmp.core.navigation.NavigationHost
import ru.kpfu.itis.kmp.core.navigation.Route
import ru.kpfu.itis.kmp.core.navigation.rememberNavController
import ru.kpfu.itis.kmp.core.firebase.AuthService
import androidx.compose.runtime.getValue

@Composable
fun App() {
    AppTheme {
        val authService: AuthService = koinInject<AuthService>()

        var startDestination = if (authService.isUserLoggedIn()) Route.Home else Route.Registration
        val navController = rememberNavController(startDestination)

        val currentRoute by navController.getCurrentRoute()
        Scaffold(
            bottomBar = {
                if (currentRoute in listOf(Route.Home)) BottomBar(navController)
            }
        ) { innerPadding ->
            NavigationHost(startDestination = startDestination, navController = navController)
        }
    }
}
