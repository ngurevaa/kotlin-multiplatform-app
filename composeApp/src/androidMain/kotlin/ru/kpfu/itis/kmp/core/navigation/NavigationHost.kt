package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.kpfu.itis.kmp.feature.auth.LoginScreen
import ru.kpfu.itis.kmp.feature.auth.RegistrationScreen

@Composable
actual fun NavigationHost(
    startDestination: Route
) {
    val navController: NavHostController = rememberNavController()
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        composable<Route.Registration> {
            RegistrationScreen(
                navigateToLogin = { navController.navigate(Route.Login) }
            )
        }
        composable<Route.Login> {
            LoginScreen(
                navigateToRegistration = { navController.navigate(Route.Registration) }
            )
        }
    }
}
